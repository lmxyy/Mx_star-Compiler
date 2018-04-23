package com.lmxyy.mxcompiler.frontend;
import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.parser.Mx_starBaseVisitor;
import com.lmxyy.mxcompiler.parser.Mx_starParser;
import com.lmxyy.mxcompiler.symbol.ExprOperator;
import com.lmxyy.mxcompiler.symbol.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

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
            ExpressionNode expr = null;
            if (((Mx_starParser.DefvarassignmentContext)var).expression() != null)
                expr = (ExpressionNode) visit(((Mx_starParser.DefvarassignmentContext)var).expression());
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
            stmts.add((Node) visit(stmt));
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
    public Node visitCallfun(Mx_starParser.CallfunContext ctx) {
        VariableNode var = (VariableNode)visit(ctx.variable());
        List<ExpressionNode> params = new ArrayList<>();
        for (ParserRuleContext param:ctx.expression()) {
            params.add((ExpressionNode)visit(param));
        }
        return new CallfunNode(var,params);
    }

    @Override
    public Node visitIf_stmt(Mx_starParser.If_stmtContext ctx) {
        ExpressionNode cond = (ExpressionNode)visit(ctx.expression());
        BlockNode block1 = null;
        if (((Mx_starParser.StmtorblockContext)ctx.stmtorblock(0)).stmt() != null) {
            List<Node> stmts = new ArrayList<>();
            stmts.add((Node)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock(0)).stmt()));
            block1 = new BlockNode(stmts);
        }
        else block1 = (BlockNode)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock(0)).block());
        boolean hasElse = false;
        BlockNode block2 = null;
        if (ctx.Else() != null) {
            hasElse = true;
            if (((Mx_starParser.StmtorblockContext)ctx.stmtorblock(1)).stmt() != null) {
                List<Node> stmts = new ArrayList<>();
                stmts.add((Node)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock(1)).stmt()));
                block2 = new BlockNode(stmts);
            }
            else block2 = (BlockNode)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock(1)).block());
        }
        return new IfStmtNode(cond,block1,hasElse,block2);
    }

    @Override
    public Node visitWhile_stmt(Mx_starParser.While_stmtContext ctx) {
        ExpressionNode cond = (ExpressionNode)visit(ctx.expression());
        BlockNode block = null;
        if (((Mx_starParser.StmtorblockContext)ctx.stmtorblock()).stmt() != null) {
            List<Node> stmts = new ArrayList<>();
            stmts.add((Node)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock()).stmt()));
            block = new BlockNode(stmts);
        }
        else block = (BlockNode)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock()).block());
        WhileStmtNode ret = new WhileStmtNode(cond,block);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitFor_stmt(Mx_starParser.For_stmtContext ctx) {
        DefvarlistNode init1 = null;
        ExpressionNode init2 = null;
        AssignmentNode init3 = null;
        ExpressionNode cond = null;
        AssignmentNode step1 = null;
        ExpressionNode step2 = null;
        StmtNode block = null;
        if (ctx.forinit() != null) {
            if (((Mx_starParser.ForinitContext) ctx.forinit()).defvar() != null)
                init1 = (DefvarlistNode) visit(((Mx_starParser.ForinitContext)ctx.forinit()).defvar());
            else if (((Mx_starParser.ForinitContext) ctx.forinit()).expression() != null)
                init2 = (ExpressionNode) visit(((Mx_starParser.ForinitContext)ctx.forinit()).expression());
            else init3 = (AssignmentNode) visit(((Mx_starParser.ForinitContext)ctx.forinit()).assignment());
        }
        if (ctx.expression() != null)
            cond = (ExpressionNode) visit(ctx.expression());
        if (ctx.forstep() != null) {
            if (((Mx_starParser.ForstepContext) ctx.forstep()).assignment() != null)
                step1 = (AssignmentNode) visit(((Mx_starParser.ForstepContext) ctx.forstep()).assignment());
            else step2 = (ExpressionNode) visit(((Mx_starParser.ForstepContext)ctx.forstep()).expression());
        }
        if (((Mx_starParser.StmtorblockContext)ctx.stmtorblock()).stmt() != null) {
            List<Node> stmts = new ArrayList<>();
            stmts.add((Node)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock()).stmt()));
            block = new BlockNode(stmts);
        }
        else block = (BlockNode)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock()).block());
        ForStmtNode ret = new ForStmtNode(init1,init2,init3,cond,step1,step2,block);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitReturn_stmt(Mx_starParser.Return_stmtContext ctx) {
        ExpressionNode expr = null;
        if (ctx.expression() != null)
            expr = (ExpressionNode) visit(ctx.expression());
        ReturnStmtNode ret = new ReturnStmtNode(expr);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitAssignment(Mx_starParser.AssignmentContext ctx) {
        VariableNode var = (VariableNode)visit(ctx.variable());
        ExpressionNode expr = (ExpressionNode)visit(ctx.expression());
        return new AssignmentNode(var,expr);
    }

    @Override
    public Node visitVariable(Mx_starParser.VariableContext ctx) {
        VariableNode var = null;
        IdentifierNode id = null;
        ExpressionNode expr = null;
        if (ctx.variable() != null)
            var = (VariableNode) visit(ctx.variable());
        if (ctx.Identifier() != null)
            id = (IdentifierNode) visit(ctx.Identifier());
        if (ctx.expression() != null)
            expr = (ExpressionNode) visit(ctx.expression());
        return new VariableNode(var,id,expr);
    }

    @Override
    public Node visitTerm(Mx_starParser.TermContext ctx) {
        if (ctx.variable() != null)
            return (VariableNode) visit(ctx.variable());
        else return (LiteralNode) visit(ctx.literal());
    }

    @Override
    public Node visitExpression(Mx_starParser.ExpressionContext ctx) {
        List<ExprNode> exprs = new ArrayList<>();
        VartypePlusNode vartype = null;
        ExprOperator op = null;
        if (ctx.term() != null) {
            exprs.add((ExprNode) visit(ctx.term()));
            op = new ExprOperator(ExprOperator.Operator.SELF);
        }
        else if (ctx.mem() == null&&ctx.callfun() != null) {
            exprs.add((ExprNode) visit(ctx.callfun()));
            op = new ExprOperator(ExprOperator.Operator.SELF);
        }
        else if (ctx.lefpar() != null&&ctx.lefpar() != null&&ctx.expression() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            op = new ExprOperator(ExprOperator.Operator.SELF);
        }
        else if (ctx.mem() != null&&ctx.Identifier() != null) {
            exprs.add((ExprNode) visit(ctx.Identifier()));
            op = new ExprOperator(ExprOperator.Operator.MEM);
        }
        else if (ctx.lefbra() != null&&ctx.rigbra() != null&&ctx.expression() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.ARRAY);
        }
        else if (ctx.sinc() != null) {
            exprs.add((ExprNode) visit(ctx.variable()));
            op = new ExprOperator(ExprOperator.Operator.SINC);
        }
        else if (ctx.sdec() != null) {
            exprs.add((ExprNode) visit(ctx.variable()));
            op = new ExprOperator(ExprOperator.Operator.SDEC);
        }
        else if (ctx.pinc() != null) {
            exprs.add((ExprNode) visit(ctx.variable()));
            op = new ExprOperator(ExprOperator.Operator.PINC);
        }
        else if (ctx.pdec() != null) {
            exprs.add((ExprNode) visit(ctx.variable()));
            op = new ExprOperator(ExprOperator.Operator.PDEC);
        }
        else if (ctx.neg() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            op = new ExprOperator(ExprOperator.Operator.NEG);
        }
        else if (ctx.not() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            op = new ExprOperator(ExprOperator.Operator.NOT);
        }
        else if (ctx.comp() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            op = new ExprOperator(ExprOperator.Operator.COMP);
        }
        else if (ctx.New() != null) {
            vartype = (VartypePlusNode) visit(ctx.vartype_plus());
            for (ParserRuleContext expr:ctx.expression())
                exprs.add((ExpressionNode) visit(expr));
            op = new ExprOperator(ExprOperator.Operator.NEW);
        }
        else if (ctx.times() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.TIMES);
        }
        else if (ctx.divide() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.DIVIDE);
        }
        else if (ctx.mod() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.MOD);
        }
        else if (ctx.add() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.ADD);
        }
        else if (ctx.sub() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.SUB);
        }
        else if (ctx.lesh() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.LESH);
        }
        else if (ctx.rish() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.RISH);
        }
        else if (ctx.less() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.LESS);
        }
        else if (ctx.leq() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.LEQ);
        }
        else if (ctx.grtr() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.GRTR);
        }
        else if (ctx.geq() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.GEQ);
        }
        else if (ctx.equ() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.EQU);
        }
        else if (ctx.neq() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.NEQ);
        }
        else if (ctx.band() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.BAND);
        }
        else if (ctx.xor() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.XOR);
        }
        else if (ctx.bor() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.BOR);
        }
        else if (ctx.and() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.LAND);
        }
        else if (ctx.or() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            op = new ExprOperator(ExprOperator.Operator.LOR);
        }
        else if (ctx.que() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.expression(1)));
            exprs.add((ExprNode) visit(ctx.expression(2)));
            op = new ExprOperator(ExprOperator.Operator.TRN);
        }
        return new ExpressionNode(exprs,vartype,op);
    }

    @Override
    public Node visitVartype_plus(Mx_starParser.Vartype_plusContext ctx) {
        Type type = null;
        String name = null;
        List<Integer> dims = new ArrayList<>();
        int d = 0;
        if (ctx.lefbra() != null) d = ctx.lefbra().size();
        if (((Mx_starParser.BasetypeContext)ctx.basetype()).Int() != null)
            type = new Type(Type.Types.INT,false,d);
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).String() != null)
            type = new Type(Type.Types.STRING,false,d);
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).Bool() != null)
            type = new Type(Type.Types.BOOL,false,d);
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).Identifier() != null) {
            type = new Type(Type.Types.CLASS, false, d);
            name = ((Mx_starParser.BasetypeContext)ctx.basetype()).Identifier().getText();
        }
        if (ctx.Integerliteral() != null)
            for (TerminalNode num:ctx.Integerliteral())
                dims.add(Integer.valueOf(num.getText()));
        VartypePlusNode ret =  new VartypePlusNode(type,name,dims);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitVartype(Mx_starParser.VartypeContext ctx) {
        Type type = null;
        String name = null;
        int d = 0;
        if (ctx.lefbra() != null) d = ctx.lefbra().size();
        if (((Mx_starParser.BasetypeContext)ctx.basetype()).Int() != null)
            type = new Type(Type.Types.INT,false,d);
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).String() != null)
            type = new Type(Type.Types.STRING,false,d);
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).Bool() != null)
            type = new Type(Type.Types.BOOL,false,d);
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).Identifier() != null) {
            type = new Type(Type.Types.CLASS, false, d);
            name = ((Mx_starParser.BasetypeContext)ctx.basetype()).Identifier().getText();
        }
        VartypeNode ret =  new VartypeNode(type,name);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitLiteral(Mx_starParser.LiteralContext ctx) {
        if (ctx.Integerliteral() != null) {
            IntegerliteralNode ret = new IntegerliteralNode(Integer.valueOf(ctx.Integerliteral().getText()));
            ret.setLocation(Location.fromCtx(ctx));
            return ret;
        }
        else if (ctx.Stringliteral() != null) {
            StringliteralNode ret = new StringliteralNode(ctx.Stringliteral().getText());
            ret.setLocation(Location.fromCtx(ctx));
            return ret;
        }
        else if (ctx.Booleanliteral() != null) {
            BooleanliteralNode ret = new BooleanliteralNode(Boolean.valueOf(ctx.Booleanliteral().getText()));
            ret.setLocation(Location.fromCtx(ctx));
            return ret;
        }
        else {
            NullNode ret = new NullNode();
            ret.setLocation(Location.fromCtx(ctx));
            return ret;
        }
    }

}