package dev.dsf.abstractdatatype;

import dev.dsf.exception.EmptyCollectionException;

/**
 * A min-heap is a type of heap in which every parent node is smaller or equal
 * in comparison to it's left and right child.
 * <p>
 * 
 * The common operations for a min-heap include:
 * <p>
 * <ul>
 * <li>{@link #findMin()}: Returns the element from the root of this heap</li>
 * <li>{@link #removeMin()}: Removes the element from the root of this heap</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>MinHeapADT</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public interface MinHeapADT<T> extends HeapADT<T> {
    /**
     * Returns the element from the root of this heap.
     * 
     * @return the element from the root of this heap
     * @throws EmptyCollectionException if this heap is empty
     */
    default T findMin() {
        return getRoot();
    }

    /**
     * Removes the element from the root of this heap.
     * 
     * @return the element from the root of this heap
     * @throws EmptyCollectionException if this heap is empty
     */
    T removeMin();
}
