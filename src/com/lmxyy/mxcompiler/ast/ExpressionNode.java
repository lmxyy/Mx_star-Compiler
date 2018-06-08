package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.ExprOperator;
import com.lmxyy.mxcompiler.utils.Location;

import java.util.ArrayList;
import java.util.List;


public class ExpressionNode extends ExprNode{
    private List<ExprNode> exprs;
    private VartypePlusNode vartype;
    private ExprOperator op;
    private boolean hasPar;

    public ExpressionNode(List<ExprNode> _exprs,VartypePlusNode _vartype,ExprOperator _op,boolean _hasPar) {
        vartype = _vartype;
        op = _op;
        exprs = new ArrayList<>();
        if (op.getOp() == ExprOperator.Operator.LAND||op.getOp() == ExprOperator.Operator.LOR) {
            exprs.add(_exprs.get(1));
            exprs.add(_exprs.get(0));
        }
        else exprs.addAll(_exprs);
//        exprs = _exprs;
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
        if (exprs.isEmpty())
            return vartype.location();
        else return exprs.get(0).location();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
