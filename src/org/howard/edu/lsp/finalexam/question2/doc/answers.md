# Question 2: Template Method Pattern

## Design Explanation

I implemented the Template Method pattern by creating an abstract `Report` class with a `generateReport()` method marked `final`. This method follows the same sequence every time: `loadData()`, `formatHeader()`, `formatBody()`, `formatFooter()`, and combines them together.

`StudentReport` and `CourseReport` are subclasses that inherit this method and automatically follow the same workflow. They each override the formatting methods to handle their specific report type - StudentReport formats student information while CourseReport formats course information.

In the driver, I create a list that holds both report types and loop through them. They all call the same `generateReport()` method but produce different output based on their overridden methods. This demonstrates polymorphism - the driver doesn't need to know what type of report it's dealing with.

## How the Output Works

When `report.generateReport()` is called, it follows the same workflow every time:
1. Load the data (student name + GPA for StudentReport, course name + enrollment for CourseReport)
2. Format the header (displays "Student Report" or "Course Report")
3. Format the body (displays the actual data)
4. Format the footer (wraps up the report)

The template method controls the sequence while each report type provides its own implementation. This allows all reports to be processed uniformly through a single list, regardless of their specific type.

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
