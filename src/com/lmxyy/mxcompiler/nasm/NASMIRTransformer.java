package com.lmxyy.mxcompiler.nasm;

import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.utils.CompilerOption;

import java.util.*;

public class NASMIRTransformer {

    private static class FunctionInfo {
        List<PhysicalRegister> usedCallerSaveRegister = new ArrayList<>();
        List<PhysicalRegister> usedCalleeSaveRegister = new ArrayList<>();
        Map<StackSlot, Integer> stackSlotOffset = new HashMap<>();
        Set<PhysicalRegister> recursiveUsedRegister = new HashSet<>();
    }

    private Map<Function,FunctionInfo> infoMap = new HashMap<>();
    private int wordSize = CompilerOption.getSizeInt();

    private IRRoot irRoot;
    public NASMIRTransformer(IRRoot _irRoot) {
        irRoot = _irRoot;
    }

    private void calcFrame(Function func) {
        FunctionInfo info = new FunctionInfo();
        infoMap.put(func, info);

        for (PhysicalRegister pr:func.usedPhysicalGeneralRegister) {
            if (pr.isCallerSave()) info.usedCallerSaveRegister.add(pr);
            if (pr.isCalleeSave()) info.usedCalleeSaveRegister.add(pr);
        }

        int cnt = 0;
        for (StackSlot slot:func.stackSlots) {
            info.stackSlotOffset.put(slot,(++cnt)*wordSize);
        }
    }

    private void modifyEntry(Function func) {
        FunctionInfo info = infoMap.get(func);
        BasicBlock entryBasicBlock = func.startBasicBlock;
        IRInstruction firstInst = entryBasicBlock.getHead();
        firstInst.prepend(new PushInstruction(entryBasicBlock,NASMRegisterSet.RBP));
        firstInst.prepend(new MoveInstruction(entryBasicBlock,NASMRegisterSet.RSP,NASMRegisterSet.RBP));
        int decNum = ((func.stackSlots.size()+6 +info.usedCallerSaveRegister.size())*wordSize+15)/16*16;
        firstInst.prepend(
                new TwoAddressInstruction(
                        entryBasicBlock,BinaryOperationInstruction.Operator.SUB,
                        NASMRegisterSet.RSP,new IntImmediate(decNum)
                )
        );
    }
    private void modifyReturn(Function func) {
        if (!func.getType().getReturnType().isVoid()) {
            ReturnInstruction ret = func.retInstruction.get(0);
            ret.prepend(new MoveInstruction(ret.getBasicBlock(), ret.getRetVal(), NASMRegisterSet.RAX));
        }
    }
    private void modifyExit(Function func) {
        ReturnInstruction ret = func.retInstruction.get(0);
        ret.prepend(new LeaveInstruction(ret.getBasicBlock()));
    }

    private void calcRecursiveRegisterUse() {
        for (Map.Entry<Function, FunctionInfo> entry : infoMap.entrySet()) {
            Function func = entry.getKey();
            FunctionInfo info = entry.getValue();
            info.recursiveUsedRegister.addAll(func.usedPhysicalGeneralRegister);
            func.calleeSet.forEach(
                    callee -> info.recursiveUsedRegister.addAll(callee.usedPhysicalGeneralRegister)
            );
        }
    }

