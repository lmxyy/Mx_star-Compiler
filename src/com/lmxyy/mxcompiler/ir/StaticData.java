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
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
