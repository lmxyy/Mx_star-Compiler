package com.lmxyy.mxcompiler.frontend;

import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.symbol.*;
import com.lmxyy.mxcompiler.utils.ParamChecker;

import java.util.ArrayList;
import java.util.List;

public class SemanticChecker implements Visitor {
    private GlobalSymbolTable globalSymbolTable;
    private SymbolTable symbolTable,curScope;

    public SemanticChecker(GlobalSymbolTable _globalSymbolTable) {
        globalSymbolTable = _globalSymbolTable;
        curScope = _globalSymbolTable.globals;
    }

    @Override
    public void visit(ProgNode node) {
        node.scope = curScope;
    }

    @Override
    public void visit(DefunNode node) {

    }

    @Override
    public void visit(DefvarNode node) {
        node.scope = curScope;
        if (curScope.getCurInfo(node.getName()) != null) {
            // 变量重名
        }
        VartypeNode type = globalSymbolTable.resolveType(node.getType().getName());
        if (type == null) {
            // 无此类型
        }
        if (node.getInit() != null) {
            visit(node.getInit());
            if (!node.getInit().getType().equals(node.getType())) {
                // 不是同一个类型
            }
        }
    }

    @Override
    public void visit(DefvarlistNode node) {
        node.scope = curScope;
        node.getVars().forEach(this::visit);
    }

    @Override
    public void visit(DefclassNode node) {
        node.scope = curScope;
    }

    @Override
    public void visit(VartypeNode node) {}

    @Override
    public void visit(VartypePlusNode node) {

    }

    @Override
    public void visit(IfStmtNode node) {
        node.scope = curScope;
        visit(node.getCond());
        if (!node.getCond().getType().isBool()) {
            // 条件表达式里的值不是bool
        }
        curScope = new SymbolTable(curScope);
        visit(node.getBlock1());
        curScope = curScope.getEnclosingScope();
        if (node.isHasElse()) {
            curScope = new SymbolTable(curScope);
            visit(node.getBlock2());
        }
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.scope = curScope;
        visit(node.getCond());
        if (!node.getCond().getType().isBool()) {
            // 条件表达式的值不是bool
        }
        curScope = new SymbolTable(curScope);
        curScope.setLoop();
        visit(node.getBlock());
        curScope = curScope.getEnclosingScope();
    }

    @Override
    public void visit(ForStmtNode node) {
        node.scope = curScope;
        if (node.getInit1() != null)
            visit(node.getInit1());
        else if (node.getInit2() != null) {
            node.getInit2().forEach(this::visit);
        }
        if (node.getCond() != null) {
            visit(node.getCond());
            if (!node.getCond().getType().isBool()) {
                // 条件表达式值不是bool
            }
        }
        if (node.getStep() != null)
            node.getStep().forEach(this::visit);
        curScope = new SymbolTable(curScope);
        curScope.setLoop();
        visit(node.getBlock());
        curScope = curScope.getEnclosingScope();
    }

