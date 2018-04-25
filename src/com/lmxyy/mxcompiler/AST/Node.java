package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.SymbolTable;

public abstract class Node {
    public SymbolTable scope;
    public Node() {}
    abstract public Location location();
    abstract public void accept(Visitor visitor);
}
