package com.lmxyy.mxcompiler.ir;

import java.util.HashSet;
import java.util.Set;

public class BasicBlock {
    private Set<BasicBlock> pred = new HashSet<>(),succ = new HashSet<>();
    private Function parent; String hintName;
    private IRInstruction head,tail;
    private boolean ended;

    public BasicBlock(Function _parent,String _hintName) {
        parent = _parent;
        if (_hintName == null) hintName = "$block";
        else hintName = _hintName;
        head = tail = null;
    }

    public void append(IRInstruction node) {
        if (ended) {
             throw new RuntimeException("Cannot append instruction after a basic block ends.");
        }
        else if (tail != null) {
            tail.linkNxt(node);
            tail = node;
        }
        else head = tail = node;
    }

    public void end(EndInstruction ender) {
        if (ended) return;
        append(ender);
        ended = true;
        if (ender instanceof Jump)
            succ.add(((Jump) ender).getTarget());
    }
    public void cleanEnd(IRInstruction node) {
        if (!ended) return;
        ended = false;

    }

    public Set<BasicBlock> getPred() {
        return pred;
    }
    public Set<BasicBlock> getSucc() {
        return succ;
    }
    public Function getParent() {
        return parent;
    }
    public String getHintName() {
        return hintName;
    }
    public IRInstruction getHead() {
        return head;
    }
    public IRInstruction getTail() {
        return tail;
    }
    public boolean isEnded() {
        return ended;
    }

    @Override
    public String toString() {
        return hintName;
    }
}
