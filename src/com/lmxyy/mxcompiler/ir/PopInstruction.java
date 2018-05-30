package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class PopInstruction extends IRInstruction {

    private IntValue oprand;

    public PopInstruction(BasicBlock _basicBlock,IntValue _oprand) {
        super(_basicBlock);
        oprand = _oprand;
        reloadUsedRegisterCollection();
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
