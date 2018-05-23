package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.ir.BasicBlock;
import com.lmxyy.mxcompiler.ir.IntValue;

public abstract class ExprNode extends Node {
    private VartypeNode type;

    public BasicBlock basicBlockTrue = null,basicBlockFalse = null;

    public IntValue intValue;
    public IntValue address;
    public int offset;

    public VartypeNode getType() {
        return type;
    }
    public void setType(VartypeNode _type) {
        type = _type;
    }
}
