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
		RULE_params = 8, RULE_block = 9, RULE_stmt = 10, RULE_callfun = 11, RULE_if_stmt = 12, 
		RULE_while_stmt = 13, RULE_for_stmt = 14, RULE_return_stmt = 15, RULE_assignment = 16, 
		RULE_variable = 17, RULE_expression = 18, RULE_term = 19, RULE_vartype_plus = 20, 
		RULE_vartype = 21, RULE_basetype = 22, RULE_funtype = 23, RULE_literal = 24;
	public static final String[] ruleNames = {
		"prog", "progsec", "defclass", "constructor", "classmem", "defvar", "defvarassignment", 
		"defun", "params", "block", "stmt", "callfun", "if_stmt", "while_stmt", 
		"for_stmt", "return_stmt", "assignment", "variable", "expression", "term", 
		"vartype_plus", "vartype", "basetype", "funtype", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "';'", "','", "'='", "'.'", "'['", "']'", 
		"'++'", "'--'", "'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'+'", "'<<'", 
		"'>>'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&'", "'^'", "'|'", 
		"'&&'", "'||'", "'?'", "':'", null, null, null, null, null, null, null, 
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
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(50);
				progsec();
				}
				}
				setState(55);
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
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				defclass();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				defvar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
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
			setState(61);
			match(Class);
			setState(62);
			match(Identifier);
			setState(63);
			match(T__0);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(64);
					classmem();
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(70);
				constructor();
				}
				break;
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(73);
				classmem();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
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
			setState(81);
			match(Identifier);
			setState(82);
			match(T__2);
			setState(83);
			params();
			setState(84);
			match(T__3);
			setState(85);
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
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				defvar();
				setState(88);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
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
			setState(93);
			vartype();
			setState(94);
			defvarassignment();
			}
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(96);
				match(T__5);
				setState(97);
				defvarassignment();
				}
				}
				setState(102);
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
			setState(103);
			match(Identifier);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(104);
				match(T__6);
				setState(105);
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
			setState(108);
			funtype();
			setState(109);
			match(Identifier);
			setState(110);
			match(T__2);
			setState(111);
			params();
			setState(112);
			match(T__3);
			setState(113);
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
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Void) {
					{
					setState(115);
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
				setState(118);
				vartype();
				setState(119);
				match(Identifier);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(120);
					match(T__5);
					setState(121);
					vartype();
					setState(122);
					match(Identifier);
					}
					}
					setState(128);
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
			setState(132);
			match(T__0);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				{
				setState(133);
				stmt();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
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
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				defvar();
				setState(142);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				assignment();
				setState(145);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				expression(0);
				setState(148);
				match(T__4);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				block();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(151);
				if_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(152);
				while_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(153);
				for_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(154);
				match(Break);
				setState(155);
				match(T__4);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(156);
				match(Continue);
				setState(157);
				match(T__4);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(158);
				return_stmt();
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(159);
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
			setState(162);
			variable(0);
			setState(163);
			match(T__2);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(164);
				expression(0);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(165);
					match(T__5);
					setState(166);
					expression(0);
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(174);
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(Mx_starParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
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
		enterRule(_localctx, 24, RULE_if_stmt);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(176);
				match(If);
				setState(177);
				match(T__2);
				setState(178);
				expression(0);
				setState(179);
				match(T__3);
				setState(182);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(180);
					stmt();
					}
					break;
				case 2:
					{
					setState(181);
					block();
					}
					break;
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(184);
				match(If);
				setState(185);
				match(T__2);
				setState(186);
				expression(0);
				setState(187);
				match(T__3);
				setState(190);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(188);
					stmt();
					}
					break;
				case 2:
					{
					setState(189);
					block();
					}
					break;
				}
				setState(192);
				match(Else);
				setState(195);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(193);
					stmt();
					}
					break;
				case 2:
					{
					setState(194);
					block();
					}
					break;
				}
				}
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
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 26, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(While);
			setState(200);
			match(T__2);
			setState(201);
			expression(0);
			setState(202);
			match(T__3);
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(203);
				stmt();
				}
				break;
			case 2:
				{
				setState(204);
				block();
				}
				break;
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

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(Mx_starParser.For, 0); }
		public DefvarContext defvar() {
			return getRuleContext(DefvarContext.class,0);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 28, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(For);
			setState(208);
			match(T__2);
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(209);
				defvar();
				}
				break;
			case 2:
				{
				setState(210);
				assignment();
				}
				break;
			}
			setState(213);
			match(T__4);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(214);
				expression(0);
				}
			}

			setState(217);
			match(T__4);
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(218);
				assignment();
				}
				break;
			case 2:
				{
				setState(219);
				expression(0);
				}
				break;
			}
			setState(222);
			match(T__3);
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(223);
				stmt();
				}
				break;
			case 2:
				{
				setState(224);
				block();
				}
				break;
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
		enterRule(_localctx, 30, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(Return);
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
				{
				setState(228);
				expression(0);
				}
			}

			setState(231);
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
		enterRule(_localctx, 32, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(233);
			variable(0);
			setState(234);
			match(T__6);
			setState(235);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_variable, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(238);
				match(Identifier);
				}
				break;
			case T__2:
				{
				setState(239);
				match(T__2);
				setState(240);
				variable(0);
				setState(241);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(257);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new VariableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable);
						setState(245);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(246);
						match(T__7);
						setState(247);
						match(Identifier);
						}
						break;
					case 2:
						{
						_localctx = new VariableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable);
						setState(248);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(253); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(249);
								match(T__8);
								setState(250);
								expression(0);
								setState(251);
								match(T__9);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(255); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class ExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public CallfunContext callfun() {
			return getRuleContext(CallfunContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode New() { return getToken(Mx_starParser.New, 0); }
		public Vartype_plusContext vartype_plus() {
			return getRuleContext(Vartype_plusContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Mx_starParser.Identifier, 0); }
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(263);
				term();
				}
				break;
			case 2:
				{
				setState(264);
				callfun();
				}
				break;
			case 3:
				{
				setState(265);
				match(T__2);
				setState(266);
				expression(0);
				setState(267);
				match(T__3);
				}
				break;
			case 4:
				{
				setState(269);
				variable(0);
				setState(270);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 5:
				{
				setState(272);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(273);
				variable(0);
				}
				break;
			case 6:
				{
				setState(274);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(275);
				expression(13);
				}
				break;
			case 7:
				{
				setState(276);
				match(New);
				setState(277);
				vartype_plus();
				setState(290);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(278);
					match(T__2);
					setState(287);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Null) | (1L << New) | (1L << Identifier))) != 0)) {
						{
						setState(279);
						expression(0);
						setState(284);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__5) {
							{
							{
							setState(280);
							match(T__5);
							setState(281);
							expression(0);
							}
							}
							setState(286);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(289);
					match(T__3);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(343);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(341);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(295);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(296);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(298);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__18) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(299);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(301);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(302);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(304);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(305);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(307);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(308);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(310);
						match(T__27);
						setState(311);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(313);
						match(T__28);
						setState(314);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(316);
						match(T__29);
						setState(317);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(319);
						match(T__30);
						setState(320);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(322);
						match(T__31);
						setState(323);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(325);
						match(T__32);
						setState(326);
						expression(0);
						setState(327);
						match(T__33);
						setState(328);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(330);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(331);
						match(T__7);
						setState(332);
						callfun();
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(334);
						match(T__7);
						setState(335);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(337);
						match(T__8);
						setState(338);
						expression(0);
						setState(339);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(345);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 38, RULE_term);
		try {
			setState(348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				variable(0);
				}
				break;
			case Booleanliteral:
			case Stringliteral:
			case Integerliteral:
			case Null:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
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

	public static class Vartype_plusContext extends ParserRuleContext {
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public List<TerminalNode> Integerliteral() { return getTokens(Mx_starParser.Integerliteral); }
		public TerminalNode Integerliteral(int i) {
			return getToken(Mx_starParser.Integerliteral, i);
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
		enterRule(_localctx, 40, RULE_vartype_plus);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			basetype();
			setState(356);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(351);
					match(T__8);
					setState(352);
					match(Integerliteral);
					setState(353);
					match(T__9);
					}
					} 
				}
				setState(358);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			setState(363);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(359);
					match(T__8);
					setState(360);
					match(T__9);
					}
					} 
				}
				setState(365);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		enterRule(_localctx, 42, RULE_vartype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			basetype();
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(367);
				match(T__8);
				setState(368);
				match(T__9);
				}
				}
				setState(373);
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
		enterRule(_localctx, 44, RULE_basetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
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
		enterRule(_localctx, 46, RULE_funtype);
		try {
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				vartype();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
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
		enterRule(_localctx, 48, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
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
		case 17:
			return variable_sempred((VariableContext)_localctx, predIndex);
		case 18:
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
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u0181\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\3\5\3>\n\3\3\4\3\4"+
		"\3\4\3\4\7\4D\n\4\f\4\16\4G\13\4\3\4\5\4J\n\4\3\4\7\4M\n\4\f\4\16\4P\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6^\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\7\7e\n\7\f\7\16\7h\13\7\3\b\3\b\3\b\5\bm\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\5\nw\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\177\n\n\f\n\16"+
		"\n\u0082\13\n\3\n\5\n\u0085\n\n\3\13\3\13\7\13\u0089\n\13\f\13\16\13\u008c"+
		"\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a3\n\f\3\r\3\r\3\r\3\r\3\r\7\r\u00aa\n\r"+
		"\f\r\16\r\u00ad\13\r\5\r\u00af\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u00b9\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c1\n\16\3\16"+
		"\3\16\3\16\5\16\u00c6\n\16\5\16\u00c8\n\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00d0\n\17\3\20\3\20\3\20\3\20\5\20\u00d6\n\20\3\20\3\20\5\20"+
		"\u00da\n\20\3\20\3\20\3\20\5\20\u00df\n\20\3\20\3\20\3\20\5\20\u00e4\n"+
		"\20\3\21\3\21\5\21\u00e8\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00f6\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\6\23\u0100\n\23\r\23\16\23\u0101\7\23\u0104\n\23\f\23\16\23\u0107"+
		"\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u011d\n\24\f\24\16\24\u0120\13"+
		"\24\5\24\u0122\n\24\3\24\5\24\u0125\n\24\5\24\u0127\n\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\7\24\u0158\n\24\f\24\16\24\u015b\13\24\3\25\3\25\5\25\u015f"+
		"\n\25\3\26\3\26\3\26\3\26\7\26\u0165\n\26\f\26\16\26\u0168\13\26\3\26"+
		"\3\26\7\26\u016c\n\26\f\26\16\26\u016f\13\26\3\27\3\27\3\27\7\27\u0174"+
		"\n\27\f\27\16\27\u0177\13\27\3\30\3\30\3\31\3\31\5\31\u017d\n\31\3\32"+
		"\3\32\3\32\2\4$&\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\2\13\3\2\r\16\3\2\17\21\3\2\22\24\4\2\17\17\25\25\3\2\26\27\3\2\30"+
		"\33\3\2\34\35\4\2,.==\4\2%\'//\2\u01ac\2\67\3\2\2\2\4=\3\2\2\2\6?\3\2"+
		"\2\2\bS\3\2\2\2\n]\3\2\2\2\f_\3\2\2\2\16i\3\2\2\2\20n\3\2\2\2\22\u0084"+
		"\3\2\2\2\24\u0086\3\2\2\2\26\u00a2\3\2\2\2\30\u00a4\3\2\2\2\32\u00c7\3"+
		"\2\2\2\34\u00c9\3\2\2\2\36\u00d1\3\2\2\2 \u00e5\3\2\2\2\"\u00eb\3\2\2"+
		"\2$\u00f5\3\2\2\2&\u0126\3\2\2\2(\u015e\3\2\2\2*\u0160\3\2\2\2,\u0170"+
		"\3\2\2\2.\u0178\3\2\2\2\60\u017c\3\2\2\2\62\u017e\3\2\2\2\64\66\5\4\3"+
		"\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\3\3\2\2\29\67"+
		"\3\2\2\2:>\5\6\4\2;>\5\f\7\2<>\5\20\t\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2"+
		">\5\3\2\2\2?@\7;\2\2@A\7=\2\2AE\7\3\2\2BD\5\n\6\2CB\3\2\2\2DG\3\2\2\2"+
		"EC\3\2\2\2EF\3\2\2\2FI\3\2\2\2GE\3\2\2\2HJ\5\b\5\2IH\3\2\2\2IJ\3\2\2\2"+
		"JN\3\2\2\2KM\5\n\6\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2"+
		"PN\3\2\2\2QR\7\4\2\2R\7\3\2\2\2ST\7=\2\2TU\7\5\2\2UV\5\22\n\2VW\7\6\2"+
		"\2WX\5\24\13\2X\t\3\2\2\2YZ\5\f\7\2Z[\7\7\2\2[^\3\2\2\2\\^\5\20\t\2]Y"+
		"\3\2\2\2]\\\3\2\2\2^\13\3\2\2\2_`\5,\27\2`a\5\16\b\2af\3\2\2\2bc\7\b\2"+
		"\2ce\5\16\b\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\r\3\2\2\2hf\3\2"+
		"\2\2il\7=\2\2jk\7\t\2\2km\5&\24\2lj\3\2\2\2lm\3\2\2\2m\17\3\2\2\2no\5"+
		"\60\31\2op\7=\2\2pq\7\5\2\2qr\5\22\n\2rs\7\6\2\2st\5\24\13\2t\21\3\2\2"+
		"\2uw\7\60\2\2vu\3\2\2\2vw\3\2\2\2w\u0085\3\2\2\2xy\5,\27\2y\u0080\7=\2"+
		"\2z{\7\b\2\2{|\5,\27\2|}\7=\2\2}\177\3\2\2\2~z\3\2\2\2\177\u0082\3\2\2"+
		"\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0085\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\u0085\3\2\2\2\u0084v\3\2\2\2\u0084x\3\2\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\23\3\2\2\2\u0086\u008a\7\3\2\2\u0087\u0089\5\26\f\2\u0088"+
		"\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7\4\2\2\u008e"+
		"\25\3\2\2\2\u008f\u0090\5\f\7\2\u0090\u0091\7\7\2\2\u0091\u00a3\3\2\2"+
		"\2\u0092\u0093\5\"\22\2\u0093\u0094\7\7\2\2\u0094\u00a3\3\2\2\2\u0095"+
		"\u0096\5&\24\2\u0096\u0097\7\7\2\2\u0097\u00a3\3\2\2\2\u0098\u00a3\5\24"+
		"\13\2\u0099\u00a3\5\32\16\2\u009a\u00a3\5\34\17\2\u009b\u00a3\5\36\20"+
		"\2\u009c\u009d\7\67\2\2\u009d\u00a3\7\7\2\2\u009e\u009f\78\2\2\u009f\u00a3"+
		"\7\7\2\2\u00a0\u00a3\5 \21\2\u00a1\u00a3\7\7\2\2\u00a2\u008f\3\2\2\2\u00a2"+
		"\u0092\3\2\2\2\u00a2\u0095\3\2\2\2\u00a2\u0098\3\2\2\2\u00a2\u0099\3\2"+
		"\2\2\u00a2\u009a\3\2\2\2\u00a2\u009b\3\2\2\2\u00a2\u009c\3\2\2\2\u00a2"+
		"\u009e\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\27\3\2\2"+
		"\2\u00a4\u00a5\5$\23\2\u00a5\u00ae\7\5\2\2\u00a6\u00ab\5&\24\2\u00a7\u00a8"+
		"\7\b\2\2\u00a8\u00aa\5&\24\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\7\6\2\2\u00b1\31\3\2\2\2\u00b2\u00b3\7\63\2\2\u00b3\u00b4\7\5\2"+
		"\2\u00b4\u00b5\5&\24\2\u00b5\u00b8\7\6\2\2\u00b6\u00b9\5\26\f\2\u00b7"+
		"\u00b9\5\24\13\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00c8\3"+
		"\2\2\2\u00ba\u00bb\7\63\2\2\u00bb\u00bc\7\5\2\2\u00bc\u00bd\5&\24\2\u00bd"+
		"\u00c0\7\6\2\2\u00be\u00c1\5\26\f\2\u00bf\u00c1\5\24\13\2\u00c0\u00be"+
		"\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c5\7\64\2\2"+
		"\u00c3\u00c6\5\26\f\2\u00c4\u00c6\5\24\13\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c4\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00b2\3\2\2\2\u00c7\u00ba\3\2"+
		"\2\2\u00c8\33\3\2\2\2\u00c9\u00ca\7\66\2\2\u00ca\u00cb\7\5\2\2\u00cb\u00cc"+
		"\5&\24\2\u00cc\u00cf\7\6\2\2\u00cd\u00d0\5\26\f\2\u00ce\u00d0\5\24\13"+
		"\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\35\3\2\2\2\u00d1\u00d2"+
		"\7\65\2\2\u00d2\u00d5\7\5\2\2\u00d3\u00d6\5\f\7\2\u00d4\u00d6\5\"\22\2"+
		"\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9"+
		"\7\7\2\2\u00d8\u00da\5&\24\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00de\7\7\2\2\u00dc\u00df\5\"\22\2\u00dd\u00df\5"+
		"&\24\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e3\7\6\2\2\u00e1\u00e4\5\26\f\2\u00e2\u00e4\5"+
		"\24\13\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\37\3\2\2\2\u00e5"+
		"\u00e7\79\2\2\u00e6\u00e8\5&\24\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7\7\2\2\u00ea!\3\2\2\2\u00eb\u00ec"+
		"\5$\23\2\u00ec\u00ed\7\t\2\2\u00ed\u00ee\5&\24\2\u00ee#\3\2\2\2\u00ef"+
		"\u00f0\b\23\1\2\u00f0\u00f6\7=\2\2\u00f1\u00f2\7\5\2\2\u00f2\u00f3\5$"+
		"\23\2\u00f3\u00f4\7\6\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00ef\3\2\2\2\u00f5"+
		"\u00f1\3\2\2\2\u00f6\u0105\3\2\2\2\u00f7\u00f8\f\4\2\2\u00f8\u00f9\7\n"+
		"\2\2\u00f9\u0104\7=\2\2\u00fa\u00ff\f\3\2\2\u00fb\u00fc\7\13\2\2\u00fc"+
		"\u00fd\5&\24\2\u00fd\u00fe\7\f\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fb\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0104\3\2\2\2\u0103\u00f7\3\2\2\2\u0103\u00fa\3\2\2\2\u0104\u0107\3\2"+
		"\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106%\3\2\2\2\u0107\u0105"+
		"\3\2\2\2\u0108\u0109\b\24\1\2\u0109\u0127\5(\25\2\u010a\u0127\5\30\r\2"+
		"\u010b\u010c\7\5\2\2\u010c\u010d\5&\24\2\u010d\u010e\7\6\2\2\u010e\u0127"+
		"\3\2\2\2\u010f\u0110\5$\23\2\u0110\u0111\t\2\2\2\u0111\u0127\3\2\2\2\u0112"+
		"\u0113\t\2\2\2\u0113\u0127\5$\23\2\u0114\u0115\t\3\2\2\u0115\u0127\5&"+
		"\24\17\u0116\u0117\7:\2\2\u0117\u0124\5*\26\2\u0118\u0121\7\5\2\2\u0119"+
		"\u011e\5&\24\2\u011a\u011b\7\b\2\2\u011b\u011d\5&\24\2\u011c\u011a\3\2"+
		"\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0119\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123\u0125\7\6\2\2\u0124\u0118\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0108\3\2\2\2\u0126\u010a\3\2"+
		"\2\2\u0126\u010b\3\2\2\2\u0126\u010f\3\2\2\2\u0126\u0112\3\2\2\2\u0126"+
		"\u0114\3\2\2\2\u0126\u0116\3\2\2\2\u0127\u0159\3\2\2\2\u0128\u0129\f\16"+
		"\2\2\u0129\u012a\t\4\2\2\u012a\u0158\5&\24\17\u012b\u012c\f\r\2\2\u012c"+
		"\u012d\t\5\2\2\u012d\u0158\5&\24\16\u012e\u012f\f\f\2\2\u012f\u0130\t"+
		"\6\2\2\u0130\u0158\5&\24\r\u0131\u0132\f\13\2\2\u0132\u0133\t\7\2\2\u0133"+
		"\u0158\5&\24\f\u0134\u0135\f\n\2\2\u0135\u0136\t\b\2\2\u0136\u0158\5&"+
		"\24\13\u0137\u0138\f\t\2\2\u0138\u0139\7\36\2\2\u0139\u0158\5&\24\n\u013a"+
		"\u013b\f\b\2\2\u013b\u013c\7\37\2\2\u013c\u0158\5&\24\t\u013d\u013e\f"+
		"\7\2\2\u013e\u013f\7 \2\2\u013f\u0158\5&\24\b\u0140\u0141\f\6\2\2\u0141"+
		"\u0142\7!\2\2\u0142\u0158\5&\24\7\u0143\u0144\f\5\2\2\u0144\u0145\7\""+
		"\2\2\u0145\u0158\5&\24\6\u0146\u0147\f\4\2\2\u0147\u0148\7#\2\2\u0148"+
		"\u0149\5&\24\2\u0149\u014a\7$\2\2\u014a\u014b\5&\24\5\u014b\u0158\3\2"+
		"\2\2\u014c\u014d\f\24\2\2\u014d\u014e\7\n\2\2\u014e\u0158\5\30\r\2\u014f"+
		"\u0150\f\23\2\2\u0150\u0151\7\n\2\2\u0151\u0158\7=\2\2\u0152\u0153\f\22"+
		"\2\2\u0153\u0154\7\13\2\2\u0154\u0155\5&\24\2\u0155\u0156\7\f\2\2\u0156"+
		"\u0158\3\2\2\2\u0157\u0128\3\2\2\2\u0157\u012b\3\2\2\2\u0157\u012e\3\2"+
		"\2\2\u0157\u0131\3\2\2\2\u0157\u0134\3\2\2\2\u0157\u0137\3\2\2\2\u0157"+
		"\u013a\3\2\2\2\u0157\u013d\3\2\2\2\u0157\u0140\3\2\2\2\u0157\u0143\3\2"+
		"\2\2\u0157\u0146\3\2\2\2\u0157\u014c\3\2\2\2\u0157\u014f\3\2\2\2\u0157"+
		"\u0152\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015a\'\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015f\5$\23\2\u015d\u015f"+
		"\5\62\32\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2\u015f)\3\2\2\2\u0160"+
		"\u0166\5.\30\2\u0161\u0162\7\13\2\2\u0162\u0163\7\'\2\2\u0163\u0165\7"+
		"\f\2\2\u0164\u0161\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u016d\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016a\7\13"+
		"\2\2\u016a\u016c\7\f\2\2\u016b\u0169\3\2\2\2\u016c\u016f\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e+\3\2\2\2\u016f\u016d\3\2\2\2"+
		"\u0170\u0175\5.\30\2\u0171\u0172\7\13\2\2\u0172\u0174\7\f\2\2\u0173\u0171"+
		"\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"-\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\t\t\2\2\u0179/\3\2\2\2\u017a"+
		"\u017d\5,\27\2\u017b\u017d\7\60\2\2\u017c\u017a\3\2\2\2\u017c\u017b\3"+
		"\2\2\2\u017d\61\3\2\2\2\u017e\u017f\t\n\2\2\u017f\63\3\2\2\2*\67=EIN]"+
		"flv\u0080\u0084\u008a\u00a2\u00ab\u00ae\u00b8\u00c0\u00c5\u00c7\u00cf"+
		"\u00d5\u00d9\u00de\u00e3\u00e7\u00f5\u0101\u0103\u0105\u011e\u0121\u0124"+
		"\u0126\u0157\u0159\u015e\u0166\u016d\u0175\u017c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}