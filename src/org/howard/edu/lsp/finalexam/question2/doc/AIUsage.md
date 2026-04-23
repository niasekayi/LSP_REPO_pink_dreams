# AI Usage Report - Question 2

## AI Tools Used
- GitHub Copilot (for code structure and javadoc generation)

## Prompts Used
1. "Create a Template Method pattern with an abstract Report class and two concrete implementations"
2. "Generate javadocs for the Report template method and its abstract methods"
3. "Write a driver that demonstrates polymorphism with List<Report>"

## How AI Helped
AI assisted in structuring the Template Method pattern correctly, ensuring the template method was declared `final` to prevent override, and generating proper javadocs. It also helped verify that the concrete classes properly override all abstract methods and that the polymorphic behavior works as expected.

## Reflection
Implementing the Template Method pattern reinforced how abstract classes define contracts for subclasses while controlling the overall algorithm flow. The pattern enables flexible, extensible designs where new report types can be added without modifying existing code or the driver.
