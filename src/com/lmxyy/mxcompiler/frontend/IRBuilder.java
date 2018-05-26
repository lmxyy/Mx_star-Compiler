package com.lmxyy.mxcompiler.frontend;

import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.symbol.*;
import com.lmxyy.mxcompiler.utils.CompilerOption;
import com.lmxyy.mxcompiler.utils.WarningInfo;

import java.util.ArrayList;
import java.util.List;

import static com.lmxyy.mxcompiler.symbol.ExprOperator.Operator.*;

public class IRBuilder implements ASTVisitor {
    private IRRoot irRoot;
    private GlobalSymbolTable globalSymbolTable;
    private Function curFunction;
    private BasicBlock curBasicBlock;
    private BasicBlock loopStepBlock = null,loopAfterBlock = null;
    private boolean isFunArg = false,needAddr = false;
    private String className = null;

    public IRBuilder(GlobalSymbolTable _globalSymbolTable,IRRoot _irRoot) {
        globalSymbolTable = _globalSymbolTable;
        irRoot = _irRoot;
    }

    private boolean needMemoryAccess(Node node) {
        if (node instanceof VariableNode) {
            if (((VariableNode) node).getExpr() != null) return true;
            else if (((VariableNode) node).getVar() != null&&((VariableNode) node).getId() != null) return true;
            else return false;
        }
        else if (node instanceof ExpressionNode) {
            if (((ExpressionNode) node).getOp().getOp() == MEM) return true;
            else if (((ExpressionNode) node).getOp().getOp() == ARRAY) return true;
            else if (((ExpressionNode) node).getOp().getOp() == SELF
                    &&needMemoryAccess(((ExpressionNode) node).getExprs().get(0)))
                return true;
            else if (((ExpressionNode) node).getOp().getOp() == TRN&&
                    (needMemoryAccess(((ExpressionNode) node).getExprs().get(1))
                            ||needMemoryAccess(((ExpressionNode) node).getExprs().get(2))))
                return true;
            return false;
        }
        else return false;
    }

    private void assign(boolean needMem,int size,IntValue addr,int offset,ExprNode rhs) {
        if (rhs.basicBlockTrue != null) {
            // Cannot be here.
            BasicBlock merge = new BasicBlock(curFunction,null);
            if (needMem) {
                rhs.basicBlockTrue.append(new StoreInstruction(rhs.basicBlockTrue,addr,offset,size,rhs.intValue));
                rhs.basicBlockFalse.append(new StoreInstruction(rhs.basicBlockFalse,addr,offset,size,rhs.intValue));
            }
            else {
                rhs.basicBlockTrue.append(new MoveInstruction(rhs.basicBlockTrue,rhs.intValue,(Register)addr));
                rhs.basicBlockFalse.append(new MoveInstruction(rhs.basicBlockFalse,rhs.intValue,(Register)addr));
            }
            rhs.basicBlockTrue.end(new JumpInstruction(rhs.basicBlockTrue,merge));
            rhs.basicBlockFalse.end(new JumpInstruction(rhs.basicBlockFalse,merge));
            curBasicBlock = merge;
        }
        else{
            if (needMem)
                curBasicBlock.append(new StoreInstruction(curBasicBlock,addr,offset,size,rhs.intValue));
            else curBasicBlock.append(new MoveInstruction(curBasicBlock,rhs.intValue,(Register)addr));
        }
    }

