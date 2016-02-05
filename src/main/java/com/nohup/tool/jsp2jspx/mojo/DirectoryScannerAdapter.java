package com.nohup.tool.jsp2jspx.mojo;

import org.apache.maven.plugin.MojoFailureException;
import org.codehaus.plexus.util.DirectoryScanner;

import java.io.File;

/**
 * Scans source directories for files.
 *
 * @author Dmytro Koval
 */
public class DirectoryScannerAdapter {

    /**
     * The directory scanner used to scan the source directory for files.
     */
    private DirectoryScanner scanner;

    /**
     * Constructs a default <code>DirectoryScannerAdapter</code>.
     */
    public DirectoryScannerAdapter() {
        this.scanner = new DirectoryScanner();
        this.scanner.setFollowSymlinks(true);
    }

    /**
     * Constructs a new <code>DirectoryScannerAdapter</code>.
     *
     * @param sourceDirectory The base directory where the files will be searched.
     * @param includes A set of Ant-like inclusion patterns used to select files from the <code>sourceDirectory</code>
     * for processing, can be <code>null</code> if all files should be included.
     * @param excludes A set of Ant-like inclusion patterns used to exclude files from the source directory for processing,
     * can be <code>null</code> if no files should be excluded.
     */
    public DirectoryScannerAdapter(File sourceDirectory, String[] includes, String[] excludes) {
        this();
        setSourceDirectory(sourceDirectory);
        setIncludes(includes);
        setExcludes(excludes);
    }

    /**
     * Sets the absolute path to the source directory to scan for JSP files. This directory must exists or the scanner
     * will report an error.
     *
     * @param sourceDirectory The absolute path to the source directory to scan, must not be <code>null</code>.
     * @throws MojoFailureException
     */
    public void setSourceDirectory(File sourceDirectory) {
        if (sourceDirectory == null) {
            throw new IllegalArgumentException("Source directory must not be null");
        }

        if (!sourceDirectory.isDirectory()) {
            throw new IllegalArgumentException("Specified source directory " + sourceDirectory.getPath()
                    + " either doesn't exist or is not a directory");
        }

        if (!sourceDirectory.isAbsolute()) {
            throw new IllegalArgumentException("Source directory is not absolute: " + sourceDirectory);
        }
        this.scanner.setBasedir(sourceDirectory);
    }

    /**
     * Sets the Ant-like inclusion patterns.
     *
     * @param includes The set of Ant-like inclusion patterns, may be <code>null</code> to include all files.
     */
    public void setIncludes(String[] includes) {
        this.scanner.setIncludes(includes);
    }

    /**
     * Sets the Ant-like exclusion patterns.
     *
     * @param excludes The set of Ant-like exclusion patterns, may be <code>null</code> to exclude no files.
     */
    public void setExcludes(String[] excludes) {
        this.scanner.setExcludes(excludes);
        this.scanner.addDefaultExcludes();
    }

    /**
     * Scans the source directory for files and returns a set of path names.
     *
     * @return the names of the files which matched at least one of the include patterns and none of the exclude patterns.
     */
    public String[] scan() {
        this.scanner.scan();
        return this.scanner.getIncludedFiles();
    }
}
