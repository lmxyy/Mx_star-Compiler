package com.lmxyy.mxcompiler.frontend;

import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.symbol.*;
import com.lmxyy.mxcompiler.utils.ParamChecker;
import com.lmxyy.mxcompiler.utils.SemanticError;

import java.util.ArrayList;
import java.util.List;

public class SemanticChecker implements ASTVisitor {
    private GlobalSymbolTable globalSymbolTable;
    private SymbolTable curScope;
    public SemanticError semanticError;

    public SemanticChecker(GlobalSymbolTable _globalSymbolTable) {
        globalSymbolTable = _globalSymbolTable;
        curScope = _globalSymbolTable.globals;
        semanticError = new SemanticError();
    }

    @Override
    public void visit(ProgNode node) {
        node.scope = curScope;
        for (DefNode def:node.getDefs()) {
            if (def instanceof DefclassNode) {
                if (globalSymbolTable.resolveType(((DefclassNode) def).getName()) != null) {
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
                    semanticError.hasAlreadyBeenDeclared(def.location(),((DefunNode) def).getName());
                    ((DefunNode) def).setOmmit();
                }
                else if (globalSymbolTable.resolveType(((DefunNode) def).getReturnType().getName()) == null) {
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
                            semanticError.canNotResolveToTheType(param.location(),param.getType().getName());
                            flag = true; break;
                        }
                        else argTypes.add(param.getType());
                    }
                    if (flag) {
                        ((DefunNode) def).setOmmit();
                    }
                    else {
                        if (((DefunNode) def).isInline()&&((DefunNode) def).getName() == "main") {
                            ((DefunNode) def).setOmmit();
                            semanticError.add(def.location(),"Cannot inline the main function.");
                        }
                        else {
                            for (int i = 0; i < argTypes.size(); ++i)
                                argNames.add("arg" + i);
                            FunctionType functionType = new FunctionType
                                    (((DefunNode) def).getReturnType()
                                            , ((DefunNode) def).getName()
                                            , argTypes, argNames);
                            curScope.define(functionType.getName(), functionType);
                        }
                    }
                }
            }
            else continue;
        }
        for (DefNode def:node.getDefs()) {
            if (def instanceof DefclassNode) {
                curScope = new SymbolTable(curScope);
                curScope.setClass(((DefclassNode) def).getName());
                previsit((DefclassNode) def);
                curScope = curScope.getEnclosingScope();
            }
        }
        for (DefNode def:node.getDefs()) {
            if (def instanceof DefclassNode) {
                if (((DefclassNode) def).isOmmit()) continue;
                curScope = def.scope;
                visit(def);
                curScope = curScope.getEnclosingScope();
            }
            else if (def instanceof DefunNode) {
                if (((DefunNode) def).isOmmit()) continue;
                curScope = new SymbolTable(curScope);
                curScope.setInFun((FunctionType) curScope.getTypeInfo(((DefunNode) def).getName()));
                visit(def);
                curScope = curScope.getEnclosingScope();
            }
            else visit(def);
        }
        SymbolInfo mainFun = globalSymbolTable.globals.getInfo("main");
        if (mainFun == null||!(mainFun.getType() instanceof FunctionType)) {
            semanticError.add("The program doesn't has a main function.");
        }
        else if (!mainFun.getType().isInt()) {
            semanticError.add("The main function is not int type.");
        }
    }

    @Override
    public void visit(DefunNode node) {
        node.scope = curScope;
        node.getParameterList().forEach(this::visit);
        visit(node.getBody());
    }

    @Override
    public void visit(DefvarNode node) {
        node.scope = curScope;
        if (curScope.getCurInfo(node.getName()) != null||globalSymbolTable.resolveType(node.getName()) != null) {
            semanticError.hasAlreadyBeenDeclared(node.location(),node.getName());
            return;
        }
        VartypeNode type = globalSymbolTable.resolveType(node.getType().getName());
        if (type == null) {
            semanticError.canNotResolveToTheType(node.location(),node.getType().getName());
            return;
        }
        if (node.getInit() != null) {
            visit(node.getInit());
            if (!(node.getInit().getType().equals(node.getType()))) {
                semanticError.add(node.location(),"The initializer must match the type of the declaration.");
                return;
            }
        }
        if (!curScope.isClass())
            curScope.define(node.getName(),node.getType());
        else curScope.define(node.getName(),node.getType());
    }

    public void previsit(DefclassNode node) {
        node.scope = curScope;
        for (DefunNode def:node.getFunMembers()) {
            if (globalSymbolTable.resolveType(def.getName()) != null||curScope.getCurInfo(def.getName()) != null) {
                semanticError.hasAlreadyBeenDeclared(def.location(),def.getName());
                def.setOmmit();
            }
            else if (globalSymbolTable.resolveType(def.getReturnType().getName()) == null) {
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
                        semanticError.canNotResolveToTheType(param.location(),param.getType().getName());
                        flag = true; break;
                    }
                    else argTypes.add(param.getType());
                }
                if (flag) {
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
        node.getVarMembers().forEach(this::previsit);
        if (node.getConstructor() == null) {
            FunctionType functionType = new FunctionType(new VartypeNode(new Type(Type.Types.VOID,0),"void"),node.getName(),new ArrayList<>(),new ArrayList<>());
            globalSymbolTable.defineConstructor(node.getName(),functionType);
        }
        else {
            if (!node.getConstructor().getName().equals(curScope.getClassName())) {
                semanticError.add(node.getConstructor().location(),"The name of constructor doesn't match the class.");
                node.getConstructor().setOmmit();
                return;
            }
            List <VartypeNode> argTypes = new ArrayList<>();
            List <String> argNames = new ArrayList<>();
            boolean flag = false;
            for (DefvarNode param:node.getConstructor().getParameterList()) {
                VartypeNode t = globalSymbolTable.resolveType(param.getType().getName());
                if (t == null) {
                    semanticError.canNotResolveToTheType(param.location(),param.getType().getName());
                    flag = true; break;
                }
                else argTypes.add(param.getType());
            }
            if (flag) {
                node.getConstructor().setOmmit();
                return;
            }
            else {
                for (int i = 0;i < argTypes.size();++i)
                    argNames.add("arg"+i);
                FunctionType functionType = new FunctionType(new VartypeNode(new Type(Type.Types.VOID,0),"void"),node.getName(),argTypes,argNames);
                globalSymbolTable.defineConstructor(node.getName(),functionType);
            }
        }
    }

    @Override
    public void visit(DefclassNode node) {
        node.scope = curScope;
        for (DefvarNode def:node.getVarMembers()) {
            if (def.isOmmit()) continue;
            posvisit(def);
        }
        for (DefunNode def:node.getFunMembers()) {
            if (def.isOmmit()) continue;;
            curScope = new SymbolTable(curScope);
            curScope.setInFun((FunctionType) curScope.getTypeInfo(def.getName()));
            visit(def);
            curScope = curScope.getEnclosingScope();
        }
        if (node.getConstructor() != null&&!node.getConstructor().isOmmit()) {
            curScope = new SymbolTable(curScope);
            curScope.setInFun(new FunctionType(new VartypeNode(new Type(Type.Types.VOID,0),"void"),node.getName(),null,null));
            visit(node.getConstructor());
            curScope = curScope.getEnclosingScope();
        }
    }

    public void previsit(DefvarNode node) {
        node.scope = curScope;
        if (curScope.getCurInfo(node.getName()) != null||globalSymbolTable.resolveType(node.getName()) != null) {
            semanticError.hasAlreadyBeenDeclared(node.location(),node.getName());
            node.setOmmit();
            return;
        }
        VartypeNode type = globalSymbolTable.resolveType(node.getType().getName());
        if (type == null) {
            semanticError.canNotResolveToTheType(node.location(),node.getType().getName());
            node.setOmmit();
            return;
        }
        if (!curScope.isClass())
            curScope.define(node.getName(),node.getType());
        else {
                globalSymbolTable.globals.define(curScope.getClassName()+"."+node.getName(),node.getType());
                curScope.define(node.getName(),node.getType(),true);
        }
    }

    public void posvisit(DefvarNode node) {
        node.scope = curScope;
        if (node.getInit() != null) {
            visit(node.getInit());
            if (!(node.getInit().getType().equals(node.getType()))) {
                semanticError.add(node.location(),"The initializer must match the type of the declaration.");
                return;
            }
        }
    }


    @Override
    public void visit(DefvarlistNode node) {
        node.scope = curScope;
        node.getVars().forEach(this::visit);
    }

    @Override
    public void visit(VartypeNode node) {
        node.scope = curScope;
        assert false;
    }

    @Override
    public void visit(VartypePlusNode node) {
        node.scope = curScope;
        node.getDims().forEach(dim->dim.accept(this));
    }

    @Override
    public void visit(IfStmtNode node) {
        node.scope = curScope;
        visit(node.getCond());
        if (!node.getCond().getType().isBool()) {
            semanticError.expectType(node.getCond().location(),GlobalSymbolTable.boolType,node.getCond().getType());
        }
        curScope = new SymbolTable(curScope);
        visit(node.getBlock1());
        curScope = curScope.getEnclosingScope();
        if (node.isHasElse()) {
            curScope = new SymbolTable(curScope);
            visit(node.getBlock2());
            curScope = curScope.getEnclosingScope();
        }
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.scope = curScope;
        visit(node.getCond());
        if (!node.getCond().getType().isBool()) {
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
                semanticError.expectType(node.getCond().location(),GlobalSymbolTable.boolType,node.getCond().getType());
            }
        }
        if (node.getStep() != null)
            node.getStep().forEach(this::visit);
        visit(node.getBlock());
    }

    @Override
    public void visit(ContinueStmtNode node) {
        node.scope = curScope;
        if (!curScope.isLoop()) {
            semanticError.add(node.location(),"Continue statement should only exist inside a loop.");
        }
    }
    @Override
    public void visit(BreakStmtNode node) {
        node.scope = curScope;
        if (!curScope.isLoop()) {
            semanticError.add(node.location(),"Break statement should only exist inside a loop.");
        }
    }
    @Override
    public void visit(ReturnStmtNode node) {
        node.scope = curScope;
        if (node.getExpr() != null) {
            visit(node.getExpr());
            if (!node.getExpr().getType().equals(curScope.getInFun().getReturnType())){
                semanticError.expectType(node.getExpr().location(),curScope.getInFun(),node.getExpr().getType());
                return;
            }
        }
        else{
            if (!((VartypeNode) curScope.getInFun()).isVoid()) {
                semanticError.expectType(node.location(),curScope.getInFun(),GlobalSymbolTable.voidType);
                return;
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
                if (stmt instanceof ForStmtNode)
                    curScope.setLoop();
                visit(stmt);
                curScope = curScope.getEnclosingScope();
            }
            else visit(stmt);
        }
    }
    @Override
    public void visit(IdentifierNode node) {
        node.scope = curScope;
        VartypeNode type = curScope.getTypeInfo(node.getName());
        if (type != null&&!(type instanceof FunctionType)) {
            node.setType(type);
            node.setInfo(curScope.getInfo(node.getName()));
            return;
        }
        else {
            node.setType(GlobalSymbolTable.ubType);
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
                node.setType(GlobalSymbolTable.ubType);
                semanticError.add(node.location(),"\"this\" can only be used in class.");
                return;
            }
            else {
                node.setType(globalSymbolTable.resolveType(curScope.getClassName()));
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
        else if (node.getVar() != null&&node.getId() == null&&node.getExpr() == null) {
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
            VartypeNode t = node.getVar().getType();
            if (t.isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else if (!t.isClass()) {
                node.setType(GlobalSymbolTable.ubType);
                semanticError.hasNoMember(node.getVar().location(),t,node.getId().getName());
                return;
            }
            else {
                VartypeNode classType = globalSymbolTable.resolveType(t.getName());
                VartypeNode mem = globalSymbolTable.globals.getTypeInfo(classType.getName()+"."+node.getId().getName());
                if (mem == null) {
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
        else if (node.getVar() != null&&node.getId() == null&&node.getExpr() != null) {
            visit(node.getVar());
            visit(node.getExpr());
            VartypeNode varType = node.getVar().getType(),exprType = node.getExpr().getType();
            if (varType.isUB()) {
                node.setType(GlobalSymbolTable.ubType);
                return;
            }
            else {
                if (varType.getType().getDimension() == 0) {
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.isNotArray(node.getExpr().location(),varType);
                    return;
                }
                else {
                    if (!exprType.isInt()) {
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
            assert false;
        }
    }
    @Override
    public void visit(CallfunNode node) {
        node.scope = curScope;
        VartypeNode type = curScope.getTypeInfo(node.getName());
        if (type != null&&type instanceof FunctionType) {
            node.getParams().forEach(this::visit);
            List <VartypeNode> exprTypes = new ArrayList<>();
            node.getParams().forEach(param -> exprTypes.add(param.getType()));
            if (ParamChecker.isSame(exprTypes,((FunctionType) type).getArgTypes())) {
                node.setType(((FunctionType) type).getReturnType());
                return;
            }
            else {
                node.setType(type);
                semanticError.parameterListDoesNotMatch(node.location());
                return;
            }
        }
        else {
            node.setType(GlobalSymbolTable.ubType);
            semanticError.canNotResolveToTheIdentifier(node.location(),node.getName());
            return;
        }
    }
    @Override
    public void visit(AssignmentNode node) {
        node.scope = curScope;
        visit(node.getVariable());
        if (node.getVariable().getOp().getOp() == ExprOperator.Operator.SELF){
            if (node.getVariable().getExprs().get(0) instanceof VariableNode) {
                if (((VariableNode) node.getVariable().getExprs().get(0)).isThis()){
                    semanticError.add(node.getVariable().location(),"\"this\" is not a left value.");
                    return;
                }
            }
            else {
                semanticError.add(node.getVariable().location(),"Left value is invalid.");
                return;
            }
        }
        else if (node.getVariable().getOp().getOp() != ExprOperator.Operator.MEM
                &&node.getVariable().getOp().getOp() != ExprOperator.Operator.ARRAY) {
            semanticError.add(node.getVariable().location(),"Left value is invalid.");
            return;
        }
        else if (node.getVariable().getOp().getOp() == ExprOperator.Operator.MEM) {
            if (node.getVariable().getExprs().get(1) instanceof CallfunNode) {
                semanticError.add(node.getVariable().location(),"Left value is invalid.");
                return;
            }
        }
        visit(node.getExpr());
        if (!node.getVariable().getType().equals(node.getExpr().getType())) {
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
                    type = globalSymbolTable.globals.getTypeInfo(classType.getName()+"."+((CallfunNode) rhs).getName());
                    if (type != null&&type instanceof FunctionType) {
                        ((CallfunNode) rhs).getParams().forEach(this::visit);
                        List <VartypeNode> exprTypes = new ArrayList<>();
                        ((CallfunNode) rhs).getParams().forEach(param -> exprTypes.add(param.getType()));
                        if (ParamChecker.isSame(exprTypes,((FunctionType) type).getArgTypes())) {
                            node.setType(((FunctionType) type).getReturnType());
                            return;
                        }
                        else {
                            node.setType(((FunctionType) type).getReturnType());
                            semanticError.parameterListDoesNotMatch(rhs.location());
                            return;
                        }
                    }
                    else {
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.hasNoMember(rhs.location(),lhs.getType(),((CallfunNode) rhs).getName());
                        return;
                    }
                }
                else {
                    type = globalSymbolTable.globals.getTypeInfo(classType.getName()+"."+((IdentifierNode) rhs).getName());
                    if (type != null&&!(type instanceof FunctionType)) {
                        node.setType(type);
                        return;
                    }
                    else{
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.hasNoMember(rhs.location(),lhs.getType(),((IdentifierNode) rhs).getName());
                        return;
                    }
                }
            }
            else if (lhs.getType().isString()) {
                if (rhs instanceof CallfunNode) {
                    VartypeNode type = globalSymbolTable.globals.getTypeInfo("string."+((CallfunNode) rhs).getName());
                    if (type == null) {
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
                        }
                    }
                }
                else {
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.hasNoMember(rhs.location(),lhs.getType(),((IdentifierNode) rhs).getName());
                    return;
                }
            }
            else if (lhs.getType().getType().getDimension() > 0) {
                if (rhs instanceof CallfunNode) {
                    VartypeNode type = globalSymbolTable.globals.getTypeInfo("_array."+((CallfunNode) rhs).getName());
                    if (type == null) {
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
                        }
                    }
                }
                else {
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.hasNoMember(rhs.location(),lhs.getType(),((IdentifierNode) rhs).getName());
                    return;
                }
            }
            else {
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
                        if (((ExpressionNode) lhs).getOp().getOp() == ExprOperator.Operator.NEW) {
                            node.setType(GlobalSymbolTable.ubType);
                            semanticError.add(lhs.location(),"Expect parentheses here.");
                            return;
                        }
                        node.setType(new VartypeNode(
                                new Type(lhs.getType().getType().getType(),lhs.getType().getType().getDimension()-1),
                                lhs.getType().getName()));
                        return;
                    }
                    else {
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
                node.setType(GlobalSymbolTable.boolType);
                semanticError.expectType(expr.location(),GlobalSymbolTable.boolType,expr.getType());
            }
        }
        else if (op == ExprOperator.Operator.NEW) {
            VartypePlusNode vartype = node.getVartype();
            visit(vartype);
            if (vartype.getType().getDimension() == 0) {
                if (vartype.getType().getType() == Type.Types.CLASS) {
                    if (globalSymbolTable.resolveType(vartype.getName()) == null) {
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.canNotResolveToTheType(vartype.location(),vartype.getName());
                        return;
                    }
                    else {
                        FunctionType constructor = globalSymbolTable.resolveConstructor(vartype.getName());
                        if (constructor == null) {
                            node.setType(vartype.toVartypeNode());
                            semanticError.add(vartype.location(),"Cannot get the constructor.");
                            return;
                        }
                        node.getExprs().forEach(this::visit);
                        List <VartypeNode> exprTypes = new ArrayList<>();
                        node.getExprs().forEach(param -> exprTypes.add(param.getType()));
                        if (ParamChecker.isSame(exprTypes,constructor.getArgTypes())) {
                            node.setType(vartype.toVartypeNode());
                            return;
                        }
                        else {
                            node.setType(vartype.toVartypeNode());
                            semanticError.parameterListDoesNotMatch(vartype.location());
                            return;
                        }
                    }
                }
                else {
                    node.setType(GlobalSymbolTable.intType);
                    semanticError.add(vartype.location(),"Primitive types cannot use new operator.");
                    return;
                }
            }
            else {
                if (globalSymbolTable.resolveType(vartype.getName()) == null) {
                    node.setType(GlobalSymbolTable.ubType);
                    semanticError.canNotResolveToTheType(vartype.location(),vartype.getName());
                    return;
                }
                else {
                    if (node.isHasPar()) {
                        node.setType(vartype.toVartypeNode());
                        semanticError.add(vartype.location(),"Parentheses cannot follow the array constructor.");
                        return;
                    }
                    else if (node.getVartype().getDims().size() == 0) {
                        node.setType(vartype.toVartypeNode());
                        semanticError.add(vartype.location(),"Please indicate at least one dimension.");
                        return;
                    }
                    else {
                        node.getVartype().getDims().forEach(dim->{
                            if(!(dim.getType().isInt())) {
                                semanticError.expectType(dim.location(),GlobalSymbolTable.intType,dim.getType());
                            }
                        });
                        node.setType(vartype.toVartypeNode());
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
            else if (!lhs.getType().equals(rhs.getType())) {
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
                else if (lhs.getType().isClass()||rhs.getType().isClass()
                        ||lhs.getType().getType().getDimension() > 0||rhs.getType().getType().getDimension() > 0) {
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
                else if (lhs.getType().isNull()&&rhs.getType().isNull()) {
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
            else if (!lhs.getType().equals(rhs.getType())) {
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
                        node.setType(GlobalSymbolTable.ubType);
                        semanticError.areNotTheSameType(mhs.location(),mhs.getType(),rhs.getType());
                        return;
                    }
                }
                else {
                    node.setType(mhs.getType());
                    semanticError.expectType(lhs.location(),GlobalSymbolTable.boolType,lhs.getType());
                    return;
                }
            }
        }
        else {
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
