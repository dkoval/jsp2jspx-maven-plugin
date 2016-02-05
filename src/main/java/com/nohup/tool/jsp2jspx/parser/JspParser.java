// $ANTLR 3.0.1 Jsp.g 2010-10-13 12:47:50

package com.nohup.tool.jsp2jspx.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

public class JspParser extends Parser {
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
    public static final int TAG_END_OPEN = 26;
    public static final int JSP_COMMENT = 18;
    public static final int JSP_DIRECTIVE_CLOSE = 15;
    public static final int NAMECHAR = 28;
    public static final int ATTR_EQ = 23;
    public static final int TAG_START_OPEN = 22;
    public static final int ATTRIBUTES = 6;
    public static final int DIGIT = 29;
    public static final int ATTRIBUTE = 5;
    public static final int JSP_SCRIPTLET = 17;

    public JspParser(TokenStream input) {
        super(input);
    }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }

    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() {
        return tokenNames;
    }

    public String getGrammarFileName() {
        return "Jsp.g";
    }

    public static class document_return extends ParserRuleReturnScope {
        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start document
    // Jsp.g:59:1: document : ( child | PROCESSING_INSTRUCTION | DOCTYPE_DEFINITION | jspDirective )* EOF ;
    public final document_return document() throws RecognitionException {
        document_return retval = new document_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PROCESSING_INSTRUCTION2 = null;
        Token DOCTYPE_DEFINITION3 = null;
        Token EOF5 = null;
        child_return child1 = null;

        jspDirective_return jspDirective4 = null;

        Object PROCESSING_INSTRUCTION2_tree = null;
        Object DOCTYPE_DEFINITION3_tree = null;
        Object EOF5_tree = null;

        try {
            // Jsp.g:60:5: ( ( child | PROCESSING_INSTRUCTION | DOCTYPE_DEFINITION | jspDirective )* EOF )
            // Jsp.g:60:7: ( child | PROCESSING_INSTRUCTION | DOCTYPE_DEFINITION | jspDirective )* EOF
            {
                root_0 = (Object) adaptor.nil();

                // Jsp.g:60:7: ( child | PROCESSING_INSTRUCTION | DOCTYPE_DEFINITION | jspDirective )*
                loop1: do {
                    int alt1 = 5;
                    switch (input.LA(1)) {
                    case CDATA:
                    case PCDATA:
                    case COMMENT:
                    case JSP_EXPRESSION:
                    case JSP_SCRIPTLET:
                    case JSP_COMMENT:
                    case EL_EXPR:
                    case TAG_START_OPEN: {
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
                    case JSP_DIRECTIVE_OPEN: {
                        alt1 = 4;
                    }
                        break;

                    }

                    switch (alt1) {
                    case 1:
                        // Jsp.g:61:9: child
                    {
                        pushFollow(FOLLOW_child_in_document108);
                        child1 = child();
                        _fsp--;

                        adaptor.addChild(root_0, child1.getTree());

                    }
                        break;
                    case 2:
                        // Jsp.g:62:11: PROCESSING_INSTRUCTION
                    {
                        PROCESSING_INSTRUCTION2 = (Token) input.LT(1);
                        match(input, PROCESSING_INSTRUCTION, FOLLOW_PROCESSING_INSTRUCTION_in_document120);
                        PROCESSING_INSTRUCTION2_tree = (Object) adaptor.create(PROCESSING_INSTRUCTION2);
                        adaptor.addChild(root_0, PROCESSING_INSTRUCTION2_tree);

                    }
                        break;
                    case 3:
                        // Jsp.g:63:11: DOCTYPE_DEFINITION
                    {
                        DOCTYPE_DEFINITION3 = (Token) input.LT(1);
                        match(input, DOCTYPE_DEFINITION, FOLLOW_DOCTYPE_DEFINITION_in_document132);
                        DOCTYPE_DEFINITION3_tree = (Object) adaptor.create(DOCTYPE_DEFINITION3);
                        adaptor.addChild(root_0, DOCTYPE_DEFINITION3_tree);

                    }
                        break;
                    case 4:
                        // Jsp.g:64:11: jspDirective
                    {
                        pushFollow(FOLLOW_jspDirective_in_document144);
                        jspDirective4 = jspDirective();
                        _fsp--;

                        adaptor.addChild(root_0, jspDirective4.getTree());

                    }
                        break;

                    default:
                        break loop1;
                    }
                } while (true);

                EOF5 = (Token) input.LT(1);
                match(input, EOF, FOLLOW_EOF_in_document158);

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }

    // $ANTLR end document

    public static class child_return extends ParserRuleReturnScope {
        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start child
    // Jsp.g:69:1: child : ( element[false] | CDATA | PCDATA | COMMENT | jspLexicon );
    public final child_return child() throws RecognitionException {
        child_return retval = new child_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CDATA7 = null;
        Token PCDATA8 = null;
        Token COMMENT9 = null;
        element_return element6 = null;

        jspLexicon_return jspLexicon10 = null;

        Object CDATA7_tree = null;
        Object PCDATA8_tree = null;
        Object COMMENT9_tree = null;

        try {
            // Jsp.g:70:5: ( element[false] | CDATA | PCDATA | COMMENT | jspLexicon )
            int alt2 = 5;
            switch (input.LA(1)) {
            case TAG_START_OPEN: {
                alt2 = 1;
            }
                break;
            case CDATA: {
                alt2 = 2;
            }
                break;
            case PCDATA: {
                alt2 = 3;
            }
                break;
            case COMMENT: {
                alt2 = 4;
            }
                break;
            case JSP_EXPRESSION:
            case JSP_SCRIPTLET:
            case JSP_COMMENT:
            case EL_EXPR: {
                alt2 = 5;
            }
                break;
            default:
                NoViableAltException nvae = new NoViableAltException(
                        "69:1: child : ( element[false] | CDATA | PCDATA | COMMENT | jspLexicon );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
            case 1:
                // Jsp.g:70:7: element[false]
            {
                root_0 = (Object) adaptor.nil();

                pushFollow(FOLLOW_element_in_child176);
                element6 = element(false);
                _fsp--;

                adaptor.addChild(root_0, element6.getTree());

            }
                break;
            case 2:
                // Jsp.g:71:7: CDATA
            {
                root_0 = (Object) adaptor.nil();

                CDATA7 = (Token) input.LT(1);
                match(input, CDATA, FOLLOW_CDATA_in_child185);
                CDATA7_tree = (Object) adaptor.create(CDATA7);
                adaptor.addChild(root_0, CDATA7_tree);

            }
                break;
            case 3:
                // Jsp.g:72:7: PCDATA
            {
                root_0 = (Object) adaptor.nil();

                PCDATA8 = (Token) input.LT(1);
                match(input, PCDATA, FOLLOW_PCDATA_in_child193);
                PCDATA8_tree = (Object) adaptor.create(PCDATA8);
                adaptor.addChild(root_0, PCDATA8_tree);

            }
                break;
            case 4:
                // Jsp.g:73:7: COMMENT
            {
                root_0 = (Object) adaptor.nil();

                COMMENT9 = (Token) input.LT(1);
                match(input, COMMENT, FOLLOW_COMMENT_in_child201);
                COMMENT9_tree = (Object) adaptor.create(COMMENT9);
                adaptor.addChild(root_0, COMMENT9_tree);

            }
                break;
            case 5:
                // Jsp.g:74:7: jspLexicon
            {
                root_0 = (Object) adaptor.nil();

                pushFollow(FOLLOW_jspLexicon_in_child209);
                jspLexicon10 = jspLexicon();
                _fsp--;

                adaptor.addChild(root_0, jspLexicon10.getTree());

            }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }

    // $ANTLR end child

    public static class jspDirective_return extends ParserRuleReturnScope {
        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start jspDirective
    // Jsp.g:78:1: jspDirective : JSP_DIRECTIVE_OPEN name= GENERIC_ID (attributes+= attribute )* JSP_DIRECTIVE_CLOSE -> ^( JSP_DIRECTIVE $name ^( ATTRIBUTES ( $attributes)* ) ) ;
    public final jspDirective_return jspDirective() throws RecognitionException {
        jspDirective_return retval = new jspDirective_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name = null;
        Token JSP_DIRECTIVE_OPEN11 = null;
        Token JSP_DIRECTIVE_CLOSE12 = null;
        List list_attributes = null;
        RuleReturnScope attributes = null;
        Object name_tree = null;
        Object JSP_DIRECTIVE_OPEN11_tree = null;
        Object JSP_DIRECTIVE_CLOSE12_tree = null;
        RewriteRuleTokenStream stream_JSP_DIRECTIVE_CLOSE = new RewriteRuleTokenStream(adaptor,
                "token JSP_DIRECTIVE_CLOSE");
        RewriteRuleTokenStream stream_JSP_DIRECTIVE_OPEN = new RewriteRuleTokenStream(adaptor,
                "token JSP_DIRECTIVE_OPEN");
        RewriteRuleTokenStream stream_GENERIC_ID = new RewriteRuleTokenStream(adaptor, "token GENERIC_ID");
        RewriteRuleSubtreeStream stream_attribute = new RewriteRuleSubtreeStream(adaptor, "rule attribute");
        try {
            // Jsp.g:79:5: ( JSP_DIRECTIVE_OPEN name= GENERIC_ID (attributes+= attribute )* JSP_DIRECTIVE_CLOSE -> ^( JSP_DIRECTIVE $name ^( ATTRIBUTES ( $attributes)* ) ) )
            // Jsp.g:79:7: JSP_DIRECTIVE_OPEN name= GENERIC_ID (attributes+= attribute )* JSP_DIRECTIVE_CLOSE
            {
                JSP_DIRECTIVE_OPEN11 = (Token) input.LT(1);
                match(input, JSP_DIRECTIVE_OPEN, FOLLOW_JSP_DIRECTIVE_OPEN_in_jspDirective227);
                stream_JSP_DIRECTIVE_OPEN.add(JSP_DIRECTIVE_OPEN11);

                name = (Token) input.LT(1);
                match(input, GENERIC_ID, FOLLOW_GENERIC_ID_in_jspDirective231);
                stream_GENERIC_ID.add(name);

                // Jsp.g:79:42: (attributes+= attribute )*
                loop3: do {
                    int alt3 = 2;
                    int LA3_0 = input.LA(1);

                    if ((LA3_0 == GENERIC_ID)) {
                        alt3 = 1;
                    }

                    switch (alt3) {
                    case 1:
                        // Jsp.g:80:9: attributes+= attribute
                    {
                        pushFollow(FOLLOW_attribute_in_jspDirective245);
                        attributes = attribute();
                        _fsp--;

                        stream_attribute.add(attributes.getTree());
                        if (list_attributes == null)
                            list_attributes = new ArrayList();
                        list_attributes.add(attributes);

                    }
                        break;

                    default:
                        break loop3;
                    }
                } while (true);

                JSP_DIRECTIVE_CLOSE12 = (Token) input.LT(1);
                match(input, JSP_DIRECTIVE_CLOSE, FOLLOW_JSP_DIRECTIVE_CLOSE_in_jspDirective259);
                stream_JSP_DIRECTIVE_CLOSE.add(JSP_DIRECTIVE_CLOSE12);

                // AST REWRITE
                // elements: attributes, name
                // token labels: name
                // rule labels: retval
                // token list labels:
                // rule list labels: attributes
                retval.tree = root_0;
                RewriteRuleTokenStream stream_name = new RewriteRuleTokenStream(adaptor, "token name", name);
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "token retval",
                        retval != null ? retval.tree : null);
                RewriteRuleSubtreeStream stream_attributes = new RewriteRuleSubtreeStream(adaptor, "token attributes",
                        list_attributes);
                root_0 = (Object) adaptor.nil();
                // 83:5: -> ^( JSP_DIRECTIVE $name ^( ATTRIBUTES ( $attributes)* ) )
                {
                    // Jsp.g:83:8: ^( JSP_DIRECTIVE $name ^( ATTRIBUTES ( $attributes)* ) )
                    {
                        Object root_1 = (Object) adaptor.nil();
                        root_1 = (Object) adaptor.becomeRoot(adaptor.create(JSP_DIRECTIVE, "JSP_DIRECTIVE"), root_1);

                        adaptor.addChild(root_1, stream_name.next());
                        // Jsp.g:83:31: ^( ATTRIBUTES ( $attributes)* )
                        {
                            Object root_2 = (Object) adaptor.nil();
                            root_2 = (Object) adaptor.becomeRoot(adaptor.create(ATTRIBUTES, "ATTRIBUTES"), root_2);

                            // Jsp.g:83:45: ( $attributes)*
                            while (stream_attributes.hasNext()) {
                                adaptor.addChild(root_2, ((ParserRuleReturnScope) stream_attributes.next()).getTree());

                            }
                            stream_attributes.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }

    // $ANTLR end jspDirective

    public static class jspLexicon_return extends ParserRuleReturnScope {
        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start jspLexicon
    // Jsp.g:86:1: jspLexicon : ( JSP_EXPRESSION | JSP_SCRIPTLET | JSP_COMMENT | EL_EXPR );
    public final jspLexicon_return jspLexicon() throws RecognitionException {
        jspLexicon_return retval = new jspLexicon_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set13 = null;

        Object set13_tree = null;

        try {
            // Jsp.g:87:5: ( JSP_EXPRESSION | JSP_SCRIPTLET | JSP_COMMENT | EL_EXPR )
            // Jsp.g:
            {
                root_0 = (Object) adaptor.nil();

                set13 = (Token) input.LT(1);
                if ((input.LA(1) >= JSP_EXPRESSION && input.LA(1) <= EL_EXPR)) {
                    input.consume();
                    adaptor.addChild(root_0, adaptor.create(set13));
                    errorRecovery = false;
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recoverFromMismatchedSet(input, mse, FOLLOW_set_in_jspLexicon0);
                    throw mse;
                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }

    // $ANTLR end jspLexicon

    public static class element_return extends ParserRuleReturnScope {
        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start element
    // Jsp.g:93:1: element[boolean attributeAllowed] : r= startTag ( TAG_CLOSE ( ( ({...}? => attribute ) | child )+ endTag[$r.tagName] | endTag[$r.tagName] ) | TAG_EMPTY_CLOSE ) ;
    public final element_return element(boolean attributeAllowed) throws RecognitionException {
        element_return retval = new element_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TAG_CLOSE14 = null;
        Token TAG_EMPTY_CLOSE19 = null;
        startTag_return r = null;

        attribute_return attribute15 = null;

        child_return child16 = null;

        endTag_return endTag17 = null;

        endTag_return endTag18 = null;

        Object TAG_CLOSE14_tree = null;
        Object TAG_EMPTY_CLOSE19_tree = null;

        try {
            // Jsp.g:94:5: (r= startTag ( TAG_CLOSE ( ( ({...}? => attribute ) | child )+ endTag[$r.tagName] | endTag[$r.tagName] ) | TAG_EMPTY_CLOSE ) )
            // Jsp.g:94:7: r= startTag ( TAG_CLOSE ( ( ({...}? => attribute ) | child )+ endTag[$r.tagName] | endTag[$r.tagName] ) | TAG_EMPTY_CLOSE )
            {
                root_0 = (Object) adaptor.nil();

                pushFollow(FOLLOW_startTag_in_element345);
                r = startTag();
                _fsp--;

                root_0 = (Object) adaptor.becomeRoot(r.getTree(), root_0);
                // Jsp.g:94:19: ( TAG_CLOSE ( ( ({...}? => attribute ) | child )+ endTag[$r.tagName] | endTag[$r.tagName] ) | TAG_EMPTY_CLOSE )
                int alt6 = 2;
                int LA6_0 = input.LA(1);

                if ((LA6_0 == TAG_CLOSE)) {
                    alt6 = 1;
                } else if ((LA6_0 == TAG_EMPTY_CLOSE)) {
                    alt6 = 2;
                } else {
                    NoViableAltException nvae = new NoViableAltException(
                            "94:19: ( TAG_CLOSE ( ( ({...}? => attribute ) | child )+ endTag[$r.tagName] | endTag[$r.tagName] ) | TAG_EMPTY_CLOSE )",
                            6, 0, input);

                    throw nvae;
                }
                switch (alt6) {
                case 1:
                    // Jsp.g:95:9: TAG_CLOSE ( ( ({...}? => attribute ) | child )+ endTag[$r.tagName] | endTag[$r.tagName] )
                {
                    TAG_CLOSE14 = (Token) input.LT(1);
                    match(input, TAG_CLOSE, FOLLOW_TAG_CLOSE_in_element358);
                    // Jsp.g:95:20: ( ( ({...}? => attribute ) | child )+ endTag[$r.tagName] | endTag[$r.tagName] )
                    int alt5 = 2;
                    int LA5_0 = input.LA(1);

                    if ((LA5_0 == GENERIC_ID) && (attributeAllowed)) {
                        alt5 = 1;
                    } else if (((LA5_0 >= CDATA && LA5_0 <= COMMENT) || (LA5_0 >= JSP_EXPRESSION && LA5_0 <= EL_EXPR) || LA5_0 == TAG_START_OPEN)) {
                        alt5 = 1;
                    } else if ((LA5_0 == TAG_END_OPEN)) {
                        alt5 = 2;
                    } else {
                        NoViableAltException nvae = new NoViableAltException(
                                "95:20: ( ( ({...}? => attribute ) | child )+ endTag[$r.tagName] | endTag[$r.tagName] )",
                                5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                    case 1:
                        // Jsp.g:95:22: ( ({...}? => attribute ) | child )+ endTag[$r.tagName]
                    {
                        // Jsp.g:95:22: ( ({...}? => attribute ) | child )+
                        int cnt4 = 0;
                        loop4: do {
                            int alt4 = 3;
                            int LA4_0 = input.LA(1);

                            if ((LA4_0 == GENERIC_ID) && (attributeAllowed)) {
                                alt4 = 1;
                            } else if (((LA4_0 >= CDATA && LA4_0 <= COMMENT)
                                    || (LA4_0 >= JSP_EXPRESSION && LA4_0 <= EL_EXPR) || LA4_0 == TAG_START_OPEN)) {
                                alt4 = 2;
                            }

                            switch (alt4) {
                            case 1:
                                // Jsp.g:96:13: ({...}? => attribute )
                            {
                                // Jsp.g:96:13: ({...}? => attribute )
                                // Jsp.g:96:15: {...}? => attribute
                                {
                                    if (!(attributeAllowed)) {
                                        throw new FailedPredicateException(input, "element", " attributeAllowed ");
                                    }
                                    pushFollow(FOLLOW_attribute_in_element382);
                                    attribute15 = attribute();
                                    _fsp--;

                                    adaptor.addChild(root_0, attribute15.getTree());

                                }

                            }
                                break;
                            case 2:
                                // Jsp.g:97:15: child
                            {
                                pushFollow(FOLLOW_child_in_element400);
                                child16 = child();
                                _fsp--;

                                adaptor.addChild(root_0, child16.getTree());

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

                        pushFollow(FOLLOW_endTag_in_element414);
                        endTag17 = endTag(r.tagName);
                        _fsp--;

                    }
                        break;
                    case 2:
                        // Jsp.g:99:11: endTag[$r.tagName]
                    {
                        pushFollow(FOLLOW_endTag_in_element428);
                        endTag18 = endTag(r.tagName);
                        _fsp--;

                        adaptor.addChild(root_0, endTag18.getTree());

                    }
                        break;

                    }

                }
                    break;
                case 2:
                    // Jsp.g:100:11: TAG_EMPTY_CLOSE
                {
                    TAG_EMPTY_CLOSE19 = (Token) input.LT(1);
                    match(input, TAG_EMPTY_CLOSE, FOLLOW_TAG_EMPTY_CLOSE_in_element443);

                }
                    break;

                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }

    // $ANTLR end element

    public static class startTag_return extends ParserRuleReturnScope {
        public String tagName;
        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start startTag
    // Jsp.g:104:1: startTag returns [ String tagName ] : TAG_START_OPEN name= GENERIC_ID (attributes+= attribute | attributes+= jspLexicon | attributes+= element[true] )* -> ^( ELEMENT $name ^( ATTRIBUTES ( $attributes)* ) ) ;
    public final startTag_return startTag() throws RecognitionException {
        startTag_return retval = new startTag_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name = null;
        Token TAG_START_OPEN20 = null;
        List list_attributes = null;
        RuleReturnScope attributes = null;
        Object name_tree = null;
        Object TAG_START_OPEN20_tree = null;
        RewriteRuleTokenStream stream_TAG_START_OPEN = new RewriteRuleTokenStream(adaptor, "token TAG_START_OPEN");
        RewriteRuleTokenStream stream_GENERIC_ID = new RewriteRuleTokenStream(adaptor, "token GENERIC_ID");
        RewriteRuleSubtreeStream stream_element = new RewriteRuleSubtreeStream(adaptor, "rule element");
        RewriteRuleSubtreeStream stream_jspLexicon = new RewriteRuleSubtreeStream(adaptor, "rule jspLexicon");
        RewriteRuleSubtreeStream stream_attribute = new RewriteRuleSubtreeStream(adaptor, "rule attribute");
        try {
            // Jsp.g:106:5: ( TAG_START_OPEN name= GENERIC_ID (attributes+= attribute | attributes+= jspLexicon | attributes+= element[true] )* -> ^( ELEMENT $name ^( ATTRIBUTES ( $attributes)* ) ) )
            // Jsp.g:106:7: TAG_START_OPEN name= GENERIC_ID (attributes+= attribute | attributes+= jspLexicon | attributes+= element[true] )*
            {
                TAG_START_OPEN20 = (Token) input.LT(1);
                match(input, TAG_START_OPEN, FOLLOW_TAG_START_OPEN_in_startTag476);
                stream_TAG_START_OPEN.add(TAG_START_OPEN20);

                name = (Token) input.LT(1);
                match(input, GENERIC_ID, FOLLOW_GENERIC_ID_in_startTag480);
                stream_GENERIC_ID.add(name);

                // Jsp.g:106:38: (attributes+= attribute | attributes+= jspLexicon | attributes+= element[true] )*
                loop7: do {
                    int alt7 = 4;
                    switch (input.LA(1)) {
                    case GENERIC_ID: {
                        alt7 = 1;
                    }
                        break;
                    case JSP_EXPRESSION:
                    case JSP_SCRIPTLET:
                    case JSP_COMMENT:
                    case EL_EXPR: {
                        alt7 = 2;
                    }
                        break;
                    case TAG_START_OPEN: {
                        alt7 = 3;
                    }
                        break;

                    }

                    switch (alt7) {
                    case 1:
                        // Jsp.g:107:9: attributes+= attribute
                    {
                        pushFollow(FOLLOW_attribute_in_startTag494);
                        attributes = attribute();
                        _fsp--;

                        stream_attribute.add(attributes.getTree());
                        if (list_attributes == null)
                            list_attributes = new ArrayList();
                        list_attributes.add(attributes);

                    }
                        break;
                    case 2:
                        // Jsp.g:108:11: attributes+= jspLexicon
                    {
                        pushFollow(FOLLOW_jspLexicon_in_startTag508);
                        attributes = jspLexicon();
                        _fsp--;

                        stream_jspLexicon.add(attributes.getTree());
                        if (list_attributes == null)
                            list_attributes = new ArrayList();
                        list_attributes.add(attributes);

                    }
                        break;
                    case 3:
                        // Jsp.g:109:11: attributes+= element[true]
                    {
                        pushFollow(FOLLOW_element_in_startTag522);
                        attributes = element(true);
                        _fsp--;

                        stream_element.add(attributes.getTree());
                        if (list_attributes == null)
                            list_attributes = new ArrayList();
                        list_attributes.add(attributes);

                    }
                        break;

                    default:
                        break loop7;
                    }
                } while (true);

                retval.tagName = name.getText();

                // AST REWRITE
                // elements: name, attributes
                // token labels: name
                // rule labels: retval
                // token list labels:
                // rule list labels: attributes
                retval.tree = root_0;
                RewriteRuleTokenStream stream_name = new RewriteRuleTokenStream(adaptor, "token name", name);
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "token retval",
                        retval != null ? retval.tree : null);
                RewriteRuleSubtreeStream stream_attributes = new RewriteRuleSubtreeStream(adaptor, "token attributes",
                        list_attributes);
                root_0 = (Object) adaptor.nil();
                // 112:5: -> ^( ELEMENT $name ^( ATTRIBUTES ( $attributes)* ) )
                {
                    // Jsp.g:112:8: ^( ELEMENT $name ^( ATTRIBUTES ( $attributes)* ) )
                    {
                        Object root_1 = (Object) adaptor.nil();
                        root_1 = (Object) adaptor.becomeRoot(adaptor.create(ELEMENT, "ELEMENT"), root_1);

                        adaptor.addChild(root_1, stream_name.next());
                        // Jsp.g:112:25: ^( ATTRIBUTES ( $attributes)* )
                        {
                            Object root_2 = (Object) adaptor.nil();
                            root_2 = (Object) adaptor.becomeRoot(adaptor.create(ATTRIBUTES, "ATTRIBUTES"), root_2);

                            // Jsp.g:112:39: ( $attributes)*
                            while (stream_attributes.hasNext()) {
                                adaptor.addChild(root_2, ((ParserRuleReturnScope) stream_attributes.next()).getTree());

                            }
                            stream_attributes.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }

    // $ANTLR end startTag

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start attribute
    // Jsp.g:115:1: attribute : name= GENERIC_ID ATTR_EQ ATTR_VALUE_OPEN (value+= attributeValue )* ATTR_VALUE_CLOSE -> ^( ATTRIBUTE $name ( $value)* ) ;
    public final attribute_return attribute() throws RecognitionException {
        attribute_return retval = new attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name = null;
        Token ATTR_EQ21 = null;
        Token ATTR_VALUE_OPEN22 = null;
        Token ATTR_VALUE_CLOSE23 = null;
        List list_value = null;
        RuleReturnScope value = null;
        Object name_tree = null;
        Object ATTR_EQ21_tree = null;
        Object ATTR_VALUE_OPEN22_tree = null;
        Object ATTR_VALUE_CLOSE23_tree = null;
        RewriteRuleTokenStream stream_ATTR_VALUE_CLOSE = new RewriteRuleTokenStream(adaptor, "token ATTR_VALUE_CLOSE");
        RewriteRuleTokenStream stream_ATTR_EQ = new RewriteRuleTokenStream(adaptor, "token ATTR_EQ");
        RewriteRuleTokenStream stream_GENERIC_ID = new RewriteRuleTokenStream(adaptor, "token GENERIC_ID");
        RewriteRuleTokenStream stream_ATTR_VALUE_OPEN = new RewriteRuleTokenStream(adaptor, "token ATTR_VALUE_OPEN");
        RewriteRuleSubtreeStream stream_attributeValue = new RewriteRuleSubtreeStream(adaptor, "rule attributeValue");
        try {
            // Jsp.g:116:5: (name= GENERIC_ID ATTR_EQ ATTR_VALUE_OPEN (value+= attributeValue )* ATTR_VALUE_CLOSE -> ^( ATTRIBUTE $name ( $value)* ) )
            // Jsp.g:116:7: name= GENERIC_ID ATTR_EQ ATTR_VALUE_OPEN (value+= attributeValue )* ATTR_VALUE_CLOSE
            {
                name = (Token) input.LT(1);
                match(input, GENERIC_ID, FOLLOW_GENERIC_ID_in_attribute581);
                stream_GENERIC_ID.add(name);

                ATTR_EQ21 = (Token) input.LT(1);
                match(input, ATTR_EQ, FOLLOW_ATTR_EQ_in_attribute583);
                stream_ATTR_EQ.add(ATTR_EQ21);

                ATTR_VALUE_OPEN22 = (Token) input.LT(1);
                match(input, ATTR_VALUE_OPEN, FOLLOW_ATTR_VALUE_OPEN_in_attribute585);
                stream_ATTR_VALUE_OPEN.add(ATTR_VALUE_OPEN22);

                // Jsp.g:116:47: (value+= attributeValue )*
                loop8: do {
                    int alt8 = 2;
                    int LA8_0 = input.LA(1);

                    if ((LA8_0 == PCDATA || (LA8_0 >= JSP_EXPRESSION && LA8_0 <= EL_EXPR) || LA8_0 == TAG_START_OPEN)) {
                        alt8 = 1;
                    }

                    switch (alt8) {
                    case 1:
                        // Jsp.g:117:9: value+= attributeValue
                    {
                        pushFollow(FOLLOW_attributeValue_in_attribute599);
                        value = attributeValue();
                        _fsp--;

                        stream_attributeValue.add(value.getTree());
                        if (list_value == null)
                            list_value = new ArrayList();
                        list_value.add(value);

                    }
                        break;

                    default:
                        break loop8;
                    }
                } while (true);

                ATTR_VALUE_CLOSE23 = (Token) input.LT(1);
                match(input, ATTR_VALUE_CLOSE, FOLLOW_ATTR_VALUE_CLOSE_in_attribute609);
                stream_ATTR_VALUE_CLOSE.add(ATTR_VALUE_CLOSE23);

                // AST REWRITE
                // elements: name, value
                // token labels: name
                // rule labels: retval
                // token list labels:
                // rule list labels: value
                retval.tree = root_0;
                RewriteRuleTokenStream stream_name = new RewriteRuleTokenStream(adaptor, "token name", name);
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "token retval",
                        retval != null ? retval.tree : null);
                RewriteRuleSubtreeStream stream_value = new RewriteRuleSubtreeStream(adaptor, "token value", list_value);
                root_0 = (Object) adaptor.nil();
                // 119:5: -> ^( ATTRIBUTE $name ( $value)* )
                {
                    // Jsp.g:119:8: ^( ATTRIBUTE $name ( $value)* )
                    {
                        Object root_1 = (Object) adaptor.nil();
                        root_1 = (Object) adaptor.becomeRoot(adaptor.create(ATTRIBUTE, "ATTRIBUTE"), root_1);

                        adaptor.addChild(root_1, stream_name.next());
                        // Jsp.g:119:27: ( $value)*
                        while (stream_value.hasNext()) {
                            adaptor.addChild(root_1, ((ParserRuleReturnScope) stream_value.next()).getTree());

                        }
                        stream_value.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }

    // $ANTLR end attribute

    public static class attributeValue_return extends ParserRuleReturnScope {
        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start attributeValue
    // Jsp.g:122:1: attributeValue : ( PCDATA | element[false] | jspLexicon );
    public final attributeValue_return attributeValue() throws RecognitionException {
        attributeValue_return retval = new attributeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PCDATA24 = null;
        element_return element25 = null;

        jspLexicon_return jspLexicon26 = null;

        Object PCDATA24_tree = null;

        try {
            // Jsp.g:123:5: ( PCDATA | element[false] | jspLexicon )
            int alt9 = 3;
            switch (input.LA(1)) {
            case PCDATA: {
                alt9 = 1;
            }
                break;
            case TAG_START_OPEN: {
                alt9 = 2;
            }
                break;
            case JSP_EXPRESSION:
            case JSP_SCRIPTLET:
            case JSP_COMMENT:
            case EL_EXPR: {
                alt9 = 3;
            }
                break;
            default:
                NoViableAltException nvae = new NoViableAltException(
                        "122:1: attributeValue : ( PCDATA | element[false] | jspLexicon );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
            case 1:
                // Jsp.g:123:7: PCDATA
            {
                root_0 = (Object) adaptor.nil();

                PCDATA24 = (Token) input.LT(1);
                match(input, PCDATA, FOLLOW_PCDATA_in_attributeValue645);
                PCDATA24_tree = (Object) adaptor.create(PCDATA24);
                adaptor.addChild(root_0, PCDATA24_tree);

            }
                break;
            case 2:
                // Jsp.g:124:7: element[false]
            {
                root_0 = (Object) adaptor.nil();

                pushFollow(FOLLOW_element_in_attributeValue653);
                element25 = element(false);
                _fsp--;

                adaptor.addChild(root_0, element25.getTree());

            }
                break;
            case 3:
                // Jsp.g:125:7: jspLexicon
            {
                root_0 = (Object) adaptor.nil();

                pushFollow(FOLLOW_jspLexicon_in_attributeValue662);
                jspLexicon26 = jspLexicon();
                _fsp--;

                adaptor.addChild(root_0, jspLexicon26.getTree());

            }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }

    // $ANTLR end attributeValue

    public static class endTag_return extends ParserRuleReturnScope {
        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start endTag
    // Jsp.g:138:1: endTag[ String tagName ] : t= TAG_END_OPEN name= GENERIC_ID {...}? TAG_CLOSE -> CDATA[$t,\"\"] ;
    public final endTag_return endTag(String tagName) throws RecognitionException {
        endTag_return retval = new endTag_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t = null;
        Token name = null;
        Token TAG_CLOSE27 = null;

        Object t_tree = null;
        Object name_tree = null;
        Object TAG_CLOSE27_tree = null;
        RewriteRuleTokenStream stream_TAG_END_OPEN = new RewriteRuleTokenStream(adaptor, "token TAG_END_OPEN");
        RewriteRuleTokenStream stream_TAG_CLOSE = new RewriteRuleTokenStream(adaptor, "token TAG_CLOSE");
        RewriteRuleTokenStream stream_GENERIC_ID = new RewriteRuleTokenStream(adaptor, "token GENERIC_ID");

        try {
            // Jsp.g:139:5: (t= TAG_END_OPEN name= GENERIC_ID {...}? TAG_CLOSE -> CDATA[$t,\"\"] )
            // Jsp.g:139:7: t= TAG_END_OPEN name= GENERIC_ID {...}? TAG_CLOSE
            {
                t = (Token) input.LT(1);
                match(input, TAG_END_OPEN, FOLLOW_TAG_END_OPEN_in_endTag686);
                stream_TAG_END_OPEN.add(t);

                name = (Token) input.LT(1);
                match(input, GENERIC_ID, FOLLOW_GENERIC_ID_in_endTag690);
                stream_GENERIC_ID.add(name);

                if (!(name.getText().equals(tagName))) {
                    throw new FailedPredicateException(input, "endTag", " $name.text.equals( $tagName ) ");
                }
                TAG_CLOSE27 = (Token) input.LT(1);
                match(input, TAG_CLOSE, FOLLOW_TAG_CLOSE_in_endTag694);
                stream_TAG_CLOSE.add(TAG_CLOSE27);

                // AST REWRITE
                // elements:
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "token retval",
                        retval != null ? retval.tree : null);

                root_0 = (Object) adaptor.nil();
                // 140:5: -> CDATA[$t,\"\"]
                {
                    adaptor.addChild(root_0, adaptor.create(CDATA, t, ""));

                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }

    // $ANTLR end endTag

    public static final BitSet FOLLOW_child_in_document108 = new BitSet(new long[] { 0x00000000004F3F00L });
    public static final BitSet FOLLOW_PROCESSING_INSTRUCTION_in_document120 = new BitSet(
            new long[] { 0x00000000004F3F00L });
    public static final BitSet FOLLOW_DOCTYPE_DEFINITION_in_document132 = new BitSet(new long[] { 0x00000000004F3F00L });
    public static final BitSet FOLLOW_jspDirective_in_document144 = new BitSet(new long[] { 0x00000000004F3F00L });
    public static final BitSet FOLLOW_EOF_in_document158 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_element_in_child176 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_CDATA_in_child185 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_PCDATA_in_child193 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_COMMENT_in_child201 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_jspLexicon_in_child209 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_JSP_DIRECTIVE_OPEN_in_jspDirective227 = new BitSet(
            new long[] { 0x0000000000004000L });
    public static final BitSet FOLLOW_GENERIC_ID_in_jspDirective231 = new BitSet(new long[] { 0x000000000000C000L });
    public static final BitSet FOLLOW_attribute_in_jspDirective245 = new BitSet(new long[] { 0x000000000000C000L });
    public static final BitSet FOLLOW_JSP_DIRECTIVE_CLOSE_in_jspDirective259 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_set_in_jspLexicon0 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_startTag_in_element345 = new BitSet(new long[] { 0x0000000000300000L });
    public static final BitSet FOLLOW_TAG_CLOSE_in_element358 = new BitSet(new long[] { 0x00000000044F5C00L });
    public static final BitSet FOLLOW_attribute_in_element382 = new BitSet(new long[] { 0x00000000044F5C00L });
    public static final BitSet FOLLOW_child_in_element400 = new BitSet(new long[] { 0x00000000044F5C00L });
    public static final BitSet FOLLOW_endTag_in_element414 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_endTag_in_element428 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_TAG_EMPTY_CLOSE_in_element443 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_TAG_START_OPEN_in_startTag476 = new BitSet(new long[] { 0x0000000000004000L });
    public static final BitSet FOLLOW_GENERIC_ID_in_startTag480 = new BitSet(new long[] { 0x00000000004F4002L });
    public static final BitSet FOLLOW_attribute_in_startTag494 = new BitSet(new long[] { 0x00000000004F4002L });
    public static final BitSet FOLLOW_jspLexicon_in_startTag508 = new BitSet(new long[] { 0x00000000004F4002L });
    public static final BitSet FOLLOW_element_in_startTag522 = new BitSet(new long[] { 0x00000000004F4002L });
    public static final BitSet FOLLOW_GENERIC_ID_in_attribute581 = new BitSet(new long[] { 0x0000000000800000L });
    public static final BitSet FOLLOW_ATTR_EQ_in_attribute583 = new BitSet(new long[] { 0x0000000001000000L });
    public static final BitSet FOLLOW_ATTR_VALUE_OPEN_in_attribute585 = new BitSet(new long[] { 0x00000000024F0800L });
    public static final BitSet FOLLOW_attributeValue_in_attribute599 = new BitSet(new long[] { 0x00000000024F0800L });
    public static final BitSet FOLLOW_ATTR_VALUE_CLOSE_in_attribute609 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_PCDATA_in_attributeValue645 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_element_in_attributeValue653 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_jspLexicon_in_attributeValue662 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_TAG_END_OPEN_in_endTag686 = new BitSet(new long[] { 0x0000000000004000L });
    public static final BitSet FOLLOW_GENERIC_ID_in_endTag690 = new BitSet(new long[] { 0x0000000000100000L });
    public static final BitSet FOLLOW_TAG_CLOSE_in_endTag694 = new BitSet(new long[] { 0x0000000000000002L });

}
