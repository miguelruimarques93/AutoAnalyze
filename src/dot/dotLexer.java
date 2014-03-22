// Generated from dot.g4 by ANTLR 4.1
package dot;
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
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, STRICT=21, GRAPH=22, DIGRAPH=23, NODE=24, 
		EDGE=25, SUBGRAPH=26, ID=27, NUMERAL=28, QUOTED_STRING=29, HTML_STRING=30, 
		COMMENT=31, LINE_COMMENT=32, PREPROC=33, WS=34;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "','", "'_'", "'-'", "'['", "':'", "'c'", "'s'", "'ne'", "'='", 
		"'w'", "';'", "'e'", "'>'", "'{'", "'se'", "'n'", "'nw'", "'}'", "'sw'", 
		"STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", "SUBGRAPH", "ID", "NUMERAL", 
		"QUOTED_STRING", "HTML_STRING", "COMMENT", "LINE_COMMENT", "PREPROC", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", 
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", 
		"SUBGRAPH", "ID", "NUMERAL", "QUOTED_STRING", "HTML_STRING", "COMMENT", 
		"LINE_COMMENT", "PREPROC", "WS"
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
		case 30: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 31: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 32: PREPROC_action((RuleContext)_localctx, actionIndex); break;

		case 33: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2$\u0107\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\7\34\u009e\n\34\f\34\16\34\u00a1\13\34\3\35\5\35\u00a4\n\35\3\35"+
		"\3\35\6\35\u00a8\n\35\r\35\16\35\u00a9\3\35\6\35\u00ad\n\35\r\35\16\35"+
		"\u00ae\3\35\3\35\7\35\u00b3\n\35\f\35\16\35\u00b6\13\35\5\35\u00b8\n\35"+
		"\5\35\u00ba\n\35\3\36\3\36\3\36\3\36\7\36\u00c0\n\36\f\36\16\36\u00c3"+
		"\13\36\3\36\3\36\3\37\3\37\3\37\7\37\u00ca\n\37\f\37\16\37\u00cd\13\37"+
		"\3\37\3\37\7\37\u00d1\n\37\f\37\16\37\u00d4\13\37\3\37\3\37\3 \3 \3 \3"+
		" \7 \u00dc\n \f \16 \u00df\13 \3 \3 \3 \3 \3 \3!\3!\3!\3!\7!\u00ea\n!"+
		"\f!\16!\u00ed\13!\3!\5!\u00f0\n!\3!\3!\3!\3!\3\"\3\"\7\"\u00f8\n\"\f\""+
		"\16\"\u00fb\13\"\3\"\3\"\3\"\3\"\3#\6#\u0102\n#\r#\16#\u0103\3#\3#\7\u00c1"+
		"\u00cb\u00dd\u00eb\u00f9$\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1"+
		"\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23"+
		"\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35"+
		"\19\36\1;\37\1= \1?!\2A\"\3C#\4E$\5\3\2\26\4\2UUuu\4\2VVvv\4\2TTtt\4\2"+
		"KKkk\4\2EEee\4\2IIii\4\2CCcc\4\2RRrr\4\2JJjj\4\2FFff\4\2PPpp\4\2QQqq\4"+
		"\2GGgg\4\2WWww\4\2DDdd\6\2C\\aac|\u0082\u0101\7\2\62;C\\aac|\u0082\u0101"+
		"\3\2\62;\4\2>>@@\5\2\13\f\17\17\"\"\u0117\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2\tM"+
		"\3\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17S\3\2\2\2\21U\3\2\2\2\23W\3\2\2\2\25"+
		"Z\3\2\2\2\27\\\3\2\2\2\31^\3\2\2\2\33`\3\2\2\2\35b\3\2\2\2\37d\3\2\2\2"+
		"!f\3\2\2\2#i\3\2\2\2%k\3\2\2\2\'n\3\2\2\2)p\3\2\2\2+s\3\2\2\2-z\3\2\2"+
		"\2/\u0080\3\2\2\2\61\u0088\3\2\2\2\63\u008d\3\2\2\2\65\u0092\3\2\2\2\67"+
		"\u009b\3\2\2\29\u00a3\3\2\2\2;\u00bb\3\2\2\2=\u00c6\3\2\2\2?\u00d7\3\2"+
		"\2\2A\u00e5\3\2\2\2C\u00f5\3\2\2\2E\u0101\3\2\2\2GH\7_\2\2H\4\3\2\2\2"+
		"IJ\7.\2\2J\6\3\2\2\2KL\7a\2\2L\b\3\2\2\2MN\7/\2\2N\n\3\2\2\2OP\7]\2\2"+
		"P\f\3\2\2\2QR\7<\2\2R\16\3\2\2\2ST\7e\2\2T\20\3\2\2\2UV\7u\2\2V\22\3\2"+
		"\2\2WX\7p\2\2XY\7g\2\2Y\24\3\2\2\2Z[\7?\2\2[\26\3\2\2\2\\]\7y\2\2]\30"+
		"\3\2\2\2^_\7=\2\2_\32\3\2\2\2`a\7g\2\2a\34\3\2\2\2bc\7@\2\2c\36\3\2\2"+
		"\2de\7}\2\2e \3\2\2\2fg\7u\2\2gh\7g\2\2h\"\3\2\2\2ij\7p\2\2j$\3\2\2\2"+
		"kl\7p\2\2lm\7y\2\2m&\3\2\2\2no\7\177\2\2o(\3\2\2\2pq\7u\2\2qr\7y\2\2r"+
		"*\3\2\2\2st\t\2\2\2tu\t\3\2\2uv\t\4\2\2vw\t\5\2\2wx\t\6\2\2xy\t\3\2\2"+
		"y,\3\2\2\2z{\t\7\2\2{|\t\4\2\2|}\t\b\2\2}~\t\t\2\2~\177\t\n\2\2\177.\3"+
		"\2\2\2\u0080\u0081\t\13\2\2\u0081\u0082\t\5\2\2\u0082\u0083\t\7\2\2\u0083"+
		"\u0084\t\4\2\2\u0084\u0085\t\b\2\2\u0085\u0086\t\t\2\2\u0086\u0087\t\n"+
		"\2\2\u0087\60\3\2\2\2\u0088\u0089\t\f\2\2\u0089\u008a\t\r\2\2\u008a\u008b"+
		"\t\13\2\2\u008b\u008c\t\16\2\2\u008c\62\3\2\2\2\u008d\u008e\t\16\2\2\u008e"+
		"\u008f\t\13\2\2\u008f\u0090\t\7\2\2\u0090\u0091\t\16\2\2\u0091\64\3\2"+
		"\2\2\u0092\u0093\t\2\2\2\u0093\u0094\t\17\2\2\u0094\u0095\t\20\2\2\u0095"+
		"\u0096\t\7\2\2\u0096\u0097\t\4\2\2\u0097\u0098\t\b\2\2\u0098\u0099\t\t"+
		"\2\2\u0099\u009a\t\n\2\2\u009a\66\3\2\2\2\u009b\u009f\t\21\2\2\u009c\u009e"+
		"\t\22\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a08\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\7"+
		"/\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00b9\3\2\2\2\u00a5"+
		"\u00a7\7\60\2\2\u00a6\u00a8\t\23\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3"+
		"\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ba\3\2\2\2\u00ab"+
		"\u00ad\t\23\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3"+
		"\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b7\3\2\2\2\u00b0\u00b4\7\60\2\2\u00b1"+
		"\u00b3\t\23\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00b0\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00a5\3\2"+
		"\2\2\u00b9\u00ac\3\2\2\2\u00ba:\3\2\2\2\u00bb\u00c1\7$\2\2\u00bc\u00bd"+
		"\7^\2\2\u00bd\u00c0\7$\2\2\u00be\u00c0\13\2\2\2\u00bf\u00bc\3\2\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7$\2\2\u00c5"+
		"<\3\2\2\2\u00c6\u00d2\7>\2\2\u00c7\u00cb\7>\2\2\u00c8\u00ca\13\2\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\7@\2\2\u00cf"+
		"\u00d1\n\24\2\2\u00d0\u00c7\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3"+
		"\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00d6\7@\2\2\u00d6>\3\2\2\2\u00d7\u00d8\7\61\2\2"+
		"\u00d8\u00d9\7,\2\2\u00d9\u00dd\3\2\2\2\u00da\u00dc\13\2\2\2\u00db\u00da"+
		"\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7,\2\2\u00e1\u00e2\7\61"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b \2\2\u00e4@\3\2\2\2\u00e5\u00e6"+
		"\7\61\2\2\u00e6\u00e7\7\61\2\2\u00e7\u00eb\3\2\2\2\u00e8\u00ea\13\2\2"+
		"\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00ec\3\2\2\2\u00eb\u00e9"+
		"\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f0\7\17\2\2"+
		"\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2"+
		"\7\f\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\b!\3\2\u00f4B\3\2\2\2\u00f5\u00f9"+
		"\7%\2\2\u00f6\u00f8\13\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fc\u00fd\7\f\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\b\"\4\2\u00ff"+
		"D\3\2\2\2\u0100\u0102\t\25\2\2\u0101\u0100\3\2\2\2\u0102\u0103\3\2\2\2"+
		"\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106"+
		"\b#\5\2\u0106F\3\2\2\2\24\2\u009f\u00a3\u00a9\u00ae\u00b4\u00b7\u00b9"+
		"\u00bf\u00c1\u00cb\u00d0\u00d2\u00dd\u00eb\u00ef\u00f9\u0103";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}