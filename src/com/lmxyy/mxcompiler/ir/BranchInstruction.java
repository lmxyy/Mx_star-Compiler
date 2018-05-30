package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class BranchInstruction extends EndInstruction {
    private IntValue indicator;
    private BasicBlock ifTrue,ifFalse;

    public BranchInstruction(BasicBlock _basicBlock,IntValue _indicator,BasicBlock _ifTrue,BasicBlock _ifFalse) {
        super(_basicBlock);
        indicator = _indicator;
        ifTrue = _ifTrue;
        ifFalse = _ifFalse;
        reloadUsedRegisterCollection();
    }

    public IntValue getIndicator() {
        return indicator;
    }
    public BasicBlock getIfTrue() {
        return ifTrue;
    }
    public BasicBlock getIfFalse() {
        return ifFalse;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    protected void reloadUsedRegisterCollection() {
        usedRegister.clear();
        if (indicator instanceof Register) usedRegister.add((Register) indicator);
        usedIntValue.clear();
        usedIntValue.add(indicator);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (indicator instanceof Register) indicator = regMap.get(indicator);
        reloadUsedRegisterCollection();
    }

    @Override
    public Register getDefinedRegister() {
        return null;
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue,IntValue newValue) {
        if (indicator == oldValue) indicator = newValue;
        reloadUsedRegisterCollection();
    }
}
