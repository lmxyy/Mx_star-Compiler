// Generated from Mx_star.g4 by ANTLR 4.7.1

package com.lmxyy.mxcompiler.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Mx_starParser}.
 */
public interface Mx_starListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(Mx_starParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(Mx_starParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#progsec}.
	 * @param ctx the parse tree
	 */
	void enterProgsec(Mx_starParser.ProgsecContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#progsec}.
	 * @param ctx the parse tree
	 */
	void exitProgsec(Mx_starParser.ProgsecContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#defclass}.
	 * @param ctx the parse tree
	 */
	void enterDefclass(Mx_starParser.DefclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#defclass}.
	 * @param ctx the parse tree
	 */
	void exitDefclass(Mx_starParser.DefclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(Mx_starParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(Mx_starParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#classmem}.
	 * @param ctx the parse tree
	 */
	void enterClassmem(Mx_starParser.ClassmemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#classmem}.
	 * @param ctx the parse tree
	 */
	void exitClassmem(Mx_starParser.ClassmemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#defvar}.
	 * @param ctx the parse tree
	 */
	void enterDefvar(Mx_starParser.DefvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#defvar}.
	 * @param ctx the parse tree
	 */
	void exitDefvar(Mx_starParser.DefvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#defvarassignment}.
	 * @param ctx the parse tree
	 */
	void enterDefvarassignment(Mx_starParser.DefvarassignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#defvarassignment}.
	 * @param ctx the parse tree
	 */
	void exitDefvarassignment(Mx_starParser.DefvarassignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#defun}.
	 * @param ctx the parse tree
	 */
	void enterDefun(Mx_starParser.DefunContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#defun}.
	 * @param ctx the parse tree
	 */
	void exitDefun(Mx_starParser.DefunContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(Mx_starParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(Mx_starParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Mx_starParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Mx_starParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(Mx_starParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(Mx_starParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#callfun}.
	 * @param ctx the parse tree
	 */
	void enterCallfun(Mx_starParser.CallfunContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#callfun}.
	 * @param ctx the parse tree
	 */
	void exitCallfun(Mx_starParser.CallfunContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(Mx_starParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(Mx_starParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(Mx_starParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(Mx_starParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(Mx_starParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(Mx_starParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(Mx_starParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(Mx_starParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Mx_starParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Mx_starParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(Mx_starParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(Mx_starParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Mx_starParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Mx_starParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(Mx_starParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(Mx_starParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#vartype_plus}.
	 * @param ctx the parse tree
	 */
	void enterVartype_plus(Mx_starParser.Vartype_plusContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#vartype_plus}.
	 * @param ctx the parse tree
	 */
	void exitVartype_plus(Mx_starParser.Vartype_plusContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#vartype}.
	 * @param ctx the parse tree
	 */
	void enterVartype(Mx_starParser.VartypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#vartype}.
	 * @param ctx the parse tree
	 */
	void exitVartype(Mx_starParser.VartypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#basetype}.
	 * @param ctx the parse tree
	 */
	void enterBasetype(Mx_starParser.BasetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#basetype}.
	 * @param ctx the parse tree
	 */
	void exitBasetype(Mx_starParser.BasetypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#funtype}.
	 * @param ctx the parse tree
	 */
	void enterFuntype(Mx_starParser.FuntypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#funtype}.
	 * @param ctx the parse tree
	 */
	void exitFuntype(Mx_starParser.FuntypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Mx_starParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Mx_starParser.LiteralContext ctx);
}