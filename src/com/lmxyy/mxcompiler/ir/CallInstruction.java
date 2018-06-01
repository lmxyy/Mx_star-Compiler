package com.lmxyy.mxcompiler.ir;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CallInstruction extends IRInstruction {
    private Register register;
    private Function function;
    private List<IntValue> argRegList = new ArrayList<>();

    public CallInstruction(BasicBlock _basicBlock, VirtualRegister _register, Function _function) {
        super(_basicBlock);
        register = _register;
        function = _function;
        reloadUsedRegisterCollection();
    }

    public void appendArgReg(IntValue reg) {
        argRegList.add(reg);
    }

    public Register getRegister() {
        return register;
    }
    public Function getFunction() {
        return function;
    }
    public List<IntValue> getArgRegList() {
        return argRegList;
    }
    public void callReloadUsedRegisterCollection() {
        reloadUsedRegisterCollection();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    protected void reloadUsedRegisterCollection() {
        usedRegister.clear();
        for (IntValue arg : argRegList) {
            if (arg instanceof Register)
                usedRegister.add((Register) arg);
        }
        usedIntValue.clear();
        for (IntValue arg : argRegList) {
            if (arg instanceof IntValue)
                usedIntValue.add(arg);
        }
    }

    @Override
    public void setDefinedRegister(Register newReg) {
        register = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        for (int i = 0; i < argRegList.size(); ++i)
            if (argRegList.get(i) instanceof Register) {
                argRegList.set(i, regMap.get(argRegList.get(i)));
            }
        reloadUsedRegisterCollection();
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue,IntValue newValue) {
        for (int i = 0; i < argRegList.size(); ++i)
            if (argRegList.get(i) == oldValue)
                argRegList.set(i, newValue);
        reloadUsedRegisterCollection();
    }

    @Override
    public Register getDefinedRegister() {
        return register;
    }
}
