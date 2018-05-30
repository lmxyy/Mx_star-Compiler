package com.lmxyy.mxcompiler.nasm;

import com.lmxyy.mxcompiler.ir.*;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NASMPrinter implements IRVisitor {
    private PrintStream out;
    private Set<BasicBlock> BBVisited = new HashSet<>();
    private Map<BasicBlock, String> labelMap = new HashMap<>();
    private Map<StaticData, String> dataMap = new HashMap<>();
    private Map<String, Integer> counterBB = new HashMap<>();

    public NASMPrinter(PrintStream _out) {
        out = _out;
    }
    private String newId(String name,Map<String,Integer> counter) {
        int cnt = counter.getOrDefault(name,0)+1;
        counter.put(name,cnt);
        if (cnt == 1) return name;
        else return name+"_"+cnt;
    }

    private String labelId(BasicBlock basicBlock) {
        String id = labelMap.get(basicBlock);
        if (id == null) {
            id = newId(basicBlock.getParent().getConvertedName()+".."+basicBlock.getHintName(), counterBB);
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
        /* TODO Some Global Information here. */
        out.println("\tglobal main\n");
        out.println("\tsection .text");
        node.functions.values().forEach(func->func.accept(this));
        /* Static String */
        out.println("\tsection .data");
        node.stringPool.forEach((a,b)->{
            out.println(dataId(b)+":");
            out.println("\tdb "+a.length()+','+a+','+0);
        });
        out.println("\tsection .bss");
        node.dataList.forEach(data->{
            out.println(dataId(data)+":");
            out.println("\tdb resb "+data.getRegisterSize()*8);
        });
    }

    @Override
    public void visit(BasicBlock node) {
        if (BBVisited.contains(node)) return;
        BBVisited.add(node);
        out.println(labelId(node)+":");
        for (IRInstruction inst = node.getHead();inst != null;inst = inst.getNxt()) {
            inst.accept(this);
        }
    }

    @Override
    public void visit(Function node) {
        out.println(node.getConvertedName()+":");
        node.getReversePostOrder().forEach(basicBlock->visit(basicBlock));
    }

    @Override
    public void visit(ArithmeticInstruction node) {
        if (node.getOperator() == BinaryOperationInstruction.Operator.DIV
                || node.getOperator() == BinaryOperationInstruction.Operator.MOD) {
            out.print("\tidiv ");
            node.getRhs().accept(this);
            out.print('\n');
        }
        else {
            System.err.println("Reach the thress address instruction.");
            assert false;
        }
    }

    @Override
    public void visit(UnaryOperationInstruction node) {
        out.print("\t");
        if (node.getOperator() == UnaryOperationInstruction.Operator.NEG) {
            out.print("neg ");
        }
        else if (node.getOperator() == UnaryOperationInstruction.Operator.COMP) {
            out.print("not ");
        }
        else {
            System.err.println("Get a strange operator.");
            assert false;
        }
        node.getOprand().accept(this);
        out.print('\n');
    }

    @Override
    public void visit(ComparisionInstruction node) {
        out.println("\tcmp ");
        node.getLhs().accept(this);
        out.println(',');
        node.getRhs().accept(this);
        out.print("\n\t");
        switch (node.getOperator()) {
            case EQU:
                out.println("sete ");
                break;
            case NEQ:
                out.println("setne ");
                break;
            case LESS:
                out.println("setl ");
                break;
            case LEQ:
                out.println("setle ");
                break;
            case GRTR:
                out.println("setg ");
                break;
            case GEQ:
                out.println("setge ");
                break;
            default: System.err.println("Unknown comparision operator."); break;
        }
        node.getDest().accept(this);
        out.print('\n');
    }

    @Override
    public void visit(CallInstruction node) {
        out.println("\tcall "+node.getFunction().getConvertedName());
    }

    @Override
    public void visit(BranchInstruction node) {
        out.print("\tcmp ");
        node.getIndicator().accept(this);
        out.println("1");
        out.println("\tjz "+labelId(node.getIfTrue()));
        out.println("\tjnz "+labelId(node.getIfFalse()));
    }

    @Override
    public void visit(HeapAllocateInstruction node) {
        out.println("\tcall malloc");
    }

    @Override
    public void visit(JumpInstruction node) {
        out.println("\tjmp "+labelId(node.getTarget()));
    }

    @Override
    public void visit(LoadInstruction node) {
        out.print("\tmov");
        node.getDest().accept(this);
        out.print(",[");
        node.getAddr().accept(this);
        if (node.getOffset() > 0) out.print('+');
        out.print(node.getOffset());
        out.print("]\n");
    }

    @Override
    public void visit(MoveInstruction node) {
        out.print("\tmov ");
        node.getDest().accept(this);
        out.print(',');
        node.getSource().accept(this);
        out.print('\n');
    }

    @Override
    public void visit(StoreInstruction node) {
        out.print("\tmov [");
        node.getAddr().accept(this);
        if (node.getOffset() > 0) out.print('+');
        out.print(node.getOffset());
        out.print(',');
        node.getValue().accept(this);
        out.print('\n');
    }

    @Override
    public void visit(ReturnInstruction node) {
        out.println("\tret");
    }

    @Override
    public void visit(TwoAddressInstruction node) {
        out.print('\t');
        switch (node.getOperator()) {
            case ADD:
                out.print("add ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case SUB:
                out.print("sub ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case MUL:
                out.print("imul ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case DIV: case MOD:
                out.print("idiv ");
                node.getRhs().accept(this);
                break;
            case XOR:
                out.print("xor ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case OR:
                out.print("or ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case AND:
                out.print("and ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case SHL:
                out.print("sal ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case SHR:
                out.print("sar ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            default: System.err.println("Unknown operator in two address operation."); break;
        }
        out.print('\n');
    }

    @Override
    public void visit(PushInstruction node) {
        out.print("\tpush ");
        if (node.isAddress()) {
            out.print('[');
            node.getOprand().accept(this);
            if (node.getOffset() > 0) out.print('+');
            out.print(node.getOffset());
            out.print(']');
        }
        else {
            node.getOprand().accept(this);
        }
        out.print('\n');
    }

    @Override
    public void visit(PopInstruction node) {
        // nothing to do here, cannot be here.
        System.err.println("Invalid pop instruction.");
        assert false;
    }

    @Override
    public void visit(LeaveInstruction node) {
        out.println("leave");
    }

    @Override
    public void visit(CltdInstruction node) {
        out.println("cltd");
    }

    @Override
    public void visit(VirtualRegister node) {
        System.err.println("Virtual registers still exist.");
        assert false;
    }

    @Override
    public void visit(PhysicalRegister node) {
        node.accept(this);
    }

    @Override
    public void visit(NASMRegister node) {
        out.print(node.getName());
    }

    @Override
    public void visit(StaticSpace node) {
        out.print(node.getHintName());
    }

    @Override
    public void visit(StaticString node) {
        out.print(node.getHintName());
    }

    @Override
    public void visit(IntImmediate node) {
        out.print(node.getVal());
    }

    @Override
    public void visit(StackSlot node) {
        // nothing to do here, cannot be here.
        System.err.println("Stack slots do not exist.");
        assert false;
    }
}
