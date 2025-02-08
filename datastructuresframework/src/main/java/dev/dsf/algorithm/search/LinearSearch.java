package dev.dsf.algorithm.search;

import java.util.Iterator;

import dev.dsf.abstractdatatype.ListADT;

/**
 * Linear, or sequential, search is a simple searching algorithm
 * that traverses a list or array sequentially to find a target.
 * <p>
 * 
 * <h3>LinearSearch</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class LinearSearch {
    /**
     * Performs a linear search on the specified list to find the specified target.
     *
     * @param <T>    the type of elements in the list and the target
     * @param list   the specified list
     * @param target the specified target
     * @return the index of the first occurrence of the specified target
     *         in this list, or -1 if this list does not contain the target
     * @throws NullPointerException if the list is null
     */
    public static <T> int search(ListADT<T> list, T target) {
        if (list == null)
            throw new NullPointerException("List is null");
        Iterator<T> listIterator = list.iterator();
        for (int i = 0; listIterator.hasNext(); i++) {
            T element = listIterator.next();
            if (element == target || element != null && element.equals(target))
                return i;
        }
        return -1;
    }

    /**
     * Performs a linear search on the specified array to find the specified target.
     *
     * @param <T>    the type of elements in the array
     * @param array  the specified array
     * @param target the specified target
     * @return the index of the first occurrence of the specified target
     *         in this array, or -1 if this array does not contain the target
     * @throws NullPointerException if the array is null
     */
    public static <T> int search(T[] array, T target) {
        return search(array, array.length, target);
    }

    /**
     * Performs a linear search on the specified array to find the specified target.
     *
     * @param <T>    the type of elements in the array
     * @param array  the specified array
     * @param length the specified length
     * @param target the specified target
     * @return the index of the first occurrence of the specified target
     *         in this array, or -1 if this array does not contain the target
     * @throws NullPointerException if the array is null
     */
    public static <T> int search(T[] array, int length, T target) {
        if (array == null)
            throw new NullPointerException("Array is null");
        for (int i = 0; i < length; i++)
            if (array[i] == target || array[i] != null && array[i].equals(target))
                return i;
        return -1;
    }
}
