package com.lmxyy.mxcompiler.ir;

public abstract class EndInstruction extends IRInstruction{
    public EndInstruction(BasicBlock _basicBlock) {
        super(_basicBlock);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
