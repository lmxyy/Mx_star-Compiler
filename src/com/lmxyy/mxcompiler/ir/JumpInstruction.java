package com.lmxyy.mxcompiler.ir;

public class JumpInstruction extends EndInstruction {
    private BasicBlock target;

    public JumpInstruction(BasicBlock _curBasicBlock, BasicBlock _target) {
        super(_curBasicBlock);
        target = _target;
    }

    public BasicBlock getTarget() {
        return target;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
