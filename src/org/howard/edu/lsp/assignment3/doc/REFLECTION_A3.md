# Assignment 3 Reflection

## Overview

In Assignment 2, I built an ETL pipeline using a mostly procedural design. All of the logic for reading the file, transforming the data, and writing the output was handled inside one main class. While the program worked correctly, the responsibilities were not clearly separated.

In Assignment 3, I redesigned the program using a more object-oriented approach. Instead of keeping everything in one place, I divided the responsibilities across multiple classes. The goal was not to change functionality, but to improve the design and structure of the program.

---

## Key Design Differences

### Assignment 2 (Procedural Style)
- One main class handled reading, transforming, and writing.
- Data was processed mostly using string arrays.
- Limited separation of concerns.
- Harder to extend or modify without editing the main logic.

### Assignment 3 (Object-Oriented Style)
- Created separate classes:
  - `Product` (represents a product object)
  - `CSVReader` (handles reading input file)
  - `ProductTransformer` (applies transformation rules)
  - `CSVWriter` (handles writing output file)
  - `ETLApplication` (coordinates the entire process)
- Responsibilities are clearly divided.
- Each class has a single, focused purpose.
- The code is more modular and easier to maintain.

---

## How Assignment 3 is More Object-Oriented

### 1. Objects and Classes
In Assignment 3, I introduced a `Product` class to represent each row of data as an object instead of a string array. This better models real-world data and makes the program easier to understand.

### 2. Encapsulation
The fields in the `Product` class are private, and access is controlled through getters and setters. This protects the internal state of the object and follows proper encapsulation principles.

### 3. Separation of Concerns
Each class now has a clear responsibility:
- `CSVReader` only reads data.
- `ProductTransformer` only modifies data.
- `CSVWriter` only writes data.
- `ETLApplication` coordinates everything.

This makes the design cleaner and more maintainable.

### 4. Polymorphism and Extensibility
Although inheritance was not heavily used in this assignment, the structure now makes it easier to extend the system. For example, additional transformers or different file readers could be added without rewriting the main application logic.

---

## Testing and Verification

To confirm that Assignment 3 works the same as Assignment 2, I:

1. Used the same `products.csv` input file.
2. Ran both implementations.
3. Compared the output file `transformed_products.csv`.
4. Verified:
   - Negative prices were corrected.
   - Product names were properly capitalized.
   - Price ranges were assigned correctly.
   - Invalid rows were skipped.
   - The output file format remained identical.

The results matched Assignment 2 exactly, confirming that the redesign preserved functionality while improving structure.

---

## Conclusion

Assignment 3 improved the overall design of the ETL pipeline by applying object-oriented principles. While Assignment 2 focused on making the program work, Assignment 3 focused on making the program well-structured, modular, and easier to maintain.

This redesign helped me better understand object-oriented decomposition and how to separate responsibilities across classes in a clean and organized way.
