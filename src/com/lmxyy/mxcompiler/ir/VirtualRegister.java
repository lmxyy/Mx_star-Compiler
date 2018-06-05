package com.lmxyy.mxcompiler.ir;

public class VirtualRegister extends Register {
    private String hintName;
    public PhysicalRegister forcedPhysicalRegister = null;

    public VirtualRegister(String _hintName) {
        hintName = _hintName;
    }

    public String getHintName() {
        return hintName;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public IntValue copy() {
        return new VirtualRegister(hintName);
    }
}
