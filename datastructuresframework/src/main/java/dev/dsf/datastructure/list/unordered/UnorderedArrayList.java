package dev.dsf.datastructure.list.unordered;

import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.algorithm.search.LinearSearch;
import dev.dsf.algorithm.sort.MergeSort;
import dev.dsf.datastructure.list.ArrayList;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Resizable-array implementation of the {@code UnorderedListADT} interface
 * using the {@code ArrayList} abstract class as a base code.
 * 
 * <h3>UnorderedArrayList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class UnorderedArrayList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    /**
     * Constructs an empty unordered array list with a default capacity.
     */
    public UnorderedArrayList() {
        super();
    }

    /**
     * Constructs an empty unordered array list with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    public UnorderedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (size() == array.length)
            expandCapacity();
        for (int i = size(); i > index; i--)
            array[i] = array[i - 1];
        array[index] = element;
        size++;
        modCount++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T set(int index, T element) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        T result = array[index];
        array[index] = element;
        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public int indexOf(T target) {
        return LinearSearch.search(array, size(), target);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws ClassCastException {@inheritDoc}
     */
    @Override
    public void sort() {
        MergeSort.sort(array, size());
    }
}
