package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.utils.CompilerOption;

import java.util.*;

public class StupidAllocator extends RegisterAllocator {
    private IRRoot irRoot;
    private List<PhysicalRegister> registers = new ArrayList<>();
    private Map<VirtualRegister,StackSlot> stackSlopMap = new HashMap<>();

    private StackSlot getStackSlop(Function curFunc, VirtualRegister vr) {
        StackSlot sl = stackSlopMap.get(vr);
        if (sl == null) {
            sl = new StackSlot(curFunc,vr.getHintName());
            stackSlopMap.put(vr,sl);
        }
        return sl;
    }

    public StupidAllocator(IRRoot _irRoot, Collection<PhysicalRegister> _registers) {
        irRoot = _irRoot;
        registers.addAll(_registers);
    }

    private void processFunction(Function func) {
        stackSlopMap.clear();
        stackSlopMap.putAll(func.argStackSlopMap);

        Map<Register,Register> regRenameMap = new HashMap<>();
        for (BasicBlock basicBlock:func.getReversePostOrder()) {
            for (IRInstruction inst = basicBlock.getHead();inst != null;inst = inst.getNxt()) {
                int cnt = 0;
                if (!(inst instanceof CallInstruction)) {
                    Collection<Register> used = inst.getUsedRegister();
                    if (!used.isEmpty()) {
                        for (Register reg:used) {
                            if (reg instanceof VirtualRegister) {
                                PhysicalRegister pr = ((VirtualRegister) reg).forcedPhysicalRegister;
                                if (pr == null)
                                    ((VirtualRegister) reg).forcedPhysicalRegister = registers.get(cnt++);
                                func.usedPhysicalGeneralRegister.add(pr);
                                regRenameMap.put(reg,pr);
                                StackSlot sl = getStackSlop(func,(VirtualRegister) reg);
                                inst.prepend(new LoadInstruction(basicBlock,pr,CompilerOption.getSizeInt(),sl,0));
                            }
                        }
                        inst.setUsedRegister(regRenameMap);
                    }
                }
                else {
                    List<IntValue> argRegs = ((CallInstruction) inst).getArgRegList();
                    for (int i = 0;i < argRegs.size();++i) {
                        IntValue argReg = argRegs.get(i);
                        if (argReg instanceof VirtualRegister) {
                            argRegs.set(i,getStackSlop(func,(VirtualRegister) argReg));
                        }
                    }
                }
                Register definedReg = inst.getDefinedRegister();
                if (definedReg != null&&definedReg instanceof VirtualRegister) {
                    PhysicalRegister pr = ((VirtualRegister) definedReg).forcedPhysicalRegister;
                    if (pr == null) pr = registers.get(cnt++);
                    StackSlot sl = getStackSlop(func,(VirtualRegister) definedReg);
                    inst.append(new StoreInstruction(basicBlock,sl,CompilerOption.getSizeInt(),0,pr));
                    inst.setDefinedRegister(pr);
                    inst = inst.getNxt();
                }
            }
        }
        func.stackSlots.addAll(stackSlopMap.values());
    }

    public void run() {
        irRoot.functions.values().forEach(func->processFunction(func));
    }
}
