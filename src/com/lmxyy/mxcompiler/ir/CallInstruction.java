package com.lmxyy.mxcompiler.ir;

import java.util.ArrayList;
import java.util.List;

public class CallInstruction extends IRInstruction {
    private VirtualRegister register;
    private Function function;
    private List<IntValue> argArgRegList = new ArrayList<>();

    public CallInstruction(BasicBlock _basicBlock, VirtualRegister _register, Function _function) {
        super(_basicBlock);
        register = _register;
        function = _function;
    }

    public void appendArgReg(IntValue reg) {
        argArgRegList.add(reg);
    }

    public VirtualRegister getRegister() {
        return register;
    }
    public Function getFunction() {
        return function;
    }
    public List<IntValue> getArgArgRegList() {
        return argArgRegList;
    }
}
