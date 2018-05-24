package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;

import java.io.PrintStream;

public class IRPrinter implements IRVisitor {
    private PrintStream out;

    public IRPrinter(PrintStream _out) {
        out = _out;
    }

    @Override
    public void visit(IRRoot node) {

    }

    @Override
    public void visit(BasicBlock node) {

    }

    @Override
    public void visit(Function node) {

    }

    @Override
    public void visit(ArithmeticInstruction node) {

    }

    @Override
    public void visit(UnaryOperationInstruction node) {

    }

    @Override
    public void visit(ComparisionInstruction node) {

    }

    @Override
    public void visit(CallInstruction node) {

    }

    @Override
    public void visit(BinaryOperationInstruction node) {

    }

    @Override
    public void visit(BranchInstruction node) {

    }

    @Override
    public void visit(HeapAllocateInstruction node) {

    }

    @Override
    public void visit(JumpInstruction node) {

    }

    @Override
    public void visit(LoadInstruction node) {

    }

    @Override
    public void visit(MoveInstruction node) {

    }

    @Override
    public void visit(StoreInstruction node) {

    }

    @Override
    public void visit(VirtualRegister node) {

    }

    @Override
    public void visit(PhysicalRegister node) {

    }

    @Override
    public void visit(StaticSpace node) {

    }

    @Override
    public void visit(StaticString node) {

    }

    @Override
    public void visit(IntImmediate node) {

    }
}
