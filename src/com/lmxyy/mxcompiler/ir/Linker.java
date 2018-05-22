package com.lmxyy.mxcompiler.ir;

public abstract class Linker extends IRInstruction{
    public Linker(BasicBlock _basicBlock) {
        super(_basicBlock);
    }
}
