package com.lmxyy.mxcompiler.ir;

public abstract class IntValue {
    public abstract void accept(IRVisitor visitor);

    public abstract IntValue copy();
}
