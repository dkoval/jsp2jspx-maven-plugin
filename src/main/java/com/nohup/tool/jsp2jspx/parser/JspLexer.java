// $ANTLR 3.0.1 Jsp.g 2010-10-13 12:47:51

package com.nohup.tool.jsp2jspx.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;

public class JspLexer extends Lexer {
    public static final int ELEMENT = 4;
    public static final int LETTER = 27;
    public static final int JSP_DIRECTIVE_OPEN = 13;
    public static final int TAG_EMPTY_CLOSE = 21;
    public static final int CDATA = 10;
    public static final int GENERIC_ID = 14;
    public static final int JSP_EXPRESSION = 16;
    public static final int COMMENT = 12;
    public static final int JSP_DIRECTIVE = 7;
    public static final int PCDATA = 11;
    public static final int DOCTYPE_DEFINITION = 9;
    public static final int WHITESPACE = 30;
    public static final int PROCESSING_INSTRUCTION = 8;
    public static final int TAG_CLOSE = 20;
    public static final int EOF = -1;
    public static final int EL_EXPR = 19;
    public static final int ATTR_VALUE_OPEN = 24;
    public static final int ATTR_VALUE_CLOSE = 25;
    public static final int Tokens = 31;
    public static final int JSP_COMMENT = 18;
    public static final int TAG_END_OPEN = 26;
    public static final int JSP_DIRECTIVE_CLOSE = 15;
    public static final int ATTR_EQ = 23;
    public static final int NAMECHAR = 28;
    public static final int TAG_START_OPEN = 22;
    public static final int ATTRIBUTES = 6;
    public static final int DIGIT = 29;
    public static final int ATTRIBUTE = 5;
    public static final int JSP_SCRIPTLET = 17;

    private int tags;

    private enum Quote {
        NONE, SINGLE, DOUBLE
    };

    private Quote quote = Quote.NONE;
    private List<Integer> tagStack = new ArrayList<Integer>();
    private List<Quote> quoteStack = new ArrayList<Quote>();

    private void trim(int front, int back) {
        String text = getText();
        setText(text.substring(front, text.length() - back));
    }

    private boolean inTag() {
        return tags > 0;
    }

    private void pushTag() {
        tagStack.add(tags);
        tags = 0;
    }

    private void popTag() {
        tags = tagStack.remove(tagStack.size() - 1);
    }

    private void pushQuote() {
        quoteStack.add(quote);
        quote = Quote.NONE;
    }

    private void popQuote() {
        quote = quoteStack.remove(quoteStack.size() - 1);
    }

    public JspLexer() {
        ;
    }

    public JspLexer(CharStream input) {
        super(input);
    }

    public String getGrammarFileName() {
        return "Jsp.g";
    }

