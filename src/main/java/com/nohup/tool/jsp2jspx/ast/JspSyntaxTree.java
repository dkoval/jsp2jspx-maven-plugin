package com.nohup.tool.jsp2jspx.ast;

import com.nohup.tool.jsp2jspx.parser.JspParser;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import java.util.regex.Pattern;

/**
 * An extension of the ANTLR's AST (Abstract Syntax Tree) representing a JSP page
 * in a tree-like data structure.
 *
 * @author Dmytro Koval
 */
public class JspSyntaxTree extends CommonTree {

    /**
     * Regular expression describing any number of whitespace characters.
     */
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s*");

    /**
     * Constructs <code>JspSyntaxTree</code>.
     */
    public JspSyntaxTree() {
        super();
    }

    /**
     * Constructs <code>JspSyntaxTree</code> of the type <code>type</code>, sets <code>text</code> as its value and maps
     * all the supplied <code>children</code> to it.
     *
     * @param type     The type of the <code>JspSyntaxTree</code>.
     * @param text     The text set as a value for this tree.
     * @param children the child elements to be mapped to this tree.
     */
    public JspSyntaxTree(JspSyntaxTreeType type, String text, JspSyntaxTree... children) {
        super(new CommonToken(type.getTypeAsInt(), text));
        for (final JspSyntaxTree child : children) {
            addChild(child);
        }
    }

    /**
     * Constructs <code>JspSyntaxTree</code> from a given {@link Token}.
     *
     * @param t The <code>Token</code> from which this tree will be constructed.
     */
    private JspSyntaxTree(Token t) {
        super(t);
    }

    /**
     * Sets the type of this tree.
     *
     * @param type The type to be set.
     * @see #getType()
     */
    public void setType(JspSyntaxTreeType type) {
        getToken().setType(type.getTypeAsInt());
    }

    /**
     * Sets text of this tree.
     *
     * @param string The text to be set.
     * @see #getText()
     */
    public void setText(String string) {
        getToken().setText(string);
    }

    /**
     * Gets the name of this tree.
     *
     * @return The name of this tree.
     */
    public String getName() {
        return getChild(0).getText();
    }

    /**
     * Sets the name of this tree.
     *
     * @param name The name to be set.
     */
    public void setName(String name) {
        getChild(0).setText(name);
    }

    /**
     * Adds an attribute to this tree if its type is either <tt>JSP element</tt> or <tt>JSP directive</tt>.
     *
     * @param attribute The <code>JspSyntaxTree</code> representing an attribute to be added to this tree.
     * @throws RuntimeException If <code>this</code> tree type is nether <tt>JSP element</tt> nor <tt>JSP directive</tt>.
     */
    public void addAttribute(JspSyntaxTree attribute) {
        if (getType() == JspParser.ELEMENT || getType() == JspParser.JSP_DIRECTIVE) {
            getChild(1).addChild(attribute);
        } else {
            throw new RuntimeException("Given tree is not an element");
        }
    }

    /**
     * Gets attributes of this tree.
     *
     * @return The <code>JspSyntaxTree</code> representing attributes of this tree.
     * @throws RuntimeException If <code>this</code> tree type is nether <tt>JSP element</tt> nor <tt>JSP directive</tt>.
     */
    public JspSyntaxTree getAttributes() {
        if (getType() == JspParser.ELEMENT || getType() == JspParser.JSP_DIRECTIVE) {
            return getChild(1);
        } else {
            throw new RuntimeException("Given tree is not an element");
        }
    }

    /**
     * Gets a so-called "value" of this tree if its type is <tt>JSP Attribute</tt>.
     *
     * @return The <code>JspSyntaxTree</code> representing a "value" of this tree.
     * @throws RuntimeException if <code>this</code> tree type is not <tt>JSP Attribute</tt> or this tree has more
     *                          complex structure.
     */
    public JspSyntaxTree getTreeValue() {
        if (!(getType() == JspParser.ATTRIBUTE)) {
            throw new RuntimeException("Given tree is not an attribute");
        }
        if (!(getChildCount() == 2)) {
            throw new RuntimeException("Given attribute has a complex value");
        }
        return getChild(1);
    }

    /**
     * Gets a so-called "value" of this tree as a string.
     *
     * @return The string representing a value of this tree.
     * @throws RuntimeException if a "value" of this tree cannot be converted to string.
     */
    public String getTreeValueAsString() {
        final JspSyntaxTree value = this.getTreeValue();
        if (value.getType() == JspParser.PCDATA || value.getType() == JspParser.EL_EXPR) {
            return value.getText();
        } else {
            throw new RuntimeException("Given attribute is not of type text");
        }
    }

    /**
     * Inserts a child tree at the specified position in this tree.
     *
     * @param index The index of tree to insert.
     * @param child The <code>JspSyntaxTree</code> to be inserted at the specified position.
     * @return the number of children in the resulting tree.
     */
    @SuppressWarnings("unchecked")
    public int insertChild(int index, JspSyntaxTree child) {
        if (child == null)
            return 0;
        if (children == null) {
            children = createChildrenList();
        }
        if (child.isNil()) {
            final int childCount = child.getChildCount();
            for (int i = 0; i < childCount; i++) {
                children.add(index + i, child.getChild(i));
            }
            return childCount;
        } else {
            children.add(index, child);
            return 1;
        }
    }

    @Override
    public JspSyntaxTree getChild(int i) {
        return (JspSyntaxTree) super.getChild(i);
    }

    /**
     * @return <code>true</code> if <code>this</code> tree type is <tt>PCDATA</tt> or its text contains only whitespace
     * characters, otherwise <code>false</code>.
     * @see #getText()
     */
    public boolean isEmpty() {
        return getType() == JspParser.PCDATA && WHITESPACE_PATTERN.matcher(getText()).matches();
    }

    /**
     * @return <code>true</code> if all children of this tree are empty, otherwise <code>false</code>.
     */
    public boolean hasEmptyChildren() {
        for (int i = 0; i < getChildCount(); i++) {
            final JspSyntaxTree child = getChild(i);
            if (!child.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * A {@link TreeAdaptor} for <code>JspSyntaxTree</code> class.
     */
    public final static class JspSyntaxTreeAdaptor extends CommonTreeAdaptor {

        @Override
        public Object create(Token payload) {
            return new JspSyntaxTree(payload);
        }
    }

    /**
     * Represents <tt>Element</tt> grammar element.
     */
    public static class Element extends JspSyntaxTree {

        public Element(String name, final JspSyntaxTree... attributes) {
            super(JspSyntaxTreeType.ELEMENT, "ELEMENT",
                    new Id(name),
                    new JspSyntaxTree(JspSyntaxTreeType.ATTRIBUTES, "ATTRIBUTES", attributes));
        }
    }

    /**
     * Represents <tt>Attribute</tt> grammar element.
     */
    public static class Attribute extends JspSyntaxTree {

        public Attribute(String name, JspSyntaxTree value) {
            super(JspSyntaxTreeType.ATTRIBUTE, "ATTRIBUTE", new Id(name), value);
        }

        public Attribute(final String name, final String value) {
            this(name, new PcData(value));
        }
    }

    /**
     * Represents <tt>Generic Id</tt> grammar element.
     */
    public static class Id extends JspSyntaxTree {

        public Id(final String id) {
            super(JspSyntaxTreeType.GENERIC_ID, id);
        }
    }

    /**
     * Represents <tt>PCDATA</tt> grammar element.
     */
    public static class PcData extends JspSyntaxTree {

        public PcData(String value) {
            super(JspSyntaxTreeType.PCDATA, value);
        }
    }
}
