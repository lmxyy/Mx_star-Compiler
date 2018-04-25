// Generated from Mx_star.g4 by ANTLR 4.7.1

package com.lmxyy.mxcompiler.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Mx_starParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Mx_starVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(Mx_starParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#progsec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgsec(Mx_starParser.ProgsecContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#defclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefclass(Mx_starParser.DefclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(Mx_starParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#classmem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassmem(Mx_starParser.ClassmemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#defvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefvar(Mx_starParser.DefvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#defvarassignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefvarassignment(Mx_starParser.DefvarassignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#defun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefun(Mx_starParser.DefunContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(Mx_starParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Mx_starParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(Mx_starParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#callfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallfun(Mx_starParser.CallfunContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#stmtorblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtorblock(Mx_starParser.StmtorblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(Mx_starParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(Mx_starParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(Mx_starParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#expressionorassignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionorassignment(Mx_starParser.ExpressionorassignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#forinit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForinit(Mx_starParser.ForinitContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#forstep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstep(Mx_starParser.ForstepContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(Mx_starParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Mx_starParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(Mx_starParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(Mx_starParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Mx_starParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#lefpar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLefpar(Mx_starParser.LefparContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#rigpar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRigpar(Mx_starParser.RigparContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#mem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMem(Mx_starParser.MemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#lefbra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLefbra(Mx_starParser.LefbraContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#rigbra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRigbra(Mx_starParser.RigbraContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#sinc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinc(Mx_starParser.SincContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#sdec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdec(Mx_starParser.SdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#pinc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPinc(Mx_starParser.PincContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#pdec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPdec(Mx_starParser.PdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#neg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg(Mx_starParser.NegContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(Mx_starParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(Mx_starParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#times}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimes(Mx_starParser.TimesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#divide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(Mx_starParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#mod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod(Mx_starParser.ModContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(Mx_starParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(Mx_starParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#lesh}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLesh(Mx_starParser.LeshContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#rish}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRish(Mx_starParser.RishContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#less}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess(Mx_starParser.LessContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#grtr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrtr(Mx_starParser.GrtrContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#leq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeq(Mx_starParser.LeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#geq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeq(Mx_starParser.GeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#equ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqu(Mx_starParser.EquContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#neq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeq(Mx_starParser.NeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#band}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBand(Mx_starParser.BandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#xor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor(Mx_starParser.XorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#bor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBor(Mx_starParser.BorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(Mx_starParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(Mx_starParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#que}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQue(Mx_starParser.QueContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#vartype_plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVartype_plus(Mx_starParser.Vartype_plusContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#vartype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVartype(Mx_starParser.VartypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#basetype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasetype(Mx_starParser.BasetypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#funtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuntype(Mx_starParser.FuntypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(Mx_starParser.LiteralContext ctx);
}