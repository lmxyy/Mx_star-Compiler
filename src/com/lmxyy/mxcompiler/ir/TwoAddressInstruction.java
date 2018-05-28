package com.lmxyy.mxcompiler.ir;

public class TwoAddressInstruction extends IRInstruction {

    private BinaryOperationInstruction.Operator operator;
    private Register lhs; private IntValue rhs;

    public TwoAddressInstruction(
            BasicBlock _basicBlock, BinaryOperationInstruction.Operator _operator,
            Register _lhs, IntValue _rhs
    ) {
        super(_basicBlock);
        operator = _operator;
        lhs = _lhs;
        rhs = _rhs;
    }

    @Override
    public void accept(IRVisitor visitor) { visitor.visit(this); }
}
