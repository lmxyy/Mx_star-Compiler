package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class StoreInstruction extends IRInstruction {
    private IntValue addr;
    private int offset;
    private int size;
    private IntValue value;
    private boolean isStaticData;

    public StoreInstruction(BasicBlock _basicBlock,IntValue _addr,int _offset,int _size,IntValue _value) {
        super(_basicBlock);
        addr = _addr;
        offset = _offset;
        size = _size;
        value = _value;
        isStaticData = false;
        reloadUsedRegisterCollection();
    }
    public StoreInstruction(BasicBlock _basicBlock,IntValue _value,int _size,StaticData _addr) {
        this(_basicBlock,_addr,0,_size,_value);
        isStaticData = true;
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

    public void setAddr(IntValue _addr) {
        addr = _addr;
    }
    public void setOffset(int _offset) {
        offset = _offset;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    protected void reloadUsedRegisterCollection() {
        usedRegister.clear();
        if (addr instanceof Register) usedRegister.add((Register) addr);
        if (value instanceof Register) usedRegister.add((Register) value);
        usedIntValue.clear();
        usedIntValue.add(addr);
        usedIntValue.add(value);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (addr instanceof Register) addr = regMap.get(addr);
        if (value instanceof Register) value = regMap.get(value);
        reloadUsedRegisterCollection();
    }

    @Override
    public Register getDefinedRegister() {
        return null;
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue,IntValue newValue) {
        if (addr == oldValue) addr = newValue;
        if (value == oldValue) addr = newValue;
        reloadUsedRegisterCollection();
    }
}
