package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.nasm.NASMRegisterSet;
import com.lmxyy.mxcompiler.utils.CompilerOption;

import java.util.*;

public class GraphColoringAllocator extends RegisterAllocator {
    private static class VirtualRegisterInfo {
        Set<VirtualRegister> neighbour = new HashSet<>();
        int degree = 0;
        boolean deleted = false;
        Register color = null;
        Set<VirtualRegister> suggestSame = new HashSet<>();
    }

    private IRRoot irRoot;
    private int colors;

    private Map<VirtualRegister,VirtualRegisterInfo> infoMap = new HashMap();
    private Function curFunction = null;
    private Set<VirtualRegister> nodes = new HashSet<>();
    private Set<VirtualRegister> smallNodes = new HashSet<>();
    private Stack<VirtualRegister> stack = new Stack<>();
    private Set<PhysicalRegister> usedColor = new HashSet<>();
    private Collection<PhysicalRegister> physicalRegisters = new HashSet<>();
    private PhysicalRegister tmpReg1,tmpReg2;

    private Map<Register,Register> renameMap = new HashMap<>();

    private final int wordSize = CompilerOption.getSizeInt();

    public GraphColoringAllocator(IRRoot _irRoot,Collection<PhysicalRegister> _physicalRegisters
            ,PhysicalRegister _tmpReg1,PhysicalRegister _tmpReg2) {
        irRoot = _irRoot;
        colors = _physicalRegisters.size();
        tmpReg1 = _tmpReg1;
        tmpReg2 = _tmpReg2;
        physicalRegisters.addAll(_physicalRegisters);
    }

    private VirtualRegisterInfo getInfo(VirtualRegister reg) {
        VirtualRegisterInfo info = infoMap.get(reg);
        if (info == null) {
            info = new VirtualRegisterInfo();
            infoMap.put(reg,info);
        }
        return info;
    }

    private void addEdge(VirtualRegister x,VirtualRegister y) {
        getInfo(x).neighbour.add(y);
        getInfo(y).neighbour.add(x);
    }

    private void buildGraph() {
        curFunction.argRegList.forEach(this::getInfo);

        for (BasicBlock basicBlock:curFunction.getReversePostOrder()) {
            for (IRInstruction inst = basicBlock.getHead();inst != null;inst = inst.getNxt()) {
                Register defined = inst.getDefinedRegister();
                if (defined == null||!(defined instanceof VirtualRegister)) continue;
                VirtualRegisterInfo info = getInfo((VirtualRegister) defined);
                if (inst instanceof MoveInstruction) {
                    IntValue src = ((MoveInstruction) inst).getSource();
                    if (src instanceof VirtualRegister) {
                        info.suggestSame.add((VirtualRegister) src);
                        getInfo((VirtualRegister) src).suggestSame.add((VirtualRegister) defined);
                    }
                    inst.liveOut.stream().filter(x->x != defined).
                            forEach(x->addEdge(x,(VirtualRegister) defined));
                }
                else {
                    inst.liveOut.stream().filter(x->x != defined).
                            forEach(x->addEdge(x,(VirtualRegister) defined));
                }
            }
        }
        infoMap.values().forEach(x->x.degree = x.neighbour.size());
    }

    private void removeNode(VirtualRegister node) {
        VirtualRegisterInfo info = infoMap.get(node);
        for (VirtualRegister ni:info.neighbour) {
            VirtualRegisterInfo niInfo = infoMap.get(ni);
            if (!niInfo.deleted) {
                --niInfo.degree;
                if (niInfo.degree < colors) smallNodes.add(ni);
            }
        }
        info.deleted = true;
        stack.push(node);
        nodes.remove(node);
    }

