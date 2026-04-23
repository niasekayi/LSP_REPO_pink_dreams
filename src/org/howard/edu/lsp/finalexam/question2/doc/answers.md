# Question 2: Template Method Pattern

## Design Explanation

The Template Method pattern is implemented in the `Report` abstract class, which defines the fixed workflow in the `generateReport()` method (lines 16-20). This template method orchestrates the sequence: `loadData()` → `formatHeader()` → `formatBody()` → `formatFooter()`. 

The template method is declared `final` to prevent subclasses from overriding it, ensuring the workflow order is preserved. Each step is delegated to abstract methods that subclasses like `StudentReport` and `CourseReport` implement with their specific logic (lines 7-16 in StudentReport.java and CourseReport.java). The polymorphic driver (ReportDriver.java, lines 17-23) stores different report types in a single `List<Report>` and iterates through them, demonstrating how the template method enables consistent processing of diverse report types without the driver knowing their concrete implementations.

## How the Output Works

When `report.generateReport()` is called on any Report object (student or course), the same template sequence executes:
1. Each report's specific `loadData()` prepares its data
2. Each report's `formatHeader()` returns its type-specific header
3. Each report's `formatBody()` formats its unique content
4. Each report's `formatFooter()` generates its closing

The template method combines these formatted sections into the final report string, producing the expected output without requiring separate logic in the driver.

---

## Compilation and Execution

To compile and run:
```bash
javac src/org/howard/edu/lsp/finalexam/question2/*.java
java -cp src org.howard.edu.lsp.finalexam.question2.ReportDriver
```

Expected output:
```
=== HEADER ===
Student Report

=== BODY ===
Student Name: John Doe
GPA: 3.8

=== FOOTER ===
End of Student Report

=== HEADER ===
Course Report

=== BODY ===
Course: CSCI 363
Enrollment: 45

=== FOOTER ===
End of Course Report
```
