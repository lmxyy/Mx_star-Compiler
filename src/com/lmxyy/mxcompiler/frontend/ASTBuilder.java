package com.lmxyy.mxcompiler.frontend;
import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.parser.Mx_starBaseVisitor;
import com.lmxyy.mxcompiler.parser.Mx_starParser;
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

}