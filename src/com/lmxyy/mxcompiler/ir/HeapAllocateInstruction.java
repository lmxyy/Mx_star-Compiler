package com.lmxyy.mxcompiler.ir;

public class HeapAllocateInstruction extends IRInstruction {
    private Register dest;
    private IntValue allocSize;

    public HeapAllocateInstruction(BasicBlock _basicBlock,Register _dest,IntValue _allocSize) {
        super(_basicBlock);
        dest = _dest;
        allocSize = _allocSize;
    }

    public Register getDest() {
        return dest;
    }
    public IntValue getAllocSize() {
        return allocSize;
    }
}
