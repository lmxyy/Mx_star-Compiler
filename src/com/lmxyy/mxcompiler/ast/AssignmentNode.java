package com.lmxyy.mxcompiler.ast;


import com.lmxyy.mxcompiler.utils.Location;

public class AssignmentNode extends Node {
    VariableNode variable;
    ExpressionNode expr;

    public AssignmentNode(VariableNode _variable,ExpressionNode _expr) {
        variable = _variable;
        expr = _expr;
    }

    public VariableNode getVariable() {
        return variable;
    }
    public ExpressionNode getExpr() {
        return expr;
    }

    @Override
    public Location location() {
        return variable.location();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
