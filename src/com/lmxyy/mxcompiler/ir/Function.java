package com.lmxyy.mxcompiler.ir;

import com.lmxyy.mxcompiler.symbol.FunctionType;

import java.util.*;

public class Function {
    FunctionType type;
    public BasicBlock startBasicBlock = null,exitBasicBlock = null;
    public List<VirtualRegister> argVarRegList = new ArrayList<>();
    public List<ReturnInstruction> retInstruction = new ArrayList<>();

    private Set<BasicBlock> visited = null;
    private List<BasicBlock> reversePostOrder = null;

    public Function(FunctionType _type) {
        type = _type;
        startBasicBlock = new BasicBlock(this,type.getName()+".entry");
    }

    public FunctionType getType() {
        return type;
    }
    public String getConvertedName() {
        if (type == null) return null;
        else {
            String name = type.getName();
            if (name.contains(".")) {
                String [] strings = name.split(".");
                return "_"+strings[0]+strings[1];
            }
            else return name;
        }
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

    @Override
    public String toString() {
        return getName();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
