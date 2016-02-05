package com.nohup.tool.jsp2jspx.processor;

import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree;
import com.nohup.tool.jsp2jspx.transformation.AbstractJspSyntaxTreeTransformation;

/**
 * Defines a set of rules to be applied to a {@link JspSyntaxTree} instance by any subclass of the
 * {@link AbstractJspSyntaxTreeTransformation}.
 *
 * @author Dmytro Koval
 */
public interface JspSyntaxTreeProcessor {

    /**
     * Transforms <tt>Attribute</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onAttribute(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>Processing Instruction</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onProcessingInstruction(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>DOCTYPE Definition</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onDoctypeDefinition(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>PCDATA</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onPcData(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>JSP Comment</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onJspComment(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>EL Expression</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onElExpression(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>JSP Scriptlet</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onJspScriptlet(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>JSP Expression</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onJspExpression(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>JSP Directive</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onJspDirective(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>Element</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onElement(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);

    /**
     * Transforms <tt>HTML Comment</tt> grammar element.
     *
     * @param tree   The tree to be transformed. Must not be <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev   The tree that immediately precedes the given tree in the parents list of children.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    JspSyntaxTree onHtmlComment(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev);
}
