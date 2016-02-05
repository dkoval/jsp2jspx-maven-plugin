package com.nohup.tool.jsp2jspx;

/**
 * Assists Jsp2Jspx tool by means of providing auxiliary utility methods.
 *
 * @author Dmytro Koval
 */
public interface Jsp2JspxToolAssistant {

    /**
     * Resolves a JSPX file path from a given JSP file path.
     *
     * @param jspFilePath The JSP file path from which the JSPX file path will be constructed.
     * @return The JSPX file path.
     */
    String resolveJspxFilePath(String jspFilePath);
}
