package com.nohup.tool.jsp2jspx.processor;

import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree;

/**
 * The default JSP grammar processor that doesn't perform any modifications on the supplied {@link JspSyntaxTree} object.
 *
 * @author Dmytro Koval
 */
public class DefaultJspSyntaxTreeProcessor implements JspSyntaxTreeProcessor {

    public JspSyntaxTree onAttribute(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onProcessingInstruction(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onDoctypeDefinition(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onPcData(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onJspComment(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onElExpression(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onJspScriptlet(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onJspExpression(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onJspDirective(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onElement(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }

    public JspSyntaxTree onHtmlComment(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return tree;
    }
}
