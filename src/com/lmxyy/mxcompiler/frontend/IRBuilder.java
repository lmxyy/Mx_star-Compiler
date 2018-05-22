package com.lmxyy.mxcompiler.frontend;

import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.symbol.FunctionType;
import com.lmxyy.mxcompiler.symbol.GlobalSymbolTable;
import com.lmxyy.mxcompiler.symbol.SymbolInfo;
import com.lmxyy.mxcompiler.utils.WarningInfo;

public class IRBuilder implements ASTVisitor {
    private IRRoot irRoot = new IRRoot();
    private GlobalSymbolTable globalSymbolTable;
    private Function curFunction;
    private BasicBlock curBasicBlock;
    private BasicBlock loopStepBlock = null,loopAfterBlock = null;
    private boolean isFunArg = false;

    public IRBuilder(GlobalSymbolTable _globalSymbolTable) {
        globalSymbolTable = _globalSymbolTable;
    }

    @Override
    public void visit(DefunNode node) {
        FunctionType functionType = (FunctionType)globalSymbolTable.resolveType(node.getName());
        curFunction = new Function(functionType);
        irRoot.functions.put(node.getName(),curFunction);

        curBasicBlock = curFunction.startBasicBlock;
        isFunArg = true;
        node.getParameterList().forEach(para->para.accept(this));
        isFunArg = false;

        visit(node.getBody());
        if (!curBasicBlock.isEnded()) {
            if (node.getReturnType().isVoid())
                curBasicBlock.end(new Return(curBasicBlock,null));
            else {
                curBasicBlock.end(new Return(curBasicBlock, new IntImmediate(0)));
                WarningInfo.add(node.location(),"The function doesn't have a return value.");
            }
        }

        // merge all return blocks to one block
        if (curFunction.retInstruction.size() > 1) {
            BasicBlock exitBasicBlock = new BasicBlock(curFunction,"$"+curFunction.getName()+".exit");
            Register newRetVal = null;
            if (!node.getReturnType().isVoid())
                newRetVal = new VirtualRegister("$returnValue");
            for (Return ret:curFunction.retInstruction) {
                BasicBlock basicBlock = ret.getBasicBlock();
                ret.remove();
                if (ret.getRetVal() != null)
                    basicBlock.append(new Move(basicBlock,ret.getRetVal(),newRetVal));
                basicBlock.end(new Jump(basicBlock,exitBasicBlock));
            }
            curFunction.retInstruction.clear();
        }
        else curFunction.exitBasicBlock = curFunction.retInstruction.get(0).getBasicBlock();
        // remove unreachable block: to be completed

    }

    @Override
    public void visit(DefvarNode node) {
        SymbolInfo info = node.scope.getInfo(node.getName());
        if (node.scope == globalSymbolTable.globals) {
            StaticData data = new StaticSpace(node.getName(),info.getType().getRegisterSize());
            info.register = data;
            
        }
    }

    @Override
    public void visit(DefclassNode node) {

    }

    @Override
    public void visit(DefvarlistNode node) {
        node.getVars().forEach(var->var.accept(this));
    }

    @Override
    public void visit(VartypeNode node) {

    }

    @Override
    public void visit(VartypePlusNode node) {

    }

    @Override
    public void visit(IfStmtNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }
        BasicBlock basicBlockTrue = new BasicBlock(curFunction,"$if_true"),basicBlockFalse = null;
        BasicBlock basicBlockAfter = new BasicBlock(curFunction,"$if_after");
        if (node.isHasElse())
            basicBlockFalse = new BasicBlock(curFunction,"$if_false");
        node.getCond().basicBlockTrue = basicBlockTrue;
        if (node.isHasElse()) node.getCond().basicBlockFalse = basicBlockFalse;
        else node.getCond().basicBlockFalse = basicBlockAfter;
        visit(node.getCond());

        curBasicBlock = basicBlockTrue;
        visit(node.getBlock1());
        basicBlockTrue.end(new Jump(curBasicBlock,basicBlockAfter));

