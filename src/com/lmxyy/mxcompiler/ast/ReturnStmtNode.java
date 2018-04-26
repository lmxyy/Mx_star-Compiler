package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

public class ReturnStmtNode extends StmtNode {
    private ExpressionNode expr;
    private Location location;

    public ReturnStmtNode(ExpressionNode _expr) {
        expr = _expr;
    }

    public void setLocation(Location _location) {
        location = _location;
    }

    public ExpressionNode getExpr() {
        return expr;
    }

    @Override
    public Location location() {
        return location;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
