package com.lmxyy.mxcompiler.ast;

public abstract class ExprNode extends Node {
    private VartypeNode type;

    public VartypeNode getType() {
        return type;
    }
    public void setType(VartypeNode _type) {
        type = _type;
    }
}