    // $ANTLR start CDATA
    public final void mCDATA() throws RecognitionException {
        try {
            int _type = CDATA;
            // Jsp.g:144:5: ( '<![CDATA[' ( options {greedy=false; } : . )* ']]>' )
            // Jsp.g:144:7: '<![CDATA[' ( options {greedy=false; } : . )* ']]>'
            {
                match("<![CDATA[");

                // Jsp.g:144:19: ( options {greedy=false; } : . )*
                loop1: do {
                    int alt1 = 2;
                    int LA1_0 = input.LA(1);

                    if ((LA1_0 == ']')) {
                        int LA1_1 = input.LA(2);

                        if ((LA1_1 == ']')) {
                            int LA1_3 = input.LA(3);

                            if (((LA1_3 >= '\u0000' && LA1_3 <= '=') || (LA1_3 >= '?' && LA1_3 <= '\uFFFE'))) {
                                alt1 = 1;
                            } else if ((LA1_3 == '>')) {
                                alt1 = 2;
                            }

                        } else if (((LA1_1 >= '\u0000' && LA1_1 <= '\\') || (LA1_1 >= '^' && LA1_1 <= '\uFFFE'))) {
                            alt1 = 1;
                        }

                    } else if (((LA1_0 >= '\u0000' && LA1_0 <= '\\') || (LA1_0 >= '^' && LA1_0 <= '\uFFFE'))) {
                        alt1 = 1;
                    }

                    switch (alt1) {
                    case 1:
                        // Jsp.g:144:51: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop1;
                    }
                } while (true);

                match("]]>");

                trim(9, 3);

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end CDATA

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // Jsp.g:148:5: ({...}? => '<!--' ( options {greedy=false; } : . )* '-->' )
            // Jsp.g:148:7: {...}? => '<!--' ( options {greedy=false; } : . )* '-->'
            {
                if (!(!inTag())) {
                    throw new FailedPredicateException(input, "COMMENT", " ! inTag() ");
                }
                match("<!--");

                // Jsp.g:148:31: ( options {greedy=false; } : . )*
                loop2: do {
                    int alt2 = 2;
                    int LA2_0 = input.LA(1);

                    if ((LA2_0 == '-')) {
                        int LA2_1 = input.LA(2);

                        if ((LA2_1 == '-')) {
                            int LA2_3 = input.LA(3);

                            if (((LA2_3 >= '\u0000' && LA2_3 <= '=') || (LA2_3 >= '?' && LA2_3 <= '\uFFFE'))) {
                                alt2 = 1;
                            } else if ((LA2_3 == '>')) {
                                alt2 = 2;
                            }

                        } else if (((LA2_1 >= '\u0000' && LA2_1 <= ',') || (LA2_1 >= '.' && LA2_1 <= '\uFFFE'))) {
                            alt2 = 1;
                        }

                    } else if (((LA2_0 >= '\u0000' && LA2_0 <= ',') || (LA2_0 >= '.' && LA2_0 <= '\uFFFE'))) {
                        alt2 = 1;
                    }

                    switch (alt2) {
                    case 1:
                        // Jsp.g:148:63: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop2;
                    }
                } while (true);

                match("-->");

                trim(4, 3);

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end COMMENT

    // $ANTLR start TAG_START_OPEN
    public final void mTAG_START_OPEN() throws RecognitionException {
        try {
            int _type = TAG_START_OPEN;
            // Jsp.g:152:5: ( '<' )
            // Jsp.g:152:7: '<'
            {
                match('<');
                tags++;
                pushQuote();

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end TAG_START_OPEN

    // $ANTLR start TAG_END_OPEN
    public final void mTAG_END_OPEN() throws RecognitionException {
        try {
            int _type = TAG_END_OPEN;
            // Jsp.g:156:5: ( '</' )
            // Jsp.g:156:7: '</'
            {
                match("</");

                tags++;
                pushQuote();

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end TAG_END_OPEN

    // $ANTLR start TAG_CLOSE
    public final void mTAG_CLOSE() throws RecognitionException {
        try {
            int _type = TAG_CLOSE;
            // Jsp.g:160:5: ({...}? => '>' )
            // Jsp.g:160:7: {...}? => '>'
            {
                if (!(inTag())) {
                    throw new FailedPredicateException(input, "TAG_CLOSE", " inTag() ");
                }
                match('>');
                tags--;
                popQuote();

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end TAG_CLOSE

    // $ANTLR start TAG_EMPTY_CLOSE
    public final void mTAG_EMPTY_CLOSE() throws RecognitionException {
        try {
            int _type = TAG_EMPTY_CLOSE;
            // Jsp.g:164:5: ({...}? => '/>' )
            // Jsp.g:164:7: {...}? => '/>'
            {
                if (!(inTag())) {
                    throw new FailedPredicateException(input, "TAG_EMPTY_CLOSE", " inTag() ");
                }
                match("/>");

                tags--;
                popQuote();

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end TAG_EMPTY_CLOSE

    // $ANTLR start ATTR_EQ
    public final void mATTR_EQ() throws RecognitionException {
        try {
            int _type = ATTR_EQ;
            // Jsp.g:168:5: ({...}? => '=' )
            // Jsp.g:168:7: {...}? => '='
            {
                if (!(inTag())) {
                    throw new FailedPredicateException(input, "ATTR_EQ", " inTag() ");
                }
                match('=');

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end ATTR_EQ

    // $ANTLR start ATTR_VALUE_OPEN
    public final void mATTR_VALUE_OPEN() throws RecognitionException {
        try {
            int _type = ATTR_VALUE_OPEN;
            // Jsp.g:171:5: ({...}? => ({...}? => '\"' | {...}? => '\\'' ) )
            // Jsp.g:171:7: {...}? => ({...}? => '\"' | {...}? => '\\'' )
            {
                if (!(inTag())) {
                    throw new FailedPredicateException(input, "ATTR_VALUE_OPEN", " inTag() ");
                }
                // Jsp.g:171:22: ({...}? => '\"' | {...}? => '\\'' )
                int alt3 = 2;
                int LA3_0 = input.LA(1);

                if ((LA3_0 == '\"') && (quote != Quote.DOUBLE)) {
                    alt3 = 1;
                } else if ((LA3_0 == '\'') && (quote != Quote.DOUBLE)) {
                    alt3 = 2;
                } else {
                    NoViableAltException nvae = new NoViableAltException("171:22: ({...}? => '\"' | {...}? => '\\'' )",
                            3, 0, input);

                    throw nvae;
                }
                switch (alt3) {
                case 1:
                    // Jsp.g:172:9: {...}? => '\"'
                {
                    if (!(quote != Quote.DOUBLE)) {
                        throw new FailedPredicateException(input, "ATTR_VALUE_OPEN", " quote != Quote.DOUBLE ");
                    }
                    match('\"');
                    quote = Quote.DOUBLE;

                }
                    break;
                case 2:
                    // Jsp.g:173:11: {...}? => '\\''
                {
                    if (!(quote != Quote.DOUBLE)) {
                        throw new FailedPredicateException(input, "ATTR_VALUE_OPEN", " quote != Quote.DOUBLE ");
                    }
                    match('\'');
                    quote = Quote.SINGLE;

                }
                    break;

                }

                pushTag();

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end ATTR_VALUE_OPEN

    // $ANTLR start ATTR_VALUE_CLOSE
    public final void mATTR_VALUE_CLOSE() throws RecognitionException {
        try {
            int _type = ATTR_VALUE_CLOSE;
            // Jsp.g:179:5: ({...}? => ({...}? => '\"' | {...}? => '\\'' ) )
            // Jsp.g:179:7: {...}? => ({...}? => '\"' | {...}? => '\\'' )
            {
                if (!(!inTag())) {
                    throw new FailedPredicateException(input, "ATTR_VALUE_CLOSE", " ! inTag() ");
                }
                // Jsp.g:179:24: ({...}? => '\"' | {...}? => '\\'' )
                int alt4 = 2;
                int LA4_0 = input.LA(1);

                if ((LA4_0 == '\"') && (quote == Quote.DOUBLE)) {
                    alt4 = 1;
                } else if ((LA4_0 == '\'') && (quote == Quote.SINGLE)) {
                    alt4 = 2;
                } else {
                    NoViableAltException nvae = new NoViableAltException("179:24: ({...}? => '\"' | {...}? => '\\'' )",
                            4, 0, input);

                    throw nvae;
                }
                switch (alt4) {
                case 1:
                    // Jsp.g:180:11: {...}? => '\"'
                {
                    if (!(quote == Quote.DOUBLE)) {
                        throw new FailedPredicateException(input, "ATTR_VALUE_CLOSE", " quote == Quote.DOUBLE ");
                    }
                    match('\"');

                }
                    break;
                case 2:
                    // Jsp.g:181:11: {...}? => '\\''
                {
                    if (!(quote == Quote.SINGLE)) {
                        throw new FailedPredicateException(input, "ATTR_VALUE_CLOSE", " quote == Quote.SINGLE ");
                    }
                    match('\'');

                }
                    break;

                }

                quote = Quote.NONE;
                popTag();

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end ATTR_VALUE_CLOSE

    // $ANTLR start EL_EXPR
    public final void mEL_EXPR() throws RecognitionException {
        try {
            int _type = EL_EXPR;
            // Jsp.g:187:5: ( '${' ( options {greedy=false; } : . )* '}' )
            // Jsp.g:187:7: '${' ( options {greedy=false; } : . )* '}'
            {
                match("${");

                // Jsp.g:187:12: ( options {greedy=false; } : . )*
                loop5: do {
                    int alt5 = 2;
                    int LA5_0 = input.LA(1);

                    if ((LA5_0 == '}')) {
                        alt5 = 2;
                    } else if (((LA5_0 >= '\u0000' && LA5_0 <= '|') || (LA5_0 >= '~' && LA5_0 <= '\uFFFE'))) {
                        alt5 = 1;
                    }

                    switch (alt5) {
                    case 1:
                        // Jsp.g:187:44: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop5;
                    }
                } while (true);

                match('}');
                trim(2, 1);

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end EL_EXPR

    // $ANTLR start PCDATA
    public final void mPCDATA() throws RecognitionException {
        try {
            int _type = PCDATA;
            // Jsp.g:191:5: ({...}? => ({...}? =>~ ( '<' ) (~ ( '<' | '$' ) )* | {...}? =>~ ( '<' | '\"' ) (~ ( '<' | '$' | '\"' ) )* | {...}? =>~ ( '<' | '\\'' ) (~ ( '<' | '$' | '\\'' ) )* ) )
            // Jsp.g:191:7: {...}? => ({...}? =>~ ( '<' ) (~ ( '<' | '$' ) )* | {...}? =>~ ( '<' | '\"' ) (~ ( '<' | '$' | '\"' ) )* | {...}? =>~ ( '<' | '\\'' ) (~ ( '<' | '$' | '\\'' ) )* )
            {
                if (!(!inTag())) {
                    throw new FailedPredicateException(input, "PCDATA", " ! inTag() ");
                }
                // Jsp.g:191:24: ({...}? =>~ ( '<' ) (~ ( '<' | '$' ) )* | {...}? =>~ ( '<' | '\"' ) (~ ( '<' | '$' | '\"' ) )* | {...}? =>~ ( '<' | '\\'' ) (~ ( '<' | '$' | '\\'' ) )* )
                int alt9 = 3;
                int LA9_0 = input.LA(1);

                if (((LA9_0 >= '\u0000' && LA9_0 <= '!') || (LA9_0 >= '#' && LA9_0 <= '&')
                        || (LA9_0 >= '(' && LA9_0 <= ';') || (LA9_0 >= '=' && LA9_0 <= '\uFFFE'))
                        && ((quote == Quote.DOUBLE || quote == Quote.SINGLE || quote == Quote.NONE))) {
                    int LA9_1 = input.LA(2);

                    if ((quote == Quote.NONE)) {
                        alt9 = 1;
                    } else if ((quote == Quote.DOUBLE)) {
                        alt9 = 2;
                    } else if ((quote == Quote.SINGLE)) {
                        alt9 = 3;
                    } else {
                        NoViableAltException nvae = new NoViableAltException(
                                "191:24: ({...}? =>~ ( '<' ) (~ ( '<' | '$' ) )* | {...}? =>~ ( '<' | '\"' ) (~ ( '<' | '$' | '\"' ) )* | {...}? =>~ ( '<' | '\\'' ) (~ ( '<' | '$' | '\\'' ) )* )",
                                9, 1, input);

                        throw nvae;
                    }
                } else if ((LA9_0 == '\"') && ((quote == Quote.NONE || quote == Quote.SINGLE))) {
                    int LA9_2 = input.LA(2);

                    if ((quote == Quote.NONE)) {
                        alt9 = 1;
                    } else if ((quote == Quote.SINGLE)) {
                        alt9 = 3;
                    } else {
                        NoViableAltException nvae = new NoViableAltException(
                                "191:24: ({...}? =>~ ( '<' ) (~ ( '<' | '$' ) )* | {...}? =>~ ( '<' | '\"' ) (~ ( '<' | '$' | '\"' ) )* | {...}? =>~ ( '<' | '\\'' ) (~ ( '<' | '$' | '\\'' ) )* )",
                                9, 2, input);

                        throw nvae;
                    }
                } else if ((LA9_0 == '\'') && ((quote == Quote.DOUBLE || quote == Quote.NONE))) {
                    int LA9_3 = input.LA(2);

                    if ((quote == Quote.NONE)) {
                        alt9 = 1;
                    } else if ((quote == Quote.DOUBLE)) {
                        alt9 = 2;
                    } else {
                        NoViableAltException nvae = new NoViableAltException(
                                "191:24: ({...}? =>~ ( '<' ) (~ ( '<' | '$' ) )* | {...}? =>~ ( '<' | '\"' ) (~ ( '<' | '$' | '\"' ) )* | {...}? =>~ ( '<' | '\\'' ) (~ ( '<' | '$' | '\\'' ) )* )",
                                9, 3, input);

                        throw nvae;
                    }
                } else {
                    NoViableAltException nvae = new NoViableAltException(
                            "191:24: ({...}? =>~ ( '<' ) (~ ( '<' | '$' ) )* | {...}? =>~ ( '<' | '\"' ) (~ ( '<' | '$' | '\"' ) )* | {...}? =>~ ( '<' | '\\'' ) (~ ( '<' | '$' | '\\'' ) )* )",
                            9, 0, input);

                    throw nvae;
                }
                switch (alt9) {
                case 1:
                    // Jsp.g:192:11: {...}? =>~ ( '<' ) (~ ( '<' | '$' ) )*
                {
                    if (!(quote == Quote.NONE)) {
                        throw new FailedPredicateException(input, "PCDATA", " quote == Quote.NONE ");
                    }
                    if ((input.LA(1) >= '\u0000' && input.LA(1) <= ';')
                            || (input.LA(1) >= '=' && input.LA(1) <= '\uFFFE')) {
                        input.consume();

                    } else {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }

                    // Jsp.g:192:48: (~ ( '<' | '$' ) )*
                    loop6: do {
                        int alt6 = 2;
                        int LA6_0 = input.LA(1);

                        if (((LA6_0 >= '\u0000' && LA6_0 <= '#') || (LA6_0 >= '%' && LA6_0 <= ';') || (LA6_0 >= '=' && LA6_0 <= '\uFFFE'))) {
                            alt6 = 1;
                        }

                        switch (alt6) {
                        case 1:
                            // Jsp.g:192:50: ~ ( '<' | '$' )
                        {
                            if ((input.LA(1) >= '\u0000' && input.LA(1) <= '#')
                                    || (input.LA(1) >= '%' && input.LA(1) <= ';')
                                    || (input.LA(1) >= '=' && input.LA(1) <= '\uFFFE')) {
                                input.consume();

                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }

                        }
                            break;

                        default:
                            break loop6;
                        }
                    } while (true);

                }
                    break;
                case 2:
                    // Jsp.g:193:11: {...}? =>~ ( '<' | '\"' ) (~ ( '<' | '$' | '\"' ) )*
                {
                    if (!(quote == Quote.DOUBLE)) {
                        throw new FailedPredicateException(input, "PCDATA", " quote == Quote.DOUBLE ");
                    }
                    if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= ';')
                            || (input.LA(1) >= '=' && input.LA(1) <= '\uFFFE')) {
                        input.consume();

                    } else {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }

                    // Jsp.g:193:56: (~ ( '<' | '$' | '\"' ) )*
                    loop7: do {
                        int alt7 = 2;
                        int LA7_0 = input.LA(1);

                        if (((LA7_0 >= '\u0000' && LA7_0 <= '!') || LA7_0 == '#' || (LA7_0 >= '%' && LA7_0 <= ';') || (LA7_0 >= '=' && LA7_0 <= '\uFFFE'))) {
                            alt7 = 1;
                        }

                        switch (alt7) {
                        case 1:
                            // Jsp.g:193:58: ~ ( '<' | '$' | '\"' )
                        {
                            if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!') || input.LA(1) == '#'
                                    || (input.LA(1) >= '%' && input.LA(1) <= ';')
                                    || (input.LA(1) >= '=' && input.LA(1) <= '\uFFFE')) {
                                input.consume();

                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }

                        }
                            break;

                        default:
                            break loop7;
                        }
                    } while (true);

                }
                    break;
                case 3:
                    // Jsp.g:194:11: {...}? =>~ ( '<' | '\\'' ) (~ ( '<' | '$' | '\\'' ) )*
                {
                    if (!(quote == Quote.SINGLE)) {
                        throw new FailedPredicateException(input, "PCDATA", " quote == Quote.SINGLE ");
                    }
                    if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&') || (input.LA(1) >= '(' && input.LA(1) <= ';')
                            || (input.LA(1) >= '=' && input.LA(1) <= '\uFFFE')) {
                        input.consume();

                    } else {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }

                    // Jsp.g:194:57: (~ ( '<' | '$' | '\\'' ) )*
                    loop8: do {
                        int alt8 = 2;
                        int LA8_0 = input.LA(1);

                        if (((LA8_0 >= '\u0000' && LA8_0 <= '#') || (LA8_0 >= '%' && LA8_0 <= '&')
                                || (LA8_0 >= '(' && LA8_0 <= ';') || (LA8_0 >= '=' && LA8_0 <= '\uFFFE'))) {
                            alt8 = 1;
                        }

                        switch (alt8) {
                        case 1:
                            // Jsp.g:194:59: ~ ( '<' | '$' | '\\'' )
                        {
                            if ((input.LA(1) >= '\u0000' && input.LA(1) <= '#')
                                    || (input.LA(1) >= '%' && input.LA(1) <= '&')
                                    || (input.LA(1) >= '(' && input.LA(1) <= ';')
                                    || (input.LA(1) >= '=' && input.LA(1) <= '\uFFFE')) {
                                input.consume();

                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }

                        }
                            break;

                        default:
                            break loop8;
                        }
                    } while (true);

                }
                    break;

                }

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end PCDATA

    // $ANTLR start GENERIC_ID
    public final void mGENERIC_ID() throws RecognitionException {
        try {
            int _type = GENERIC_ID;
            // Jsp.g:199:5: ({...}? => ( LETTER | '_' | ':' ) ( NAMECHAR )* )
            // Jsp.g:199:7: {...}? => ( LETTER | '_' | ':' ) ( NAMECHAR )*
            {
                if (!(inTag())) {
                    throw new FailedPredicateException(input, "GENERIC_ID", " inTag() ");
                }
                if (input.LA(1) == ':' || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_'
                        || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

                // Jsp.g:199:45: ( NAMECHAR )*
                loop10: do {
                    int alt10 = 2;
                    int LA10_0 = input.LA(1);

                    if (((LA10_0 >= '-' && LA10_0 <= '.') || (LA10_0 >= '0' && LA10_0 <= ':')
                            || (LA10_0 >= 'A' && LA10_0 <= 'Z') || LA10_0 == '_' || (LA10_0 >= 'a' && LA10_0 <= 'z'))) {
                        alt10 = 1;
                    }

                    switch (alt10) {
                    case 1:
                        // Jsp.g:199:47: NAMECHAR
                    {
                        mNAMECHAR();

                    }
                        break;

                    default:
                        break loop10;
                    }
                } while (true);

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end GENERIC_ID

    // $ANTLR start NAMECHAR
    public final void mNAMECHAR() throws RecognitionException {
        try {
            // Jsp.g:202:19: ( LETTER | DIGIT | '.' | '-' | '_' | ':' )
            // Jsp.g:
            {
                if ((input.LA(1) >= '-' && input.LA(1) <= '.') || (input.LA(1) >= '0' && input.LA(1) <= ':')
                        || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_'
                        || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

            }

        } finally {
        }
    }

    // $ANTLR end NAMECHAR

    // $ANTLR start DIGIT
    public final void mDIGIT() throws RecognitionException {
        try {
            // Jsp.g:203:16: ( '0' .. '9' )
            // Jsp.g:203:18: '0' .. '9'
            {
                matchRange('0', '9');

            }

        } finally {
        }
    }

    // $ANTLR end DIGIT

    // $ANTLR start LETTER
    public final void mLETTER() throws RecognitionException {
        try {
            // Jsp.g:204:17: ( 'a' .. 'z' | 'A' .. 'Z' )
            // Jsp.g:
            {
                if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

            }

        } finally {
        }
    }

    // $ANTLR end LETTER

    // $ANTLR start WHITESPACE
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            // Jsp.g:207:5: ({...}? => ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // Jsp.g:207:7: {...}? => ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
                if (!(inTag())) {
                    throw new FailedPredicateException(input, "WHITESPACE", " inTag() ");
                }
                if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || (input.LA(1) >= '\f' && input.LA(1) <= '\r')
                        || input.LA(1) == ' ') {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

                channel = HIDDEN;

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end WHITESPACE

    // $ANTLR start PROCESSING_INSTRUCTION
    public final void mPROCESSING_INSTRUCTION() throws RecognitionException {
        try {
            int _type = PROCESSING_INSTRUCTION;
            // Jsp.g:211:5: ({...}? => '<?' ( options {greedy=false; } : . )* '?>' )
            // Jsp.g:211:7: {...}? => '<?' ( options {greedy=false; } : . )* '?>'
            {
                if (!(!inTag())) {
                    throw new FailedPredicateException(input, "PROCESSING_INSTRUCTION", " ! inTag() ");
                }
                match("<?");

                // Jsp.g:211:29: ( options {greedy=false; } : . )*
                loop11: do {
                    int alt11 = 2;
                    int LA11_0 = input.LA(1);

                    if ((LA11_0 == '?')) {
                        int LA11_1 = input.LA(2);

                        if ((LA11_1 == '>')) {
                            alt11 = 2;
                        } else if (((LA11_1 >= '\u0000' && LA11_1 <= '=') || (LA11_1 >= '?' && LA11_1 <= '\uFFFE'))) {
                            alt11 = 1;
                        }

                    } else if (((LA11_0 >= '\u0000' && LA11_0 <= '>') || (LA11_0 >= '@' && LA11_0 <= '\uFFFE'))) {
                        alt11 = 1;
                    }

                    switch (alt11) {
                    case 1:
                        // Jsp.g:211:61: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop11;
                    }
                } while (true);

                match("?>");

                trim(2, 2);

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end PROCESSING_INSTRUCTION

    // $ANTLR start DOCTYPE_DEFINITION
    public final void mDOCTYPE_DEFINITION() throws RecognitionException {
        try {
            int _type = DOCTYPE_DEFINITION;
            // Jsp.g:215:5: ({...}? => '<!DOCTYPE' ( options {greedy=false; } : . )* '>' )
            // Jsp.g:215:7: {...}? => '<!DOCTYPE' ( options {greedy=false; } : . )* '>'
            {
                if (!(!inTag())) {
                    throw new FailedPredicateException(input, "DOCTYPE_DEFINITION", " ! inTag() ");
                }
                match("<!DOCTYPE");

                // Jsp.g:215:36: ( options {greedy=false; } : . )*
                loop12: do {
                    int alt12 = 2;
                    int LA12_0 = input.LA(1);

                    if ((LA12_0 == '>')) {
                        alt12 = 2;
                    } else if (((LA12_0 >= '\u0000' && LA12_0 <= '=') || (LA12_0 >= '?' && LA12_0 <= '\uFFFE'))) {
                        alt12 = 1;
                    }

                    switch (alt12) {
                    case 1:
                        // Jsp.g:215:68: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop12;
                    }
                } while (true);

                match('>');

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end DOCTYPE_DEFINITION

    // $ANTLR start JSP_DIRECTIVE_OPEN
    public final void mJSP_DIRECTIVE_OPEN() throws RecognitionException {
        try {
            int _type = JSP_DIRECTIVE_OPEN;
            // Jsp.g:219:5: ({...}? => '<%@' )
            // Jsp.g:219:7: {...}? => '<%@'
            {
                if (!(!inTag())) {
                    throw new FailedPredicateException(input, "JSP_DIRECTIVE_OPEN", " ! inTag() ");
                }
                match("<%@");

                tags++;

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end JSP_DIRECTIVE_OPEN

    // $ANTLR start JSP_DIRECTIVE_CLOSE
    public final void mJSP_DIRECTIVE_CLOSE() throws RecognitionException {
        try {
            int _type = JSP_DIRECTIVE_CLOSE;
            // Jsp.g:223:5: ({...}? => '%>' )
            // Jsp.g:223:7: {...}? => '%>'
            {
                if (!(inTag())) {
                    throw new FailedPredicateException(input, "JSP_DIRECTIVE_CLOSE", " inTag() ");
                }
                match("%>");

                tags--;

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end JSP_DIRECTIVE_CLOSE

    // $ANTLR start JSP_COMMENT
    public final void mJSP_COMMENT() throws RecognitionException {
        try {
            int _type = JSP_COMMENT;
            // Jsp.g:227:5: ( '<%--' ( options {greedy=false; } : . )* '--%>' )
            // Jsp.g:227:7: '<%--' ( options {greedy=false; } : . )* '--%>'
            {
                match("<%--");

                // Jsp.g:227:14: ( options {greedy=false; } : . )*
                loop13: do {
                    int alt13 = 2;
                    int LA13_0 = input.LA(1);

                    if ((LA13_0 == '-')) {
                        int LA13_1 = input.LA(2);

                        if ((LA13_1 == '-')) {
                            int LA13_3 = input.LA(3);

                            if ((LA13_3 == '%')) {
                                int LA13_4 = input.LA(4);

                                if ((LA13_4 == '>')) {
                                    alt13 = 2;
                                } else if (((LA13_4 >= '\u0000' && LA13_4 <= '=') || (LA13_4 >= '?' && LA13_4 <= '\uFFFE'))) {
                                    alt13 = 1;
                                }

                            } else if (((LA13_3 >= '\u0000' && LA13_3 <= '$') || (LA13_3 >= '&' && LA13_3 <= '\uFFFE'))) {
                                alt13 = 1;
                            }

                        } else if (((LA13_1 >= '\u0000' && LA13_1 <= ',') || (LA13_1 >= '.' && LA13_1 <= '\uFFFE'))) {
                            alt13 = 1;
                        }

                    } else if (((LA13_0 >= '\u0000' && LA13_0 <= ',') || (LA13_0 >= '.' && LA13_0 <= '\uFFFE'))) {
                        alt13 = 1;
                    }

                    switch (alt13) {
                    case 1:
                        // Jsp.g:227:46: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop13;
                    }
                } while (true);

                match("--%>");

                trim(4, 4);

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end JSP_COMMENT

    // $ANTLR start JSP_EXPRESSION
    public final void mJSP_EXPRESSION() throws RecognitionException {
        try {
            int _type = JSP_EXPRESSION;
            // Jsp.g:231:5: ( '<%=' ( options {greedy=false; } : . )* '%>' )
            // Jsp.g:231:7: '<%=' ( options {greedy=false; } : . )* '%>'
            {
                match("<%=");

                // Jsp.g:231:13: ( options {greedy=false; } : . )*
                loop14: do {
                    int alt14 = 2;
                    int LA14_0 = input.LA(1);

                    if ((LA14_0 == '%')) {
                        int LA14_1 = input.LA(2);

                        if ((LA14_1 == '>')) {
                            alt14 = 2;
                        } else if (((LA14_1 >= '\u0000' && LA14_1 <= '=') || (LA14_1 >= '?' && LA14_1 <= '\uFFFE'))) {
                            alt14 = 1;
                        }

                    } else if (((LA14_0 >= '\u0000' && LA14_0 <= '$') || (LA14_0 >= '&' && LA14_0 <= '\uFFFE'))) {
                        alt14 = 1;
                    }

                    switch (alt14) {
                    case 1:
                        // Jsp.g:231:45: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop14;
                    }
                } while (true);

                match("%>");

                trim(3, 2);

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end JSP_EXPRESSION

    // $ANTLR start JSP_SCRIPTLET
    public final void mJSP_SCRIPTLET() throws RecognitionException {
        try {
            int _type = JSP_SCRIPTLET;
            // Jsp.g:235:5: ( '<%' ~ ( '@' | '=' | '-' ) ( options {greedy=false; } : . )* '%>' )
            // Jsp.g:235:7: '<%' ~ ( '@' | '=' | '-' ) ( options {greedy=false; } : . )* '%>'
            {
                match("<%");

                if ((input.LA(1) >= '\u0000' && input.LA(1) <= ',') || (input.LA(1) >= '.' && input.LA(1) <= '<')
                        || (input.LA(1) >= '>' && input.LA(1) <= '?')
                        || (input.LA(1) >= 'A' && input.LA(1) <= '\uFFFE')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

                // Jsp.g:235:33: ( options {greedy=false; } : . )*
                loop15: do {
                    int alt15 = 2;
                    int LA15_0 = input.LA(1);

                    if ((LA15_0 == '%')) {
                        int LA15_1 = input.LA(2);

                        if ((LA15_1 == '>')) {
                            alt15 = 2;
                        } else if (((LA15_1 >= '\u0000' && LA15_1 <= '=') || (LA15_1 >= '?' && LA15_1 <= '\uFFFE'))) {
                            alt15 = 1;
                        }

                    } else if (((LA15_0 >= '\u0000' && LA15_0 <= '$') || (LA15_0 >= '&' && LA15_0 <= '\uFFFE'))) {
                        alt15 = 1;
                    }

                    switch (alt15) {
                    case 1:
                        // Jsp.g:235:65: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop15;
                    }
                } while (true);

                match("%>");

                trim(2, 2);

            }

            this.type = _type;
        } finally {
        }
    }

    // $ANTLR end JSP_SCRIPTLET

    public void mTokens() throws RecognitionException {
        // Jsp.g:1:8: ( CDATA | COMMENT | TAG_START_OPEN | TAG_END_OPEN | TAG_CLOSE | TAG_EMPTY_CLOSE | ATTR_EQ | ATTR_VALUE_OPEN | ATTR_VALUE_CLOSE | EL_EXPR | PCDATA | GENERIC_ID | WHITESPACE | PROCESSING_INSTRUCTION | DOCTYPE_DEFINITION | JSP_DIRECTIVE_OPEN | JSP_DIRECTIVE_CLOSE | JSP_COMMENT | JSP_EXPRESSION | JSP_SCRIPTLET )
        int alt16 = 20;
        alt16 = dfa16.predict(input);
        switch (alt16) {
        case 1:
            // Jsp.g:1:10: CDATA
        {
            mCDATA();

        }
            break;
        case 2:
            // Jsp.g:1:16: COMMENT
        {
            mCOMMENT();

        }
            break;
        case 3:
            // Jsp.g:1:24: TAG_START_OPEN
        {
            mTAG_START_OPEN();

        }
            break;
        case 4:
            // Jsp.g:1:39: TAG_END_OPEN
        {
            mTAG_END_OPEN();

        }
            break;
        case 5:
            // Jsp.g:1:52: TAG_CLOSE
        {
            mTAG_CLOSE();

        }
            break;
        case 6:
            // Jsp.g:1:62: TAG_EMPTY_CLOSE
        {
            mTAG_EMPTY_CLOSE();

        }
            break;
        case 7:
            // Jsp.g:1:78: ATTR_EQ
        {
            mATTR_EQ();

        }
            break;
        case 8:
            // Jsp.g:1:86: ATTR_VALUE_OPEN
        {
            mATTR_VALUE_OPEN();

        }
            break;
        case 9:
            // Jsp.g:1:102: ATTR_VALUE_CLOSE
        {
            mATTR_VALUE_CLOSE();

        }
            break;
        case 10:
            // Jsp.g:1:119: EL_EXPR
        {
            mEL_EXPR();

        }
            break;
        case 11:
            // Jsp.g:1:127: PCDATA
        {
            mPCDATA();

        }
            break;
        case 12:
            // Jsp.g:1:134: GENERIC_ID
        {
            mGENERIC_ID();

        }
            break;
        case 13:
            // Jsp.g:1:145: WHITESPACE
        {
            mWHITESPACE();

        }
            break;
        case 14:
            // Jsp.g:1:156: PROCESSING_INSTRUCTION
        {
            mPROCESSING_INSTRUCTION();

        }
            break;
        case 15:
            // Jsp.g:1:179: DOCTYPE_DEFINITION
        {
            mDOCTYPE_DEFINITION();

        }
            break;
        case 16:
            // Jsp.g:1:198: JSP_DIRECTIVE_OPEN
        {
            mJSP_DIRECTIVE_OPEN();

        }
            break;
        case 17:
            // Jsp.g:1:217: JSP_DIRECTIVE_CLOSE
        {
            mJSP_DIRECTIVE_CLOSE();

        }
            break;
        case 18:
            // Jsp.g:1:237: JSP_COMMENT
        {
            mJSP_COMMENT();

        }
            break;
        case 19:
            // Jsp.g:1:249: JSP_EXPRESSION
        {
            mJSP_EXPRESSION();

        }
            break;
        case 20:
            // Jsp.g:1:264: JSP_SCRIPTLET
        {
            mJSP_SCRIPTLET();

        }
            break;

        }

    }

    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS = "\1\uffff\1\20\1\22\1\26\1\27\1\30\1\32\1\26\1\35\1\36\1\26\12\uffff"
            + "\1\50\5\uffff\1\26\1\63\2\uffff\1\66\16\uffff\1\70\1\72\1\uffff"
            + "\1\26\1\75\6\uffff\1\77\1\uffff\1\101\1\102\3\uffff\1\103\3\uffff";
    static final String DFA16_eofS = "\104\uffff";
    static final String DFA16_minS = "\1\0\1\41\11\0\1\uffff\1\0\1\55\4\uffff\1\0\2\uffff\1\0\1\uffff"
            + "\2\0\1\uffff\6\0\10\uffff\1\0\5\uffff\2\0\1\uffff\3\0\2\uffff\1"
            + "\0\1\uffff\2\0\1\uffff\2\0\2\uffff\2\0\1\uffff\2\0";
    static final String DFA16_maxS = "\1\ufffe\1\77\11\ufffe\1\uffff\1\ufffe\1\133\4\uffff\1\0\2\uffff"
            + "\1\ufffe\1\uffff\2\0\1\uffff\1\0\2\ufffe\2\0\1\ufffe\10\uffff\1"
            + "\0\5\uffff\2\ufffe\1\uffff\2\ufffe\1\0\2\uffff\1\0\1\uffff\1\0\1"
            + "\ufffe\1\uffff\2\ufffe\2\uffff\1\0\1\ufffe\1\uffff\2\0";
    static final String DFA16_acceptS = "\13\uffff\1\13\2\uffff\1\16\1\4\1\3\1\13\1\uffff\2\13\1\uffff\1"
            + "\13\2\uffff\1\13\6\uffff\1\24\1\23\1\22\1\20\1\1\1\2\1\17\1\5\1"
            + "\uffff\1\7\1\10\1\11\1\10\1\11\2\uffff\1\12\3\uffff\1\14\1\15\1"
            + "\uffff\1\6\2\uffff\1\13\2\uffff\1\13\1\21\2\uffff\1\13\2\uffff";
    static final String DFA16_specialS = "\1\36\1\40\1\4\1\1\1\30\1\15\1\12\1\21\1\13\1\43\1\42\1\uffff\1"
            + "\44\1\45\4\uffff\1\2\2\uffff\1\16\1\uffff\1\33\1\6\1\uffff\1\7\1"
            + "\41\1\3\1\35\1\27\1\25\10\uffff\1\10\5\uffff\1\22\1\24\1\uffff\1"
            + "\37\1\5\1\34\2\uffff\1\0\1\uffff\1\23\1\17\1\uffff\1\14\1\11\2\uffff" + "\1\32\1\26\1\uffff\1\31\1\20}>";
    static final String[] DFA16_transitionS = {
            "\11\13\2\11\1\13\2\11\22\13\1\11\1\13\1\5\1\13\1\7\1\12\1\13"
                    + "\1\6\7\13\1\3\12\13\1\10\1\13\1\1\1\4\1\2\2\13\32\10\4\13\1" + "\10\1\13\32\10\uff84\13",
            "\1\15\3\uffff\1\14\11\uffff\1\17\17\uffff\1\16",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\24\21\1\uffff\uffc2\21",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\24\21\1\uffff\1\21\1\25\uffc0" + "\21",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\24\21\1\uffff\uffc2\21",
            "\44\24\1\uffff\2\24\1\31\24\24\1\uffff\uffc2\24",
            "\42\23\1\31\1\23\1\uffff\27\23\1\uffff\uffc2\23",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\24\21\1\uffff\76\21\1\33" + "\uff83\21",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\5\21\2\34\1\21\13\34\1\21"
                    + "\1\uffff\4\21\32\34\4\21\1\34\1\21\32\34\uff84\21",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\24\21\1\uffff\uffc2\21",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\24\21\1\uffff\1\21\1\37\uffc0" + "\21",
            "",
            "\55\40\1\42\17\40\1\41\2\40\1\43\uffbe\40",
            "\1\45\26\uffff\1\46\26\uffff\1\44",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\24\21\1\uffff\uffc2\21",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\42\61\1\62\1\61\1\60\2\61\1\57\24\61\1\60\100\61\1\56\uff81" + "\61",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\5\21\2\34\1\21\13\34\1\21"
                    + "\1\uffff\4\21\32\34\4\21\1\34\1\21\32\34\uff84\21", "\1\uffff", "\1\uffff",
            "\42\21\1\24\1\21\1\uffff\2\21\1\23\24\21\1\uffff\uffc2\21", "", "", "", "", "", "", "", "", "\1\uffff",
            "", "", "", "", "", "\42\61\1\62\1\61\1\60\2\61\1\57\24\61\1\60\100\61\1\56\uff81" + "\61",
            "\42\57\1\73\1\57\1\60\27\57\1\60\100\57\1\71\uff81\57", "",
            "\42\61\1\62\1\61\1\60\2\61\1\57\24\61\1\60\100\61\1\56\uff81" + "\61",
            "\44\62\1\60\2\62\1\73\24\62\1\60\100\62\1\74\uff81\62", "\1\uffff", "", "", "\1\uffff", "", "\1\uffff",
            "\42\57\1\73\1\57\1\60\27\57\1\60\100\57\1\71\uff81\57", "",
            "\44\73\1\60\27\73\1\60\100\73\1\100\uff81\73", "\44\62\1\60\2\62\1\73\24\62\1\60\100\62\1\74\uff81\62",
            "", "", "\1\uffff", "\44\73\1\60\27\73\1\60\100\73\1\100\uff81\73", "", "\1\uffff", "\1\uffff" };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }

        public String getDescription() {
            return "1:1: Tokens : ( CDATA | COMMENT | TAG_START_OPEN | TAG_END_OPEN | TAG_CLOSE | TAG_EMPTY_CLOSE | ATTR_EQ | ATTR_VALUE_OPEN | ATTR_VALUE_CLOSE | EL_EXPR | PCDATA | GENERIC_ID | WHITESPACE | PROCESSING_INSTRUCTION | DOCTYPE_DEFINITION | JSP_DIRECTIVE_OPEN | JSP_DIRECTIVE_CLOSE | JSP_COMMENT | JSP_EXPRESSION | JSP_SCRIPTLET );";
        }

        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
            int _s = s;
            switch (s) {
            case 0:
                int LA16_54 = input.LA(1);

                int index16_54 = input.index();
                input.rewind();
                s = -1;
                if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 61;
                }

                else if ((inTag())) {
                    s = 62;
                }

                input.seek(index16_54);
                if (s >= 0)
                    return s;
                break;
            case 1:
                int LA16_3 = input.LA(1);

                int index16_3 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_3 == '>')
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || inTag() || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 21;
                }

                else if (((LA16_3 >= '\u0000' && LA16_3 <= '!') || LA16_3 == '#' || (LA16_3 >= '%' && LA16_3 <= '&')
                        || (LA16_3 >= '(' && LA16_3 <= ';') || LA16_3 == '=' || (LA16_3 >= '?' && LA16_3 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 17;
                }

                else if ((LA16_3 == '\'')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 19;
                }

                else if ((LA16_3 == '\"')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 20;
                }

                else
                    s = 22;

                input.seek(index16_3);
                if (s >= 0)
                    return s;
                break;
            case 2:
                int LA16_18 = input.LA(1);

                int index16_18 = input.index();
                input.rewind();
                s = -1;
                if ((inTag())) {
                    s = 39;
                }

                else if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 25;
                }

                input.seek(index16_18);
                if (s >= 0)
                    return s;
                break;
            case 3:
                int LA16_28 = input.LA(1);

                int index16_28 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_28 >= '-' && LA16_28 <= '.') || (LA16_28 >= '0' && LA16_28 <= ':')
                        || (LA16_28 >= 'A' && LA16_28 <= 'Z') || LA16_28 == '_' || (LA16_28 >= 'a' && LA16_28 <= 'z'))
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || inTag() || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 28;
                }

                else if ((LA16_28 == '\'')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 19;
                }

                else if ((LA16_28 == '\"')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 20;
                }

                else if (((LA16_28 >= '\u0000' && LA16_28 <= '!') || LA16_28 == '#'
                        || (LA16_28 >= '%' && LA16_28 <= '&') || (LA16_28 >= '(' && LA16_28 <= ',') || LA16_28 == '/'
                        || LA16_28 == ';' || (LA16_28 >= '=' && LA16_28 <= '@') || (LA16_28 >= '[' && LA16_28 <= '^')
                        || LA16_28 == '`' || (LA16_28 >= '{' && LA16_28 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 17;
                }

                else
                    s = 51;

                input.seek(index16_28);
                if (s >= 0)
                    return s;
                break;
            case 4:
                int LA16_2 = input.LA(1);

                int index16_2 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_2 >= '\u0000' && LA16_2 <= '!') || LA16_2 == '#' || (LA16_2 >= '%' && LA16_2 <= '&')
                        || (LA16_2 >= '(' && LA16_2 <= ';') || (LA16_2 >= '=' && LA16_2 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 17;
                }

                else if ((LA16_2 == '\'')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 19;
                }

                else if ((LA16_2 == '\"')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 20;
                }

                else
                    s = 18;

                input.seek(index16_2);
                if (s >= 0)
                    return s;
                break;
            case 5:
                int LA16_50 = input.LA(1);

                int index16_50 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_50 == '}')) {
                    s = 60;
                }

                else if (((LA16_50 >= '\u0000' && LA16_50 <= '#') || (LA16_50 >= '%' && LA16_50 <= '&')
                        || (LA16_50 >= '(' && LA16_50 <= ';') || (LA16_50 >= '=' && LA16_50 <= '|') || (LA16_50 >= '~' && LA16_50 <= '\uFFFE'))) {
                    s = 50;
                }

                else if ((LA16_50 == '$' || LA16_50 == '<')) {
                    s = 48;
                }

                else if ((LA16_50 == '\'')) {
                    s = 59;
                }

                else
                    s = 61;

                input.seek(index16_50);
                if (s >= 0)
                    return s;
                break;
            case 6:
                int LA16_24 = input.LA(1);

                int index16_24 = input.index();
                input.rewind();
                s = -1;
                if (((inTag() && quote != Quote.DOUBLE))) {
                    s = 42;
                }

                else if (((!inTag() && quote == Quote.DOUBLE))) {
                    s = 43;
                }

                else if ((((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 25;
                }

                input.seek(index16_24);
                if (s >= 0)
                    return s;
                break;
            case 7:
                int LA16_26 = input.LA(1);

                int index16_26 = input.index();
                input.rewind();
                s = -1;
                if (((inTag() && quote != Quote.DOUBLE))) {
                    s = 44;
                }

                else if (((!inTag() && quote == Quote.SINGLE))) {
                    s = 45;
                }

                else if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 25;
                }

                input.seek(index16_26);
                if (s >= 0)
                    return s;
                break;
            case 8:
                int LA16_40 = input.LA(1);

                int index16_40 = input.index();
                input.rewind();
                s = -1;
                if ((inTag())) {
                    s = 55;
                }

                else if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 25;
                }

                input.seek(index16_40);
                if (s >= 0)
                    return s;
                break;
            case 9:
                int LA16_60 = input.LA(1);

                int index16_60 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_60 == '}')) {
                    s = 60;
                }

                else if (((LA16_60 >= '\u0000' && LA16_60 <= '#') || (LA16_60 >= '%' && LA16_60 <= '&')
                        || (LA16_60 >= '(' && LA16_60 <= ';') || (LA16_60 >= '=' && LA16_60 <= '|') || (LA16_60 >= '~' && LA16_60 <= '\uFFFE'))) {
                    s = 50;
                }

                else if ((LA16_60 == '$' || LA16_60 == '<')) {
                    s = 48;
                }

                else if ((LA16_60 == '\'')) {
                    s = 59;
                }

                else
                    s = 66;

                input.seek(index16_60);
                if (s >= 0)
                    return s;
                break;
            case 10:
                int LA16_6 = input.LA(1);

                int index16_6 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_6 >= '\u0000' && LA16_6 <= '!') || LA16_6 == '#' || (LA16_6 >= '%' && LA16_6 <= ';') || (LA16_6 >= '=' && LA16_6 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 19;
                }

                else if ((LA16_6 == '\"') && ((!inTag() && quote == Quote.NONE))) {
                    s = 25;
                }

                else
                    s = 26;

                input.seek(index16_6);
                if (s >= 0)
                    return s;
                break;
            case 11:
                int LA16_8 = input.LA(1);

                int index16_8 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_8 >= '-' && LA16_8 <= '.') || (LA16_8 >= '0' && LA16_8 <= ':')
                        || (LA16_8 >= 'A' && LA16_8 <= 'Z') || LA16_8 == '_' || (LA16_8 >= 'a' && LA16_8 <= 'z'))
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || inTag() || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 28;
                }

                else if (((LA16_8 >= '\u0000' && LA16_8 <= '!') || LA16_8 == '#' || (LA16_8 >= '%' && LA16_8 <= '&')
                        || (LA16_8 >= '(' && LA16_8 <= ',') || LA16_8 == '/' || LA16_8 == ';'
                        || (LA16_8 >= '=' && LA16_8 <= '@') || (LA16_8 >= '[' && LA16_8 <= '^') || LA16_8 == '`' || (LA16_8 >= '{' && LA16_8 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 17;
                }

                else if ((LA16_8 == '\'')
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 19;
                }

                else if ((LA16_8 == '\"')
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 20;
                }

                else
                    s = 29;

                input.seek(index16_8);
                if (s >= 0)
                    return s;
                break;
            case 12:
                int LA16_59 = input.LA(1);

                int index16_59 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_59 == '}')) {
                    s = 64;
                }

                else if (((LA16_59 >= '\u0000' && LA16_59 <= '#') || (LA16_59 >= '%' && LA16_59 <= ';')
                        || (LA16_59 >= '=' && LA16_59 <= '|') || (LA16_59 >= '~' && LA16_59 <= '\uFFFE'))) {
                    s = 59;
                }

                else if ((LA16_59 == '$' || LA16_59 == '<')) {
                    s = 48;
                }

                else
                    s = 65;

                input.seek(index16_59);
                if (s >= 0)
                    return s;
                break;
            case 13:
                int LA16_5 = input.LA(1);

                int index16_5 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_5 >= '\u0000' && LA16_5 <= '#') || (LA16_5 >= '%' && LA16_5 <= '&')
                        || (LA16_5 >= '(' && LA16_5 <= ';') || (LA16_5 >= '=' && LA16_5 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 20;
                }

                else if ((LA16_5 == '\'') && ((!inTag() && quote == Quote.NONE))) {
                    s = 25;
                }

                else
                    s = 24;

                input.seek(index16_5);
                if (s >= 0)
                    return s;
                break;
            case 14:
                int LA16_21 = input.LA(1);

                int index16_21 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_21 >= '\u0000' && LA16_21 <= '!') || LA16_21 == '#' || (LA16_21 >= '%' && LA16_21 <= '&')
                        || (LA16_21 >= '(' && LA16_21 <= ';') || (LA16_21 >= '=' && LA16_21 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 17;
                }

                else if ((LA16_21 == '\'')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 19;
                }

                else if ((LA16_21 == '\"')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 20;
                }

                else
                    s = 40;

                input.seek(index16_21);
                if (s >= 0)
                    return s;
                break;
            case 15:
                int LA16_57 = input.LA(1);

                int index16_57 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_57 == '}')) {
                    s = 57;
                }

                else if (((LA16_57 >= '\u0000' && LA16_57 <= '!') || LA16_57 == '#'
                        || (LA16_57 >= '%' && LA16_57 <= ';') || (LA16_57 >= '=' && LA16_57 <= '|') || (LA16_57 >= '~' && LA16_57 <= '\uFFFE'))) {
                    s = 47;
                }

                else if ((LA16_57 == '$' || LA16_57 == '<')) {
                    s = 48;
                }

                else if ((LA16_57 == '\"')) {
                    s = 59;
                }

                else
                    s = 63;

                input.seek(index16_57);
                if (s >= 0)
                    return s;
                break;
            case 16:
                int LA16_67 = input.LA(1);

                int index16_67 = input.index();
                input.rewind();
                s = -1;
                if ((!((!inTag() && quote == Quote.NONE)))) {
                    s = 48;
                }

                else if (((!inTag() && quote == Quote.NONE))) {
                    s = 65;
                }

                input.seek(index16_67);
                if (s >= 0)
                    return s;
                break;
            case 17:
                int LA16_7 = input.LA(1);

                int index16_7 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_7 == '{')) {
                    s = 27;
                }

                else if (((LA16_7 >= '\u0000' && LA16_7 <= '!') || LA16_7 == '#' || (LA16_7 >= '%' && LA16_7 <= '&')
                        || (LA16_7 >= '(' && LA16_7 <= ';') || (LA16_7 >= '=' && LA16_7 <= 'z') || (LA16_7 >= '|' && LA16_7 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 17;
                }

                else if ((LA16_7 == '\'')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 19;
                }

                else if ((LA16_7 == '\"')
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 20;
                }

                else
                    s = 22;

                input.seek(index16_7);
                if (s >= 0)
                    return s;
                break;
            case 18:
                int LA16_46 = input.LA(1);

                int index16_46 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_46 == '}')) {
                    s = 46;
                }

                else if (((LA16_46 >= '\u0000' && LA16_46 <= '!') || LA16_46 == '#'
                        || (LA16_46 >= '%' && LA16_46 <= '&') || (LA16_46 >= '(' && LA16_46 <= ';')
                        || (LA16_46 >= '=' && LA16_46 <= '|') || (LA16_46 >= '~' && LA16_46 <= '\uFFFE'))) {
                    s = 49;
                }

                else if ((LA16_46 == '$' || LA16_46 == '<')) {
                    s = 48;
                }

                else if ((LA16_46 == '\'')) {
                    s = 47;
                }

                else if ((LA16_46 == '\"')) {
                    s = 50;
                }

                else
                    s = 56;

                input.seek(index16_46);
                if (s >= 0)
                    return s;
                break;
            case 19:
                int LA16_56 = input.LA(1);

                int index16_56 = input.index();
                input.rewind();
                s = -1;
                if ((!(((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE))))) {
                    s = 48;
                }

                else if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 61;
                }

                input.seek(index16_56);
                if (s >= 0)
                    return s;
                break;
            case 20:
                int LA16_47 = input.LA(1);

                int index16_47 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_47 == '}')) {
                    s = 57;
                }

                else if (((LA16_47 >= '\u0000' && LA16_47 <= '!') || LA16_47 == '#'
                        || (LA16_47 >= '%' && LA16_47 <= ';') || (LA16_47 >= '=' && LA16_47 <= '|') || (LA16_47 >= '~' && LA16_47 <= '\uFFFE'))) {
                    s = 47;
                }

                else if ((LA16_47 == '$' || LA16_47 == '<')) {
                    s = 48;
                }

                else if ((LA16_47 == '\"')) {
                    s = 59;
                }

                else
                    s = 58;

                input.seek(index16_47);
                if (s >= 0)
                    return s;
                break;
            case 21:
                int LA16_31 = input.LA(1);

                int index16_31 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_31 >= '\u0000' && LA16_31 <= '!') || LA16_31 == '#' || (LA16_31 >= '%' && LA16_31 <= '&')
                        || (LA16_31 >= '(' && LA16_31 <= ';') || (LA16_31 >= '=' && LA16_31 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 17;
                }

                else if ((LA16_31 == '\'')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 19;
                }

                else if ((LA16_31 == '\"')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 20;
                }

                else
                    s = 54;

                input.seek(index16_31);
                if (s >= 0)
                    return s;
                break;
            case 22:
                int LA16_64 = input.LA(1);

                int index16_64 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_64 == '}')) {
                    s = 64;
                }

                else if (((LA16_64 >= '\u0000' && LA16_64 <= '#') || (LA16_64 >= '%' && LA16_64 <= ';')
                        || (LA16_64 >= '=' && LA16_64 <= '|') || (LA16_64 >= '~' && LA16_64 <= '\uFFFE'))) {
                    s = 59;
                }

                else if ((LA16_64 == '$' || LA16_64 == '<')) {
                    s = 48;
                }

                else
                    s = 67;

                input.seek(index16_64);
                if (s >= 0)
                    return s;
                break;
            case 23:
                int LA16_30 = input.LA(1);

                int index16_30 = input.index();
                input.rewind();
                s = -1;
                if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 25;
                }

                else if ((inTag())) {
                    s = 53;
                }

                input.seek(index16_30);
                if (s >= 0)
                    return s;
                break;
            case 24:
                int LA16_4 = input.LA(1);

                int index16_4 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_4 >= '\u0000' && LA16_4 <= '!') || LA16_4 == '#' || (LA16_4 >= '%' && LA16_4 <= '&')
                        || (LA16_4 >= '(' && LA16_4 <= ';') || (LA16_4 >= '=' && LA16_4 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 17;
                }

                else if ((LA16_4 == '\'')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 19;
                }

                else if ((LA16_4 == '\"')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 20;
                }

                else
                    s = 23;

                input.seek(index16_4);
                if (s >= 0)
                    return s;
                break;
            case 25:
                int LA16_66 = input.LA(1);

                int index16_66 = input.index();
                input.rewind();
                s = -1;
                if ((!(((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE))))) {
                    s = 48;
                }

                else if ((((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 65;
                }

                input.seek(index16_66);
                if (s >= 0)
                    return s;
                break;
            case 26:
                int LA16_63 = input.LA(1);

                int index16_63 = input.index();
                input.rewind();
                s = -1;
                if ((!(((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE))))) {
                    s = 48;
                }

                else if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 65;
                }

                input.seek(index16_63);
                if (s >= 0)
                    return s;
                break;
            case 27:
                int LA16_23 = input.LA(1);

                int index16_23 = input.index();
                input.rewind();
                s = -1;
                if ((inTag())) {
                    s = 41;
                }

                else if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 25;
                }

                input.seek(index16_23);
                if (s >= 0)
                    return s;
                break;
            case 28:
                int LA16_51 = input.LA(1);

                int index16_51 = input.index();
                input.rewind();
                s = -1;
                if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 61;
                }

                else if ((inTag())) {
                    s = 52;
                }

                input.seek(index16_51);
                if (s >= 0)
                    return s;
                break;
            case 29:
                int LA16_29 = input.LA(1);

                int index16_29 = input.index();
                input.rewind();
                s = -1;
                if ((((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 25;
                }

                else if ((inTag())) {
                    s = 52;
                }

                input.seek(index16_29);
                if (s >= 0)
                    return s;
                break;
            case 30:
                int LA16_0 = input.LA(1);

                int index16_0 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_0 == '<')) {
                    s = 1;
                }

                else if ((LA16_0 == '>')
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || inTag() || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 2;
                }

                else if ((LA16_0 == '/')
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE) || inTag()
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 3;
                }

                else if ((LA16_0 == '=')
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || inTag()
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 4;
                }

                else if ((LA16_0 == '\"')
                        && (((!inTag() && quote == Quote.DOUBLE) || (inTag() && quote != Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (inTag() && quote != Quote.DOUBLE)
                                || (inTag() && quote != Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (inTag() && quote != Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (inTag() && quote != Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (inTag() && quote != Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 5;
                }

                else if ((LA16_0 == '\'')
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (inTag() && quote != Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (inTag() && quote != Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (inTag() && quote != Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (inTag() && quote != Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (inTag() && quote != Quote.DOUBLE) || (inTag() && quote != Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 6;
                }

                else if ((LA16_0 == '$')) {
                    s = 7;
                }

                else if ((LA16_0 == ':' || (LA16_0 >= 'A' && LA16_0 <= 'Z') || LA16_0 == '_' || (LA16_0 >= 'a' && LA16_0 <= 'z'))
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || inTag() || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 8;
                }

                else if (((LA16_0 >= '\t' && LA16_0 <= '\n') || (LA16_0 >= '\f' && LA16_0 <= '\r') || LA16_0 == ' ')
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE) || inTag()
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 9;
                }

                else if ((LA16_0 == '%')
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || inTag()
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 10;
                }

                else if (((LA16_0 >= '\u0000' && LA16_0 <= '\b') || LA16_0 == '\u000B'
                        || (LA16_0 >= '\u000E' && LA16_0 <= '\u001F') || LA16_0 == '!' || LA16_0 == '#'
                        || LA16_0 == '&' || (LA16_0 >= '(' && LA16_0 <= '.') || (LA16_0 >= '0' && LA16_0 <= '9')
                        || LA16_0 == ';' || (LA16_0 >= '?' && LA16_0 <= '@') || (LA16_0 >= '[' && LA16_0 <= '^')
                        || LA16_0 == '`' || (LA16_0 >= '{' && LA16_0 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 11;
                }

                input.seek(index16_0);
                if (s >= 0)
                    return s;
                break;
            case 31:
                int LA16_49 = input.LA(1);

                int index16_49 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_49 == '}')) {
                    s = 46;
                }

                else if (((LA16_49 >= '\u0000' && LA16_49 <= '!') || LA16_49 == '#'
                        || (LA16_49 >= '%' && LA16_49 <= '&') || (LA16_49 >= '(' && LA16_49 <= ';')
                        || (LA16_49 >= '=' && LA16_49 <= '|') || (LA16_49 >= '~' && LA16_49 <= '\uFFFE'))) {
                    s = 49;
                }

                else if ((LA16_49 == '$' || LA16_49 == '<')) {
                    s = 48;
                }

                else if ((LA16_49 == '\'')) {
                    s = 47;
                }

                else if ((LA16_49 == '\"')) {
                    s = 50;
                }

                else
                    s = 22;

                input.seek(index16_49);
                if (s >= 0)
                    return s;
                break;
            case 32:
                int LA16_1 = input.LA(1);

                int index16_1 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_1 == '%')) {
                    s = 12;
                }

                else if ((LA16_1 == '!')) {
                    s = 13;
                }

                else if ((LA16_1 == '?') && (!inTag())) {
                    s = 14;
                }

                else if ((LA16_1 == '/')) {
                    s = 15;
                }

                else
                    s = 16;

                input.seek(index16_1);
                if (s >= 0)
                    return s;
                break;
            case 33:
                int LA16_27 = input.LA(1);

                int index16_27 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_27 == '}')) {
                    s = 46;
                }

                else if ((LA16_27 == '\'')) {
                    s = 47;
                }

                else if ((LA16_27 == '$' || LA16_27 == '<')) {
                    s = 48;
                }

                else if (((LA16_27 >= '\u0000' && LA16_27 <= '!') || LA16_27 == '#'
                        || (LA16_27 >= '%' && LA16_27 <= '&') || (LA16_27 >= '(' && LA16_27 <= ';')
                        || (LA16_27 >= '=' && LA16_27 <= '|') || (LA16_27 >= '~' && LA16_27 <= '\uFFFE'))) {
                    s = 49;
                }

                else if ((LA16_27 == '\"')) {
                    s = 50;
                }

                else
                    s = 22;

                input.seek(index16_27);
                if (s >= 0)
                    return s;
                break;
            case 34:
                int LA16_10 = input.LA(1);

                int index16_10 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_10 == '>')
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || inTag()
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)
                                || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE)
                                || (!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 31;
                }

                else if (((LA16_10 >= '\u0000' && LA16_10 <= '!') || LA16_10 == '#'
                        || (LA16_10 >= '%' && LA16_10 <= '&') || (LA16_10 >= '(' && LA16_10 <= ';') || LA16_10 == '=' || (LA16_10 >= '?' && LA16_10 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.DOUBLE)))) {
                    s = 17;
                }

                else if ((LA16_10 == '\'')
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 19;
                }

                else if ((LA16_10 == '\"')
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 20;
                }

                else
                    s = 22;

                input.seek(index16_10);
                if (s >= 0)
                    return s;
                break;
            case 35:
                int LA16_9 = input.LA(1);

                int index16_9 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_9 >= '\u0000' && LA16_9 <= '!') || LA16_9 == '#' || (LA16_9 >= '%' && LA16_9 <= '&')
                        || (LA16_9 >= '(' && LA16_9 <= ';') || (LA16_9 >= '=' && LA16_9 <= '\uFFFE'))
                        && (((!inTag() && quote == Quote.NONE) || (!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.SINGLE)))) {
                    s = 17;
                }

                else if ((LA16_9 == '\'')
                        && (((!inTag() && quote == Quote.DOUBLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 19;
                }

                else if ((LA16_9 == '\"')
                        && (((!inTag() && quote == Quote.SINGLE) || (!inTag() && quote == Quote.NONE)))) {
                    s = 20;
                }

                else
                    s = 30;

                input.seek(index16_9);
                if (s >= 0)
                    return s;
                break;
            case 36:
                int LA16_12 = input.LA(1);

                int index16_12 = input.index();
                input.rewind();
                s = -1;
                if (((LA16_12 >= '\u0000' && LA16_12 <= ',') || (LA16_12 >= '.' && LA16_12 <= '<')
                        || (LA16_12 >= '>' && LA16_12 <= '?') || (LA16_12 >= 'A' && LA16_12 <= '\uFFFE'))) {
                    s = 32;
                }

                else if ((LA16_12 == '=')) {
                    s = 33;
                }

                else if ((LA16_12 == '-')) {
                    s = 34;
                }

                else if ((LA16_12 == '@') && (!inTag())) {
                    s = 35;
                }

                input.seek(index16_12);
                if (s >= 0)
                    return s;
                break;
            case 37:
                int LA16_13 = input.LA(1);

                int index16_13 = input.index();
                input.rewind();
                s = -1;
                if ((LA16_13 == '[')) {
                    s = 36;
                }

                else if ((LA16_13 == '-') && (!inTag())) {
                    s = 37;
                }

                else if ((LA16_13 == 'D') && (!inTag())) {
                    s = 38;
                }

                input.seek(index16_13);
                if (s >= 0)
                    return s;
                break;
            }
            NoViableAltException nvae = new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }

}
