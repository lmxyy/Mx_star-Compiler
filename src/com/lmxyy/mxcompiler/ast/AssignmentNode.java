package com.lmxyy.mxcompiler.ast;


import com.lmxyy.mxcompiler.utils.Location;

public class AssignmentNode extends Node {
    ExpressionNode variable;
    ExpressionNode expr;

    public AssignmentNode(ExpressionNode _variable,ExpressionNode _expr) {
        variable = _variable;
        expr = _expr;
    }

    public ExpressionNode getVariable() {
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
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
