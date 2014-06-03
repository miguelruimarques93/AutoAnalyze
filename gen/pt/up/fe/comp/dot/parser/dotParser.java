// Generated from dot.g4 by ANTLR 4.1


package pt.up.fe.comp.dot.parser;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class dotParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, DIEDGE_OP=9, 
		EDGE_OP=10, STRICT=11, GRAPH=12, DIGRAPH=13, NODE=14, EDGE=15, SUBGRAPH=16, 
		ID=17, NUMERAL=18, QUOTED_STRING=19, HTML_STRING=20, COMMENT=21, LINE_COMMENT=22, 
		PREPROC=23, WS=24;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'{'", "','", "'['", "':'", "'='", "'}'", "';'", "'->'", 
		"'--'", "STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", "SUBGRAPH", "ID", 
		"NUMERAL", "QUOTED_STRING", "HTML_STRING", "COMMENT", "LINE_COMMENT", 
		"PREPROC", "WS"
	};
	public static final int
		RULE_graph = 0, RULE_stmt_list = 1, RULE_stmt = 2, RULE_attr1_stmt = 3, 
		RULE_attr_stmt = 4, RULE_attr_list = 5, RULE_a_list = 6, RULE_edge_stmt = 7, 
		RULE_node_stmt = 8, RULE_node_id = 9, RULE_port = 10, RULE_subgraph = 11, 
		RULE_id = 12;
	public static final String[] ruleNames = {
		"graph", "stmt_list", "stmt", "attr1_stmt", "attr_stmt", "attr_list", 
		"a_list", "edge_stmt", "node_stmt", "node_id", "port", "subgraph", "id"
	};

	@Override
	public String getGrammarFileName() { return "dot.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public dotParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GraphContext extends ParserRuleContext {
		public Token directed;
		public TerminalNode DIGRAPH() { return getToken(dotParser.DIGRAPH, 0); }
		public TerminalNode GRAPH() { return getToken(dotParser.GRAPH, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode STRICT() { return getToken(dotParser.STRICT, 0); }
		public GraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterGraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitGraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitGraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphContext graph() throws RecognitionException {
		GraphContext _localctx = new GraphContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_la = _input.LA(1);
			if (_la==STRICT) {
				{
				setState(26); match(STRICT);
				}
			}

			setState(29);
			((GraphContext)_localctx).directed = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==GRAPH || _la==DIGRAPH) ) {
				((GraphContext)_localctx).directed = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(31);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0)) {
				{
				setState(30); id();
				}
			}

			setState(33); match(2);
			setState(34); stmt_list();
			setState(35); match(7);
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
			if ( listener instanceof dotListener ) ((dotListener)listener).enterStmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitStmt_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitStmt_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << GRAPH) | (1L << NODE) | (1L << EDGE) | (1L << SUBGRAPH) | (1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0)) {
				{
				{
				setState(37); stmt();
				setState(39);
				_la = _input.LA(1);
				if (_la==8) {
					{
					setState(38); match(8);
					}
				}

				}
				}
				setState(45);
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
		public SubgraphContext subgraph() {
			return getRuleContext(SubgraphContext.class,0);
		}
		public Attr_stmtContext attr_stmt() {
			return getRuleContext(Attr_stmtContext.class,0);
		}
		public Edge_stmtContext edge_stmt() {
			return getRuleContext(Edge_stmtContext.class,0);
		}
		public Node_stmtContext node_stmt() {
			return getRuleContext(Node_stmtContext.class,0);
		}
		public Attr1_stmtContext attr1_stmt() {
			return getRuleContext(Attr1_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(51);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46); node_stmt();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47); edge_stmt();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48); attr_stmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(49); attr1_stmt();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(50); subgraph();
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

	public static class Attr1_stmtContext extends ParserRuleContext {
		public IdContext lhs;
		public IdContext rhs;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Attr1_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr1_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterAttr1_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitAttr1_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitAttr1_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr1_stmtContext attr1_stmt() throws RecognitionException {
		Attr1_stmtContext _localctx = new Attr1_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attr1_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); ((Attr1_stmtContext)_localctx).lhs = id();
			setState(54); match(6);
			setState(55); ((Attr1_stmtContext)_localctx).rhs = id();
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

	public static class Attr_stmtContext extends ParserRuleContext {
		public Attr_listContext attributes;
		public TerminalNode GRAPH() { return getToken(dotParser.GRAPH, 0); }
		public TerminalNode EDGE() { return getToken(dotParser.EDGE, 0); }
		public TerminalNode NODE() { return getToken(dotParser.NODE, 0); }
		public Attr_listContext attr_list() {
			return getRuleContext(Attr_listContext.class,0);
		}
		public Attr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterAttr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitAttr_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitAttr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_stmtContext attr_stmt() throws RecognitionException {
		Attr_stmtContext _localctx = new Attr_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attr_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << NODE) | (1L << EDGE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(58); ((Attr_stmtContext)_localctx).attributes = attr_list();
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

	public static class Attr_listContext extends ParserRuleContext {
		public A_listContext a_list(int i) {
			return getRuleContext(A_listContext.class,i);
		}
		public List<A_listContext> a_list() {
			return getRuleContexts(A_listContext.class);
		}
		public Attr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterAttr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitAttr_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitAttr_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_listContext attr_list() throws RecognitionException {
		Attr_listContext _localctx = new Attr_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60); match(4);
				setState(62);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0)) {
					{
					setState(61); a_list();
					}
				}

				setState(64); match(1);
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==4 );
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

	public static class A_listContext extends ParserRuleContext {
		public IdContext lhs;
		public IdContext rhs;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public A_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterA_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitA_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitA_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final A_listContext a_list() throws RecognitionException {
		A_listContext _localctx = new A_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_a_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69); ((A_listContext)_localctx).lhs = id();
				setState(70); match(6);
				setState(71); ((A_listContext)_localctx).rhs = id();
				setState(73);
				_la = _input.LA(1);
				if (_la==3 || _la==8) {
					{
					setState(72);
					_la = _input.LA(1);
					if ( !(_la==3 || _la==8) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0) );
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

	public static class Edge_stmtContext extends ParserRuleContext {
		public Node_idContext lhs;
		public Token op;
		public Node_idContext rhs;
		public Attr_listContext attributes;
		public TerminalNode EDGE_OP() { return getToken(dotParser.EDGE_OP, 0); }
		public TerminalNode DIEDGE_OP() { return getToken(dotParser.DIEDGE_OP, 0); }
		public Node_idContext node_id(int i) {
			return getRuleContext(Node_idContext.class,i);
		}
		public List<Node_idContext> node_id() {
			return getRuleContexts(Node_idContext.class);
		}
		public Attr_listContext attr_list() {
			return getRuleContext(Attr_listContext.class,0);
		}
		public Edge_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterEdge_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitEdge_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitEdge_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Edge_stmtContext edge_stmt() throws RecognitionException {
		Edge_stmtContext _localctx = new Edge_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_edge_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); ((Edge_stmtContext)_localctx).lhs = node_id();
			setState(80);
			((Edge_stmtContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==DIEDGE_OP || _la==EDGE_OP) ) {
				((Edge_stmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(81); ((Edge_stmtContext)_localctx).rhs = node_id();
			setState(83);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(82); ((Edge_stmtContext)_localctx).attributes = attr_list();
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

	public static class Node_stmtContext extends ParserRuleContext {
		public Node_idContext node_id() {
			return getRuleContext(Node_idContext.class,0);
		}
		public Attr_listContext attr_list() {
			return getRuleContext(Attr_listContext.class,0);
		}
		public Node_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterNode_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitNode_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitNode_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Node_stmtContext node_stmt() throws RecognitionException {
		Node_stmtContext _localctx = new Node_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_node_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); node_id();
			setState(87);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(86); attr_list();
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

	public static class Node_idContext extends ParserRuleContext {
		public PortContext port() {
			return getRuleContext(PortContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Node_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterNode_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitNode_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitNode_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Node_idContext node_id() throws RecognitionException {
		Node_idContext _localctx = new Node_idContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_node_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); id();
			setState(91);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(90); port();
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

	public static class PortContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterPort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitPort(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitPort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); match(5);
			setState(94); id();
			setState(97);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(95); match(5);
				setState(96); id();
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

	public static class SubgraphContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode SUBGRAPH() { return getToken(dotParser.SUBGRAPH, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public SubgraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subgraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterSubgraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitSubgraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitSubgraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubgraphContext subgraph() throws RecognitionException {
		SubgraphContext _localctx = new SubgraphContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_subgraph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_la = _input.LA(1);
			if (_la==SUBGRAPH) {
				{
				setState(99); match(SUBGRAPH);
				setState(101);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0)) {
					{
					setState(100); id();
					}
				}

				}
			}

			setState(105); match(2);
			setState(106); stmt_list();
			setState(107); match(7);
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode NUMERAL() { return getToken(dotParser.NUMERAL, 0); }
		public TerminalNode QUOTED_STRING() { return getToken(dotParser.QUOTED_STRING, 0); }
		public TerminalNode ID() { return getToken(dotParser.ID, 0); }
		public TerminalNode HTML_STRING() { return getToken(dotParser.HTML_STRING, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\32r\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\5\2\36\n\2\3\2\3\2\5\2\"\n\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\5\3*\n\3\7\3,\n\3\f\3\16\3/\13\3\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\66\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\5\7A\n\7\3\7\6\7D\n\7\r\7"+
		"\16\7E\3\b\3\b\3\b\3\b\5\bL\n\b\6\bN\n\b\r\b\16\bO\3\t\3\t\3\t\3\t\5\t"+
		"V\n\t\3\n\3\n\5\nZ\n\n\3\13\3\13\5\13^\n\13\3\f\3\f\3\f\3\f\5\fd\n\f\3"+
		"\r\3\r\5\rh\n\r\5\rj\n\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\2\17\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\2\7\3\2\16\17\4\2\16\16\20\21\4\2\5\5\n\n\3\2"+
		"\13\f\3\2\23\26v\2\35\3\2\2\2\4-\3\2\2\2\6\65\3\2\2\2\b\67\3\2\2\2\n;"+
		"\3\2\2\2\fC\3\2\2\2\16M\3\2\2\2\20Q\3\2\2\2\22W\3\2\2\2\24[\3\2\2\2\26"+
		"_\3\2\2\2\30i\3\2\2\2\32o\3\2\2\2\34\36\7\r\2\2\35\34\3\2\2\2\35\36\3"+
		"\2\2\2\36\37\3\2\2\2\37!\t\2\2\2 \"\5\32\16\2! \3\2\2\2!\"\3\2\2\2\"#"+
		"\3\2\2\2#$\7\4\2\2$%\5\4\3\2%&\7\t\2\2&\3\3\2\2\2\')\5\6\4\2(*\7\n\2\2"+
		")(\3\2\2\2)*\3\2\2\2*,\3\2\2\2+\'\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2"+
		"\2.\5\3\2\2\2/-\3\2\2\2\60\66\5\22\n\2\61\66\5\20\t\2\62\66\5\n\6\2\63"+
		"\66\5\b\5\2\64\66\5\30\r\2\65\60\3\2\2\2\65\61\3\2\2\2\65\62\3\2\2\2\65"+
		"\63\3\2\2\2\65\64\3\2\2\2\66\7\3\2\2\2\678\5\32\16\289\7\b\2\29:\5\32"+
		"\16\2:\t\3\2\2\2;<\t\3\2\2<=\5\f\7\2=\13\3\2\2\2>@\7\6\2\2?A\5\16\b\2"+
		"@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2BD\7\3\2\2C>\3\2\2\2DE\3\2\2\2EC\3\2\2\2"+
		"EF\3\2\2\2F\r\3\2\2\2GH\5\32\16\2HI\7\b\2\2IK\5\32\16\2JL\t\4\2\2KJ\3"+
		"\2\2\2KL\3\2\2\2LN\3\2\2\2MG\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\17"+
		"\3\2\2\2QR\5\24\13\2RS\t\5\2\2SU\5\24\13\2TV\5\f\7\2UT\3\2\2\2UV\3\2\2"+
		"\2V\21\3\2\2\2WY\5\24\13\2XZ\5\f\7\2YX\3\2\2\2YZ\3\2\2\2Z\23\3\2\2\2["+
		"]\5\32\16\2\\^\5\26\f\2]\\\3\2\2\2]^\3\2\2\2^\25\3\2\2\2_`\7\7\2\2`c\5"+
		"\32\16\2ab\7\7\2\2bd\5\32\16\2ca\3\2\2\2cd\3\2\2\2d\27\3\2\2\2eg\7\22"+
		"\2\2fh\5\32\16\2gf\3\2\2\2gh\3\2\2\2hj\3\2\2\2ie\3\2\2\2ij\3\2\2\2jk\3"+
		"\2\2\2kl\7\4\2\2lm\5\4\3\2mn\7\t\2\2n\31\3\2\2\2op\t\6\2\2p\33\3\2\2\2"+
		"\21\35!)-\65@EKOUY]cgi";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}