package org.howard.edu.lsp.finalexam.question2;

/**
 * CourseReport implementation of the Report template.
 * 
 * Stores and formats course information including name and enrollment.
 */
public class CourseReport extends Report {

    private String courseName;
    private int enrollment;

    /**
     * Constructs a CourseReport with the given course name and enrollment.
     * 
     * @param courseName the name of the course
     * @param enrollment the number of students enrolled
     */
    public CourseReport(String courseName, int enrollment) {
        this.courseName = courseName;
        this.enrollment = enrollment;
    }

    @Override
    protected void loadData() {
        // Data is loaded in the constructor
        // This method confirms data is available
    }

    @Override
    protected String formatHeader() {
        return "=== HEADER ===\nCourse Report";
    }

    @Override
    protected String formatBody() {
        return "=== BODY ===\n"
                + "Course: " + courseName + "\n"
                + "Enrollment: " + enrollment;
    }

    @Override
    protected String formatFooter() {
        return "=== FOOTER ===\nEnd of Course Report";
    }
}
