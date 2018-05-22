package com.lmxyy.mxcompiler.ir;

public interface IRVisitor {
    void visit(IRRoot node);
    void visit(BasicBlock node);
    void visit(Function node);
    void visit(IRInstruction node);
}
