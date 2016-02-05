package com.nohup.tool.jsp2jspx.processor;

import com.nohup.tool.jsp2jspx.Jsp2JspxToolAssistant;
import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree;
import com.nohup.tool.jsp2jspx.ast.JspSyntaxTreeType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Processes {@link JspSyntaxTree} object so that it conforms to the JSPX standard.
 *
 * @author Dmytro Koval
 */
public class Jsp2JspxSyntaxTreeProcessor extends DefaultJspSyntaxTreeProcessor {

    /**
     * Inner logger.
     */
    private static final Logger logger = Logger.getLogger("com.nohup.tool.jsp2jspx");

    /**
     * The XML namespace provided by <code>Jsp2JspxTool</code>.
     */
    public static final String JSPX_NAMESPACE = "jspx";

    /**
     * The regular expression for an XML declaration.
     */
    private static final Pattern XML_DECLARATION_PATTERN = Pattern.compile("^\\s*xml\\s+");

    /**
     * The regular expression for an EL expression.
     */
    private static final Pattern EL_FUNCTION_INVOCATION_PATTERN = Pattern.compile("(\\w+):\\w+\\(");

    /**
     * The regular expression for a DOCTYPE definition.
     */
    private static final Pattern DOCTYPE_PATTERN = Pattern.compile("<!DOCTYPE\\s+" // preamble
            + "(\\w+)\\s+"            // root namespace
            + "PUBLIC\\s+"            // public doctype
            + "\"([^\"]+)\"\\s+"    // the PubId Literal
            + "\"([^\"]+)\""        // the System Literal
            + "\\s*>");

    /**
     * Assists <code>Jsp2JspxTool</code> in resolving file paths to the dependent resources.
     */
    private final Jsp2JspxToolAssistant assistant;

    /**
     * Whether or not to allow the processor to detect recursion in attributes.
     */
    private boolean detectRecursionInAttributes = true;

    /**
     * Holds namespaces extracted from the <code>JspSyntaxTree</code> tree.
     */
    private final Set<String> namespaces = new HashSet<String>();

    /**
     * Holds namespace mappings.
     */
    @SuppressWarnings("serial")
    private final Map<String, String> namespaceMappings = new HashMap<String, String>() {
        {
            put(null, "http://www.w3c.org/1999/xhtml");
            put("jsp", "http://java.sun.com/JSP/Page");
            put(JSPX_NAMESPACE, "urn:jsptagdir:/WEB-INF/tags/jspx");
        }
    };

    /**
     * Constructs <code>Jsp2JspxSyntaxTreeProcessor</code>.
     *
     * @param assistant The object that will assist in resolving file paths to the dependent resources.
     */
    public Jsp2JspxSyntaxTreeProcessor(Jsp2JspxToolAssistant assistant) {
        if (assistant == null) {
            throw new IllegalArgumentException("assistant argument must not be null");
        }
        this.assistant = assistant;
    }


    /**
     * @return The namespaces extracted from the <code>JspSyntaxTree</code> tree.
     */
    public Set<String> getNamespaces() {
        return namespaces;
    }

    /**
     * @return The namespace mappings.
     */
    public Map<String, String> getNamespaceMappings() {
        return namespaceMappings;
    }

    /**
     * Allows or disables to detect recursion in attributes.
     *
     * @param detectRecursionInAttributes <code>true</code> if recursion detection is allowed or <code>false</code> if
     *                                    detection must be disabled.
     */
    public void setDetectRecursionInAttributes(boolean detectRecursionInAttributes) {
        this.detectRecursionInAttributes = detectRecursionInAttributes;
    }

    public JspSyntaxTree onProcessingInstruction(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return XML_DECLARATION_PATTERN.matcher(tree.getText()).lookingAt() ? null : tree;
    }

    public JspSyntaxTree onDoctypeDefinition(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        final Matcher matcher = DOCTYPE_PATTERN.matcher(tree.getText());
        if (matcher.matches()) {
            return new JspSyntaxTree.Element("jsp:output", new JspSyntaxTree.Attribute("doctype-root-element", matcher.group(1)), new JspSyntaxTree.Attribute(
                    "doctype-public", matcher.group(2)), new JspSyntaxTree.Attribute("doctype-system", matcher.group(3)));

        }
        return tree;
    }

    public JspSyntaxTree onJspComment(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        tree.setType(JspSyntaxTreeType.COMMENT);
        return tree;
    }

    public JspSyntaxTree onElExpression(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        trackNamespacesInElExpression(tree);
        tree.setType(JspSyntaxTreeType.PCDATA);
        tree.setText("${" + tree.getText() + "}");
        return tree;
    }

    /**
     * Tracks namespaces in an EL expression and stores them into {@link #namespaces}.
     *
     * @param el The <code>JspSyntaxTree</code> representing EL expression.
     */
    private void trackNamespacesInElExpression(JspSyntaxTree el) {
        if (el.getType() == com.nohup.tool.jsp2jspx.parser.JspParser.EL_EXPR) {
            final Matcher matcher = EL_FUNCTION_INVOCATION_PATTERN.matcher(el.getText());
            while (matcher.find()) {
                this.namespaces.add(matcher.group(1));
            }
        }
    }

