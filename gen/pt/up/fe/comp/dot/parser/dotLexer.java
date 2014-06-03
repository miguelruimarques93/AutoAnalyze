// Generated from dot.g4 by ANTLR 4.1


package pt.up.fe.comp.dot.parser;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class dotLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, DIEDGE_OP=9, 
		EDGE_OP=10, STRICT=11, GRAPH=12, DIGRAPH=13, NODE=14, EDGE=15, SUBGRAPH=16, 
		ID=17, NUMERAL=18, QUOTED_STRING=19, HTML_STRING=20, COMMENT=21, LINE_COMMENT=22, 
		PREPROC=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "'{'", "','", "'['", "':'", "'='", "'}'", "';'", "'->'", "'--'", 
		"STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", "SUBGRAPH", "ID", "NUMERAL", 
		"QUOTED_STRING", "HTML_STRING", "COMMENT", "LINE_COMMENT", "PREPROC", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "DIEDGE_OP", 
		"EDGE_OP", "STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", "SUBGRAPH", "ID", 
		"NUMERAL", "QUOTED_STRING", "HTML_STRING", "COMMENT", "LINE_COMMENT", 
		"PREPROC", "WS"
	};


	public dotLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "dot.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 20: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 21: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 22: PREPROC_action((RuleContext)_localctx, actionIndex); break;

		case 23: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void PREPROC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: skip();  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\32\u00dd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\7\22t\n\22\f\22\16\22w\13\22\3\23\5\23z\n\23\3\23\3\23"+
		"\6\23~\n\23\r\23\16\23\177\3\23\6\23\u0083\n\23\r\23\16\23\u0084\3\23"+
		"\3\23\7\23\u0089\n\23\f\23\16\23\u008c\13\23\5\23\u008e\n\23\5\23\u0090"+
		"\n\23\3\24\3\24\3\24\3\24\7\24\u0096\n\24\f\24\16\24\u0099\13\24\3\24"+
		"\3\24\3\25\3\25\3\25\7\25\u00a0\n\25\f\25\16\25\u00a3\13\25\3\25\3\25"+
		"\7\25\u00a7\n\25\f\25\16\25\u00aa\13\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\7\26\u00b2\n\26\f\26\16\26\u00b5\13\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\7\27\u00c0\n\27\f\27\16\27\u00c3\13\27\3\27\5\27\u00c6"+
		"\n\27\3\27\3\27\3\27\3\27\3\30\3\30\7\30\u00ce\n\30\f\30\16\30\u00d1\13"+
		"\30\3\30\3\30\3\30\3\30\3\31\6\31\u00d8\n\31\r\31\16\31\u00d9\3\31\3\31"+
		"\7\u0097\u00a1\u00b3\u00c1\u00cf\32\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b"+
		"\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1"+
		"!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\2-\30\3/\31\4\61\32\5\3\2\26\4\2U"+
		"Uuu\4\2VVvv\4\2TTtt\4\2KKkk\4\2EEee\4\2IIii\4\2CCcc\4\2RRrr\4\2JJjj\4"+
		"\2FFff\4\2PPpp\4\2QQqq\4\2GGgg\4\2WWww\4\2DDdd\6\2C\\aac|\u0082\u0101"+
		"\7\2\62;C\\aac|\u0082\u0101\3\2\62;\4\2>>@@\5\2\13\f\17\17\"\"\u00ed\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t9\3\2\2\2\13;\3"+
		"\2\2\2\r=\3\2\2\2\17?\3\2\2\2\21A\3\2\2\2\23C\3\2\2\2\25F\3\2\2\2\27I"+
		"\3\2\2\2\31P\3\2\2\2\33V\3\2\2\2\35^\3\2\2\2\37c\3\2\2\2!h\3\2\2\2#q\3"+
		"\2\2\2%y\3\2\2\2\'\u0091\3\2\2\2)\u009c\3\2\2\2+\u00ad\3\2\2\2-\u00bb"+
		"\3\2\2\2/\u00cb\3\2\2\2\61\u00d7\3\2\2\2\63\64\7_\2\2\64\4\3\2\2\2\65"+
		"\66\7}\2\2\66\6\3\2\2\2\678\7.\2\28\b\3\2\2\29:\7]\2\2:\n\3\2\2\2;<\7"+
		"<\2\2<\f\3\2\2\2=>\7?\2\2>\16\3\2\2\2?@\7\177\2\2@\20\3\2\2\2AB\7=\2\2"+
		"B\22\3\2\2\2CD\7/\2\2DE\7@\2\2E\24\3\2\2\2FG\7/\2\2GH\7/\2\2H\26\3\2\2"+
		"\2IJ\t\2\2\2JK\t\3\2\2KL\t\4\2\2LM\t\5\2\2MN\t\6\2\2NO\t\3\2\2O\30\3\2"+
		"\2\2PQ\t\7\2\2QR\t\4\2\2RS\t\b\2\2ST\t\t\2\2TU\t\n\2\2U\32\3\2\2\2VW\t"+
		"\13\2\2WX\t\5\2\2XY\t\7\2\2YZ\t\4\2\2Z[\t\b\2\2[\\\t\t\2\2\\]\t\n\2\2"+
		"]\34\3\2\2\2^_\t\f\2\2_`\t\r\2\2`a\t\13\2\2ab\t\16\2\2b\36\3\2\2\2cd\t"+
		"\16\2\2de\t\13\2\2ef\t\7\2\2fg\t\16\2\2g \3\2\2\2hi\t\2\2\2ij\t\17\2\2"+
		"jk\t\20\2\2kl\t\7\2\2lm\t\4\2\2mn\t\b\2\2no\t\t\2\2op\t\n\2\2p\"\3\2\2"+
		"\2qu\t\21\2\2rt\t\22\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v$\3\2"+
		"\2\2wu\3\2\2\2xz\7/\2\2yx\3\2\2\2yz\3\2\2\2z\u008f\3\2\2\2{}\7\60\2\2"+
		"|~\t\23\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0090\3\2\2\2\u0081\u0083\t\23\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3"+
		"\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u008d\3\2\2\2\u0086"+
		"\u008a\7\60\2\2\u0087\u0089\t\23\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3"+
		"\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008d\u0086\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2"+
		"\2\2\u008f{\3\2\2\2\u008f\u0082\3\2\2\2\u0090&\3\2\2\2\u0091\u0097\7$"+
		"\2\2\u0092\u0093\7^\2\2\u0093\u0096\7$\2\2\u0094\u0096\13\2\2\2\u0095"+
		"\u0092\3\2\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u009b\7$\2\2\u009b(\3\2\2\2\u009c\u00a8\7>\2\2\u009d\u00a1\7>\2\2\u009e"+
		"\u00a0\13\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u00a2\3"+
		"\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a7\7@\2\2\u00a5\u00a7\n\24\2\2\u00a6\u009d\3\2\2\2\u00a6\u00a5\3\2"+
		"\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7@\2\2\u00ac*\3\2\2\2\u00ad"+
		"\u00ae\7\61\2\2\u00ae\u00af\7,\2\2\u00af\u00b3\3\2\2\2\u00b0\u00b2\13"+
		"\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\7,"+
		"\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\b\26\2\2\u00ba"+
		",\3\2\2\2\u00bb\u00bc\7\61\2\2\u00bc\u00bd\7\61\2\2\u00bd\u00c1\3\2\2"+
		"\2\u00be\u00c0\13\2\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c4\u00c6\7\17\2\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c8\7\f\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b\27"+
		"\3\2\u00ca.\3\2\2\2\u00cb\u00cf\7%\2\2\u00cc\u00ce\13\2\2\2\u00cd\u00cc"+
		"\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7\f\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\u00d5\b\30\4\2\u00d5\60\3\2\2\2\u00d6\u00d8\t\25\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b\31\5\2\u00dc\62\3\2\2\2\24\2uy"+
		"\177\u0084\u008a\u008d\u008f\u0095\u0097\u00a1\u00a6\u00a8\u00b3\u00c1"+
		"\u00c5\u00cf\u00d9";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}