package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;

import java.util.HashMap;
import java.util.Map;

public class ConstantFolder {
    private IRRoot irRoot;
    public ConstantFolder(IRRoot _irRoot) {
        irRoot = _irRoot;
    }

    Map<IntValue,Integer> ivMap = new HashMap<>();

    private void processFunc(Function func) {
        for (BasicBlock basicBlock:func.getReversePreOrder()) {
            ivMap.clear();
            for (IRInstruction inst = basicBlock.getHead(); inst != null; inst = inst.getNxt()) {
                if (inst instanceof CallInstruction)
                    ((CallInstruction) inst).callReloadUsedRegisterCollection();
                inst.getUsedIntValue().forEach(v->{
                    if (v instanceof IntImmediate) {
                        ivMap.put(v,((IntImmediate) v).getVal());
                    }
                });
                if (inst instanceof BranchInstruction) {
                    Integer t = ivMap.get(((BranchInstruction) inst).getIndicator());
                    if (t != null) {
                        inst.remove();
                        if (t == 0) {
                            basicBlock.end(new JumpInstruction(basicBlock,((BranchInstruction) inst).getIfFalse()));
                        }
                        else {
                            basicBlock.end(new JumpInstruction(basicBlock,((BranchInstruction) inst).getIfTrue()));
                        }
                    }
                }
                else if (inst instanceof ReturnInstruction) {
                    Integer t = ivMap.get(((ReturnInstruction) inst).getRetVal());
                    if (t != null) {
                        ((ReturnInstruction) inst).setRetVal(new IntImmediate(t));
                    }
                }
                else if (inst instanceof JumpInstruction) {
                    // Do nothing here
                }
                else if (inst instanceof CallInstruction) {
                    CallInstruction call = (CallInstruction) inst;
                    for (int i = 0;i < call.argRegList.size();++i) {
                        Integer t = ivMap.get(call.argRegList.get(i));
                        if (t !=  null)
                            call.argRegList.set(i,new IntImmediate(t));
                    }
                    if (call.getDefinedRegister() != null) {
                        ivMap.put(call.getDefinedRegister(),null);
                    }
                }
                else if (inst instanceof HeapAllocateInstruction) {
                    Integer t = ivMap.get(((HeapAllocateInstruction) inst).getAllocSize());
                    if (t != null) {
                        ((HeapAllocateInstruction) inst).setAllocSize(new IntImmediate(t));
                    }
                    ivMap.put(inst.getDefinedRegister(),null);
                }
                else if (inst instanceof ArithmeticInstruction) {
                    ArithmeticInstruction ai = (ArithmeticInstruction) inst;
                    Integer t1 = ivMap.get(ai.getLhs());
                    Integer t2 = ivMap.get(ai.getRhs());
                    if (t1 != null) {
                        ai.setLhs(new IntImmediate(t1));
                    }
                    if (t2 != null) {
                        ai.setRhs(new IntImmediate(t2));
                    }
                    if (ai.getLhs() instanceof IntImmediate&&ai.getRhs() instanceof IntImmediate) {
                        switch (ai.getOperator()) {
                            case ADD:
                                ai.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1+t2),
                                        ai.getDefinedRegister()
                                ));
                                ivMap.put(ai.getDefinedRegister(),t1+t2);
                                ai.remove();
                                break;
                            case SUB:
                                ai.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1-t2),
                                        ai.getDefinedRegister()
                                ));
                                ivMap.put(ai.getDefinedRegister(),t1-t2);
                                ai.remove();
                                break;
                            case MUL:
                                ai.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1*t2),
                                        ai.getDefinedRegister()
                                ));
                                ivMap.put(ai.getDefinedRegister(),t1*t2);
                                ai.remove();
                                break;
                            case DIV:
                                if (t2 != 0) {
                                    ai.prepend(new MoveInstruction(
                                            basicBlock, new IntImmediate(t1 / t2),
                                            ai.getDefinedRegister()
                                    ));
                                    ivMap.put(ai.getDefinedRegister(), t1 / t2);
                                    ai.remove();
                                }
                                else ivMap.put(ai.getDefinedRegister(),null);
                                break;
                            case MOD:
                                if (t2 != 0) {
                                    ai.prepend(new MoveInstruction(
                                            basicBlock, new IntImmediate(t1 % t2),
                                            ai.getDefinedRegister()
                                    ));
                                    ivMap.put(ai.getDefinedRegister(), t1 % t2);
                                    ai.remove();
                                }
                                else ivMap.put(ai.getDefinedRegister(),null);
                                break;
                            case SHL:
                                ai.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1<<t2),
                                        ai.getDefinedRegister()
                                ));
                                ivMap.put(ai.getDefinedRegister(),t1<<t2);
                                ai.remove();
                                break;
                            case SHR:
                                ai.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1>>t2),
                                        ai.getDefinedRegister()
                                ));
                                ivMap.put(ai.getDefinedRegister(),t1>>t2);
                                ai.remove();
                                break;
                            case AND:
                                ai.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1&t2),
                                        ai.getDefinedRegister()
                                ));
                                ivMap.put(ai.getDefinedRegister(),t1&t2);
                                ai.remove();
                                break;
                            case OR:
                                ai.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1|t2),
                                        ai.getDefinedRegister()
                                ));
                                ivMap.put(ai.getDefinedRegister(),t1|t2);
                                ai.remove();
                                break;
                            case XOR:
                                ai.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1^t2),
                                        ai.getDefinedRegister()
                                ));
                                ivMap.put(ai.getDefinedRegister(),t1^t2);
                                ai.remove();
                                break;
                            default:
                                System.err.println("Unknow operator of arithmetic instruction in constant folder.");
                                break;
                        }
                    }
                    else {
                        ivMap.put(inst.getDefinedRegister(),null);
                    }
                }
                else if (inst instanceof ComparisionInstruction) {
                    ComparisionInstruction ci = (ComparisionInstruction) inst;
                    Integer t1 = ivMap.get(ci.getLhs());
                    Integer t2 = ivMap.get(ci.getRhs());
                    if (t1 != null) {
                        ci.setLhs(new IntImmediate(t1));
                    }
                    if (t2 != null) {
                        ci.setRhs(new IntImmediate(t2));
                    }
                    if (ci.getLhs() instanceof IntImmediate&&ci.getRhs() instanceof IntImmediate) {
                        switch (ci.getOperator()) {
                            case EQU:
                                ci.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1 == t2?1:0),
                                        ci.getDefinedRegister()
                                ));
                                ivMap.put(ci.getDefinedRegister(),t1 == t2?1:0);
                                ci.remove();
                                break;
                            case NEQ:
                                ci.prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1 != t2?1:0),
                                        ci.getDefinedRegister()
                                ));
                                ivMap.put(ci.getDefinedRegister(),t1 != t2?1:0);
                                ci.remove();
                                break;
                            case LESS:
                                ci.getNxt().prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1 < t2?1:0),
                                        ci.getDefinedRegister()
                                ));
                                ivMap.put(ci.getDefinedRegister(),t1 < t2?1:0);
                                ci.remove();
                                break;
                            case GRTR:
                                ci.getNxt().prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1 > t2?1:0),
                                        ci.getDefinedRegister()
                                ));
                                ivMap.put(ci.getDefinedRegister(),t1 > t2?1:0);
                                ci.remove();
                                break;
                            case LEQ:
                                ci.getNxt().prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1 <= t2?1:0),
                                        ci.getDefinedRegister()
                                ));
                                ivMap.put(ci.getDefinedRegister(),t1 <= t2?1:0);
                                ci.remove();
                                break;
                            case GEQ:
                                ci.getNxt().prepend(new MoveInstruction(
                                        basicBlock,new IntImmediate(t1 >= t2?1:0),
                                        ci.getDefinedRegister()
                                ));
                                ivMap.put(ci.getDefinedRegister(),t1 >= t2?1:0);
                                ci.remove();
                                break;
                            default:
                                System.err.println("Unknow operator of comparision instruction in constant folder.");
                                break;
                        }
                    }
                    else {
                        ivMap.put(inst.getDefinedRegister(),null);
                    }
                }
                else if (inst instanceof UnaryOperationInstruction) {
                    UnaryOperationInstruction ui = (UnaryOperationInstruction) inst;
                    Integer t = ivMap.get(ui.getOprand());
                    if (t != null) {
                        if (ui.getOperator() == UnaryOperationInstruction.Operator.NEG) {
                            ui.prepend(new MoveInstruction(
                                    basicBlock,new IntImmediate(-t),ui.getDefinedRegister()
                            ));
                            ui.remove();
                            ivMap.put(ui.getDefinedRegister(),-t);
                        }
                        else if (ui.getOperator() == UnaryOperationInstruction.Operator.COMP) {
                            ui.prepend(new MoveInstruction(
                                    basicBlock,new IntImmediate(~t),ui.getDefinedRegister()
                            ));
                            ui.remove();
                            ivMap.put(ui.getDefinedRegister(),~t);
                        }
                        else {
                            System.err.println("Unknow operator of unary operation instruction in constant folder.");
                        }
                    }
                    else {
                        ivMap.put(inst.getDefinedRegister(),null);
                    }
                }
                else if (inst instanceof LoadInstruction) {
                    LoadInstruction load = (LoadInstruction) inst;
                    Integer t = ivMap.get(load.getAddr());
                    if (t != null) {
                        load.setAddr(new IntImmediate(t));
                    }
                    ivMap.put(load.getDefinedRegister(),null);
                }
                else if (inst instanceof StoreInstruction) {
                    StoreInstruction store = (StoreInstruction) inst;
                    Integer t1 = ivMap.get(store.getAddr());
                    if (t1 != null) {
                        store.setAddr(new IntImmediate(t1));
                    }
                    Integer t2 = ivMap.get(store.getValue());
                    if (t2 != null) {
                        store.setValue(new IntImmediate(t2));
                    }
                }
                else if (inst instanceof MoveInstruction) {
                    MoveInstruction move = (MoveInstruction) inst;
                    Integer t = ivMap.get(move.getSource());
                    if (t != null) {
                        move.setSource(new IntImmediate(t));
                        ivMap.put(move.getDest(),t);
                    }
                    else {
                        ivMap.put(move.getDest(),null);
                    }
                }
                else {
                    System.err.println("Unknown IR instruction in constant folder.");
                }
            }
        }
    }

    public void run() {
        irRoot.functions.values().forEach(func->processFunc(func));
    }
}
