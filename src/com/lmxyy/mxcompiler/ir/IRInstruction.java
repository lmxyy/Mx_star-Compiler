package com.lmxyy.mxcompiler.ir;

public abstract class IRInstruction {
    private BasicBlock basicBlock;
    private IRInstruction pre,nxt;
    private boolean removed;

    public IRInstruction(BasicBlock _basicBlock) {
        basicBlock = _basicBlock;
        pre = null; nxt = null;
    }

    public void linkPre(IRInstruction node) {
        node.nxt = this;
        this.pre = node;
    }
    public void linkNxt(IRInstruction node) {
        node.pre = this;
        this.nxt = node;
    }

    public void remove() {
        assert removed == false;
        if (pre != null) pre.nxt = nxt;
        if (nxt != null) nxt.pre = pre;
        else basicBlock.cleanEnd(this);
        removed = true;
    }

    public BasicBlock getBasicBlock() {
        return basicBlock;
    }
    public IRInstruction getPre() {
        return pre;
    }
    public IRInstruction getNxt() {
        return nxt;
    }
    public boolean isRemoved() {
        return removed;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
