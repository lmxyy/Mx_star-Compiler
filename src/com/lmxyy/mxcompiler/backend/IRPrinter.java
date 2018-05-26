package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;

import java.io.PrintStream;
import java.util.*;

public class IRPrinter implements IRVisitor {
    private PrintStream out;
    private Map<BasicBlock, Boolean> BBVisited = new HashMap<>();
    private Map<BasicBlock, String> labelMap = new HashMap<>();
    private Map<StaticData, String> dataMap = new HashMap<>();
    private Map<VirtualRegister, String> regMap = new HashMap<>();
    private Map<String, Integer> counterReg = new HashMap<>();
    private Map<String, Integer> counterBB = new HashMap<>();
    private Map<String, Integer> counterData = new HashMap<>();
    private boolean definingStatic = true;

    public IRPrinter(PrintStream _out) {
        out = _out;
    }

    private String newId(String name,Map<String,Integer> counter) {
        int cnt = counter.getOrDefault(name,0)+1;
        counter.put(name,cnt);
        if (cnt == 1) return name;
        else return name+"_"+cnt;
    }


    private String regId(VirtualRegister reg) {
        String id = regMap.get(reg);
        if (id == null) {
            id = newId(reg.getHintName() == null?reg.getHintName():"t",counterReg);
            regMap.put(reg,id);
        }
        return id;
    }
    private String labelId(BasicBlock basicBlock) {
        String id = labelMap.get(basicBlock);
        if (id == null) {
            id = newId(basicBlock.getHintName(), counterBB);
            labelMap.put(basicBlock, id);
        }
        return id;
    }
    private String dataId(StaticData data) {
        String id = dataMap.get(data);
        if (id == null) {
            id = newId(data.getHintName(), counterBB);
            dataMap.put(data, id);
        }
        return id;
    }

    @Override
    public void visit(IRRoot node) {
        node.dataList.forEach(data->data.accept(this));
    }

    @Override
    public void visit(BasicBlock node) {

    }

    @Override
    public void visit(Function node) {

    }

    @Override
    public void visit(ArithmeticInstruction node) {

    }

    @Override
    public void visit(UnaryOperationInstruction node) {

    }

    @Override
    public void visit(ComparisionInstruction node) {

    }

    @Override
    public void visit(CallInstruction node) {

    }

    @Override
    public void visit(BinaryOperationInstruction node) {

    }

    @Override
    public void visit(BranchInstruction node) {

    }

    @Override
    public void visit(HeapAllocateInstruction node) {

    }

    @Override
    public void visit(JumpInstruction node) {

    }

    @Override
    public void visit(LoadInstruction node) {

    }

    @Override
    public void visit(MoveInstruction node) {

    }

    @Override
    public void visit(StoreInstruction node) {

    }

    @Override
    public void visit(VirtualRegister node) {

    }

    @Override
    public void visit(PhysicalRegister node) {

    }

    @Override
    public void visit(StaticSpace node) {

    }

    @Override
    public void visit(StaticString node) {

    }

    @Override
    public void visit(IntImmediate node) {

    }
}
