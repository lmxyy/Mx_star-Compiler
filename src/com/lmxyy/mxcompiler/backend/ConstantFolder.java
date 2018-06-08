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
            for (IRInstruction inst = basicBlock.getTail(); inst != null; inst = inst.getPre()) {
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
                    call.
                }
            }
        }
    }

    public void run() {
        irRoot.functions.values().forEach(func->processFunc(func));
    }
}
