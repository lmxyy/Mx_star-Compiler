package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.nasm.NASMRegister;

import java.io.PrintStream;
import java.util.*;

public class IRPrinter implements IRVisitor {
    private PrintStream out;
    private Set<BasicBlock> BBVisited = new HashSet<>();
    private Map<BasicBlock, String> labelMap = new HashMap<>();
    private Map<StaticData, String> dataMap = new HashMap<>();
    private Map<VirtualRegister, String> regMap;
    private Map<String, Integer> counterReg;
    private Map<String, Integer> counterBB = new HashMap<>();
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
            id = newId(reg.getHintName() != null?reg.getHintName():"t",counterReg);
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
        node.stringPool.values().forEach(str->str.accept(this));
        if (!node.dataList.isEmpty()||!node.stringPool.isEmpty()) out.println();
        definingStatic = false;
        node.functions.values().forEach(fun->fun.accept(this));
    }

    @Override
    public void visit(BasicBlock node) {
        if (BBVisited.contains(node)) return;
        BBVisited.add(node);
        out.println("%"+labelId(node)+":");
        for (IRInstruction inst = node.getHead();inst != null;inst = inst.getNxt()) {
            visit(inst);
        }
    }

    @Override
    public void visit(Function node) {
        regMap = new HashMap<>(); counterReg = new IdentityHashMap<>();
        out.printf("func %s ",node.getName());
        node.argRegList.forEach(reg->out.printf("$%s ",regId(reg)));
        out.println("{\n");
        node.getReversePostOrder().forEach(basicBlock->visit(basicBlock));
        out.println("}\n");
    }

    public void visit(IRInstruction node) {
        node.accept(this);
    }

    public void visit(BinaryOperationInstruction node) {
        node.accept(this);
    }

    @Override
    public void visit(ArithmeticInstruction node) {
        out.printf("    ");
        String op = null;
        switch (node.getOperator()) {
            case ADD: op = "add"; break;
            case SUB: op = "sub"; break;
            case MUL: op = "mul"; break;
            case DIV: op = "div"; break;
            case MOD: op = "rem"; break;
            case SHL: op = "shl"; break;
            case SHR: op = "ashr"; break;
            case AND: op = "and"; break;
            case OR: op = "or"; break;
            case XOR: op = "xor"; break;
            default: assert false; break;
        }

        visit(node.getDest());
        out.printf(" = %s ", op);
        visit(node.getLhs());
        out.printf(" ");
        visit(node.getRhs());
        out.println();
    }
    @Override
    public void visit(ComparisionInstruction node) {
        out.print("    ");
        String op = null;
        switch (node.getOperator()) {
            case EQU: op = "seq"; break;
            case NEQ: op = "sne"; break;
            case GRTR: op = "sgt"; break;
            case GEQ: op = "sge"; break;
            case LESS: op = "slt"; break;
            case LEQ: op = "sle"; break;
            default: assert false; break;
        }

        visit(node.getDest());
        out.printf(" = %s ", op);
        visit(node.getLhs());
        out.printf(" ");
        visit(node.getRhs());
        out.println();
    }

    @Override
    public void visit(UnaryOperationInstruction node) {
        out.print("    ");
        String op = null;
        switch (node.getOperator()) {
            case NEG: op = "neg"; break;
            case COMP: op = "not"; break;
            default: assert false;
        }

        visit(node.getDest());
        out.printf(" = %s ", op);
        visit(node.getOprand());
        out.println();
    }

    @Override
    public void visit(CallInstruction node) {
        out.print("    ");
        if (node.getRegister() != null) {
            visit(node.getRegister());
            out.print(" = ");
        }
        out.printf("call %s ",node.getFunction().getName());
        node.getArgRegList().forEach(arg -> {
            arg.accept(this);
            out.print(" ");
        });
        out.println();
    }

    public void visit(EndInstruction node) {
        node.accept(this);
    }
    @Override
    public void visit(BranchInstruction node) {
        out.print("    br ");
        visit(node.getIndicator());
        out.println(" %" + labelId(node.getIfTrue()) + " %" + labelId(node.getIfFalse()));
        out.println();
    }
    @Override
    public void visit(JumpInstruction node) {
        out.printf("    jump %%%s\n\n", labelId(node.getTarget()));
    }

    @Override
    public void visit(ReturnInstruction node) {
        out.print("    ret ");
        if (node.getRetVal() != null)
            visit(node.getRetVal());
        else out.print("0");
        out.println();
        out.println();
    }

    @Override
    public void visit(HeapAllocateInstruction node) {
        out.print("    ");
        visit(node.getDest());
        out.printf(" = alloc ");
        visit(node.getAllocSize());
        out.println();
    }

    @Override
    public void visit(LoadInstruction node) {
        out.print("    ");
        visit(node.getDest());
        out.printf(" = load %d ", node.getSize());
        visit(node.getAddr());
        out.println(" " + node.getOffset());
    }

    @Override
    public void visit(MoveInstruction node) {
        out.print("    ");
        visit(node.getDest());
        out.print(" = move ");
        visit(node.getSource());
        out.println();
    }

    @Override
    public void visit(StoreInstruction node) {
        out.printf("    store %d ", node.getSize());
        visit(node.getAddr());
        out.print(" ");
        visit(node.getValue());
        out.printf(" %d\n",node.getOffset());
    }

    @Override
    public void visit(PushInstruction node) {

    }

    @Override
    public void visit(PopInstruction node) {

    }

    @Override
    public void visit(LeaveInstruction node) {

    }

    @Override
    public void visit(CqoInstruction node) {

    }

    @Override
    public void visit(StackSlot node) {

    }

    @Override
    public void visit(TwoAddressInstruction node) {

    }
    public void visit(IntValue node) {
        node.accept(this);
    }
    @Override
    public void visit(VirtualRegister node) {
        out.print("$" + regId(node));
    }

    @Override
    public void visit(PhysicalRegister node) {

    }


    @Override
    public void visit(NASMRegister node) {
        out.print(node.getName());
    }
    public void visit(StaticData node) {
        node.accept(this);
    }
    @Override
    public void visit(StaticSpace node) {
        if (definingStatic) out.printf("space @%s %d\n", dataId(node), node.getRegisterSize());
        else out.print("@" + dataId(node));
    }

    @Override
    public void visit(StaticString node) {
        if (definingStatic) out.printf("asciiz @%s %s\n", dataId(node), node.getString());
        else out.print("@" + dataId(node));
    }

    @Override
    public void visit(IntImmediate node) {
        out.print(node.getVal());
    }
}
