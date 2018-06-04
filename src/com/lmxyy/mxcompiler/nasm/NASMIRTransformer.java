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
        int stackSlotNum = 0;
    }

    private Map<Function,FunctionInfo> infoMap = new HashMap<>();
    private int wordSize = CompilerOption.getSizeInt();
    private int stackSlotNum = 0;

    private IRRoot irRoot;
    public NASMIRTransformer(IRRoot _irRoot) {
        irRoot = _irRoot;
    }

    private void calcFrame(Function func) {
        FunctionInfo info = new FunctionInfo();
        infoMap.put(func, info);

        for (PhysicalRegister pr:func.usedPhysicalGeneralRegister) {
            /*if (pr.isCallerSave()) */info.usedCallerSaveRegister.add(pr);
            if (pr.isCalleeSave()) info.usedCalleeSaveRegister.add(pr);
        }

        stackSlotNum = 0;
        for (int i = 6;i < func.argRegList.size();++i) {
            VirtualRegister reg = func.argRegList.get(i);
            info.stackSlotOffset.put(func.argStackSlopMap.get(reg),0);
        }
        for (StackSlot slot:func.stackSlots) {
            if (info.stackSlotOffset.get(slot) == null)
                info.stackSlotOffset.put(slot,(stackSlotNum++)*wordSize);
        }
        info.stackSlotNum = stackSlotNum;
    }

    private void modifyEntry(Function func) {
        FunctionInfo info = infoMap.get(func);
        BasicBlock entryBasicBlock = func.startBasicBlock;
        IRInstruction firstInst = entryBasicBlock.getHead();
        firstInst.prepend(new PushInstruction(entryBasicBlock,NASMRegisterSet.RBP));
        firstInst.prepend(new MoveInstruction(entryBasicBlock,NASMRegisterSet.RSP,NASMRegisterSet.RBP));
        int decNum = ((func.stackSlots.size()+info.usedCallerSaveRegister.size())*wordSize+15)/16*16;
        firstInst.prepend(
                new TwoAddressInstruction(
                        entryBasicBlock,BinaryOperationInstruction.Operator.SUB,
                        NASMRegisterSet.RSP,new IntImmediate(decNum)
                )
        );
        for (int i = 6;i < func.argRegList.size();++i) {
            VirtualRegister reg = func.argRegList.get(i);
            info.stackSlotOffset.put(func.argStackSlopMap.get(reg),decNum+(i-4)*wordSize);
        }
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

        Map <PhysicalRegister,Integer> offsetMap = new HashMap<>();
        // save caller-save register
        for (int i = 0; i < info.usedCallerSaveRegister.size(); ++i) {
            PhysicalRegister pr = info.usedCallerSaveRegister.get(i);
            offsetMap.put(pr,(info.stackSlotNum + i) * wordSize);
            inst.prepend(new StoreInstruction(
                    basicBlock, NASMRegisterSet.RSP,
                    (info.stackSlotNum + i) * wordSize, wordSize, pr
            ));
        }

        int pushNum = 0;
        for (int i = inst.getArgRegList().size() - 1; i >= 0; --i) {
            IntValue val = inst.getArgRegList().get(i);
            if (i >= 6) {
                ++pushNum;
                if (!(val instanceof StackSlot)) {
                    inst.prepend(new PushInstruction(basicBlock, val));
                } else {
                    inst.prepend(new PushInstruction(
                            basicBlock, NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                    ));
                }
            } else {
                if (i == 0) {
                    if (!(val instanceof StackSlot)) {
                        if (val instanceof IntImmediate||!((NASMRegister) val).isFunArg())
                            inst.prepend(new MoveInstruction(basicBlock, val,NASMRegisterSet.RDI));
                        else inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RDI, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RDI, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 1) {
                    if (!(val instanceof StackSlot)) {
                        if (val instanceof IntImmediate||!((NASMRegister) val).isFunArg())
                            inst.prepend(new MoveInstruction(basicBlock, val,NASMRegisterSet.RSI));
                        else inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RSI, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RSI, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 2) {
                    if (!(val instanceof StackSlot)) {
                        if (val instanceof IntImmediate||!((NASMRegister) val).isFunArg())
                            inst.prepend(new MoveInstruction(basicBlock, val,NASMRegisterSet.RDX));
                        else inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RDX, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RDX, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 3) {
                    if (!(val instanceof StackSlot)) {
                        if (val instanceof IntImmediate||!((NASMRegister) val).isFunArg())
                            inst.prepend(new MoveInstruction(basicBlock, val,NASMRegisterSet.RCX));
                        else inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RCX, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.RCX, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 4) {
                    if (!(val instanceof StackSlot)) {
                        if (val instanceof IntImmediate||!((NASMRegister) val).isFunArg())
                            inst.prepend(new MoveInstruction(basicBlock, val,NASMRegisterSet.R8));
                        else inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.R8, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.R8, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                }
                else if (i == 5) {
                    if (!(val instanceof StackSlot)) {
                        if (val instanceof IntImmediate||!((NASMRegister) val).isFunArg())
                            inst.prepend(new MoveInstruction(basicBlock, val,NASMRegisterSet.R9));
                        else inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.R9, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
                        ));
                    }
                    else {
                        inst.prepend(new LoadInstruction(
                                basicBlock, NASMRegisterSet.R9, wordSize,
                                NASMRegisterSet.RSP, info.stackSlotOffset.get(val)
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
            inst.append(new LoadInstruction(
                    basicBlock, pr, wordSize, NASMRegisterSet.RSP,
                    (info.stackSlotNum + i) * wordSize)
            );
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
                    // add 0, sub 0, mul 1,
                }
            }
        }
    }
}
