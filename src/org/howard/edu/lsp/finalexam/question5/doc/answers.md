# Question 5: Arthur Riel's Object-Oriented Design Heuristics

## Heuristic 1

**Name:**
Encapsulation - Hide internal implementation details and expose only a well-defined public interface.

**Explanation:**
This heuristic improves maintainability and readability by allowing classes to control how their data is accessed and modified. In lecture, we discussed how exposing internal state directly (e.g., public fields) creates dependencies on implementation details. By using private fields and public methods, we can change the internal implementation without affecting client code. For example, in the Question 1 RequestManager analysis, we identified that `getNextId()` should not be public because ID generation is an implementation detail. When only the necessary operations are exposed through public methods, the class contract becomes clear to users, and the code is less prone to misuse. This also prevents external classes from assuming they understand or can manipulate the internal state, which would break encapsulation.

---

## Heuristic 2

**Name:**
Classes should have a single responsibility or reason to change.

**Explanation:**
Single responsibility improves maintainability because changes to one concern don't require modifications to unrelated code. In lecture, we discussed how a class like RequestManager should be responsible only for managing requests and IDs, not for formatting output or handling network communication. This heuristic was illustrated when we designed the Template Method pattern in Question 2: each Report subclass has a single responsibility - formatting its specific report type. The abstract Report class manages only the workflow structure. When classes are focused on one responsibility, they are easier to test, understand, and modify. A class with multiple responsibilities becomes fragile: changes to one responsibility can accidentally break another.

---

## Heuristic 3

**Name:**
The Law of Demeter (Principle of Least Knowledge) - Objects should only communicate with their direct neighbors, avoiding long chains of method calls.

**Explanation:**
This heuristic improves readability and maintainability by reducing coupling between classes. In lecture, we learned that code like `student.getCourses().get(0).getInstructor().getOffice().getBuilding()` violates this principle - the client must know the entire chain of objects to access information. Following this heuristic means asking for what you need directly (e.g., asking the student for their primary course instructor's building directly) rather than navigating through intermediate objects. This was illustrated in our exam code: the ReportDriver doesn't ask Report for individual components and reassemble them; it calls `generateReport()` and lets the Report handle internal coordination. When classes follow this principle, they are less fragile to changes in intermediate classes, and the code reads more naturally as a series of clear interactions rather than long navigation chains.
