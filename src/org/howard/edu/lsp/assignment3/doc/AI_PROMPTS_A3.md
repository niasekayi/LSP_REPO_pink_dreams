# AI Prompts – Assignment 3

Below are selected prompts I used while redesigning my Assignment 2 ETL pipeline into a more object-oriented structure.

---

## Prompt 1

"How can I redesign my Java ETL pipeline from a procedural style to a more object-oriented design while keeping the same functionality?"

### Summary of Response:
The AI suggested separating responsibilities into different classes such as a data model class, a reader class, a transformer class, and a writer class. It emphasized separation of concerns and encapsulation.

I used this idea to create the following classes:
- Product
- CSVReader
- ProductTransformer
- CSVWriter
- ETLApplication

---

## Prompt 2

"What responsibilities should go into each class if I split my ETL pipeline into multiple Java classes?"

### Summary of Response:
The AI explained that:
- The model class should only store data.
- The reader should only handle file input.
- The transformer should apply business rules.
- The writer should handle file output.
- The main class should coordinate the process.

I adapted this structure but ensured that the transformation logic stayed consistent with Assignment 2 requirements.

---

## Prompt 3

"Can you help me improve the Javadocs for my classes and public methods?"

### Summary of Response:
The AI generated sample Javadoc comments. I reviewed and edited them to make sure they accurately described my implementation and matched the assignment requirements.

---

## Reflection on AI Usage

I used AI mainly as a brainstorming and structure assistant rather than asking it to rewrite my entire assignment. It helped me think through how to decompose the program into clearer responsibilities and apply object-oriented principles. I reviewed, tested, and adjusted the suggestions to ensure that the final implementation met the exact same behavior as Assignment 2.
