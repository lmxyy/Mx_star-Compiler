package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;

import java.util.*;

public class GlobalVariableResolver {
    private IRRoot irRoot;
    private Map<Function,Set<Function>> calleeSetMap = new HashMap<>();
    private Map<Function,FunctionInfo> funcInfo = new HashMap<>();

    private VirtualRegister getReg(StaticData data,Map<StaticData,VirtualRegister> staticMap) {
        VirtualRegister reg = staticMap.get(data);
        if (reg == null) {
            reg = new VirtualRegister(null);
            staticMap.put(data,reg);
        }
        return reg;
    }

    private static class FunctionInfo {
        Map<StaticData, VirtualRegister> staticMap = new HashMap<>();
        Set<StaticData> writtenStatic = new HashSet<>();
        Set<StaticData> recursiveStaticUse = new HashSet<>();
    }

    public GlobalVariableResolver(IRRoot _irRoot) {
        irRoot = _irRoot;
    }

    private void processFunction(Function function) {
        Set<Function> calleeSet = new HashSet<Function>();
        calleeSetMap.put(function,calleeSet);
        FunctionInfo info = new FunctionInfo();
        funcInfo.put(function,info);
        Map<StaticData, VirtualRegister> staticMap = info.staticMap;
        Set<StaticData> writtenStatic = info.writtenStatic;
        Map<Register,Register> renameMap = new HashMap<>();

        for (BasicBlock basicBlock: function.getReversePostOrder()) {
            for (IRInstruction inst = basicBlock.getHead(); inst != null; inst = inst.getNxt()) {
                if (inst instanceof CallInstruction) {
                    if (!irRoot.isBuiltinFunction(((CallInstruction) inst).getFunction())) {
                        calleeSet.add(((CallInstruction) inst).getFunction());
                    }
                }
                Collection<Register> used = inst.getUsedRegister();
                if (!used.isEmpty()) {
                    renameMap.clear();
                    used.forEach(reg->renameMap.put(reg,reg));
                    for (Register reg:used) {
                        if (reg instanceof StaticData) {
                            StaticData data = (StaticData) reg;
                            renameMap.replace(reg, getReg(data, staticMap));
                        }
                    }
                    inst.setUsedRegister(renameMap);
                }
                Register defined = inst.getDefinedRegister();
                if (defined instanceof StaticData) {
                    StaticData data = (StaticData) defined;
                    inst.setDefinedRegister(getReg(data,staticMap));
                    writtenStatic.add((StaticData) defined);
                }
            }
        }

        BasicBlock b = function.startBasicBlock;
        IRInstruction i = b.getHead();
        staticMap.forEach((data,reg) -> {
            i.prepend(new LoadInstruction(
                    b,staticMap.get(data),data.getRegisterSize(),
                    data,data instanceof StaticString
            ));
        });
    }

    public void run() {
        for (Function func : irRoot.functions.values()) {
            processFunction(func);
        }

        for (Function func : irRoot.functions.values()) {
            FunctionInfo info = funcInfo.get(func);
            Set<Function> calleeSet = calleeSetMap.get(func);
            info.recursiveStaticUse.addAll(info.staticMap.keySet());
            calleeSet.forEach(callee->info.recursiveStaticUse.addAll(funcInfo.get(callee).staticMap.keySet()));
        }

        for (Function func : irRoot.functions.values()) {
            FunctionInfo info = funcInfo.get(func);
            Set<StaticData> usedSet = info.staticMap.keySet();
            if (usedSet.isEmpty()) continue;
            for (BasicBlock basicBlock:func.getReversePostOrder()) {
                for (IRInstruction inst = basicBlock.getHead(); inst != null; inst = inst.getNxt()) {
                    if (inst instanceof CallInstruction) {
                        if (irRoot.isBuiltinFunction(((CallInstruction) inst).getFunction()))
                            continue;
                        Function callee = ((CallInstruction) inst).getFunction();
                        FunctionInfo calleeInfo = funcInfo.get(callee);
                        for (StaticData data:info.writtenStatic) {
                            if (calleeInfo.recursiveStaticUse.contains(data)) {
                                inst.prepend(new StoreInstruction(
                                        basicBlock, info.staticMap.get(data),
                                        data.getRegisterSize(), data)
                                );
                            }
                        }
                        if (calleeInfo.writtenStatic.isEmpty()) continue;
                        Set<StaticData> reloadSet = new HashSet<>();
                        reloadSet.addAll(usedSet);
                        reloadSet.retainAll(calleeInfo.writtenStatic);
                        for (StaticData data:reloadSet) {
                            if (calleeInfo.recursiveStaticUse.contains(data)) {
                                inst.append(new LoadInstruction(
                                        basicBlock,info.staticMap.get(data),data.getRegisterSize(),
                                        data,data instanceof StaticString
                                ));
                            }
                        }
                    }
                }
            }
        }

        for (Function func : irRoot.functions.values()) {
            ReturnInstruction ret = func.retInstruction.get(0);
            FunctionInfo info = funcInfo.get(func);
            for (StaticData data : info.writtenStatic) {
                ret.prepend(new StoreInstruction(
                        ret.getBasicBlock(), info.staticMap.get(data),
                        data.getRegisterSize(), data
                ));
            }
        }
    }
}
