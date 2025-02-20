package dev.dsf.datastructure.list.ordered;

import dev.dsf.abstractdatatype.list.OrderedListADT;
import dev.dsf.algorithm.search.BinarySearch;
import dev.dsf.datastructure.list.ArrayList;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Resizable-array implementation of the {@code OrderedListADT} interface.
 * 
 * <h3>OrderedArrayList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class OrderedArrayList<T> extends ArrayList<T> implements OrderedListADT<T> {
    /**
     * Constructs an empty list with a default capacity.
     */
    public OrderedArrayList() {
        super();
    }

    /**
     * Constructs an empty list with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    public OrderedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws ClassCastException {@inheritDoc}
     */
    @Override
    public void add(T element) {
        if (size() == array.length)
            expandCapacity();
        int insertionIndex = findInsertionIndex(element);
        for (int i = size(); i > insertionIndex; i--)
            array[i] = array[i - 1];
        array[insertionIndex] = element;
        size++;
        modCount++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public int indexOf(T target) {
        return BinarySearch.search(array, size(), target);
    }

    /**
     * Finds the index at which the specified element should be inserted to maintain
     * the order of the list.
     * 
     * @param element the specified element
     * @return the index at which the specified element should be inserted
     * @throws ClassCastException if the element isn't comparable
     */
    @SuppressWarnings("unchecked")
    private int findInsertionIndex(T element) {
        int left = 0;
        int right = size() - 1;
        Comparable<T> comparableElement = element == null ? null : (Comparable<T>) element;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == null || element != null && comparableElement.compareTo(array[mid]) <= 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
