// Generated from dot.g4 by ANTLR 4.1
package dot;
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
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, STRICT=21, GRAPH=22, DIGRAPH=23, NODE=24, 
		EDGE=25, SUBGRAPH=26, ID=27, NUMERAL=28, QUOTED_STRING=29, HTML_STRING=30, 
		COMMENT=31, LINE_COMMENT=32, PREPROC=33, WS=34;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "','", "'_'", "'-'", "'['", "':'", "'c'", "'s'", "'ne'", 
		"'='", "'w'", "';'", "'e'", "'>'", "'{'", "'se'", "'n'", "'nw'", "'}'", 
		"'sw'", "STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", "SUBGRAPH", "ID", 
		"NUMERAL", "QUOTED_STRING", "HTML_STRING", "COMMENT", "LINE_COMMENT", 
		"PREPROC", "WS"
	};
	public static final int
		RULE_graph = 0, RULE_stmt_list = 1, RULE_stmt = 2, RULE_attr_stmt = 3, 
		RULE_attr_list = 4, RULE_a_list = 5, RULE_edgeop = 6, RULE_edge_stmt = 7, 
		RULE_edgeRHS = 8, RULE_node_stmt = 9, RULE_node_id = 10, RULE_port = 11, 
		RULE_subgraph = 12, RULE_compass_pt = 13, RULE_id = 14;
	public static final String[] ruleNames = {
		"graph", "stmt_list", "stmt", "attr_stmt", "attr_list", "a_list", "edgeop", 
		"edge_stmt", "edgeRHS", "node_stmt", "node_id", "port", "subgraph", "compass_pt", 
		"id"
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
		public TerminalNode DIGRAPH() { return getToken(dotParser.DIGRAPH, 0); }
		public TerminalNode GRAPH() { return getToken(dotParser.GRAPH, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode ID() { return getToken(dotParser.ID, 0); }
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
			setState(31);
			_la = _input.LA(1);
			if (_la==STRICT) {
				{
				setState(30); match(STRICT);
				}
			}

			setState(33);
			_la = _input.LA(1);
			if ( !(_la==GRAPH || _la==DIGRAPH) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(35);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(34); match(ID);
				}
			}

			setState(37); match(15);
			setState(38); stmt_list();
			setState(39); match(19);
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
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << GRAPH) | (1L << NODE) | (1L << EDGE) | (1L << SUBGRAPH) | (1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0)) {
				{
				{
				setState(41); stmt();
				setState(43);
				_la = _input.LA(1);
				if (_la==12) {
					{
					setState(42); match(12);
					}
				}

				}
				}
				setState(49);
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
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
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
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
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
			setState(58);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50); node_stmt();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51); edge_stmt();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(52); attr_stmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(53); id();
				setState(54); match(10);
				setState(55); id();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(57); subgraph();
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

	public static class Attr_stmtContext extends ParserRuleContext {
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
		enterRule(_localctx, 6, RULE_attr_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << NODE) | (1L << EDGE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(61); attr_list();
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
		public Attr_listContext attr_list() {
			return getRuleContext(Attr_listContext.class,0);
		}
		public A_listContext a_list() {
			return getRuleContext(A_listContext.class,0);
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
		enterRule(_localctx, 8, RULE_attr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); match(5);
			setState(65);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0)) {
				{
				setState(64); a_list();
				}
			}

			setState(67); match(1);
			setState(69);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(68); attr_list();
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

	public static class A_listContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public A_listContext a_list() {
			return getRuleContext(A_listContext.class,0);
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
		enterRule(_localctx, 10, RULE_a_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); id();
			setState(72); match(10);
			setState(73); id();
			setState(75);
			_la = _input.LA(1);
			if (_la==2 || _la==12) {
				{
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==2 || _la==12) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(78);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0)) {
				{
				setState(77); a_list();
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

	public static class EdgeopContext extends ParserRuleContext {
		public EdgeopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterEdgeop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitEdgeop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitEdgeop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeopContext edgeop() throws RecognitionException {
		EdgeopContext _localctx = new EdgeopContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_edgeop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(4);
			setState(81);
			_la = _input.LA(1);
			if ( !(_la==4 || _la==14) ) {
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

	public static class Edge_stmtContext extends ParserRuleContext {
		public SubgraphContext subgraph() {
			return getRuleContext(SubgraphContext.class,0);
		}
		public Node_idContext node_id() {
			return getRuleContext(Node_idContext.class,0);
		}
		public EdgeRHSContext edgeRHS() {
			return getRuleContext(EdgeRHSContext.class,0);
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
			setState(85);
			switch (_input.LA(1)) {
			case ID:
			case NUMERAL:
			case QUOTED_STRING:
			case HTML_STRING:
				{
				setState(83); node_id();
				}
				break;
			case 15:
			case SUBGRAPH:
				{
				setState(84); subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(87); edgeRHS();
			setState(89);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(88); attr_list();
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

	public static class EdgeRHSContext extends ParserRuleContext {
		public SubgraphContext subgraph() {
			return getRuleContext(SubgraphContext.class,0);
		}
		public EdgeopContext edgeop() {
			return getRuleContext(EdgeopContext.class,0);
		}
		public Node_idContext node_id() {
			return getRuleContext(Node_idContext.class,0);
		}
		public EdgeRHSContext edgeRHS() {
			return getRuleContext(EdgeRHSContext.class,0);
		}
		public EdgeRHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeRHS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterEdgeRHS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitEdgeRHS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitEdgeRHS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeRHSContext edgeRHS() throws RecognitionException {
		EdgeRHSContext _localctx = new EdgeRHSContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_edgeRHS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); edgeop();
			setState(94);
			switch (_input.LA(1)) {
			case ID:
			case NUMERAL:
			case QUOTED_STRING:
			case HTML_STRING:
				{
				setState(92); node_id();
				}
				break;
			case 15:
			case SUBGRAPH:
				{
				setState(93); subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(97);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(96); edgeRHS();
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
		enterRule(_localctx, 18, RULE_node_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); node_id();
			setState(101);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(100); attr_list();
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
		enterRule(_localctx, 20, RULE_node_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103); id();
			setState(105);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(104); port();
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
		public Compass_ptContext compass_pt() {
			return getRuleContext(Compass_ptContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
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
		enterRule(_localctx, 22, RULE_port);
		int _la;
		try {
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107); match(6);
				setState(108); id();
				setState(111);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(109); match(6);
					setState(110); compass_pt();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113); match(6);
				setState(114); compass_pt();
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
		enterRule(_localctx, 24, RULE_subgraph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if (_la==SUBGRAPH) {
				{
				setState(117); match(SUBGRAPH);
				setState(119);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMERAL) | (1L << QUOTED_STRING) | (1L << HTML_STRING))) != 0)) {
					{
					setState(118); id();
					}
				}

				}
			}

			setState(123); match(15);
			setState(124); stmt_list();
			setState(125); match(19);
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

	public static class Compass_ptContext extends ParserRuleContext {
		public Compass_ptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compass_pt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).enterCompass_pt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dotListener ) ((dotListener)listener).exitCompass_pt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dotVisitor ) return ((dotVisitor<? extends T>)visitor).visitCompass_pt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compass_ptContext compass_pt() throws RecognitionException {
		Compass_ptContext _localctx = new Compass_ptContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_compass_pt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 20))) != 0)) ) {
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
		enterRule(_localctx, 28, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3$\u0086\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\5\2\"\n\2\3\2\3"+
		"\2\5\2&\n\2\3\2\3\2\3\2\3\2\3\3\3\3\5\3.\n\3\7\3\60\n\3\f\3\16\3\63\13"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\5\3\5\3\5\3\6\3\6\5\6D\n"+
		"\6\3\6\3\6\5\6H\n\6\3\7\3\7\3\7\3\7\5\7N\n\7\3\7\5\7Q\n\7\3\b\3\b\3\b"+
		"\3\t\3\t\5\tX\n\t\3\t\3\t\5\t\\\n\t\3\n\3\n\3\n\5\na\n\n\3\n\5\nd\n\n"+
		"\3\13\3\13\5\13h\n\13\3\f\3\f\5\fl\n\f\3\r\3\r\3\r\3\r\5\rr\n\r\3\r\3"+
		"\r\5\rv\n\r\3\16\3\16\5\16z\n\16\5\16|\n\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\20\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\b\3\2"+
		"\30\31\4\2\30\30\32\33\4\2\4\4\16\16\4\2\6\6\20\20\b\2\5\5\t\13\r\r\17"+
		"\17\22\24\26\26\3\2\35 \u008c\2!\3\2\2\2\4\61\3\2\2\2\6<\3\2\2\2\b>\3"+
		"\2\2\2\nA\3\2\2\2\fI\3\2\2\2\16R\3\2\2\2\20W\3\2\2\2\22]\3\2\2\2\24e\3"+
		"\2\2\2\26i\3\2\2\2\30u\3\2\2\2\32{\3\2\2\2\34\u0081\3\2\2\2\36\u0083\3"+
		"\2\2\2 \"\7\27\2\2! \3\2\2\2!\"\3\2\2\2\"#\3\2\2\2#%\t\2\2\2$&\7\35\2"+
		"\2%$\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\7\21\2\2()\5\4\3\2)*\7\25\2\2*\3"+
		"\3\2\2\2+-\5\6\4\2,.\7\16\2\2-,\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/+\3\2\2"+
		"\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\5\3\2\2\2\63\61\3\2\2\2"+
		"\64=\5\24\13\2\65=\5\20\t\2\66=\5\b\5\2\678\5\36\20\289\7\f\2\29:\5\36"+
		"\20\2:=\3\2\2\2;=\5\32\16\2<\64\3\2\2\2<\65\3\2\2\2<\66\3\2\2\2<\67\3"+
		"\2\2\2<;\3\2\2\2=\7\3\2\2\2>?\t\3\2\2?@\5\n\6\2@\t\3\2\2\2AC\7\7\2\2B"+
		"D\5\f\7\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EG\7\3\2\2FH\5\n\6\2GF\3\2\2\2"+
		"GH\3\2\2\2H\13\3\2\2\2IJ\5\36\20\2JK\7\f\2\2KM\5\36\20\2LN\t\4\2\2ML\3"+
		"\2\2\2MN\3\2\2\2NP\3\2\2\2OQ\5\f\7\2PO\3\2\2\2PQ\3\2\2\2Q\r\3\2\2\2RS"+
		"\7\6\2\2ST\t\5\2\2T\17\3\2\2\2UX\5\26\f\2VX\5\32\16\2WU\3\2\2\2WV\3\2"+
		"\2\2XY\3\2\2\2Y[\5\22\n\2Z\\\5\n\6\2[Z\3\2\2\2[\\\3\2\2\2\\\21\3\2\2\2"+
		"]`\5\16\b\2^a\5\26\f\2_a\5\32\16\2`^\3\2\2\2`_\3\2\2\2ac\3\2\2\2bd\5\22"+
		"\n\2cb\3\2\2\2cd\3\2\2\2d\23\3\2\2\2eg\5\26\f\2fh\5\n\6\2gf\3\2\2\2gh"+
		"\3\2\2\2h\25\3\2\2\2ik\5\36\20\2jl\5\30\r\2kj\3\2\2\2kl\3\2\2\2l\27\3"+
		"\2\2\2mn\7\b\2\2nq\5\36\20\2op\7\b\2\2pr\5\34\17\2qo\3\2\2\2qr\3\2\2\2"+
		"rv\3\2\2\2st\7\b\2\2tv\5\34\17\2um\3\2\2\2us\3\2\2\2v\31\3\2\2\2wy\7\34"+
		"\2\2xz\5\36\20\2yx\3\2\2\2yz\3\2\2\2z|\3\2\2\2{w\3\2\2\2{|\3\2\2\2|}\3"+
		"\2\2\2}~\7\21\2\2~\177\5\4\3\2\177\u0080\7\25\2\2\u0080\33\3\2\2\2\u0081"+
		"\u0082\t\6\2\2\u0082\35\3\2\2\2\u0083\u0084\t\7\2\2\u0084\37\3\2\2\2\25"+
		"!%-\61<CGMPW[`cgkquy{";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}