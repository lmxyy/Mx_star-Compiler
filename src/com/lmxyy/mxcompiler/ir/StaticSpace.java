package com.lmxyy.mxcompiler.ir;

public class StaticSpace extends StaticData {
    private int length;
    public StaticSpace(String _hintName,int _length) {
        super(_hintName);
        length = _length;
    }

    public int getLength() {
        return length;
    }
}
