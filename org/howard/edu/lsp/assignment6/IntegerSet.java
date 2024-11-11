package org.howard.edu.lsp.assignment6;
import java.util.*;

/**
 * IntegerSet class implements a set of integers with basic set operations.
 * This implementation prevents duplicate elements and maintains an unordered collection.
 */
public class IntegerSet {
    /** Store the set elements in an ArrayList */
    private List<Integer> set = new ArrayList<Integer>();
    
    /**
     * Default Constructor creates an empty set
     */
    public IntegerSet() {
    }
    
    /**
     * Constructor that initializes the set with given ArrayList of integers
     * Removes any duplicates while constructing
     * @param set ArrayList of integers to initialize the set
     */
    public IntegerSet(ArrayList<Integer> set) {
        // Remove duplicates while constructing
        for (Integer item : set) {
            add(item);
        }
    }
    
    /**
     * Clears all elements from the set
     */
    public void clear() {
        set.clear();
    }
    
    /**
     * Returns the number of elements in the set
     * @return integer representing the number of elements in the set
     */
    public int length() {
        return set.size();
    }
    
    /**
     * Determines if two sets are equal (contain the same elements regardless of order)
     * @param o Object to compare with
     * @return true if sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        
        IntegerSet other = (IntegerSet) o;
        if (this.length() != other.length()) return false;
        
        // Check if all elements in this set are in the other set
        for (Integer item : this.set) {
            if (!other.contains(item)) return false;
        }
        return true;
    }
    
    /**
     * Checks if a value exists in the set
     * @param value integer to check for
     * @return true if value is in set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }
    
    /**
     * Finds the largest element in the set
     * @return largest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find largest element of empty set");
        }
        return Collections.max(set);
    }
    
    /**
     * Finds the smallest element in the set
     * @return smallest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find smallest element of empty set");
        }
        return Collections.min(set);
    }
    
    /**
     * Adds an integer to the set if it's not already present
     * @param item integer to be added to the set
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }
    
    /**
     * Removes an integer from the set if present
     * @param item integer to be removed from the set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }
    
    /**
     * Performs union operation with another set
     * Adds all elements from intSetb to this set
     * @param intSetb set to perform union with
     */
    public void union(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            add(item);
        }
    }
    
    /**
     * Performs intersection operation with another set
     * Keeps only elements that exist in both sets
     * @param intSetb set to perform intersection with
     */
    public void intersect(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer item : set) {
            if (intSetb.contains(item)) {
                result.add(item);
            }
        }
        set = result;
    }
    
    /**
     * Performs difference operation (this - intSetb)
     * Keeps only elements that exist in this set but not in intSetb
     * @param intSetb set to perform difference with
     */
    public void diff(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer item : set) {
            if (!intSetb.contains(item)) {
                result.add(item);
            }
        }
        set = result;
    }
    
    /**
     * Performs complement operation (intSetb - this)
     * Keeps only elements that exist in intSetb but not in this set
     * @param intSetb set to perform complement with
     */
    public void complement(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer item : intSetb.set) {
            if (!this.contains(item)) {
                result.add(item);
            }
        }
        set = result;
    }
    
    /**
     * Checks if the set is empty
     * @return true if set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }
    
    /**
     * Returns string representation of the set
     * @return string representation of set in format [n1, n2, ...]
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < set.size(); i++) {
            sb.append(set.get(i));
            if (i < set.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
