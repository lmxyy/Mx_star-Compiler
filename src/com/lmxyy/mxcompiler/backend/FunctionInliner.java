package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;

import java.util.*;

public class FunctionInliner {
    private static class FuncInfo {
        int numInst = 0;
        int numUsed = 0;
        Set<Function> recursiveCalleeSet = new HashSet<>();
        Set<Function> calleeSet = new HashSet<>();
        boolean skip = false;
    }

    private IRRoot irRoot;
    private Map<Function,FuncInfo> infoMap = new HashMap();

    public FunctionInliner(IRRoot _irRoot) {
        irRoot = _irRoot;
    }

    private void copyIntValue(Map<Object,Object> renameMap,IntValue intValue) {
        if (renameMap.containsKey(intValue)) return;
        renameMap.put(intValue,intValue.copy());
    }

    private void countInstructionNumber() {
        irRoot.functions.values().forEach(func->infoMap.put(func,new FuncInfo()));
        for (Function func:irRoot.functions.values()) {
            FuncInfo info = infoMap.get(func);
            for (BasicBlock basicBlock:func.getReversePostOrder()) {
                for (IRInstruction inst = basicBlock.getHead(); inst != null; inst = inst.getNxt()) {
                    ++info.numInst;
                    if (inst instanceof CallInstruction) {
                        FuncInfo calleeInfo = infoMap.get(((CallInstruction) inst).getFunction());
                        if (calleeInfo != null) ++calleeInfo.numUsed;
                        if (IRRoot.isBuiltinFunction(((CallInstruction) inst).getFunction())) continue;
                        info.recursiveCalleeSet.add(((CallInstruction) inst).getFunction());
                        info.calleeSet.add(((CallInstruction) inst).getFunction());
                    }
                }
            }
        }
    }

    private void getRecursiveCalleeSet() {
        irRoot.functions.values().forEach(func->{
            Set <Function> incSet = new HashSet<>();
            FuncInfo info = infoMap.get(func);
            info.recursiveCalleeSet.forEach(callee->incSet.addAll(infoMap.get(callee).calleeSet));
            info.recursiveCalleeSet.addAll(incSet);
        });
    }

    private IRInstruction doInline(CallInstruction call) {
        Function func = call.getBasicBlock().getParent();
        Function callee = call.getFunction();
        Map<Object,Object> renameMap = new HashMap<>();
        func.calcReversePostOrder();
        List<BasicBlock> RPO = callee.getReversePostOrder();

        BasicBlock oldExitBlock = callee.exitBasicBlock;
        BasicBlock newExitBlock = new BasicBlock(func,oldExitBlock.getHintName());
        renameMap.put(oldExitBlock,newExitBlock);
        renameMap.put(callee.startBasicBlock,call.getBasicBlock());
        if (func.exitBasicBlock == call.basicBlock)
            func.exitBasicBlock = newExitBlock;

        Map <Object,Object> moveMap = Collections.singletonMap(call.getBasicBlock(),newExitBlock);
        for (IRInstruction inst = call.getNxt();inst != null;inst = inst.getNxt()) {
            if (inst instanceof EndInstruction) {
                newExitBlock.end((EndInstruction)inst.copyAndRename(moveMap));
            }
            else {
                newExitBlock.append(inst.copyAndRename(moveMap));
            }
            inst.remove();
        }
        IRInstruction newExitHead = newExitBlock.getHead();

        for (int i = 0; i < call.getArgRegList().size(); ++i) {
            VirtualRegister oldReg = callee.argRegList.get(i);
            VirtualRegister newReg = (VirtualRegister) oldReg.copy();
            call.prepend(new MoveInstruction(call.getBasicBlock(),call.getArgRegList().get(i), newReg));
            renameMap.put(oldReg, newReg);
        }

        call.remove();

        RPO.stream().filter(basicBlock -> !renameMap.containsKey(basicBlock)).
                forEach(basicBlock -> renameMap.put(basicBlock,new BasicBlock(func,basicBlock.getHintName())));

        for (BasicBlock oldBlock:RPO) {
            BasicBlock newBlock = (BasicBlock) renameMap.get(oldBlock);
            for (IRInstruction inst = oldBlock.getHead();inst != null;inst = inst.getNxt()) {
                inst.getUsedIntValue().forEach(v->copyIntValue(renameMap,v));
                if (inst.getDefinedRegister() != null) {
                    copyIntValue(renameMap,inst.getDefinedRegister());
                }
                if (newBlock != newExitBlock) {
                    if (inst instanceof EndInstruction) {
                        if (!(inst instanceof ReturnInstruction))
                            newBlock.end((EndInstruction)inst.copyAndRename(renameMap));
                    }
                    else {
                        newBlock.append(inst.copyAndRename(renameMap));
                    }
                }
                else {
                    if (!(inst instanceof ReturnInstruction))
                        newExitHead.prepend(inst.copyAndRename(renameMap));
                }
            }
        }

        ReturnInstruction retInst = callee.retInstruction.get(0);
        if (retInst.getRetVal() != null) {
            newExitHead.prepend(new MoveInstruction(newExitBlock,(IntValue) renameMap.get(retInst.getRetVal()),call.getRegister()));
        }
        return newExitHead;
    }

    public void run() {
        final int MAX_CALLEE_INST = 1<<8;
        final int MAX_CALLER_INST = 1<<14;

        countInstructionNumber();
        for (int i = irRoot.functions.size();i >= 0;--i) {
            getRecursiveCalleeSet();
        }
        infoMap.forEach((func,info)->{info.skip = info.recursiveCalleeSet.contains(func);});

        List<Function> toDeleteFunction = new ArrayList<>();
        boolean changed = true;
        List<BasicBlock> RPO = new ArrayList<>();
        while (changed) {
            changed = false;
            toDeleteFunction.clear();
            for (Function func:irRoot.functions.values()) {
                FuncInfo info = infoMap.get(func);
                func.calcReversePostOrder();
                RPO.clear();
                RPO.addAll(func.getReversePostOrder());
                for (BasicBlock basicBlock:RPO) {
                    for (IRInstruction inst = basicBlock.getHead(),nxt;inst != null;inst = nxt) {
                        nxt = inst.getNxt();
                        if (!(inst instanceof CallInstruction))
                            continue;
                        CallInstruction call = (CallInstruction) inst;
                        Function callee = call.getFunction();
                        if (IRRoot.isBuiltinFunction(callee)) continue;
                        FuncInfo calleeInfo = infoMap.get(callee);
                        if (calleeInfo.skip) continue;

                        if (calleeInfo.numInst < MAX_CALLEE_INST&&info.numInst+calleeInfo.numInst < MAX_CALLER_INST) {
                            nxt = doInline(call);
                            changed = true;
                            info.numInst += calleeInfo.numInst;
                            if (--calleeInfo.numUsed == 0) {
                                toDeleteFunction.add(callee);
                            }
                        }
                    }
                }
                func.calcReversePostOrder();
            }
            toDeleteFunction.forEach(func->irRoot.functions.remove(func));
        }
    }
}
