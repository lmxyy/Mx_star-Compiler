package com.lmxyy.mxcompiler.ir;

public class Branch extends Linker {
    public BasicBlock trueTarget,falseTarget;

    public Branch(BasicBlock _curBasicBlock,BasicBlock _trueTarget,BasicBlock _falseTarget) {
        super(_curBasicBlock);
        trueTarget = _trueTarget;
        falseTarget = _falseTarget;
    }

    public BasicBlock getTrueTarget() {
        return trueTarget;
    }
    public BasicBlock getFalseTarget() {
        return falseTarget;
    }
}
