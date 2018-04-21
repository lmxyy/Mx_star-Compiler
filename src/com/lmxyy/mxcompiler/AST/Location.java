package com.lmxyy.mxcompiler.ast;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class Location {
    private final int row,col;

    public Location(int _row,int _col) {
        row = _row; col = _col;
    }

    public Location(Token token) {
        row = token.getLine();
        col = token.getCharPositionInLine();
    }
    static public Location fromCtx(ParserRuleContext ctx) {
        return new Location(ctx.getStart());
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
