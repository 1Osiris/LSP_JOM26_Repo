package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;

/**
 * Test class for IntegerSet implementation
 * Contains unit tests for all IntegerSet operations including basic set operations,
 * mathematical set operations, and edge cases
 */
public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     * Initializes two empty IntegerSet objects for testing
     */
    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    /**
     * Tests the add method of IntegerSet
     * Verifies that:
     * 1. Elements are added correctly
     * 2. Duplicate elements are not added
     */
    @Test
    @DisplayName("Test adding elements to set and handling duplicates")
    public void testAdd() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals("[1, 2, 3]", set1.toString());
        
        // Test adding duplicate
        set1.add(2);
        assertEquals("[1, 2, 3]", set1.toString());
    }

    /**
     * Tests the length method of IntegerSet
     * Verifies that:
     * 1. Empty set has length 0
     * 2. Length increases correctly when elements are added
     */
    @Test
    @DisplayName("Test length calculation of empty and non-empty sets")
    public void testLength() {
        assertEquals(0, set1.length());
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.length());
    }

    /**
     * Tests the remove method of IntegerSet
     * Verifies that:
     * 1. Elements are removed correctly
     * 2. Removing non-existent elements doesn't affect the set
     */
    @Test
    @DisplayName("Test removing existing and non-existing elements")
    public void testRemove() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.remove(2);
        assertEquals("[1, 3]", set1.toString());
        
        // Remove non-existent element
        set1.remove(4);
        assertEquals("[1, 3]", set1.toString());
    }

    /**
     * Tests the clear method of IntegerSet
     * Verifies that:
     * 1. All elements are removed
     * 2. Length becomes 0
     */
    @Test
    @DisplayName("Test clearing all elements from set")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
        assertEquals(0, set1.length());
    }

    /**
     * Tests the equals method of IntegerSet
     * Verifies that:
     * 1. Sets with same elements in different orders are equal
     * 2. Sets with different sizes are not equal
     * 3. Sets with same size but different elements are not equal
     */
    @Test
    @DisplayName("Test equality comparison between sets")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2)); // Order shouldn't matter
        
        set2.add(3);
        assertFalse(set1.equals(set2)); // Different sizes
        
        IntegerSet set3 = new IntegerSet();
        set3.add(1);
        set3.add(3);
        assertFalse(set1.equals(set3)); // Same size, different elements
    }

    /**
     * Tests the contains method of IntegerSet
     * Verifies correct identification of:
     * 1. Existing elements
     * 2. Non-existing elements
     */
    @Test
    @DisplayName("Test checking existence of elements in set")
    public void testContains() {
        set1.add(1);
        set1.add(2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertFalse(set1.contains(3));
    }

    /**
     * Tests the largest method with empty set
     * Expects IllegalStateException to be thrown
     * @throws IllegalStateException when set is empty
     */
    @Test(expected = IllegalStateException.class)
    @DisplayName("Test largest method throws exception for empty set")
    public void testLargestEmpty() {
        set1.largest();
    }

    /**
     * Tests the largest method of IntegerSet
     * Verifies correct identification of largest element
     */
    @Test
    @DisplayName("Test finding largest element in set")
    public void testLargest() {
        set1.add(1);
        set1.add(3);
        set1.add(2);
        assertEquals(3, set1.largest());
    }

    /**
     * Tests the smallest method with empty set
     * Expects IllegalStateException to be thrown
     * @throws IllegalStateException when set is empty
     */
    @Test(expected = IllegalStateException.class)
    @DisplayName("Test smallest method throws exception for empty set")
    public void testSmallestEmpty() {
        set1.smallest();
    }

    /**
     * Tests the smallest method of IntegerSet
     * Verifies correct identification of smallest element
     */
    @Test
    @DisplayName("Test finding smallest element in set")
    public void testSmallest() {
        set1.add(3);
        set1.add(1);
        set1.add(2);
        assertEquals(1, set1.smallest());
    }

    /**
     * Tests the union method of IntegerSet
     * Verifies that:
     * 1. All elements from both sets are included
     * 2. No duplicates are present in result
     */
    @Test
    @DisplayName("Test union operation between two sets")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertEquals("[1, 2, 3]", set1.toString());
    }

    /**
     * Tests the intersect method of IntegerSet
     * Verifies that:
     * 1. Only common elements are retained
     * 2. Elements present in only one set are removed
     */
    @Test
    @DisplayName("Test intersection operation between two sets")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set1.intersect(set2);
        assertEquals("[2, 3]", set1.toString());
    }

    /**
     * Tests the diff method of IntegerSet
     * Verifies that:
     * 1. Only elements unique to the first set are retained
     * 2. Common elements are removed
     */
    @Test
    @DisplayName("Test difference operation between two sets")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set1.diff(set2);
        assertEquals("[1]", set1.toString());
    }

    /**
     * Tests the complement method of IntegerSet
     * Verifies that:
     * 1. Only elements unique to the second set are retained
     * 2. Common elements are removed
     */
    @Test
    @DisplayName("Test complement operation between two sets")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set1.complement(set2);
        assertEquals("[3, 4]", set1.toString());
    }

    /**
     * Tests the isEmpty method of IntegerSet
     * Verifies correct identification of:
     * 1. Empty set
     * 2. Non-empty set
     * 3. Set that becomes empty after clearing
     */
    @Test
    @DisplayName("Test checking if set is empty")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty());
        set1.add(1);
        assertFalse(set1.isEmpty());
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    /**
     * Tests the toString method of IntegerSet
     * Verifies correct string representation for:
     * 1. Empty set
     * 2. Single element set
     * 3. Multiple element set
     */
    @Test
    @DisplayName("Test string representation of set")
    public void testToString() {
        assertEquals("[]", set1.toString());
        set1.add(1);
        assertEquals("[1]", set1.toString());
        set1.add(2);
        assertEquals("[1, 2]", set1.toString());
    }

    /**
     * Tests the ArrayList constructor of IntegerSet
     * Verifies that:
     * 1. Elements are properly initialized from ArrayList
     * 2. Duplicates are handled correctly during initialization
     */
    @Test
    @DisplayName("Test constructor with ArrayList parameter")
    public void testConstructorWithArrayList() {
        ArrayList<Integer> initial = new ArrayList<>();
        initial.add(1);
        initial.add(2);
        initial.add(2); // Duplicate
        IntegerSet set = new IntegerSet(initial);
        assertEquals("[1, 2]", set.toString());
    }
}
