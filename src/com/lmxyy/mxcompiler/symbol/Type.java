package com.lmxyy.mxcompiler.symbol;

public class Type {
    public enum Types {
        VOID,INT,BOOL,STRING,CLASS
    }

    private int dimension;
    private Types type;
    public int getDimension() {
        return dimension;
    }
    public Types getType() {
        return type;
    }
}
