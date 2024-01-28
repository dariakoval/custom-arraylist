package org.example;

import java.util.Arrays;

/**
 * Array-based resizable list.
 *
 * @param <T> the Type of elements in this list
 * @author Daria Koval
 *
 */
public class CustomArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double STANDARD_LOAD_FACTOR = 0.75;
    private static final int MULTIPLIER = 2;
    private Object[] data;
    private int size;

    /**
     * Constructs an empty list with an initial capacity of DEFAULT_CAPACITY.
     */
    public CustomArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence (from first to last element).
     *
     * @return an array containing the elements of the list
     */
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    /**
     * Returns a string representation of this list.
     * The string representation consists of a list of the collection's elements in the order they are
     * returned by its iterator, enclosed in square brackets ("[]").
     * Adjacent elements are separated by the characters ", " (comma and space).
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        return Arrays.toString((Arrays.copyOf(data, size)));
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element - element to be appended to this list
     * @return true if this list changed as a result of the call
     */
    public boolean add(T element) {
        increaseCapacityIfNeed();
        data[size++] = element;
        return true;
    }

    /**
     * Appends all the elements in the specified collection to the end of this list, in the order that they are
     * returned by the specified collection's Iterator.
     *
     * @param list - list containing elements to be added to this list
     * @return true if this list changed as a result of the call
     */
    public boolean addAll(CustomArrayList<T> list) {
        var sourceArray = list.toArray();
        size += sourceArray.length;
        increaseCapacityIfNeed();
        System.arraycopy(sourceArray, 0, data, size - sourceArray.length, list.size);
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index - index at which the specified element is to be inserted
     * @param element - element to be inserted
     * @throws IndexOutOfBoundsException - if the index is out of bounds for size
     */
    public void insert(int index, T element) {
        checkBounds(index);
        increaseCapacityIfNeed();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of bounds for size
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkBounds(index);
        return (T) data[index];
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index - the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException - if the index is out of bounds for size
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkBounds(index);

        var element = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[size] = null;
        size--;

        return element;

    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param removedElement - removedElement to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean remove(T removedElement) {
        for (int i = 0; i < size; i++) {
            if (removedElement.equals(data[i])) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Removes all the elements from this list.
     * The list will be empty after this call returns.
     *
     */
    public void clear() {
        Arrays.fill(data, null);
        this.size = 0;
    }

    private void increaseCapacityIfNeed() {
        var loadFactor = (double) size / data.length;

        if (loadFactor >= STANDARD_LOAD_FACTOR) {
            long newCapacity = (long) data.length * MULTIPLIER;

            if (newCapacity > Integer.MAX_VALUE) {
                newCapacity = Integer.MAX_VALUE;
            }

            Object[] newData = new Object[(int) newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            this.data = newData;
        }
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for size %d%n", index, size));
        }
    }
}

