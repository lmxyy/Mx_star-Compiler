package com.lmxyy.mxcompiler.ast;

public interface Visitor {
    void visit(DefunNode node);
    void visit(DefvarNode node);
    void visit(DefclassNode node);
    void visit(VartypeNode node);
}
