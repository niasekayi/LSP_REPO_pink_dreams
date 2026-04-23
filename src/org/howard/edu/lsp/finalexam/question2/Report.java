package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract Report class implementing the Template Method pattern.
 * 
 * The template method generateReport() defines the fixed workflow:
 * loadData() -> formatHeader() -> formatBody() -> formatFooter()
 * 
 * Subclasses provide specific implementations for each step.
 */
public abstract class Report {

    /**
     * Template method that defines the fixed workflow for report generation.
     * This method enforces the order of operations and calls abstract methods
     * that subclasses must implement.
     * 
     * @return the formatted report as a String
     */
    public final String generateReport() {
        loadData();
        String header = formatHeader();
        String body = formatBody();
        String footer = formatFooter();
        return header + "\n\n" + body + "\n\n" + footer;
    }

    /**
     * Load data specific to this report type.
     * Subclasses must implement this to populate their data.
     */
    protected abstract void loadData();

    /**
     * Format the header section of the report.
     * 
     * @return the formatted header
     */
    protected abstract String formatHeader();

    /**
     * Format the body section of the report.
     * 
     * @return the formatted body
     */
    protected abstract String formatBody();

    /**
     * Format the footer section of the report.
     * 
     * @return the formatted footer
     */
    protected abstract String formatFooter();
}
