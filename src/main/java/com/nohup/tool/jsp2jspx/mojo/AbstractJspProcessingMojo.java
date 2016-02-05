package com.nohup.tool.jsp2jspx.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import java.io.File;

/**
 * Provides common services for all mojos that process JSP files.
 *
 * @author Dmytro Koval
 */
public abstract class AbstractJspProcessingMojo extends AbstractMojo {

    /**
     * @parameter default-value="${project}"
     * @required
     * @readonly
     */
    protected MavenProject project;

    /**
     * A set of Ant-like inclusion patterns used to select files from the source directory for processing.
     * Can be <code>null</code> if all files should be included. By default the patterns
     * <code>**&#47;*.jsp</code>, <code>**&#47;*.jspf</code> and <code>**&#47;*.tag</code>
     * are used to select JSP files.
     *
     * @parameter
     */
    protected String[] includes = new String[]{"**/*.jsp", "**/*.jspf", "**/*.tag"};

    /**
     * A set of Ant-like exclusion patterns used to prevent certain files from being processed. By default, this set is
     * empty such that no files are excluded.
     *
     * @parameter
     */
    protected String[] excludes;

    /**
     * Gets the absolute path to the directory where the JSP files are located.
     *
     * @return The absolute path to the directory where the JSP files are located, never <code>null</code>.
     */
    public abstract File getSourceDirectory();

    /**
     * Gets a set of Ant-like inclusion patterns used to select JSP files from the source directory for processing.
     *
     * @return A set of Ant-like inclusion patterns used to select JSP files from the source directory for processing,
     * can be <code>null</code> if all files should be included.
     */
    protected String[] getIncludes() {
        return this.includes;
    }

    /**
     * Gets a set of Ant-like exclusion patterns used to exclude JSP files from the source directory for processing.
     *
     * @return A set of Ant-like inclusion patterns used to exclude JSP files from the source directory for processing,
     * can be <code>null</code> if no files should be excluded.
     */
    protected String[] getExcludes() {
        return this.excludes;
    }

    /**
     * Scans the configured source directory for JSP files which need processing.
     *
     * @return An array of relative to the source directory paths to JSP files or <code>null</code>
     * if the source directory does not exist.
     * @throws MojoExecutionException if an unexpected problem occurs.
     *                                Throwing this exception causes a  "BUILD ERROR" message to be displayed.
     * @throws MojoFailureException   if an expected problem (such as a compilation failure) occurs.
     *                                Throwing this exception causes a "BUILD FAILURE" message to be displayed.
     */
    protected String[] scanForJspFiles() throws MojoExecutionException, MojoFailureException {
        if (getSourceDirectory() == null) {
            throw new MojoFailureException("The plugin configuration requires non-empty 'sourceDirectory' element");
        }

        if (!getSourceDirectory().isDirectory()) {
            return null;
        }

        try {
            getLog().info("Scanning for JSP files: " + getSourceDirectory());

            DirectoryScannerAdapter scanner = new DirectoryScannerAdapter();
            scanner.setSourceDirectory(getSourceDirectory());
            scanner.setIncludes(getIncludes());
            scanner.setExcludes(getExcludes());

            String[] relativeJspFilePaths = scanner.scan();
            getLog().info("Found JSP files: " + relativeJspFilePaths.length);
            return relativeJspFilePaths;
        } catch (Exception e) {
            throw new MojoExecutionException("Failed to scan for JSP files: " + getSourceDirectory(), e);
        }
    }
}