    private void colorize() {
        infoMap.keySet().forEach(nodes::add);
        nodes.stream().filter(x->infoMap.get(x).degree < colors).forEach(smallNodes::add);
        while (!nodes.isEmpty()) {
            // there exists node whose degree is less than colors
            while (!smallNodes.isEmpty()) {
                Iterator<VirtualRegister> iter = smallNodes.iterator();
                VirtualRegister node = iter.next();
                iter.remove();
                removeNode(node);
            }
            if (nodes.isEmpty()) break;

            // there doesn't exist node whose degree is less than colors
            Iterator<VirtualRegister> iter = nodes.iterator();
            VirtualRegister node = iter.next();
            iter.remove();
            removeNode(node);
        }
        // stack is the sequence
        while (!stack.isEmpty()) {
            VirtualRegister node = stack.pop();
            VirtualRegisterInfo info = infoMap.get(node);
            usedColor.clear();
            for (VirtualRegister ni:info.neighbour) {
                VirtualRegisterInfo niInfo = infoMap.get(ni);
                if (!niInfo.deleted&&niInfo.color instanceof PhysicalRegister) {
                    usedColor.add((PhysicalRegister) niInfo.color);
                }
            }

            PhysicalRegister forced = node.forcedPhysicalRegister;
            if (forced != null) {
                assert !usedColor.contains(forced);
                info.color = forced;
            }
            else {
                for (VirtualRegister vr:info.suggestSame) {
                    Register reg = getInfo(vr).color;
                    if (reg != null&&reg instanceof PhysicalRegister&&!usedColor.contains(reg)) {
                        info.color = reg;
                        break;
                    }
                }
                if (info.color == null) {
                    for (PhysicalRegister pr : physicalRegisters) {
                        if (!usedColor.contains(pr)) {
                            info.color = pr;
                            break;
                        }
                    }
                    if (info.color == null) {
                        info.color = curFunction.argStackSlopMap.get(node);
                        if (info.color == null) {
                            info.color = new StackSlot(curFunction, node.getHintName());
                            curFunction.stackSlots.add((StackSlot) info.color);
                        }
                    }
                }
            }
            info.deleted = false;
        }
        curFunction.stackSlots.addAll(curFunction.argStackSlopMap.values());
    }

    private void rewrite() {
        for (BasicBlock basicBlock:curFunction.getReversePostOrder()) {
            for (IRInstruction inst = basicBlock.getHead();inst != null;inst = inst.getNxt()) {
                if (inst instanceof HeapAllocateInstruction) {
                    // do nothing here
                }
                else if (inst instanceof TwoAddressInstruction) {
                    Collection<Register> used = inst.getUsedRegister();
                    used.forEach(reg -> renameMap.put(reg, reg));
                    boolean tmpPR1Used = false;
                    if (((TwoAddressInstruction) inst).getRhs() instanceof VirtualRegister) {
                        VirtualRegister reg = (VirtualRegister) ((TwoAddressInstruction) inst).getRhs();
                        Register color = infoMap.get(reg).color;
                        if (color instanceof StackSlot) {
                            PhysicalRegister pr = tmpPR1Used ? tmpReg1 : tmpReg2;
                            inst.prepend(new LoadInstruction(basicBlock, pr, wordSize, color, 0));
                            tmpPR1Used = true;
                            renameMap.put(reg, pr);
                            curFunction.usedPhysicalGeneralRegister.add(pr);
                        } else {
                            renameMap.put(reg, color);
                            curFunction.usedPhysicalGeneralRegister.add((PhysicalRegister) color);
                        }
                    }
                    if (((TwoAddressInstruction) inst).getLhs() instanceof VirtualRegister&&
                            ((TwoAddressInstruction) inst).getOperator() != BinaryOperationInstruction.Operator.DIV &&
                            ((TwoAddressInstruction) inst).getOperator() != BinaryOperationInstruction.Operator.MOD) {
                        VirtualRegister reg = (VirtualRegister) ((TwoAddressInstruction) inst).getLhs();
                        Register color = infoMap.get(reg).color;
                        if (color instanceof StackSlot) {
                            PhysicalRegister pr = tmpPR1Used ? tmpReg1 : tmpReg2;
                            inst.prepend(new LoadInstruction(basicBlock, pr, wordSize, color, 0));
                            renameMap.put(reg, pr);
                            curFunction.usedPhysicalGeneralRegister.add(pr);
                            inst.append(new StoreInstruction(basicBlock, color, CompilerOption.getSizeInt(), 0, pr));
                            inst.setUsedRegister(renameMap);
                            inst = inst.getNxt();
                        } else {
                            renameMap.put(reg, color);
                            curFunction.usedPhysicalGeneralRegister.add((PhysicalRegister) color);
                            inst.setUsedRegister(renameMap);
                        }
                    } else inst.setUsedRegister(renameMap);
                }
                else {
                    Collection<Register> used = inst.getUsedRegister();
                    if (inst instanceof CallInstruction) {
                        List<IntValue> args = ((CallInstruction) inst).getArgRegList();
                        for (int i = 0; i < args.size(); ++i) {
                            IntValue val = args.get(i);
                            if (val instanceof VirtualRegister)
                                args.set(i, infoMap.get(val).color);
                        }
                    }
                    else {
                        if (!used.isEmpty()) {
                            boolean tmpReg1Used = false;
                            renameMap.clear();
                            for (Register reg:used) {
                                if (reg instanceof VirtualRegister) {
                                    Register color = infoMap.get(reg).color;
                                    if (color instanceof StackSlot) {
                                        PhysicalRegister pr = tmpReg1Used?tmpReg2:tmpReg1;
                                        inst.prepend(new LoadInstruction(basicBlock,pr,wordSize,color,0));
                                        tmpReg1Used = true;
                                        renameMap.put(reg,pr);
                                        curFunction.usedPhysicalGeneralRegister.add(pr);
                                    }
                                    else {
                                        renameMap.put(reg,color);
                                        curFunction.usedPhysicalGeneralRegister.add((PhysicalRegister) color);
                                    }
                                }
                                else {
                                    renameMap.put(reg,reg);
                                }
                            }
                            inst.setUsedRegister(renameMap);
                        }
                    }
                    Register defined = inst.getDefinedRegister();
                    if (defined instanceof VirtualRegister) {
                        Register color = infoMap.get(defined).color;
                        if (color instanceof StackSlot) {
                            inst.append(new StoreInstruction(basicBlock,color,0,wordSize,tmpReg1));
                            inst.setDefinedRegister(tmpReg1);
                            curFunction.usedPhysicalGeneralRegister.add(tmpReg1);
                            inst = inst.getNxt();
                        }
                        else {
                            inst.setDefinedRegister(color);
                            curFunction.usedPhysicalGeneralRegister.add((PhysicalRegister) color);
                        }
                    }
                }
            }
        }
    }

