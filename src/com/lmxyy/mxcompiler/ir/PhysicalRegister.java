package com.lmxyy.mxcompiler.ir;

public class PhysicalRegister extends Register {
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
