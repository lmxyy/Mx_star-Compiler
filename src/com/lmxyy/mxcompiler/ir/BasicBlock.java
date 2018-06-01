package com.lmxyy.mxcompiler.ir;

import com.lmxyy.mxcompiler.nasm.NASMRegisterSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.lmxyy.mxcompiler.ir.BinaryOperationInstruction.Operator.*;

public class BasicBlock {
    private Set<BasicBlock> pred = new HashSet<>(),succ = new HashSet<>();
    private Function parent; String hintName;
    private IRInstruction head,tail;
    private boolean ended;

    public BasicBlock(Function _parent,String _hintName) {
        parent = _parent;
        if (_hintName == null) hintName = "block";
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

    public void transform() {
        ended = false;
        List<IRInstruction> instructions = new ArrayList<>();
        for (IRInstruction inst = head;inst != null;inst = inst.getNxt()) {
            instructions.add(inst);
        }
        head = tail = null;
        instructions.forEach(instruction -> {
            if (instruction instanceof BinaryOperationInstruction) {
                switch (((BinaryOperationInstruction) instruction).getOperator()) {
                    case DIV:
                        append(new MoveInstruction(
                            this,((BinaryOperationInstruction) instruction).getLhs(),
                            NASMRegisterSet.RAX
                        ));
                        append(new CqoInstruction(this));
                        append(new TwoAddressInstruction(
                                this,((BinaryOperationInstruction) instruction).getOperator(),
                                ((BinaryOperationInstruction) instruction).getDest(),
                                ((BinaryOperationInstruction) instruction).getRhs())
                        );
                        append(new MoveInstruction(
                                this, NASMRegisterSet.RAX,
                                ((BinaryOperationInstruction) instruction).getDest()
                        ));
                        break;
                    case MOD:
                        append(new MoveInstruction(
                                this,((BinaryOperationInstruction) instruction).getLhs(),
                                NASMRegisterSet.RAX
                        ));
                        append(new CqoInstruction(this));
                        append(new TwoAddressInstruction(
                                this,((BinaryOperationInstruction) instruction).getOperator(),
                                ((BinaryOperationInstruction) instruction).getDest(),
                                ((BinaryOperationInstruction) instruction).getRhs())
                        );
                        append(new MoveInstruction(
                                this, NASMRegisterSet.RDX,
                                ((BinaryOperationInstruction) instruction).getDest()
                        ));
                        break;
                    case LEQ:
                        if (((BinaryOperationInstruction) instruction).getLhs() instanceof IntImmediate) {
                            append(new ComparisionInstruction(
                                    this,((BinaryOperationInstruction) instruction).getDest(), GEQ,
                                    ((BinaryOperationInstruction) instruction).getRhs(),
                                    ((BinaryOperationInstruction) instruction).getLhs())
                            );
                        }
                        else append(new ComparisionInstruction(
                                this,((BinaryOperationInstruction) instruction).getDest(), LEQ,
                                ((BinaryOperationInstruction) instruction).getLhs(),
                                ((BinaryOperationInstruction) instruction).getRhs())
                        );

                        break;
                    case GEQ:
                        if (((BinaryOperationInstruction) instruction).getLhs() instanceof IntImmediate) {
                            append(new ComparisionInstruction(
                                    this,((BinaryOperationInstruction) instruction).getDest(), LEQ,
                                    ((BinaryOperationInstruction) instruction).getRhs(),
                                    ((BinaryOperationInstruction) instruction).getLhs())
                            );
                        }
                        else append(new ComparisionInstruction(
                                this,((BinaryOperationInstruction) instruction).getDest(), GEQ,
                                ((BinaryOperationInstruction) instruction).getLhs(),
                                ((BinaryOperationInstruction) instruction).getRhs())
                        );
                        break;
                    case LESS:
                        if (((BinaryOperationInstruction) instruction).getLhs() instanceof IntImmediate) {
                            append(new ComparisionInstruction(
                                    this,((BinaryOperationInstruction) instruction).getDest(), GRTR,
                                    ((BinaryOperationInstruction) instruction).getRhs(),
                                    ((BinaryOperationInstruction) instruction).getLhs())
                            );
                        }
                        else append(instruction);
                        break;
                    case GRTR:
                        if (((BinaryOperationInstruction) instruction).getLhs() instanceof IntImmediate) {
                            append(new ComparisionInstruction(
                                    this,((BinaryOperationInstruction) instruction).getDest(), LESS,
                                    ((BinaryOperationInstruction) instruction).getRhs(),
                                    ((BinaryOperationInstruction) instruction).getLhs())
                            );
                        }
                        else append(instruction);
                        break;
                    case EQU: case NEQ:
                        if (((BinaryOperationInstruction) instruction).getLhs() instanceof IntImmediate) {
                            append(new ComparisionInstruction(
                                    this,((BinaryOperationInstruction) instruction).getDest(),
                                    ((BinaryOperationInstruction) instruction).getOperator(),
                                    ((BinaryOperationInstruction) instruction).getRhs(),
                                    ((BinaryOperationInstruction) instruction).getLhs())
                            );
                        }
                        else append(instruction);
                        break;
                    default:
                        IntValue lhs = ((BinaryOperationInstruction) instruction).getLhs(),
                                rhs = ((BinaryOperationInstruction) instruction).getRhs();
                        if (lhs instanceof IntImmediate) {
                            lhs = ((BinaryOperationInstruction) instruction).getRhs();
                            rhs = ((BinaryOperationInstruction) instruction).getLhs();
                        }
                        if (lhs == ((BinaryOperationInstruction) instruction).getDest()) {
                            append(new TwoAddressInstruction(
                                    this, ((BinaryOperationInstruction) instruction).getOperator(),
                                    (Register) lhs, rhs));
                        }
                        else if (rhs == ((BinaryOperationInstruction) instruction).getDest()) {
                            append(new TwoAddressInstruction(
                                    this, ((BinaryOperationInstruction) instruction).getOperator(),
                                    (Register) rhs, lhs));
                        }
                        else {
                            VirtualRegister reg = new VirtualRegister(null);
                            append(new MoveInstruction(this, lhs, reg));
                            append(new TwoAddressInstruction(
                                    this, ((BinaryOperationInstruction) instruction).getOperator(),
                                    (Register) lhs, rhs));
                            append(new MoveInstruction(this, lhs,
                                    ((BinaryOperationInstruction) instruction).getDest()));
                            append(new MoveInstruction(this, reg, (Register) lhs));
                            break;
                        }
                }
            }
            else if (instruction instanceof UnaryOperationInstruction) {
                VirtualRegister reg = new VirtualRegister(null);
                IntValue oprand = ((UnaryOperationInstruction) instruction).getOprand();
                Register dest = ((UnaryOperationInstruction) instruction).getDest();
                append(new MoveInstruction(this,oprand,reg));
                append(new UnaryOperationInstruction(this,reg,
                        ((UnaryOperationInstruction) instruction).getOperator(),reg
                ));
                if (!(oprand instanceof IntImmediate))
                    append(new MoveInstruction(this,reg,(Register) oprand));
            }
            else append(instruction);
        });
        ended = true;
    }

    public void setHead(IRInstruction _head) {
        head = _head;
    }
    public void setTail(IRInstruction _tail) {
        tail = _tail;
    }
}
