package com.lmxyy.mxcompiler.ir;

import java.util.*;

public abstract class IRInstruction {
    private BasicBlock basicBlock;
    private IRInstruction pre,nxt;
    protected List<Register> usedRegister = new ArrayList<>();
    protected List<IntValue> usedIntValue = new ArrayList<>();
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
        else basicBlock.cleanEnd();
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

    public void prepend(IRInstruction node) {
        if (pre != null) pre.linkNxt(node);
        else basicBlock.setHead(node);
        node.linkPre(this);
    }
    public void append(IRInstruction node) {
        if (nxt != null) nxt.linkPre(node);
        else basicBlock.setTail(node);
        node.linkNxt(this);
    }

    public final Collection<Register> getUsedRegister() {
        return Collections.unmodifiableCollection(usedRegister);
    }

    public final Collection<IntValue> getUsedIntValue() {
        return Collections.unmodifiableCollection(usedIntValue);
    }

    public abstract void accept(IRVisitor visitor);
    protected abstract void reloadUsedRegisterCollection();
    public abstract Register getDefinedRegister();
    public abstract void setDefinedRegister(Register newReg);
    public abstract void setUsedRegister(Map<Register, Register> regMap);
    public abstract void replaceIntValueUse(IntValue oldValue,IntValue newValue);
}
