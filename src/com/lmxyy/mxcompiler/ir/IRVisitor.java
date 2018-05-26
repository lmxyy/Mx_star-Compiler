package com.lmxyy.mxcompiler.ir;


public interface IRVisitor {
    void visit(IRRoot node);
    void visit(BasicBlock node);
    void visit(Function node);

    void visit(IRInstruction node);
    void visit(ArithmeticInstruction node);
    void visit(UnaryOperationInstruction node);
    void visit(ComparisionInstruction node);
    void visit(CallInstruction node);
    void visit(BinaryOperationInstruction node);
    void visit(BranchInstruction node);
    void visit(HeapAllocateInstruction node);
    void visit(JumpInstruction node);
    void visit(LoadInstruction node);
    void visit(MoveInstruction node);
    void visit(StoreInstruction node);
    void visit(EndInstruction node);

    void visit(IntValue node);
    void visit(VirtualRegister node);
    void visit(PhysicalRegister node);
    void visit(StaticSpace node);
    void visit(StaticString node);
    void visit(IntImmediate node);
}
