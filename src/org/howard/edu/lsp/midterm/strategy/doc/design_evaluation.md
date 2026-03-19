The current implementation relies on multiple if statements, which makes the system difficult to maintain and extend. Adding new customer types would require modifying the existing method, violating the Open/Closed Principle.

The design also reduces readability because all pricing logic is combined in one place. This makes it harder to isolate and test individual behaviors.

Using the Strategy Pattern improves the design by separating each pricing rule into its own class. This allows new strategies to be added without modifying existing code, making the system more flexible and maintainable.