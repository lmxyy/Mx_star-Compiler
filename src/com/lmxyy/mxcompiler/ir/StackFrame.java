package com.lmxyy.mxcompiler.ir;

public class StackFrame extends Register {
    private Function parent;
    private String hintName;

    public StackFrame(Function _parent,String _hintName) {
        parent = _parent;
        hintName = _hintName;
    }

    @Override
    public void accept(IRVisitor visitor) { visitor.visit(this); }
}
