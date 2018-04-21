package com.lmxyy.mxcompiler.symbol;

import com.lmxyy.mxcompiler.ast.ExpressionNode;

public class ExprOperator {
    public enum Operator {
        SELF,
        MEM,
        ARRAY,
        SINC,
        SDEC,
        PINC,
        PDEC,
        NEG,
        NOT,
        COMP,
        NEW,
        TIMES,
        DIVIDE,
        MOD,
        ADD,
        SUB,
        LESH,
        RISH,
        LESS,
        LEQ,
        GRTR,
        GEQ,
        EQU,
        NEQ,
        BAND,
        XOR,
        BOR,
        LAND,
        LOR,
        TRN
    }
    private Operator op;

    public ExprOperator(Operator _op) {
        op = _op;
    }

    public Operator getOp() {
        return op;
    }
}
