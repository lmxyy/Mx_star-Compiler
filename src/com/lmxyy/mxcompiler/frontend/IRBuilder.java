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
    private BasicBlock loopStepBlock = null, loopAfterBlock = null;
    private boolean isFunArg = false, needAddr = false;
    private String className = null;

    public IRBuilder(GlobalSymbolTable _globalSymbolTable, IRRoot _irRoot) {
        globalSymbolTable = _globalSymbolTable;
        irRoot = _irRoot;
    }

    private boolean needMemoryAccess(Node node) {
        if (node instanceof IdentifierNode) {
            if (((IdentifierNode) node).getName() == null)
                return false;
            SymbolInfo info = node.scope.getInfo(((IdentifierNode) node).getName());
            if (info.isClassGlobal()) {
                return true;
            }
            else return false;
        }
        if (node instanceof VariableNode) {
            if (((VariableNode) node).getExpr() != null)
                return true;
            else if (((VariableNode) node).getVar() != null && ((VariableNode) node).getId() != null)
                return true;
            else if (((VariableNode) node).getVar() == null && ((VariableNode) node).getId() != null)
                return needMemoryAccess(((VariableNode) node).getId());
            else return false;
        } else if (node instanceof ExpressionNode) {
            if (((ExpressionNode) node).getOp().getOp() == MEM) return true;
            else if (((ExpressionNode) node).getOp().getOp() == ARRAY) return true;
            else if (((ExpressionNode) node).getOp().getOp() == SELF)
                return needMemoryAccess(((ExpressionNode) node).getExprs().get(0));
            return false;
        } else return false;
    }

    private void assign(boolean needMem, int size, IntValue addr, int offset, ExprNode rhs) {
        if (rhs.basicBlockTrue != null) {
            BasicBlock merge = new BasicBlock(curFunction, null);
            if (needMem) {
                rhs.basicBlockTrue.append(new StoreInstruction(rhs.basicBlockTrue, addr, offset, size, rhs.intValue));
                rhs.basicBlockFalse.append(new StoreInstruction(rhs.basicBlockFalse, addr, offset, size, rhs.intValue));
            } else {
                rhs.basicBlockTrue.append(new MoveInstruction(rhs.basicBlockTrue, rhs.intValue, (Register) addr));
                rhs.basicBlockFalse.append(new MoveInstruction(rhs.basicBlockFalse, rhs.intValue, (Register) addr));
            }
            rhs.basicBlockTrue.end(new JumpInstruction(rhs.basicBlockTrue, merge));
            rhs.basicBlockFalse.end(new JumpInstruction(rhs.basicBlockFalse, merge));
            curBasicBlock = merge;
        } else {
            if (needMem)
                curBasicBlock.append(new StoreInstruction(curBasicBlock, addr, offset, size, rhs.intValue));
            else curBasicBlock.append(new MoveInstruction(curBasicBlock, rhs.intValue, (Register) addr));
        }
    }

    private void processArrayAccess(ExprNode node, ExprNode array, ExprNode subscript) {
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

        if (subscript.intValue instanceof IntImmediate) {
            int offset = ((IntImmediate) unitSize).getVal()*((IntImmediate) subscript.intValue).getVal();
            curBasicBlock.append(new ArithmeticInstruction(
                            curBasicBlock, reg, BinaryOperationInstruction.Operator.ADD, array.intValue,
                            new IntImmediate(offset)
            ));
        }
        else {
            curBasicBlock.append(
                    new ArithmeticInstruction(
                            curBasicBlock, reg, BinaryOperationInstruction.Operator.MUL,
                            subscript.intValue, unitSize
                    )
            );
            curBasicBlock.append(
                    new ArithmeticInstruction(
                            curBasicBlock, reg, BinaryOperationInstruction.Operator.ADD,
                            array.intValue, reg
                    )
            );
        }

        if (needAddr) {
            node.address = reg;
            node.offset = CompilerOption.getSizeInt();
        } else {
            curBasicBlock.append(
                    new LoadInstruction(
                            curBasicBlock, reg, node.getType().getRegisterSize(),
                            reg, CompilerOption.getSizeInt()
                    )
            );
            node.intValue = reg;
            if (node.basicBlockTrue != null)
                curBasicBlock.end(new BranchInstruction(curBasicBlock, reg, node.basicBlockTrue, node.basicBlockFalse));
        }
    }

    private ForStmtNode getForStatement(
            List<List<Node>> inits, ExpressionNode[] conds, List<List<Node>> steps,
            AssignmentNode assignment, int now, int tot
    ) {
        if (now == tot - 1) {
            List<Node> stmts = new ArrayList<>();
            stmts.add(assignment);
            return new ForStmtNode(
                    null, inits.get(now), conds[now],
                    steps.get(now), new BlockNode(stmts)
            );
        } else {
            List<Node> stmts = new ArrayList<>();
            stmts.add(getForStatement(inits, conds, steps, assignment, now + 1, tot));
            return new ForStmtNode(
                    null, inits.get(now), conds[now],
                    steps.get(now), getForStatement(inits, conds, steps, assignment, now + 1, tot)
            );
        }
    }

    private ExpressionNode getLhs(
            VirtualRegister[] virtualRegisters, int tot, int now,
            IdentifierNode base, IdentifierNode[] identifierNodes, VartypeNode baseType
    ) {
        if (now == -1) {
            List<ExprNode> exprs = new ArrayList<>();
            exprs.add(base);
            return new ExpressionNode(
                    exprs, null, new ExprOperator(ExprOperator.Operator.SELF), false
            ) {{
                setType(baseType);
            }};
        } else {
            ExpressionNode array = getLhs(virtualRegisters, tot, now - 1, base, identifierNodes, baseType);
            List<ExprNode> exprs = new ArrayList<>();
            exprs.add(identifierNodes[now]);
            ExpressionNode subscript = new ExpressionNode(
                    exprs, null,
                    new ExprOperator(ExprOperator.Operator.SELF), false
            ) {{
                setType(GlobalSymbolTable.intType);
            }};
            exprs = new ArrayList<>();
            exprs.add(array);
            exprs.add(subscript);
            return new ExpressionNode(
                    exprs, null,
                    new ExprOperator(ExprOperator.Operator.ARRAY), false
            ) {{
                VartypeNode arrayType = getExprs().get(0).getType();
                setType(arrayType.getRecessionType(1));
            }};
        }
    }

    private void processNewArray(IntValue addr, VartypePlusNode node) {
        int n = node.getDims().size();
        VirtualRegister[] virtualRegisters = new VirtualRegister[n];
        IdentifierNode[] identifierNodes = new IdentifierNode[n];
        VariableNode[] variableNodes = new VariableNode[n];

        List<List<Node>> inits = new ArrayList<List<Node>>();
        ExpressionNode[] conds = new ExpressionNode[n];
        List<List<Node>> steps = new ArrayList<List<Node>>();
        for (int i = 0; i < n; ++i) {
            virtualRegisters[i] = new VirtualRegister("myloopvariable");
            identifierNodes[i] = new IdentifierNode(null);
            identifierNodes[i].intValue = virtualRegisters[i];
            identifierNodes[i].setType(GlobalSymbolTable.intType);
            variableNodes[i] = new VariableNode(null, identifierNodes[i], null, false);
            variableNodes[i].setType(GlobalSymbolTable.intType);

            ExpressionNode lhs = null, rhs = null;
            List<ExprNode> lhsList = null, rhsList = null;

            lhsList = new ArrayList<>();
            rhsList = new ArrayList<>();
            lhsList.add(variableNodes[i]);
            rhsList.add(new IntegerliteralNode(0) {{
                setType(GlobalSymbolTable.intType);
            }});
            lhs = new ExpressionNode(lhsList, null, new ExprOperator(SELF), false);
            lhs.setType(GlobalSymbolTable.intType);
            rhs = new ExpressionNode(rhsList, null, new ExprOperator(SELF), false);
            rhs.setType(GlobalSymbolTable.intType);
            inits.add(new ArrayList<>());
            inits.get(i).add(new AssignmentNode(lhs, rhs));

            lhsList = new ArrayList<>();
            lhsList.add(variableNodes[i]);
            lhsList.add(node.getDims().get(i));
            conds[i] = new ExpressionNode(lhsList, null, new ExprOperator(LESS), false);
            conds[i].setType(GlobalSymbolTable.boolType);

            lhsList = new ArrayList<>();
            lhsList.add(variableNodes[i]);
            steps.add(new ArrayList<>());
            steps.get(i).add(new ExpressionNode(lhsList, null, new ExprOperator(PINC), false) {{
                setType(GlobalSymbolTable.intType);
            }});
        }

        IdentifierNode base = new IdentifierNode(null);
        base.intValue = addr;
        for (int i = 1; i < n; ++i) {
            List<ExpressionNode> dims = new ArrayList<>();
            dims.add(node.getDims().get(i));
            VartypePlusNode vartypePlusNode = new VartypePlusNode(
                    new Type(
                            node.getType().getType(), node.getType().getDimension() - i
                    ),
                    node.getName(), dims
            );
            ExpressionNode lhs = getLhs(virtualRegisters, i, i - 1, base, identifierNodes, node.toVartypeNode());
            lhs.setType(vartypePlusNode.toVartypeNode());
            ExpressionNode rhs = new ExpressionNode(
                    null, vartypePlusNode,
                    new ExprOperator(NEW), false
            );
            rhs.setType(vartypePlusNode.toVartypeNode());
            AssignmentNode assignment = new AssignmentNode(lhs, rhs);
            visit(getForStatement(inits, conds, steps, assignment, 0, i));
        }
    }

    private void processNewExpr(ExpressionNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }

        VartypeNode type = node.getType();
        VirtualRegister reg = new VirtualRegister("newaddress");

        if (type.isClass()) {
            curBasicBlock.append(new HeapAllocateInstruction(
                    curBasicBlock, reg,
                    new IntImmediate(globalSymbolTable.globals.getMemorySize(type.getName()))
                    )
            );
            Function constructor = irRoot.functions.get(node.getVartype().getName());
            node.getExprs().forEach(param -> param.accept(this));
            CallInstruction callFun = new CallInstruction(curBasicBlock, null, constructor);
            callFun.appendArgReg(reg);
            node.getExprs().forEach(param -> callFun.appendArgReg(param.intValue));
            curBasicBlock.append(callFun);
        } else {
            visit(node.getVartype());
            if (node.getVartype().getDims().size() > 1) {
                ExpressionNode dim = node.getVartype().getDims().get(0);
                boolean oldNeedAddr = needAddr;
                needAddr = false;
                VartypeNode baseType = new VartypeNode(
                        new Type(
                                node.getVartype().getType().getType(),
                                node.getVartype().getType().getDimension() - 1
                        ),
                        node.getVartype().getName()
                );
                needAddr = oldNeedAddr;
                if (dim.intValue instanceof IntImmediate) {
                    int size = ((IntImmediate) dim.intValue).getVal()*baseType.getRegisterSize()
                            +CompilerOption.getSizeInt();
                    curBasicBlock.append(new MoveInstruction(curBasicBlock,new IntImmediate(size),reg));
                }
                else {
                    curBasicBlock.append(
                            new ArithmeticInstruction(
                                    curBasicBlock, reg, BinaryOperationInstruction.Operator.MUL, dim.intValue,
                                    new IntImmediate(baseType.getRegisterSize())
                            )
                    );
                    curBasicBlock.append(
                            new ArithmeticInstruction(
                                    curBasicBlock, reg, BinaryOperationInstruction.Operator.ADD, reg,
                                    new IntImmediate(CompilerOption.getSizeInt())
                            )
                    );
                }
                curBasicBlock.append(new HeapAllocateInstruction(curBasicBlock, reg, reg));
                curBasicBlock.append(
                        new StoreInstruction(
                                curBasicBlock, reg, 0,
                                CompilerOption.getSizeInt(), dim.intValue
                        )
                );
                processNewArray(reg, node.getVartype());
            } else {
                ExpressionNode dim = node.getVartype().getDims().get(0);
                boolean oldNeedAddr = needAddr;
                needAddr = false;
                VartypeNode baseType = new VartypeNode(
                        new Type(
                                node.getVartype().getType().getType(),
                                node.getVartype().getType().getDimension() - 1
                        ),
                        node.getVartype().getName()
                );
                needAddr = oldNeedAddr;
                if (dim.intValue instanceof IntImmediate) {
                    int size = ((IntImmediate) dim.intValue).getVal()*baseType.getRegisterSize()
                            +CompilerOption.getSizeInt();
                    curBasicBlock.append(new MoveInstruction(curBasicBlock,new IntImmediate(size),reg));
                }
                else {
                    curBasicBlock.append(
                            new ArithmeticInstruction(
                                    curBasicBlock, reg, BinaryOperationInstruction.Operator.MUL, dim.intValue,
                                    new IntImmediate(baseType.getRegisterSize())
                            )
                    );
                    curBasicBlock.append(
                            new ArithmeticInstruction(
                                    curBasicBlock, reg, BinaryOperationInstruction.Operator.ADD, reg,
                                    new IntImmediate(CompilerOption.getSizeInt())
                            )
                    );
                }
                curBasicBlock.append(new HeapAllocateInstruction(curBasicBlock, reg, reg));
                curBasicBlock.append(
                        new StoreInstruction(
                                curBasicBlock, reg, 0,
                                CompilerOption.getSizeInt(), dim.intValue
                        )
                );
            }
        }
        node.intValue = reg;
    }

    private void processSelfIncOrDec(ExpressionNode node) {
        boolean oldNeedAddr = needAddr, isMemOp = needMemoryAccess(node);
        needAddr = isMemOp;
        ExprNode oprand = node.getExprs().get(0);
        visit(oprand);
        if (isMemOp) {
            needAddr = false;
            visit(oprand);
        }
        needAddr = oldNeedAddr;

        BinaryOperationInstruction.Operator op = BinaryOperationInstruction.Operator.ADD;
        if (node.getOp().getOp() == ExprOperator.Operator.SDEC || node.getOp().getOp() == ExprOperator.Operator.PDEC)
            op = BinaryOperationInstruction.Operator.SUB;
        boolean isSuffix = true;
        if (node.getOp().getOp() == ExprOperator.Operator.PINC || node.getOp().getOp() == ExprOperator.Operator.PDEC)
            isSuffix = false;
        IntImmediate one = new IntImmediate(1);
        VirtualRegister reg;

        if (isSuffix) {
            reg = new VirtualRegister(null);
            curBasicBlock.append(new MoveInstruction(curBasicBlock, oprand.intValue, reg));
            node.intValue = reg;
        } else node.intValue = oprand.intValue;

        if (isMemOp) {
            IntValue addr = oprand.address;
            int offset = oprand.offset;
            reg = new VirtualRegister(null);
            curBasicBlock.append(new ArithmeticInstruction(curBasicBlock, reg, op, oprand.intValue, one));
            curBasicBlock.append(new StoreInstruction(curBasicBlock, addr, offset, CompilerOption.getSizeInt(), reg));
            if (!isSuffix) node.intValue = reg;
        } else {
            curBasicBlock.append(
                    new ArithmeticInstruction(
                            curBasicBlock, (Register) oprand.intValue, op, oprand.intValue, one
                    )
            );
        }
    }

    private void processStrOperation(ExprOperator.Operator op, ExpressionNode node) {
        visit(node.getExprs().get(0));
        visit(node.getExprs().get(1));
        ExprNode lhs = node.getExprs().get(0), rhs = node.getExprs().get(1);
        if (op == ExprOperator.Operator.GRTR || op == ExprOperator.Operator.GEQ) {
            lhs = node.getExprs().get(1);
            rhs = node.getExprs().get(0);
        }
        VirtualRegister reg = new VirtualRegister(null);
        node.intValue = reg;
        CallInstruction call = null;
        switch (op) {
            case ADD:
                call = new CallInstruction(curBasicBlock, reg, irRoot.stringConcat);
                break;
            case EQU:
                call = new CallInstruction(curBasicBlock, reg, irRoot.stringEqual);
                break;
            case LESS:
            case GRTR:
                call = new CallInstruction(curBasicBlock, reg, irRoot.stringLess);
                break;
            case LEQ:
            case GEQ:
                call = new CallInstruction(curBasicBlock, reg, irRoot.stringLeq);
                break;
            default:
                assert false;
                break;
        }
        call.appendArgReg(lhs.intValue);
        call.appendArgReg(rhs.intValue);
        curBasicBlock.append(call);

        if (node.basicBlockTrue != null) {
            curBasicBlock.end(new BranchInstruction(curBasicBlock, reg, node.basicBlockTrue, node.basicBlockFalse));
        }
    }

    private void processFuncPrint(ExprNode node, boolean lastNewLine) {
        if (node instanceof ExpressionNode) {
            if (((ExpressionNode) node).getOp().getOp() == SELF) {
                processFuncPrint(((ExpressionNode) node).getExprs().get(0), lastNewLine);
            }
            else if (((ExpressionNode) node).getOp().getOp() == ExprOperator.Operator.ADD) {
                ExprNode lhs = ((ExpressionNode) node).getExprs().get(0);
                ExprNode rhs = ((ExpressionNode) node).getExprs().get(1);
                processFuncPrint(lhs, false);
                processFuncPrint(rhs, lastNewLine);
            }
            else {
                visit(node);
                CallInstruction call = new CallInstruction(
                        curBasicBlock, null,
                        lastNewLine ? irRoot.funcPrintln : irRoot.funcPrint
                );
                call.appendArgReg(node.intValue);
                curBasicBlock.append(call);
            }
        } else {
            boolean flag = false;
            if (node instanceof CallfunNode) {
                FunctionType functionType = null;
                if (className != null) {
                    functionType = (FunctionType) globalSymbolTable.globals.getTypeInfo(
                            className + "." + ((CallfunNode) node).getName()
                    );
                }
                if (functionType == null) {
                    functionType = (FunctionType) globalSymbolTable.globals.getTypeInfo(
                            ((CallfunNode) node).getName()
                    );
                    if (functionType == GlobalSymbolTable.funcToString)
                        flag = true;
                }
            }
            if (flag) {
                ExprNode intExpr = ((CallfunNode) node).getParams().get(0);
                visit(intExpr);
                CallInstruction call = new CallInstruction(
                        curBasicBlock, null,
                        lastNewLine ? irRoot.funcPrintlnInt : irRoot.funcPrintInt
                );
                call.appendArgReg(intExpr.intValue);
                curBasicBlock.append(call);
            } else {
                visit(node);
                CallInstruction call = new CallInstruction(
                        curBasicBlock, null,
                        lastNewLine ? irRoot.funcPrintln : irRoot.funcPrint
                );
                call.appendArgReg(node.intValue);
                curBasicBlock.append(call);
            }
        }
    }

    private void processBuiltinMethod(ExprNode node, FunctionType functionType) {
        boolean oldNeedAddr = needAddr;
        needAddr = false;
        if (node instanceof CallfunNode) {
            if (functionType == GlobalSymbolTable.funcPrint || functionType == GlobalSymbolTable.funcPrintln) {
                processFuncPrint(((CallfunNode) node).getParams().get(0),
                        functionType == GlobalSymbolTable.funcPrintln);
            } else if (functionType == GlobalSymbolTable.funcGetString) {
                VirtualRegister reg = new VirtualRegister("gottenstring");
                CallInstruction call = new CallInstruction(curBasicBlock, reg, irRoot.funcGetString);
                curBasicBlock.append(call);
                node.intValue = reg;
            } else if (functionType == GlobalSymbolTable.funcGetInt) {
                VirtualRegister reg = new VirtualRegister("gottenint");
                CallInstruction call = new CallInstruction(curBasicBlock, reg, irRoot.funcGetInt);
                curBasicBlock.append(call);
                node.intValue = reg;
            } else if (functionType == GlobalSymbolTable.funcToString) {
                visit(((CallfunNode) node).getParams().get(0));
                VirtualRegister reg = new VirtualRegister("tostring");
                CallInstruction call = new CallInstruction(curBasicBlock, reg, irRoot.funcToString);
                call.appendArgReg(((CallfunNode) node).getParams().get(0).intValue);
                curBasicBlock.append(call);
                node.intValue = reg;
            } else {
                // Cannot reach here.
                assert false;
            }
        } else {
            ExprNode record = ((ExpressionNode) node).getExprs().get(0);
            CallfunNode member = (CallfunNode) ((ExpressionNode) node).getExprs().get(1);
            if (functionType == GlobalSymbolTable.arraySize||functionType == GlobalSymbolTable.stringLength) {
                visit(record);
                VirtualRegister reg = new VirtualRegister("size");
                curBasicBlock.append(
                        new LoadInstruction(
                                curBasicBlock, reg, CompilerOption.getSizeInt(),
                                record.intValue, 0));
                node.intValue = reg;
            }
            /*else if (functionType == GlobalSymbolTable.stringLength) {
                visit(record);
                member.getParams().forEach(param -> param.accept(this));
                VirtualRegister reg = new VirtualRegister("length");
                CallInstruction call = new CallInstruction(curBasicBlock, reg, irRoot.stringLength);
                member.getParams().forEach(param -> call.appendArgReg(param.intValue));
                curBasicBlock.append(call);
                node.intValue = reg;
            }*/
            else if (functionType == GlobalSymbolTable.stringSubString) {
                visit(record);
                member.getParams().forEach(param -> param.accept(this));
                VirtualRegister reg = new VirtualRegister("substr");
                CallInstruction call = new CallInstruction(curBasicBlock, reg, irRoot.stringSubString);
                call.appendArgReg(record.intValue);
                member.getParams().forEach(param -> call.appendArgReg(param.intValue));
                curBasicBlock.append(call);
                node.intValue = reg;
            } else if (functionType == GlobalSymbolTable.stringParseInt) {
                visit(record);
                VirtualRegister reg = new VirtualRegister("parsedint");
                CallInstruction call = new CallInstruction(curBasicBlock, reg, irRoot.stringParseInt);
                call.appendArgReg(record.intValue);
                curBasicBlock.append(call);
                node.intValue = reg;
            } else if (functionType == GlobalSymbolTable.stringOrd) {
                visit(record);
                visit(member.getParams().get(0));
                VirtualRegister reg = new VirtualRegister("ord");
                curBasicBlock.append(
                        new ArithmeticInstruction(
                                curBasicBlock, reg, BinaryOperationInstruction.Operator.ADD,
                                record.intValue, member.getParams().get(0).intValue));
                curBasicBlock.append(
                        new LoadInstruction(
                                curBasicBlock, reg, 1,
                                reg, CompilerOption.getSizeInt()));
                node.intValue = reg;
            }

        }
    }

    private void processIntArithmeticExpr(ExprOperator.Operator op, ExpressionNode node) {
        ExprNode lhs = node.getExprs().get(0), rhs = node.getExprs().get(1);
        visit(lhs);
        visit(rhs);
        boolean isConstant = (lhs.intValue instanceof IntImmediate)&&(rhs.intValue instanceof IntImmediate);
        BinaryOperationInstruction.Operator operator = null;
        switch (op) {
            case TIMES:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()*((IntImmediate) rhs.intValue).getVal()
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.MUL;
                break;
            case DIVIDE:
                if (isConstant) {
                    if (((IntImmediate) rhs.intValue).getVal() != 0)
                        node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()/((IntImmediate) rhs.intValue).getVal()
                        );
                    else WarningInfo.add(node.location(),"Cannot divide 0.");
                    return;
                }
                operator = BinaryOperationInstruction.Operator.DIV;
                break;
            case MOD:
                if (isConstant) {
                    if (((IntImmediate) rhs.intValue).getVal() != 0)
                        node.intValue = new IntImmediate(
                                ((IntImmediate) lhs.intValue).getVal()%((IntImmediate) rhs.intValue).getVal()
                        );
                    else WarningInfo.add(node.location(),"Cannot mod 0.");
                    return;
                }
                operator = BinaryOperationInstruction.Operator.MOD;
                break;
            case ADD:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()+((IntImmediate) rhs.intValue).getVal()
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.ADD;
                break;
            case SUB:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()-((IntImmediate) rhs.intValue).getVal()
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.SUB;
                break;
            case LESH:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()<<((IntImmediate) rhs.intValue).getVal()
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.SHL;
                break;
            case RISH:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()>>((IntImmediate) rhs.intValue).getVal()
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.SHR;
                break;
            case BAND:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()&((IntImmediate) rhs.intValue).getVal()
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.AND;
                break;
            case XOR:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()^((IntImmediate) rhs.intValue).getVal()
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.XOR;
                break;
            case BOR:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()|((IntImmediate) rhs.intValue).getVal()
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.OR;
                break;
            default:
                assert false;
                break;
        }
        VirtualRegister reg = new VirtualRegister(null);
        node.intValue = reg;
        curBasicBlock.append(new ArithmeticInstruction(curBasicBlock, reg, operator, lhs.intValue, rhs.intValue));
    }

    private void processIntRelationExpr(ExprOperator.Operator op, ExpressionNode node) {
        ExprNode lhs = node.getExprs().get(0), rhs = node.getExprs().get(1);
        visit(lhs);
        visit(rhs);
        boolean isConstant = (lhs.intValue instanceof IntImmediate)&&(rhs.intValue instanceof IntImmediate);
        BinaryOperationInstruction.Operator operator = null;
        switch (op) {
            case EQU:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()==((IntImmediate) rhs.intValue).getVal()?1:0
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.EQU;
                break;
            case NEQ:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()!=((IntImmediate) rhs.intValue).getVal()?1:0
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.NEQ;
                break;
            case LESS:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()<((IntImmediate) rhs.intValue).getVal()?1:0
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.LESS;
                break;
            case LEQ:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()<=((IntImmediate) rhs.intValue).getVal()?1:0
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.LEQ;
                break;
            case GRTR:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()>((IntImmediate) rhs.intValue).getVal()?1:0
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.GRTR;
                break;
            case GEQ:
                if (isConstant) {
                    node.intValue = new IntImmediate(
                            ((IntImmediate) lhs.intValue).getVal()>=((IntImmediate) rhs.intValue).getVal()?1:0
                    );
                    return;
                }
                operator = BinaryOperationInstruction.Operator.GEQ;
                break;
            default:
                assert false;
                break;
        }
        VirtualRegister reg = new VirtualRegister(null);
        curBasicBlock.append(new ComparisionInstruction(curBasicBlock, reg, operator, lhs.intValue, rhs.intValue));

        if (node.basicBlockTrue != null)
            curBasicBlock.end(new BranchInstruction(curBasicBlock, reg, node.basicBlockTrue, node.basicBlockFalse));
        else node.intValue = reg;
    }

    @Override
    public void visit(DefunNode node) {
        if (className == null) {
            curFunction = irRoot.functions.get(node.getName());
        } else {
            curFunction = irRoot.functions.get(className + "." + node.getName());
            curFunction.argRegList.add(new VirtualRegister("this"));
        }
        curBasicBlock = curFunction.startBasicBlock;

        isFunArg = true;
        node.getParameterList().forEach(param -> param.accept(this));
        isFunArg = false;

        if (curFunction.getName().equals("main")) {
            curBasicBlock.append(new CallInstruction(curBasicBlock, null, irRoot.functions.get("__init")));
        }
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
            List<ReturnInstruction> returnInstructions = new ArrayList<>();
            returnInstructions.addAll(curFunction.retInstruction);
            for (ReturnInstruction ret : returnInstructions) {
                BasicBlock basicBlock = ret.getBasicBlock();
                ret.remove();
                if (ret.getRetVal() != null)
                    basicBlock.append(new MoveInstruction(basicBlock, ret.getRetVal(), newRetVal));
                basicBlock.end(new JumpInstruction(basicBlock, exitBasicBlock));
            }
            curFunction.retInstruction.clear();
            exitBasicBlock.end(new ReturnInstruction(exitBasicBlock,newRetVal));
            curFunction.exitBasicBlock = exitBasicBlock;
        } else curFunction.exitBasicBlock = curFunction.retInstruction.get(0).getBasicBlock();

        curFunction.exitBasicBlock.getPred().retainAll(curFunction.getReversePostOrder());
        // Write something here.
    }

    @Override
    public void visit(DefvarNode node) {
        SymbolInfo info = node.scope.getInfo(node.getName());
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }
        if (isFunArg)
            curFunction.argRegList.add((VirtualRegister) info.register);
        else {
            if (node.getInit() != null) {
                visit(node.getInit());
                assign(
                        false, node.getInit().getType().getRegisterSize(),
                        info.register, 0, node.getInit()
                );
            } else {
                NullNode nullNode = new NullNode();
                nullNode.setType(GlobalSymbolTable.nullType);
                nullNode.intValue = new IntImmediate(0);
                assign(false, nullNode.getType().getRegisterSize(), info.register, 0, nullNode);
            }
        }
    }

    @Override
    public void visit(DefclassNode node) {
        className = node.getName();
        node.getFunMembers().forEach(fun->fun.accept(this));
        curFunction = irRoot.functions.get(node.getName());
        curBasicBlock = curFunction.startBasicBlock;
        VirtualRegister thisReg = new VirtualRegister("this");
        curFunction.argRegList.add(thisReg);

        for (DefvarNode defvar:node.getVarMembers()) {
            if (defvar.getInit() != null) {
                visit(defvar.getInit());
                assign(
                        true,defvar.getInit().getType().getRegisterSize(),thisReg,
                        globalSymbolTable.globals.getOffset(className+"."+defvar.getName()), defvar.getInit()
                );
            }
        }

        if (node.getConstructor() != null) {
            DefunNode constructor = node.getConstructor();

            isFunArg = true;
            constructor.getParameterList().forEach(param -> param.accept(this));
            isFunArg = false;

            visit(constructor.getBody());
        }
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
        curFunction.exitBasicBlock.getPred().retainAll(curFunction.getReversePostOrder());
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
        curBasicBlock.end(new JumpInstruction(curBasicBlock,basicBlockAfter));

        if (node.isHasElse()) {
            curBasicBlock = basicBlockFalse;
            visit(node.getBlock2());
            curBasicBlock.end(new JumpInstruction(curBasicBlock,basicBlockAfter));
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
        curBasicBlock.end(new JumpInstruction(curBasicBlock,basicBlockCond));

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
            node.getCond().basicBlockTrue = basicBlockLoop;
            node.getCond().basicBlockFalse = basicBlockAfter;
            visit(node.getCond());
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
        if (node.getName() == null)
            return;
        SymbolInfo info = node.getInfo();
        info.used = true;
        if (info.isClassGlobal()) {
            VirtualRegister reg = new VirtualRegister(null);
            node.intValue = reg;
            IntValue address = curFunction.argRegList.get(0);
            IntValue offset = new IntImmediate(globalSymbolTable.globals.getOffset(className+"."+node.getName()));
            if (needAddr) {
                node.address = address;
                node.offset = ((IntImmediate) offset).getVal();
            }
            else {
                curBasicBlock.append(new ArithmeticInstruction(
                        curBasicBlock, reg,
                        BinaryOperationInstruction.Operator.ADD,
                        address, offset)
                );
                curBasicBlock.append(new LoadInstruction(
                        curBasicBlock, reg,
                        node.getType().getRegisterSize(),
                        address,0)
                );
            }
        }
        else node.intValue = info.register;
        if (node.basicBlockTrue != null) {
            curBasicBlock.end(new BranchInstruction(curBasicBlock,node.intValue,node.basicBlockTrue,node.basicBlockFalse));
        }
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
        if (node.basicBlockTrue != null) {
            if (node.getVal())
                curBasicBlock.end(new JumpInstruction(curBasicBlock,node.basicBlockTrue));
            else curBasicBlock.end(new JumpInstruction(curBasicBlock,node.basicBlockFalse));
        }
    }

    @Override
    public void visit(NullNode node) {
        node.intValue = new IntImmediate(0);
    }

    @Override
    public void visit(VariableNode node) {
        if (node.isThis()) {
            node.intValue = curFunction.argRegList.get(0);
        }
        else if (node.getVar() == null && node.getId() != null && node.getExpr() == null) {
            node.getId().basicBlockTrue = node.basicBlockTrue;
            node.getId().basicBlockFalse = node.basicBlockFalse;
            visit(node.getId());
            if (needAddr) {
                node.address = node.getId().address;
                node.offset = node.getId().offset;
            }
            else node.intValue = node.getId().intValue;
        }
        else if (node.getVar() != null && node.getId() == null && node.getExpr() == null) {
            node.getId().basicBlockTrue = node.basicBlockTrue;
            node.getId().basicBlockFalse = node.basicBlockFalse;
            visit(node.getId());
            if (needAddr) {
                node.address = node.getVar().address;
                node.offset = node.getVar().offset;
            }
            else node.intValue = node.getVar().intValue;
        }
        else if (node.getVar() != null && node.getId() != null && node.getExpr() == null) { // Member Access
            ExprNode record = node.getVar(),member = node.getId();
            boolean oldNeedAddr = needAddr;
            needAddr = false;
            visit(record);
            needAddr = oldNeedAddr;

            IntValue address = record.intValue;
            int offset = globalSymbolTable.globals.getOffset(
                    record.getType().getName() + "." + ((IdentifierNode) member).getName()
            );
            VartypeNode type = globalSymbolTable.globals.getTypeInfo(
                    record.getType().getName() + "." + ((IdentifierNode) member).getName()
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
        if (className != null&&globalSymbolTable.globals.getTypeInfo(className+"."+node.getName()) != null) {
            Function function = irRoot.functions.get(className+"."+node.getName());
            node.getParams().forEach(param -> param.accept(this));
            VirtualRegister reg = new VirtualRegister(null);
            CallInstruction call = new CallInstruction(curBasicBlock, reg, function);
            call.appendArgReg(curFunction.argRegList.get(0));
            node.getParams().forEach(param -> call.appendArgReg(param.intValue));
            curBasicBlock.append(call);
            node.intValue = reg;
        }
        else {
            functionType = (FunctionType) globalSymbolTable.globals.getTypeInfo(node.getName());
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
        assign(isMemOp,rhs.getType().getRegisterSize(),addr,offset,rhs);
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
            if (!needAddr) {
                node.intValue = node.getExprs().get(0).intValue;
            }
            else {
                node.address = node.getExprs().get(0).address;
                node.offset = node.getExprs().get(0).offset;
            }
        }
        else if (op == ExprOperator.Operator.MEM) {
            ExprNode record = node.getExprs().get(0),member = node.getExprs().get(1);
            boolean oldNeedAddr = needAddr;
            needAddr = false;
            visit(record);
            needAddr = oldNeedAddr;

            if (member instanceof IdentifierNode) {
                IntValue address = record.intValue;
                int offset = globalSymbolTable.globals.getOffset(
                        node.getType().getName() + "." + ((IdentifierNode) member).getName()
                );
                VartypeNode type = globalSymbolTable.globals.getTypeInfo(
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
            else { // Call builtin function
                if (record.getType().getType().getDimension() > 0) {
                    processBuiltinMethod(node,GlobalSymbolTable.arraySize);
                }
                else if (record.getType().isString()) {
                    FunctionType functionType = (FunctionType) globalSymbolTable.globals.getTypeInfo(
                            "string." + ((CallfunNode) member).getName()
                    );
                    processBuiltinMethod(node,functionType);
                }
                else {
                    FunctionType functionType = (FunctionType) globalSymbolTable.globals.getTypeInfo(
                            record.getType().getName() + "." + ((CallfunNode) member).getName()
                    );
                    Function function = irRoot.functions.get(functionType.getName());
                    ((CallfunNode) member).getParams().forEach(param -> param.accept(this));
                    VirtualRegister reg = new VirtualRegister(null);
                    CallInstruction call = new CallInstruction(curBasicBlock, reg, function);
                    call.appendArgReg(record.intValue);
                    ((CallfunNode) member).getParams().forEach(param -> call.appendArgReg(param.intValue));
                    curBasicBlock.append(call);
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
            visit(node.getExprs().get(0));
            if (node.getExprs().get(0).intValue instanceof IntImmediate) {
                if (op == ExprOperator.Operator.NEG)
                    node.intValue = new IntImmediate(-((IntImmediate) node.getExprs().get(0).intValue).getVal());
                else
                    node.intValue = new IntImmediate(~((IntImmediate) node.getExprs().get(0).intValue).getVal());
            }
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
            VirtualRegister reg = new VirtualRegister(null);
            visit(node.getExprs().get(0));
            curBasicBlock.append(new ArithmeticInstruction(
                    curBasicBlock,
                    reg,BinaryOperationInstruction.Operator.XOR,
                    node.getExprs().get(0).intValue,
                    new IntImmediate(1))
            );
            if (node.getExprs().get(0).intValue instanceof IntImmediate){
                node.intValue = new IntImmediate(((IntImmediate) node.getExprs().get(0).intValue).getVal()^1);
            }
            else node.intValue = reg;
            if (node.basicBlockTrue != null) {
                curBasicBlock.end(new BranchInstruction(curBasicBlock,reg,node.basicBlockTrue,node.basicBlockFalse));
            }
        }
        else if (op == ExprOperator.Operator.NEW)
            processNewExpr(node);
        else if (op == ExprOperator.Operator.EQU||op == ExprOperator.Operator.NEQ
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
            VirtualRegister reg = new VirtualRegister(null);

            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            lhs.basicBlockTrue = new BasicBlock(curFunction,"lhs_true");
            lhs.basicBlockFalse = new BasicBlock(curFunction,"lhs_false");
            BasicBlock merge = new BasicBlock(curFunction,"lhs_merge");

            visit(lhs);

            lhs.basicBlockFalse.append(new MoveInstruction(lhs.basicBlockFalse,new IntImmediate(0),reg));
            lhs.basicBlockFalse.end(new JumpInstruction(lhs.basicBlockFalse,merge));

            curBasicBlock = lhs.basicBlockTrue;

            visit(rhs);
            curBasicBlock.append(new MoveInstruction(curBasicBlock,rhs.intValue,reg));
            curBasicBlock.end(new JumpInstruction(curBasicBlock,merge));

            node.intValue = reg;

            curBasicBlock = merge;
            if (node.basicBlockTrue != null)
                curBasicBlock.end(new BranchInstruction(curBasicBlock,reg,node.basicBlockTrue,node.basicBlockFalse));
        }
        else if (op == ExprOperator.Operator.LOR) {
            VirtualRegister reg = new VirtualRegister(null);

            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            lhs.basicBlockTrue = new BasicBlock(curFunction,"lhs_true");
            lhs.basicBlockFalse = new BasicBlock(curFunction,"lhs_false");
            BasicBlock merge = new BasicBlock(curFunction,"lhs_merge");

            visit(lhs);

            lhs.basicBlockTrue.append(new MoveInstruction(lhs.basicBlockFalse,new IntImmediate(1),reg));
            lhs.basicBlockTrue.end(new JumpInstruction(lhs.basicBlockFalse,merge));

            curBasicBlock = lhs.basicBlockFalse;

            visit(rhs);
            curBasicBlock.append(new MoveInstruction(curBasicBlock,rhs.intValue,reg));
            curBasicBlock.end(new JumpInstruction(curBasicBlock,merge));

            node.intValue = reg;

            curBasicBlock = merge;
            if (node.basicBlockTrue != null)
                curBasicBlock.end(new BranchInstruction(curBasicBlock,reg,node.basicBlockTrue,node.basicBlockFalse));
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
            visit(lhs);
            basicBlockTrue.append(new MoveInstruction(basicBlockTrue,lhs.intValue,reg));
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
        curFunction = irRoot.functions.get("__init");
        curBasicBlock = curFunction.startBasicBlock;
        node.getDefs().forEach(def -> {
            if (def instanceof DefvarNode)
                def.accept(this);
        });
        curBasicBlock.end(new ReturnInstruction(curBasicBlock,null));
        curFunction = null;
        node.getDefs().forEach(def -> {
            if (!(def instanceof DefvarNode))
                def.accept(this);
        });
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
