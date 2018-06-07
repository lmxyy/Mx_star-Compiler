package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.symbol.ExprOperator;
import com.lmxyy.mxcompiler.symbol.SymbolInfo;

import java.util.*;

public class VirtualRegisterInjector implements ASTVisitor {
    private IRRoot irRoot;
    public VirtualRegisterInjector(IRRoot _irRoot) {
        irRoot = _irRoot;
    }

    private static class IntValueInfo {
        public Set<IntValue> toNode = new HashSet<>();
    }
    private static class BasicBlockInfo {
        public Set<IntValue> usedIntValue = new HashSet<>();
        public Set<IntValue> defineIntValue = new HashSet<>();
    }

    private Map<IntValue,IntValueInfo> ivMap = new HashMap<>();
    private Map<BasicBlock,BasicBlockInfo> bbMap = new HashMap<>();

    private void addEdge(IntValue x,IntValue y) {
        IntValueInfo xInfo = ivMap.get(x);
        xInfo.toNode.add(x);
    }

    private void processFunction(Function func) {
        Set<IntValue> usedIntValue = new HashSet<>();
        for (BasicBlock basicBlock:func.getReversePostOrder()) {
            BasicBlockInfo basicBlockInfo = new BasicBlockInfo();
            bbMap.put(basicBlock,basicBlockInfo);
            for (IRInstruction inst = basicBlock.getHead();inst != null;inst = inst.getNxt()) {
                if (inst instanceof CallInstruction) ((CallInstruction) inst).callReloadUsedRegisterCollection();
                inst.getUsedIntValue().forEach(v->basicBlockInfo.usedIntValue.add(v));
                if (inst.getDefinedRegister() != null) {
                    basicBlockInfo.usedIntValue.add(inst.getDefinedRegister());
                    basicBlockInfo.defineIntValue.add(inst.getDefinedRegister());
                }
            }
            usedIntValue.addAll(basicBlockInfo.usedIntValue);
        }
        usedIntValue.forEach(val->{
            IntValueInfo ivInfo = new IntValueInfo();
            ivMap.put(val,ivInfo);
        });
        for (BasicBlock basicBlock:func.getReversePostOrder()) {
            for (IRInstruction inst = basicBlock.getHead();inst != null;inst = inst.getNxt()) {
                if (inst instanceof BranchInstruction) {
                    BranchInstruction branch = (BranchInstruction)inst;
                    BasicBlockInfo ifTrueBlockInfo = bbMap.get(branch.getIfTrue());
                    BasicBlockInfo ifFalseBlockInfo = bbMap.get(branch.getIfFalse());
                    ifTrueBlockInfo.defineIntValue.forEach(val->addEdge(val,branch.getIndicator()));
                    ifFalseBlockInfo.defineIntValue.forEach(val->addEdge(val,branch.getIndicator()));
                }
                else if (inst instanceof ReturnInstruction) {
                    if (((ReturnInstruction) inst).getRetVal() != null) {
                        ((ReturnInstruction) inst).getRetVal().important = true;
                    }
                }
                else {
                    IntValue defined = inst.getDefinedRegister();
                    if (defined != null) {
                        inst.getUsedIntValue().forEach(v->addEdge(defined,v));
                    }
                    if (inst instanceof CallInstruction) {
                        inst.getUsedIntValue().forEach(v->v.important = true);
                    }
                }
            }
        }
        usedIntValue.forEach(v->{
            if (v instanceof StaticData) v.important = true;
        });
        Queue<IntValue> team = new LinkedList<>();
        usedIntValue.forEach(v->{
            if (v.important) team.offer(v);
        });
        while (!team.isEmpty()) {
            IntValue now = team.poll(); IntValueInfo nowInfo = ivMap.get(now);
            nowInfo.toNode.forEach(to->{
                if (!to.important) team.offer(to);
            });
        }
    }

    public void run() {
        irRoot.functions.values().forEach(func->processFunction(func));
    }

    @Override
    public void visit(DefunNode node) {
        visit(node.getBody());
    }

    @Override
    public void visit(DefvarNode node) {
        if (node.getInit() != null) {
            visit(node.getInit());
            node.usedIntValue.addAll(node.getInit().usedIntValue);
        }
        SymbolInfo info = node.scope.getInfo(node.getName());
        node.usedIntValue.add(info.register);
    }

    @Override
    public void visit(DefclassNode node) {
        // Data-oriented Programming
    }

    @Override
    public void visit(DefvarlistNode node) {
        node.getVars().forEach(var->var.accept(this));
    }

    @Override
    public void visit(VartypeNode node) {
    }

    @Override
    public void visit(VartypePlusNode node) {
        node.getDims().forEach(dim->{
            dim.accept(this);
            node.usedIntValue.addAll(dim.usedIntValue);
        });
    }

