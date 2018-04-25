package com.lmxyy.mxcompiler.symbol;

public class Type {
    public enum Types {
        VOID,INT,BOOL,STRING,CLASS,NULL,UB
    }
    private Types type;
    private int dimension;

    public Type(Types _type,int _dimension) {
        type = _type;
        dimension = _dimension;
    }
    public Types getType() {
        return type;
    }
    public int getDimension() {
        return dimension;
    }
}
