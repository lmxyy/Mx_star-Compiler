package com.lmxyy.mxcompiler.ir;

public class BranchInstruction extends EndInstruction {
    private IntValue indicator;
    private BasicBlock ifTrue,ifFalse;

    public BranchInstruction(BasicBlock _basicBlock,IntValue _indicator,BasicBlock _ifTrue,BasicBlock _ifFalse) {
        super(_basicBlock);
        indicator = _indicator;
        ifTrue = _ifTrue;
        ifFalse = _ifFalse;
    }

    public IntValue getIndicator() {
        return indicator;
    }
    public BasicBlock getIfTrue() {
        return ifTrue;
    }
    public BasicBlock getIfFalse() {
        return ifFalse;
    }
}
