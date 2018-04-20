package com.lmxyy.mxcompiler.frontend;
import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.parser.Mx_starBaseVisitor;
import com.lmxyy.mxcompiler.parser.Mx_starParser;
import com.lmxyy.mxcompiler.symbol.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends Mx_starBaseVisitor<Node> {

    @Override
    public Node visitProg(Mx_starParser.ProgContext ctx) {
        List<DefNode> defs = new ArrayList<>();
        for (ParserRuleContext progsec : ctx.progsec()) {
            Node def = visit(progsec);
            if (def instanceof DefvarlistNode) defs.addAll(((DefvarlistNode) def).getVars());
            else defs.add((DefNode) def);
        }
        return new ProgNode(defs);
    }

    @Override
    public Node visitProgsec(Mx_starParser.ProgsecContext ctx) {
        if (ctx.defclass() != null) return visit(ctx.defclass());
        else if (ctx.defun() != null) return visit(ctx.defun());
        else return visit(ctx.defvar());
    }

    @Override
    public Node visitDefclass(Mx_starParser.DefclassContext ctx) {
        String name = ctx.Identifier().getText();
        List <DefvarNode> defvars = new ArrayList<>();
        List <DefunNode> defuns = new ArrayList<>();
        for (ParserRuleContext classmem:ctx.classmem()) {
            Node mem = visit(classmem);
            if (mem instanceof DefvarlistNode) defvars.addAll(((DefvarlistNode)mem).getVars());
            else defuns.add((DefunNode)mem);
        }
        DefunNode constructor = null;
        if (ctx.constructor() != null)
            constructor = (DefunNode) visit(ctx.constructor());
        DefclassNode ret = new DefclassNode(name,defvars,defuns,constructor);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitConstructor(Mx_starParser.ConstructorContext ctx) {
        VartypeNode type = new VartypeNode(new Type(Type.Types.VOID,true,0),null);
        String name = ctx.Identifier().getText();
        List <DefvarNode> params = new ArrayList<>();
        params.addAll(((DefvarlistNode)visit(ctx.params())).getVars());
        BlockNode block = (BlockNode) visit(ctx.block());
        return new DefunNode(type,name,params,block);
    }

    @Override
    public Node visitClassmem(Mx_starParser.ClassmemContext ctx) {
        if (ctx.defvar() != null) return visit(ctx.defvar());
        else return visit(ctx.defun());
    }

    @Override
    public Node visitDefvar(Mx_starParser.DefvarContext ctx) {
        VartypeNode type = (VartypeNode)visit(ctx.vartype());
        List <DefvarNode> vars = new ArrayList<>();
        for (ParserRuleContext var:ctx.defvarassignment()) {
            String name = ((Mx_starParser.DefvarassignmentContext)var).Identifier().getText();
            ExpressionNode expr = (ExpressionNode) visit(((Mx_starParser.DefvarassignmentContext)var).expression());
            vars.add(new DefvarNode(type,name,expr));
        }
        DefvarlistNode ret = new DefvarlistNode(vars);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitDefun(Mx_starParser.DefunContext ctx) {
        VartypeNode type = (VartypeNode)visit(ctx.funtype());
        String name = ctx.Identifier().getText();
        List <DefvarNode> params = new ArrayList<>();
        params.addAll(((DefvarlistNode)visit(ctx.params())).getVars());
        BlockNode block = (BlockNode) visit(ctx.block());
        return new DefunNode(type,name,params,block);
    }

    @Override
    public Node visitParams(Mx_starParser.ParamsContext ctx) {
        List<DefvarNode> vars = new ArrayList<>();
        int n = ctx.Identifier().size();
        for (int i = 0;i < n;++i) {
            VartypeNode type = (VartypeNode)visit(ctx.vartype(i));
            String name = ctx.Identifier(i).getText();
            vars.add(new DefvarNode(type,name,null));
        }
        DefvarlistNode ret = new DefvarlistNode(vars);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitBlock(Mx_starParser.BlockContext ctx) {
        List<Node> stmts = new ArrayList<>();
        for (ParserRuleContext stmt:ctx.stmt()) {
            stmts.add((StmtNode) visit(stmt));
        }
        BlockNode ret = new BlockNode(stmts);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitStmt(Mx_starParser.StmtContext ctx) {
        if (ctx.defvar() != null) return visit(ctx.defvar());
        else if (ctx.assignment() != null) return visit(ctx.assignment());
        else if (ctx.expression() != null) return visit(ctx.expression());
        else if (ctx.block() != null) return visit(ctx.block());
        else if (ctx.if_stmt() != null) return visit(ctx.if_stmt());
        else if (ctx.while_stmt() != null) return visit(ctx.while_stmt());
        else if (ctx.for_stmt() != null) return visit(ctx.for_stmt());
        else if (ctx.Continue() != null){
            ContinueStmtNode ret = new ContinueStmtNode();
            ret.setLocation(Location.fromCtx(ctx));
            return ret;
        }
        else if (ctx.Break() != null) {
            BreakStmtNode ret = new BreakStmtNode();
            ret.setLocation(Location.fromCtx(ctx));
            return ret;
        }
        else if (ctx.return_stmt() != null) return visit(ctx.return_stmt());
        else {
            BlankStmtNode ret = new BlankStmtNode();
            ret.setLocation(Location.fromCtx(ctx));
            return ret;
        }
    }

    @Override
    public Node visitCallfun(Mx_starParser.CallfunContext ctx) { return visitChildren(ctx); }

}