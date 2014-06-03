// Generated from aa.g4 by ANTLR 4.1


package pt.up.fe.comp.aa.parser;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class aaParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, IDENTIFIER=3, STRING=4, OPEN_PR=5, CLOSE_PR=6, OPEN_BR=7, 
		CLOSE_BR=8, EQUAL=9, SEMICOLON=10, WS=11, COMMENT=12, LINE_COMMENT=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'if'", "'else'", "IDENTIFIER", "STRING", "'('", "')'", "'{'", 
		"'}'", "'='", "';'", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_stmt_list = 0, RULE_stmt = 1, RULE_attribution = 2, RULE_attribution_lhs = 3, 
		RULE_attribution_rhs = 4, RULE_operation = 5, RULE_control_expr = 6, RULE_arg_list = 7, 
		RULE_arg = 8;
	public static final String[] ruleNames = {
		"stmt_list", "stmt", "attribution", "attribution_lhs", "attribution_rhs", 
		"operation", "control_expr", "arg_list", "arg"
	};

	@Override
	public String getGrammarFileName() { return "aa.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public aaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Stmt_listContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).enterStmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).exitStmt_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof aaVisitor ) return ((aaVisitor<? extends T>)visitor).visitStmt_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stmt_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IF || _la==IDENTIFIER) {
				{
				{
				setState(18); stmt();
				}
				}
				setState(23);
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
		public AttributionContext attribution() {
			return getRuleContext(AttributionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(aaParser.EOF, 0); }
		public TerminalNode SEMICOLON() { return getToken(aaParser.SEMICOLON, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public Control_exprContext control_expr() {
			return getRuleContext(Control_exprContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof aaVisitor ) return ((aaVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				{
				setState(26);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(24); attribution();
					}
					break;

				case 2:
					{
					setState(25); operation();
					}
					break;
				}
				setState(28);
				_la = _input.LA(1);
				if ( !(_la==EOF || _la==SEMICOLON) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				break;
			case IF:
				{
				setState(30); control_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AttributionContext extends ParserRuleContext {
		public Attribution_rhsContext attribution_rhs() {
			return getRuleContext(Attribution_rhsContext.class,0);
		}
		public Attribution_lhsContext attribution_lhs() {
			return getRuleContext(Attribution_lhsContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(aaParser.EQUAL, 0); }
		public AttributionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).enterAttribution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).exitAttribution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof aaVisitor ) return ((aaVisitor<? extends T>)visitor).visitAttribution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributionContext attribution() throws RecognitionException {
		AttributionContext _localctx = new AttributionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_attribution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); attribution_lhs();
			setState(34); match(EQUAL);
			setState(35); attribution_rhs();
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

	public static class Attribution_lhsContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(aaParser.IDENTIFIER, 0); }
		public Attribution_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribution_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).enterAttribution_lhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).exitAttribution_lhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof aaVisitor ) return ((aaVisitor<? extends T>)visitor).visitAttribution_lhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribution_lhsContext attribution_lhs() throws RecognitionException {
		Attribution_lhsContext _localctx = new Attribution_lhsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attribution_lhs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); match(IDENTIFIER);
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

	public static class Attribution_rhsContext extends ParserRuleContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(aaParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(aaParser.STRING, 0); }
		public Attribution_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribution_rhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).enterAttribution_rhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).exitAttribution_rhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof aaVisitor ) return ((aaVisitor<? extends T>)visitor).visitAttribution_rhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribution_rhsContext attribution_rhs() throws RecognitionException {
		Attribution_rhsContext _localctx = new Attribution_rhsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attribution_rhs);
		try {
			setState(42);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39); match(IDENTIFIER);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40); operation();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41); match(STRING);
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

	public static class OperationContext extends ParserRuleContext {
		public Token operator;
		public TerminalNode IDENTIFIER() { return getToken(aaParser.IDENTIFIER, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof aaVisitor ) return ((aaVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); ((OperationContext)_localctx).operator = match(IDENTIFIER);
			setState(45); arg_list();
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

	public static class Control_exprContext extends ParserRuleContext {
		public OperationContext predicate;
		public Stmt_listContext trueCase;
		public Stmt_listContext falseCase;
		public TerminalNode IF() { return getToken(aaParser.IF, 0); }
		public List<Stmt_listContext> stmt_list() {
			return getRuleContexts(Stmt_listContext.class);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode CLOSE_BR(int i) {
			return getToken(aaParser.CLOSE_BR, i);
		}
		public TerminalNode ELSE() { return getToken(aaParser.ELSE, 0); }
		public Stmt_listContext stmt_list(int i) {
			return getRuleContext(Stmt_listContext.class,i);
		}
		public List<TerminalNode> CLOSE_BR() { return getTokens(aaParser.CLOSE_BR); }
		public TerminalNode CLOSE_PR() { return getToken(aaParser.CLOSE_PR, 0); }
		public TerminalNode OPEN_BR(int i) {
			return getToken(aaParser.OPEN_BR, i);
		}
		public List<TerminalNode> OPEN_BR() { return getTokens(aaParser.OPEN_BR); }
		public TerminalNode OPEN_PR() { return getToken(aaParser.OPEN_PR, 0); }
		public Control_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).enterControl_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).exitControl_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof aaVisitor ) return ((aaVisitor<? extends T>)visitor).visitControl_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Control_exprContext control_expr() throws RecognitionException {
		Control_exprContext _localctx = new Control_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_control_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); match(IF);
			setState(48); match(OPEN_PR);
			setState(49); ((Control_exprContext)_localctx).predicate = operation();
			setState(50); match(CLOSE_PR);
			setState(51); match(OPEN_BR);
			setState(52); ((Control_exprContext)_localctx).trueCase = stmt_list();
			setState(53); match(CLOSE_BR);
			setState(59);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(54); match(ELSE);
				setState(55); match(OPEN_BR);
				setState(56); ((Control_exprContext)_localctx).falseCase = stmt_list();
				setState(57); match(CLOSE_BR);
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

	public static class Arg_listContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).enterArg_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).exitArg_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof aaVisitor ) return ((aaVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << STRING) | (1L << OPEN_PR))) != 0)) {
				{
				{
				setState(61); arg();
				}
				}
				setState(66);
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

	public static class ArgContext extends ParserRuleContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(aaParser.IDENTIFIER, 0); }
		public TerminalNode CLOSE_PR() { return getToken(aaParser.CLOSE_PR, 0); }
		public TerminalNode OPEN_PR() { return getToken(aaParser.OPEN_PR, 0); }
		public TerminalNode STRING() { return getToken(aaParser.STRING, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aaListener ) ((aaListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof aaVisitor ) return ((aaVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arg);
		try {
			setState(73);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(67); match(IDENTIFIER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(68); match(STRING);
				}
				break;
			case OPEN_PR:
				enterOuterAlt(_localctx, 3);
				{
				setState(69); match(OPEN_PR);
				setState(70); operation();
				setState(71); match(CLOSE_PR);
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\17N\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\3\3\3\5\3\35\n\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\6\5\6-\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b>\n\b\3\t\7\tA\n\t\f\t\16\tD\13\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\nL\n\n\3\n\2\13\2\4\6\b\n\f\16\20\22\2\3\3\3\f"+
		"\fM\2\27\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b\'\3\2\2\2\n,\3\2\2\2\f.\3\2\2"+
		"\2\16\61\3\2\2\2\20B\3\2\2\2\22K\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26"+
		"\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\3\3\2\2\2\31\27\3\2\2\2\32"+
		"\35\5\6\4\2\33\35\5\f\7\2\34\32\3\2\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36"+
		"\37\t\2\2\2\37\"\3\2\2\2 \"\5\16\b\2!\34\3\2\2\2! \3\2\2\2\"\5\3\2\2\2"+
		"#$\5\b\5\2$%\7\13\2\2%&\5\n\6\2&\7\3\2\2\2\'(\7\5\2\2(\t\3\2\2\2)-\7\5"+
		"\2\2*-\5\f\7\2+-\7\6\2\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\13\3\2\2\2./\7"+
		"\5\2\2/\60\5\20\t\2\60\r\3\2\2\2\61\62\7\3\2\2\62\63\7\7\2\2\63\64\5\f"+
		"\7\2\64\65\7\b\2\2\65\66\7\t\2\2\66\67\5\2\2\2\67=\7\n\2\289\7\4\2\29"+
		":\7\t\2\2:;\5\2\2\2;<\7\n\2\2<>\3\2\2\2=8\3\2\2\2=>\3\2\2\2>\17\3\2\2"+
		"\2?A\5\22\n\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\21\3\2\2\2DB\3"+
		"\2\2\2EL\7\5\2\2FL\7\6\2\2GH\7\7\2\2HI\5\f\7\2IJ\7\b\2\2JL\3\2\2\2KE\3"+
		"\2\2\2KF\3\2\2\2KG\3\2\2\2L\23\3\2\2\2\t\27\34!,=BK";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}