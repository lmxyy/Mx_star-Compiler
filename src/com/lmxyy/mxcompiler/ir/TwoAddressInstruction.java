package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class TwoAddressInstruction extends IRInstruction {

    private BinaryOperationInstruction.Operator operator;
    private Register lhs; private IntValue rhs;

    public TwoAddressInstruction(
            BasicBlock _basicBlock, BinaryOperationInstruction.Operator _operator,
            Register _lhs, IntValue _rhs
    ) {
        super(_basicBlock);
        operator = _operator;
        lhs = _lhs;
        rhs = _rhs;
        reloadUsedRegisterCollection();
    }

    public BinaryOperationInstruction.Operator getOperator() {
        return operator;
    }

    public Register getLhs() {
        return lhs;
    }

    public IntValue getRhs() {
        return rhs;
    }

    @Override
    public void accept(IRVisitor visitor) { visitor.visit(this); }

    @Override
    protected void reloadUsedRegisterCollection() {
        usedRegister.clear();
        if (lhs instanceof Register) usedRegister.add((Register) lhs);
        if (rhs instanceof Register) usedRegister.add((Register) rhs);
        usedIntValue.clear();
        usedIntValue.add(lhs);
        usedIntValue.add(rhs);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
        lhs = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (lhs instanceof Register) lhs = regMap.get(lhs);
        if (rhs instanceof Register) rhs = regMap.get(rhs);
        reloadUsedRegisterCollection();
    }

    @Override
    public Register getDefinedRegister() {
        return lhs;
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue,IntValue newValue) {
        if (rhs == oldValue) rhs = newValue;
        reloadUsedRegisterCollection();
    }
}
