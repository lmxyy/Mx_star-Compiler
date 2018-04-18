package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.ExprOperator;

import java.util.List;


public class ExpressionNode extends ExprNode{
    List<ExprNode> exprs;
    ExprOperator op;

    public ExpressionNode(List<ExprNode> _exprs,ExprOperator _op) {
        exprs = _exprs;
        op = _op;
    }

    public List<ExprNode> getExprs() {
        return exprs;
    }
    public ExprOperator getOp() {
        return op;
    }

    @Override
    public Location location() { return exprs.get(0).location(); }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
