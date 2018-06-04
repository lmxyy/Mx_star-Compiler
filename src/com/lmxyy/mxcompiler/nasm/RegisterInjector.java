package com.lmxyy.mxcompiler.nasm;

import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.utils.CompilerOption;

public class RegisterInjector {
    private final int wordSize = CompilerOption.getSizeInt();
    private IRRoot irRoot;

    public RegisterInjector(IRRoot _irRoot) {
        irRoot = _irRoot;
    }

    private void replaceFunctionArg(Function func) {
        IRInstruction first = func.startBasicBlock.getHead();
        for (int i = 0;i < func.argRegList.size();++i) {
            VirtualRegister vr = func.argRegList.get(i);
            StackSlot sl = new StackSlot(func,"arg"+i);
//            func.argStackSlopMap.put(vr,sl);
//            if (i == 0)
//                first.prepend(new MoveInstruction(func.startBasicBlock,NASMRegisterSet.RDI,vr));
//            if (i == 1)
//                first.prepend(new MoveInstruction(func.startBasicBlock,NASMRegisterSet.RSI,vr));
//            if (i == 2)
//                first.prepend(new MoveInstruction(func.startBasicBlock,NASMRegisterSet.RDX,vr));
//            if (i == 3)
//                first.prepend(new MoveInstruction(func.startBasicBlock,NASMRegisterSet.RCX,vr));
//            if (i == 4)
//                first.prepend(new MoveInstruction(func.startBasicBlock,NASMRegisterSet.R8,vr));
//            if (i == 5)
//                first.prepend(new MoveInstruction(func.startBasicBlock,NASMRegisterSet.R9,vr));
            /*else */if (i > 5) {
                first.prepend(new LoadInstruction(func.startBasicBlock,vr,wordSize,sl,0));
            }
        }
        if (func.argRegList.size() > 0) {
            func.argRegList.get(0).forcedPhysicalRegister = NASMRegisterSet.RDI;
        }
        if (func.argRegList.size() > 1) {
            func.argRegList.get(1).forcedPhysicalRegister = NASMRegisterSet.RSI;
        }
        if (func.argRegList.size() > 2) {
            func.argRegList.get(2).forcedPhysicalRegister = NASMRegisterSet.RDX;
        }
        if (func.argRegList.size() > 3) {
            func.argRegList.get(3).forcedPhysicalRegister = NASMRegisterSet.RCX;
        }
        if (func.argRegList.size() > 4) {
            func.argRegList.get(4).forcedPhysicalRegister = NASMRegisterSet.R8;
        }
        if (func.argRegList.size() > 5) {
            func.argRegList.get(5).forcedPhysicalRegister = NASMRegisterSet.R9;
        }
    }

    private void modifyHeapAllocation(Function func,BasicBlock basicBlock,HeapAllocateInstruction inst) {
        if (func.argRegList.size() > 0)
            inst.append(new StoreInstruction(
                    basicBlock, func.argStackSlopMap.get(func.argRegList.get(0)),
                    0,wordSize,NASMRegisterSet.RDI
            ));
        inst.prepend(new MoveInstruction(basicBlock, inst.getAllocSize(), NASMRegisterSet.RDI));
        inst.append(new MoveInstruction(basicBlock, NASMRegisterSet.RAX, inst.getDest()));
        if (func.argRegList.size() > 0)
            // TODO There may be some bugs here.
            inst.append(new LoadInstruction(basicBlock, NASMRegisterSet.RDI, wordSize,
                    func.argStackSlopMap.get(func.argRegList.get(0)), 0
            ));
    }

    public void run() {
        irRoot.functions.values().forEach(func->replaceFunctionArg(func));
        for (Function func:irRoot.functions.values()) {
            for (BasicBlock basicBlock:func.getReversePostOrder()) {
                for (IRInstruction inst = basicBlock.getHead();inst != null;inst = inst.getNxt()) {
                    if (inst instanceof HeapAllocateInstruction)
                        modifyHeapAllocation(func,basicBlock,(HeapAllocateInstruction) inst);
                }
            }
        }
    }
}
