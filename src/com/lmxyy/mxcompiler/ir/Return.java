package com.lmxyy.mxcompiler.ir;

public class Return extends Linker {
    private IntValue retVal;

    public Return(BasicBlock _curBasicBlock,IntValue _retVal) {
        super(_curBasicBlock);
        retVal = _retVal;
        _curBasicBlock.getParent().retInstruction.add(this);
    }

    public IntValue getRetVal() {
        return retVal;
    }
}
