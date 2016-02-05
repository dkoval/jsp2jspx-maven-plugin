package com.nohup.tool.jsp2jspx.transformation;

import com.nohup.tool.jsp2jspx.Jsp2JspxFailureException;
import com.nohup.tool.jsp2jspx.Jsp2JspxToolAssistant;
import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree;
import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree.Attribute;
import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree.Element;
import com.nohup.tool.jsp2jspx.parser.JspLexer;
import com.nohup.tool.jsp2jspx.parser.JspSyntaxTreeSerializer;
import com.nohup.tool.jsp2jspx.processor.Jsp2JspxSyntaxTreeProcessor;
import com.nohup.tool.jsp2jspx.processor.JspSyntaxTreeProcessor;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeNodeStream;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Converts a JSP page to a JSP document (JSPX), i.e. JSP in well-formed XML syntax. The code of this class is based on
 * the sources of <a href="http://code.google.com/p/jsp2x">Jsp2X</a> utility.
 *
 * @author Dmytro Koval
 */
public final class Jsp2JspxTool extends AbstractJspSyntaxTreeTransformation {

    /**
     * Inner logger.
     */
    private static final Logger logger = Logger.getLogger("com.nohup.tool.jsp2jspx");

    /**
     * The regular expression for an XML namespace.
     */
    private static final Pattern NAMESPACE_PATTERN = Pattern.compile("^(?:([-.\\w]+):)?[-.\\w]+$");

    /**
     * The JSP file to convert.
     */
    private final File inputFile;

    /**
     * The File where the generated JSP document (JSPX) will be written to.
     */
    private final File outputFile;

    /**
     * The character encoding used to read in JSP file.
     */
    private final String inputEncoding;

    /**
     * The character encoding for the generated JSPX file.
     */
    private final String outputEncoding;

    /**
     * A concrete implementation of the {@link JspSyntaxTreeProcessor} interface to be transparently used by this
     * transformation.
     */
    private final Jsp2JspxSyntaxTreeProcessor jspSyntaxTreeProcessor;

    /**
     * Constructs <code>Jsp2JspxTool</code>.
     *
     * @param inputFile      The JSP file to convert.
     * @param outputFile     The File where the generated JSP document (JSPX) will be written to.
     * @param inputEncoding  The character encoding used to read in JSP file.
     * @param outputEncoding The character encoding for the generated JSPX file.
     * @param assistant      The object that will assist in resolving file paths to the dependent resources.
     * @see java.nio.charset.Charset
     */
    public Jsp2JspxTool(File inputFile, File outputFile, String inputEncoding, String outputEncoding,
                        Jsp2JspxToolAssistant assistant) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;

        this.inputEncoding = inputEncoding;
        this.outputEncoding = outputEncoding;

