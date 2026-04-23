package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class for demonstrating the Template Method pattern with Report system.
 * 
 * This driver creates multiple report types, stores them in a polymorphic list,
 * and generates all reports using the template method workflow.
 */
public class ReportDriver {

    /**
     * Main method that creates and displays reports using polymorphism.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a polymorphic list of reports
        List<Report> reports = new ArrayList<>();

        // Add different report types to demonstrate polymorphism
        reports.add(new StudentReport("John Doe", 3.8));
        reports.add(new CourseReport("CSCI 363", 45));

        // Generate and display each report
        for (Report report : reports) {
            System.out.println(report.generateReport());
            System.out.println();
        }
    }
}
