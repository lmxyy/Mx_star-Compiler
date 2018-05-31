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
                regRenameMap.clear();
                if (inst instanceof TwoAddressInstruction) {
                    Collection<Register> used = inst.getUsedRegister();
                    used.forEach(reg->regRenameMap.put(reg,reg));
                    if (((TwoAddressInstruction) inst).getRhs() instanceof VirtualRegister) {
                        VirtualRegister reg = (VirtualRegister) ((TwoAddressInstruction) inst).getRhs();
                        PhysicalRegister pr = regRenameMap.get(reg) == reg?
                                registers.get(cnt++):(PhysicalRegister)regRenameMap.get(reg);
                        StackSlot sl = getStackSlop(func, (VirtualRegister) reg);
                        if (regRenameMap.get(reg) != pr)
                            inst.prepend(new LoadInstruction(basicBlock, pr, CompilerOption.getSizeInt(), sl, 0));
                        regRenameMap.put(reg,pr);
                        func.usedPhysicalGeneralRegister.add(pr);
                    }
                    if (((TwoAddressInstruction) inst).getLhs() instanceof VirtualRegister) {
                        VirtualRegister reg = (VirtualRegister) ((TwoAddressInstruction) inst).getLhs();
                        PhysicalRegister pr = regRenameMap.get(reg) == reg ?
                                registers.get(cnt++) : (PhysicalRegister) regRenameMap.get(reg);
                        StackSlot sl = getStackSlop(func, (VirtualRegister) reg);
                        if (regRenameMap.get(reg) != pr)
                            inst.prepend(new LoadInstruction(basicBlock, pr, CompilerOption.getSizeInt(), sl, 0));
                        regRenameMap.put(reg, pr);
                        func.usedPhysicalGeneralRegister.add(pr);
                        inst.append(new StoreInstruction(basicBlock, sl, CompilerOption.getSizeInt(), 0, pr));
                        inst.setUsedRegister(regRenameMap);
                        inst = inst.getNxt();
                    }
                    else inst.setUsedRegister(regRenameMap);
                }
                else {
                    if (inst instanceof CallInstruction) {
                        List<IntValue> argRegs = ((CallInstruction) inst).getArgRegList();
                        for (int i = 0; i < argRegs.size(); ++i) {
                            IntValue argReg = argRegs.get(i);
                            if (argReg instanceof VirtualRegister) {
                                argRegs.set(i, getStackSlop(func, (VirtualRegister) argReg));
                            }
                        }
                    }
                    else {
                        Collection<Register> used = inst.getUsedRegister();
                        used.forEach(reg->regRenameMap.put(reg,reg));
                        if (!used.isEmpty()) {
                            for (Register reg : used) {
                                if (reg instanceof VirtualRegister) {
                                    PhysicalRegister pr = regRenameMap.get(reg) == reg ?
                                            registers.get(cnt++) : (PhysicalRegister) regRenameMap.get(reg);
                                    StackSlot sl = getStackSlop(func, (VirtualRegister) reg);
                                    if (regRenameMap.get(reg) != pr)
                                        inst.prepend(new LoadInstruction(basicBlock, pr, CompilerOption.getSizeInt(), sl, 0));
                                    regRenameMap.put(reg, pr);
                                    func.usedPhysicalGeneralRegister.add(pr);
                                }
                            }
                            inst.setUsedRegister(regRenameMap);
                        }
                        Register definedReg = inst.getDefinedRegister();
                        if (definedReg != null&&definedReg instanceof VirtualRegister) {
                            PhysicalRegister pr = regRenameMap.get(definedReg) == null ?
                                    registers.get(cnt++) : (PhysicalRegister) regRenameMap.get(definedReg);
                            StackSlot sl = getStackSlop(func, (VirtualRegister) definedReg);
                            regRenameMap.put(definedReg, pr);
                            func.usedPhysicalGeneralRegister.add(pr);
                            inst.setDefinedRegister(pr);
                            inst.append(new StoreInstruction(basicBlock, sl, CompilerOption.getSizeInt(), 0, pr));
                            inst = inst.getNxt();
                        }
                    }
                }
            }
        }
        func.stackSlots.addAll(stackSlopMap.values());
    }

    public void run() {
        irRoot.functions.values().forEach(func->processFunction(func));
    }
}
