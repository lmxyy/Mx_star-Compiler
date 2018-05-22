package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

public class VariableNode extends TermNode {
    private VariableNode var;
    private IdentifierNode id;
    private ExpressionNode expr;
    private boolean isThis;
    private Location location;

    public void setLocation(Location _location) {
        location = _location;
    }

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
        else if (id != null) return id.location();
        else return location;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
