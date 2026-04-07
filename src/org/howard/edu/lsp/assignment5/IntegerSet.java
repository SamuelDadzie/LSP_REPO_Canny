package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a set of integers with no duplicates.
 * @author Samuel Dadzie
 */
public class IntegerSet {

    private ArrayList<Integer> set;

    /**
     * Constructor initializes the set.
     */
    public IntegerSet() {
        set = new ArrayList<>();
    }

    /**
     * Clears the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns length of set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if set is empty.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Adds an item to the set (no duplicates allowed).
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Checks if value exists in set.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns largest value.
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns smallest value.
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Checks equality of two sets.
     */
    public boolean equals(IntegerSet b) {
        if (b == null) return false;
        ArrayList<Integer> temp1 = new ArrayList<>(set);
        ArrayList<Integer> temp2 = new ArrayList<>(b.set);
        Collections.sort(temp1);
        Collections.sort(temp2);
        return temp1.equals(temp2);
    }

    /**
     * Union of two sets.
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);

        for (int item : intSetb.set) {
            if (!result.set.contains(item)) {
                result.set.add(item);
            }
        }
        return result;
    }

    /**
     * Intersection of two sets.
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (intSetb.set.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Difference (this - b).
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (!intSetb.set.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Complement (b - this).
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : intSetb.set) {
            if (!this.set.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Returns string representation in ascending order.
     */
    @Override
    public String toString() {
        ArrayList<Integer> temp = new ArrayList<>(set);
        Collections.sort(temp);
        return temp.toString();
    }
}