package com.lmxyy.mxcompiler.ir;

public class IntImmediate extends IntValue {
    private int val;

    public IntImmediate (int _val) {
        val = _val;
    }
    public int getVal() {
        return val;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
