package dev.dsf.abstractdatatype.binarytree;

import dev.dsf.exception.EmptyCollectionException;

/**
 * A max-heap is a type of heap in which every parent node is bigger or equal
 * in comparison to it's left and right child.
 * <p>
 * 
 * The common operations for a max-heap include:
 * <p>
 * <ul>
 * <li>{@link #findMax()}: Returns the element from the root of this heap</li>
 * <li>{@link #removeMax()}: Removes the element from the root of this heap</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>MaxHeapADT</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public interface MaxHeapADT<T> extends HeapADT<T> {
    /**
     * Returns the element from the root of this heap.
     * 
     * @return the element from the root of this heap
     * @throws EmptyCollectionException if this heap is empty
     */
    default T findMax() {
        return getRoot();
    }

    /**
     * Removes the element from the root of this heap.
     * 
     * @return the element from the root of this heap
     * @throws EmptyCollectionException if this heap is empty
     */
    T removeMax();
}