        this.jspSyntaxTreeProcessor = new Jsp2JspxSyntaxTreeProcessor(assistant);
    }

    @Override
    protected JspSyntaxTreeProcessor createJspSyntaxTreeProcessor() {
        return jspSyntaxTreeProcessor;
    }

    /**
     * Allows or disables to detect recursion in attributes.
     *
     * @param detectRecursionInAttributes <code>true</code> if recursion detection is allowed or <code>false</code> if
     *                                    detection must be disabled.
     */
    public void setDetectRecursionInAttributes(boolean detectRecursionInAttributes) {
        this.jspSyntaxTreeProcessor.setDetectRecursionInAttributes(detectRecursionInAttributes);
    }

    /**
     * Converts of a JSP file to a JSP document (JSPX).
     *
     * @throws IOException          In case of I/O errors.
     * @throws RecognitionException In case of ANTLR parsing errors.
     */
    public void convert() throws IOException, RecognitionException {
        // Parse JSP file.
        JspSyntaxTree tree = parseJsp();
        if (tree == null) {
            logger.warning("Parser didn't return any results");
            return;
        }

        // Transform JspSyntaxTree so that it conforms to the JSPX standard.
        tree = transform(tree);
        wrapInRootElement(tree);
        addNamespacesToRootElement(tree);

        // Serialize processed JspSyntax tree to a file.
        serializeJspSyntaxTree(tree);
    }

    /**
     * Creates an instance of {@link com.nohup.tool.jsp2jspx.parser.JspParser} and parsers the current {@link #inputFile}.
     *
     * @return The <code>JspSyntaxTree</code> as a result of parsing.
     * @throws IOException          In case of I/O errors.
     * @throws RecognitionException In case of ANTLR parsing errors.
     */
    private JspSyntaxTree parseJsp() throws IOException, RecognitionException {
        final JspLexer lexer = new JspLexer(new ANTLRFileStream(this.inputFile.getPath(), this.inputEncoding));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final com.nohup.tool.jsp2jspx.parser.JspParser parser = new com.nohup.tool.jsp2jspx.parser.JspParser(tokens);
        parser.setTreeAdaptor(new JspSyntaxTree.JspSyntaxTreeAdaptor());
        return (JspSyntaxTree) parser.document().getTree();
    }

    /**
     * Serializes preliminarily processed <code>JspSyntaxTree</code> to a file.
     *
     * @param tree The <code>JspSyntaxTree</code> to be serialized.
     * @throws IOException          In case of I/O errors.
     * @throws RecognitionException In case of ANTLR parsing errors.
     */
    private void serializeJspSyntaxTree(JspSyntaxTree tree) throws IOException, RecognitionException {
        final TreeNodeStream nodes = new CommonTreeNodeStream(tree);
        final PrintStream printStream = new PrintStream(this.outputFile, this.outputEncoding);
        final JspSyntaxTreeSerializer jspxParser = new JspSyntaxTreeSerializer(nodes, printStream);
        jspxParser.document();
    }

    @Override
    protected JspSyntaxTree transform(JspSyntaxTree tree) {
        tree = super.transform(tree);
        tree = new XmlEscapeCharactersTransformation().transform(tree);
        tree = new JspTextTransformation().transform(tree);
        return tree;
    }

    @Override
    protected JspSyntaxTree transform(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
        tree = super.transform(tree, parent, prev);
        if (tree != null)
            trackNamespacesInElement(tree);
        return tree;
    }

    /**
     * Tracks namespaces in a JSP element and stores them into namespaces.
     *
     * @param element
     */
    private void trackNamespacesInElement(JspSyntaxTree element) {
        if (element.getType() == com.nohup.tool.jsp2jspx.parser.JspParser.ELEMENT) {
            final Matcher matcher = NAMESPACE_PATTERN.matcher(element.getName());
            if (matcher.matches()) {
                this.jspSyntaxTreeProcessor.getNamespaces().add(matcher.group(1));
            }
        }
    }

    /**
     * Wraps the entire <code>tree</code> in either <jsp:root> or <jspx:fragment> root element, depending on JSP file
     * extension.
     *
     * @param tree The resulting <code>JspSyntaxTree</code>.
     */
    private void wrapInRootElement(JspSyntaxTree tree) {
        JspSyntaxTree root = inputFile.getPath().endsWith(".jspf") ? new Element(
                Jsp2JspxSyntaxTreeProcessor.JSPX_NAMESPACE + ":fragment") : new Element("jsp:root", new Attribute(
                "version", "2.0"));

        trackNamespacesInElement(root);

        for (int i = 0; i < tree.getChildCount(); i++) {
            final JspSyntaxTree child = tree.getChild(i);
            final int type = child.getType();
            if (type != com.nohup.tool.jsp2jspx.parser.JspParser.PROCESSING_INSTRUCTION && type != com.nohup.tool.jsp2jspx.parser.JspParser.DOCTYPE_DEFINITION) {
                tree.deleteChild(i--);
                root.addChild(child);
            }
        }
        tree.addChild(root);
    }

    /**
     * Finds the root element in a given <code>tree</code>.
     *
     * @param tree The <code>JspSyntaxTree</code> to be searched for the root element.
     * @return The root element or <code>null</code> if it doesn't exists in the given tree.
     */
    private JspSyntaxTree findRootElement(JspSyntaxTree tree) {
        JspSyntaxTree candidateForRoot = null;
        for (int i = 0; i < tree.getChildCount(); i++) {
            final JspSyntaxTree child = tree.getChild(i);
            if (child.getType() == com.nohup.tool.jsp2jspx.parser.JspParser.ELEMENT) {
                if (candidateForRoot == null) {
                    candidateForRoot = child;
                } else {
                    return null;
                }
            }
        }
        return candidateForRoot;
    }

    /**
     * Finds the root element in a given <code>tree</code> and adds all resolved namespaces to it.
     *
     * @param tree The <code>JspSyntaxTree</code> to be transformed.
     */
    private void addNamespacesToRootElement(JspSyntaxTree tree) {
        final JspSyntaxTree root = findRootElement(tree);
        if (root != null) {
            final JspSyntaxTree attributes = root.getAttributes();
            for (final String namespace : this.jspSyntaxTreeProcessor.getNamespaces()) {
                attributes.addChild(new Attribute("xmlns" + (namespace != null ? ":" + namespace : ""),
                        this.jspSyntaxTreeProcessor.getNamespaceMappings().get(namespace)));
            }
        } else {
            throw new Jsp2JspxFailureException("Wasn't able to determine the root element of converted input");
        }
    }
}