    public JspSyntaxTree onJspScriptlet(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return wrapInElement(tree, "jsp:scriptlet");
    }

    public JspSyntaxTree onJspExpression(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        return wrapInElement(tree, "jsp:expression");
    }

    /**
     * Wraps a given <code>tree</code> inside a new element.
     *
     * @param tree        The <code>JspSyntaxTree</code> to be wrapped in.
     * @param elementName The name of new element to create.
     * @return The created element.
     */
    private JspSyntaxTree wrapInElement(JspSyntaxTree tree, String elementName) {
        tree.setType(JspSyntaxTreeType.PCDATA);
        final JspSyntaxTree element = new JspSyntaxTree.Element(elementName);
        element.addChild(tree);
        return element;
    }

    public JspSyntaxTree onJspDirective(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        if (handleTaglibDirective(tree)) {
            return null;
        }

        handleIncludeDirective(tree);
        tree.setType(JspSyntaxTreeType.ELEMENT);
        tree.setName("jsp:directive." + tree.getName());
        return tree;
    }

    /**
     * Handles JSP Include directive.
     *
     * @param directive The <code>JspSyntaxTree</code> representing a JSP Include directive.
     */
    private void handleIncludeDirective(JspSyntaxTree directive) {
        if (directive.getName().equalsIgnoreCase("include")) {
            final JspSyntaxTree attributes = directive.getAttributes();
            for (int i = 0; i < attributes.getChildCount(); i++) {
                final JspSyntaxTree attribute = attributes.getChild(i);
                if (attribute.getName().equalsIgnoreCase("file")) {
                    // Resolve path to a JSPX file.
                    final String fileName = attribute.getTreeValueAsString();
                    final String newFileName = this.assistant.resolveJspxFilePath(fileName);
                    if (!fileName.equals(newFileName)) {
                        attribute.getTreeValue().setText(newFileName);
                    }
                }
            }
        }
    }

    /**
     * Handles JSP Taglib directive.
     *
     * @param directive The <code>JspSyntaxTree</code> representing a JSP Taglib directive.
     * @return <code>true</code> on success, otherwise <code>false</code>.
     */
    private boolean handleTaglibDirective(JspSyntaxTree directive) {
        if (directive.getName().equalsIgnoreCase("taglib")) {
            String namespace = null;
            String uri = null;
            final JspSyntaxTree attributes = directive.getAttributes();
            for (int i = 0; i < attributes.getChildCount(); i++) {
                final JspSyntaxTree attribute = attributes.getChild(i);
                final String name = attribute.getName();
                final String value = attribute.getTreeValueAsString();
                if ("prefix".equalsIgnoreCase(name)) {
                    namespace = value;
                } else if ("uri".equalsIgnoreCase(name)) {
                    if (value.startsWith("/")) {
                        uri = "urn:jsptld:" + value;
                    } else {
                        uri = value;
                    }
                } else if ("tagdir".equalsIgnoreCase(name)) {
                    uri = "urn:jsptagdir:" + value;
                } else {
                    logger.warning("Unknown taglib directive atribute: " + name);
                }
            }
            if (namespace != null && uri != null) {
                namespaceMappings.put(namespace, uri);
                return true;
            }
            logger.warning("Incomplete taglib directive: " + directive.getText());
        }
        return false;
    }

    public JspSyntaxTree onElement(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        if (this.detectRecursionInAttributes && hasRecursionInAttributes(tree)) {
            throw new RuntimeException("Could not resolve recursion in attribute: " + tree.getName());
        }
        return tree;
    }

    /**
     * Checks if a given element has recursion in its attributes, i.e. the value of an attribute is a
     * <tt>JSP Expression</tt>, other <tt>JSP Element</tt> or a <tt>JSP Scriptlet</tt>.
     *
     * @param element The <code>JspSyntaxTree</code> representing a JSP element to be checked.
     * @return <code>true</code> if the element contains recursion in its attributes, otherwise <code>false</code>.
     */
    private boolean hasRecursionInAttributes(JspSyntaxTree element) {
        final JspSyntaxTree attributes = element.getAttributes();
        if (attributes != null) {
            for (int i = 0; i < attributes.getChildCount(); i++) {
                final JspSyntaxTree attribute = attributes.getChild(i);
                if (attribute.getType() == com.nohup.tool.jsp2jspx.parser.JspParser.ATTRIBUTE) {
                    for (int j = 1; j < attribute.getChildCount(); j++) {
                        final int type = attribute.getChild(j).getType();
                        if (type == com.nohup.tool.jsp2jspx.parser.JspParser.JSP_EXPRESSION || type == com.nohup.tool.jsp2jspx.parser.JspParser.ELEMENT || type == com.nohup.tool.jsp2jspx.parser.JspParser.JSP_SCRIPTLET) {
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
