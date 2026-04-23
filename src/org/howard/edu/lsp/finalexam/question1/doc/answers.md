# Question 1: Concurrency Analysis

## Part 1: Shared Resources and Risk

**Shared Resource #1:**
`nextId` - The integer counter variable that tracks the next ID to be assigned.

**Shared Resource #2:**
`requests` - The ArrayList that stores all submitted requests.

**Concurrency Problem:**
There's a race condition on `nextId`. When two threads try to call `getNextId()` at the same time, they can both read the value 1 before either one increments it. So Thread A reads 1, Thread B reads 1, then they both increment and return 1 - resulting in duplicate IDs.

Also, the `requests` ArrayList isn't thread-safe. If multiple threads try to add requests simultaneously, it can corrupt the ArrayList's internal data structure.

**Why addRequest() is unsafe:**
1. It calls `getNextId()`, which isn't protected - duplicate IDs are possible
2. The ID generation and list addition aren't atomic - a thread could interrupt between them
3. ArrayList itself isn't thread-safe, so concurrent `add()` calls can corrupt the structure
4. Even if we synchronized just `addRequest()`, someone could call `getNextId()` directly from outside and still get duplicates

---

## Part 2: Evaluate Fixes

**Fix A: `public synchronized int getNextId() { ... }`**

**CORRECT**

This fix works. By synchronizing `getNextId()`, only one thread can run this method at a time. So Thread A gets in, reads 1, increments it to 2, and exits before Thread B can even look at `nextId`. This means every thread gets a unique ID - no more duplicates.

**Fix B: `public synchronized void addRequest(String studentName) { ... }`**

**INCORRECT**

This doesn't work because it doesn't protect `getNextId()` at all. Even though `addRequest()` is synchronized, the call to `getNextId()` inside it still isn't protected. Plus, nothing stops someone from calling `getNextId()` directly from outside, which would still give duplicate IDs. The real problem (the race condition on `nextId`) never gets fixed.

**Fix C: `public synchronized List<String> getRequests() { ... }`**

**INCORRECT**

This only protects reading the list, not adding to it. It doesn't do anything about the duplicate ID problem with `getNextId()`, and multiple threads still can't safely call `addRequest()`. This leaves the main issues completely unsolved.

---

## Part 3: Object-Oriented Design (Riel's Heuristics)

**Should getNextId() be public?**

**No, it should not be public.**

**Explanation:**
`getNextId()` shouldn't be public according to Riel's heuristics on encapsulation. ID generation is just an implementation detail - clients shouldn't need to care about it. If people can call `getNextId()` directly, they might use those IDs for other purposes, making the system inconsistent. By keeping it private, we ensure IDs are only generated through `addRequest()`, maintaining the integrity of the system.

---

## Part 4: Alternative Synchronization Approach

**Description:**

Instead of using `synchronized`, we learned in lecture that we can use **AtomicInteger** from `java.util.concurrent.atomic`. It gives us thread-safe operations without having to manually lock threads. The `getAndIncrement()` method is atomic, so it handles the read-increment-return all in one go that can't be interrupted. This is simpler than writing `synchronized` everywhere.

**Code Snippet:**

```java
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;

public class RequestManager {
    private AtomicInteger nextId = new AtomicInteger(1);
    private List<String> requests = new ArrayList<>();

    public int getNextId() {
        return nextId.getAndIncrement();
    }

    public synchronized void addRequest(String studentName) {
        int id = getNextId();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    }

    public List<String> getRequests() {
        return new ArrayList<>(requests);
    }
}
```

With this approach:
- `AtomicInteger.getAndIncrement()` provides thread-safe ID generation without needing `synchronized`
- `synchronized` on `addRequest()` ensures ID assignment and list addition happen together
- Returning a copy of the list prevents external code from modifying the internal data