        if (node.isHasElse()) {
            curBasicBlock = basicBlockFalse;
            visit(node.getBlock2());
            basicBlockTrue.end(new Jump(curBasicBlock,basicBlockAfter));
        }

        curBasicBlock = basicBlockAfter;
    }

    @Override
    public void visit(WhileStmtNode node) {
        if (curBasicBlock.isEnded()) {
            WarningInfo.uselessStatement(node.location());
            return;
        }
        BasicBlock basicBlockCond = new BasicBlock(curFunction,"$while_cond");
        BasicBlock basicBlockLoop = new BasicBlock(curFunction,"$while_loop");
        BasicBlock basicBlockAfter = new BasicBlock(curFunction,"$while_after");

        BasicBlock oldLoopStepBlock = loopStepBlock;
        BasicBlock oldLoopAfterBlock = loopAfterBlock;
        loopStepBlock = basicBlockCond; loopAfterBlock = basicBlockAfter;

        curBasicBlock.end(new Jump(curBasicBlock,basicBlockCond));
        node.getCond().basicBlockTrue = basicBlockLoop;
        node.getCond().basicBlockFalse = basicBlockAfter;

        curBasicBlock = basicBlockCond;
        visit(node.getCond());

        curBasicBlock = basicBlockLoop;
        visit(node.getBlock());
        basicBlockLoop.end(new Jump(curBasicBlock,basicBlockCond));

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

        BasicBlock basicBlockCond = new BasicBlock(curFunction,"$for_cond");
        BasicBlock basicBlockLoop = new BasicBlock(curFunction,"$for_loop");
        BasicBlock basicBlockStep = new BasicBlock(curFunction,"$for_step");
        BasicBlock basicBlockAfter = new BasicBlock(curFunction,"$for_after");

        BasicBlock oldLoopStepBlock = loopStepBlock;
        BasicBlock oldLoopAfterBlock = loopAfterBlock;
        loopStepBlock = basicBlockCond; loopAfterBlock = basicBlockAfter;

        curBasicBlock.end(new Jump(curBasicBlock,basicBlockCond));
        curBasicBlock = basicBlockCond;
        if (node.getCond() != null) {
            visit(node.getCond());
            node.getCond().basicBlockTrue = basicBlockLoop;
            node.getCond().basicBlockFalse = basicBlockAfter;
        }

        curBasicBlock.end(new Jump(curBasicBlock,basicBlockLoop));
        curBasicBlock = basicBlockLoop;
        visit(node.getBlock());
        if (node.getStep() == null) curBasicBlock.end(new Jump(curBasicBlock,basicBlockCond));
        else {
            curBasicBlock.end(new Jump(curBasicBlock,basicBlockStep));
            curBasicBlock = basicBlockStep;
            node.getStep().forEach(step->step.accept(this));
            curBasicBlock.end(new Jump(curBasicBlock,basicBlockCond));
        }

        curBasicBlock = basicBlockAfter;
        loopStepBlock = oldLoopStepBlock; loopAfterBlock = oldLoopAfterBlock;
    }

    @Override
    public void visit(ContinueStmtNode node) {
        curBasicBlock.end(new Jump(curBasicBlock,loopStepBlock));
    }

    @Override
    public void visit(BreakStmtNode node) {
        curBasicBlock.end(new Jump(curBasicBlock,loopAfterBlock));
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.getExpr() == null)
            curBasicBlock.end(new Return(curBasicBlock,null));
        else {
            visit(node.getExpr());
            curBasicBlock.end(new Return(curBasicBlock,node.getExpr().intValue));
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

    }

    @Override
    public void visit(StringliteralNode node) {

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

    }

    @Override
    public void visit(CallfunNode node) {

    }

    @Override
    public void visit(AssignmentNode node) {

    }

    @Override
    public void visit(ExpressionNode node) {

    }

    @Override
    public void visit(ProgNode node) {
        node.getDefs().forEach(def -> def.accept(this));
        // To be completed here.
    }

    public void visit(StmtNode node) {
        node.accept(this);
    }
    public void visit(Node node) {
        node.accept(this);
    }
}
