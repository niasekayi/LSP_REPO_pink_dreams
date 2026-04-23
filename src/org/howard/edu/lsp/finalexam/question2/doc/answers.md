# Question 2: Template Method Pattern

## Design Explanation

I implemented the Template Method pattern by creating an abstract `Report` class with a `generateReport()` method that's marked `final`. This method does the same thing every time: calls `loadData()`, then `formatHeader()`, then `formatBody()`, then `formatFooter()`, and puts them all together.

The cool part is that `StudentReport` and `CourseReport` are subclasses that inherit this method, so they automatically follow the same workflow. They each override the formatting methods to do their own thing - like StudentReport formats student info, CourseReport formats course info.

In the driver, I create a list that holds both types of reports and loop through them. They all call the same `generateReport()` method, but each one produces different output based on their own overridden methods. This is polymorphism - the driver doesn't even need to know what type of report it's dealing with.

## How the Output Works

When you call `report.generateReport()`, it follows the same steps every time:
1. Load the data (student name + GPA for StudentReport, course name + enrollment for CourseReport)
2. Format the header (says "Student Report" or "Course Report")
3. Format the body (shows the actual data)
4. Format the footer (wraps it up)

Then it combines all those pieces into one string. The template method controls the order, but each report type fills in the pieces differently. That's why we can put them all in one list and treat them the same way.

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
