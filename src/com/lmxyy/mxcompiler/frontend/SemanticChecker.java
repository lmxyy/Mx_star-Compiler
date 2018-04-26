package com.lmxyy.mxcompiler.frontend;

import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.symbol.*;
import com.lmxyy.mxcompiler.utils.ParamChecker;
import com.lmxyy.mxcompiler.utils.SemanticError;

import java.util.ArrayList;
import java.util.List;

public class SemanticChecker implements Visitor {
    private GlobalSymbolTable globalSymbolTable;
    private SymbolTable curScope;
    public SemanticError semanticError;

    public SemanticChecker(GlobalSymbolTable _globalSymbolTable) {
        globalSymbolTable = _globalSymbolTable;
        curScope = _globalSymbolTable.globals;
    }

    @Override
    public void visit(ProgNode node) {
        node.scope = curScope;
        for (DefNode def:node.getDefs()) {
            if (def instanceof DefclassNode) {
                if (globalSymbolTable.resolveType(((DefclassNode) def).getName()) != null) {
                    // 类定义重复
                    semanticError.hasAlreadyBeenDeclared(def.location(),((DefclassNode) def).getName());
                    ((DefclassNode) def).setOmmit();
                }
                else
                    globalSymbolTable.defineType(
                            ((DefclassNode) def).getName(),
                            new VartypeNode(new Type(Type.Types.CLASS,0),((DefclassNode) def).getName())
                    );
            }
            else continue;
        }
        for (DefNode def:node.getDefs()) {
            if (def instanceof DefunNode) {
                if (globalSymbolTable.resolveType(((DefunNode) def).getName()) != null||curScope.getInfo(((DefunNode) def).getName()) != null) {
                    // 函数定义重名
                    semanticError.hasAlreadyBeenDeclared(def.location(),((DefunNode) def).getName());
                    ((DefunNode) def).setOmmit();
                }
                else if (globalSymbolTable.resolveType(((DefunNode) def).getReturnType().getName()) == null) {
                    // 函数的类型不存在
                    semanticError.canNotResolveToTheType(def.location(),((DefunNode) def).getReturnType().getName());
                    ((DefunNode) def).setOmmit();
                }
                else {
                    List <VartypeNode> argTypes = new ArrayList<>();
                    List <String> argNames = new ArrayList<>();
                    boolean flag = false;
                    for (DefvarNode param:((DefunNode) def).getParameterList()) {
                        VartypeNode t = globalSymbolTable.resolveType(param.getType().getName());
                        if (t == null) {
                            // 参数类型没见过
                            semanticError.canNotResolveToTheType(param.location(),param.getType().getName());
                            flag = true; break;
                        }
                        else argTypes.add(t);
                    }
                    if (flag) {
                        // 参数里面有未知类型
                        ((DefunNode) def).setOmmit();
                    }
                    else {
                        for (int i = 0;i < argTypes.size();++i)
                            argNames.add("arg"+i);
                        FunctionType functionType = new FunctionType
                                (((DefunNode) def).getReturnType()
                                ,((DefunNode) def).getName()
                                ,argTypes,argNames);
                        curScope.define(functionType.getName(),functionType);
                    }
                }
            }
            else continue;
        }
        for (DefNode def:node.getDefs()) {
            if (def instanceof DefclassNode) {
                if (((DefclassNode) def).isOmmit()) continue;
                curScope = new SymbolTable(curScope);
                curScope.setClass(((DefclassNode) def).getName());
                visit(def);
                curScope = curScope.getEnclosingScope();
            }
            else if (def instanceof DefunNode) {
                if (((DefunNode) def).isOmmit()) continue;
                curScope = new SymbolTable(curScope);
                curScope.setInFun((FunctionType) curScope.getInfo(((DefunNode) def).getName()).getType());
                visit(def);
                curScope = curScope.getEnclosingScope();
            }
            else visit(def);
        }
        SymbolInfo mainFun = globalSymbolTable.globals.getInfo("main");
        if (mainFun == null) {
            // 无main函数
            semanticError.add("The program doesn't has main function.");
        }
        else if (!mainFun.getType().isInt()) {
            // main函数类型不是int
            semanticError.add("The main function is not int type.");
        }
    }

