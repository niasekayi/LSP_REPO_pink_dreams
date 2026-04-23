# AI Usage Report - Question 1

## AI Tools Used
- GitHub Copilot (for reviewing code analysis and formatting)

## Prompts Used (2–5 max)
1. "Analyze the race condition on nextId in this RequestManager code"
2. "Evaluate each synchronization fix for thread safety"
3. "Apply Riel's heuristics for evaluating getNextId() as a public method"

## How AI Helped
AI assisted in organizing the technical analysis and ensuring all concurrency concepts were clearly explained. It helped verify the correctness of the race condition explanation and provided confirmation on how each fix addresses (or fails to address) the concurrency problem. AI also helped structure the explanation of Riel's heuristics in relation to encapsulation.

## Reflection
This exercise reinforced the critical importance of understanding race conditions at a detailed level, not just recognizing them conceptually. The analysis showed that synchronization placement matters significantly—protecting only part of an unsafe operation leaves vulnerabilities.
