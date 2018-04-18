package com.lmxyy.mxcompiler.symbol;

public class Type {
    public enum Types {
        VOID,NULL,INT,BOOL,STRING,CLASS
    }
    private boolean isFun;
    private int dimension;
    private Types type;

    public boolean isFun() {
        return isFun;
    }
    public int getDimension() {
        return dimension;
    }
    public Types getType() {
        return type;
    }
}
