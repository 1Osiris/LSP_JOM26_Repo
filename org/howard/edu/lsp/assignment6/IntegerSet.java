package org.howard.edu.lsp.assignment6;
import java.util.*;

public class IntegerSet {
    // Store the set elements in an ArrayList
    private List<Integer> set = new ArrayList<Integer>();

    // Default Constructor
    public IntegerSet() {
    }

    // Constructor if you want to pass in already initialized
    public IntegerSet(ArrayList<Integer> set) {
        // Remove duplicates while constructing
        for (Integer item : set) {
            add(item);
        }
    }

    // Clears the internal representation of the set
    public void clear() {
        set.clear();
    }

    // Returns the length of the set
    public int length() {
        return set.size();
    }

    // Check if two sets are equal (contain same elements in any order)
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

    // Returns true if the set contains the value
    public boolean contains(int value) {
        return set.contains(value);
    }

    // Returns the largest item in the set
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find largest element of empty set");
        }
        return Collections.max(set);
    }

    // Returns the smallest item in the set
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find smallest element of empty set");
        }
        return Collections.min(set);
    }

    // Adds an item to the set if it's not already present
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    // Removes an item from the set if present
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    // Set union
    public void union(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            add(item);
        }
    }

    // Set intersection
    public void intersect(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer item : set) {
            if (intSetb.contains(item)) {
                result.add(item);
            }
        }
        set = result;
    }

    // Set difference (this - intSetb)
    public void diff(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer item : set) {
            if (!intSetb.contains(item)) {
                result.add(item);
            }
        }
        set = result;
    }

    // Set complement (intSetb - this)
    public void complement(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer item : intSetb.set) {
            if (!this.contains(item)) {
                result.add(item);
            }
        }
        set = result;
    }

    // Returns true if the set is empty
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // Return String representation of the set
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
