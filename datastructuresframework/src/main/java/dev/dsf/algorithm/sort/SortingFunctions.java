package dev.dsf.algorithm.sort;

/**
 * Class that implements all the methods shared by the sorting algorithms.
 * <p>
 * 
 * <h3>SortingFunctions</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class SortingFunctions {
    /**
     * Swaps the elements at the specified positions in the specified array.
     *
     * @param <T>   the type of the elements in the array
     * @param array the specified array
     * @param i     the index of one element to be swapped
     * @param j     the index of the other element to be swapped
     * @throws IndexOutOfBoundsException if either i or j is out of range
     */
    public static <T> void swap(T[] array, int i, int j) throws IndexOutOfBoundsException {
        if (i < 0 || i >= array.length)
            throw new IndexOutOfBoundsException("Index " + i + " out of range");
        if (j < 0 || j >= array.length)
            throw new IndexOutOfBoundsException("Index " + j + " out of range");
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
