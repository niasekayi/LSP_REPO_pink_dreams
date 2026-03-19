AI Tool: ChatGPT  

Prompt: Evaluate the object-oriented design of a Java class called OrderProcessor and identify design issues. Also propose a better design using CRC cards.

Response: ChatGPT helped me identify key object-oriented design issues in the provided class, including poor encapsulation due to public fields, violation of the Single Responsibility Principle, and tight coupling between unrelated responsibilities such as file handling, email sending, and logging. It also helped me understand why having multiple responsibilities in one class makes the system harder to maintain and extend.

Additionally, ChatGPT guided me in restructuring the system using CRC cards by suggesting separate classes for responsibilities like order data management, receipt printing, file storage, email communication, discount handling, and logging. This helped me better understand how to distribute responsibilities across classes and improve modularity and scalability in the design.

No other external resources were used.