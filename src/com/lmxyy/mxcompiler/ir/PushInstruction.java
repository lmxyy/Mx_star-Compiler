package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class PushInstruction extends IRInstruction {
    private IntValue oprand;
    private boolean isAddress = false;
    private int offset;

    public PushInstruction(BasicBlock _basicBlock,IntValue _oprand) {
        super(_basicBlock);
        oprand = _oprand;
    }

    public PushInstruction(BasicBlock _basicBlock,IntValue _oprand,int _offset) {
        this(_basicBlock,_oprand);
        offset = _offset;
        isAddress = true;
    }

    public IntValue getOprand() {
        return oprand;
    }

    public boolean isAddress() {
        return isAddress;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    protected void reloadUsedRegisterCollection() {
    }

    @Override
    public void setDefinedRegister(Register newReg) {
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
    }

    @Override
    public Register getDefinedRegister() {
        return null;
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue,IntValue newValue) {
    }
}
