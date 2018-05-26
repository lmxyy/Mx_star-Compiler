package com.lmxyy.mxcompiler.ir;

public abstract class Register extends IntValue {
    public abstract void accept(IRVisitor visitor);
}
