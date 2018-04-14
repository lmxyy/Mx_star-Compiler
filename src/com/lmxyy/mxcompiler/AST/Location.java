package com.lmxyy.mxcompiler.ast;

public class Location {
    private final int row,col;

    public Location(int _row,int _col) {
        row = _row; col = _col;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    @Override
    public String toString(){
        return String.format("(%d:%d)",row,col);
    }
}
