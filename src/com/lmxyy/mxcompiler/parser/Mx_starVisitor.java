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
	 * Visit a parse tree produced by {@link Mx_starParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Mx_starParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_starParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(Mx_starParser.TermContext ctx);
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