package com.lmxyy.mxcompiler.ir;

public class OperationInstruction extends IRInstruction {
    public enum Operator {
        ADD, SUB, MUL, DIV, MOD,
        SHL, SHR, AND, OR, XOR
    }

    private Register dest;
    private Operator operator;
    private IntValue lhs,rhs;

    public OperationInstruction(BasicBlock _basicBlock,Register _dest,Operator _operator,IntValue _lhs,IntValue _rhs) {
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
}
