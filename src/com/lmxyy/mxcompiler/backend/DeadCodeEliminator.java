package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;

import java.util.HashSet;
import java.util.Set;

public class DeadCodeEliminator {
    private IRRoot irRoot;

    public DeadCodeEliminator(IRRoot _irRoot) {
        irRoot = _irRoot;
    }

    private void initBasicBlock(BasicBlock basicBlock) {
        for (IRInstruction inst = basicBlock.getHead();inst != null;inst = inst.getNxt()) {
            if (inst.liveIn == null||inst.liveOut == null) {
                inst.liveIn = new HashSet<VirtualRegister>();
                inst.liveOut = new HashSet<VirtualRegister>();
            }
            else {
                inst.liveIn.clear();
                inst.liveOut.clear();
            }
        }
    }

    private void processFunction(Function func) {
        func.getReversePreOrder().forEach(this::initBasicBlock);
        Set<VirtualRegister> in = new HashSet<>();
        Set<VirtualRegister> out = new HashSet<>();
        boolean changed = true;

        while (changed) {
            changed = false;
            for (BasicBlock basicBlock:func.getReversePreOrder()) {
                for (IRInstruction inst = basicBlock.getTail();inst != null;inst = inst.getPre()) {
                    in.clear(); out.clear();
                    if (inst instanceof BranchInstruction) {
                        out.addAll(((BranchInstruction) inst).getIfTrue().getHead().liveIn);
                        out.addAll(((BranchInstruction) inst).getIfFalse().getHead().liveIn);
                    }
                    else if (inst instanceof JumpInstruction) {
                        out.addAll(((JumpInstruction) inst).getTarget().getHead().liveIn);
                    }
                    else if (inst instanceof ReturnInstruction) {
                        // do nothing here
                    }
                    else {
                        out.addAll(inst.getNxt().liveIn);
                    }
                    in.addAll(out);
                    if (inst instanceof CallInstruction) ((CallInstruction) inst).callReloadUsedRegisterCollection();
                    Register defined = inst.getDefinedRegister();
                    if (defined != null&&defined instanceof VirtualRegister) {
                        in.remove(defined);
                    }
                    inst.getUsedRegister().stream().
                            filter(x->x instanceof VirtualRegister).
                            forEach(x->in.add((VirtualRegister) x));
                    if (!(inst.liveIn.equals(in))||!(inst.liveOut.equals(out))) {
                        changed = true;
                        inst.liveIn.clear(); inst.liveIn.addAll(in);
                        inst.liveOut.clear(); inst.liveOut.addAll(out);
                    }
                }
            }
        }
        for (BasicBlock basicBlock:func.getReversePostOrder()) {
            for (IRInstruction inst = basicBlock.getHead();inst != null;inst = inst.getNxt()) {
                Register defined = inst.getDefinedRegister();
                if ((defined != null&&!(defined instanceof StaticData))&&!(inst.getNxt().liveIn.contains(defined))) {
                    inst.remove();
                }
            }
        }
    }

    public void run() {
        irRoot.functions.values().forEach(func->processFunction(func));
    }
}
