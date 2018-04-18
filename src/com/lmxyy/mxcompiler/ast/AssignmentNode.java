package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.AssignmentOperator;

public class AssignmentNode extends Node {
    VariableNode variable;
    AssignmentOperator op;
    ExpressionNode expr;

    public AssignmentNode(VariableNode _variable,AssignmentOperator _op,ExpressionNode _expr) {
        variable = _variable;
        op = _op;
        expr = _expr;
    }

    public VariableNode getVariable() {
        return variable;
    }
    public AssignmentOperator getOp() {
        return op;
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
