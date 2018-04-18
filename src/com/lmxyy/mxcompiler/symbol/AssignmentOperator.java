package com.lmxyy.mxcompiler.symbol;

public class AssignmentOperator {
    public enum Operator {
        INC,DEC,ASS
    }
    private Operator op;

    public AssignmentOperator(Operator _op) {
        op = _op;
    }

    public Operator getOp() {
        return op;
    }
}
