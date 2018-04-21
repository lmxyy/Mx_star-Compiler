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
		null, "'{'", "'}'", "'('", "')'", "';'", "','", "'='", "'.'", "'['", "']'", 
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
			setState(127);
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
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
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
			setState(129);
			match(Class);
			setState(130);
			match(Identifier);
			setState(131);
			match(T__0);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(132);
					classmem();
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(138);
				constructor();
				}
				break;
			}
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(141);
				classmem();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
			match(T__1);
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
			setState(149);
			match(Identifier);
			setState(150);
			match(T__2);
			setState(151);
			params();
			setState(152);
			match(T__3);
			setState(153);
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
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				defvar();
				setState(156);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
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
			setState(161);
			vartype();
			setState(162);
			defvarassignment();
			}
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(164);
				match(T__5);
				setState(165);
				defvarassignment();
				}
				}
				setState(170);
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
			setState(171);
			match(Identifier);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(172);
				match(T__6);
				setState(173);
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
			setState(176);
			funtype();
			setState(177);
			match(Identifier);
			setState(178);
			match(T__2);
			setState(179);
			params();
			setState(180);
			match(T__3);
			setState(181);
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
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Void) {
					{
					setState(183);
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
				setState(186);
				vartype();
				setState(187);
				match(Identifier);
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(188);
					match(T__5);
					setState(189);
					vartype();
					setState(190);
					match(Identifier);
					}
					}
					setState(196);
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
			setState(200);
			match(T__0);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				{
				setState(201);
				stmt();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
			match(T__1);
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
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				defvar();
				setState(210);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				assignment();
				setState(213);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				expression(0);
				setState(216);
				match(T__4);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				block();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(219);
				if_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
				while_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(221);
				for_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(222);
				match(Break);
				setState(223);
				match(T__4);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(224);
				match(Continue);
				setState(225);
				match(T__4);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(226);
				return_stmt();
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(227);
				match(T__4);
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
			setState(230);
			variable(0);
			setState(231);
			match(T__2);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(232);
				expression(0);
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(233);
					match(T__5);
					setState(234);
					expression(0);
					}
					}
					setState(239);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(242);
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
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
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
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(If);
				setState(249);
				match(T__2);
				setState(250);
				expression(0);
				setState(251);
				match(T__3);
				setState(252);
				stmtorblock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(If);
				setState(255);
				match(T__2);
				setState(256);
				expression(0);
				setState(257);
				match(T__3);
				setState(258);
				stmtorblock();
				setState(259);
				match(Else);
				setState(260);
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
			setState(264);
			match(While);
			setState(265);
			match(T__2);
			setState(266);
			expression(0);
			setState(267);
			match(T__3);
			setState(268);
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
			setState(270);
			match(For);
			setState(271);
			match(T__2);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(272);
				forinit();
				}
			}

			setState(275);
			match(T__4);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(276);
				expression(0);
				}
			}

			setState(279);
			match(T__4);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(280);
				forstep();
				}
			}

			setState(283);
			match(T__3);
			setState(284);
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
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				defvar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
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
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
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
			setState(295);
			match(Return);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(296);
				expression(0);
				}
			}

			setState(299);
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
			setState(301);
			variable(0);
			setState(302);
			match(T__6);
			setState(303);
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
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(306);
				match(Identifier);
				}
				break;
			case T__2:
				{
				setState(307);
				match(T__2);
				setState(308);
				variable(0);
				setState(309);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(321);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new VariableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable);
						setState(313);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(314);
						match(T__7);
						setState(315);
						match(Identifier);
						}
						break;
					case 2:
						{
						_localctx = new VariableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable);
						setState(316);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(317);
						match(T__8);
						setState(318);
						expression(0);
						setState(319);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(325);
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
			setState(328);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				variable(0);
				}
				break;
			case Booleanliteral:
			case Stringliteral:
			case Integerliteral:
			case Null:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
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
			setState(371);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(331);
				term();
				}
				break;
			case 2:
				{
				setState(332);
				callfun();
				}
				break;
			case 3:
				{
				setState(333);
				lefpar();
				setState(334);
				expression(0);
				setState(335);
				rigpar();
				}
				break;
			case 4:
				{
				setState(337);
				variable(0);
				setState(340);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(338);
					sinc();
					}
					break;
				case T__12:
					{
					setState(339);
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
				setState(344);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(342);
					pinc();
					}
					break;
				case T__12:
					{
					setState(343);
					pdec();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(346);
				variable(0);
				}
				break;
			case 6:
				{
				setState(351);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(348);
					neg();
					}
					break;
				case T__14:
					{
					setState(349);
					not();
					}
					break;
				case T__15:
					{
					setState(350);
					comp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(353);
				expression(13);
				}
				break;
			case 7:
				{
				setState(355);
				match(New);
				setState(356);
				vartype_plus();
				setState(369);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(357);
					match(T__2);
					setState(366);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
						{
						setState(358);
						expression(0);
						setState(363);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__5) {
							{
							{
							setState(359);
							match(T__5);
							setState(360);
							expression(0);
							}
							}
							setState(365);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(368);
					match(T__3);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(452);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(450);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(373);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(377);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__16:
							{
							setState(374);
							times();
							}
							break;
						case T__17:
							{
							setState(375);
							divide();
							}
							break;
						case T__18:
							{
							setState(376);
							mod();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(379);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(381);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(384);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__19:
							{
							setState(382);
							add();
							}
							break;
						case T__13:
							{
							setState(383);
							sub();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(386);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(388);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(391);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__20:
							{
							setState(389);
							lesh();
							}
							break;
						case T__21:
							{
							setState(390);
							rish();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(393);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(395);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(400);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__23:
							{
							setState(396);
							grtr();
							}
							break;
						case T__25:
							{
							setState(397);
							geq();
							}
							break;
						case T__22:
							{
							setState(398);
							less();
							}
							break;
						case T__24:
							{
							setState(399);
							leq();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(402);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(404);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(407);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__26:
							{
							setState(405);
							equ();
							}
							break;
						case T__27:
							{
							setState(406);
							neq();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(409);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(411);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(412);
						band();
						setState(413);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(415);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(416);
						xor();
						setState(417);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(419);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(420);
						bor();
						setState(421);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(423);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(424);
						and();
						setState(425);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(427);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(428);
						or();
						setState(429);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(431);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(432);
						que();
						setState(433);
						expression(0);
						setState(434);
						match(T__10);
						setState(435);
						expression(2);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(437);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(438);
						mem();
						setState(439);
						callfun();
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(441);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(442);
						mem();
						setState(443);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(445);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(446);
						lefbra();
						setState(447);
						expression(0);
						setState(448);
						rigbra();
						}
						break;
					}
					} 
				}
				setState(454);
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
			setState(455);
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
			setState(459);
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
			setState(461);
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
			setState(463);
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
			setState(465);
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
			setState(467);
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
			setState(469);
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
			setState(471);
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
			setState(473);
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
			setState(475);
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
			setState(477);
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
			setState(479);
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
			setState(481);
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
			setState(483);
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
			setState(485);
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
			setState(487);
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
			setState(489);
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
			setState(491);
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
			setState(493);
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
			setState(495);
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
			setState(497);
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
			setState(499);
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
			setState(501);
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
			setState(503);
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
			setState(505);
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
			setState(507);
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
			setState(509);
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
			setState(511);
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
			setState(513);
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
			setState(515);
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
			setState(517);
			basetype();
			setState(524);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(518);
					lefbra();
					setState(519);
					match(Integerliteral);
					setState(520);
					rigbra();
					}
					} 
				}
				setState(526);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			setState(532);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(527);
					lefbra();
					setState(528);
					rigbra();
					}
					} 
				}
				setState(534);
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
			setState(535);
			basetype();
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(536);
				lefbra();
				setState(537);
				rigbra();
				}
				}
				setState(543);
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
			setState(544);
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
			setState(548);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				vartype();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(547);
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
			setState(550);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u022b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\7"+
		"\2z\n\2\f\2\16\2}\13\2\3\3\3\3\3\3\5\3\u0082\n\3\3\4\3\4\3\4\3\4\7\4\u0088"+
		"\n\4\f\4\16\4\u008b\13\4\3\4\5\4\u008e\n\4\3\4\7\4\u0091\n\4\f\4\16\4"+
		"\u0094\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6\u00a2"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\7\7\u00a9\n\7\f\7\16\7\u00ac\13\7\3\b\3\b\3\b"+
		"\5\b\u00b1\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\5\n\u00bb\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u00c3\n\n\f\n\16\n\u00c6\13\n\3\n\5\n\u00c9\n\n\3\13"+
		"\3\13\7\13\u00cd\n\13\f\13\16\13\u00d0\13\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e7"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\7\r\u00ee\n\r\f\r\16\r\u00f1\13\r\5\r\u00f3\n"+
		"\r\3\r\3\r\3\16\3\16\5\16\u00f9\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0109\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\5\21\u0114\n\21\3\21\3\21\5\21\u0118\n\21\3"+
		"\21\3\21\5\21\u011c\n\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u0124\n\22"+
		"\3\23\3\23\5\23\u0128\n\23\3\24\3\24\5\24\u012c\n\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u013a\n\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0144\n\26\f\26\16\26\u0147\13\26"+
		"\3\27\3\27\5\27\u014b\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u0157\n\30\3\30\3\30\5\30\u015b\n\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u0162\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u016c"+
		"\n\30\f\30\16\30\u016f\13\30\5\30\u0171\n\30\3\30\5\30\u0174\n\30\5\30"+
		"\u0176\n\30\3\30\3\30\3\30\3\30\5\30\u017c\n\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u0183\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u018a\n\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\5\30\u0193\n\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u019a\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\7\30\u01c5\n\30\f\30\16\30\u01c8\13\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3."+
		"\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\3\66\3\67\3\67\38\38\38\38\38\78\u020d\n8\f8\168\u0210\138\38\38\38\7"+
		"8\u0215\n8\f8\168\u0218\138\39\39\39\39\79\u021e\n9\f9\169\u0221\139\3"+
		":\3:\3;\3;\5;\u0227\n;\3<\3<\3<\2\4*.=\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv\2\4\4\2,"+
		".==\4\2%\'//\2\u023d\2{\3\2\2\2\4\u0081\3\2\2\2\6\u0083\3\2\2\2\b\u0097"+
		"\3\2\2\2\n\u00a1\3\2\2\2\f\u00a3\3\2\2\2\16\u00ad\3\2\2\2\20\u00b2\3\2"+
		"\2\2\22\u00c8\3\2\2\2\24\u00ca\3\2\2\2\26\u00e6\3\2\2\2\30\u00e8\3\2\2"+
		"\2\32\u00f8\3\2\2\2\34\u0108\3\2\2\2\36\u010a\3\2\2\2 \u0110\3\2\2\2\""+
		"\u0123\3\2\2\2$\u0127\3\2\2\2&\u0129\3\2\2\2(\u012f\3\2\2\2*\u0139\3\2"+
		"\2\2,\u014a\3\2\2\2.\u0175\3\2\2\2\60\u01c9\3\2\2\2\62\u01cb\3\2\2\2\64"+
		"\u01cd\3\2\2\2\66\u01cf\3\2\2\28\u01d1\3\2\2\2:\u01d3\3\2\2\2<\u01d5\3"+
		"\2\2\2>\u01d7\3\2\2\2@\u01d9\3\2\2\2B\u01db\3\2\2\2D\u01dd\3\2\2\2F\u01df"+
		"\3\2\2\2H\u01e1\3\2\2\2J\u01e3\3\2\2\2L\u01e5\3\2\2\2N\u01e7\3\2\2\2P"+
		"\u01e9\3\2\2\2R\u01eb\3\2\2\2T\u01ed\3\2\2\2V\u01ef\3\2\2\2X\u01f1\3\2"+
		"\2\2Z\u01f3\3\2\2\2\\\u01f5\3\2\2\2^\u01f7\3\2\2\2`\u01f9\3\2\2\2b\u01fb"+
		"\3\2\2\2d\u01fd\3\2\2\2f\u01ff\3\2\2\2h\u0201\3\2\2\2j\u0203\3\2\2\2l"+
		"\u0205\3\2\2\2n\u0207\3\2\2\2p\u0219\3\2\2\2r\u0222\3\2\2\2t\u0226\3\2"+
		"\2\2v\u0228\3\2\2\2xz\5\4\3\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2"+
		"|\3\3\2\2\2}{\3\2\2\2~\u0082\5\6\4\2\177\u0082\5\f\7\2\u0080\u0082\5\20"+
		"\t\2\u0081~\3\2\2\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\5\3\2"+
		"\2\2\u0083\u0084\7;\2\2\u0084\u0085\7=\2\2\u0085\u0089\7\3\2\2\u0086\u0088"+
		"\5\n\6\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\5\b"+
		"\5\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0092\3\2\2\2\u008f"+
		"\u0091\5\n\6\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095"+
		"\u0096\7\4\2\2\u0096\7\3\2\2\2\u0097\u0098\7=\2\2\u0098\u0099\7\5\2\2"+
		"\u0099\u009a\5\22\n\2\u009a\u009b\7\6\2\2\u009b\u009c\5\24\13\2\u009c"+
		"\t\3\2\2\2\u009d\u009e\5\f\7\2\u009e\u009f\7\7\2\2\u009f\u00a2\3\2\2\2"+
		"\u00a0\u00a2\5\20\t\2\u00a1\u009d\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\13"+
		"\3\2\2\2\u00a3\u00a4\5p9\2\u00a4\u00a5\5\16\b\2\u00a5\u00aa\3\2\2\2\u00a6"+
		"\u00a7\7\b\2\2\u00a7\u00a9\5\16\b\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3"+
		"\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\r\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ad\u00b0\7=\2\2\u00ae\u00af\7\t\2\2\u00af\u00b1\5.\30\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\17\3\2\2\2\u00b2\u00b3\5t;\2"+
		"\u00b3\u00b4\7=\2\2\u00b4\u00b5\7\5\2\2\u00b5\u00b6\5\22\n\2\u00b6\u00b7"+
		"\7\6\2\2\u00b7\u00b8\5\24\13\2\u00b8\21\3\2\2\2\u00b9\u00bb\7\60\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00c9\3\2\2\2\u00bc\u00bd\5p"+
		"9\2\u00bd\u00c4\7=\2\2\u00be\u00bf\7\b\2\2\u00bf\u00c0\5p9\2\u00c0\u00c1"+
		"\7=\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00be\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c9\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00ba\3\2\2\2\u00c8\u00bc\3\2\2\2\u00c8"+
		"\u00c7\3\2\2\2\u00c9\23\3\2\2\2\u00ca\u00ce\7\3\2\2\u00cb\u00cd\5\26\f"+
		"\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7\4\2\2\u00d2"+
		"\25\3\2\2\2\u00d3\u00d4\5\f\7\2\u00d4\u00d5\7\7\2\2\u00d5\u00e7\3\2\2"+
		"\2\u00d6\u00d7\5(\25\2\u00d7\u00d8\7\7\2\2\u00d8\u00e7\3\2\2\2\u00d9\u00da"+
		"\5.\30\2\u00da\u00db\7\7\2\2\u00db\u00e7\3\2\2\2\u00dc\u00e7\5\24\13\2"+
		"\u00dd\u00e7\5\34\17\2\u00de\u00e7\5\36\20\2\u00df\u00e7\5 \21\2\u00e0"+
		"\u00e1\7\67\2\2\u00e1\u00e7\7\7\2\2\u00e2\u00e3\78\2\2\u00e3\u00e7\7\7"+
		"\2\2\u00e4\u00e7\5&\24\2\u00e5\u00e7\7\7\2\2\u00e6\u00d3\3\2\2\2\u00e6"+
		"\u00d6\3\2\2\2\u00e6\u00d9\3\2\2\2\u00e6\u00dc\3\2\2\2\u00e6\u00dd\3\2"+
		"\2\2\u00e6\u00de\3\2\2\2\u00e6\u00df\3\2\2\2\u00e6\u00e0\3\2\2\2\u00e6"+
		"\u00e2\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\27\3\2\2"+
		"\2\u00e8\u00e9\5*\26\2\u00e9\u00f2\7\5\2\2\u00ea\u00ef\5.\30\2\u00eb\u00ec"+
		"\7\b\2\2\u00ec\u00ee\5.\30\2\u00ed\u00eb\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f2\u00ea\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\7\6\2\2\u00f5\31\3\2\2\2\u00f6\u00f9\5\26\f\2\u00f7\u00f9\5\24"+
		"\13\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\33\3\2\2\2\u00fa\u00fb"+
		"\7\63\2\2\u00fb\u00fc\7\5\2\2\u00fc\u00fd\5.\30\2\u00fd\u00fe\7\6\2\2"+
		"\u00fe\u00ff\5\32\16\2\u00ff\u0109\3\2\2\2\u0100\u0101\7\63\2\2\u0101"+
		"\u0102\7\5\2\2\u0102\u0103\5.\30\2\u0103\u0104\7\6\2\2\u0104\u0105\5\32"+
		"\16\2\u0105\u0106\7\64\2\2\u0106\u0107\5\32\16\2\u0107\u0109\3\2\2\2\u0108"+
		"\u00fa\3\2\2\2\u0108\u0100\3\2\2\2\u0109\35\3\2\2\2\u010a\u010b\7\66\2"+
		"\2\u010b\u010c\7\5\2\2\u010c\u010d\5.\30\2\u010d\u010e\7\6\2\2\u010e\u010f"+
		"\5\32\16\2\u010f\37\3\2\2\2\u0110\u0111\7\65\2\2\u0111\u0113\7\5\2\2\u0112"+
		"\u0114\5\"\22\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3"+
		"\2\2\2\u0115\u0117\7\7\2\2\u0116\u0118\5.\30\2\u0117\u0116\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\7\7\2\2\u011a\u011c\5$"+
		"\23\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011e\7\6\2\2\u011e\u011f\5\32\16\2\u011f!\3\2\2\2\u0120\u0124\5\f\7"+
		"\2\u0121\u0124\5.\30\2\u0122\u0124\5(\25\2\u0123\u0120\3\2\2\2\u0123\u0121"+
		"\3\2\2\2\u0123\u0122\3\2\2\2\u0124#\3\2\2\2\u0125\u0128\5(\25\2\u0126"+
		"\u0128\5.\30\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128%\3\2\2\2"+
		"\u0129\u012b\79\2\2\u012a\u012c\5.\30\2\u012b\u012a\3\2\2\2\u012b\u012c"+
		"\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\7\7\2\2\u012e\'\3\2\2\2\u012f"+
		"\u0130\5*\26\2\u0130\u0131\7\t\2\2\u0131\u0132\5.\30\2\u0132)\3\2\2\2"+
		"\u0133\u0134\b\26\1\2\u0134\u013a\7=\2\2\u0135\u0136\7\5\2\2\u0136\u0137"+
		"\5*\26\2\u0137\u0138\7\6\2\2\u0138\u013a\3\2\2\2\u0139\u0133\3\2\2\2\u0139"+
		"\u0135\3\2\2\2\u013a\u0145\3\2\2\2\u013b\u013c\f\4\2\2\u013c\u013d\7\n"+
		"\2\2\u013d\u0144\7=\2\2\u013e\u013f\f\3\2\2\u013f\u0140\7\13\2\2\u0140"+
		"\u0141\5.\30\2\u0141\u0142\7\f\2\2\u0142\u0144\3\2\2\2\u0143\u013b\3\2"+
		"\2\2\u0143\u013e\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146+\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014b\5*\26\2"+
		"\u0149\u014b\5v<\2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b-\3\2"+
		"\2\2\u014c\u014d\b\30\1\2\u014d\u0176\5,\27\2\u014e\u0176\5\30\r\2\u014f"+
		"\u0150\5\60\31\2\u0150\u0151\5.\30\2\u0151\u0152\5\62\32\2\u0152\u0176"+
		"\3\2\2\2\u0153\u0156\5*\26\2\u0154\u0157\5:\36\2\u0155\u0157\5<\37\2\u0156"+
		"\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157\u0176\3\2\2\2\u0158\u015b\5>"+
		" \2\u0159\u015b\5@!\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2\2\2\u015b\u015c"+
		"\3\2\2\2\u015c\u015d\5*\26\2\u015d\u0176\3\2\2\2\u015e\u0162\5B\"\2\u015f"+
		"\u0162\5D#\2\u0160\u0162\5F$\2\u0161\u015e\3\2\2\2\u0161\u015f\3\2\2\2"+
		"\u0161\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\5.\30\17\u0164\u0176"+
		"\3\2\2\2\u0165\u0166\7:\2\2\u0166\u0173\5n8\2\u0167\u0170\7\5\2\2\u0168"+
		"\u016d\5.\30\2\u0169\u016a\7\b\2\2\u016a\u016c\5.\30\2\u016b\u0169\3\2"+
		"\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0168\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0172\3\2\2\2\u0172\u0174\7\6\2\2\u0173\u0167\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174\u0176\3\2\2\2\u0175\u014c\3\2\2\2\u0175\u014e\3\2"+
		"\2\2\u0175\u014f\3\2\2\2\u0175\u0153\3\2\2\2\u0175\u015a\3\2\2\2\u0175"+
		"\u0161\3\2\2\2\u0175\u0165\3\2\2\2\u0176\u01c6\3\2\2\2\u0177\u017b\f\r"+
		"\2\2\u0178\u017c\5H%\2\u0179\u017c\5J&\2\u017a\u017c\5L\'\2\u017b\u0178"+
		"\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\u017e\5.\30\16\u017e\u01c5\3\2\2\2\u017f\u0182\f\f\2\2\u0180\u0183\5"+
		"N(\2\u0181\u0183\5P)\2\u0182\u0180\3\2\2\2\u0182\u0181\3\2\2\2\u0183\u0184"+
		"\3\2\2\2\u0184\u0185\5.\30\r\u0185\u01c5\3\2\2\2\u0186\u0189\f\13\2\2"+
		"\u0187\u018a\5R*\2\u0188\u018a\5T+\2\u0189\u0187\3\2\2\2\u0189\u0188\3"+
		"\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\5.\30\f\u018c\u01c5\3\2\2\2\u018d"+
		"\u0192\f\n\2\2\u018e\u0193\5X-\2\u018f\u0193\5\\/\2\u0190\u0193\5V,\2"+
		"\u0191\u0193\5Z.\2\u0192\u018e\3\2\2\2\u0192\u018f\3\2\2\2\u0192\u0190"+
		"\3\2\2\2\u0192\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\5.\30\13"+
		"\u0195\u01c5\3\2\2\2\u0196\u0199\f\t\2\2\u0197\u019a\5^\60\2\u0198\u019a"+
		"\5`\61\2\u0199\u0197\3\2\2\2\u0199\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u019c\5.\30\n\u019c\u01c5\3\2\2\2\u019d\u019e\f\b\2\2\u019e\u019f\5b"+
		"\62\2\u019f\u01a0\5.\30\t\u01a0\u01c5\3\2\2\2\u01a1\u01a2\f\7\2\2\u01a2"+
		"\u01a3\5d\63\2\u01a3\u01a4\5.\30\b\u01a4\u01c5\3\2\2\2\u01a5\u01a6\f\6"+
		"\2\2\u01a6\u01a7\5f\64\2\u01a7\u01a8\5.\30\7\u01a8\u01c5\3\2\2\2\u01a9"+
		"\u01aa\f\5\2\2\u01aa\u01ab\5h\65\2\u01ab\u01ac\5.\30\6\u01ac\u01c5\3\2"+
		"\2\2\u01ad\u01ae\f\4\2\2\u01ae\u01af\5j\66\2\u01af\u01b0\5.\30\5\u01b0"+
		"\u01c5\3\2\2\2\u01b1\u01b2\f\3\2\2\u01b2\u01b3\5l\67\2\u01b3\u01b4\5."+
		"\30\2\u01b4\u01b5\7\r\2\2\u01b5\u01b6\5.\30\4\u01b6\u01c5\3\2\2\2\u01b7"+
		"\u01b8\f\24\2\2\u01b8\u01b9\5\64\33\2\u01b9\u01ba\5\30\r\2\u01ba\u01c5"+
		"\3\2\2\2\u01bb\u01bc\f\23\2\2\u01bc\u01bd\5\64\33\2\u01bd\u01be\7=\2\2"+
		"\u01be\u01c5\3\2\2\2\u01bf\u01c0\f\22\2\2\u01c0\u01c1\5\66\34\2\u01c1"+
		"\u01c2\5.\30\2\u01c2\u01c3\58\35\2\u01c3\u01c5\3\2\2\2\u01c4\u0177\3\2"+
		"\2\2\u01c4\u017f\3\2\2\2\u01c4\u0186\3\2\2\2\u01c4\u018d\3\2\2\2\u01c4"+
		"\u0196\3\2\2\2\u01c4\u019d\3\2\2\2\u01c4\u01a1\3\2\2\2\u01c4\u01a5\3\2"+
		"\2\2\u01c4\u01a9\3\2\2\2\u01c4\u01ad\3\2\2\2\u01c4\u01b1\3\2\2\2\u01c4"+
		"\u01b7\3\2\2\2\u01c4\u01bb\3\2\2\2\u01c4\u01bf\3\2\2\2\u01c5\u01c8\3\2"+
		"\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7/\3\2\2\2\u01c8\u01c6"+
		"\3\2\2\2\u01c9\u01ca\7\5\2\2\u01ca\61\3\2\2\2\u01cb\u01cc\7\6\2\2\u01cc"+
		"\63\3\2\2\2\u01cd\u01ce\7\n\2\2\u01ce\65\3\2\2\2\u01cf\u01d0\7\13\2\2"+
		"\u01d0\67\3\2\2\2\u01d1\u01d2\7\f\2\2\u01d29\3\2\2\2\u01d3\u01d4\7\16"+
		"\2\2\u01d4;\3\2\2\2\u01d5\u01d6\7\17\2\2\u01d6=\3\2\2\2\u01d7\u01d8\7"+
		"\16\2\2\u01d8?\3\2\2\2\u01d9\u01da\7\17\2\2\u01daA\3\2\2\2\u01db\u01dc"+
		"\7\20\2\2\u01dcC\3\2\2\2\u01dd\u01de\7\21\2\2\u01deE\3\2\2\2\u01df\u01e0"+
		"\7\22\2\2\u01e0G\3\2\2\2\u01e1\u01e2\7\23\2\2\u01e2I\3\2\2\2\u01e3\u01e4"+
		"\7\24\2\2\u01e4K\3\2\2\2\u01e5\u01e6\7\25\2\2\u01e6M\3\2\2\2\u01e7\u01e8"+
		"\7\26\2\2\u01e8O\3\2\2\2\u01e9\u01ea\7\20\2\2\u01eaQ\3\2\2\2\u01eb\u01ec"+
		"\7\27\2\2\u01ecS\3\2\2\2\u01ed\u01ee\7\30\2\2\u01eeU\3\2\2\2\u01ef\u01f0"+
		"\7\31\2\2\u01f0W\3\2\2\2\u01f1\u01f2\7\32\2\2\u01f2Y\3\2\2\2\u01f3\u01f4"+
		"\7\33\2\2\u01f4[\3\2\2\2\u01f5\u01f6\7\34\2\2\u01f6]\3\2\2\2\u01f7\u01f8"+
		"\7\35\2\2\u01f8_\3\2\2\2\u01f9\u01fa\7\36\2\2\u01faa\3\2\2\2\u01fb\u01fc"+
		"\7\37\2\2\u01fcc\3\2\2\2\u01fd\u01fe\7 \2\2\u01fee\3\2\2\2\u01ff\u0200"+
		"\7!\2\2\u0200g\3\2\2\2\u0201\u0202\7\"\2\2\u0202i\3\2\2\2\u0203\u0204"+
		"\7#\2\2\u0204k\3\2\2\2\u0205\u0206\7$\2\2\u0206m\3\2\2\2\u0207\u020e\5"+
		"r:\2\u0208\u0209\5\66\34\2\u0209\u020a\7\'\2\2\u020a\u020b\58\35\2\u020b"+
		"\u020d\3\2\2\2\u020c\u0208\3\2\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2"+
		"\2\2\u020e\u020f\3\2\2\2\u020f\u0216\3\2\2\2\u0210\u020e\3\2\2\2\u0211"+
		"\u0212\5\66\34\2\u0212\u0213\58\35\2\u0213\u0215\3\2\2\2\u0214\u0211\3"+
		"\2\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"o\3\2\2\2\u0218\u0216\3\2\2\2\u0219\u021f\5r:\2\u021a\u021b\5\66\34\2"+
		"\u021b\u021c\58\35\2\u021c\u021e\3\2\2\2\u021d\u021a\3\2\2\2\u021e\u0221"+
		"\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220q\3\2\2\2\u0221"+
		"\u021f\3\2\2\2\u0222\u0223\t\2\2\2\u0223s\3\2\2\2\u0224\u0227\5p9\2\u0225"+
		"\u0227\7\60\2\2\u0226\u0224\3\2\2\2\u0226\u0225\3\2\2\2\u0227u\3\2\2\2"+
		"\u0228\u0229\t\3\2\2\u0229w\3\2\2\2/{\u0081\u0089\u008d\u0092\u00a1\u00aa"+
		"\u00b0\u00ba\u00c4\u00c8\u00ce\u00e6\u00ef\u00f2\u00f8\u0108\u0113\u0117"+
		"\u011b\u0123\u0127\u012b\u0139\u0143\u0145\u014a\u0156\u015a\u0161\u016d"+
		"\u0170\u0173\u0175\u017b\u0182\u0189\u0192\u0199\u01c4\u01c6\u020e\u0216"+
		"\u021f\u0226";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}