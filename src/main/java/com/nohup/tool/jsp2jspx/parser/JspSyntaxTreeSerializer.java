// $ANTLR 3.0.1 JspSyntaxTreeSerializer.g 2010-10-13 12:47:51

package com.nohup.tool.jsp2jspx.parser;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeParser;

public class JspSyntaxTreeSerializer extends TreeParser {
    public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ELEMENT",
            "ATTRIBUTE", "ATTRIBUTES", "JSP_DIRECTIVE", "PROCESSING_INSTRUCTION", "DOCTYPE_DEFINITION", "CDATA",
            "PCDATA", "COMMENT", "JSP_DIRECTIVE_OPEN", "GENERIC_ID", "JSP_DIRECTIVE_CLOSE", "JSP_EXPRESSION",
            "JSP_SCRIPTLET", "JSP_COMMENT", "EL_EXPR", "TAG_CLOSE", "TAG_EMPTY_CLOSE", "TAG_START_OPEN", "ATTR_EQ",
            "ATTR_VALUE_OPEN", "ATTR_VALUE_CLOSE", "TAG_END_OPEN", "LETTER", "NAMECHAR", "DIGIT", "WHITESPACE" };
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

    public JspSyntaxTreeSerializer(TreeNodeStream input) {
        super(input);
    }

    public String[] getTokenNames() {
        return tokenNames;
    }

    public String getGrammarFileName() {
        return "JspSyntaxTreeSerializer.g";
    }

    private java.io.PrintStream out;

    public JspSyntaxTreeSerializer(TreeNodeStream input, java.io.PrintStream out) {
        super(input);
        this.out = out;
    }

    private void out(String text) {
        out.print(text);
    }

    // $ANTLR start document
    // JspSyntaxTreeSerializer.g:26:1: document : ( child | t= PROCESSING_INSTRUCTION | t= DOCTYPE_DEFINITION )* ;
    public final void document() throws RecognitionException {
        Tree t = null;

        try {
            // JspSyntaxTreeSerializer.g:27:5: ( ( child | t= PROCESSING_INSTRUCTION | t= DOCTYPE_DEFINITION )* )
            // JspSyntaxTreeSerializer.g:27:7: ( child | t= PROCESSING_INSTRUCTION | t= DOCTYPE_DEFINITION )*
            {
                // JspSyntaxTreeSerializer.g:27:7: ( child | t= PROCESSING_INSTRUCTION | t= DOCTYPE_DEFINITION )*
                loop1: do {
                    int alt1 = 4;
                    switch (input.LA(1)) {
                    case ELEMENT:
                    case CDATA:
                    case PCDATA:
                    case COMMENT: {
                        alt1 = 1;
                    }
                        break;
                    case PROCESSING_INSTRUCTION: {
                        alt1 = 2;
                    }
                        break;
                    case DOCTYPE_DEFINITION: {
                        alt1 = 3;
                    }
                        break;

                    }

                    switch (alt1) {
                    case 1:
                        // JspSyntaxTreeSerializer.g:28:9: child
                    {
                        pushFollow(FOLLOW_child_in_document76);
                        child();
                        _fsp--;

                    }
                        break;
                    case 2:
                        // JspSyntaxTreeSerializer.g:29:11: t= PROCESSING_INSTRUCTION
                    {
                        t = (Tree) input.LT(1);
                        match(input, PROCESSING_INSTRUCTION, FOLLOW_PROCESSING_INSTRUCTION_in_document90);
                        out("<?" + t.getText() + "?>");

                    }
                        break;
                    case 3:
                        // JspSyntaxTreeSerializer.g:30:11: t= DOCTYPE_DEFINITION
                    {
                        t = (Tree) input.LT(1);
                        match(input, DOCTYPE_DEFINITION, FOLLOW_DOCTYPE_DEFINITION_in_document106);
                        out(t.getText());

                    }
                        break;

                    default:
                        break loop1;
                    }
                } while (true);

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end document

    // $ANTLR start text
    // JspSyntaxTreeSerializer.g:34:1: text : (t= PCDATA | t= CDATA );
    public final void text() throws RecognitionException {
        Tree t = null;

        try {
            // JspSyntaxTreeSerializer.g:35:5: (t= PCDATA | t= CDATA )
            int alt2 = 2;
            int LA2_0 = input.LA(1);

            if ((LA2_0 == PCDATA)) {
                alt2 = 1;
            } else if ((LA2_0 == CDATA)) {
                alt2 = 2;
            } else {
                NoViableAltException nvae = new NoViableAltException("34:1: text : (t= PCDATA | t= CDATA );", 2, 0,
                        input);

                throw nvae;
            }
            switch (alt2) {
            case 1:
                // JspSyntaxTreeSerializer.g:35:7: t= PCDATA
            {
                t = (Tree) input.LT(1);
                match(input, PCDATA, FOLLOW_PCDATA_in_text134);
                out(t.getText());

            }
                break;
            case 2:
                // JspSyntaxTreeSerializer.g:36:7: t= CDATA
            {
                t = (Tree) input.LT(1);
                match(input, CDATA, FOLLOW_CDATA_in_text146);
                out("<![CDATA[" + t.getText() + "]]>");

            }
                break;

            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end text

    // $ANTLR start element
    // JspSyntaxTreeSerializer.g:39:1: element : ^( ELEMENT GENERIC_ID ^( ATTRIBUTES ( attribute )* ) ( ( child )+ | ) ) ;
    public final void element() throws RecognitionException {
        Tree GENERIC_ID1 = null;

        try {
            // JspSyntaxTreeSerializer.g:40:5: ( ^( ELEMENT GENERIC_ID ^( ATTRIBUTES ( attribute )* ) ( ( child )+ | ) ) )
            // JspSyntaxTreeSerializer.g:40:7: ^( ELEMENT GENERIC_ID ^( ATTRIBUTES ( attribute )* ) ( ( child )+ | ) )
            {
                match(input, ELEMENT, FOLLOW_ELEMENT_in_element167);

                match(input, Token.DOWN, null);
                GENERIC_ID1 = (Tree) input.LT(1);
                match(input, GENERIC_ID, FOLLOW_GENERIC_ID_in_element181);
                out("<" + GENERIC_ID1.getText());
                match(input, ATTRIBUTES, FOLLOW_ATTRIBUTES_in_element199);

                if (input.LA(1) == Token.DOWN) {
                    match(input, Token.DOWN, null);
                    // JspSyntaxTreeSerializer.g:42:27: ( attribute )*
                    loop3: do {
                        int alt3 = 2;
                        int LA3_0 = input.LA(1);

                        if ((LA3_0 == ATTRIBUTE)) {
                            alt3 = 1;
                        }

                        switch (alt3) {
                        case 1:
                            // JspSyntaxTreeSerializer.g:42:29: attribute
                        {
                            out(" ");
                            pushFollow(FOLLOW_attribute_in_element205);
                            attribute();
                            _fsp--;

                        }
                            break;

                        default:
                            break loop3;
                        }
                    } while (true);

                    match(input, Token.UP, null);
                }
                // JspSyntaxTreeSerializer.g:43:13: ( ( child )+ | )
                int alt5 = 2;
                int LA5_0 = input.LA(1);

                if ((LA5_0 == ELEMENT || (LA5_0 >= CDATA && LA5_0 <= COMMENT))) {
                    alt5 = 1;
                } else if ((LA5_0 == UP)) {
                    alt5 = 2;
                } else {
                    NoViableAltException nvae = new NoViableAltException("43:13: ( ( child )+ | )", 5, 0, input);

                    throw nvae;
                }
                switch (alt5) {
                case 1:
                    // JspSyntaxTreeSerializer.g:44:17: ( child )+
                {
                    out(">");
                    // JspSyntaxTreeSerializer.g:44:33: ( child )+
                    int cnt4 = 0;
                    loop4: do {
                        int alt4 = 2;
                        int LA4_0 = input.LA(1);

                        if ((LA4_0 == ELEMENT || (LA4_0 >= CDATA && LA4_0 <= COMMENT))) {
                            alt4 = 1;
                        }

                        switch (alt4) {
                        case 1:
                            // JspSyntaxTreeSerializer.g:44:33: child
                        {
                            pushFollow(FOLLOW_child_in_element244);
                            child();
                            _fsp--;

                        }
                            break;

                        default:
                            if (cnt4 >= 1)
                                break loop4;
                            EarlyExitException eee = new EarlyExitException(4, input);
                            throw eee;
                        }
                        cnt4++;
                    } while (true);

                    out("</" + GENERIC_ID1.getText() + ">");

                }
                    break;
                case 2:
                    // JspSyntaxTreeSerializer.g:45:19:
                {
                    out("/>");

                }
                    break;

                }

                match(input, Token.UP, null);

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end element

    // $ANTLR start child
    // JspSyntaxTreeSerializer.g:50:1: child : ( element | text | comment );
    public final void child() throws RecognitionException {
        try {
            // JspSyntaxTreeSerializer.g:51:5: ( element | text | comment )
            int alt6 = 3;
            switch (input.LA(1)) {
            case ELEMENT: {
                alt6 = 1;
            }
                break;
            case CDATA:
            case PCDATA: {
                alt6 = 2;
            }
                break;
            case COMMENT: {
                alt6 = 3;
            }
                break;
            default:
                NoViableAltException nvae = new NoViableAltException("50:1: child : ( element | text | comment );", 6,
                        0, input);

                throw nvae;
            }

            switch (alt6) {
            case 1:
                // JspSyntaxTreeSerializer.g:51:7: element
            {
                pushFollow(FOLLOW_element_in_child311);
                element();
                _fsp--;

            }
                break;
            case 2:
                // JspSyntaxTreeSerializer.g:52:7: text
            {
                pushFollow(FOLLOW_text_in_child319);
                text();
                _fsp--;

            }
                break;
            case 3:
                // JspSyntaxTreeSerializer.g:53:7: comment
            {
                pushFollow(FOLLOW_comment_in_child327);
                comment();
                _fsp--;

            }
                break;

            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end child

    // $ANTLR start comment
    // JspSyntaxTreeSerializer.g:56:1: comment : t= COMMENT ;
    public final void comment() throws RecognitionException {
        Tree t = null;

        try {
            // JspSyntaxTreeSerializer.g:57:5: (t= COMMENT )
            // JspSyntaxTreeSerializer.g:57:7: t= COMMENT
            {
                t = (Tree) input.LT(1);
                match(input, COMMENT, FOLLOW_COMMENT_in_comment346);
                out("<!--" + t.getText() + "-->");

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end comment

    // $ANTLR start attribute
    // JspSyntaxTreeSerializer.g:60:1: attribute : ^( ATTRIBUTE t= GENERIC_ID ( text )* ) ;
    public final void attribute() throws RecognitionException {
        Tree t = null;

        try {
            // JspSyntaxTreeSerializer.g:61:5: ( ^( ATTRIBUTE t= GENERIC_ID ( text )* ) )
            // JspSyntaxTreeSerializer.g:61:7: ^( ATTRIBUTE t= GENERIC_ID ( text )* )
            {
                match(input, ATTRIBUTE, FOLLOW_ATTRIBUTE_in_attribute375);

                match(input, Token.DOWN, null);
                t = (Tree) input.LT(1);
                match(input, GENERIC_ID, FOLLOW_GENERIC_ID_in_attribute387);
                out(t.getText() + "=\"");
                // JspSyntaxTreeSerializer.g:65:9: ( text )*
                loop7: do {
                    int alt7 = 2;
                    int LA7_0 = input.LA(1);

                    if (((LA7_0 >= CDATA && LA7_0 <= PCDATA))) {
                        alt7 = 1;
                    }

                    switch (alt7) {
                    case 1:
                        // JspSyntaxTreeSerializer.g:65:9: text
                    {
                        pushFollow(FOLLOW_text_in_attribute407);
                        text();
                        _fsp--;

                    }
                        break;

                    default:
                        break loop7;
                    }
                } while (true);

                out("\"");

                match(input, Token.UP, null);

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end attribute

    public static final BitSet FOLLOW_child_in_document76 = new BitSet(new long[] { 0x0000000000001F12L });
    public static final BitSet FOLLOW_PROCESSING_INSTRUCTION_in_document90 = new BitSet(
            new long[] { 0x0000000000001F12L });
    public static final BitSet FOLLOW_DOCTYPE_DEFINITION_in_document106 = new BitSet(new long[] { 0x0000000000001F12L });
    public static final BitSet FOLLOW_PCDATA_in_text134 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CDATA_in_text146 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ELEMENT_in_element167 = new BitSet(new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_GENERIC_ID_in_element181 = new BitSet(new long[] { 0x0000000000000040L });
    public static final BitSet FOLLOW_ATTRIBUTES_in_element199 = new BitSet(new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_attribute_in_element205 = new BitSet(new long[] { 0x0000000000000028L });
    public static final BitSet FOLLOW_child_in_element244 = new BitSet(new long[] { 0x0000000000001C18L });
    public static final BitSet FOLLOW_element_in_child311 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_text_in_child319 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_comment_in_child327 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_COMMENT_in_comment346 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ATTRIBUTE_in_attribute375 = new BitSet(new long[] { 0x0000000000000004L });
    public static final BitSet FOLLOW_GENERIC_ID_in_attribute387 = new BitSet(new long[] { 0x0000000000000C08L });
    public static final BitSet FOLLOW_text_in_attribute407 = new BitSet(new long[] { 0x0000000000000C08L });

}
