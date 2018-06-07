package com.lmxyy.mxcompiler.ir;

public abstract class IntValue {
    public boolean important = false;
    public abstract void accept(IRVisitor visitor);

    public abstract IntValue copy();

}
