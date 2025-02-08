package dev.dsf.algorithm.search;

/**
 * Binary search is an efficient algorithm for finding a target
 * within a sorted array. It works by repeatedly dividing the
 * search interval in half.
 * <p>
 * 
 * <h3>BinarySearch</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class BinarySearch {
    /**
     * Performs a binary search on the specified array to find the specified target.
     *
     * @param <T>    the type of elements in the array and the target
     * @param array  the specified array
     * @param target the specified target
     * @return the index of the first occurrence of the specified target
     *         in this array, or -1 if this array does not contain the target
     * @throws NullPointerException if the array is null
     * @throws ClassCastException   if the elements in the array aren't comparable
     */
    public static <T> int search(T[] array, T target) {
        return search(array, array.length, target);
    }

    /**
     * Performs a binary search on the specified array to find the specified target.
     *
     * @param <T>    the type of elements in the array and the target
     * @param array  the specified array
     * @param length the specified length
     * @param target the specified target
     * @return the index of the first occurrence of the specified target
     *         in this array, or -1 if this array does not contain the target
     * @throws NullPointerException if the array is null
     * @throws ClassCastException   if the elements in the array aren't comparable
     */
    public static <T> int search(T[] array, int length, T target) {
        if (array == null)
            throw new NullPointerException("Array is null");
        return search(array, 0, length - 1, target);
    }

    /**
     * Binary search algorithm implementation using a recursive approach.
     *
     * @param <T>      the type of elements in the array, which must be comparable
     * @param array    the specified array
     * @param minIndex the minimum index of the array segment to search
     * @param maxIndex the maximum index of the array segment to search
     * @param target   the specified target
     * @return the index of the first occurrence of the specified target
     *         in this array, or -1 if this array does not contain the target
     * @throws ClassCastException if the elements in the array aren't comparable
     */
    @SuppressWarnings("unchecked")
    private static <T> int search(T[] array, int minIndex, int maxIndex, T target) {
        if (minIndex <= maxIndex) {
            int midpoint = (minIndex + maxIndex) / 2;
            if (array[midpoint] == null)
                if (target == null)
                    return midpoint;
                else
                    return search(array, minIndex, midpoint - 1, target);
            else if (target == null || ((Comparable<T>) array[midpoint]).compareTo(target) > 0)
                return search(array, minIndex, midpoint - 1, target);
            else if (((Comparable<T>) array[midpoint]).compareTo(target) < 0)
                return search(array, midpoint + 1, maxIndex, target);
            else
                return midpoint;
        }
        return -1;
    }
}
