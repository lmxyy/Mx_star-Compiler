package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

public class DefvarNode extends DefNode {
    private VartypeNode type;
    private String name;
    private ExpressionNode init;

    public DefvarNode(VartypeNode _type,String _name,ExpressionNode _init) {
        type = _type;
        name = _name;
        init = _init;
    }

    public VartypeNode getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public ExpressionNode getInit() {
        return init;
    }

    @Override
    public Location location() {
        return type.location();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
