 # AI Usage Report – Assignment 5: IntegerSet Implementation

## AI Conversations Used

### Claude (claude-sonnet-4-6) via Claude Code CLI
- **Prompt:** Asked Claude to implement IntegerSet.java, IntegerSetException.java, and Driver.java for CSCI 363/540 Assignment 5 based on the provided assignment specification.
- **What was generated:** Full implementation of `IntegerSet.java` with all required methods (clear, length, equals, contains, largest, smallest, add, remove, union, intersect, diff, complement, isEmpty, toString), `IntegerSetException.java` as a custom RuntimeException, and `Driver.java` copied verbatim from the assignment spec.
- **How it was used:** The generated code was placed directly into the required package structure. The logic was reviewed to confirm correctness of set operations, Javadoc completeness, and that toString() returns elements in ascending order as required.

## External Websites / References Used

- Java Collections Framework documentation (ArrayList, Collections.sort, Collections.max, Collections.min): https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html

## Notes

All set operations (union, intersect, diff, complement) were implemented to return new IntegerSet objects without modifying the originals, as required by the specification.
