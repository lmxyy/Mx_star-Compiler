package com.lmxyy.mxcompiler.ir;

public class StoreInstruction extends IRInstruction {
    private IntValue addr;
    private int offset;
    private int size;
    private IntValue value;

    public StoreInstruction(BasicBlock _basicBlock,IntValue _addr,int _offset,int _size,IntValue _value) {
        super(_basicBlock);
        addr = _addr;
        offset = _offset;
        size = _size;
        value = _value;
    }

    public IntValue getAddr() {
        return addr;
    }
    public int getOffset() {
        return offset;
    }
    public int getSize() {
        return size;
    }
    public IntValue getValue() {
        return value;
    }
}
