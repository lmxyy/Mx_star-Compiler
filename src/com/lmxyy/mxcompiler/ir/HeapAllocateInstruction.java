package com.lmxyy.mxcompiler.ir;

import java.util.Map;

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

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    protected void reloadUsedRegisterCollection() {
        usedRegister.clear();
        if (allocSize instanceof Register) usedRegister.add((Register) allocSize);
        usedIntValue.clear();
        usedIntValue.add(allocSize);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
        dest = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (allocSize instanceof Register) allocSize = regMap.get(allocSize);
        reloadUsedRegisterCollection();
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue,IntValue newValue) {
        if (allocSize == oldValue) allocSize = newValue;
        reloadUsedRegisterCollection();
    }
}
