# Question 5: Arthur Riel's Object-Oriented Design Heuristics

## Heuristic 1

**Name:**
Encapsulation - Hide what's happening inside your class and only show people the important stuff on the outside.

**Explanation:**
This makes code easier to maintain and read because you control how people use your class. In class, we talked about how if you just make all your fields public, people get used to accessing them directly. Then if you want to change how things work inside, you have to update all their code too. But if you hide everything with private fields and give them public methods to use, you can change the inside without breaking anything. For example, in Question 1, we decided `getNextId()` shouldn't be public because that's how the RequestManager works internally - it's not something external code should worry about. When you only expose what's necessary, people use your class the right way.

---

## Heuristic 2

**Name:**
Single Responsibility Principle - Each class should have one job and one reason to change.

**Explanation:**
This makes code easier to test and change because if something breaks, you know exactly where to look. We learned that a class like RequestManager shouldn't handle requests AND format output AND manage network stuff - that's too much. If it has one job, like just managing requests, then when the requirements change for how to manage requests, only that class needs to change. We saw this in Question 2 with Template Method - each Report subclass has one job: format its specific type of report. The base Report class just manages the workflow. If a StudentReport needs to change how it displays GPA, I only touch StudentReport. Clean and simple.

---

## Heuristic 3

**Name:**
Law of Demeter / Principle of Least Knowledge - Don't make a class dig through a bunch of other objects to get what it needs.

**Explanation:**
This helps keep coupling low and makes code easier to understand. In lecture, you showed us how code like `student.getCourses().get(0).getInstructor().getOffice().getBuilding()` is really bad because now my code depends on knowing the entire structure - if the instructor office changes, my code breaks. Instead, you should ask the student directly for what you need. We did this in our exam code - the ReportDriver doesn't ask a Report for its individual pieces and then assemble them. It just calls `generateReport()` and the Report handles everything inside. The driver's nice and simple, and if a Report changes how it formats things, the driver doesn't care. Less coupling, cleaner code.
