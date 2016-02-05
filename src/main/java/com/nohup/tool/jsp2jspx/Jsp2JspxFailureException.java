package com.nohup.tool.jsp2jspx;

/**
 * The <code>Jsp2JspxFailureException</code> indicates conditions that the application might want to catch.
 * <p>
 * As this class is a runtime exception, there is no need for user code or subclasses to catch it
 * if any error is to be considered fatal.
 * </p>
 *
 * @author Dmytro Koval
 */
public class Jsp2JspxFailureException extends RuntimeException {

    /**
     * Constructs <code>Jsp2JspxFailureException</code>.
     */
    public Jsp2JspxFailureException() {
        super();
    }

    /**
     * Constructs <code>Jsp2JspxFailureException</code>.
     *
     * @param message the detail message.
     * @param cause   the root cause.
     */
    public Jsp2JspxFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs <code>Jsp2JspxFailureException</code>.
     *
     * @param message the detail message.
     * @param cause   the root cause.
     */
    public Jsp2JspxFailureException(String message) {
        super(message);
    }

    /**
     * Constructs <code>Jsp2JspxFailureException</code>.
     *
     * @param cause the root cause.
     */
    public Jsp2JspxFailureException(Throwable cause) {
        super(cause);
    }
}
