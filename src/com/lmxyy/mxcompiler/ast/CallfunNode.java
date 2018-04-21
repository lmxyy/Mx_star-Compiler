package com.lmxyy.mxcompiler.ast;

import java.util.List;

public class CallfunNode extends ExprNode {
    VariableNode fun;
    List<ExpressionNode> params;
    public CallfunNode(VariableNode _fun,List<ExpressionNode> _params) {
        fun = _fun;
        params = _params;
    }

    public VariableNode getFun() {
        return fun;
    }
    public List<ExpressionNode> getParams() {
        return params;
    }

    @Override
    public Location location() {
        return fun.location();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
