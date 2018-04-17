package com.lmxyy.mxcompiler.ast;

public class AssignmentStmtNode extends StmtNode{
    private AssignmentNode expr;

    public AssignmentStmtNode(AssignmentNode _expr) {
        expr = _expr;
    }

    public AssignmentNode getExpr() {
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
