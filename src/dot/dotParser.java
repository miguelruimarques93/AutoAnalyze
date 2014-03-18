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
		EDGE=25, SUBGRAPH=26, ID=27, COMMENT=28, LINE_COMMENT=29, PREPROC=30, 
		WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "','", "'_'", "'-'", "'['", "':'", "'c'", "'s'", "'ne'", 
		"'='", "'w'", "';'", "'e'", "'>'", "'{'", "'se'", "'n'", "'nw'", "'}'", 
		"'sw'", "STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", "SUBGRAPH", "'ABC'", 
		"COMMENT", "LINE_COMMENT", "PREPROC", "WS"
	};
	public static final int
		RULE_graph = 0, RULE_stmt_list = 1, RULE_stmt = 2, RULE_attr_stmt = 3, 
		RULE_attr_list = 4, RULE_a_list = 5, RULE_edgeop = 6, RULE_edge_stmt = 7, 
		RULE_edgeRHS = 8, RULE_node_stmt = 9, RULE_node_id = 10, RULE_port = 11, 
		RULE_subgraph = 12, RULE_compass_pt = 13;
	public static final String[] ruleNames = {
		"graph", "stmt_list", "stmt", "attr_stmt", "attr_list", "a_list", "edgeop", 
		"edge_stmt", "edgeRHS", "node_stmt", "node_id", "port", "subgraph", "compass_pt"
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
			setState(29);
			_la = _input.LA(1);
			if (_la==STRICT) {
				{
				setState(28); match(STRICT);
				}
			}

			setState(31);
			_la = _input.LA(1);
			if ( !(_la==GRAPH || _la==DIGRAPH) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(33);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(32); match(ID);
				}
			}

			setState(35); match(15);
			setState(36); stmt_list();
			setState(37); match(19);
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
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << GRAPH) | (1L << NODE) | (1L << EDGE) | (1L << SUBGRAPH) | (1L << ID))) != 0)) {
				{
				{
				setState(39); stmt();
				setState(41);
				_la = _input.LA(1);
				if (_la==12) {
					{
					setState(40); match(12);
					}
				}

				}
				}
				setState(47);
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
		public List<TerminalNode> ID() { return getTokens(dotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(dotParser.ID, i);
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
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48); node_stmt();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49); edge_stmt();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50); attr_stmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(51); match(ID);
				setState(52); match(10);
				setState(53); match(ID);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(54); subgraph();
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
			setState(57);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << NODE) | (1L << EDGE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(58); attr_list();
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
			setState(60); match(5);
			setState(62);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(61); a_list();
				}
			}

			setState(64); match(1);
			setState(66);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(65); attr_list();
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
		public List<TerminalNode> ID() { return getTokens(dotParser.ID); }
		public A_listContext a_list() {
			return getRuleContext(A_listContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(dotParser.ID, i);
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
			setState(68); match(ID);
			setState(69); match(10);
			setState(70); match(ID);
			setState(72);
			_la = _input.LA(1);
			if (_la==2 || _la==12) {
				{
				setState(71);
				_la = _input.LA(1);
				if ( !(_la==2 || _la==12) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(75);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(74); a_list();
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
			setState(77); match(4);
			setState(78);
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
			setState(82);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(80); node_id();
				}
				break;
			case 15:
			case SUBGRAPH:
				{
				setState(81); subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(84); edgeRHS();
			setState(86);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(85); attr_list();
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
			setState(88); edgeop();
			setState(91);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(89); node_id();
				}
				break;
			case 15:
			case SUBGRAPH:
				{
				setState(90); subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(94);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(93); edgeRHS();
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
			setState(96); node_id();
			setState(98);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(97); attr_list();
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
		public TerminalNode ID() { return getToken(dotParser.ID, 0); }
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
			setState(100); match(ID);
			setState(102);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(101); port();
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
		public TerminalNode ID() { return getToken(dotParser.ID, 0); }
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
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104); match(6);
				setState(105); match(ID);
				setState(108);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(106); match(6);
					setState(107); compass_pt();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110); match(6);
				setState(111); compass_pt();
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
		public TerminalNode SUBGRAPH() { return getToken(dotParser.SUBGRAPH, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode ID() { return getToken(dotParser.ID, 0); }
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
			setState(118);
			_la = _input.LA(1);
			if (_la==SUBGRAPH) {
				{
				setState(114); match(SUBGRAPH);
				setState(116);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(115); match(ID);
					}
				}

				}
			}

			setState(120); match(15);
			setState(121); stmt_list();
			setState(122); match(19);
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
			setState(124);
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3!\u0081\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\5\2 \n\2\3\2\3\2\5\2$\n\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\5\3,\n\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\6\3\6\5\6A\n\6\3\6\3\6\5\6E"+
		"\n\6\3\7\3\7\3\7\3\7\5\7K\n\7\3\7\5\7N\n\7\3\b\3\b\3\b\3\t\3\t\5\tU\n"+
		"\t\3\t\3\t\5\tY\n\t\3\n\3\n\3\n\5\n^\n\n\3\n\5\na\n\n\3\13\3\13\5\13e"+
		"\n\13\3\f\3\f\5\fi\n\f\3\r\3\r\3\r\3\r\5\ro\n\r\3\r\3\r\5\rs\n\r\3\16"+
		"\3\16\5\16w\n\16\5\16y\n\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\2\20\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\2\7\3\2\30\31\4\2\30\30\32\33\4\2\4"+
		"\4\16\16\4\2\6\6\20\20\b\2\5\5\t\13\r\r\17\17\22\24\26\26\u0088\2\37\3"+
		"\2\2\2\4/\3\2\2\2\69\3\2\2\2\b;\3\2\2\2\n>\3\2\2\2\fF\3\2\2\2\16O\3\2"+
		"\2\2\20T\3\2\2\2\22Z\3\2\2\2\24b\3\2\2\2\26f\3\2\2\2\30r\3\2\2\2\32x\3"+
		"\2\2\2\34~\3\2\2\2\36 \7\27\2\2\37\36\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!#"+
		"\t\2\2\2\"$\7\35\2\2#\"\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\7\21\2\2&\'\5\4"+
		"\3\2\'(\7\25\2\2(\3\3\2\2\2)+\5\6\4\2*,\7\16\2\2+*\3\2\2\2+,\3\2\2\2,"+
		".\3\2\2\2-)\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61"+
		"/\3\2\2\2\62:\5\24\13\2\63:\5\20\t\2\64:\5\b\5\2\65\66\7\35\2\2\66\67"+
		"\7\f\2\2\67:\7\35\2\28:\5\32\16\29\62\3\2\2\29\63\3\2\2\29\64\3\2\2\2"+
		"9\65\3\2\2\298\3\2\2\2:\7\3\2\2\2;<\t\3\2\2<=\5\n\6\2=\t\3\2\2\2>@\7\7"+
		"\2\2?A\5\f\7\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2BD\7\3\2\2CE\5\n\6\2DC\3\2"+
		"\2\2DE\3\2\2\2E\13\3\2\2\2FG\7\35\2\2GH\7\f\2\2HJ\7\35\2\2IK\t\4\2\2J"+
		"I\3\2\2\2JK\3\2\2\2KM\3\2\2\2LN\5\f\7\2ML\3\2\2\2MN\3\2\2\2N\r\3\2\2\2"+
		"OP\7\6\2\2PQ\t\5\2\2Q\17\3\2\2\2RU\5\26\f\2SU\5\32\16\2TR\3\2\2\2TS\3"+
		"\2\2\2UV\3\2\2\2VX\5\22\n\2WY\5\n\6\2XW\3\2\2\2XY\3\2\2\2Y\21\3\2\2\2"+
		"Z]\5\16\b\2[^\5\26\f\2\\^\5\32\16\2][\3\2\2\2]\\\3\2\2\2^`\3\2\2\2_a\5"+
		"\22\n\2`_\3\2\2\2`a\3\2\2\2a\23\3\2\2\2bd\5\26\f\2ce\5\n\6\2dc\3\2\2\2"+
		"de\3\2\2\2e\25\3\2\2\2fh\7\35\2\2gi\5\30\r\2hg\3\2\2\2hi\3\2\2\2i\27\3"+
		"\2\2\2jk\7\b\2\2kn\7\35\2\2lm\7\b\2\2mo\5\34\17\2nl\3\2\2\2no\3\2\2\2"+
		"os\3\2\2\2pq\7\b\2\2qs\5\34\17\2rj\3\2\2\2rp\3\2\2\2s\31\3\2\2\2tv\7\34"+
		"\2\2uw\7\35\2\2vu\3\2\2\2vw\3\2\2\2wy\3\2\2\2xt\3\2\2\2xy\3\2\2\2yz\3"+
		"\2\2\2z{\7\21\2\2{|\5\4\3\2|}\7\25\2\2}\33\3\2\2\2~\177\t\6\2\2\177\35"+
		"\3\2\2\2\25\37#+/9@DJMTX]`dhnrvx";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}