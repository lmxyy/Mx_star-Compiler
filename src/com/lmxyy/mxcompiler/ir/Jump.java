package com.lmxyy.mxcompiler.ir;

public class Jump extends EndInstruction {
    private BasicBlock target;

    public Jump(BasicBlock _curBasicBlock,BasicBlock _target) {
        super(_curBasicBlock);
        target = _target;
    }

    public BasicBlock getTarget() {
        return target;
    }
}
