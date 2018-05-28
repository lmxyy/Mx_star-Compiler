package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class JumpInstruction extends EndInstruction {
    private BasicBlock target;

    public JumpInstruction(BasicBlock _curBasicBlock, BasicBlock _target) {
        super(_curBasicBlock);
        target = _target;
    }

    public BasicBlock getTarget() {
        return target;
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
