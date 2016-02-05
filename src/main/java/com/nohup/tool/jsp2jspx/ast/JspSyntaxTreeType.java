package com.nohup.tool.jsp2jspx.ast;

import com.nohup.tool.jsp2jspx.parser.JspParser;

/**
 * Denotes a set of allowed types for {@link JspSyntaxTree}.
 *
 * @author Dmytro Koval
 * @see {@link JspSyntaxTree#setType(JspSyntaxTreeType)} method.
 */
public enum JspSyntaxTreeType {

    PROCESSING_INSTRUCTION(JspParser.PROCESSING_INSTRUCTION),
    DOCTYPE_DEFINITION(JspParser.DOCTYPE_DEFINITION),
    COMMENT(JspParser.COMMENT),
    JSP_COMMENT(JspParser.JSP_COMMENT),
    ELEMENT(JspParser.ELEMENT),
    ATTRIBUTE(JspParser.ATTRIBUTE),
    ATTRIBUTES(JspParser.ATTRIBUTES),
    ATTR_VALUE_OPEN(JspParser.ATTR_VALUE_OPEN),
    ATTR_VALUE_CLOSE(JspParser.ATTR_VALUE_CLOSE),
    JSP_DIRECTIVE_OPEN(JspParser.JSP_DIRECTIVE_OPEN),
    JSP_DIRECTIVE(JspParser.JSP_DIRECTIVE),
    JSP_DIRECTIVE_CLOSE(JspParser.JSP_DIRECTIVE_CLOSE),
    JSP_EXPRESSION(JspParser.JSP_EXPRESSION),
    JSP_SCRIPTLET(JspParser.JSP_SCRIPTLET),
    EL_EXPR(JspParser.EL_EXPR),
    CDATA(JspParser.CDATA),
    PCDATA(JspParser.PCDATA),
    GENERIC_ID(JspParser.GENERIC_ID),
    TAG_START_OPEN(JspParser.TAG_START_OPEN),
    TAG_END_OPEN(JspParser.TAG_END_OPEN),
    TAG_EMPTY_CLOSE(JspParser.TAG_EMPTY_CLOSE),
    TAG_CLOSE(JspParser.TAG_CLOSE),
    WHITESPACE(JspParser.WHITESPACE),
    NAMECHAR(JspParser.NAMECHAR),
    DIGIT(JspParser.DIGIT),
    LETTER(JspParser.LETTER),
    ATTR_EQ(JspParser.ATTR_EQ),
    EOF(JspParser.EOF);

    /**
     * The type of a concrete instance of <code>JspSyntaxTree</code> as it is produced by ANTLR parser generator.
     */
    private final int type;

    /**
     * Constructs <code>JspSyntaxTreeType</code>.
     */
    private JspSyntaxTreeType(int type) {
        this.type = type;
    }

    /**
     * Returns the type of a concrete instance of <code>JspSyntaxTree</code> as it is produced by ANTLR parser generator.
     *
     * @return the integer value representing the type of a concrete instance of <code>JspSyntaxTree</code>.
     * @see {@link JspParser#PROCESSING_INSTRUCTION} ... {@link JspParser#EOF} public static constants.
     */
    public int getTypeAsInt() {
        return this.type;
    }
}
