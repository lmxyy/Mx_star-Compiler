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
	 * Enter a parse tree produced by {@link Mx_starParser#stmtorblock}.
	 * @param ctx the parse tree
	 */
	void enterStmtorblock(Mx_starParser.StmtorblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#stmtorblock}.
	 * @param ctx the parse tree
	 */
	void exitStmtorblock(Mx_starParser.StmtorblockContext ctx);
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
	 * Enter a parse tree produced by {@link Mx_starParser#forinit}.
	 * @param ctx the parse tree
	 */
	void enterForinit(Mx_starParser.ForinitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#forinit}.
	 * @param ctx the parse tree
	 */
	void exitForinit(Mx_starParser.ForinitContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#forstep}.
	 * @param ctx the parse tree
	 */
	void enterForstep(Mx_starParser.ForstepContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#forstep}.
	 * @param ctx the parse tree
	 */
	void exitForstep(Mx_starParser.ForstepContext ctx);
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
	 * Enter a parse tree produced by {@link Mx_starParser#lefpar}.
	 * @param ctx the parse tree
	 */
	void enterLefpar(Mx_starParser.LefparContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#lefpar}.
	 * @param ctx the parse tree
	 */
	void exitLefpar(Mx_starParser.LefparContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#rigpar}.
	 * @param ctx the parse tree
	 */
	void enterRigpar(Mx_starParser.RigparContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#rigpar}.
	 * @param ctx the parse tree
	 */
	void exitRigpar(Mx_starParser.RigparContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#mem}.
	 * @param ctx the parse tree
	 */
	void enterMem(Mx_starParser.MemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#mem}.
	 * @param ctx the parse tree
	 */
	void exitMem(Mx_starParser.MemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#lefbra}.
	 * @param ctx the parse tree
	 */
	void enterLefbra(Mx_starParser.LefbraContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#lefbra}.
	 * @param ctx the parse tree
	 */
	void exitLefbra(Mx_starParser.LefbraContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#rigbra}.
	 * @param ctx the parse tree
	 */
	void enterRigbra(Mx_starParser.RigbraContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#rigbra}.
	 * @param ctx the parse tree
	 */
	void exitRigbra(Mx_starParser.RigbraContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#sinc}.
	 * @param ctx the parse tree
	 */
	void enterSinc(Mx_starParser.SincContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#sinc}.
	 * @param ctx the parse tree
	 */
	void exitSinc(Mx_starParser.SincContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#sdec}.
	 * @param ctx the parse tree
	 */
	void enterSdec(Mx_starParser.SdecContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#sdec}.
	 * @param ctx the parse tree
	 */
	void exitSdec(Mx_starParser.SdecContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#pinc}.
	 * @param ctx the parse tree
	 */
	void enterPinc(Mx_starParser.PincContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#pinc}.
	 * @param ctx the parse tree
	 */
	void exitPinc(Mx_starParser.PincContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#pdec}.
	 * @param ctx the parse tree
	 */
	void enterPdec(Mx_starParser.PdecContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#pdec}.
	 * @param ctx the parse tree
	 */
	void exitPdec(Mx_starParser.PdecContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(Mx_starParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(Mx_starParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(Mx_starParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(Mx_starParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(Mx_starParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(Mx_starParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#times}.
	 * @param ctx the parse tree
	 */
	void enterTimes(Mx_starParser.TimesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#times}.
	 * @param ctx the parse tree
	 */
	void exitTimes(Mx_starParser.TimesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#divide}.
	 * @param ctx the parse tree
	 */
	void enterDivide(Mx_starParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#divide}.
	 * @param ctx the parse tree
	 */
	void exitDivide(Mx_starParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#mod}.
	 * @param ctx the parse tree
	 */
	void enterMod(Mx_starParser.ModContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#mod}.
	 * @param ctx the parse tree
	 */
	void exitMod(Mx_starParser.ModContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(Mx_starParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(Mx_starParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(Mx_starParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(Mx_starParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#lesh}.
	 * @param ctx the parse tree
	 */
	void enterLesh(Mx_starParser.LeshContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#lesh}.
	 * @param ctx the parse tree
	 */
	void exitLesh(Mx_starParser.LeshContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#rish}.
	 * @param ctx the parse tree
	 */
	void enterRish(Mx_starParser.RishContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#rish}.
	 * @param ctx the parse tree
	 */
	void exitRish(Mx_starParser.RishContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#less}.
	 * @param ctx the parse tree
	 */
	void enterLess(Mx_starParser.LessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#less}.
	 * @param ctx the parse tree
	 */
	void exitLess(Mx_starParser.LessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#grtr}.
	 * @param ctx the parse tree
	 */
	void enterGrtr(Mx_starParser.GrtrContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#grtr}.
	 * @param ctx the parse tree
	 */
	void exitGrtr(Mx_starParser.GrtrContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#leq}.
	 * @param ctx the parse tree
	 */
	void enterLeq(Mx_starParser.LeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#leq}.
	 * @param ctx the parse tree
	 */
	void exitLeq(Mx_starParser.LeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#geq}.
	 * @param ctx the parse tree
	 */
	void enterGeq(Mx_starParser.GeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#geq}.
	 * @param ctx the parse tree
	 */
	void exitGeq(Mx_starParser.GeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#equ}.
	 * @param ctx the parse tree
	 */
	void enterEqu(Mx_starParser.EquContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#equ}.
	 * @param ctx the parse tree
	 */
	void exitEqu(Mx_starParser.EquContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#neq}.
	 * @param ctx the parse tree
	 */
	void enterNeq(Mx_starParser.NeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#neq}.
	 * @param ctx the parse tree
	 */
	void exitNeq(Mx_starParser.NeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#band}.
	 * @param ctx the parse tree
	 */
	void enterBand(Mx_starParser.BandContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#band}.
	 * @param ctx the parse tree
	 */
	void exitBand(Mx_starParser.BandContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#xor}.
	 * @param ctx the parse tree
	 */
	void enterXor(Mx_starParser.XorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#xor}.
	 * @param ctx the parse tree
	 */
	void exitXor(Mx_starParser.XorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#bor}.
	 * @param ctx the parse tree
	 */
	void enterBor(Mx_starParser.BorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#bor}.
	 * @param ctx the parse tree
	 */
	void exitBor(Mx_starParser.BorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(Mx_starParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(Mx_starParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(Mx_starParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(Mx_starParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_starParser#que}.
	 * @param ctx the parse tree
	 */
	void enterQue(Mx_starParser.QueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_starParser#que}.
	 * @param ctx the parse tree
	 */
	void exitQue(Mx_starParser.QueContext ctx);
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