package com.lmxyy.mxcompiler.ir;

public class StaticString extends StaticData {
    private String string;
    public StaticString(String _hintName,String _string) {
        super(_hintName);
        string = _string;
    }
}
