package com.nohup.tool.jsp2jspx.transformation;

import com.nohup.tool.jsp2jspx.ast.JspSyntaxTree;
import com.nohup.tool.jsp2jspx.processor.DefaultJspSyntaxTreeProcessor;
import com.nohup.tool.jsp2jspx.processor.JspSyntaxTreeProcessor;

import static com.nohup.tool.jsp2jspx.parser.JspParser.PCDATA;

/**
 * An extension of {@link AbstractJspSyntaxTreeTransformation} that analyzes PCDATA and escapes
 * XML characters, if needed.
 * <p>
 * See <a href="http://en.wikipedia.org/wiki/List_of_XML_and_HTML_character_entity_references">List of XML and HTML
 * character entity references</a> for more information.
 * </p>
 *
 * @author Dmytro Koval
 */
public class XmlEscapeCharactersTransformation extends AbstractJspSyntaxTreeTransformation {

    protected JspSyntaxTreeProcessor createJspSyntaxTreeProcessor() {
        return new DefaultJspSyntaxTreeProcessor() {

            public JspSyntaxTree onPcData(JspSyntaxTree pcData, JspSyntaxTree parent, JspSyntaxTree prev) {
                escapeXmlCharacters(pcData);
                if (prev != null && prev.getType() == PCDATA) {
                    prev.setText(prev.getText() + pcData.getText());
                    return null;
                }
                return pcData;
            }

            /**
             * Escapes XML characters.
             *
             * @param pcdata The <code>JspSyntaxTree</code> representing a <tt>PCDATA</tt> grammar element.
             */
            private void escapeXmlCharacters(JspSyntaxTree pcdata) {
                String text = pcdata.getText();
                text = text.replaceAll("&(?!amp;)", "&amp;");
                text = text.replace("<", "&lt;");
                text = text.replace(">", "&gt;");
                pcdata.setText(text);
            }
        };
    }
}
