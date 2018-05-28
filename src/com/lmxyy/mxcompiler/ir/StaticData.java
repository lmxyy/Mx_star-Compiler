package com.lmxyy.mxcompiler.ir;

public abstract class StaticData extends Register {
    private String hintName;
    public StaticData(String _hintName) {
        hintName = _hintName;
    }

    public String getHintName() {
        return hintName;
    }

    @Override
    public abstract void accept(IRVisitor visitor);

    public abstract int getRegisterSize();
}
