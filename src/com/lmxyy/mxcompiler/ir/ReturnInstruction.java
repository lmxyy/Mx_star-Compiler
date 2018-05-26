package com.lmxyy.mxcompiler.ir;

public class ReturnInstruction extends EndInstruction {
    private IntValue retVal;

    public ReturnInstruction(BasicBlock _curBasicBlock,IntValue _retVal) {
        super(_curBasicBlock);
        retVal = _retVal;
        _curBasicBlock.getParent().retInstruction.add(this);
    }

    public IntValue getRetVal() {
        return retVal;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
