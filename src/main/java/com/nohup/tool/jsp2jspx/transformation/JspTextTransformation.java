package com.nohup.tool.jsp2jspx.transformation;

import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree;
import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree.Element;
import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree.PcData;
import com.nohup.tool.jsp2jspx.processor.DefaultJspSyntaxTreeProcessor;
import com.nohup.tool.jsp2jspx.processor.JspSyntaxTreeProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.nohup.tool.jsp2jspx.parser.JspParser.ATTRIBUTE;
import static com.nohup.tool.jsp2jspx.parser.JspParser.ELEMENT;

/**
 * An extension of {@link AbstractJspSyntaxTreeTransformation} that matches pure text and enclose it with
 * the &lt;jsp:text&gt; element.
 *
 * @author Dmytro Koval
 */
public class JspTextTransformation extends AbstractJspSyntaxTreeTransformation {

    /**
     * The regular expression for pure text.
     */
    private static final Pattern INDENTED_TEXT_PATTERN = Pattern.compile("^(\\s*(?:\\n\\s*)+)([^\\s].*?)(\\s*)$");

    protected JspSyntaxTreeProcessor createJspSyntaxTreeProcessor() {
        return new DefaultJspSyntaxTreeProcessor() {

            public JspSyntaxTree onPcData(JspSyntaxTree tree, JspSyntaxTree parent, JspSyntaxTree prev) {
                return (parent == null || parent.getType() != ATTRIBUTE || parent.getType() == ELEMENT
                        && parent.getName().equals("script")) ? wrapInJspText(tree) : tree;
            }

            /**
             * Wraps pure text in &lt;jsp:text&gt; element.
             *
             * @param pcdata The <code>JspSyntaxTree<code> representing text to be wrapped in.
             * @return The transformed tree.
             */
            private JspSyntaxTree wrapInJspText(JspSyntaxTree pcdata) {
                final Matcher matcher = INDENTED_TEXT_PATTERN.matcher(pcdata.getText());
                if (matcher.matches()) {
                    final JspSyntaxTree jspText = new Element("jsp:text");
                    final String leadingSpace = matcher.group(1);
                    final String text = matcher.group(2);
                    final String trailingSpace = matcher.group(3);
                    jspText.addChild(new PcData(text));

                    final JspSyntaxTree list = new JspSyntaxTree();
                    list.addChild(new PcData(leadingSpace));
                    list.addChild(jspText);
                    if (trailingSpace.length() > 0) {
                        list.addChild(new PcData(trailingSpace));
                    }
                    return list;
                }
                return pcdata;
            }
        };
    }
}
