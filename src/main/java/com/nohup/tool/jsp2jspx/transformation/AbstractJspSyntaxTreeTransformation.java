package com.nohup.tool.jsp2jspx.transformation;

import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree;
import com.nohup.tool.jsp2jspx.processor.JspSyntaxTreeProcessor;
import org.antlr.runtime.tree.Tree;

import static com.nohup.tool.jsp2jspx.parser.JspParser.*;

/**
 * An abstract JSP Syntax Tree transformation that is common to all subclasses intended for processing JSP
 * grammar. This class provides template implementation of the {@link #transform(JspSyntaxTree)} method that is typical
 * to all subclasses.
 *
 * @author Dmytro Koval
 */
public abstract class AbstractJspSyntaxTreeTransformation {

    /**
     * The {@link JspSyntaxTreeProcessor} to be used by this transformation.
     *
     * @see {@link #transform(JspSyntaxTree, JspSyntaxTree, JspSyntaxTree)} method.
     */
    private JspSyntaxTreeProcessor jspSyntaxTreeProcessor;

    /**
     * Creates the {@link JspSyntaxTreeProcessor} object to be used by this transformation.
     *
     * @return The {@link JspSyntaxTreeProcessor} object to be used by this transformation, never <code>null</code>.
     */
    protected abstract JspSyntaxTreeProcessor createJspSyntaxTreeProcessor();

    /**
     * Gets the {@link JspSyntaxTreeProcessor} object to be used by this transformation. This method ensures that the
     * <code>JspSyntaxTreeProcessor</code> is created only once.
     *
     * @return The {@link JspSyntaxTreeProcessor} object to be used by this transformation.
     */
    private JspSyntaxTreeProcessor getJspSyntaxTreeProcessor() {
        if (this.jspSyntaxTreeProcessor == null) {
            this.jspSyntaxTreeProcessor = createJspSyntaxTreeProcessor();
        }
        return jspSyntaxTreeProcessor;
    }

    /**
     * Transforms a given JSP syntax tree, starting from the root.
     *
     * @param tree The tree to be transformed.
     * @return The transformed tree or <code>null</code> if argument tree should be removed from its parent.
     */
    protected JspSyntaxTree transform(JspSyntaxTree tree) {
        return transform(tree, null, null);
    }

    /**
     * Transforms a given JSP syntax tree.
     *
     * @param tree  The tree to be transformed. Can be <code>nil</code> (see {@link Tree#isNil()}) but must not be
     * <code>null</code>.
     * @param parent The parent of this tree.
     * @param prev The tree that immediately precedes the given tree in the parents list of children.
     * @return  The transformed tree or <code>null</code> if argument tree should be removed from its parent. The return
     * value is not necessarily a new tree instance, it could be identical (==) to the argument. If the returned tree is
     * <code>nil<code> (see {@link Tree#isNil()}) the tree argument was transformed into a list of trees. In that case
     * the returned tree is supposed to be removed from its parent and be replaced with the children of the returned tree.
     */
    protected JspSyntaxTree transform(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        switch (tree.getType()) {
        case ELEMENT:
            tree = getJspSyntaxTreeProcessor().onElement(tree, parent, prev);
            break;
        case JSP_DIRECTIVE:
            tree = getJspSyntaxTreeProcessor().onJspDirective(tree, parent, prev);
            break;
        case JSP_EXPRESSION:
            tree = getJspSyntaxTreeProcessor().onJspExpression(tree, parent, prev);
            break;
        case JSP_SCRIPTLET:
            tree = getJspSyntaxTreeProcessor().onJspScriptlet(tree, parent, prev);
            break;
        case EL_EXPR:
            tree = getJspSyntaxTreeProcessor().onElExpression(tree, parent, prev);
            break;
        case JSP_COMMENT:
            tree = getJspSyntaxTreeProcessor().onJspComment(tree, parent, prev);
            break;
        case COMMENT:
            tree = getJspSyntaxTreeProcessor().onHtmlComment(tree, parent, prev);
            break;
        case PCDATA:
            tree = getJspSyntaxTreeProcessor().onPcData(tree, parent, prev);
            break;
        case DOCTYPE_DEFINITION:
            tree = getJspSyntaxTreeProcessor().onDoctypeDefinition(tree, parent, prev);
            break;
        case PROCESSING_INSTRUCTION:
            tree = getJspSyntaxTreeProcessor().onProcessingInstruction(tree, parent, prev);
            break;
        case ATTRIBUTE:
            tree = getJspSyntaxTreeProcessor().onAttribute(tree, parent, prev);
            break;
        }

        if (tree != null) {
            transformChildren(tree);
        }
        return tree;
    }

    /**
     * Transforms a given JSP syntax tree by means of removing its empty or redundant child elements.
     *
     * @param tree The tree to be transformed. Must not be <code>null</code>.
     */
    protected final void transformChildren(JspSyntaxTree tree) {
        JspSyntaxTree prev = null;
        for (int i = 0; i < tree.getChildCount(); i++) {
            final JspSyntaxTree child = tree.getChild(i);
            final JspSyntaxTree transformedChild = transform(child, tree, prev);
            if (child != transformedChild) {
                if (transformedChild != null) {
                    if (transformedChild.isNil()) {
                        tree.deleteChild(i);
                        i += tree.insertChild(i, transformedChild) - 1;
                        prev = i > 0 ? tree.getChild(i) : null;
                    } else {
                        tree.setChild(i, prev = transformedChild);
                    }
                } else {
                    tree.deleteChild(i);
                    while (i < tree.getChildCount() && (tree.getChild(i)).isEmpty()) {
                        tree.deleteChild(i);
                    }
                    i--;
                }
            } else {
                prev = child;
            }
        }
    }
}
