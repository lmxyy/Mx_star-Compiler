package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public abstract class BinaryOperationInstruction extends IRInstruction {
    public enum Operator {
        ADD, SUB, MUL, DIV, MOD,
        SHL, SHR, AND, OR, XOR,
        EQU, NEQ, LESS, GRTR, LEQ, GEQ
    }

    private Register dest;
    private Operator operator;
    private IntValue lhs,rhs;

    public BinaryOperationInstruction(BasicBlock _basicBlock,Register _dest,Operator _operator, IntValue _lhs,IntValue _rhs) {
        super(_basicBlock);
        dest = _dest;
        operator = _operator;
        lhs = _lhs;
        rhs = _rhs;
    }

    public Register getDest() {
        return dest;
    }
    public Operator getOperator() {
        return operator;
    }
    public IntValue getLhs() {
        return lhs;
    }
    public IntValue getRhs() {
        return rhs;
    }

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
        dest = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (lhs instanceof Register) lhs = regMap.get(lhs);
        if (rhs instanceof Register) rhs = regMap.get(rhs);
        reloadUsedRegisterCollection();
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue,IntValue newValue) {
        if (lhs == oldValue) lhs = newValue;
        if (rhs == oldValue) rhs = newValue;
        reloadUsedRegisterCollection();
    }

    public abstract void accept(IRVisitor visitor);
}
