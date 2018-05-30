package com.lmxyy.mxcompiler.ir;

public class ComparisionInstruction extends BinaryOperationInstruction {
    public ComparisionInstruction(BasicBlock _basicBlock,Register _dest,Operator _operator, IntValue _lhs,IntValue _rhs) {
        super(_basicBlock,_dest,_operator,_lhs,_rhs);
        reloadUsedRegisterCollection();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
