package com.lmxyy.mxcompiler.ir;

public class StackSlot extends Register {
    private Function parent;
    private String hintName;

    public StackSlot(Function _parent, String _hintName) {
        parent = _parent;
        hintName = _hintName;
    }

    @Override
    public void accept(IRVisitor visitor) { visitor.visit(this); }
}
