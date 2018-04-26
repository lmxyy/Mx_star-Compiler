package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

public class IfStmtNode extends StmtNode{
    private ExpressionNode cond;
    private StmtNode block1;
    private boolean hasElse;
    private StmtNode block2;

    public IfStmtNode(ExpressionNode _cond,StmtNode _block1,boolean _hasElse,StmtNode _block2) {
        cond = _cond;
        block1 = _block1;
        hasElse = _hasElse;
        block2 = _block2;
    }

    public ExpressionNode getCond() {
        return cond;
    }
    public StmtNode getBlock1() {
        return block1;
    }
    public boolean isHasElse() {
        return hasElse;
    }
    public StmtNode getBlock2() {
        return block2;
    }

    @Override
    public Location location() {
        return cond.location();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
