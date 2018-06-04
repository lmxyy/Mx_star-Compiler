package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class MoveInstruction extends IRInstruction {
    private IntValue source;
    private Register dest;
    private boolean canRemove;

    public MoveInstruction(BasicBlock _curBasicBlock, IntValue _source, Register _dest) {
        super(_curBasicBlock);
        source = _source;
        dest = _dest;
        reloadUsedRegisterCollection();
        canRemove = false;
    }
    public MoveInstruction(BasicBlock _curBasicBlock, IntValue _source, Register _dest,boolean _canRemove) {
        super(_curBasicBlock);
        source = _source;
        dest = _dest;
        reloadUsedRegisterCollection();
        canRemove = _canRemove;
    }

    public IntValue getSource() {
        return source;
    }
    public Register getDest() {
        return dest;
    }
    public boolean isCanRemove() {
        return canRemove;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    protected void reloadUsedRegisterCollection() {
        usedRegister.clear();
        if (source instanceof Register) usedRegister.add((Register) source);
        usedIntValue.clear();
        usedIntValue.add(source);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
        dest = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (source instanceof Register) source = regMap.get(source);
        reloadUsedRegisterCollection();
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue,IntValue newValue) {
        if (source == oldValue) source = newValue;
        reloadUsedRegisterCollection();
    }
}
