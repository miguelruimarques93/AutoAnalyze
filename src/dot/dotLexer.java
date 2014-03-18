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
		EDGE=25, SUBGRAPH=26, ID=27, COMMENT=28, LINE_COMMENT=29, PREPROC=30, 
		WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "','", "'_'", "'-'", "'['", "':'", "'c'", "'s'", "'ne'", "'='", 
		"'w'", "';'", "'e'", "'>'", "'{'", "'se'", "'n'", "'nw'", "'}'", "'sw'", 
		"STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", "SUBGRAPH", "'ABC'", "COMMENT", 
		"LINE_COMMENT", "PREPROC", "WS"
	};
	public static final String[] ruleNames = {
		"T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", 
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", 
		"SUBGRAPH", "ID", "COMMENT", "LINE_COMMENT", "PREPROC", "WS"
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
		case 27: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 28: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 29: PREPROC_action((RuleContext)_localctx, actionIndex); break;

		case 30: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2!\u00c9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\7\35\u009e\n\35\f\35\16\35\u00a1\13\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\36\7\36\u00ac\n\36\f\36\16\36\u00af\13\36\3"+
		"\36\5\36\u00b2\n\36\3\36\3\36\3\36\3\36\3\37\3\37\7\37\u00ba\n\37\f\37"+
		"\16\37\u00bd\13\37\3\37\3\37\3\37\3\37\3 \6 \u00c4\n \r \16 \u00c5\3 "+
		"\3 \5\u009f\u00ad\u00bb!\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1"+
		"%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\1"+
		"9\36\2;\37\3= \4?!\5\3\2\22\4\2UUuu\4\2VVvv\4\2TTtt\4\2KKkk\4\2EEee\4"+
		"\2IIii\4\2CCcc\4\2RRrr\4\2JJjj\4\2FFff\4\2PPpp\4\2QQqq\4\2GGgg\4\2WWw"+
		"w\4\2DDdd\5\2\13\f\17\17\"\"\u00cd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2"+
		"\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17M\3\2\2\2"+
		"\21O\3\2\2\2\23Q\3\2\2\2\25T\3\2\2\2\27V\3\2\2\2\31X\3\2\2\2\33Z\3\2\2"+
		"\2\35\\\3\2\2\2\37^\3\2\2\2!`\3\2\2\2#c\3\2\2\2%e\3\2\2\2\'h\3\2\2\2)"+
		"j\3\2\2\2+m\3\2\2\2-t\3\2\2\2/z\3\2\2\2\61\u0082\3\2\2\2\63\u0087\3\2"+
		"\2\2\65\u008c\3\2\2\2\67\u0095\3\2\2\29\u0099\3\2\2\2;\u00a7\3\2\2\2="+
		"\u00b7\3\2\2\2?\u00c3\3\2\2\2AB\7_\2\2B\4\3\2\2\2CD\7.\2\2D\6\3\2\2\2"+
		"EF\7a\2\2F\b\3\2\2\2GH\7/\2\2H\n\3\2\2\2IJ\7]\2\2J\f\3\2\2\2KL\7<\2\2"+
		"L\16\3\2\2\2MN\7e\2\2N\20\3\2\2\2OP\7u\2\2P\22\3\2\2\2QR\7p\2\2RS\7g\2"+
		"\2S\24\3\2\2\2TU\7?\2\2U\26\3\2\2\2VW\7y\2\2W\30\3\2\2\2XY\7=\2\2Y\32"+
		"\3\2\2\2Z[\7g\2\2[\34\3\2\2\2\\]\7@\2\2]\36\3\2\2\2^_\7}\2\2_ \3\2\2\2"+
		"`a\7u\2\2ab\7g\2\2b\"\3\2\2\2cd\7p\2\2d$\3\2\2\2ef\7p\2\2fg\7y\2\2g&\3"+
		"\2\2\2hi\7\177\2\2i(\3\2\2\2jk\7u\2\2kl\7y\2\2l*\3\2\2\2mn\t\2\2\2no\t"+
		"\3\2\2op\t\4\2\2pq\t\5\2\2qr\t\6\2\2rs\t\3\2\2s,\3\2\2\2tu\t\7\2\2uv\t"+
		"\4\2\2vw\t\b\2\2wx\t\t\2\2xy\t\n\2\2y.\3\2\2\2z{\t\13\2\2{|\t\5\2\2|}"+
		"\t\7\2\2}~\t\4\2\2~\177\t\b\2\2\177\u0080\t\t\2\2\u0080\u0081\t\n\2\2"+
		"\u0081\60\3\2\2\2\u0082\u0083\t\f\2\2\u0083\u0084\t\r\2\2\u0084\u0085"+
		"\t\13\2\2\u0085\u0086\t\16\2\2\u0086\62\3\2\2\2\u0087\u0088\t\16\2\2\u0088"+
		"\u0089\t\13\2\2\u0089\u008a\t\7\2\2\u008a\u008b\t\16\2\2\u008b\64\3\2"+
		"\2\2\u008c\u008d\t\2\2\2\u008d\u008e\t\17\2\2\u008e\u008f\t\20\2\2\u008f"+
		"\u0090\t\7\2\2\u0090\u0091\t\4\2\2\u0091\u0092\t\b\2\2\u0092\u0093\t\t"+
		"\2\2\u0093\u0094\t\n\2\2\u0094\66\3\2\2\2\u0095\u0096\7C\2\2\u0096\u0097"+
		"\7D\2\2\u0097\u0098\7E\2\2\u00988\3\2\2\2\u0099\u009a\7\61\2\2\u009a\u009b"+
		"\7,\2\2\u009b\u009f\3\2\2\2\u009c\u009e\13\2\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\u00a1\3\2\2\2\u009f\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\3\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7,\2\2\u00a3\u00a4\7\61\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a6\b\35\2\2\u00a6:\3\2\2\2\u00a7\u00a8\7\61\2"+
		"\2\u00a8\u00a9\7\61\2\2\u00a9\u00ad\3\2\2\2\u00aa\u00ac\13\2\2\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\7\17\2\2\u00b1"+
		"\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\f"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b\36\3\2\u00b6<\3\2\2\2\u00b7\u00bb"+
		"\7%\2\2\u00b8\u00ba\13\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00be\u00bf\7\f\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\b\37\4\2\u00c1"+
		">\3\2\2\2\u00c2\u00c4\t\21\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2"+
		"\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8"+
		"\b \5\2\u00c8@\3\2\2\2\b\2\u009f\u00ad\u00b1\u00bb\u00c5";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}