    @Override
    public void visit(ContinueStmtNode node) {
        node.scope = curScope;
        if (!curScope.isLoop()) {
            // 未在循环之中
        }
    }
    @Override
    public void visit(BreakStmtNode node) {
        node.scope = curScope;
        if (!curScope.isLoop()) {
            // 未在循环之中
        }
    }
    @Override
    public void visit(ReturnStmtNode node) {
        node.scope = curScope;
        if (node.getExpr() != null) {
            visit(node.getExpr());
            if (!node.getExpr().equals((VartypeNode) curScope.getInFun()));
        }
    }
    @Override
    public void visit(BlankStmtNode node) {
        node.scope = curScope;
    }
    @Override
    public void visit(BlockNode node) {
        node.scope = curScope;
        node.getStmts().forEach(this::visit);
    }
    @Override
    public void visit(IdentifierNode node) {

    }
    @Override
    public void visit(StringliteralNode node) {
        node.scope = curScope;
        node.setType(GlobalSymbolTable.stringType);
    }
    @Override
    public void visit(IntegerliteralNode node) {
        node.scope = curScope;
        node.setType(GlobalSymbolTable.intType);
    }
    @Override
    public void visit(BooleanliteralNode node) {
        node.scope = curScope;
        node.setType(GlobalSymbolTable.boolType);
    }
    @Override
    public void visit(NullNode node) {
        node.scope = curScope;
        node.setType(GlobalSymbolTable.nullType);
    }
    @Override
    public void visit(VariableNode node) {
        node.scope = curScope;
        if (node.isThis()) {
            if (!curScope.isClass()) {
                // 在非类里面调用了this
            }
        }
        else if (node.getVar() == null&&node.getId() != null&&node.getExpr() == null)
            visit(node.getId());
        else if (node.getVar() != null&&node.getId() != null&&node.getExpr() == null)
            visit(node.getVar());
        else if (node.getVar() != null&&node.getId() != null&&node.getExpr() == null) {
            visit(node.getVar());
            visit(node.getId());
            VartypeNode t = node.getVar().getType();
            if (t.isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else if (!t.isClass()) {
                // 属于基本类，无mem
            }
            else {
                VartypeNode classType = globalSymbolTable.resolveType(t.getName());
                VartypeNode mem = ((ClassType)classType).resolveMem(node.getId().getName());
                if (mem == null) {
                    // 没有这个成员
                }
                else node.setType(mem);
            }
        }
        else if (node.getVar() != null&&node.getId() != null&&node.getExpr() == null) {
            visit(node.getVar());
            visit(node.getExpr());
            VartypeNode varType = node.getVar().getType(),exprType = node.getExpr().getType();
            if (varType.isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else {
                if (varType.getType().getDimension() == 0) {
                    // 属于变量，非数组
                }
                else {
                    if (!exprType.isInt()) {
                        // 数组维数不是整数
                    }
                    else {
                        node.setType(new VartypeNode(
                                new Type(
                                        varType.getType().getType(),
                                        varType.getType().isFun(),
                                        varType.getType().getDimension()-1
                                ),
                                varType.getName()
                        ));
                        return;
                    }
                }
            }
        }
        else {
            // 一般到不了这里
        }
    }
    @Override
    public void visit(CallfunNode node) {

    }
    @Override
    public void visit(AssignmentNode node) {
        node.scope = curScope;
        visit(node.getVariable());
        visit(node.getExpr());
        if (!node.getExpr().getType().equals(node.getExpr().getType())) {
            // 二者类型不一致
        }
    }

    @Override
    public void visit(ExpressionNode node) {
        node.scope = curScope;
        ExprOperator.Operator op = node.getOp().getOp();
        if (op == ExprOperator.Operator.SELF) {
            node.getExprs().forEach(this::visit);
            node.setType(node.getExprs().get(0).getType());
            return;
        }
        else if (op == ExprOperator.Operator.MEM) {
            ExprNode lsh = node.getExprs().get(0),rhs = node.getExprs().get(1);
            visit(lsh);
            if (lsh.getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else if (lsh.getType().isClass()) {
                ClassType classType = (ClassType) globalSymbolTable.resolveType(lsh.getType().getName());
                VartypeNode type = null;
                if (rhs instanceof CallfunNode) {
                    type = classType.resolveMem(((CallfunNode) rhs).getName());
                    if (type instanceof FunctionType) {
                        ((CallfunNode) rhs).getParams().forEach(this::visit);
                        List <VartypeNode> exprTypes = new ArrayList<>();
                        ((CallfunNode) rhs).getParams().forEach(param -> exprTypes.add(param.getType()));
                        if (ParamChecker.isSame(exprTypes,((FunctionType) type).getArgTypes())) {
                            node.setType(type);
                        }
                        else {
                            // 参数不匹配
                        }
                    }
                    else {
                        // 没有这个成员函数
                    }
                }
                else {

                }
            }
            else if (lsh.getType().isString()) {
                if (rhs instanceof CallfunNode) {

                }
                else {
                    // 没有成员
                }
            }
            else if (lsh.getType().getType().getDimension() == 1) {
                if (rhs instanceof CallfunNode) {

                }
                else {
                    // 没有成员
                }
            }
            else {
                // 没有成员
            }
        }
    }

    public void visit(Node node) {
        node.accept(this);
    }
    public void visit(StmtNode node) {
        node.accept(this);
    }
    public void visit(ExprNode node) {
        node.accept(this);
    }
}
