package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class UnaryOperationInstruction extends IRInstruction {
    public enum Operator {
        NEG,COMP;
    }

    private Register dest;
    private Operator operator;
    private IntValue oprand;

    public UnaryOperationInstruction(BasicBlock _basicBlock,Register _dest,Operator _operator,IntValue _oprand) {
        super(_basicBlock);
        dest = _dest;
        operator = _operator;
        oprand = _oprand;
        reloadUsedRegisterCollection();
    }

    public Register getDest() {
        return dest;
    }
    public Operator getOperator() {
        return operator;
    }
    public IntValue getOprand() {
        return oprand;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    protected void reloadUsedRegisterCollection() {
        usedRegister.clear();
        if (oprand instanceof Register) usedRegister.add((Register) oprand);
        usedIntValue.clear();
        usedIntValue.add(dest);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
        dest = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (oprand instanceof Register) oprand = regMap.get(oprand);
        reloadUsedRegisterCollection();
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue,IntValue newValue) {
        if (oprand == oldValue) oprand = newValue;
        reloadUsedRegisterCollection();
    }
}
