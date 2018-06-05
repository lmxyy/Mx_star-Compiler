package com.lmxyy.mxcompiler.ir;

import com.lmxyy.mxcompiler.symbol.FunctionType;

import java.util.*;

public class Function {
    FunctionType type;
    public BasicBlock startBasicBlock = null,exitBasicBlock = null;
    public List<VirtualRegister> argRegList = new ArrayList<>();
    public List<ReturnInstruction> retInstruction = new ArrayList<>();

    public Set<PhysicalRegister> usedPhysicalGeneralRegister = new HashSet<>();
    public Map<VirtualRegister,StackSlot> argStackSlopMap = new HashMap<>();
    public Set<StackSlot> stackSlots = new HashSet<>();
    public Set<Function> calleeSet = new HashSet<>();

    private Set<BasicBlock> visited = null;
    private List<BasicBlock> reversePostOrder = null;
    private List<BasicBlock> reversePreOrder = null;

    private String callName = null;

    public Function(FunctionType _type) {
        if (_type == null) return;
        type = _type;
        startBasicBlock = new BasicBlock(this,type.getName()+".entry");
    }

    public FunctionType getType() {
        return type;
    }
    public String getConvertedName() {
        if (getName().equals("main")) return "main";
        else if (IRRoot.isBuiltinFunction(this)) return callName;
        else return "___"+getName();
    }
    public String getName() {
        if (type == null) return null;
        else {
            return type.getName();
        }
    }

    private void dfsPostOrd(BasicBlock basicBlock) {
        if (visited.contains(basicBlock)) return;
        visited.add(basicBlock);
        basicBlock.getSucc().forEach(succ->dfsPostOrd(succ));
        reversePostOrder.add(basicBlock);
    }
    private void calcReversePostOrder() {
        reversePostOrder = new ArrayList<>();
        visited = new HashSet<>();
        dfsPostOrd(startBasicBlock);
        Collections.reverse(reversePostOrder);
    }
    public List<BasicBlock> getReversePostOrder() {
        if (reversePostOrder == null) calcReversePostOrder();
        return reversePostOrder;
    }

    private void dfsPreOrd(BasicBlock basicBlock) {
        if (visited.contains(basicBlock)) return;
        visited.add(basicBlock);
        reversePreOrder.add(basicBlock);
        basicBlock.getSucc().forEach(succ->dfsPreOrd(succ));
    }
    private void calcReversePreOrder() {
        reversePreOrder = new ArrayList<>();
        visited = new HashSet<>();
        dfsPreOrd(startBasicBlock);
        Collections.reverse(reversePreOrder);
    }
    public List<BasicBlock> getReversePreOrder() {
        if (reversePreOrder == null) calcReversePreOrder();
        return reversePreOrder;
    }

    public void setCallName(String _callName) {
        callName = _callName;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
