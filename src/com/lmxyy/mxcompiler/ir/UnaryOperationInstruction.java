package com.lmxyy.mxcompiler.ir;

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
}
