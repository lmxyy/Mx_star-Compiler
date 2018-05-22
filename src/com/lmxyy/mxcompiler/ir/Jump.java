package com.lmxyy.mxcompiler.ir;

import com.lmxyy.mxcompiler.utils.Location;

public class Jump extends Linker {
    private BasicBlock target;

    public Jump(BasicBlock _curBasicBlock,BasicBlock _target) {
        super(_curBasicBlock);
        target = _target;
    }

    public BasicBlock getTarget() {
        return target;
    }
}
