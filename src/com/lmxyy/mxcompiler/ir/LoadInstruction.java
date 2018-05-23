package com.lmxyy.mxcompiler.ir;

public class LoadInstruction extends IRInstruction {
    private Register dest;
    private int size;
    private IntValue addr;
    private int offset;

    public LoadInstruction(BasicBlock _basicBlock, Register _dest, int _size, IntValue _addr, int _offset) {
        super(_basicBlock);
        dest = _dest;
        size = _size;
        addr = _addr;
        offset = _offset;
    }

    public Register getDest() {
        return dest;
    }

    public int getSize() {
        return size;
    }

    public IntValue getAddr() {
        return addr;
    }
    public int getOffset() {
        return offset;
    }
}
