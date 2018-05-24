package com.lmxyy.mxcompiler.ir;

public class ArithmeticInstruction extends BinaryOperationInstruction {
    public ArithmeticInstruction(BasicBlock _basicBlock,Register _dest,Operator _operator, IntValue _lhs,IntValue _rhs) {
        super(_basicBlock,_dest,_operator,_lhs,_rhs);
    }
}
