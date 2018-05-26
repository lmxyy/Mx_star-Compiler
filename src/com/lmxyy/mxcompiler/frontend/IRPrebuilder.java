package com.lmxyy.mxcompiler.frontend;

import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.ir.*;
import com.lmxyy.mxcompiler.symbol.FunctionType;
import com.lmxyy.mxcompiler.symbol.GlobalSymbolTable;
import com.lmxyy.mxcompiler.symbol.SymbolInfo;
import com.lmxyy.mxcompiler.utils.WarningInfo;

public class IRPrebuilder implements ASTVisitor {
    private GlobalSymbolTable globalSymbolTable;
    private IRRoot irRoot;
    private String className = null;

    public IRPrebuilder(GlobalSymbolTable _globalSymbolTable,IRRoot _irRoot) {
        globalSymbolTable = _globalSymbolTable;
        irRoot = _irRoot;
    }

    @Override
    public void visit(DefunNode node) {
        Function function = null;
        if (className == null)
            function = new Function((FunctionType) globalSymbolTable.resolveType(node.getName()),null);
        else
            function = new Function((FunctionType) globalSymbolTable.resolveType(
                    className+"."+node.getName()),new VirtualRegister("thisaddress"));
        irRoot.functions.put(function.getType().getName(),function);
    }

    @Override
    public void visit(DefvarNode node) {
        SymbolInfo info = node.scope.getInfo(node.getName());
        if (node.scope == globalSymbolTable.globals) {
            StaticData data = new StaticSpace(node.getName(),info.getType().getRegisterSize());
            info.register = data; irRoot.dataList.add(data);
        }
        else {
            VirtualRegister reg = new VirtualRegister(node.getName());
            info.register = reg;
        }
    }

    @Override
    public void visit(DefclassNode node) {
        className = node.getName();
        if (node.getConstructor() != null) {
            irRoot.functions.put(
                    className,new Function(globalSymbolTable.resolveConstructor(className),
                            new VirtualRegister("thisaddress")
                    )
            );
        }
        node.getFunMembers().forEach(fun->fun.accept(this));
        className = null;
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
    }

    @Override
    public void visit(IfStmtNode node) {
        visit(node.getBlock1());
        if (node.isHasElse())
            visit(node.getBlock2());
    }

    @Override
    public void visit(WhileStmtNode node) {
        visit(node.getBlock());
    }

    @Override
    public void visit(ForStmtNode node) {
        if (node.getInit1() != null)
            visit(node.getInit1());
        visit(node.getBlock());
    }

    @Override
    public void visit(ContinueStmtNode node) {
    }

    @Override
    public void visit(BreakStmtNode node) {
    }

    @Override
    public void visit(ReturnStmtNode node) {
    }

    @Override
    public void visit(BlankStmtNode node) {
    }

    @Override
    public void visit(BlockNode node) {
        node.getStmts().forEach(stmt->stmt.accept(this));
    }

    @Override
    public void visit(IdentifierNode node) {
    }

    @Override
    public void visit(StringliteralNode node) {
    }

    @Override
    public void visit(IntegerliteralNode node) {
    }

    @Override
    public void visit(BooleanliteralNode node) {
    }

    @Override
    public void visit(NullNode node) {
    }

    @Override
    public void visit(VariableNode node) {
    }

    @Override
    public void visit(CallfunNode node) {
    }

    @Override
    public void visit(AssignmentNode node) {
    }

    @Override
    public void visit(ExpressionNode node) {
    }

    @Override
    public void visit(ProgNode node) {
        node.getDefs().forEach(def->def.accept(this));
    }

    public void visit(StmtNode node) {
        node.accept(this);
    }

    public IRRoot getIrRoot() {
        return irRoot;
    }
}
