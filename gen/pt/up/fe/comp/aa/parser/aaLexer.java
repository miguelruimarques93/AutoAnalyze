// Generated from aa.g4 by ANTLR 4.1


package pt.up.fe.comp.aa.parser;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class aaLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, IDENTIFIER=3, STRING=4, OPEN_PR=5, CLOSE_PR=6, OPEN_BR=7, 
		CLOSE_BR=8, EQUAL=9, SEMICOLON=10, WS=11, COMMENT=12, LINE_COMMENT=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'if'", "'else'", "IDENTIFIER", "STRING", "'('", "')'", "'{'", "'}'", 
		"'='", "';'", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"IF", "ELSE", "IDENTIFIER", "STRING", "OPEN_PR", "CLOSE_PR", "OPEN_BR", 
		"CLOSE_BR", "EQUAL", "SEMICOLON", "WS", "COMMENT", "LINE_COMMENT"
	};


	public aaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "aa.g4"; }

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
		case 10: WS_action((RuleContext)_localctx, actionIndex); break;

		case 11: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 12: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\17f\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\7\4(\n\4\f\4\16\4+\13\4\3\5\3\5\7\5/\n\5\f\5\16\5\62\13\5\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\6\fC\n\f\r\f\16\fD"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\7\rM\n\r\f\r\16\rP\13\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\7\16[\n\16\f\16\16\16^\13\16\3\16\5\16a\n\16\3\16\3"+
		"\16\3\16\3\16\5\60N\\\17\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\1\23\13\1\25\f\1\27\r\2\31\16\3\33\17\4\3\2\5\5\2C\\aac|\7\2//\62;"+
		"C\\aac|\5\2\13\f\17\17\"\"k\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5 \3"+
		"\2\2\2\7%\3\2\2\2\t,\3\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21"+
		";\3\2\2\2\23=\3\2\2\2\25?\3\2\2\2\27B\3\2\2\2\31H\3\2\2\2\33V\3\2\2\2"+
		"\35\36\7k\2\2\36\37\7h\2\2\37\4\3\2\2\2 !\7g\2\2!\"\7n\2\2\"#\7u\2\2#"+
		"$\7g\2\2$\6\3\2\2\2%)\t\2\2\2&(\t\3\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2"+
		"\2)*\3\2\2\2*\b\3\2\2\2+)\3\2\2\2,\60\7$\2\2-/\13\2\2\2.-\3\2\2\2/\62"+
		"\3\2\2\2\60\61\3\2\2\2\60.\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\64\7"+
		"$\2\2\64\n\3\2\2\2\65\66\7*\2\2\66\f\3\2\2\2\678\7+\2\28\16\3\2\2\29:"+
		"\7}\2\2:\20\3\2\2\2;<\7\177\2\2<\22\3\2\2\2=>\7?\2\2>\24\3\2\2\2?@\7="+
		"\2\2@\26\3\2\2\2AC\t\4\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3"+
		"\2\2\2FG\b\f\2\2G\30\3\2\2\2HI\7\61\2\2IJ\7,\2\2JN\3\2\2\2KM\13\2\2\2"+
		"LK\3\2\2\2MP\3\2\2\2NO\3\2\2\2NL\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7,\2\2"+
		"RS\7\61\2\2ST\3\2\2\2TU\b\r\3\2U\32\3\2\2\2VW\7\61\2\2WX\7\61\2\2X\\\3"+
		"\2\2\2Y[\13\2\2\2ZY\3\2\2\2[^\3\2\2\2\\]\3\2\2\2\\Z\3\2\2\2]`\3\2\2\2"+
		"^\\\3\2\2\2_a\7\17\2\2`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\7\f\2\2cd\3\2\2"+
		"\2de\b\16\4\2e\34\3\2\2\2\t\2)\60DN\\`";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}