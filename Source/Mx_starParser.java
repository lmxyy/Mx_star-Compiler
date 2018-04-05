// Generated from Mx_star.g4 by ANTLR 4.7.1
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
		Identifier=38, Decimalliteral=39, Whitespace=40, Newline=41, BlockComment=42, 
		LineComment=43, Int=44, Bool=45, String=46, Null=47, Void=48, True=49, 
		False=50, If=51, Else=52, For=53, While=54, Break=55, Continue=56, Return=57, 
		New=58, Class=59, This=60;
	public static final int
		RULE_defclass = 0, RULE_defvar = 1, RULE_defun = 2, RULE_params = 3, RULE_block = 4, 
		RULE_stmts = 5, RULE_stmt = 6, RULE_callfun = 7, RULE_if_stmt = 8, RULE_while_stmt = 9, 
		RULE_for_stmt = 10, RULE_return_stmt = 11, RULE_assignment = 12, RULE_expression = 13, 
		RULE_variable = 14, RULE_term = 15, RULE_vartype_plus = 16, RULE_vartype = 17, 
		RULE_basetype = 18, RULE_funtype = 19, RULE_literal = 20;
	public static final String[] ruleNames = {
		"defclass", "defvar", "defun", "params", "block", "stmts", "stmt", "callfun", 
		"if_stmt", "while_stmt", "for_stmt", "return_stmt", "assignment", "expression", 
		"variable", "term", "vartype_plus", "vartype", "basetype", "funtype", 
		"literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'('", "')'", "'}'", "'='", "';'", "','", "'++'", "'--'", 
		"'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'+'", "'<<'", "'>>'", "'>'", 
		"'>='", "'<'", "'<='", "'=='", "'!='", "'&'", "'^'", "'|'", "'&&'", "'||'", 
		"'?'", "':'", "'.'", "'['", "']'", null, null, null, null, null, null, 
		null, null, null, "'int'", "'bool'", "'string'", "'null'", "'void'", "'true'", 
		"'false'", "'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", 
		"'return'", "'new'", "'class'", "'this'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "Booleanliteral", 
		"Stringliteral", "Integerliteral", "Identifier", "Decimalliteral", "Whitespace", 
		"Newline", "BlockComment", "LineComment", "Int", "Bool", "String", "Null", 
		"Void", "True", "False", "If", "Else", "For", "While", "Break", "Continue", 
		"Return", "New", "Class", "This"
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
	public static class DefclassContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(Mx_starParser.Class, 0); }
		public List<TerminalNode> Identifier() { return getTokens(Mx_starParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Mx_starParser.Identifier, i);
		}
		public List<DefvarContext> defvar() {
			return getRuleContexts(DefvarContext.class);
		}
		public DefvarContext defvar(int i) {
			return getRuleContext(DefvarContext.class,i);
		}
		public List<DefunContext> defun() {
			return getRuleContexts(DefunContext.class);
		}
		public DefunContext defun(int i) {
			return getRuleContext(DefunContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Void() { return getToken(Mx_starParser.Void, 0); }
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
	}

	public final DefclassContext defclass() throws RecognitionException {
		DefclassContext _localctx = new DefclassContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_defclass);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(Class);
			setState(43);
			match(Identifier);
			setState(44);
			match(T__0);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(47);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(45);
						defvar();
						}
						break;
					case 2:
						{
						setState(46);
						defun();
						}
						break;
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(52);
				match(Identifier);
				setState(53);
				match(T__1);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Void) {
					{
					setState(54);
					match(Void);
					}
				}

				setState(57);
				match(T__2);
				setState(58);
				block();
				}
				break;
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Void))) != 0)) {
				{
				setState(63);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(61);
					defvar();
					}
					break;
				case 2:
					{
					setState(62);
					defun();
					}
					break;
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
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

	public static class DefvarContext extends ParserRuleContext {
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Mx_starParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}

	public final DefvarContext defvar() throws RecognitionException {
		DefvarContext _localctx = new DefvarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_defvar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(70);
			basetype();
			setState(71);
			match(Identifier);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(72);
				match(T__4);
				setState(73);
				expression(0);
				}
			}

			setState(76);
			match(T__5);
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
	}

	public final DefunContext defun() throws RecognitionException {
		DefunContext _localctx = new DefunContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_defun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			funtype();
			setState(79);
			match(Identifier);
			setState(80);
			match(T__1);
			setState(81);
			params();
			setState(82);
			match(T__2);
			setState(83);
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
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_params);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Void) {
					{
					setState(85);
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
				setState(88);
				vartype();
				setState(89);
				match(Identifier);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(90);
					match(T__6);
					setState(91);
					vartype();
					setState(92);
					match(Identifier);
					}
					}
					setState(98);
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
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
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
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__0);
			setState(103);
			stmts();
			setState(104);
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

	public static class StmtsContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_starListener ) ((Mx_starListener)listener).exitStmts(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stmts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Identifier) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New))) != 0)) {
				{
				{
				setState(106);
				stmt();
				}
				}
				setState(111);
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

	public static class StmtContext extends ParserRuleContext {
		public DefvarContext defvar() {
			return getRuleContext(DefvarContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CallfunContext callfun() {
			return getRuleContext(CallfunContext.class,0);
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
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmt);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				defvar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(115);
				callfun();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(116);
				expression(0);
				setState(117);
				match(T__5);
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
				block();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(120);
				if_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(121);
				while_stmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(122);
				for_stmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(123);
				match(Break);
				setState(124);
				match(T__5);
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(125);
				match(Continue);
				setState(126);
				match(T__5);
				}
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				{
				setState(127);
				return_stmt();
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
	}

	public final CallfunContext callfun() throws RecognitionException {
		CallfunContext _localctx = new CallfunContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_callfun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			variable(0);
			setState(131);
			match(T__1);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Identifier) | (1L << Null) | (1L << New))) != 0)) {
				{
				setState(132);
				expression(0);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(133);
					match(T__1);
					setState(134);
					match(T__6);
					setState(135);
					expression(0);
					setState(136);
					match(T__2);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(145);
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
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_stmt);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(147);
				match(If);
				setState(148);
				match(T__1);
				setState(149);
				expression(0);
				setState(150);
				match(T__2);
				setState(153);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(151);
					stmt();
					}
					break;
				case 2:
					{
					setState(152);
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
				setState(155);
				match(If);
				setState(156);
				match(T__1);
				setState(157);
				expression(0);
				setState(158);
				match(T__2);
				setState(161);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(159);
					stmt();
					}
					break;
				case 2:
					{
					setState(160);
					block();
					}
					break;
				}
				setState(163);
				match(Else);
				setState(166);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(164);
					stmt();
					}
					break;
				case 2:
					{
					setState(165);
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
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(While);
			setState(171);
			match(T__1);
			setState(172);
			expression(0);
			setState(173);
			match(T__2);
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(174);
				stmt();
				}
				break;
			case 2:
				{
				setState(175);
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
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public DefvarContext defvar() {
			return getRuleContext(DefvarContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(For);
			setState(179);
			match(T__1);
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(180);
				defvar();
				}
				break;
			case 2:
				{
				setState(181);
				assignment();
				}
				break;
			}
			setState(184);
			match(T__5);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Identifier) | (1L << Null) | (1L << New))) != 0)) {
				{
				setState(185);
				expression(0);
				}
			}

			setState(188);
			match(T__5);
			setState(189);
			assignment();
			setState(190);
			match(T__2);
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(191);
				stmt();
				}
				break;
			case 2:
				{
				setState(192);
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
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(Return);
			setState(196);
			expression(0);
			setState(197);
			match(T__5);
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
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignment);
		int _la;
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(199);
				variable(0);
				setState(200);
				match(T__4);
				setState(201);
				expression(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(203);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(204);
				variable(0);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(205);
				variable(0);
				setState(206);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
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
		public TerminalNode New() { return getToken(Mx_starParser.New, 0); }
		public Vartype_plusContext vartype_plus() {
			return getRuleContext(Vartype_plusContext.class,0);
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
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(211);
				term();
				}
				break;
			case 2:
				{
				setState(212);
				callfun();
				}
				break;
			case 3:
				{
				setState(213);
				match(T__1);
				setState(214);
				expression(0);
				setState(215);
				match(T__2);
				}
				break;
			case 4:
				{
				setState(217);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(218);
				expression(13);
				}
				break;
			case 5:
				{
				setState(219);
				match(New);
				setState(220);
				vartype_plus();
				setState(233);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(221);
					match(T__1);
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << Booleanliteral) | (1L << Stringliteral) | (1L << Integerliteral) | (1L << Identifier) | (1L << Null) | (1L << New))) != 0)) {
						{
						setState(222);
						expression(0);
						setState(227);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__6) {
							{
							{
							setState(223);
							match(T__6);
							setState(224);
							expression(0);
							}
							}
							setState(229);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(232);
					match(T__2);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(273);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(237);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(238);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(239);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(240);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(241);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__15) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(242);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(244);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(245);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(246);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(247);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(249);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(250);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(253);
						match(T__24);
						setState(254);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(255);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(256);
						match(T__25);
						setState(257);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(258);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(259);
						match(T__26);
						setState(260);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(261);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(262);
						match(T__27);
						setState(263);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(264);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(265);
						match(T__28);
						setState(266);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(268);
						match(T__29);
						setState(269);
						expression(0);
						setState(270);
						match(T__30);
						setState(271);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(277);
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
	}

	public final VariableContext variable() throws RecognitionException {
		return variable(0);
	}

	private VariableContext variable(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableContext _localctx = new VariableContext(_ctx, _parentState);
		VariableContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_variable, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(279);
				match(Identifier);
				}
				break;
			case T__1:
				{
				setState(280);
				match(T__1);
				setState(281);
				variable(0);
				setState(282);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(298);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new VariableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable);
						setState(286);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(287);
						match(T__31);
						setState(288);
						match(Identifier);
						}
						break;
					case 2:
						{
						_localctx = new VariableContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable);
						setState(289);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(294); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(290);
								match(T__32);
								setState(291);
								expression(0);
								setState(292);
								match(T__33);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(296); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_term);
		try {
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				variable(0);
				}
				break;
			case Booleanliteral:
			case Stringliteral:
			case Integerliteral:
			case Null:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
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
		public List<TerminalNode> Decimalliteral() { return getTokens(Mx_starParser.Decimalliteral); }
		public TerminalNode Decimalliteral(int i) {
			return getToken(Mx_starParser.Decimalliteral, i);
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
	}

	public final Vartype_plusContext vartype_plus() throws RecognitionException {
		Vartype_plusContext _localctx = new Vartype_plusContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_vartype_plus);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			basetype();
			setState(313);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(308);
					match(T__32);
					setState(309);
					match(Decimalliteral);
					setState(310);
					match(T__33);
					}
					} 
				}
				setState(315);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(316);
					match(T__32);
					setState(317);
					match(T__33);
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
	}

	public final VartypeContext vartype() throws RecognitionException {
		VartypeContext _localctx = new VartypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_vartype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			basetype();
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(324);
				match(T__32);
				setState(325);
				match(T__33);
				}
				}
				setState(330);
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
	}

	public final BasetypeContext basetype() throws RecognitionException {
		BasetypeContext _localctx = new BasetypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_basetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << Int) | (1L << Bool) | (1L << String))) != 0)) ) {
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
	}

	public final FuntypeContext funtype() throws RecognitionException {
		FuntypeContext _localctx = new FuntypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funtype);
		try {
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
			case Int:
			case Bool:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				vartype();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
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
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
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
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 14:
			return variable_sempred((VariableContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean variable_sempred(VariableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3>\u0156\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\7\2\62\n"+
		"\2\f\2\16\2\65\13\2\3\2\3\2\3\2\5\2:\n\2\3\2\3\2\5\2>\n\2\3\2\3\2\7\2"+
		"B\n\2\f\2\16\2E\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3M\n\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\5\5Y\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5a\n\5\f\5"+
		"\16\5d\13\5\3\5\5\5g\n\5\3\6\3\6\3\6\3\6\3\7\7\7n\n\7\f\7\16\7q\13\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0083"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u008d\n\t\f\t\16\t\u0090\13\t"+
		"\5\t\u0092\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009c\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u00a4\n\n\3\n\3\n\3\n\5\n\u00a9\n\n\5\n\u00ab\n\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b3\n\13\3\f\3\f\3\f\3\f\5\f\u00b9"+
		"\n\f\3\f\3\f\5\f\u00bd\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c4\n\f\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d3\n\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\7\17\u00e4\n\17\f\17\16\17\u00e7\13\17\5\17\u00e9\n\17\3\17\5\17\u00ec"+
		"\n\17\5\17\u00ee\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0114"+
		"\n\17\f\17\16\17\u0117\13\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u011f"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u0129\n\20\r\20\16"+
		"\20\u012a\7\20\u012d\n\20\f\20\16\20\u0130\13\20\3\21\3\21\5\21\u0134"+
		"\n\21\3\22\3\22\3\22\3\22\7\22\u013a\n\22\f\22\16\22\u013d\13\22\3\22"+
		"\3\22\7\22\u0141\n\22\f\22\16\22\u0144\13\22\3\23\3\23\3\23\7\23\u0149"+
		"\n\23\f\23\16\23\u014c\13\23\3\24\3\24\3\25\3\25\5\25\u0152\n\25\3\26"+
		"\3\26\3\26\2\4\34\36\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		"\2\13\3\2\n\13\3\2\f\16\3\2\17\21\4\2\f\f\22\22\3\2\23\24\3\2\25\30\3"+
		"\2\31\32\4\2((.\60\4\2%\'\61\61\2\u017e\2,\3\2\2\2\4H\3\2\2\2\6P\3\2\2"+
		"\2\bf\3\2\2\2\nh\3\2\2\2\fo\3\2\2\2\16\u0082\3\2\2\2\20\u0084\3\2\2\2"+
		"\22\u00aa\3\2\2\2\24\u00ac\3\2\2\2\26\u00b4\3\2\2\2\30\u00c5\3\2\2\2\32"+
		"\u00d2\3\2\2\2\34\u00ed\3\2\2\2\36\u011e\3\2\2\2 \u0133\3\2\2\2\"\u0135"+
		"\3\2\2\2$\u0145\3\2\2\2&\u014d\3\2\2\2(\u0151\3\2\2\2*\u0153\3\2\2\2,"+
		"-\7=\2\2-.\7(\2\2.\63\7\3\2\2/\62\5\4\3\2\60\62\5\6\4\2\61/\3\2\2\2\61"+
		"\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64=\3\2\2\2\65\63"+
		"\3\2\2\2\66\67\7(\2\2\679\7\4\2\28:\7\62\2\298\3\2\2\29:\3\2\2\2:;\3\2"+
		"\2\2;<\7\5\2\2<>\5\n\6\2=\66\3\2\2\2=>\3\2\2\2>C\3\2\2\2?B\5\4\3\2@B\5"+
		"\6\4\2A?\3\2\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3"+
		"\2\2\2FG\7\6\2\2G\3\3\2\2\2HI\5&\24\2IL\7(\2\2JK\7\7\2\2KM\5\34\17\2L"+
		"J\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\b\2\2O\5\3\2\2\2PQ\5(\25\2QR\7(\2\2"+
		"RS\7\4\2\2ST\5\b\5\2TU\7\5\2\2UV\5\n\6\2V\7\3\2\2\2WY\7\62\2\2XW\3\2\2"+
		"\2XY\3\2\2\2Yg\3\2\2\2Z[\5$\23\2[b\7(\2\2\\]\7\t\2\2]^\5$\23\2^_\7(\2"+
		"\2_a\3\2\2\2`\\\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2cg\3\2\2\2db\3\2"+
		"\2\2eg\3\2\2\2fX\3\2\2\2fZ\3\2\2\2fe\3\2\2\2g\t\3\2\2\2hi\7\3\2\2ij\5"+
		"\f\7\2jk\7\6\2\2k\13\3\2\2\2ln\5\16\b\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2"+
		"op\3\2\2\2p\r\3\2\2\2qo\3\2\2\2r\u0083\7\b\2\2s\u0083\5\4\3\2t\u0083\5"+
		"\32\16\2u\u0083\5\20\t\2vw\5\34\17\2wx\7\b\2\2x\u0083\3\2\2\2y\u0083\5"+
		"\n\6\2z\u0083\5\22\n\2{\u0083\5\24\13\2|\u0083\5\26\f\2}~\79\2\2~\u0083"+
		"\7\b\2\2\177\u0080\7:\2\2\u0080\u0083\7\b\2\2\u0081\u0083\5\30\r\2\u0082"+
		"r\3\2\2\2\u0082s\3\2\2\2\u0082t\3\2\2\2\u0082u\3\2\2\2\u0082v\3\2\2\2"+
		"\u0082y\3\2\2\2\u0082z\3\2\2\2\u0082{\3\2\2\2\u0082|\3\2\2\2\u0082}\3"+
		"\2\2\2\u0082\177\3\2\2\2\u0082\u0081\3\2\2\2\u0083\17\3\2\2\2\u0084\u0085"+
		"\5\36\20\2\u0085\u0091\7\4\2\2\u0086\u008e\5\34\17\2\u0087\u0088\7\4\2"+
		"\2\u0088\u0089\7\t\2\2\u0089\u008a\5\34\17\2\u008a\u008b\7\5\2\2\u008b"+
		"\u008d\3\2\2\2\u008c\u0087\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0086\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\5"+
		"\2\2\u0094\21\3\2\2\2\u0095\u0096\7\65\2\2\u0096\u0097\7\4\2\2\u0097\u0098"+
		"\5\34\17\2\u0098\u009b\7\5\2\2\u0099\u009c\5\16\b\2\u009a\u009c\5\n\6"+
		"\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u00ab\3\2\2\2\u009d\u009e"+
		"\7\65\2\2\u009e\u009f\7\4\2\2\u009f\u00a0\5\34\17\2\u00a0\u00a3\7\5\2"+
		"\2\u00a1\u00a4\5\16\b\2\u00a2\u00a4\5\n\6\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8\7\66\2\2\u00a6\u00a9\5"+
		"\16\b\2\u00a7\u00a9\5\n\6\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\u00ab\3\2\2\2\u00aa\u0095\3\2\2\2\u00aa\u009d\3\2\2\2\u00ab\23\3\2\2"+
		"\2\u00ac\u00ad\78\2\2\u00ad\u00ae\7\4\2\2\u00ae\u00af\5\34\17\2\u00af"+
		"\u00b2\7\5\2\2\u00b0\u00b3\5\16\b\2\u00b1\u00b3\5\n\6\2\u00b2\u00b0\3"+
		"\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\25\3\2\2\2\u00b4\u00b5\7\67\2\2\u00b5"+
		"\u00b8\7\4\2\2\u00b6\u00b9\5\4\3\2\u00b7\u00b9\5\32\16\2\u00b8\u00b6\3"+
		"\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\7\b\2\2\u00bb"+
		"\u00bd\5\34\17\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3"+
		"\2\2\2\u00be\u00bf\7\b\2\2\u00bf\u00c0\5\32\16\2\u00c0\u00c3\7\5\2\2\u00c1"+
		"\u00c4\5\16\b\2\u00c2\u00c4\5\n\6\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3"+
		"\2\2\2\u00c4\27\3\2\2\2\u00c5\u00c6\7;\2\2\u00c6\u00c7\5\34\17\2\u00c7"+
		"\u00c8\7\b\2\2\u00c8\31\3\2\2\2\u00c9\u00ca\5\36\20\2\u00ca\u00cb\7\7"+
		"\2\2\u00cb\u00cc\5\34\17\2\u00cc\u00d3\3\2\2\2\u00cd\u00ce\t\2\2\2\u00ce"+
		"\u00d3\5\36\20\2\u00cf\u00d0\5\36\20\2\u00d0\u00d1\t\2\2\2\u00d1\u00d3"+
		"\3\2\2\2\u00d2\u00c9\3\2\2\2\u00d2\u00cd\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d3"+
		"\33\3\2\2\2\u00d4\u00d5\b\17\1\2\u00d5\u00ee\5 \21\2\u00d6\u00ee\5\20"+
		"\t\2\u00d7\u00d8\7\4\2\2\u00d8\u00d9\5\34\17\2\u00d9\u00da\7\5\2\2\u00da"+
		"\u00ee\3\2\2\2\u00db\u00dc\t\3\2\2\u00dc\u00ee\5\34\17\17\u00dd\u00de"+
		"\7<\2\2\u00de\u00eb\5\"\22\2\u00df\u00e8\7\4\2\2\u00e0\u00e5\5\34\17\2"+
		"\u00e1\u00e2\7\t\2\2\u00e2\u00e4\5\34\17\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00e0\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00ec\7\5\2\2\u00eb\u00df\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ee\3\2\2\2\u00ed\u00d4\3\2\2\2\u00ed\u00d6\3\2\2\2\u00ed\u00d7\3\2"+
		"\2\2\u00ed\u00db\3\2\2\2\u00ed\u00dd\3\2\2\2\u00ee\u0115\3\2\2\2\u00ef"+
		"\u00f0\f\16\2\2\u00f0\u00f1\t\4\2\2\u00f1\u0114\5\34\17\17\u00f2\u00f3"+
		"\f\r\2\2\u00f3\u00f4\t\5\2\2\u00f4\u0114\5\34\17\16\u00f5\u00f6\f\f\2"+
		"\2\u00f6\u00f7\t\6\2\2\u00f7\u0114\5\34\17\r\u00f8\u00f9\f\13\2\2\u00f9"+
		"\u00fa\t\7\2\2\u00fa\u0114\5\34\17\f\u00fb\u00fc\f\n\2\2\u00fc\u00fd\t"+
		"\b\2\2\u00fd\u0114\5\34\17\13\u00fe\u00ff\f\t\2\2\u00ff\u0100\7\33\2\2"+
		"\u0100\u0114\5\34\17\n\u0101\u0102\f\b\2\2\u0102\u0103\7\34\2\2\u0103"+
		"\u0114\5\34\17\t\u0104\u0105\f\7\2\2\u0105\u0106\7\35\2\2\u0106\u0114"+
		"\5\34\17\b\u0107\u0108\f\6\2\2\u0108\u0109\7\36\2\2\u0109\u0114\5\34\17"+
		"\7\u010a\u010b\f\5\2\2\u010b\u010c\7\37\2\2\u010c\u0114\5\34\17\6\u010d"+
		"\u010e\f\4\2\2\u010e\u010f\7 \2\2\u010f\u0110\5\34\17\2\u0110\u0111\7"+
		"!\2\2\u0111\u0112\5\34\17\5\u0112\u0114\3\2\2\2\u0113\u00ef\3\2\2\2\u0113"+
		"\u00f2\3\2\2\2\u0113\u00f5\3\2\2\2\u0113\u00f8\3\2\2\2\u0113\u00fb\3\2"+
		"\2\2\u0113\u00fe\3\2\2\2\u0113\u0101\3\2\2\2\u0113\u0104\3\2\2\2\u0113"+
		"\u0107\3\2\2\2\u0113\u010a\3\2\2\2\u0113\u010d\3\2\2\2\u0114\u0117\3\2"+
		"\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\35\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0118\u0119\b\20\1\2\u0119\u011f\7(\2\2\u011a\u011b\7\4\2\2\u011b"+
		"\u011c\5\36\20\2\u011c\u011d\7\5\2\2\u011d\u011f\3\2\2\2\u011e\u0118\3"+
		"\2\2\2\u011e\u011a\3\2\2\2\u011f\u012e\3\2\2\2\u0120\u0121\f\4\2\2\u0121"+
		"\u0122\7\"\2\2\u0122\u012d\7(\2\2\u0123\u0128\f\3\2\2\u0124\u0125\7#\2"+
		"\2\u0125\u0126\5\34\17\2\u0126\u0127\7$\2\2\u0127\u0129\3\2\2\2\u0128"+
		"\u0124\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\u012d\3\2\2\2\u012c\u0120\3\2\2\2\u012c\u0123\3\2\2\2\u012d"+
		"\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\37\3\2\2"+
		"\2\u0130\u012e\3\2\2\2\u0131\u0134\5\36\20\2\u0132\u0134\5*\26\2\u0133"+
		"\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134!\3\2\2\2\u0135\u013b\5&\24\2"+
		"\u0136\u0137\7#\2\2\u0137\u0138\7)\2\2\u0138\u013a\7$\2\2\u0139\u0136"+
		"\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u0142\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\7#\2\2\u013f\u0141\7$\2"+
		"\2\u0140\u013e\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143#\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u014a\5&\24\2\u0146"+
		"\u0147\7#\2\2\u0147\u0149\7$\2\2\u0148\u0146\3\2\2\2\u0149\u014c\3\2\2"+
		"\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b%\3\2\2\2\u014c\u014a"+
		"\3\2\2\2\u014d\u014e\t\t\2\2\u014e\'\3\2\2\2\u014f\u0152\5$\23\2\u0150"+
		"\u0152\7\62\2\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u0152)\3\2\2\2"+
		"\u0153\u0154\t\n\2\2\u0154+\3\2\2\2(\61\639=ACLXbfo\u0082\u008e\u0091"+
		"\u009b\u00a3\u00a8\u00aa\u00b2\u00b8\u00bc\u00c3\u00d2\u00e5\u00e8\u00eb"+
		"\u00ed\u0113\u0115\u011e\u012a\u012c\u012e\u0133\u013b\u0142\u014a\u0151";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}