    private void processArrayAccess(ExprNode node,ExprNode array,ExprNode subscript) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }

        boolean oldNeedAddr = needAddr;

        needAddr = false;
        visit(array);
        visit(subscript);
        needAddr = oldNeedAddr;

        IntValue unitSize = new IntImmediate(node.getType().getRegisterSize());
        VirtualRegister reg = new VirtualRegister(null);

        curBasicBlock.append(
                new ArithmeticInstruction(
                        curBasicBlock,reg,BinaryOperationInstruction.Operator.MUL,
                        subscript.intValue,unitSize
                )
        );
        curBasicBlock.append(
                new ArithmeticInstruction(
                        curBasicBlock,reg,BinaryOperationInstruction.Operator.ADD,
                        array.intValue,reg
                )
        );

        if (needAddr) {
            node.address = reg;
            node.offset = CompilerOption.getSizeInt();
        }
        else {
            curBasicBlock.append(
                    new LoadInstruction(
                            curBasicBlock,reg,node.getType().getRegisterSize(),
                            reg,CompilerOption.getSizeInt()
                    )
            );
            node.intValue = reg;
            if (node.basicBlockTrue != null)
                curBasicBlock.end(new BranchInstruction(curBasicBlock,reg,node.basicBlockTrue,node.basicBlockFalse));
        }
    }

    private StmtNode getForStatement(
            List<List<Node>> inits,ExpressionNode [] conds,List<List<Node>> steps,
            AssignmentNode assignment,int now,int tot
    ) {
        if (now == tot-1) {
            List<Node> stmts = new ArrayList<>();
            stmts.add(assignment);
            return new BlockNode(stmts);
        }
        else {
            List<Node> stmts = new ArrayList<>();
            stmts.add(getForStatement(inits,conds,steps,assignment,now+1,tot));
            return new ForStmtNode(
                    null,inits.get(now),conds[now],
                    steps.get(now),getForStatement(inits,conds,steps,assignment,now+1,tot)
            );
        }
    }
    private ExpressionNode getLhs(
            VirtualRegister[] virtualRegisters,int tot,int now,
            IdentifierNode base,IdentifierNode[] identifierNodes
    ) {
        if (now == -1) {
            List<ExprNode> exprs = new ArrayList<>();exprs.add(base);
            return new ExpressionNode(exprs,null,new ExprOperator(ExprOperator.Operator.SELF),false);
        }
        else {
            ExpressionNode array = getLhs(virtualRegisters,tot,now-1,base,identifierNodes);
            List<ExprNode> exprs = new ArrayList<>(); exprs.add(identifierNodes[now]);
            ExpressionNode subscript = new ExpressionNode(
                    exprs,null,
                    new ExprOperator(ExprOperator.Operator.SELF),false
            );
            exprs = new ArrayList<>(); exprs.add(array); exprs.add(subscript);
            return  new ExpressionNode(
                    exprs,null,
                    new ExprOperator(ExprOperator.Operator.ARRAY),false
            );
        }
    }
    private void processNewArray(IntValue addr,VartypePlusNode node) {
        int n = node.getDims().size();
        VirtualRegister [] virtualRegisters = new VirtualRegister[n-1];
        IdentifierNode [] identifierNodes = new IdentifierNode[n-1];
        VariableNode [] variableNodes = new VariableNode[n-1];

        List<List<Node>> inits = new ArrayList<List<Node>>();
        ExpressionNode [] conds = new ExpressionNode[n-1];
        List<List<Node>> steps = new ArrayList<List<Node>>();
        for (int i = 0;i < n-1;++i) {
            virtualRegisters[i] = new VirtualRegister(null);
            identifierNodes[i] = new IdentifierNode(null);
            identifierNodes[i].intValue =virtualRegisters[i];
            variableNodes[i] = new VariableNode(null,identifierNodes[i],null,false);

            ExpressionNode lhs = null,rhs = null;
            List<ExprNode> lhsList = null,rhsList = null;

            lhsList = new ArrayList<>(); rhsList = new ArrayList<>();
            lhsList.add(variableNodes[i]); rhsList.add(new IntegerliteralNode(0));
            lhs = new ExpressionNode(lhsList,null,new ExprOperator(SELF),false);
            rhs = new ExpressionNode(rhsList,null,new ExprOperator(SELF),false);
            inits.add(new ArrayList<>());
            inits.get(i).add(new AssignmentNode(lhs,rhs));

            lhsList = new ArrayList<>();
            lhsList.add(variableNodes[i]); lhsList.add(node.getDims().get(i));
            conds[i] = new ExpressionNode(lhsList,null,new ExprOperator(LESS),false);

            lhsList = new ArrayList<>();
            lhsList.add(variableNodes[i]);
            steps.add(new ArrayList<>());
            steps.get(i).add(new ExpressionNode(lhsList,null,new ExprOperator(PINC),false));
        }

        IdentifierNode base = new IdentifierNode(null);
        base.intValue = addr;
        for (int i = 1;i < n;++i) {
            ExpressionNode lhs = getLhs(virtualRegisters,i,i-1,base,identifierNodes);
            List<ExprNode> exprs = new ArrayList<>(); exprs.add(identifierNodes[i]);
            ExpressionNode dim = new ExpressionNode(exprs,null,new ExprOperator(SELF),false);
            List<ExpressionNode> dims = new ArrayList<>(); dims.add(dim);
            ExpressionNode rhs = new ExpressionNode(
                    null,new VartypePlusNode(
                            new Type(
                                    node.getType().getType(),node.getType().getDimension()-i),
                                    node.getName(),dims
                            ),
                    new ExprOperator(NEW),false
            );
            AssignmentNode assignment = new AssignmentNode(lhs,rhs);
            visit(getForStatement(inits,conds,steps,assignment,0,i));
        }
    }

    private void processNewExpr(ExpressionNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }

        VartypeNode type = node.getType();
        VirtualRegister reg = new VirtualRegister(null);

        if (type.isClass()) {
            curBasicBlock.append(new HeapAllocateInstruction(
                    curBasicBlock,reg,
                    new IntImmediate(globalSymbolTable.getMemorySize(type.getName()))
                    )
            );
            Function constructor = irRoot.functions.get(node.getVartype().getName());
            node.getExprs().forEach(param -> param.accept(this));
            CallInstruction callFun = new CallInstruction(curBasicBlock, reg, constructor);
            node.getExprs().forEach(param -> callFun.appendArgReg(param.intValue));
            VirtualRegister oldFunAddr = new VirtualRegister(null);
            curBasicBlock.append(new MoveInstruction(curBasicBlock,constructor.address,oldFunAddr));
            curBasicBlock.append(new MoveInstruction(curBasicBlock,reg,constructor.address));
            curBasicBlock.append(callFun);
            curBasicBlock.append(new MoveInstruction(curBasicBlock,oldFunAddr,constructor.address));
        }
        else {
            visit(node.getVartype());
            if (node.getVartype().getDims().size() > 1) {
                ExpressionNode dim = node.getVartype().getDims().get(0);
                boolean oldNeedAddr = needAddr;
                needAddr = false;
                VartypeNode baseType = new VartypeNode(
                        new Type(
                                node.getVartype().getType().getType(),
                                node.getVartype().getType().getDimension()-1
                        ),
                        node.getVartype().getName()
                );
                needAddr = oldNeedAddr;
                curBasicBlock.append(
                        new ArithmeticInstruction(
                                curBasicBlock,reg,BinaryOperationInstruction.Operator.MUL,dim.intValue,
                                new IntImmediate(baseType.getRegisterSize())
                        )
                );
                curBasicBlock.append(
                        new ArithmeticInstruction(
                                curBasicBlock,reg,BinaryOperationInstruction.Operator.ADD,reg,
                                new IntImmediate(CompilerOption.getSizeInt())
                        )
                );
                curBasicBlock.append(new HeapAllocateInstruction(curBasicBlock,reg,reg));
                curBasicBlock.append(
                        new StoreInstruction(
                                curBasicBlock,reg,0,
                                CompilerOption.getSizeInt(),dim.intValue
                        )
                );
                processNewArray(reg,node.getVartype());
            }
            else {
                ExpressionNode dim = node.getVartype().getDims().get(0);
                boolean oldNeedAddr = needAddr;
                needAddr = false;
                VartypeNode baseType = new VartypeNode(
                        new Type(
                                node.getVartype().getType().getType(),
                                node.getVartype().getType().getDimension()-1
                        ),
                        node.getVartype().getName()
                );
                needAddr = oldNeedAddr;
                curBasicBlock.append(
                        new ArithmeticInstruction(
                                curBasicBlock,reg,BinaryOperationInstruction.Operator.MUL,dim.intValue,
                                new IntImmediate(baseType.getRegisterSize())
                        )
                );
                curBasicBlock.append(
                        new ArithmeticInstruction(
                                curBasicBlock,reg,BinaryOperationInstruction.Operator.ADD,reg,
                                new IntImmediate(CompilerOption.getSizeInt())
                        )
                );
                curBasicBlock.append(new HeapAllocateInstruction(curBasicBlock,reg,reg));
                curBasicBlock.append(
                        new StoreInstruction(
                                curBasicBlock,reg,0,
                                CompilerOption.getSizeInt(),dim.intValue
                        )
                );
            }
        }
        node.intValue = reg;
    }

    private void processSelfIncOrDec(ExpressionNode node) {
        boolean oldNeedAddr = needAddr,isMemOp = needMemoryAccess(node);
        needAddr = isMemOp;
        ExprNode oprand = node.getExprs().get(0);
        visit(oprand);
        if (isMemOp) {
            needAddr = false;
            visit(oprand);
        }
        needAddr = oldNeedAddr;

        BinaryOperationInstruction.Operator op = BinaryOperationInstruction.Operator.ADD;
        if (node.getOp().getOp() == ExprOperator.Operator.SDEC||node.getOp().getOp() == ExprOperator.Operator.PDEC)
            op = BinaryOperationInstruction.Operator.SUB;
        boolean isSuffix = true;
        if (node.getOp().getOp() == ExprOperator.Operator.PINC||node.getOp().getOp() == ExprOperator.Operator.PDEC)
            isSuffix = false;
        IntImmediate one = new IntImmediate(1);
        VirtualRegister reg;

        if (isSuffix) {
            reg = new VirtualRegister(null);
            curBasicBlock.append(new MoveInstruction(curBasicBlock,oprand.intValue,reg));
            node.intValue = reg;
        }
        else node.intValue = oprand.intValue;

        if (isMemOp) {
            IntValue addr = oprand.address;
            int offset = oprand.offset;
            reg = new VirtualRegister(null);
            curBasicBlock.append(new ArithmeticInstruction(curBasicBlock,reg,op,oprand.intValue,one));
            curBasicBlock.append(new StoreInstruction(curBasicBlock,addr,offset,CompilerOption.getSizeInt(),reg));
            if (!isSuffix) node.intValue = reg;
        }
        else {
            curBasicBlock.append(
                    new ArithmeticInstruction(
                            curBasicBlock,(Register) node.intValue,op,oprand.intValue,one
                    )
            );
        }
    }

    private void processStrOperation(ExprOperator.Operator op,ExpressionNode node) {
        visit(node.getExprs().get(0));
        visit(node.getExprs().get(1));
        ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
        if (op == ExprOperator.Operator.GRTR||op == ExprOperator.Operator.GEQ) {
            lhs = node.getExprs().get(1);
            rhs = node.getExprs().get(0);
        }
        VirtualRegister reg = new VirtualRegister(null);
        node.intValue = reg;
        CallInstruction call = null;
        switch (op) {
            case ADD: call = new CallInstruction(curBasicBlock,reg,irRoot.stringConcat); break;
            case EQU: call = new CallInstruction(curBasicBlock,reg,irRoot.stringEqual); break;
            case LESS: case GRTR: call = new CallInstruction(curBasicBlock,reg,irRoot.stringLess); break;
            case LEQ: case GEQ: call = new CallInstruction(curBasicBlock,reg,irRoot.stringLessOrEqual); break;
            default: assert false; break;
        }
        call.appendArgReg(lhs.intValue);
        call.appendArgReg(rhs.intValue);
        curBasicBlock.append(call);

        if (node.basicBlockTrue != null) {
            curBasicBlock.end(new BranchInstruction(curBasicBlock,reg,node.basicBlockTrue,node.basicBlockFalse));
        }
    }

    private void processFuncPrint(ExprNode node,boolean lastNewLine) {
        if (node instanceof ExpressionNode) {
            if (((ExpressionNode)node).getOp().getOp() == SELF) {
                processFuncPrint(((ExpressionNode)node).getExprs().get(0), lastNewLine);
            }
            else if (((ExpressionNode)node).getOp().getOp() == ExprOperator.Operator.ADD) {
                ExprNode lhs = ((ExpressionNode)node).getExprs().get(0);
                ExprNode rhs = ((ExpressionNode)node).getExprs().get(1);
                processFuncPrint(lhs, false);
                processFuncPrint(rhs, lastNewLine);
            }
        }
        else {
            boolean flag = false;
            if (node instanceof CallfunNode) {
                FunctionType functionType = null;
                if (className != null) {
                    functionType = (FunctionType) globalSymbolTable.resolveType(
                            className+"."+ ((CallfunNode) node).getName()
                    );
                }
                if (functionType == null) {
                    functionType = (FunctionType) globalSymbolTable.resolveType(((CallfunNode) node).getName());
                    if (functionType == GlobalSymbolTable.funcToString)
                        flag = true;
                }
            }
            if (flag) {
                ExprNode intExpr = ((CallfunNode) node).getParams().get(0);
                visit(intExpr);
                CallInstruction call = new CallInstruction(
                        curBasicBlock,null,
                        lastNewLine?irRoot.funcPrintlnInt:irRoot.funcPrintInt
                );
                call.appendArgReg(intExpr.intValue);
                curBasicBlock.append(call);
            }
            else {
                visit(node);
                CallInstruction call = new CallInstruction(
                        curBasicBlock,null,
                        lastNewLine?irRoot.funcPrintln:irRoot.funcPrint
                );
                call.appendArgReg(node.intValue);
                curBasicBlock.append(call);
            }
        }
    }

    private void processBuiltinMethod(ExprNode node,FunctionType functionType) {
        boolean oldNeedAddr = needAddr;
        needAddr = false;
        if (node instanceof CallfunNode) {
            if (functionType == GlobalSymbolTable.funcPrint||functionType == GlobalSymbolTable.funcPrintln) {
                processFuncPrint(((CallfunNode) node).getParams().get(0),
                        functionType == GlobalSymbolTable.funcPrintln);
            }
            else if (functionType == GlobalSymbolTable.funcGetString) {
                VirtualRegister reg = new VirtualRegister("gottenstring");
                CallInstruction call = new CallInstruction(curBasicBlock,reg,irRoot.funcGetString);
                curBasicBlock.append(call);
                node.intValue = reg;
            }
            else if (functionType == GlobalSymbolTable.funcGetInt) {
                VirtualRegister reg = new VirtualRegister("gottenint");
                CallInstruction call = new CallInstruction(curBasicBlock,reg,irRoot.funcGetInt);
                curBasicBlock.append(call);
                node.intValue = reg;
            }
            else if (functionType == GlobalSymbolTable.funcToString) {
                visit(((CallfunNode) node).getParams().get(0));
                VirtualRegister reg = new VirtualRegister("tostring");
                CallInstruction call = new CallInstruction(curBasicBlock,reg,irRoot.funcToString);
                call.appendArgReg(((CallfunNode) node).getParams().get(0).intValue);
                curBasicBlock.append(call);
                node.intValue = reg;
            }
            else {
                // Cannot reach here.
                assert false;
            }
        }
        else {
            ExprNode record = ((ExpressionNode) node).getExprs().get(0);
            CallfunNode member = (CallfunNode) ((ExpressionNode) node).getExprs().get(1);
            if (functionType == GlobalSymbolTable.stringLength||functionType == GlobalSymbolTable.arraySize) {
                visit(record);
                VirtualRegister reg = new VirtualRegister("size");
                curBasicBlock.append(
                        new LoadInstruction(
                                curBasicBlock, reg, CompilerOption.getSizeInt(),
                                record.intValue, 0));
                node.intValue = reg;
            }
            else if (functionType == GlobalSymbolTable.stringSubString) {
                visit(record);
                member.getParams().forEach(param->param.accept(this));
                VirtualRegister reg = new VirtualRegister("substr");
                CallInstruction call = new CallInstruction(curBasicBlock,reg, irRoot.stringSubString);
                member.getParams().forEach(param->call.appendArgReg(param.intValue));
                curBasicBlock.append(call);
                node.intValue = reg;
            }
            else if (functionType == GlobalSymbolTable.stringParseInt) {
                visit(record);
                VirtualRegister reg = new VirtualRegister("parsedint");
                curBasicBlock.append(new MoveInstruction(curBasicBlock,record.intValue,irRoot.stringParseInt.address));
                curBasicBlock.append(new CallInstruction(curBasicBlock,reg,irRoot.stringParseInt));
                node.intValue = reg;
            }
            else if (functionType == GlobalSymbolTable.stringOrd) {
                visit(record);
                visit(member.getParams().get(0));
                VirtualRegister reg = new VirtualRegister("ord");
                curBasicBlock.append(
                        new ArithmeticInstruction(
                                curBasicBlock,reg,BinaryOperationInstruction.Operator.ADD,
                                record.intValue,member.getParams().get(0).intValue));
                curBasicBlock.append(
                        new LoadInstruction(
                                curBasicBlock,reg,1,
                                reg,CompilerOption.getSizeInt()
                        )
                );
                node.intValue = reg;
            }

        }
    }

    private void processIntArithmeticExpr(ExprOperator.Operator op,ExpressionNode node) {
        ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
        visit(lhs); visit(rhs);
        BinaryOperationInstruction.Operator operator = null;
        switch (op) {
            case TIMES: operator = BinaryOperationInstruction.Operator.MUL; break;
            case DIVIDE: operator = BinaryOperationInstruction.Operator.DIV; break;
            case MOD: operator = BinaryOperationInstruction.Operator.MOD; break;
            case ADD: operator = BinaryOperationInstruction.Operator.ADD; break;
            case SUB: operator = BinaryOperationInstruction.Operator.SUB; break;
            case LESH: operator = BinaryOperationInstruction.Operator.SHL; break;
            case RISH: operator = BinaryOperationInstruction.Operator.SHR; break;
            case BAND: operator = BinaryOperationInstruction.Operator.AND; break;
            case XOR: operator = BinaryOperationInstruction.Operator.XOR; break;
            case BOR: operator = BinaryOperationInstruction.Operator.OR; break;
            default: assert false; break;
        }
        VirtualRegister reg = new VirtualRegister(null);
        node.intValue = reg;
        curBasicBlock.append(new ArithmeticInstruction(curBasicBlock,reg,operator,lhs.intValue,rhs.intValue));
    }

    private void processIntRelationExpr(ExprOperator.Operator op,ExpressionNode node) {
        ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
        visit(lhs); visit(rhs);
        BinaryOperationInstruction.Operator operator = null;
        switch (op) {
            case EQU: operator = BinaryOperationInstruction.Operator.EQU; break;
            case NEQ: operator = BinaryOperationInstruction.Operator.NEQ; break;
            case LESS: operator = BinaryOperationInstruction.Operator.LESS; break;
            case LEQ: operator = BinaryOperationInstruction.Operator.LEQ; break;
            case GRTR: operator = BinaryOperationInstruction.Operator.GRTR; break;
            case GEQ: operator = BinaryOperationInstruction.Operator.GEQ; break;
            default: assert false; break;
        }
        VirtualRegister reg = new VirtualRegister(null);
        curBasicBlock.append(new ComparisionInstruction(curBasicBlock,reg,operator,lhs.intValue,rhs.intValue));

        if (node.basicBlockTrue != null)
            curBasicBlock.end(new BranchInstruction(curBasicBlock,reg,node.basicBlockTrue,node.basicBlockFalse));
        else node.intValue = reg;
    }

    @Override
    public void visit(DefunNode node) {
        FunctionType functionType = null;
        if (className == null) {
            curFunction = irRoot.functions.get(node.getName());
        }
        else {
            curFunction = irRoot.functions.get(className + "." + node.getName());
        }
        curBasicBlock = curFunction.startBasicBlock;
        isFunArg = true;
        node.getParameterList().forEach(param -> param.accept(this));
        isFunArg = false;

        visit(node.getBody());
        if (!curBasicBlock.isEnded()) {
            if (node.getReturnType().isVoid())
                curBasicBlock.end(new ReturnInstruction(curBasicBlock, null));
            else {
                curBasicBlock.end(new ReturnInstruction(curBasicBlock, new IntImmediate(0)));
                WarningInfo.add(node.location(), "The function doesn't have a return value.");
            }
        }

        // merge all return blocks to one block
        if (curFunction.retInstruction.size() > 1) {
            BasicBlock exitBasicBlock = new BasicBlock(curFunction, curFunction.getName() + ".exit");
            Register newRetVal = null;
            if (!node.getReturnType().isVoid())
                newRetVal = new VirtualRegister("returnValue");
            for (ReturnInstruction ret : curFunction.retInstruction) {
                BasicBlock basicBlock = ret.getBasicBlock();
                ret.remove();
                if (ret.getRetVal() != null)
                    basicBlock.append(new MoveInstruction(basicBlock, ret.getRetVal(), newRetVal));
                basicBlock.end(new JumpInstruction(basicBlock, exitBasicBlock));
            }
            curFunction.retInstruction.clear();
        } else curFunction.exitBasicBlock = curFunction.retInstruction.get(0).getBasicBlock();
        // remove unreachable block: to be completed
        // Write something here.
    }

    @Override
    public void visit(DefvarNode node) {
        SymbolInfo info = node.scope.getInfo(node.getName());
        if (node.scope != globalSymbolTable.globals&&curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }
        if (node.getInit() != null) {
            visit(node.getInit());
            assign(
                    false, node.getInit().getVartype().getRegisterSize(),
                    info.register, 0, node.getInit()
            );
        }
    }

    @Override
    public void visit(DefclassNode node) {
        className = node.getName();
        node.getFunMembers().forEach(fun->fun.accept(this));
        if (node.getConstructor() != null) {
            DefunNode constructor = node.getConstructor();
            curFunction = irRoot.functions.get(node.getName());
            curBasicBlock = curFunction.startBasicBlock;

            isFunArg = true;
            constructor.getParameterList().forEach(param -> param.accept(this));
            isFunArg = false;

            for (DefvarNode defvar:node.getVarMembers()) {
                if (defvar.getInit() != null) {
                    visit(defvar.getInit());
                    assign(
                            true,defvar.getInit().getVartype().getRegisterSize(), curFunction.address,
                            globalSymbolTable.getOffset(className+"."+defvar.getName()), defvar.getInit()
                    );
                }
            }

            visit(constructor.getBody());
            if (!curBasicBlock.isEnded()) {
                curBasicBlock.end(new ReturnInstruction(curBasicBlock, null));
            }

            // merge all return blocks to one block
            if (curFunction.retInstruction.size() > 1) {
                BasicBlock exitBasicBlock = new BasicBlock(curFunction, curFunction.getName() + ".exit");
                for (ReturnInstruction ret : curFunction.retInstruction) {
                    BasicBlock basicBlock = ret.getBasicBlock();
                    ret.remove();
                    basicBlock.end(new JumpInstruction(basicBlock, exitBasicBlock));
                }
                curFunction.retInstruction.clear();
            }
            else curFunction.exitBasicBlock = curFunction.retInstruction.get(0).getBasicBlock();
        }
        className = null;
    }

    @Override
    public void visit(DefvarlistNode node) {
        if (node.scope != globalSymbolTable.globals) {
            if (curBasicBlock.isEnded()) {
                WarningInfo.uselessStatement(node.location());
                return;
            }
        }
        node.getVars().forEach(var->var.accept(this));
    }

    @Override
    public void visit(VartypeNode node) {
        // Do nothing here. Cannot reach here.
        assert false;
    }

    @Override
    public void visit(VartypePlusNode node) {
        node.getDims().forEach(dim->visit(dim));
    }

    @Override
    public void visit(IfStmtNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }
        BasicBlock basicBlockTrue = new BasicBlock(curFunction,"if_true"),basicBlockFalse = null;
        BasicBlock basicBlockAfter = new BasicBlock(curFunction,"if_after");
        if (node.isHasElse())
            basicBlockFalse = new BasicBlock(curFunction,"if_false");
        node.getCond().basicBlockTrue = basicBlockTrue;
        if (node.isHasElse()) node.getCond().basicBlockFalse = basicBlockFalse;
        else node.getCond().basicBlockFalse = basicBlockAfter;
        visit(node.getCond());

        curBasicBlock = basicBlockTrue;
        visit(node.getBlock1());
        basicBlockTrue.end(new JumpInstruction(curBasicBlock,basicBlockAfter));

        if (node.isHasElse()) {
            curBasicBlock = basicBlockFalse;
            visit(node.getBlock2());
            basicBlockTrue.end(new JumpInstruction(curBasicBlock,basicBlockAfter));
        }

        curBasicBlock = basicBlockAfter;
    }

    @Override
    public void visit(WhileStmtNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }
        BasicBlock basicBlockCond = new BasicBlock(curFunction,"while_cond");
        BasicBlock basicBlockLoop = new BasicBlock(curFunction,"while_loop");
        BasicBlock basicBlockAfter = new BasicBlock(curFunction,"while_after");

        BasicBlock oldLoopStepBlock = loopStepBlock;
        BasicBlock oldLoopAfterBlock = loopAfterBlock;
        loopStepBlock = basicBlockCond; loopAfterBlock = basicBlockAfter;

        curBasicBlock.end(new JumpInstruction(curBasicBlock,basicBlockCond));
        node.getCond().basicBlockTrue = basicBlockLoop;
        node.getCond().basicBlockFalse = basicBlockAfter;

        curBasicBlock = basicBlockCond;
        visit(node.getCond());

        curBasicBlock = basicBlockLoop;
        visit(node.getBlock());
        basicBlockLoop.end(new JumpInstruction(curBasicBlock,basicBlockCond));

        curBasicBlock = basicBlockAfter;
        loopStepBlock = oldLoopStepBlock; loopAfterBlock = oldLoopAfterBlock;
    }

    @Override
    public void visit(ForStmtNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }
        if (node.getInit1() != null)
            visit(node.getInit1());
        else if (node.getInit2() != null)
            node.getInit2().forEach(x->x.accept(this));

        BasicBlock basicBlockCond = new BasicBlock(curFunction,"for_cond");
        BasicBlock basicBlockLoop = new BasicBlock(curFunction,"for_loop");
        BasicBlock basicBlockStep = new BasicBlock(curFunction,"for_step");
        BasicBlock basicBlockAfter = new BasicBlock(curFunction,"for_after");

        BasicBlock oldLoopStepBlock = loopStepBlock;
        BasicBlock oldLoopAfterBlock = loopAfterBlock;
        loopStepBlock = basicBlockCond; loopAfterBlock = basicBlockAfter;

        curBasicBlock.end(new JumpInstruction(curBasicBlock,basicBlockCond));
        curBasicBlock = basicBlockCond;
        if (node.getCond() != null) {
            visit(node.getCond());
            node.getCond().basicBlockTrue = basicBlockLoop;
            node.getCond().basicBlockFalse = basicBlockAfter;
        }

        curBasicBlock.end(new JumpInstruction(curBasicBlock,basicBlockLoop));
        curBasicBlock = basicBlockLoop;
        visit(node.getBlock());
        if (node.getStep() == null) curBasicBlock.end(new JumpInstruction(curBasicBlock,basicBlockCond));
        else {
            curBasicBlock.end(new JumpInstruction(curBasicBlock,basicBlockStep));
            curBasicBlock = basicBlockStep;
            node.getStep().forEach(step->step.accept(this));
            curBasicBlock.end(new JumpInstruction(curBasicBlock,basicBlockCond));
        }

        curBasicBlock = basicBlockAfter;
        loopStepBlock = oldLoopStepBlock; loopAfterBlock = oldLoopAfterBlock;
    }

    @Override
    public void visit(ContinueStmtNode node) {
        curBasicBlock.end(new JumpInstruction(curBasicBlock,loopStepBlock));
    }

    @Override
    public void visit(BreakStmtNode node) {
        curBasicBlock.end(new JumpInstruction(curBasicBlock,loopAfterBlock));
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.getExpr() == null)
            curBasicBlock.end(new ReturnInstruction(curBasicBlock,null));
        else {
            visit(node.getExpr());
            curBasicBlock.end(new ReturnInstruction(curBasicBlock,node.getExpr().intValue));
        }
    }

    @Override
    public void visit(BlankStmtNode node) {
        // Do nothing here.
    }

    @Override
    public void visit(BlockNode node) {
        node.getStmts().forEach(stmt->stmt.accept(this));
    }

    @Override
    public void visit(IdentifierNode node) {
        if (node.getName().contains("$")) return;
        SymbolInfo info = node.scope.getInfo(node.getName());
        info.used = true;
        if (info.isClassGlobal()) {
            VirtualRegister reg = new VirtualRegister(null);
            node.intValue = reg;
            IntValue address = curFunction.address;
            IntValue offset = new IntImmediate(globalSymbolTable.getOffset(className+"."+node.getName()));
            curBasicBlock.append(new ArithmeticInstruction(
                    curBasicBlock,reg,
                    BinaryOperationInstruction.Operator.ADD,
                    address,offset)
            );
        }
        else node.intValue = info.register;
    }

    @Override
    public void visit(StringliteralNode node) {
        StaticString staticString = irRoot.stringPool.get(node.getVal());
        if (staticString == null) {
            staticString = new StaticString(node.getVal());
            irRoot.stringPool.put(node.getVal(),staticString);
        }
        node.intValue = staticString;
    }

    @Override
    public void visit(IntegerliteralNode node) {
        node.intValue = new IntImmediate(node.getVal());
    }

    @Override
    public void visit(BooleanliteralNode node) {
        node.intValue = new IntImmediate(node.getVal()?1:0);
    }

    @Override
    public void visit(NullNode node) {
        node.intValue = new IntImmediate(0);
    }

    @Override
    public void visit(VariableNode node) {
        if (node.isThis()) {
            node.intValue = curFunction.address;
        }
        else if (node.getVar() == null && node.getId() != null && node.getExpr() == null) {
            visit(node.getId());
            node.intValue = node.getId().intValue;
        }
        else if (node.getVar() != null && node.getId() == null && node.getExpr() == null) {
            visit(node.getId());
            node.intValue = node.getId().intValue;
        }
        else if (node.getVar() != null && node.getId() != null && node.getExpr() == null) { // Member Access
            ExprNode record = node.getVar(),member = node.getId();
            boolean oldNeedAddr = needAddr;
            needAddr = false;
            visit(record);
            needAddr = oldNeedAddr;

            IntValue address = record.intValue;
            int offset = globalSymbolTable.getOffset(
                    node.getType().getName() + "." + ((IdentifierNode) member).getName()
            );
            VartypeNode type = globalSymbolTable.resolveType(
                    node.getType().getName() + "." + ((IdentifierNode) member).getName()
            );
            if (needAddr) {
                node.address = address;
                node.offset = offset;
            } else {
                VirtualRegister reg = new VirtualRegister(null);
                node.intValue = reg;
                curBasicBlock.append(new LoadInstruction(
                        curBasicBlock, reg, type.getRegisterSize(), address, offset));
                if (node.basicBlockTrue != null)
                    curBasicBlock.end(
                            new BranchInstruction(
                                    curBasicBlock, reg, node.basicBlockTrue, node.basicBlockFalse
                            )
                    );
            }
        }
        else if (node.getVar() != null && node.getId() == null && node.getExpr() != null) // Array Access
            processArrayAccess(node,node.getVar(),node.getExpr());
        else assert false;
    }

    @Override
    public void visit(CallfunNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }
        FunctionType functionType = null;
        if (className != null&&globalSymbolTable.resolveType(className+"."+node.getName()) != null) {
            Function function = irRoot.functions.get(className+"."+node.getName());
            node.getParams().forEach(param -> param.accept(this));
            VirtualRegister reg = new VirtualRegister(null);
            CallInstruction callFun = new CallInstruction(curBasicBlock, reg, function);
            node.getParams().forEach(param -> callFun.appendArgReg(param.intValue));
            curBasicBlock.append(new MoveInstruction(curBasicBlock,curFunction.address,function.address));
            curBasicBlock.append(callFun);
            node.intValue = reg;
        }
        else {
            functionType = (FunctionType) globalSymbolTable.resolveType(node.getName());
            if (globalSymbolTable.isBuiltinMethod(functionType)) {
                processBuiltinMethod(node,functionType);
            }
            else {
                Function function = irRoot.functions.get(node.getName());
                node.getParams().forEach(param -> param.accept(this));
                VirtualRegister reg = new VirtualRegister(null);
                CallInstruction callFun = new CallInstruction(curBasicBlock, reg, function);
                node.getParams().forEach(param -> callFun.appendArgReg(param.intValue));
                curBasicBlock.append(callFun);
                node.intValue = reg;
            }
        }
    }

    @Override
    public void visit(AssignmentNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }

        ExpressionNode lhs = node.getVariable(),rhs = node.getExpr();
        visit(rhs);

        boolean oldNeedAddr = needAddr,isMemOp = needMemoryAccess(lhs);
        needAddr = isMemOp;
        visit(lhs);
        needAddr = oldNeedAddr;

        IntValue addr = isMemOp?lhs.address:lhs.intValue;
        int offset = isMemOp?lhs.offset:0;
        assign(isMemOp,rhs.getVartype().getRegisterSize(),addr,offset,rhs);
    }

    @Override
    public void visit(ExpressionNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }
        ExprOperator.Operator op = node.getOp().getOp();
        if (op == ExprOperator.Operator.SELF) {
            node.getExprs().get(0).basicBlockFalse = node.basicBlockFalse;
            node.getExprs().get(0).basicBlockTrue = node.basicBlockTrue;
            visit(node.getExprs().get(0));
            node.intValue = node.getExprs().get(0).intValue;
        }
        else if (op == ExprOperator.Operator.MEM) {
            ExprNode record = node.getExprs().get(0),member = node.getExprs().get(1);
            boolean oldNeedAddr = needAddr;
            needAddr = false;
            visit(record);
            needAddr = oldNeedAddr;

            if (member instanceof IdentifierNode) {
                IntValue address = record.intValue;
                int offset = globalSymbolTable.getOffset(
                        node.getVartype().getName() + "." + ((IdentifierNode) member).getName()
                );
                VartypeNode type = globalSymbolTable.resolveType(
                        node.getVartype().getName() + "." + ((IdentifierNode) member).getName()
                );
                if (needAddr) {
                    node.address = address;
                    node.offset = offset;
                } else {
                    VirtualRegister reg = new VirtualRegister(null);
                    node.intValue = reg;
                    curBasicBlock.append(new LoadInstruction(
                            curBasicBlock, reg, type.getRegisterSize(), address, offset));
                    if (node.basicBlockTrue != null)
                        curBasicBlock.end(
                                new BranchInstruction(
                                        curBasicBlock, reg, node.basicBlockTrue, node.basicBlockFalse
                                )
                        );
                }
            }
            else { //调用类内部的函数
                if (record.getType().getType().getDimension() > 0) {
                    processBuiltinMethod(node,GlobalSymbolTable.arraySize);
                }
                else if (record.getType().isString()) {
                    FunctionType functionType = (FunctionType) globalSymbolTable.resolveType(
                            "string." + ((CallfunNode) member).getName()
                    );
                    processBuiltinMethod(node,functionType);
                }
                else {
                    FunctionType functionType = (FunctionType) globalSymbolTable.resolveType(
                            node.getVartype().getName() + "." + ((CallfunNode) member).getName()
                    );
                    Function function = irRoot.functions.get(functionType.getName());
                    if (globalSymbolTable.isBuiltinMethod(functionType))
                        ((CallfunNode) member).getParams().forEach(param -> param.accept(this));
                    VirtualRegister reg = new VirtualRegister(null);
                    CallInstruction callFun = new CallInstruction(curBasicBlock, reg, function);
                    ((CallfunNode) member).getParams().forEach(param -> callFun.appendArgReg(param.intValue));
                    VirtualRegister oldFunAddr = new VirtualRegister(null);
                    curBasicBlock.append(new MoveInstruction(curBasicBlock,function.address,oldFunAddr));
                    curBasicBlock.append(new MoveInstruction(curBasicBlock,record.intValue,function.address));
                    curBasicBlock.append(callFun);
                    curBasicBlock.append(new MoveInstruction(curBasicBlock,oldFunAddr,function.address));

                    node.intValue = reg;
                }
            }
        }
        else if (op == ExprOperator.Operator.ARRAY)
            processArrayAccess(node,node.getExprs().get(0),node.getExprs().get(1));
        else if (op == ExprOperator.Operator.SINC||op == ExprOperator.Operator.SDEC
                ||op == ExprOperator.Operator.PINC ||op == ExprOperator.Operator.PDEC)
            processSelfIncOrDec(node);
        else if (op == ExprOperator.Operator.NEG||op == ExprOperator.Operator.COMP) {
            VirtualRegister reg = new VirtualRegister(null);
            UnaryOperationInstruction.Operator operator = UnaryOperationInstruction.Operator.NEG;
            if (op == ExprOperator.Operator.COMP)
                operator = UnaryOperationInstruction.Operator.COMP;
            curBasicBlock.append(
                    new UnaryOperationInstruction(
                            curBasicBlock,reg,operator,node.getExprs().get(0).intValue
                    )
            );
            node.intValue = reg;
        }
        else if (op == ExprOperator.Operator.NOT) {
            visit(node.getExprs().get(0));
            node.basicBlockFalse = node.getExprs().get(0).basicBlockTrue;
            node.basicBlockFalse = node.getExprs().get(0).basicBlockFalse;
        }
        else if (op == ExprOperator.Operator.NEW)
            processNewExpr(node);
        if (op == ExprOperator.Operator.EQU||op == ExprOperator.Operator.NEQ
                ||op == LESS||op == ExprOperator.Operator.LEQ
                ||op == ExprOperator.Operator.GRTR||op == ExprOperator.Operator.GEQ) {
            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            if (lhs.getType().isString())
                processStrOperation(op,node);
            else processIntRelationExpr(op,node);
        }
        else if (op == ExprOperator.Operator.TIMES||op == ExprOperator.Operator.DIVIDE||op == ExprOperator.Operator.MOD
                ||op == ExprOperator.Operator.ADD||op == ExprOperator.Operator.SUB
                ||op == ExprOperator.Operator.LESH||op == ExprOperator.Operator.RISH
                ||op == ExprOperator.Operator.BAND||op == ExprOperator.Operator.XOR||op == ExprOperator.Operator.BOR) {
            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            if (lhs.getType().isString())
                processStrOperation(op,node);
            else processIntArithmeticExpr(op,node);
        }
        else if (op == ExprOperator.Operator.LAND) {
            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            lhs.basicBlockTrue = new BasicBlock(curFunction,"lhs_true");
            lhs.basicBlockFalse = node.basicBlockFalse;
            visit(lhs);
            curBasicBlock = lhs.basicBlockTrue;

            rhs.basicBlockTrue = node.basicBlockTrue;
            rhs.basicBlockFalse = node.basicBlockFalse;
            visit(rhs);
        }
        else if (op == ExprOperator.Operator.LOR) {
            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            lhs.basicBlockTrue = node.basicBlockTrue;
            lhs.basicBlockFalse = new BasicBlock(curFunction,"lhs_false");
            visit(lhs);
            curBasicBlock = lhs.basicBlockFalse;

            rhs.basicBlockTrue = node.basicBlockTrue;
            rhs.basicBlockFalse = node.basicBlockFalse;
            visit(rhs);
        }
        else if (op == TRN) {
            ExprNode cond = node.getExprs().get(0),lhs = node.getExprs().get(1),rhs = node.getExprs().get(2);
            BasicBlock basicBlockTrue = new BasicBlock(curFunction,"ternary_true");
            BasicBlock basicBlockFalse = new BasicBlock(curFunction,"ternary_false");
            BasicBlock merge = new BasicBlock(curFunction,"ternary_merge");

            cond.basicBlockTrue = basicBlockTrue;
            cond.basicBlockFalse = basicBlockFalse;
            visit(cond);

            boolean oldNeedAddr = needAddr;
            needAddr = false;
            VirtualRegister reg = new VirtualRegister(null);

            curBasicBlock = basicBlockTrue;
            visit(lhs);basicBlockTrue.append(new MoveInstruction(basicBlockTrue,lhs.intValue,reg));
            basicBlockTrue.end(new JumpInstruction(basicBlockTrue,merge));

            curBasicBlock = basicBlockFalse;
            visit(rhs);
            basicBlockFalse.append(new MoveInstruction(basicBlockFalse,rhs.intValue,reg));
            basicBlockFalse.end(new JumpInstruction(basicBlockFalse,merge));

            needAddr = oldNeedAddr;

            node.intValue = reg;
            curBasicBlock = merge;
            if (node.basicBlockTrue != null)
                curBasicBlock.end(new BranchInstruction(curBasicBlock,reg,node.basicBlockTrue,node.basicBlockFalse));
        }
    }

    @Override
    public void visit(ProgNode node) {
        node.getDefs().forEach(def -> def.accept(this));
        // To be completed here.
    }

    public void visit(Node node) {
        node.accept(this);
    }
    public void visit(StmtNode node) {
        node.accept(this);
    }
    public void visit(ExprNode node) {
        node.accept(this);
    }
}
