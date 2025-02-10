// Generated from /home/morteza-mahdi-zadeh/Documents/compiler/src/main/java/org/compiler/org/compiler/CLang.g4 by ANTLR 4.13.2
package org.compiler.org.compiler;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, IDENTIFIER=16, 
		CONSTANT=17, KEYWORD=18, WS=19, PUNCTUATION=20, OPERATOR=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "IDENTIFIER", "CONSTANT", 
			"KEYWORD", "WS", "PUNCTUATION", "OPERATOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'{'", "'}'", "';'", "'return'", "'int'", 
			"'float'", "'void'", "'+'", "'-'", "'*'", "'/'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "IDENTIFIER", "CONSTANT", "KEYWORD", "WS", "PUNCTUATION", 
			"OPERATOR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public CLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0015\u008a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0005\u000fZ\b\u000f"+
		"\n\u000f\f\u000f]\t\u000f\u0001\u0010\u0004\u0010`\b\u0010\u000b\u0010"+
		"\f\u0010a\u0001\u0010\u0001\u0010\u0004\u0010f\b\u0010\u000b\u0010\f\u0010"+
		"g\u0003\u0010j\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011~\b\u0011\u0001\u0012\u0004\u0012"+
		"\u0081\b\u0012\u000b\u0012\f\u0012\u0082\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0000\u0000\u0015\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001\u0000\u0006\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  \u0005"+
		"\u0000(),,;;{{}}\u0004\u0000*+--//==\u0091\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000"+
		"\u0003-\u0001\u0000\u0000\u0000\u0005/\u0001\u0000\u0000\u0000\u00071"+
		"\u0001\u0000\u0000\u0000\t3\u0001\u0000\u0000\u0000\u000b5\u0001\u0000"+
		"\u0000\u0000\r7\u0001\u0000\u0000\u0000\u000f>\u0001\u0000\u0000\u0000"+
		"\u0011B\u0001\u0000\u0000\u0000\u0013H\u0001\u0000\u0000\u0000\u0015M"+
		"\u0001\u0000\u0000\u0000\u0017O\u0001\u0000\u0000\u0000\u0019Q\u0001\u0000"+
		"\u0000\u0000\u001bS\u0001\u0000\u0000\u0000\u001dU\u0001\u0000\u0000\u0000"+
		"\u001fW\u0001\u0000\u0000\u0000!_\u0001\u0000\u0000\u0000#}\u0001\u0000"+
		"\u0000\u0000%\u0080\u0001\u0000\u0000\u0000\'\u0086\u0001\u0000\u0000"+
		"\u0000)\u0088\u0001\u0000\u0000\u0000+,\u0005(\u0000\u0000,\u0002\u0001"+
		"\u0000\u0000\u0000-.\u0005)\u0000\u0000.\u0004\u0001\u0000\u0000\u0000"+
		"/0\u0005,\u0000\u00000\u0006\u0001\u0000\u0000\u000012\u0005{\u0000\u0000"+
		"2\b\u0001\u0000\u0000\u000034\u0005}\u0000\u00004\n\u0001\u0000\u0000"+
		"\u000056\u0005;\u0000\u00006\f\u0001\u0000\u0000\u000078\u0005r\u0000"+
		"\u000089\u0005e\u0000\u00009:\u0005t\u0000\u0000:;\u0005u\u0000\u0000"+
		";<\u0005r\u0000\u0000<=\u0005n\u0000\u0000=\u000e\u0001\u0000\u0000\u0000"+
		">?\u0005i\u0000\u0000?@\u0005n\u0000\u0000@A\u0005t\u0000\u0000A\u0010"+
		"\u0001\u0000\u0000\u0000BC\u0005f\u0000\u0000CD\u0005l\u0000\u0000DE\u0005"+
		"o\u0000\u0000EF\u0005a\u0000\u0000FG\u0005t\u0000\u0000G\u0012\u0001\u0000"+
		"\u0000\u0000HI\u0005v\u0000\u0000IJ\u0005o\u0000\u0000JK\u0005i\u0000"+
		"\u0000KL\u0005d\u0000\u0000L\u0014\u0001\u0000\u0000\u0000MN\u0005+\u0000"+
		"\u0000N\u0016\u0001\u0000\u0000\u0000OP\u0005-\u0000\u0000P\u0018\u0001"+
		"\u0000\u0000\u0000QR\u0005*\u0000\u0000R\u001a\u0001\u0000\u0000\u0000"+
		"ST\u0005/\u0000\u0000T\u001c\u0001\u0000\u0000\u0000UV\u0005=\u0000\u0000"+
		"V\u001e\u0001\u0000\u0000\u0000W[\u0007\u0000\u0000\u0000XZ\u0007\u0001"+
		"\u0000\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\ \u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000^`\u0007\u0002\u0000\u0000_^\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000bi\u0001\u0000\u0000\u0000ce\u0005.\u0000\u0000df\u0007\u0002"+
		"\u0000\u0000ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000ge\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000\u0000"+
		"ic\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\"\u0001\u0000\u0000"+
		"\u0000kl\u0005i\u0000\u0000lm\u0005n\u0000\u0000m~\u0005t\u0000\u0000"+
		"no\u0005f\u0000\u0000op\u0005l\u0000\u0000pq\u0005o\u0000\u0000qr\u0005"+
		"a\u0000\u0000r~\u0005t\u0000\u0000st\u0005r\u0000\u0000tu\u0005e\u0000"+
		"\u0000uv\u0005t\u0000\u0000vw\u0005u\u0000\u0000wx\u0005r\u0000\u0000"+
		"x~\u0005n\u0000\u0000yz\u0005v\u0000\u0000z{\u0005o\u0000\u0000{|\u0005"+
		"i\u0000\u0000|~\u0005d\u0000\u0000}k\u0001\u0000\u0000\u0000}n\u0001\u0000"+
		"\u0000\u0000}s\u0001\u0000\u0000\u0000}y\u0001\u0000\u0000\u0000~$\u0001"+
		"\u0000\u0000\u0000\u007f\u0081\u0007\u0003\u0000\u0000\u0080\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0006\u0012\u0000\u0000\u0085&\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0007\u0004\u0000\u0000\u0087(\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0007\u0005\u0000\u0000\u0089*\u0001\u0000\u0000\u0000"+
		"\u0007\u0000[agi}\u0082\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}