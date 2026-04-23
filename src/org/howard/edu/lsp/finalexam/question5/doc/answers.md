# Question 5: Arthur Riel's Object-Oriented Design Heuristics

## Heuristic 1

**Name:**
Encapsulation - Hide what's happening inside your class and only show people the important stuff on the outside.

**Explanation:**
This improves maintainability and readability because it gives classes control over how their data is accessed. In class, we discussed how if you make all your fields public, people depend directly on them. Then if you want to change the internal implementation, you have to update all their code too. But with private fields and public methods, you can change the internals without breaking anything. For example, in Question 1, we decided `getNextId()` shouldn't be public because that's an internal detail - external code shouldn't need to care about it. Only exposing what's necessary ensures people use your class correctly.

---

## Heuristic 2

**Name:**
Single Responsibility Principle - Each class should have one job and one reason to change.

**Explanation:**
This makes debugging and maintenance easier because each class has a clear, focused purpose. If something breaks, you know exactly where to look. We learned that a class shouldn't handle requests AND format output AND manage network communication all at once - that's too much responsibility. If each class has one job, then when requirements change, only the relevant class needs modification. We saw this with the Template Method pattern in Question 2 - each Report subclass has one responsibility: format its specific report type. The base Report class only manages the workflow structure. If StudentReport needs to change how it displays GPA, I only modify that one class.

---

## Heuristic 3

**Name:**
Law of Demeter / Principle of Least Knowledge - Don't make a class dig through a bunch of other objects to get what it needs.

**Explanation:**
This reduces coupling and makes code more maintainable. In lecture, you showed us how chains like `student.getCourses().get(0).getInstructor().getOffice().getBuilding()` are problematic because your code now depends on the entire structure. If the instructor's office changes, your code breaks. Instead, you should ask directly for what you need. In our exam code, the ReportDriver doesn't ask a Report for individual components and reassemble them - it just calls `generateReport()` and lets the Report handle coordination internally. When you follow this principle, code remains flexible and changes in one object don't cascade through your entire system.
