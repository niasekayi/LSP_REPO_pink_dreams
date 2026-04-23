package org.howard.edu.lsp.finalexam.question2;

/**
 * StudentReport implementation of the Report template.
 * 
 * Stores and formats student information including name and GPA.
 */
public class StudentReport extends Report {

    private String studentName;
    private double gpa;

    /**
     * Constructs a StudentReport with the given student name and GPA.
     * 
     * @param studentName the student's name
     * @param gpa the student's GPA
     */
    public StudentReport(String studentName, double gpa) {
        this.studentName = studentName;
        this.gpa = gpa;
    }

    @Override
    protected void loadData() {
        // Data is loaded in the constructor
        // This method confirms data is available
    }

    @Override
    protected String formatHeader() {
        return "=== HEADER ===\nStudent Report";
    }

    @Override
    protected String formatBody() {
        return "=== BODY ===\n"
                + "Student Name: " + studentName + "\n"
                + "GPA: " + gpa;
    }

    @Override
    protected String formatFooter() {
        return "=== FOOTER ===\nEnd of Student Report";
    }
}
