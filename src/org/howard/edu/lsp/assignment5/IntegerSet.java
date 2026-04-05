package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a mathematical set of integers.
 * A set cannot contain duplicate values and supports standard set operations.
 * All set operations (union, intersect, diff, complement) return a new IntegerSet
 * and do not modify the original sets.
 *
 * <p>Usage example:
 * <pre>
 *   IntegerSet set = new IntegerSet();
 *   set.add(1);
 *   set.add(2);
 * </pre>
 * </p>
 *
 * @author Nia Greene
 * @version 1.0
 */
public class IntegerSet {

    /** Internal storage for set elements. */
    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Default constructor. Creates an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Constructor that initializes the set from an existing ArrayList.
     *
     * @param set the ArrayList of integers to initialize from
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(set);
    }

    /**
     * Removes all elements from the set, leaving it empty.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if this set and the given set contain exactly the same elements,
     * regardless of order.
     *
     * @param b the IntegerSet to compare against
     * @return true if both sets contain the same elements, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) {
            return false;
        }
        ArrayList<Integer> copyA = new ArrayList<>(this.set);
        ArrayList<Integer> copyB = new ArrayList<>(b.set);
        Collections.sort(copyA);
        Collections.sort(copyB);
        return copyA.equals(copyB);
    }

    /**
     * Returns true if the set contains the specified integer value.
     *
     * @param value the integer to search for
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     *
     * @return the largest integer in the set
     * @throws IntegerSetException if the set is empty
     */
    public int largest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     *
     * @return the smallest integer in the set
     * @throws IntegerSetException if the set is empty
     */
    public int smallest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an integer to the set. If the value already exists, it is not added again.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an integer from the set. If the value does not exist, nothing happens.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new IntegerSet containing all elements that appear in either this set
     * or the given set (mathematical union).
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the union
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet(this.set);
        for (int item : intSetb.set) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing only the elements common to both this set
     * and the given set (mathematical intersection).
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the intersection
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int item : this.set) {
            if (intSetb.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in this set but not in the given set
     * (set difference: this - b).
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the difference
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int item : this.set) {
            if (!intSetb.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in the given set but not in this set
     * (complement: b - this).
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the complement
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int item : intSetb.set) {
            if (!this.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Returns true if the set contains no elements.
     *
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set. Elements are sorted in ascending order,
     * separated by a comma and a single space, and enclosed in square brackets.
     * An empty set is represented as [].
     *
     * @return string representation of the set, e.g. "[1, 2, 3]"
     */
    @Override
    public String toString() {
        if (set.isEmpty()) {
            return "[]";
        }
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < sorted.size(); i++) {
            sb.append(sorted.get(i));
            if (i < sorted.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