    private void removeSelfMove(MoveInstruction inst) {
        if (inst.getSource() == inst.getDest()) inst.remove();
    }
    private void modifyCall(Function func,FunctionInfo info,BasicBlock basicBlock,CallInstruction inst) {
        Function callee = inst.getFunction();
        FunctionInfo calleeInfo = infoMap.get(callee);

        // save caller-save register
        for (int i = 0; i < info.usedCallerSaveRegister.size(); ++i) {
            PhysicalRegister pr = info.usedCallerSaveRegister.get(i);
            if (calleeInfo.recursiveUsedRegister.contains(pr)) {
                inst.prepend(new StoreInstruction(
                        basicBlock, NASMRegisterSet.RBP,
                        -(func.stackSlots.size() + i + 1) * wordSize, wordSize, pr)
                );
            }
        }

        if (callee.argRegList.size() > 0) {
            inst.prepend(new StoreInstruction(
                    basicBlock, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 1) * wordSize,
                    wordSize, NASMRegisterSet.RDI
            ));
        }
        if (callee.argRegList.size() > 1) {
            inst.prepend(new StoreInstruction(
                    basicBlock, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 2) * wordSize,
                    wordSize, NASMRegisterSet.RSI
            ));
        }
        if (callee.argRegList.size() > 2) {
            inst.prepend(new StoreInstruction(
                    basicBlock, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 3) * wordSize,
                    wordSize, NASMRegisterSet.RDX
            ));
        }
        if (callee.argRegList.size() > 3) {
            inst.prepend(new StoreInstruction(
                    basicBlock, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 4) * wordSize,
                    wordSize, NASMRegisterSet.RCX
            ));
        }
        if (callee.argRegList.size() > 4) {
            inst.prepend(new StoreInstruction(
                    basicBlock, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 5) * wordSize,
                    wordSize, NASMRegisterSet.R8
            ));
        }
        if (callee.argRegList.size() > 5) {
            inst.prepend(new StoreInstruction(
                    basicBlock, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 6) * wordSize,
                    wordSize, NASMRegisterSet.R9
            ));
        }


        int pushNum = 0;
        for (int i = inst.getArgRegList().size() - 1; i >= 0; --i) {
            IntValue val = inst.getArgRegList().get(i);
            if (i > 6) {
                ++pushNum;
                if (val instanceof IntImmediate) {
                    inst.prepend(new PushInstruction(basicBlock, val));
                } else {
                    inst.prepend(new PushInstruction(
                            basicBlock, NASMRegisterSet.RBP, -info.stackSlotOffset.get(val)
                    ));
                }
            } else {
                if (i == 0) {
                    if (val instanceof IntImmediate) {
                        inst.prepend(new MoveInstruction(basicBlock,val,NASMRegisterSet.RDI));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RDI, wordSize,
                                NASMRegisterSet.RBP, -info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 1) {
                    if (val instanceof IntImmediate) {
                        inst.prepend(new MoveInstruction(basicBlock,val,NASMRegisterSet.RSI));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RSI, wordSize,
                                NASMRegisterSet.RBP, -info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 2) {
                    if (val instanceof IntImmediate) {
                        inst.prepend(new MoveInstruction(basicBlock,val,NASMRegisterSet.RDX));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RDX, wordSize,
                                NASMRegisterSet.RBP, -info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 3) {
                    if (val instanceof IntImmediate) {
                        inst.prepend(new MoveInstruction(basicBlock,val,NASMRegisterSet.RCX));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RCX, wordSize,
                                NASMRegisterSet.RBP, -info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 4) {
                    if (val instanceof IntImmediate) {
                        inst.prepend(new MoveInstruction(basicBlock,val,NASMRegisterSet.R8));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.R8, wordSize,
                                NASMRegisterSet.RBP, -info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 5) {
                    if (val instanceof IntImmediate) {
                        inst.prepend(new MoveInstruction(basicBlock,val,NASMRegisterSet.R9));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.R9, wordSize,
                                NASMRegisterSet.RBP, -info.stackSlotOffset.get(val)
                        ));
                    }
                }
            }
        }

        if (inst.getRegister() != null) {
            inst.append(new MoveInstruction(basicBlock,NASMRegisterSet.RAX,inst.getRegister()));
        }

        // reload caller save registers
        for (int i = 0; i < info.usedCallerSaveRegister.size(); ++i) {
            PhysicalRegister pr = info.usedCallerSaveRegister.get(i);
            if (calleeInfo.recursiveUsedRegister.contains(pr)) {
                inst.append(new LoadInstruction(
                        basicBlock, pr, wordSize, NASMRegisterSet.RBP,
                        -(func.stackSlots.size() + i + 1) * wordSize)
                );
            }
        }

        if (callee.argRegList.size() > 0) {
            inst.append(new LoadInstruction(
                    basicBlock, NASMRegisterSet.RDI,wordSize, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 1) * wordSize
            ));
        }
        if (callee.argRegList.size() > 1) {
            inst.append(new LoadInstruction(
                    basicBlock, NASMRegisterSet.RSI,wordSize, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 2) * wordSize
            ));
        }
        if (callee.argRegList.size() > 2) {
            inst.append(new LoadInstruction(
                    basicBlock, NASMRegisterSet.RDX,wordSize, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 3) * wordSize
            ));
        }
        if (callee.argRegList.size() > 3) {
            inst.append(new LoadInstruction(
                    basicBlock, NASMRegisterSet.RCX,wordSize, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 4) * wordSize
            ));
        }
        if (callee.argRegList.size() > 4) {
            inst.append(new LoadInstruction(
                    basicBlock, NASMRegisterSet.R8,wordSize, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 5) * wordSize
            ));
        }
        if (callee.argRegList.size() > 5) {
            inst.append(new LoadInstruction(
                    basicBlock, NASMRegisterSet.R9,wordSize, NASMRegisterSet.RBP,
                    -(func.stackSlots.size() + info.usedCallerSaveRegister.size() + 6) * wordSize
            ));
        }
    }

    private void modifyStackSlot(Function func,FunctionInfo info,BasicBlock basicBlock,IRInstruction inst) {
        if (inst instanceof LoadInstruction) {
            if (((LoadInstruction) inst).getAddr() instanceof StackSlot) {
                StackSlot slot = (StackSlot) ((LoadInstruction) inst).getAddr();
                ((LoadInstruction) inst).setAddr(NASMRegisterSet.RBP);
                ((LoadInstruction) inst).setOffset(-info.stackSlotOffset.get(slot));
            }
        }
        else if (inst instanceof StoreInstruction) {
            if (((StoreInstruction) inst).getAddr() instanceof StackSlot) {
                StackSlot slot = (StackSlot) ((StoreInstruction) inst).getAddr();
                ((StoreInstruction) inst).setAddr(NASMRegisterSet.RBP);
                ((StoreInstruction) inst).setOffset(-info.stackSlotOffset.get(slot));
            }
        }
    }

    public void run() {
        irRoot.functions.values().forEach(func->calcFrame(func));
        irRoot.getBuiltinFunctions().forEach(func->{
            FunctionInfo info = new FunctionInfo();
            infoMap.put(func, info);

            for (PhysicalRegister pr:func.usedPhysicalGeneralRegister) {
                if (pr.isCallerSave()) info.usedCallerSaveRegister.add(pr);
                if (pr.isCalleeSave()) info.usedCalleeSaveRegister.add(pr);
            }
        });

        calcRecursiveRegisterUse();

        for (Function func:irRoot.functions.values()) {
            FunctionInfo info = infoMap.get(func);
            modifyEntry(func);
            modifyReturn(func);
            modifyExit(func);
            for (BasicBlock basicBlock : func.getReversePostOrder()) {
                for (IRInstruction inst = basicBlock.getHead(); inst != null; inst = inst.getNxt()) {
                    if (inst instanceof CallInstruction)
                        modifyCall(func, info, basicBlock, (CallInstruction) inst);
                    modifyStackSlot(func, info, basicBlock, inst);
                    if (inst instanceof MoveInstruction)
                        removeSelfMove((MoveInstruction) inst);
                }
            }
        }
    }
}
