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
        var listSize = list.getSize();

        if (listSize == 0) {
            return new CustomArrayList<>();
        }

        var index = listSize / 2;
        var pivot = list.get(index);

        var smallerElements = new CustomArrayList<T>();
        var biggerElements = new CustomArrayList<T>();

        for (int i = 0; i < listSize; i++) {
            if (i == index) {
                continue;
            }

            var currentElement = list.get(i);

            if (comparator.compare(currentElement, pivot) < 0) {
                smallerElements.add(currentElement);
            } else {
                biggerElements.add(currentElement);
            }
        }

        var sortedSmallerElements = quickSort(smallerElements, comparator);
        var sortedBiggerElements = quickSort(biggerElements, comparator);

        var result = sortedSmallerElements;
        result.add(pivot);
        result.addAll(sortedBiggerElements);
        return result;
    }
}
