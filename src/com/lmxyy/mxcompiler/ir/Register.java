package com.lmxyy.mxcompiler.ir;

public abstract class Register extends IntValue {
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
