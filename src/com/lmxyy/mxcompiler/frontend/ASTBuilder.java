package com.lmxyy.mxcompiler.frontend;
import com.lmxyy.mxcompiler.ast.*;
import com.lmxyy.mxcompiler.parser.Mx_starBaseVisitor;
import com.lmxyy.mxcompiler.parser.Mx_starParser;
import com.lmxyy.mxcompiler.symbol.ExprOperator;
import com.lmxyy.mxcompiler.symbol.GlobalSymbolTable;
import com.lmxyy.mxcompiler.symbol.Type;
import com.lmxyy.mxcompiler.utils.Location;
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
        boolean inline = ctx.Inline() != null;
        VartypeNode type = new VartypeNode(GlobalSymbolTable.voidType);
        type.setLocation(Location.fromCtx(ctx));
        String name = ctx.Identifier().getText();
        List <DefvarNode> params = new ArrayList<>();
        params.addAll(((DefvarlistNode)visit(ctx.params())).getVars());
        BlockNode block = (BlockNode) visit(ctx.block());
        return new DefunNode(inline,type,name,params,block);
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
        boolean inline = ctx.Inline() != null;
        VartypeNode type = (VartypeNode)visit(ctx.funtype());
        String name = ctx.Identifier().getText();
        List <DefvarNode> params = new ArrayList<>();
        params.addAll(((DefvarlistNode)visit(ctx.params())).getVars());
        BlockNode block = (BlockNode) visit(ctx.block());
        return new DefunNode(inline,type,name,params,block);
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
        String name = ctx.Identifier().getText();
        List<ExpressionNode> params = new ArrayList<>();
        for (ParserRuleContext param:ctx.expression()) {
            params.add((ExpressionNode)visit(param));
        }
        CallfunNode ret = new CallfunNode(name,params);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
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
        List<Node> init2 = null;
        ExpressionNode cond = null;
        List<Node> step = null;
        StmtNode block = null;
        if (ctx.forinit() != null) {
            if (((Mx_starParser.ForinitContext) ctx.forinit()).defvar() != null)
                init1 = (DefvarlistNode) visit(((Mx_starParser.ForinitContext)ctx.forinit()).defvar());
            else if (((Mx_starParser.ForinitContext) ctx.forinit()).expressionorassignment() != null) {
                init2 = new ArrayList<>();
                for (Mx_starParser.ExpressionorassignmentContext stmt:((Mx_starParser.ForinitContext) ctx.forinit()).expressionorassignment()) {
                    if (stmt.expression() != null)
                        init2.add(visit(stmt.expression()));
                    else init2.add(visit(stmt.assignment()));
                }
            }
        }
        if (ctx.expression() != null)
            cond = (ExpressionNode) visit(ctx.expression());
        if (ctx.forstep() != null) {
            step = new ArrayList<>();
            for (Mx_starParser.ExpressionorassignmentContext stmt:((Mx_starParser.ForstepContext) ctx.forstep()).expressionorassignment()) {
                if (stmt.expression() != null)
                    step.add(visit(stmt.expression()));
                else step.add(visit(stmt.assignment()));
            }
        }
        if (((Mx_starParser.StmtorblockContext)ctx.stmtorblock()).stmt() != null) {
            List<Node> stmts = new ArrayList<>();
            stmts.add((Node)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock()).stmt()));
            block = new BlockNode(stmts);
        }
        else block = (BlockNode)visit(((Mx_starParser.StmtorblockContext)ctx.stmtorblock()).block());
        ForStmtNode ret = new ForStmtNode(init1,init2,cond,step,block);
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
        ExpressionNode var = (ExpressionNode)visit(ctx.expression(0));
        ExpressionNode expr = (ExpressionNode)visit(ctx.expression(1));
        return new AssignmentNode(var,expr);
    }

    @Override
    public Node visitVariable(Mx_starParser.VariableContext ctx) {
        VariableNode var = null;
        IdentifierNode id = null;
        ExpressionNode expr = null;
        boolean isThis = false;
        Location location = null;
        if (ctx.This() != null) {
            isThis = true;
            location = Location.fromCtx(ctx.This());
        }
        if (ctx.variable() != null)
            var = (VariableNode) visit(ctx.variable());
        if (ctx.Identifier() != null) {
            id = new IdentifierNode(ctx.Identifier().getText());
            id.setLocation(Location.fromCtx(ctx.Identifier()));
        }
        if (ctx.expression() != null)
            expr = (ExpressionNode) visit(ctx.expression());
        VariableNode ret = new VariableNode(var,id,expr,isThis);
        ret.setLocation(location);
        return ret;
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
        boolean hasPar = false;
        if (ctx.term() != null) {
            exprs.add((ExprNode) visit(ctx.term()));
            op = new ExprOperator(ExprOperator.Operator.SELF);
        }
        else if (ctx.mem() == null&&ctx.callfun() != null) {
            exprs.add((ExprNode) visit(ctx.callfun()));
            op = new ExprOperator(ExprOperator.Operator.SELF);
        }
        else if (ctx.lefpar() != null&&ctx.lefpar() != null&&ctx.expression() != null&&ctx.New() == null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            op = new ExprOperator(ExprOperator.Operator.SELF);
        }
        else if (ctx.mem() != null&&ctx.callfun() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            exprs.add((ExprNode) visit(ctx.callfun()));
            op = new ExprOperator(ExprOperator.Operator.MEM);
        }
        else if (ctx.mem() != null&&ctx.Identifier() != null) {
            exprs.add((ExprNode) visit(ctx.expression(0)));
            IdentifierNode id = new IdentifierNode(ctx.Identifier().getText());
            id.setLocation(Location.fromCtx(ctx.Identifier()));
            exprs.add((ExprNode) id);
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
            if (ctx.lefpar() != null)
                hasPar = true;
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
        return new ExpressionNode(exprs,vartype,op,hasPar);
    }

    @Override
    public Node visitVartype_plus(Mx_starParser.Vartype_plusContext ctx) {
        Type type = null;
        String name = null;
        List<ExpressionNode> dims = new ArrayList<>();
        int d = 0;
        if (ctx.lefbra() != null) d = ctx.lefbra().size();
        if (((Mx_starParser.BasetypeContext)ctx.basetype()).Int() != null) {
            type = new Type(Type.Types.INT, d);
            name = "int";
        }
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).String() != null) {
            type = new Type(Type.Types.STRING, d);
            name = "string";
        }
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).Bool() != null) {
            type = new Type(Type.Types.BOOL,d);
            name = "bool";
        }
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).Identifier() != null) {
            type = new Type(Type.Types.CLASS,d);
            name = ((Mx_starParser.BasetypeContext)ctx.basetype()).Identifier().getText();
        }
        if (ctx.expression() != null)
            for (ParserRuleContext dim:ctx.expression())
                dims.add((ExpressionNode) visit(dim));
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
        if (((Mx_starParser.BasetypeContext)ctx.basetype()).Int() != null) {
            type = new Type(Type.Types.INT, d);
            name = "int";
        }
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).String() != null) {
            type = new Type(Type.Types.STRING, d);
            name = "string";
        }
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).Bool() != null) {
            type = new Type(Type.Types.BOOL, d);
            name = "bool";
        }
        else if (((Mx_starParser.BasetypeContext)ctx.basetype()).Identifier() != null) {
            type = new Type(Type.Types.CLASS, d);
            name = ((Mx_starParser.BasetypeContext)ctx.basetype()).Identifier().getText();
        }
        VartypeNode ret =  new VartypeNode(type,name);
        ret.setLocation(Location.fromCtx(ctx));
        return ret;
    }

    @Override
    public Node visitFuntype(Mx_starParser.FuntypeContext ctx) {
        if (ctx.vartype() != null) return visit(ctx.vartype());
        else return GlobalSymbolTable.voidType;
    }

    @Override
    public Node visitLiteral(Mx_starParser.LiteralContext ctx) {
        if (ctx.Integerliteral() != null) {
            IntegerliteralNode ret = new IntegerliteralNode(Integer.valueOf(ctx.Integerliteral().getText()));
            ret.setLocation(Location.fromCtx(ctx));
            return ret;
        }
        else if (ctx.Stringliteral() != null) {
            String s = ctx.Stringliteral().getText();
            StringliteralNode ret = new StringliteralNode(s.substring(1,s.length()-1));
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