package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class CltdInstruction extends IRInstruction {
    public CltdInstruction(BasicBlock _basicBlock) {
        super(_basicBlock);
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
