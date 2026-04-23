# Question 1: Concurrency Analysis

## Part 1: Shared Resources and Risk

**Shared Resource #1:**
`nextId` - The integer counter variable that tracks the next ID to be assigned.

**Shared Resource #2:**
`requests` - The ArrayList that stores all submitted requests.

**Concurrency Problem:**
A race condition occurs on `nextId`. When multiple threads call `getNextId()` concurrently, the following sequence can happen:
1. Thread A reads `nextId` (value = 1)
2. Thread B reads `nextId` (value = 1) - before Thread A increments it
3. Thread A increments `nextId` to 2 and returns 1
4. Thread B increments `nextId` to 2 and returns 1 - **duplicate ID!**

Additionally, `requests` is not thread-safe. Multiple threads calling `addRequest()` simultaneously can corrupt the ArrayList's internal state.

**Why addRequest() is unsafe:**
1. It calls `getNextId()`, which has the race condition described above (duplicate IDs possible)
2. The operation is not atomic: between getting an ID and adding the request to the list, another thread could interrupt
3. ArrayList is not thread-safe; concurrent calls to `add()` can corrupt the internal list structure
4. Even if `addRequest()` were synchronized, calls to `getNextId()` from outside `addRequest()` would still create duplicates

---

## Part 2: Evaluate Fixes

**Fix A: `public synchronized int getNextId() { ... }`**

**CORRECT**

This fix works because:
- The `synchronized` keyword ensures mutual exclusion on `getNextId()`
- Only one thread can execute this method at a time
- Each thread atomically reads `nextId`, increments it, and returns the value
- No two threads can read the same `nextId` value
- This eliminates the race condition on ID generation
- Every request receives a unique ID

**Fix B: `public synchronized void addRequest(String studentName) { ... }`**

**INCORRECT**

This fix does NOT solve the concurrency problem because:
- While it protects the `requests.add()` call, it does NOT protect `getNextId()`
- Threads can still call `getNextId()` from outside `addRequest()` and get duplicate IDs
- Even if `addRequest()` is the only caller, two threads can enter `addRequest()` sequentially. The first gets synchronized access, calls `getNextId()` (not protected), then exits. The second then calls `getNextId()` - both can receive the same ID if they interleave at the wrong moment
- The fundamental problem (race condition on `nextId`) remains unsolved

**Fix C: `public synchronized List<String> getRequests() { ... }`**

**INCORRECT**

This fix does NOT solve the concurrency problem because:
- It only protects reading the requests list, not writing to it
- It does nothing to prevent duplicate IDs from `getNextId()`
- Concurrent calls to `addRequest()` can still corrupt the ArrayList
- The race condition on `nextId` is completely unaddressed

---

## Part 3: Object-Oriented Design (Riel's Heuristics)

**Should getNextId() be public?**

**No, it should not be public.**

**Explanation:**
According to Arthur Riel's object-oriented heuristics on encapsulation and responsibility, `getNextId()` should not be part of the public interface. Here's why:
- ID generation is an **implementation detail** of the request management system, not a concern of external clients
- Exposing `getNextId()` violates **encapsulation** - it exposes internal state management
- External code should not directly obtain IDs; ID assignment should be managed internally through `addRequest()`
- This heuristic recommends hiding implementation details and providing only high-level, meaningful operations
- If clients can call `getNextId()` directly, they might use IDs for purposes other than requests, leading to inconsistency
- Making it private or package-private enforces that IDs are only generated within the controlled context of `addRequest()`

---

## Part 4: Alternative Synchronization Approach

**Description:**

The alternative approach discussed in lecture is using **java.util.concurrent.atomic classes** (specifically `AtomicInteger`) instead of the `synchronized` keyword. This provides thread-safe operations without explicit synchronization.

Another approach is using a **single-threaded ExecutorService** to serialize all request submissions, ensuring that all `addRequest()` operations execute sequentially without explicit synchronization.

The `AtomicInteger` approach is simpler and more direct: it provides atomic operations like `getAndIncrement()` that are implemented using low-level compare-and-swap operations, guaranteeing thread safety without locking.

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

This approach:
- Uses `AtomicInteger.getAndIncrement()` for thread-safe ID generation without explicit `synchronized`
- Still protects the compound operation of ID assignment + list addition with `synchronized` on `addRequest()`
- Returns a copy of the requests list to prevent external modification
