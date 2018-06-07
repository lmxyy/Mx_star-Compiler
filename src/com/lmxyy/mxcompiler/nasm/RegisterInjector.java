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
            func.argStackSlopMap.put(vr,sl);
            if (i == 0) {
                first.prepend(new StoreInstruction(func.startBasicBlock,sl,0,8,NASMRegisterSet.RDI));
            }
            if (i == 1) {
                first.prepend(new StoreInstruction(func.startBasicBlock,sl,0,8,NASMRegisterSet.RSI));
            }
            if (i == 2) {
                first.prepend(new StoreInstruction(func.startBasicBlock,sl,0,8,NASMRegisterSet.RDX));
            }
            if (i == 3) {
                first.prepend(new StoreInstruction(func.startBasicBlock,sl,0,8,NASMRegisterSet.RCX));
            }
            if (i == 4) {
                first.prepend(new StoreInstruction(func.startBasicBlock,sl,0,8,NASMRegisterSet.R8));
            }
            if (i == 5) {
                first.prepend(new StoreInstruction(func.startBasicBlock,sl,0,8,NASMRegisterSet.R9));
            }
        }
        for (int i = 0;i < func.argRegList.size();++i) {
            VirtualRegister vr = func.argRegList.get(i);
            StackSlot sl = func.argStackSlopMap.get(vr);
            first.prepend(new LoadInstruction(func.startBasicBlock,vr,wordSize,sl,0));
        }
//        if (func.argRegList.size() > 0) {
//            func.argRegList.get(0).forcedPhysicalRegister = NASMRegisterSet.RDI;
//        }
//        if (func.argRegList.size() > 1) {
//            func.argRegList.get(1).forcedPhysicalRegister = NASMRegisterSet.RSI;
//        }
//        if (func.argRegList.size() > 2) {
//            func.argRegList.get(2).forcedPhysicalRegister = NASMRegisterSet.RDX;
//        }
//        if (func.argRegList.size() > 3) {
//            func.argRegList.get(3).forcedPhysicalRegister = NASMRegisterSet.RCX;
//        }
//        if (func.argRegList.size() > 4) {
//            func.argRegList.get(4).forcedPhysicalRegister = NASMRegisterSet.R8;
//        }
//        if (func.argRegList.size() > 5) {
//            func.argRegList.get(5).forcedPhysicalRegister = NASMRegisterSet.R9;
//        }
    }

//    private void modifyHeapAllocation(Function func,BasicBlock basicBlock,HeapAllocateInstruction inst) {
//        inst.prepend(new MoveInstruction(basicBlock,NASMRegisterSet.RDI,NASMRegisterSet.R11,true));
//        inst.prepend(new MoveInstruction(basicBlock, inst.getAllocSize(), NASMRegisterSet.RDI));
//        inst.append(new MoveInstruction(basicBlock, NASMRegisterSet.RAX,inst.getDest()));
//        inst.append(new MoveInstruction(basicBlock,NASMRegisterSet.R11,NASMRegisterSet.RDI,true));
//    }

    public void run() {
        irRoot.functions.values().forEach(func->replaceFunctionArg(func));
//        for (Function func:irRoot.functions.values()) {
//            for (BasicBlock basicBlock:func.getReversePostOrder()) {
//                for (IRInstruction inst = basicBlock.getHead();inst != null;inst = inst.getNxt()) {
//                    if (inst instanceof HeapAllocateInstruction)
//                        modifyHeapAllocation(func,basicBlock,(HeapAllocateInstruction) inst);
//                }
//            }
//        }
    }
}
