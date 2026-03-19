The OrderProcessor class has several object-oriented design issues. First, it violates encapsulation because all of its fields are public, allowing external classes to modify them directly. This reduces data protection and increases the risk of unintended changes.

Second, the class violates the Single Responsibility Principle because it performs multiple tasks such as calculating totals, printing receipts, saving to files, sending emails, applying discounts, and logging. Each of these responsibilities should be handled by separate classes.

Third, the class is difficult to extend. Any new feature, such as a different discount rule or storage method, would require modifying the existing class, which increases the risk of breaking existing functionality.

Finally, the class is tightly coupled to specific implementations like FileWriter and console output, making it hard to test and reuse in other contexts.