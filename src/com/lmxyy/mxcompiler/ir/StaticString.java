package com.lmxyy.mxcompiler.ir;

public class StaticString extends StaticData {
    private String string;
    public StaticString(String _string) {
        super("$string");
        string = _string;
    }
}
