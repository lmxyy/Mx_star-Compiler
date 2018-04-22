// Generated from Mx_star.g4 by ANTLR 4.7.1

package com.lmxyy.mxcompiler.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Mx_starParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, Booleanliteral=35, Stringliteral=36, Integerliteral=37, 
		Whitespace=38, Newline=39, BlockComment=40, LineComment=41, Int=42, Bool=43, 
		String=44, Null=45, Void=46, True=47, False=48, If=49, Else=50, For=51, 
		While=52, Break=53, Continue=54, Return=55, New=56, Class=57, This=58, 
		Identifier=59;
	public static final int
		RULE_prog = 0, RULE_progsec = 1, RULE_defclass = 2, RULE_constructor = 3, 
		RULE_classmem = 4, RULE_defvar = 5, RULE_defvarassignment = 6, RULE_defun = 7, 
		RULE_params = 8, RULE_block = 9, RULE_stmt = 10, RULE_callfun = 11, RULE_stmtorblock = 12, 
		RULE_if_stmt = 13, RULE_while_stmt = 14, RULE_for_stmt = 15, RULE_forinit = 16, 
		RULE_forstep = 17, RULE_return_stmt = 18, RULE_assignment = 19, RULE_variable = 20, 
		RULE_term = 21, RULE_expression = 22, RULE_lefpar = 23, RULE_rigpar = 24, 
		RULE_mem = 25, RULE_lefbra = 26, RULE_rigbra = 27, RULE_sinc = 28, RULE_sdec = 29, 
		RULE_pinc = 30, RULE_pdec = 31, RULE_neg = 32, RULE_not = 33, RULE_comp = 34, 
		RULE_times = 35, RULE_divide = 36, RULE_mod = 37, RULE_add = 38, RULE_sub = 39, 
		RULE_lesh = 40, RULE_rish = 41, RULE_less = 42, RULE_grtr = 43, RULE_leq = 44, 
		RULE_geq = 45, RULE_equ = 46, RULE_neq = 47, RULE_band = 48, RULE_xor = 49, 
		RULE_bor = 50, RULE_and = 51, RULE_or = 52, RULE_que = 53, RULE_vartype_plus = 54, 
		RULE_vartype = 55, RULE_basetype = 56, RULE_funtype = 57, RULE_literal = 58;
	public static final String[] ruleNames = {
		"prog", "progsec", "defclass", "constructor", "classmem", "defvar", "defvarassignment", 
		"defun", "params", "block", "stmt", "callfun", "stmtorblock", "if_stmt", 
		"while_stmt", "for_stmt", "forinit", "forstep", "return_stmt", "assignment", 
		"variable", "term", "expression", "lefpar", "rigpar", "mem", "lefbra", 
		"rigbra", "sinc", "sdec", "pinc", "pdec", "neg", "not", "comp", "times", 
		"divide", "mod", "add", "sub", "lesh", "rish", "less", "grtr", "leq", 
		"geq", "equ", "neq", "band", "xor", "bor", "and", "or", "que", "vartype_plus", 
		"vartype", "basetype", "funtype", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'{'", "'}'", "'('", "')'", "','", "'='", "'.'", "'['", "']'", 
		"':'", "'++'", "'--'", "'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'+'", 
		"'<<'", "'>>'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&'", "'^'", 
		"'|'", "'&&'", "'||'", "'?'", null, null, null, null, null, null, null, 
		"'int'", "'bool'", "'string'", "'null'", "'void'", "'true'", "'false'", 
		"'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", "'return'", 
		"'new'", "'class'", "'this'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "Booleanliteral", 
		"Stringliteral", "Integerliteral", "Whitespace", "Newline", "BlockComment", 
		"LineComment", "Int", "Bool", "String", "Null", "Void", "True", "False", 
		"If", "Else", "For", "While", "Break", "Continue", "Return", "New", "Class", 
		"This", "Identifier"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Mx_star.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Mx_starParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<ProgsecContext> progsec() {
			return getRuleContexts(ProgsecContext.class);
		}
		public ProgsecContext progsec(int i) {
			return getRuleContext(ProgsecContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(118);
				progsec();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgsecContext extends ParserRuleContext {
		public DefclassContext defclass() {
			return getRuleContext(DefclassContext.class,0);
		}
		public DefvarContext defvar() {
			return getRuleContext(DefvarContext.class,0);
		}
		public DefunContext defun() {
			return getRuleContext(DefunContext.class,0);
		}
		public ProgsecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progsec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterProgsec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitProgsec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitProgsec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgsecContext progsec() throws RecognitionException {
		ProgsecContext _localctx = new ProgsecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_progsec);
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				defclass();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				defvar();
				setState(126);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				defun();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefclassContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(Mx_starParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(Mx_starParser.Identifier, 0); }
		public List<ClassmemContext> classmem() {
			return getRuleContexts(ClassmemContext.class);
		}
		public ClassmemContext classmem(int i) {
			return getRuleContext(ClassmemContext.class,i);
		}
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public DefclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterDefclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitDefclass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitDefclass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefclassContext defclass() throws RecognitionException {
		DefclassContext _localctx = new DefclassContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_defclass);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(Class);
			setState(132);
			match(Identifier);
			setState(133);
			match(T__1);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(134);
					classmem();
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(140);
				constructor();
				}
				break;
			}
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(143);
				classmem();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Mx_starParser.Identifier, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(151);
			match(Identifier);
			setState(152);
			match(T__3);
			setState(153);
			params();
			setState(154);
			match(T__4);
			setState(155);
			block();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassmemContext extends ParserRuleContext {
		public DefvarContext defvar() {
			return getRuleContext(DefvarContext.class,0);
		}
		public DefunContext defun() {
			return getRuleContext(DefunContext.class,0);
		}
		public ClassmemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classmem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterClassmem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitClassmem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitClassmem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassmemContext classmem() throws RecognitionException {
		ClassmemContext _localctx = new ClassmemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classmem);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				defvar();
				setState(158);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				defun();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefvarContext extends ParserRuleContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public List<DefvarassignmentContext> defvarassignment() {
			return getRuleContexts(DefvarassignmentContext.class);
		}
		public DefvarassignmentContext defvarassignment(int i) {
			return getRuleContext(DefvarassignmentContext.class,i);
		}
		public DefvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterDefvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitDefvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitDefvar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefvarContext defvar() throws RecognitionException {
		DefvarContext _localctx = new DefvarContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defvar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(163);
			vartype();
			setState(164);
			defvarassignment();
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(166);
				match(T__5);
				setState(167);
				defvarassignment();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefvarassignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Mx_starParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DefvarassignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defvarassignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterDefvarassignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitDefvarassignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitDefvarassignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefvarassignmentContext defvarassignment() throws RecognitionException {
		DefvarassignmentContext _localctx = new DefvarassignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_defvarassignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(Identifier);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(174);
				match(T__6);
				setState(175);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefunContext extends ParserRuleContext {
		public FuntypeContext funtype() {
			return getRuleContext(FuntypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Mx_starParser.Identifier, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DefunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterDefun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitDefun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitDefun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefunContext defun() throws RecognitionException {
		DefunContext _localctx = new DefunContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_defun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			funtype();
			setState(179);
			match(Identifier);
			setState(180);
			match(T__3);
			setState(181);
			params();
			setState(182);
			match(T__4);
			setState(183);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(Mx_starParser.Void, 0); }
		public List<VartypeContext> vartype() {
			return getRuleContexts(VartypeContext.class);
		}
		public VartypeContext vartype(int i) {
			return getRuleContext(VartypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(Mx_starParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Mx_starParser.Identifier, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_params);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Void) {
					{
					setState(185);
					match(Void);
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(188);
				vartype();
				setState(189);
				match(Identifier);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(190);
					match(T__5);
					setState(191);
					vartype();
					setState(192);
					match(Identifier);
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(T__1);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				{
				setState(203);
				stmt();
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public DefvarContext defvar() {
			return getRuleContext(DefvarContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public TerminalNode Break() { return getToken(Mx_starParser.Break, 0); }
		public TerminalNode Continue() { return getToken(Mx_starParser.Continue, 0); }
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		try {
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				defvar();
				setState(212);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				assignment();
				setState(215);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				expression(0);
				setState(218);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				block();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(221);
				if_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(222);
				while_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(223);
				for_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(224);
				match(Break);
				setState(225);
				match(T__0);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(226);
				match(Continue);
				setState(227);
				match(T__0);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(228);
				return_stmt();
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(229);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallfunContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CallfunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callfun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterCallfun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitCallfun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitCallfun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallfunContext callfun() throws RecognitionException {
		CallfunContext _localctx = new CallfunContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_callfun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			variable(0);
			setState(233);
			match(T__3);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(234);
				expression(0);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(235);
					match(T__5);
					setState(236);
					expression(0);
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(244);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtorblockContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StmtorblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtorblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterStmtorblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitStmtorblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitStmtorblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtorblockContext stmtorblock() throws RecognitionException {
		StmtorblockContext _localctx = new StmtorblockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmtorblock);
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(Mx_starParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtorblockContext> stmtorblock() {
			return getRuleContexts(StmtorblockContext.class);
		}
		public StmtorblockContext stmtorblock(int i) {
			return getRuleContext(StmtorblockContext.class,i);
		}
		public TerminalNode Else() { return getToken(Mx_starParser.Else, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_if_stmt);
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				match(If);
				setState(251);
				match(T__3);
				setState(252);
				expression(0);
				setState(253);
				match(T__4);
				setState(254);
				stmtorblock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(If);
				setState(257);
				match(T__3);
				setState(258);
				expression(0);
				setState(259);
				match(T__4);
				setState(260);
				stmtorblock();
				setState(261);
				match(Else);
				setState(262);
				stmtorblock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(Mx_starParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StmtorblockContext stmtorblock() {
			return getRuleContext(StmtorblockContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(While);
			setState(267);
			match(T__3);
			setState(268);
			expression(0);
			setState(269);
			match(T__4);
			setState(270);
			stmtorblock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(Mx_starParser.For, 0); }
		public StmtorblockContext stmtorblock() {
			return getRuleContext(StmtorblockContext.class,0);
		}
		public ForinitContext forinit() {
			return getRuleContext(ForinitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForstepContext forstep() {
			return getRuleContext(ForstepContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitFor_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(For);
			setState(273);
			match(T__3);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(274);
				forinit();
				}
			}

			setState(277);
			match(T__0);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(278);
				expression(0);
				}
			}

			setState(281);
			match(T__0);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(282);
				forstep();
				}
			}

			setState(285);
			match(T__4);
			setState(286);
			stmtorblock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForinitContext extends ParserRuleContext {
		public DefvarContext defvar() {
			return getRuleContext(DefvarContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ForinitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forinit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterForinit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitForinit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitForinit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForinitContext forinit() throws RecognitionException {
		ForinitContext _localctx = new ForinitContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forinit);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				defvar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				assignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForstepContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForstepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterForstep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitForstep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitForstep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForstepContext forstep() throws RecognitionException {
		ForstepContext _localctx = new ForstepContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forstep);
		try {
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(Mx_starParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(Return);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(298);
				expression(0);
				}
			}

			setState(301);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(303);
			variable(0);
			setState(304);
			match(T__6);
			setState(305);
			expression(0);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Mx_starParser.Identifier, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		return variable(0);
	}

	private VariableContext variable(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableContext _localctx = new VariableContext(_ctx, _parentState);
		VariableContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_variable, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(308);
				match(Identifier);
				}
				break;
			case T__3:
				{
				setState(309);
				match(T__3);
				setState(310);
				variable(0);
				setState(311);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(325);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(323);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new VariableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable);
						setState(315);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(316);
						match(T__7);
						setState(317);
						match(Identifier);
						}
						break;
					case 2:
						{
						_localctx = new VariableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable);
						setState(318);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(319);
						match(T__8);
						setState(320);
						expression(0);
						setState(321);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_term);
		try {
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				variable(0);
				}
				break;
			case Booleanliteral:
			case Stringliteral:
			case Integerliteral:
			case Null:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public CallfunContext callfun() {
			return getRuleContext(CallfunContext.class,0);
		}
		public LefparContext lefpar() {
			return getRuleContext(LefparContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RigparContext rigpar() {
			return getRuleContext(RigparContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public SincContext sinc() {
			return getRuleContext(SincContext.class,0);
		}
		public SdecContext sdec() {
			return getRuleContext(SdecContext.class,0);
		}
		public PincContext pinc() {
			return getRuleContext(PincContext.class,0);
		}
		public PdecContext pdec() {
			return getRuleContext(PdecContext.class,0);
		}
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public TerminalNode New() { return getToken(Mx_starParser.New, 0); }
		public Vartype_plusContext vartype_plus() {
			return getRuleContext(Vartype_plusContext.class,0);
		}
		public TimesContext times() {
			return getRuleContext(TimesContext.class,0);
		}
		public DivideContext divide() {
			return getRuleContext(DivideContext.class,0);
		}
		public ModContext mod() {
			return getRuleContext(ModContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public SubContext sub() {
			return getRuleContext(SubContext.class,0);
		}
		public LeshContext lesh() {
			return getRuleContext(LeshContext.class,0);
		}
		public RishContext rish() {
			return getRuleContext(RishContext.class,0);
		}
		public GrtrContext grtr() {
			return getRuleContext(GrtrContext.class,0);
		}
		public GeqContext geq() {
			return getRuleContext(GeqContext.class,0);
		}
		public LessContext less() {
			return getRuleContext(LessContext.class,0);
		}
		public LeqContext leq() {
			return getRuleContext(LeqContext.class,0);
		}
		public EquContext equ() {
			return getRuleContext(EquContext.class,0);
		}
		public NeqContext neq() {
			return getRuleContext(NeqContext.class,0);
		}
		public BandContext band() {
			return getRuleContext(BandContext.class,0);
		}
		public XorContext xor() {
			return getRuleContext(XorContext.class,0);
		}
		public BorContext bor() {
			return getRuleContext(BorContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public QueContext que() {
			return getRuleContext(QueContext.class,0);
		}
		public MemContext mem() {
			return getRuleContext(MemContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Mx_starParser.Identifier, 0); }
		public LefbraContext lefbra() {
			return getRuleContext(LefbraContext.class,0);
		}
		public RigbraContext rigbra() {
			return getRuleContext(RigbraContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(333);
				term();
				}
				break;
			case 2:
				{
				setState(334);
				callfun();
				}
				break;
			case 3:
				{
				setState(335);
				lefpar();
				setState(336);
				expression(0);
				setState(337);
				rigpar();
				}
				break;
			case 4:
				{
				setState(339);
				variable(0);
				setState(342);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(340);
					sinc();
					}
					break;
				case T__12:
					{
					setState(341);
					sdec();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 5:
				{
				setState(346);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(344);
					pinc();
					}
					break;
				case T__12:
					{
					setState(345);
					pdec();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(348);
				variable(0);
				}
				break;
			case 6:
				{
				setState(353);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(350);
					neg();
					}
					break;
				case T__14:
					{
					setState(351);
					not();
					}
					break;
				case T__15:
					{
					setState(352);
					comp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(355);
				expression(13);
				}
				break;
			case 7:
				{
				setState(357);
				match(New);
				setState(358);
				vartype_plus();
				setState(371);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(359);
					match(T__3);
					setState(368);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
						{
						setState(360);
						expression(0);
						setState(365);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__5) {
							{
							{
							setState(361);
							match(T__5);
							setState(362);
							expression(0);
							}
							}
							setState(367);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(370);
					match(T__4);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(454);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(452);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(375);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(379);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__16:
							{
							setState(376);
							times();
							}
							break;
						case T__17:
							{
							setState(377);
							divide();
							}
							break;
						case T__18:
							{
							setState(378);
							mod();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(381);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(383);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(386);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__19:
							{
							setState(384);
							add();
							}
							break;
						case T__13:
							{
							setState(385);
							sub();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(388);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(390);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(393);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__20:
							{
							setState(391);
							lesh();
							}
							break;
						case T__21:
							{
							setState(392);
							rish();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(395);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(397);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(402);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__23:
							{
							setState(398);
							grtr();
							}
							break;
						case T__25:
							{
							setState(399);
							geq();
							}
							break;
						case T__22:
							{
							setState(400);
							less();
							}
							break;
						case T__24:
							{
							setState(401);
							leq();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(404);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(406);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(409);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__26:
							{
							setState(407);
							equ();
							}
							break;
						case T__27:
							{
							setState(408);
							neq();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(411);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(413);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(414);
						band();
						setState(415);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(417);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(418);
						xor();
						setState(419);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(421);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(422);
						bor();
						setState(423);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(425);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(426);
						and();
						setState(427);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(429);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(430);
						or();
						setState(431);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(433);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(434);
						que();
						setState(435);
						expression(0);
						setState(436);
						match(T__10);
						setState(437);
						expression(2);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(439);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(440);
						mem();
						setState(441);
						callfun();
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(443);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(444);
						mem();
						setState(445);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(447);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(448);
						lefbra();
						setState(449);
						expression(0);
						setState(450);
						rigbra();
						}
						break;
					}
					} 
				}
				setState(456);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LefparContext extends ParserRuleContext {
		public LefparContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lefpar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterLefpar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitLefpar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitLefpar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LefparContext lefpar() throws RecognitionException {
		LefparContext _localctx = new LefparContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lefpar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RigparContext extends ParserRuleContext {
		public RigparContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rigpar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterRigpar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitRigpar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitRigpar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RigparContext rigpar() throws RecognitionException {
		RigparContext _localctx = new RigparContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_rigpar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemContext extends ParserRuleContext {
		public MemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterMem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitMem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitMem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemContext mem() throws RecognitionException {
		MemContext _localctx = new MemContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LefbraContext extends ParserRuleContext {
		public LefbraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lefbra; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterLefbra(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitLefbra(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitLefbra(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LefbraContext lefbra() throws RecognitionException {
		LefbraContext _localctx = new LefbraContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_lefbra);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RigbraContext extends ParserRuleContext {
		public RigbraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rigbra; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterRigbra(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitRigbra(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitRigbra(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RigbraContext rigbra() throws RecognitionException {
		RigbraContext _localctx = new RigbraContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rigbra);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SincContext extends ParserRuleContext {
		public SincContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sinc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterSinc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitSinc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitSinc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SincContext sinc() throws RecognitionException {
		SincContext _localctx = new SincContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sinc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SdecContext extends ParserRuleContext {
		public SdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sdec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterSdec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitSdec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitSdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SdecContext sdec() throws RecognitionException {
		SdecContext _localctx = new SdecContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sdec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PincContext extends ParserRuleContext {
		public PincContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pinc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterPinc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitPinc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitPinc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PincContext pinc() throws RecognitionException {
		PincContext _localctx = new PincContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pinc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PdecContext extends ParserRuleContext {
		public PdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pdec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterPdec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitPdec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitPdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PdecContext pdec() throws RecognitionException {
		PdecContext _localctx = new PdecContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_pdec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegContext extends ParserRuleContext {
		public NegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitNeg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitNeg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegContext neg() throws RecognitionException {
		NegContext _localctx = new NegContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_neg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContext extends ParserRuleContext {
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompContext extends ParserRuleContext {
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimesContext extends ParserRuleContext {
		public TimesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_times; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterTimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitTimes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitTimes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimesContext times() throws RecognitionException {
		TimesContext _localctx = new TimesContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_times);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DivideContext extends ParserRuleContext {
		public DivideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivideContext divide() throws RecognitionException {
		DivideContext _localctx = new DivideContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_divide);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModContext extends ParserRuleContext {
		public ModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitMod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModContext mod() throws RecognitionException {
		ModContext _localctx = new ModContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_mod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(T__19);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubContext extends ParserRuleContext {
		public SubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubContext sub() throws RecognitionException {
		SubContext _localctx = new SubContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeshContext extends ParserRuleContext {
		public LeshContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lesh; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterLesh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitLesh(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitLesh(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeshContext lesh() throws RecognitionException {
		LeshContext _localctx = new LeshContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_lesh);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RishContext extends ParserRuleContext {
		public RishContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rish; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterRish(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitRish(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitRish(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RishContext rish() throws RecognitionException {
		RishContext _localctx = new RishContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_rish);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LessContext extends ParserRuleContext {
		public LessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_less; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterLess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitLess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitLess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessContext less() throws RecognitionException {
		LessContext _localctx = new LessContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_less);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GrtrContext extends ParserRuleContext {
		public GrtrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grtr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterGrtr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitGrtr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitGrtr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GrtrContext grtr() throws RecognitionException {
		GrtrContext _localctx = new GrtrContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_grtr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeqContext extends ParserRuleContext {
		public LeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterLeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitLeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitLeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeqContext leq() throws RecognitionException {
		LeqContext _localctx = new LeqContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_leq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeqContext extends ParserRuleContext {
		public GeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_geq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterGeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitGeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitGeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeqContext geq() throws RecognitionException {
		GeqContext _localctx = new GeqContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_geq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EquContext extends ParserRuleContext {
		public EquContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterEqu(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitEqu(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitEqu(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquContext equ() throws RecognitionException {
		EquContext _localctx = new EquContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_equ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NeqContext extends ParserRuleContext {
		public NeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitNeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitNeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NeqContext neq() throws RecognitionException {
		NeqContext _localctx = new NeqContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_neq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BandContext extends ParserRuleContext {
		public BandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_band; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterBand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitBand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitBand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BandContext band() throws RecognitionException {
		BandContext _localctx = new BandContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_band);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(T__28);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XorContext extends ParserRuleContext {
		public XorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitXor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitXor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XorContext xor() throws RecognitionException {
		XorContext _localctx = new XorContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_xor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BorContext extends ParserRuleContext {
		public BorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterBor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitBor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitBor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BorContext bor() throws RecognitionException {
		BorContext _localctx = new BorContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_bor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(T__31);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrContext extends ParserRuleContext {
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueContext extends ParserRuleContext {
		public QueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_que; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterQue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitQue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitQue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueContext que() throws RecognitionException {
		QueContext _localctx = new QueContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_que);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			match(T__33);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vartype_plusContext extends ParserRuleContext {
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public List<LefbraContext> lefbra() {
			return getRuleContexts(LefbraContext.class);
		}
		public LefbraContext lefbra(int i) {
			return getRuleContext(LefbraContext.class,i);
		}
		public List<TerminalNode> Integerliteral() { return getTokens(Mx_starParser.Integerliteral); }
		public TerminalNode Integerliteral(int i) {
			return getToken(Mx_starParser.Integerliteral, i);
		}
		public List<RigbraContext> rigbra() {
			return getRuleContexts(RigbraContext.class);
		}
		public RigbraContext rigbra(int i) {
			return getRuleContext(RigbraContext.class,i);
		}
		public Vartype_plusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vartype_plus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterVartype_plus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitVartype_plus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitVartype_plus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vartype_plusContext vartype_plus() throws RecognitionException {
		Vartype_plusContext _localctx = new Vartype_plusContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_vartype_plus);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			basetype();
			setState(526);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(520);
					lefbra();
					setState(521);
					match(Integerliteral);
					setState(522);
					rigbra();
					}
					} 
				}
				setState(528);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			setState(534);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(529);
					lefbra();
					setState(530);
					rigbra();
					}
					} 
				}
				setState(536);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VartypeContext extends ParserRuleContext {
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public List<LefbraContext> lefbra() {
			return getRuleContexts(LefbraContext.class);
		}
		public LefbraContext lefbra(int i) {
			return getRuleContext(LefbraContext.class,i);
		}
		public List<RigbraContext> rigbra() {
			return getRuleContexts(RigbraContext.class);
		}
		public RigbraContext rigbra(int i) {
			return getRuleContext(RigbraContext.class,i);
		}
		public VartypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vartype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterVartype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitVartype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitVartype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VartypeContext vartype() throws RecognitionException {
		VartypeContext _localctx = new VartypeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_vartype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			basetype();
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(538);
				lefbra();
				setState(539);
				rigbra();
				}
				}
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasetypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(Mx_starParser.Int, 0); }
		public TerminalNode String() { return getToken(Mx_starParser.String, 0); }
		public TerminalNode Bool() { return getToken(Mx_starParser.Bool, 0); }
		public TerminalNode Identifier() { return getToken(Mx_starParser.Identifier, 0); }
		public BasetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterBasetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitBasetype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitBasetype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasetypeContext basetype() throws RecognitionException {
		BasetypeContext _localctx = new BasetypeContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_basetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuntypeContext extends ParserRuleContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public TerminalNode Void() { return getToken(Mx_starParser.Void, 0); }
		public FuntypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterFuntype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitFuntype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitFuntype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuntypeContext funtype() throws RecognitionException {
		FuntypeContext _localctx = new FuntypeContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_funtype);
		try {
			setState(550);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				vartype();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode Integerliteral() { return getToken(Mx_starParser.Integerliteral, 0); }
		public TerminalNode Stringliteral() { return getToken(Mx_starParser.Stringliteral, 0); }
		public TerminalNode Booleanliteral() { return getToken(Mx_starParser.Booleanliteral, 0); }
		public TerminalNode Null() { return getToken(Mx_starParser.Null, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_starVisitor ) return ((Mx_starVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20:
			return variable_sempred((VariableContext)_localctx, predIndex);
		case 22:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean variable_sempred(VariableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		case 15:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u022d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\7"+
		"\2z\n\2\f\2\16\2}\13\2\3\3\3\3\3\3\3\3\3\3\5\3\u0084\n\3\3\4\3\4\3\4\3"+
		"\4\7\4\u008a\n\4\f\4\16\4\u008d\13\4\3\4\5\4\u0090\n\4\3\4\7\4\u0093\n"+
		"\4\f\4\16\4\u0096\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\5\6\u00a4\n\6\3\7\3\7\3\7\3\7\3\7\7\7\u00ab\n\7\f\7\16\7\u00ae\13\7\3"+
		"\b\3\b\3\b\5\b\u00b3\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\5\n\u00bd\n\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00c5\n\n\f\n\16\n\u00c8\13\n\3\n\5\n\u00cb"+
		"\n\n\3\13\3\13\7\13\u00cf\n\13\f\13\16\13\u00d2\13\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00e9\n\f\3\r\3\r\3\r\3\r\3\r\7\r\u00f0\n\r\f\r\16\r\u00f3\13\r\5"+
		"\r\u00f5\n\r\3\r\3\r\3\16\3\16\5\16\u00fb\n\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u010b\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u0116\n\21\3\21\3\21\5\21\u011a"+
		"\n\21\3\21\3\21\5\21\u011e\n\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u0126"+
		"\n\22\3\23\3\23\5\23\u012a\n\23\3\24\3\24\5\24\u012e\n\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u013c\n\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0146\n\26\f\26\16\26\u0149\13"+
		"\26\3\27\3\27\5\27\u014d\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u0159\n\30\3\30\3\30\5\30\u015d\n\30\3\30\3\30\3\30\3"+
		"\30\3\30\5\30\u0164\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30"+
		"\u016e\n\30\f\30\16\30\u0171\13\30\5\30\u0173\n\30\3\30\5\30\u0176\n\30"+
		"\5\30\u0178\n\30\3\30\3\30\3\30\3\30\5\30\u017e\n\30\3\30\3\30\3\30\3"+
		"\30\3\30\5\30\u0185\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u018c\n\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0195\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u019c\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\7\30\u01c7\n\30\f\30\16\30\u01ca\13\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3"+
		".\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\38\38\38\78\u020f\n8\f8\168\u0212\138\38\3"+
		"8\38\78\u0217\n8\f8\168\u021a\138\39\39\39\39\79\u0220\n9\f9\169\u0223"+
		"\139\3:\3:\3;\3;\5;\u0229\n;\3<\3<\3<\2\4*.=\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv\2\4"+
		"\4\2,.==\4\2%\'//\2\u023f\2{\3\2\2\2\4\u0083\3\2\2\2\6\u0085\3\2\2\2\b"+
		"\u0099\3\2\2\2\n\u00a3\3\2\2\2\f\u00a5\3\2\2\2\16\u00af\3\2\2\2\20\u00b4"+
		"\3\2\2\2\22\u00ca\3\2\2\2\24\u00cc\3\2\2\2\26\u00e8\3\2\2\2\30\u00ea\3"+
		"\2\2\2\32\u00fa\3\2\2\2\34\u010a\3\2\2\2\36\u010c\3\2\2\2 \u0112\3\2\2"+
		"\2\"\u0125\3\2\2\2$\u0129\3\2\2\2&\u012b\3\2\2\2(\u0131\3\2\2\2*\u013b"+
		"\3\2\2\2,\u014c\3\2\2\2.\u0177\3\2\2\2\60\u01cb\3\2\2\2\62\u01cd\3\2\2"+
		"\2\64\u01cf\3\2\2\2\66\u01d1\3\2\2\28\u01d3\3\2\2\2:\u01d5\3\2\2\2<\u01d7"+
		"\3\2\2\2>\u01d9\3\2\2\2@\u01db\3\2\2\2B\u01dd\3\2\2\2D\u01df\3\2\2\2F"+
		"\u01e1\3\2\2\2H\u01e3\3\2\2\2J\u01e5\3\2\2\2L\u01e7\3\2\2\2N\u01e9\3\2"+
		"\2\2P\u01eb\3\2\2\2R\u01ed\3\2\2\2T\u01ef\3\2\2\2V\u01f1\3\2\2\2X\u01f3"+
		"\3\2\2\2Z\u01f5\3\2\2\2\\\u01f7\3\2\2\2^\u01f9\3\2\2\2`\u01fb\3\2\2\2"+
		"b\u01fd\3\2\2\2d\u01ff\3\2\2\2f\u0201\3\2\2\2h\u0203\3\2\2\2j\u0205\3"+
		"\2\2\2l\u0207\3\2\2\2n\u0209\3\2\2\2p\u021b\3\2\2\2r\u0224\3\2\2\2t\u0228"+
		"\3\2\2\2v\u022a\3\2\2\2xz\5\4\3\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2"+
		"\2\2|\3\3\2\2\2}{\3\2\2\2~\u0084\5\6\4\2\177\u0080\5\f\7\2\u0080\u0081"+
		"\7\3\2\2\u0081\u0084\3\2\2\2\u0082\u0084\5\20\t\2\u0083~\3\2\2\2\u0083"+
		"\177\3\2\2\2\u0083\u0082\3\2\2\2\u0084\5\3\2\2\2\u0085\u0086\7;\2\2\u0086"+
		"\u0087\7=\2\2\u0087\u008b\7\4\2\2\u0088\u008a\5\n\6\2\u0089\u0088\3\2"+
		"\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0090\5\b\5\2\u008f\u008e\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0094\3\2\2\2\u0091\u0093\5\n\6\2\u0092"+
		"\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7\5\2\2\u0098"+
		"\7\3\2\2\2\u0099\u009a\7=\2\2\u009a\u009b\7\6\2\2\u009b\u009c\5\22\n\2"+
		"\u009c\u009d\7\7\2\2\u009d\u009e\5\24\13\2\u009e\t\3\2\2\2\u009f\u00a0"+
		"\5\f\7\2\u00a0\u00a1\7\3\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a4\5\20\t\2"+
		"\u00a3\u009f\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\13\3\2\2\2\u00a5\u00a6"+
		"\5p9\2\u00a6\u00a7\5\16\b\2\u00a7\u00ac\3\2\2\2\u00a8\u00a9\7\b\2\2\u00a9"+
		"\u00ab\5\16\b\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3"+
		"\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\r\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b2"+
		"\7=\2\2\u00b0\u00b1\7\t\2\2\u00b1\u00b3\5.\30\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\17\3\2\2\2\u00b4\u00b5\5t;\2\u00b5\u00b6\7=\2\2\u00b6"+
		"\u00b7\7\6\2\2\u00b7\u00b8\5\22\n\2\u00b8\u00b9\7\7\2\2\u00b9\u00ba\5"+
		"\24\13\2\u00ba\21\3\2\2\2\u00bb\u00bd\7\60\2\2\u00bc\u00bb\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00cb\3\2\2\2\u00be\u00bf\5p9\2\u00bf\u00c6\7=\2"+
		"\2\u00c0\u00c1\7\b\2\2\u00c1\u00c2\5p9\2\u00c2\u00c3\7=\2\2\u00c3\u00c5"+
		"\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00cb\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00bc\3\2\2\2\u00ca\u00be\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb"+
		"\23\3\2\2\2\u00cc\u00d0\7\4\2\2\u00cd\u00cf\5\26\f\2\u00ce\u00cd\3\2\2"+
		"\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3"+
		"\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\5\2\2\u00d4\25\3\2\2\2\u00d5"+
		"\u00d6\5\f\7\2\u00d6\u00d7\7\3\2\2\u00d7\u00e9\3\2\2\2\u00d8\u00d9\5("+
		"\25\2\u00d9\u00da\7\3\2\2\u00da\u00e9\3\2\2\2\u00db\u00dc\5.\30\2\u00dc"+
		"\u00dd\7\3\2\2\u00dd\u00e9\3\2\2\2\u00de\u00e9\5\24\13\2\u00df\u00e9\5"+
		"\34\17\2\u00e0\u00e9\5\36\20\2\u00e1\u00e9\5 \21\2\u00e2\u00e3\7\67\2"+
		"\2\u00e3\u00e9\7\3\2\2\u00e4\u00e5\78\2\2\u00e5\u00e9\7\3\2\2\u00e6\u00e9"+
		"\5&\24\2\u00e7\u00e9\7\3\2\2\u00e8\u00d5\3\2\2\2\u00e8\u00d8\3\2\2\2\u00e8"+
		"\u00db\3\2\2\2\u00e8\u00de\3\2\2\2\u00e8\u00df\3\2\2\2\u00e8\u00e0\3\2"+
		"\2\2\u00e8\u00e1\3\2\2\2\u00e8\u00e2\3\2\2\2\u00e8\u00e4\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\27\3\2\2\2\u00ea\u00eb\5*\26"+
		"\2\u00eb\u00f4\7\6\2\2\u00ec\u00f1\5.\30\2\u00ed\u00ee\7\b\2\2\u00ee\u00f0"+
		"\5.\30\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00ec\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\7\2\2\u00f7"+
		"\31\3\2\2\2\u00f8\u00fb\5\26\f\2\u00f9\u00fb\5\24\13\2\u00fa\u00f8\3\2"+
		"\2\2\u00fa\u00f9\3\2\2\2\u00fb\33\3\2\2\2\u00fc\u00fd\7\63\2\2\u00fd\u00fe"+
		"\7\6\2\2\u00fe\u00ff\5.\30\2\u00ff\u0100\7\7\2\2\u0100\u0101\5\32\16\2"+
		"\u0101\u010b\3\2\2\2\u0102\u0103\7\63\2\2\u0103\u0104\7\6\2\2\u0104\u0105"+
		"\5.\30\2\u0105\u0106\7\7\2\2\u0106\u0107\5\32\16\2\u0107\u0108\7\64\2"+
		"\2\u0108\u0109\5\32\16\2\u0109\u010b\3\2\2\2\u010a\u00fc\3\2\2\2\u010a"+
		"\u0102\3\2\2\2\u010b\35\3\2\2\2\u010c\u010d\7\66\2\2\u010d\u010e\7\6\2"+
		"\2\u010e\u010f\5.\30\2\u010f\u0110\7\7\2\2\u0110\u0111\5\32\16\2\u0111"+
		"\37\3\2\2\2\u0112\u0113\7\65\2\2\u0113\u0115\7\6\2\2\u0114\u0116\5\"\22"+
		"\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119"+
		"\7\3\2\2\u0118\u011a\5.\30\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u011d\7\3\2\2\u011c\u011e\5$\23\2\u011d\u011c\3\2"+
		"\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\7\7\2\2\u0120"+
		"\u0121\5\32\16\2\u0121!\3\2\2\2\u0122\u0126\5\f\7\2\u0123\u0126\5.\30"+
		"\2\u0124\u0126\5(\25\2\u0125\u0122\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0124"+
		"\3\2\2\2\u0126#\3\2\2\2\u0127\u012a\5(\25\2\u0128\u012a\5.\30\2\u0129"+
		"\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a%\3\2\2\2\u012b\u012d\79\2\2\u012c"+
		"\u012e\5.\30\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2"+
		"\2\2\u012f\u0130\7\3\2\2\u0130\'\3\2\2\2\u0131\u0132\5*\26\2\u0132\u0133"+
		"\7\t\2\2\u0133\u0134\5.\30\2\u0134)\3\2\2\2\u0135\u0136\b\26\1\2\u0136"+
		"\u013c\7=\2\2\u0137\u0138\7\6\2\2\u0138\u0139\5*\26\2\u0139\u013a\7\7"+
		"\2\2\u013a\u013c\3\2\2\2\u013b\u0135\3\2\2\2\u013b\u0137\3\2\2\2\u013c"+
		"\u0147\3\2\2\2\u013d\u013e\f\4\2\2\u013e\u013f\7\n\2\2\u013f\u0146\7="+
		"\2\2\u0140\u0141\f\3\2\2\u0141\u0142\7\13\2\2\u0142\u0143\5.\30\2\u0143"+
		"\u0144\7\f\2\2\u0144\u0146\3\2\2\2\u0145\u013d\3\2\2\2\u0145\u0140\3\2"+
		"\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"+\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014d\5*\26\2\u014b\u014d\5v<\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014b\3\2\2\2\u014d-\3\2\2\2\u014e\u014f\b\30\1\2"+
		"\u014f\u0178\5,\27\2\u0150\u0178\5\30\r\2\u0151\u0152\5\60\31\2\u0152"+
		"\u0153\5.\30\2\u0153\u0154\5\62\32\2\u0154\u0178\3\2\2\2\u0155\u0158\5"+
		"*\26\2\u0156\u0159\5:\36\2\u0157\u0159\5<\37\2\u0158\u0156\3\2\2\2\u0158"+
		"\u0157\3\2\2\2\u0159\u0178\3\2\2\2\u015a\u015d\5> \2\u015b\u015d\5@!\2"+
		"\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f"+
		"\5*\26\2\u015f\u0178\3\2\2\2\u0160\u0164\5B\"\2\u0161\u0164\5D#\2\u0162"+
		"\u0164\5F$\2\u0163\u0160\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0162\3\2\2"+
		"\2\u0164\u0165\3\2\2\2\u0165\u0166\5.\30\17\u0166\u0178\3\2\2\2\u0167"+
		"\u0168\7:\2\2\u0168\u0175\5n8\2\u0169\u0172\7\6\2\2\u016a\u016f\5.\30"+
		"\2\u016b\u016c\7\b\2\2\u016c\u016e\5.\30\2\u016d\u016b\3\2\2\2\u016e\u0171"+
		"\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0173\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0172\u016a\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\3\2"+
		"\2\2\u0174\u0176\7\7\2\2\u0175\u0169\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"\u0178\3\2\2\2\u0177\u014e\3\2\2\2\u0177\u0150\3\2\2\2\u0177\u0151\3\2"+
		"\2\2\u0177\u0155\3\2\2\2\u0177\u015c\3\2\2\2\u0177\u0163\3\2\2\2\u0177"+
		"\u0167\3\2\2\2\u0178\u01c8\3\2\2\2\u0179\u017d\f\r\2\2\u017a\u017e\5H"+
		"%\2\u017b\u017e\5J&\2\u017c\u017e\5L\'\2\u017d\u017a\3\2\2\2\u017d\u017b"+
		"\3\2\2\2\u017d\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\5.\30\16"+
		"\u0180\u01c7\3\2\2\2\u0181\u0184\f\f\2\2\u0182\u0185\5N(\2\u0183\u0185"+
		"\5P)\2\u0184\u0182\3\2\2\2\u0184\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186"+
		"\u0187\5.\30\r\u0187\u01c7\3\2\2\2\u0188\u018b\f\13\2\2\u0189\u018c\5"+
		"R*\2\u018a\u018c\5T+\2\u018b\u0189\3\2\2\2\u018b\u018a\3\2\2\2\u018c\u018d"+
		"\3\2\2\2\u018d\u018e\5.\30\f\u018e\u01c7\3\2\2\2\u018f\u0194\f\n\2\2\u0190"+
		"\u0195\5X-\2\u0191\u0195\5\\/\2\u0192\u0195\5V,\2\u0193\u0195\5Z.\2\u0194"+
		"\u0190\3\2\2\2\u0194\u0191\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0193\3\2"+
		"\2\2\u0195\u0196\3\2\2\2\u0196\u0197\5.\30\13\u0197\u01c7\3\2\2\2\u0198"+
		"\u019b\f\t\2\2\u0199\u019c\5^\60\2\u019a\u019c\5`\61\2\u019b\u0199\3\2"+
		"\2\2\u019b\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\5.\30\n\u019e"+
		"\u01c7\3\2\2\2\u019f\u01a0\f\b\2\2\u01a0\u01a1\5b\62\2\u01a1\u01a2\5."+
		"\30\t\u01a2\u01c7\3\2\2\2\u01a3\u01a4\f\7\2\2\u01a4\u01a5\5d\63\2\u01a5"+
		"\u01a6\5.\30\b\u01a6\u01c7\3\2\2\2\u01a7\u01a8\f\6\2\2\u01a8\u01a9\5f"+
		"\64\2\u01a9\u01aa\5.\30\7\u01aa\u01c7\3\2\2\2\u01ab\u01ac\f\5\2\2\u01ac"+
		"\u01ad\5h\65\2\u01ad\u01ae\5.\30\6\u01ae\u01c7\3\2\2\2\u01af\u01b0\f\4"+
		"\2\2\u01b0\u01b1\5j\66\2\u01b1\u01b2\5.\30\5\u01b2\u01c7\3\2\2\2\u01b3"+
		"\u01b4\f\3\2\2\u01b4\u01b5\5l\67\2\u01b5\u01b6\5.\30\2\u01b6\u01b7\7\r"+
		"\2\2\u01b7\u01b8\5.\30\4\u01b8\u01c7\3\2\2\2\u01b9\u01ba\f\24\2\2\u01ba"+
		"\u01bb\5\64\33\2\u01bb\u01bc\5\30\r\2\u01bc\u01c7\3\2\2\2\u01bd\u01be"+
		"\f\23\2\2\u01be\u01bf\5\64\33\2\u01bf\u01c0\7=\2\2\u01c0\u01c7\3\2\2\2"+
		"\u01c1\u01c2\f\22\2\2\u01c2\u01c3\5\66\34\2\u01c3\u01c4\5.\30\2\u01c4"+
		"\u01c5\58\35\2\u01c5\u01c7\3\2\2\2\u01c6\u0179\3\2\2\2\u01c6\u0181\3\2"+
		"\2\2\u01c6\u0188\3\2\2\2\u01c6\u018f\3\2\2\2\u01c6\u0198\3\2\2\2\u01c6"+
		"\u019f\3\2\2\2\u01c6\u01a3\3\2\2\2\u01c6\u01a7\3\2\2\2\u01c6\u01ab\3\2"+
		"\2\2\u01c6\u01af\3\2\2\2\u01c6\u01b3\3\2\2\2\u01c6\u01b9\3\2\2\2\u01c6"+
		"\u01bd\3\2\2\2\u01c6\u01c1\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2"+
		"\2\2\u01c8\u01c9\3\2\2\2\u01c9/\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cc"+
		"\7\6\2\2\u01cc\61\3\2\2\2\u01cd\u01ce\7\7\2\2\u01ce\63\3\2\2\2\u01cf\u01d0"+
		"\7\n\2\2\u01d0\65\3\2\2\2\u01d1\u01d2\7\13\2\2\u01d2\67\3\2\2\2\u01d3"+
		"\u01d4\7\f\2\2\u01d49\3\2\2\2\u01d5\u01d6\7\16\2\2\u01d6;\3\2\2\2\u01d7"+
		"\u01d8\7\17\2\2\u01d8=\3\2\2\2\u01d9\u01da\7\16\2\2\u01da?\3\2\2\2\u01db"+
		"\u01dc\7\17\2\2\u01dcA\3\2\2\2\u01dd\u01de\7\20\2\2\u01deC\3\2\2\2\u01df"+
		"\u01e0\7\21\2\2\u01e0E\3\2\2\2\u01e1\u01e2\7\22\2\2\u01e2G\3\2\2\2\u01e3"+
		"\u01e4\7\23\2\2\u01e4I\3\2\2\2\u01e5\u01e6\7\24\2\2\u01e6K\3\2\2\2\u01e7"+
		"\u01e8\7\25\2\2\u01e8M\3\2\2\2\u01e9\u01ea\7\26\2\2\u01eaO\3\2\2\2\u01eb"+
		"\u01ec\7\20\2\2\u01ecQ\3\2\2\2\u01ed\u01ee\7\27\2\2\u01eeS\3\2\2\2\u01ef"+
		"\u01f0\7\30\2\2\u01f0U\3\2\2\2\u01f1\u01f2\7\31\2\2\u01f2W\3\2\2\2\u01f3"+
		"\u01f4\7\32\2\2\u01f4Y\3\2\2\2\u01f5\u01f6\7\33\2\2\u01f6[\3\2\2\2\u01f7"+
		"\u01f8\7\34\2\2\u01f8]\3\2\2\2\u01f9\u01fa\7\35\2\2\u01fa_\3\2\2\2\u01fb"+
		"\u01fc\7\36\2\2\u01fca\3\2\2\2\u01fd\u01fe\7\37\2\2\u01fec\3\2\2\2\u01ff"+
		"\u0200\7 \2\2\u0200e\3\2\2\2\u0201\u0202\7!\2\2\u0202g\3\2\2\2\u0203\u0204"+
		"\7\"\2\2\u0204i\3\2\2\2\u0205\u0206\7#\2\2\u0206k\3\2\2\2\u0207\u0208"+
		"\7$\2\2\u0208m\3\2\2\2\u0209\u0210\5r:\2\u020a\u020b\5\66\34\2\u020b\u020c"+
		"\7\'\2\2\u020c\u020d\58\35\2\u020d\u020f\3\2\2\2\u020e\u020a\3\2\2\2\u020f"+
		"\u0212\3\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0218\3\2"+
		"\2\2\u0212\u0210\3\2\2\2\u0213\u0214\5\66\34\2\u0214\u0215\58\35\2\u0215"+
		"\u0217\3\2\2\2\u0216\u0213\3\2\2\2\u0217\u021a\3\2\2\2\u0218\u0216\3\2"+
		"\2\2\u0218\u0219\3\2\2\2\u0219o\3\2\2\2\u021a\u0218\3\2\2\2\u021b\u0221"+
		"\5r:\2\u021c\u021d\5\66\34\2\u021d\u021e\58\35\2\u021e\u0220\3\2\2\2\u021f"+
		"\u021c\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2"+
		"\2\2\u0222q\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u0225\t\2\2\2\u0225s\3\2"+
		"\2\2\u0226\u0229\5p9\2\u0227\u0229\7\60\2\2\u0228\u0226\3\2\2\2\u0228"+
		"\u0227\3\2\2\2\u0229u\3\2\2\2\u022a\u022b\t\3\2\2\u022bw\3\2\2\2/{\u0083"+
		"\u008b\u008f\u0094\u00a3\u00ac\u00b2\u00bc\u00c6\u00ca\u00d0\u00e8\u00f1"+
		"\u00f4\u00fa\u010a\u0115\u0119\u011d\u0125\u0129\u012d\u013b\u0145\u0147"+
		"\u014c\u0158\u015c\u0163\u016f\u0172\u0175\u0177\u017d\u0184\u018b\u0194"+
		"\u019b\u01c6\u01c8\u0210\u0218\u0221\u0228";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}