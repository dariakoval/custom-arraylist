package org.example;

import java.util.Comparator;

/**
 * Utility class for sorting {@link org.example.CustomArrayList} class
 * according to the order induced by the specified {@link java.util.Comparator} class.
 *
 * @author Daria Koval
 *
 */
public class CustomArrayListUtil {

    /**
     * Default constructor.
     */
    public CustomArrayListUtil() {
    }

    /**
     * Sorts this list according to the order induced by the specified Comparator.
     * All elements in this list implement the Comparable interface and natural order is used to sort the elements.
     * @param list - list containing elements to be sorted
     * @return a list sorted in natural order
     * @param <T> the Type of elements in this list
     */
    @SuppressWarnings("unchecked")
    public static <T> CustomArrayList<T> sort(CustomArrayList<T> list) {
        Comparator<T> comparator = (o1, o2) -> ((Comparable<? super T>) o1).compareTo(o2);
        return quickSort(list, comparator);
    }

    private static <T> CustomArrayList<T> quickSort(CustomArrayList<T> list, Comparator<T> comparator) {
        if (list.getSize() < 2) {
            return list;
        }

        var pivot = list.get(0);
        var less = new CustomArrayList<T>();
        for (int i = 1; i < list.getSize(); i++) {
            var current = list.get(i);
            if (comparator.compare(current, pivot) < 0) {
                less.add(current);
            }
        }
        var greater = new CustomArrayList<T>();
        for (int i = 1; i < list.getSize(); i++) {
            var current = list.get(i);
            if (comparator.compare(current, pivot) >= 0) {
                greater.add(current);
            }
        }

        var sortedLess = quickSort(less, comparator);
        var sortedGreater = quickSort(greater, comparator);

        sortedLess.add(pivot);
        sortedLess.addAll(sortedGreater);
        return sortedLess;
    }
}
