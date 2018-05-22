package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.ir.IntValue;

public abstract class ExprNode extends Node {
    private VartypeNode type;
    public IntValue intValue;

    public VartypeNode getType() {
        return type;
    }
    public void setType(VartypeNode _type) {
        type = _type;
    }
}
