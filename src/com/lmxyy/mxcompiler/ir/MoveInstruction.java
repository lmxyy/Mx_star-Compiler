package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class MoveInstruction extends IRInstruction {
    private IntValue source;
    private Register dest;
    private MoveInstruction parentInst = null;

    public MoveInstruction(BasicBlock _curBasicBlock, IntValue _source, Register _dest) {
        super(_curBasicBlock);
        source = _source;
        dest = _dest;
        reloadUsedRegisterCollection();
    }
    public MoveInstruction(BasicBlock _curBasicBlock, IntValue _source, Register _dest,MoveInstruction _parentInst) {
        super(_curBasicBlock);
        source = _source;
        dest = _dest;
        reloadUsedRegisterCollection();
        parentInst = _parentInst;
    }

    public IntValue getSource() {
        return source;
    }
    public Register getDest() {
        return dest;
    }

    public void setSource(IntValue _source) {
        source = _source;
    }

    public MoveInstruction getParentInst() {
        return parentInst;
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

    @Override
    public IRInstruction copyAndRename(Map<Object, Object> renameMap) {
        return new MoveInstruction(
                (BasicBlock) renameMap.getOrDefault(basicBlock,basicBlock),
                (IntValue) renameMap.getOrDefault(source,source),
                (Register) renameMap.getOrDefault(dest,dest)
        );
    }
}
