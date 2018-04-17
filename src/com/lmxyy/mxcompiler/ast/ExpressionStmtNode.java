package com.lmxyy.mxcompiler.ast;

public class ExpressionStmtNode extends StmtNode {
    private ExpressionNode expr;

    public ExpressionStmtNode(ExpressionNode _expr) {
        expr = _expr;
    }

    public ExpressionNode getExpr() {
        return expr;
    }

    @Override
    public Location location() {
        return expr.location();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
