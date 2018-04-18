package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.Type;

public abstract class ExprNode extends Node {
    private Type type;

    public Type getType() {
        return type;
    }
}
