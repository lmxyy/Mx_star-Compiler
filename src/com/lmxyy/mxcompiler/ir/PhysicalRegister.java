package com.lmxyy.mxcompiler.ir;

public abstract class PhysicalRegister extends Register {
    public abstract void accept(IRVisitor visitor);

    public abstract boolean isCallerSave();
    public abstract boolean isCalleeSave();
}
