package com.lmxyy.mxcompiler.ir;

public class Move extends IRInstruction {
    IntValue source; Register dest;

    public Move(BasicBlock _curBasicBlock,IntValue _source,Register _dest) {
        super(_curBasicBlock);
        source = _source;
        dest = _dest;
    }

    public IntValue getSource() {
        return source;
    }
    public Register getDest() {
        return dest;
    }
}
