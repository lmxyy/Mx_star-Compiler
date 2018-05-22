package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.SymbolTable;
import com.lmxyy.mxcompiler.utils.Location;

public abstract class Node {
    public SymbolTable scope;
    public Node() {}
    abstract public Location location();
    abstract public void accept(ASTVisitor visitor);
}
