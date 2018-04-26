package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

public class WhileStmtNode extends StmtNode {
    private ExpressionNode cond;
    private StmtNode block;
    private Location location;

    public WhileStmtNode(ExpressionNode _cond,StmtNode _block) {
        cond = _cond;
        block = _block;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public ExpressionNode getCond() {
        return cond;
    }
    public StmtNode getBlock() {
        return block;
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
