package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.utils.CompilerOption;

import java.util.*;

public class StupidAllocator extends RegisterAllocator {
    private IRRoot irRoot;
    private List<PhysicalRegister> registers = new ArrayList<>();
    private Map<VirtualRegister,StackFrame> stackFrameMap = new HashMap<>();

    private StackFrame getStackFrame(Function curFunc,VirtualRegister vr) {
        StackFrame sf = stackFrameMap.get(vr);
        if (sf == null) {
            sf = new StackFrame(curFunc,vr.getHintName());
            stackFrameMap.put(vr,sf);
        }
        return sf;
    }

    public StupidAllocator(IRRoot _irRoot, Collection<PhysicalRegister> _registers) {
        irRoot = _irRoot;
        registers.addAll(_registers);
    }

    private void processFunction(Function func) {
        stackFrameMap.clear();

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
                                StackFrame sf = getStackFrame(func,(VirtualRegister) reg);
                                inst.prepend(new LoadInstruction(basicBlock,pr,CompilerOption.getSizeInt(),sf,0));
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
                            argRegs.set(i,getStackFrame(func,(VirtualRegister) argReg));
                        }
                    }
                }
                Register definedReg = inst.getDefinedRegister();
                if (definedReg != null&&definedReg instanceof VirtualRegister) {
                    PhysicalRegister pr = ((VirtualRegister) definedReg).forcedPhysicalRegister;
                    if (pr == null) pr = registers.get(cnt++);
                    StackFrame sf = getStackFrame(func,(VirtualRegister) definedReg);
                    inst.append(new StoreInstruction(basicBlock,sf,CompilerOption.getSizeInt(),0,pr));
                    inst.setDefinedRegister(pr);
                    inst = inst.getNxt();
                }
            }
        }
    }

    public void run() {
        irRoot.functions.values().forEach(func->processFunction(func));
    }
}
