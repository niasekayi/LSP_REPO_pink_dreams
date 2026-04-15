package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Test
    void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertEquals(2, set.length());
    }

    @Test
    void testEqualsSameElementsDifferentOrder() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    void testEqualsDifferentSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set2.add(2);
        assertFalse(set1.equals(set2));
    }

    @Test
    void testContainsPresent() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
    }

    @Test
    void testContainsAbsent() {
        IntegerSet set = new IntegerSet();
        assertFalse(set.contains(10));
    }

    @Test
    void testLargestNormal() throws Exception {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(3); set.add(2);
        assertEquals(3, set.largest());
    }

    @Test
    void testLargestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IntegerSetException.class, set::largest);
    }

    @Test
    void testSmallestNormal() throws Exception {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(3); set.add(2);
        assertEquals(1, set.smallest());
    }

    @Test
    void testSmallestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IntegerSetException.class, set::smallest);
    }

    @Test
    void testAddNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertTrue(set.contains(1));
    }

    @Test
    void testAddDuplicate() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(1);
        assertEquals(1, set.length());
    }

    @Test
    void testRemoveNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(1);
        assertFalse(set.contains(1));
    }

    @Test
    void testRemoveNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(2);
        assertEquals(1, set.length());
    }

    @Test
    void testUnionNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set2.add(2);
        IntegerSet result = set1.union(set2);
        assertTrue(result.contains(1) && result.contains(2));
    }

    @Test
    void testUnionWithEmpty() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet empty = new IntegerSet();
        set1.add(1);
        IntegerSet result = set1.union(empty);
        assertTrue(result.contains(1));
    }

    @Test
    void testIntersectNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(3);
        IntegerSet result = set1.intersect(set2);
        assertTrue(result.contains(2));
    }

    @Test
    void testIntersectNoCommon() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set2.add(2);
        IntegerSet result = set1.intersect(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    void testDiffNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1); set1.add(2);
        set2.add(2);
        IntegerSet result = set1.diff(set2);
        assertTrue(result.contains(1));
    }

    @Test
    void testDiffIdentical() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set2.add(1);
        IntegerSet result = set1.diff(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    void testComplementNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set2.add(1); set2.add(2);
        IntegerSet result = set1.complement(set2);
        assertTrue(result.contains(2));
    }

    @Test
    void testComplementDisjoint() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set2.add(2);
        IntegerSet result = set1.complement(set2);
        assertTrue(result.contains(2));
    }

    @Test
    void testIsEmptyTrue() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    void testToStringNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(1); set.add(2);
        assertEquals("[1, 2, 3]", set.toString());
    }

    @Test
    void testToStringEmpty() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
    }
}