    @Override
    public void visit(IfStmtNode node) {
        node.getCond().accept(this);
        node.usedIntValue.addAll(node.getCond().usedIntValue);
        node.getBlock1().accept(this);
        node.usedIntValue.addAll(node.getBlock1().usedIntValue);
        if (node.isHasElse()) {
            node.getBlock2().accept(this);
            node.usedIntValue.addAll(node.getBlock2().usedIntValue);
        }
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.getCond().accept(this);
        node.usedIntValue.addAll(node.getCond().usedIntValue);
        node.getBlock().accept(this);
        node.usedIntValue.addAll(node.getBlock().usedIntValue);
    }

    @Override
    public void visit(ForStmtNode node) {
        if (node.getInit1() != null) {
            node.getInit1().accept(this);
            node.usedIntValue.addAll(node.getInit1().usedIntValue);
        }
        if (node.getInit2() != null) {
            node.getInit2().forEach(x->x.accept(this));
            node.getInit2().forEach(x->node.usedIntValue.addAll(x.usedIntValue));
        }
        if (node.getCond() != null) {
            node.getCond().accept(this);
            node.usedIntValue.addAll(node.getCond().usedIntValue);
        }
        if (node.getInit2() != null) {
            node.getStep().forEach(x->x.accept(this));
            node.getStep().forEach(x->node.usedIntValue.addAll(x.usedIntValue));
        }
        node.getBlock().accept(this);
        node.usedIntValue.addAll(node.getBlock().usedIntValue);
    }

    @Override
    public void visit(ContinueStmtNode node) {

    }

    @Override
    public void visit(BreakStmtNode node) {

    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.getExpr() != null) {
            node.getExpr().accept(this);
            node.usedIntValue.addAll(node.getExpr().usedIntValue);
        }
    }

    @Override
    public void visit(BlankStmtNode node) {

    }

    @Override
    public void visit(BlockNode node) {
        node.getStmts().forEach(x->x.accept(this));
        node.getStmts().forEach(x->{node.usedIntValue.addAll(x.usedIntValue);});
    }

    @Override
    public void visit(IdentifierNode node) {
        node.usedIntValue.add(node.intValue);
    }

    @Override
    public void visit(StringliteralNode node) {
        node.usedIntValue.add(node.intValue);
    }

    @Override
    public void visit(IntegerliteralNode node) {
        node.usedIntValue.add(node.intValue);
    }

    @Override
    public void visit(BooleanliteralNode node) {
        node.usedIntValue.add(node.intValue);
    }

    @Override
    public void visit(NullNode node) {
        node.usedIntValue.add(node.intValue);
    }

    @Override
    public void visit(VariableNode node) {
        if (node.isThis()||node.getExpr() != null||(node.getId() != null&&node.getVar() != null)) {
            VirtualRegister vr = new VirtualRegister(null);
            vr.important = true;
            node.usedIntValue.add(vr);
            return;
        }
        if (node.getVar() != null) {
            node.getVar().accept(this);
            node.usedIntValue.addAll(node.getVar().usedIntValue);
        }
        if (node.getId() != null) {
            node.getId().accept(this);
            node.usedIntValue.addAll(node.getId().usedIntValue);
        }
        if (node.intValue != null)
            node.usedIntValue.add(node.intValue);
    }

    @Override
    public void visit(CallfunNode node) {
        VirtualRegister vr = new VirtualRegister(null);
        vr.important = true;
        node.usedIntValue.add(vr);
    }

    @Override
    public void visit(AssignmentNode node) {
        node.getVariable().accept(this);
        node.usedIntValue.addAll(node.getVariable().usedIntValue);
        node.getExpr().accept(this);
        node.usedIntValue.addAll(node.getExpr().usedIntValue);
    }

    @Override
    public void visit(ExpressionNode node) {
        if (node.getOp().getOp() == ExprOperator.Operator.ARRAY||node.getOp().getOp() == ExprOperator.Operator.MEM
                ||node.getOp().getOp() == ExprOperator.Operator.LESH||node.getOp().getOp() == ExprOperator.Operator.RISH||
                node.getOp().getOp() == ExprOperator.Operator.MOD||node.getOp().getOp() == ExprOperator.Operator.DIVIDE) {
            VirtualRegister vr = new VirtualRegister(null);
            vr.important = true;
            node.usedIntValue.add(vr);
            return;
        }
        node.getExprs().forEach(x->x.accept(this));
        node.getExprs().forEach(x->node.usedIntValue.addAll(x.usedIntValue));
        if (node.intValue != null)
            node.usedIntValue.add(node.intValue);
    }

    @Override
    public void visit(ProgNode node) {
        node.getDefs().forEach(def->def.accept(this));
    }
}
