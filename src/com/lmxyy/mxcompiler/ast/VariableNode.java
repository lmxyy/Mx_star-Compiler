package com.lmxyy.mxcompiler.ast;

public class VariableNode extends TermNode {
    private VariableNode var;
    private IdentifierNode id;
    private ExpressionNode expr;

    public VariableNode(VariableNode _var,IdentifierNode _id,ExpressionNode _expr) {
        var = _var;
        id = _id;
        expr = _expr;
    }

    public VariableNode getVar() {
        return var;
    }
    public IdentifierNode getId() {
        return id;
    }
    public ExpressionNode getExpr() {
        return expr;
    }

    @Override
    public Location location() {
        if (var != null) return var.location();
        else return id.location();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
