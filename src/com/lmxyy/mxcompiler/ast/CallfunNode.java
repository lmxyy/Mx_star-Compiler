package com.lmxyy.mxcompiler.ast;

import java.util.List;

public class CallfunNode extends ExprNode {
    IdentifierNode fun;
    List<ExpressionNode> params;
    public CallfunNode(IdentifierNode _fun,List<ExpressionNode> _params) {
        fun = _fun;
        params = _params;
    }

    public IdentifierNode getFun() {
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
