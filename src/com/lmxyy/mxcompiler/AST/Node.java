package com.lmxyy.mxcompiler.ast;

public abstract class Node {
    public Node() {}
    abstract public Location location();
    abstract public void accept(Visitor vistor);
}
