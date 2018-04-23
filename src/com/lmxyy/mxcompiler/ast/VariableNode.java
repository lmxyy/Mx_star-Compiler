package com.lmxyy.mxcompiler.ast;

public class VariableNode extends TermNode {
    private VariableNode var;
    private IdentifierNode id;
    private ExpressionNode expr;
    private boolean isThis;

    public VariableNode(VariableNode _var,IdentifierNode _id,ExpressionNode _expr,boolean _isThis) {
        var = _var;
        id = _id;
        expr = _expr;
        isThis = _isThis;
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
    public boolean isThis() {
        return isThis;
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
