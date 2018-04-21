package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.ExprOperator;

import java.util.List;


public class ExpressionNode extends ExprNode{
    List<ExprNode> exprs;
    VartypePlusNode vartype;
    ExprOperator op;

    public ExpressionNode(List<ExprNode> _exprs,VartypePlusNode _vartype,ExprOperator _op) {
        exprs = _exprs;
        vartype = _vartype;
        op = _op;
    }

    public List<ExprNode> getExprs() {
        return exprs;
    }
    public VartypePlusNode getVartype() {
        return vartype;
    }
    public ExprOperator getOp() {
        return op;
    }

    @Override
    public Location location() {
        return exprs.get(0).location();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