    private void modifyEntry(Function func) {
        BasicBlock entryBasicBlock = func.startBasicBlock;
        IRInstruction firstInst = entryBasicBlock.getHead();
//        if (func.argRegList.size() > 0) {
//            Register color = infoMap.get(func.argRegList.get(0)).color;
//            if (color instanceof StackSlot)
//                firstInst.prepend(new StoreInstruction(
//                        entryBasicBlock, color, 0,
//                        CompilerOption.getSizeInt(), NASMRegisterSet.RDI
//                ));
//            else firstInst.prepend(new MoveInstruction(entryBasicBlock, NASMRegisterSet.RDI, color));
//        }
//        if (func.argRegList.size() > 1) {
//            Register color = infoMap.get(func.argRegList.get(1)).color;
//            if (color instanceof StackSlot)
//                firstInst.prepend(new StoreInstruction(
//                        entryBasicBlock, color, 0,
//                        CompilerOption.getSizeInt(), NASMRegisterSet.RSI
//                ));
////            else firstInst.prepend(new MoveInstruction(entryBasicBlock, NASMRegisterSet.RSI, color));
//        }
//        if (func.argRegList.size() > 2) {
//            Register color = infoMap.get(func.argRegList.get(2)).color;
//            if (color instanceof StackSlot)
//                firstInst.prepend(new StoreInstruction(
//                        entryBasicBlock, color, 0,
//                        CompilerOption.getSizeInt(), NASMRegisterSet.RDX
//                ));
//            else firstInst.prepend(new MoveInstruction(entryBasicBlock, NASMRegisterSet.RDX, color));
//        }
//        if (func.argRegList.size() > 3) {
//            Register color = infoMap.get(func.argRegList.get(3)).color;
//            if (color instanceof StackSlot)
//                firstInst.prepend(new StoreInstruction(
//                        entryBasicBlock, color, 0,
//                        CompilerOption.getSizeInt(), NASMRegisterSet.RCX
//                ));
//            else firstInst.prepend(new MoveInstruction(entryBasicBlock, NASMRegisterSet.RCX, color));
//        }
//        if (func.argRegList.size() > 4) {
//            Register color = infoMap.get(func.argRegList.get(4)).color;
//            if (color instanceof StackSlot)
//                firstInst.prepend(new StoreInstruction(
//                        entryBasicBlock, color, 0,
//                        CompilerOption.getSizeInt(), NASMRegisterSet.R8
//                ));
//            else firstInst.prepend(new MoveInstruction(entryBasicBlock, NASMRegisterSet.R8, color));
//        }
//        if (func.argRegList.size() > 5) {
//            Register color = infoMap.get(func.argRegList.get(5)).color;
//            if (color instanceof StackSlot)
//                firstInst.prepend(new StoreInstruction(
//                        entryBasicBlock, color, 0,
//                        CompilerOption.getSizeInt(), NASMRegisterSet.R9
//                ));
//            else firstInst.prepend(new MoveInstruction(entryBasicBlock, NASMRegisterSet.R9, color));
//        }
//        for (int i = 6;i < func.argRegList.size();++i) {
//            Register color = infoMap.get(func.argRegList.get(i)).color;
//            if (color instanceof PhysicalRegister) {
//                firstInst.prepend(new LoadInstruction(
//                        entryBasicBlock, color, CompilerOption.getSizeInt(),
//                        NASMRegisterSet.RBP, (i - 4) * wordSize
//                ));
//            }
//        }
    }

    public void run() {
        new LivenessAnalysis(irRoot).run();
        for (Function func:irRoot.functions.values()) {
            curFunction = func;

            buildGraph();
            colorize();
            rewrite();
            //modifyEntry(func);
        }
    }
}
