package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.ExprOperator;

import java.util.List;


public class ExpressionNode extends ExprNode{
    private List<ExprNode> exprs;
    private VartypePlusNode vartype;
    private ExprOperator op;
    private boolean hasPar;

    public ExpressionNode(List<ExprNode> _exprs,VartypePlusNode _vartype,ExprOperator _op,boolean _hasPar) {
        exprs = _exprs;
        vartype = _vartype;
        op = _op;
        hasPar = _hasPar;
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
    public boolean isHasPar() {
        return hasPar;
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