    @Override
    public void visit(DefunNode node) {
        node.scope = curScope;
        node.getParameterList().forEach(this::visit);
        curScope = new SymbolTable(curScope);
        visit(node.getBody());
        curScope = curScope.getEnclosingScope();
    }

    @Override
    public void visit(DefvarNode node) {
        node.scope = curScope;
        if (globalSymbolTable.resolveType(node.getName()) != null||curScope.getCurInfo(node.getName()) != null) {
            // 变量重名
            semanticError.hasAlreadyBeenDeclared(node.location(),node.getName());
            return;
        }
        VartypeNode type = globalSymbolTable.resolveType(node.getType().getName());
        if (type == null) {
            // 无此类型
            semanticError.canNotResolveToTheType(node.location(),node.getType().getName());
            return;
        }
        if (node.getInit() != null) {
            visit(node.getInit());
            if (!node.getInit().getType().equals(node.getType())) {
                // 不是同一个类型
                semanticError.add(node.location(),"The initializer must match the type of the declaration.");
                return;
            }
        }
        if (!curScope.isClass())
            curScope.define(node.getName(),node.getType());
        else {
            if (curScope.getInFun() == null) {
                globalSymbolTable.globals.define(curScope.getClass()+"."+node.getName(),node.getType());
                curScope.define(node.getName(),node.getType());
            }
            else curScope.define(node.getName(),node.getType());

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
        for (DefunNode def:node.getFunMembers()) {
            if (globalSymbolTable.resolveType(def.getName()) != null||curScope.getCurInfo(def.getName()) != null) {
                // 函数定义重名
                semanticError.hasAlreadyBeenDeclared(def.location(),def.getName());
                def.setOmmit();
            }
            else if (globalSymbolTable.resolveType(def.getReturnType().getName()) == null) {
                // 函数的类型不存在
                semanticError.canNotResolveToTheType(def.location(),def.getReturnType().getName());
                def.setOmmit();
            }
            else {
                List <VartypeNode> argTypes = new ArrayList<>();
                List <String> argNames = new ArrayList<>();
                boolean flag = false;
                for (DefvarNode param:((DefunNode) def).getParameterList()) {
                    VartypeNode t = globalSymbolTable.resolveType(param.getType().getName());
                    if (t == null) {
                        // 变量类型不存在
                        semanticError.canNotResolveToTheType(param.location(),param.getType().getName());
                        flag = true; break;
                    }
                    else argTypes.add(t);
                }
                if (flag) {
                    // 参数里面有未知类型
                    def.setOmmit();
                }
                else {
                    for (int i = 0;i < argTypes.size();++i)
                        argNames.add("arg"+i);
                    FunctionType functionType1 = new FunctionType
                            (def.getReturnType()
                                    ,def.getName()
                                    ,argTypes,argNames);
                    FunctionType functionType2 = new FunctionType
                            (def.getReturnType()
                                    ,node.getName()+"."+def.getName()
                                    ,argTypes,argNames);
                    curScope.define(functionType1.getName(),functionType1);
                    globalSymbolTable.globals.define(functionType2.getName(),functionType2);
                }
            }
        }
        node.getVarMembers().forEach(this::visit);
        for (DefunNode def:node.getFunMembers()) {
            if (def.isOmmit()) continue;;
            curScope = new SymbolTable(curScope);
            curScope.setInFun((FunctionType) curScope.getInfo(def.getName()).getType());
            visit(def);
            curScope = curScope.getEnclosingScope();
        }
        if (node.getConstructor() == null) {
            FunctionType functionType = new FunctionType(null,node.getName(),new ArrayList<>(),new ArrayList<>());
            globalSymbolTable.defineConstructor(node.getName(),functionType);
        }
        else {
            List <VartypeNode> argTypes = new ArrayList<>();
            List <String> argNames = new ArrayList<>();
            boolean flag = false;
            for (DefvarNode param:node.getConstructor().getParameterList()) {
                VartypeNode t = globalSymbolTable.resolveType(param.getType().getName());
                if (t == null) {
                    // 参数里有未知类型
                    semanticError.canNotResolveToTheType(param.location(),param.getType().getName());
                    flag = true; break;
                }
                else argTypes.add(t);
            }
            if (flag) {
                // 参数里面有未知类型
                return;
            }
            else {
                for (int i = 0;i < argTypes.size();++i)
                    argNames.add("arg"+i);
                FunctionType functionType = new FunctionType(null,node.getName(),argTypes,argNames);
                globalSymbolTable.defineConstructor(node.getName(),functionType);
            }
            curScope = new SymbolTable(curScope);
            visit(node.getConstructor());
            curScope = curScope.getEnclosingScope();
        }
    }

    @Override
    public void visit(VartypeNode node) {
        node.scope = curScope;
        // 理论上到不了这里
        assert false;
    }

    @Override
    public void visit(VartypePlusNode node) {
        node.scope = curScope;
        // 理论上到不了这里
        assert false;
    }

    @Override
    public void visit(IfStmtNode node) {
        node.scope = curScope;
        visit(node.getCond());
        if (!node.getCond().getType().isBool()) {
            // 条件表达式里的值不是bool
            semanticError.expectType(node.getCond().location(),GlobalSymbolTable.boolType,node.getCond().getType());
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
            semanticError.expectType(node.getCond().location(),GlobalSymbolTable.boolType,node.getCond().getType());
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
                semanticError.expectType(node.getCond().location(),GlobalSymbolTable.boolType,node.getCond().getType());
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
            semanticError.add(node.location(),"Continue statement should only exist inside a loop.");
        }
    }
    @Override
    public void visit(BreakStmtNode node) {
        node.scope = curScope;
        if (!curScope.isLoop()) {
            // 未在循环之中
            semanticError.add(node.location(),"Break statement should only exist inside a loop.");
        }
    }
    @Override
    public void visit(ReturnStmtNode node) {
        node.scope = curScope;
        if (node.getExpr() != null) {
            visit(node.getExpr());
            if (!node.getExpr().equals(curScope.getInFun())){
                // return的值与表达式不匹配
                semanticError.expectType(node.getExpr().location(),curScope.getInFun(),node.getExpr().getType());
            }
        }
        else{
            if (!((VartypeNode) curScope.getInFun()).isVoid()) {
                // return的值与表达式不匹配
                semanticError.expectType(node.location(),curScope.getInFun(),GlobalSymbolTable.voidType);
            }
        }
    }
    @Override
    public void visit(BlankStmtNode node) {
        node.scope = curScope;
    }
    @Override
    public void visit(BlockNode node) {
        node.scope = curScope;
        for (Node stmt:node.getStmts()) {
            if (stmt instanceof ForStmtNode||stmt instanceof BlockNode) {
                curScope = new SymbolTable(curScope);
                visit(stmt);
                curScope = curScope.getEnclosingScope();
            }
            else visit(stmt);
        }
    }
    @Override
    public void visit(IdentifierNode node) {
        node.scope = curScope;
        VartypeNode type = curScope.getInfo(node.getName()).getType();
        if (type != null&&!(type instanceof FunctionType)) {
            node.setType(type);
            return;
        }
        else {
            semanticError.canNotResolveToTheIdentifier(node.location(),node.getName());
        }
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
                node.setType(GlobalSymbolTable.ubType);
                semanticError.add(node.location(),"\"this\" can only be used in class.");
                return;
            }
            else {
                node.setType(globalSymbolTable.globals.getInfo(curScope.getClassName()).getType());
                return;
            }
        }
        else if (node.getVar() == null&&node.getId() != null&&node.getExpr() == null) {
            visit(node.getId());
            if (node.getId().getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else {
                node.setType(node.getId().getType());
                return;
            }
        }
        else if (node.getVar() != null&&node.getId() != null&&node.getExpr() == null) {
            visit(node.getVar());
            if (node.getVar().getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else {
                node.setType(node.getVar().getType());
                return;
            }
        }
        else if (node.getVar() != null&&node.getId() != null&&node.getExpr() == null) {
            visit(node.getVar());
            visit(node.getId());
            VartypeNode t = node.getVar().getType();
            if (t.isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else if (!t.isClass()) {
                node.setType(GlobalSymbolTable.ubType);
                semanticError.hasNoMember(node.getVar().location(),t,node.getId().getName());
                return;
                // 属于基本类，无mem
            }
            else {
                VartypeNode classType = globalSymbolTable.resolveType(t.getName());
                VartypeNode mem = globalSymbolTable.globals.getInfo(classType.getName()+"."+node.getId().getName()).getType();
                if (mem == null) {
                    // 没有这个成员
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.hasNoMember(node.getVar().location(),t,node.getId().getName());
                    return;
                }
                else {
                    node.setType(mem);
                    return;
                }
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
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.isNotArray(node.getExpr().location(),varType);
                    return;
                }
                else {
                    if (!exprType.isInt()) {
                        // 数组维数不是整数
                        node.setType(new VartypeNode(
                                new Type(
                                        varType.getType().getType(),
                                        varType.getType().getDimension()-1
                                ),
                                varType.getName()
                        ));
                        semanticError.expectType(node.getExpr().location(),GlobalSymbolTable.intType,exprType);
                        return;
                    }
                    else {
                        node.setType(new VartypeNode(
                                new Type(
                                        varType.getType().getType(),
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
            assert false;
        }
    }
    @Override
    public void visit(CallfunNode node) {
        node.scope = curScope;
        VartypeNode type = curScope.getInfo(node.getName()).getType();
        if (type != null&&type instanceof FunctionType) {
            node.getParams().forEach(this::visit);
            List <VartypeNode> exprTypes = new ArrayList<>();
            node.getParams().forEach(param -> exprTypes.add(param.getType()));
            if (ParamChecker.isSame(exprTypes,((FunctionType) type).getArgTypes())) {
                node.setType(type);
                return;
            }
            else {
                // 参数不匹配
                node.setType(type);
                semanticError.parameterListDoesNotMatch(node.location());
                return;
            }
        }
        else {
            // 调用的函数不存在
            node.setType(GlobalSymbolTable.ubType);
            semanticError.canNotResolveToTheIdentifier(node.location(),node.getName());
            return;
        }
    }
    @Override
    public void visit(AssignmentNode node) {
        node.scope = curScope;
        visit(node.getVariable());
        visit(node.getExpr());
        if (!node.getVariable().getType().equals(node.getExpr().getType())) {
            // 二者类型不一致
            semanticError.expectType(node.location(),node.getVariable().getType(),node.getExpr().getType());
            return;
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
            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            visit(lhs);
            if (lhs.getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else if (lhs.getType().isClass()) {
                VartypeNode classType = globalSymbolTable.resolveType(lhs.getType().getName());
                VartypeNode type = null;
                if (rhs instanceof CallfunNode) {
                    type = globalSymbolTable.globals.getInfo(classType.getName()+((CallfunNode) rhs).getName()).getType();
                    if (type != null&&type instanceof FunctionType) {
                        ((CallfunNode) rhs).getParams().forEach(this::visit);
                        List <VartypeNode> exprTypes = new ArrayList<>();
                        ((CallfunNode) rhs).getParams().forEach(param -> exprTypes.add(param.getType()));
                        if (ParamChecker.isSame(exprTypes,((FunctionType) type).getArgTypes())) {
                            node.setType(type);
                            return;
                        }
                        else {
                            // 参数不匹配
                            node.setType(type);
                            semanticError.parameterListDoesNotMatch(rhs.location());
                            return;
                        }
                    }
                    else {
                        // 没有这个成员函数
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.hasNoMember(rhs.location(),lhs.getType(),((CallfunNode) rhs).getName());
                        return;
                    }
                }
                else {
                    type = globalSymbolTable.globals.getInfo(classType.getName()+((IdentifierNode) rhs).getName()).getType();
                    if (type != null&&!(type instanceof FunctionType)) {
                        node.setType(type);
                        return;
                    }
                    else{
                        // 没有这个成员
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.hasNoMember(rhs.location(),lhs.getType(),((IdentifierNode) rhs).getName());
                        return;
                    }
                }
            }
            else if (lhs.getType().isString()) {
                if (rhs instanceof CallfunNode) {
                    VartypeNode type = globalSymbolTable.globals.getInfo("string."+((CallfunNode) rhs).getName()).getType();
                    if (type == null) {
                        // 不是string内置函数，无此成员函数
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.hasNoMember(rhs.location(),lhs.getType(),((CallfunNode) rhs).getName());
                        return;
                    }
                    else {
                        ((CallfunNode) rhs).getParams().forEach(this::visit);
                        List <VartypeNode> exprTypes = new ArrayList<>();
                        ((CallfunNode) rhs).getParams().forEach(param -> exprTypes.add(param.getType()));
                        if (ParamChecker.isSame(exprTypes,((FunctionType) type).getArgTypes())) {
                            node.setType(type);
                            return;
                        }
                        else {
                            // 参数不匹配
                            node.setType(type);
                            semanticError.parameterListDoesNotMatch(rhs.location());
                            return;
                        }
                    }
                }
                else {
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.hasNoMember(rhs.location(),lhs.getType(),((IdentifierNode) rhs).getName());
                    return;
                }
            }
            else if (lhs.getType().getType().getDimension() == 1) {
                if (rhs instanceof CallfunNode) {
                    VartypeNode type = globalSymbolTable.globals.getInfo("array."+((CallfunNode) rhs).getName()).getType();
                    if (type == null) {
                        // 不是array内置函数，无此成员函数
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.hasNoMember(rhs.location(),lhs.getType(),((CallfunNode) rhs).getName());
                        return;
                    }
                    else {
                        ((CallfunNode) rhs).getParams().forEach(this::visit);
                        List <VartypeNode> exprTypes = new ArrayList<>();
                        ((CallfunNode) rhs).getParams().forEach(param -> exprTypes.add(param.getType()));
                        if (ParamChecker.isSame(exprTypes,((FunctionType) type).getArgTypes())) {
                            node.setType(type);
                            return;
                        }
                        else {
                            node.setType(type);
                            semanticError.parameterListDoesNotMatch(rhs.location());
                            return;
                            // 参数不匹配
                        }
                    }
                }
                else {
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.hasNoMember(rhs.location(),lhs.getType(),((IdentifierNode) rhs).getName());
                    return;
                    // 没有成员
                }
            }
            else {
                // 没有成员
                node.setType(GlobalSymbolTable.ubType);
                if (rhs instanceof CallfunNode)
                    semanticError.hasNoMember(rhs.location(),lhs.getType(),((CallfunNode) rhs).getName());
                else semanticError.hasNoMember(rhs.location(),lhs.getType(),((IdentifierNode) rhs).getName());
                return;
            }
        }
        else if (op == ExprOperator.Operator.ARRAY) {
            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            visit(lhs);
            if (lhs.getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else {
                if (lhs.getType().getType().getDimension() == 0) {
                    // 这是个变量，没有数组操作
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.isNotArray(rhs.location(),lhs.getType());
                }
                else {
                    visit(rhs);
                    if (rhs.getType().isUB()) {
                        node.setType(GlobalSymbolTable.ubType);
                        return;
                    }
                    else if (rhs.getType().isInt()) {
                        node.setType(new VartypeNode(
                                new Type(lhs.getType().getType().getType(),lhs.getType().getType().getDimension()-1),
                                lhs.getType().getName()));
                        return;
                    }
                    else {
                        // 数组维数类型不是int
                        node.setType(new VartypeNode(
                                new Type(lhs.getType().getType().getType(),lhs.getType().getType().getDimension()-1),
                                lhs.getType().getName()));
                        semanticError.expectType(rhs.location(),GlobalSymbolTable.intType,rhs.getType());
                        return;
                    }
                }
            }
        }
        else if (op == ExprOperator.Operator.SINC||op == ExprOperator.Operator.SDEC||op == ExprOperator.Operator.PINC
                ||op == ExprOperator.Operator.PDEC||op == ExprOperator.Operator.NEG||op == ExprOperator.Operator.COMP) {
            ExprNode expr = node.getExprs().get(0);
            visit(expr);
            if (expr.getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else if (expr.getType().isInt()) {
                node.setType(GlobalSymbolTable.intType);
                return;
            }
            else {
                // 运算数不是int
                node.setType(GlobalSymbolTable.intType);
                semanticError.expectType(expr.location(),GlobalSymbolTable.intType,expr.getType());
            }
        }
        else if (op == ExprOperator.Operator.NOT) {
            ExprNode expr = node.getExprs().get(0);
            visit(expr);
            if (expr.getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else if (expr.getType().isBool()) {
                node.setType(GlobalSymbolTable.boolType);
                return;
            }
            else {
                // 运算数不是bool
                node.setType(GlobalSymbolTable.boolType);
                semanticError.expectType(expr.location(),GlobalSymbolTable.boolType,expr.getType());
            }
        }
        else if (op == ExprOperator.Operator.NEW) {
            VartypePlusNode vartype = node.getVartype();
            if (vartype.getType().getDimension() == 0) {
                if (vartype.getType().getType() == Type.Types.CLASS) {
                    if (globalSymbolTable.resolveType(vartype.getName()) == null) {
                        // 该类不存在
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.canNotResolveToTheType(vartype.location(),vartype.getName());
                        return;
                    }
                    else {
                        FunctionType constructor = globalSymbolTable.resolveConstructor(vartype.getName());
                        if (constructor == null) {
                            // 找不到constructor
                            node.setType(new VartypeNode(vartype.getType(),vartype.getName()));
                            semanticError.add(vartype.location(),"Cannot get the constructor.");
                            return;
                        }
                        node.getExprs().forEach(this::visit);
                        List <VartypeNode> exprTypes = new ArrayList<>();
                        node.getExprs().forEach(param -> exprTypes.add(param.getType()));
                        if (ParamChecker.isSame(exprTypes,constructor.getArgTypes())) {
                            node.setType(new VartypeNode(vartype.getType(),vartype.getName()));
                            return;
                        }
                        else {
                            // 参数不匹配
                            node.setType(new VartypeNode(vartype.getType(),vartype.getName()));
                            semanticError.parameterListDoesNotMatch(vartype.location());
                            return;
                        }
                    }
                }
                else {
                    // 基本类型不能new
                    node.setType(GlobalSymbolTable.intType);
                    semanticError.add(vartype.location(),"Primitive types cannot use new operator.");
                    return;
                }
            }
            else {
                if (globalSymbolTable.resolveType(vartype.getName()) == null) {
                    // 数组类型的基类不存在
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.canNotResolveToTheType(vartype.location(),vartype.getName());
                    return;
                }
                else {
                    if (node.isHasPar()) {
                        // 数组变量后面不能带括号，无参数
                        node.setType(new VartypeNode(vartype.getType(), vartype.getName()));
                        semanticError.add(vartype.location(),"Parentheses cannot follow the array constructor.");
                        return;
                    }
                    else {
                        node.setType(new VartypeNode(vartype.getType(), vartype.getName()));
                        return;
                    }
                }
            }
        }
        else if (op == ExprOperator.Operator.TIMES||op == ExprOperator.Operator.DIVIDE||op == ExprOperator.Operator.MOD
                ||op == ExprOperator.Operator.ADD||op == ExprOperator.Operator.SUB
                ||op == ExprOperator.Operator.LESH||op == ExprOperator.Operator.RISH
                ||op == ExprOperator.Operator.LESS||op == ExprOperator.Operator.LEQ
                ||op == ExprOperator.Operator.GRTR||op == ExprOperator.Operator.GEQ
                ||op == ExprOperator.Operator.EQU||op == ExprOperator.Operator.NEQ
                ||op == ExprOperator.Operator.BAND||op == ExprOperator.Operator.XOR||op == ExprOperator.Operator.BOR) {
            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            visit(lhs); visit(rhs);
            if (lhs.getType().isUB()||rhs.getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else if (!lhs.getType().equals(rhs)) {
                // 二者类别不统一
                node.setType(GlobalSymbolTable.ubType);
                semanticError.areNotTheSameType(rhs.location(),lhs.getType(),rhs.getType());
                return;
            }
            else {
                if (lhs.getType().isInt()) {
                    if (op == ExprOperator.Operator.LESS||op == ExprOperator.Operator.LEQ
                            ||op == ExprOperator.Operator.GRTR||op == ExprOperator.Operator.GEQ
                            ||op == ExprOperator.Operator.EQU||op == ExprOperator.Operator.NEQ)
                        node.setType(GlobalSymbolTable.boolType);
                    else node.setType(GlobalSymbolTable.intType);
                    return;
                }
                else if (lhs.getType().isString()) {
                    if (op == ExprOperator.Operator.ADD) {
                        node.setType(GlobalSymbolTable.stringType);
                        return;
                    }
                    else if (op == ExprOperator.Operator.EQU||op == ExprOperator.Operator.NEQ
                            ||op == ExprOperator.Operator.LESS||op == ExprOperator.Operator.LEQ
                            ||op == ExprOperator.Operator.GRTR||op == ExprOperator.Operator.GEQ){
                        node.setType(GlobalSymbolTable.boolType);
                        return;
                    }
                    else {
                        // 运算符不支持该类型
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.doNotSupportTheOperation(rhs.location(),lhs.getType());
                        return;
                    }
                }
                else if (lhs.getType().isBool()) {
                    if (op == ExprOperator.Operator.EQU||op == ExprOperator.Operator.NEQ) {
                        node.setType(GlobalSymbolTable.boolType);
                        return;
                    }
                    else {
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.doNotSupportTheOperation(rhs.location(),lhs.getType());
                        return;
                    }
                }
                else {
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.doNotSupportTheOperation(rhs.location(),lhs.getType());
                    return;
                }
            }
        }
        else if (op == ExprOperator.Operator.LAND||op == ExprOperator.Operator.LOR) {
            ExprNode lhs = node.getExprs().get(0),rhs = node.getExprs().get(1);
            visit(lhs); visit(rhs);
            if (lhs.getType().isUB()||rhs.getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else if (!lhs.getType().equals(rhs)) {
                // 二者类别不统一
                node.setType(GlobalSymbolTable.ubType);
                semanticError.areNotTheSameType(rhs.location(),lhs.getType(),rhs.getType());
                return;
            }
            else {
                if (lhs.getType().isBool()) {
                    node.setType(GlobalSymbolTable.boolType);
                    return;
                }
                else {
                    // 运算符不支持该类型
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.doNotSupportTheOperation(rhs.location(),lhs.getType());
                    return;
                }
            }
        }
        else if (op == ExprOperator.Operator.TRN) {
            ExprNode lhs = node.getExprs().get(0),mhs = node.getExprs().get(1),rhs = node.getExprs().get(2);
            visit(lhs); visit(mhs); visit(rhs);
            if (lhs.getType().isUB()||mhs.getType().isUB()||rhs.getType().isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else {
                if (lhs.getType().isBool()) {
                    if (mhs.getType().equals(rhs.getType())) {
                        node.setType(mhs.getType());
                        return;
                    }
                    else {
                        // 三目运算符后两维类型不一样
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.areNotTheSameType(mhs.location(),mhs.getType(),rhs.getType());
                        return;
                    }
                }
                else {
                    // 三目运算符条件不是bool
                    node.setType(mhs.getType());
                    semanticError.expectType(lhs.location(),GlobalSymbolTable.boolType,lhs.getType());
                    return;
                }
            }
        }
        else {
            // 一般不会到这里来
            assert false;
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
    public void visit(DefNode node) {
        node.accept(this);
    }
}