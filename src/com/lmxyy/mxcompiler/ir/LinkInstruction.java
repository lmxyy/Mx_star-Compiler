package com.lmxyy.mxcompiler.ir;

public abstract class LinkInstruction extends IRInstruction{
    public LinkInstruction(BasicBlock _basicBlock) {
        super(_basicBlock);
    }
}
