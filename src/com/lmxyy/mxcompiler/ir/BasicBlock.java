package com.lmxyy.mxcompiler.ir;

import com.lmxyy.mxcompiler.backend.IRPrinter;

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

    private void addSucc(BasicBlock basicBlock) {
        if (basicBlock == null) return;
        succ.add(basicBlock);
        basicBlock.pred.add(this);
    }
    private void delSucc(BasicBlock basicBlock) {
        if (basicBlock == null) return;
        succ.remove(basicBlock);
        basicBlock.pred.remove(this);
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
        if (ender instanceof JumpInstruction) {
            addSucc(((JumpInstruction) ender).getTarget());
        }
        else if (ender instanceof ReturnInstruction) {
            parent.retInstruction.add((ReturnInstruction) ender);
        }
        else if (ender instanceof BranchInstruction) {
            addSucc(((BranchInstruction) ender).getIfTrue());
            addSucc(((BranchInstruction) ender).getIfFalse());
        }
        else {
            // Cannot reach here.
            assert false;
        }
    }
    public void cleanEnd() {
        if (!ended) return;
        ended = false;
        if (tail instanceof JumpInstruction) {
            delSucc(((JumpInstruction) tail).getTarget());
        }
        else if (tail instanceof ReturnInstruction) {
            parent.retInstruction.remove((ReturnInstruction) tail);
        }
        else if (tail instanceof BranchInstruction) {
            delSucc(((BranchInstruction) tail).getIfTrue());
            delSucc(((BranchInstruction) tail).getIfFalse());
        }
        else {
            // Cannot reach here.
            assert false;
        }
        if (head == tail) tail = head = null;
        else tail = tail.getPre();
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

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
