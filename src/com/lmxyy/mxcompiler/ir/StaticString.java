package com.lmxyy.mxcompiler.ir;

public class StaticString extends StaticData {
    private String string;
    public StaticString(String _string) {
        super("string");
        string = _string;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public String getString() {
        return string;
    }
}
