package dev.dsf.abstractdatatype;

import java.util.Iterator;

/**
 * A heap is a non-linear abstract data type that are complete binary trees
 * meaning that all the levels of the tree are filled except the lowest level
 * nodes or leafs which are filled from as left as possible.
 * <p>
 * 
 * There are two types of heaps:
 * <p>
 * <ul>
 * <li>Min-heap</li>
 * <li>Max-heap</li>
 * </ul>
 * The difference between the two heaps is that every parent node is
 * smaller/bigger or equal in comparison to the left and right child for the
 * min-heap and max-heap respectively.
 * <p>
 * 
 * The operations for a heap include:
 * <p>
 * <ul>
 * <li>{@link #add(Object)}: Adds an element to this heap at the proper
 * location</li>
 * <li>{@link #iterator()}: Returns an iterator over the element of this
 * heap</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>HeapADT</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see MinHeapADT
 * @see MaxHeapADT
 */
public interface HeapADT<T> extends BinaryTreeADT<T> {
    /**
     * Adds an element to this heap at the proper location.
     * 
     * @param element the element to be added
     * @throws NullPointerException if the specified element is null
     * @throws ClassCastException   if the element isn't comparable
     */
    void add(T element);

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the specified target is null
     */
    @Override
    default boolean contains(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");
        for (T element : this)
            if (element.equals(target))
                return true;
        return false;
    }

    /**
     * Returns an iterator over the element of this heap.
     * 
     * @return an iterator over the element of this heap
     * @see IterableCollectionADT#iterator()
     */
    @Override
    default Iterator<T> iterator() {
        return iteratorLevelOrder();
    }
}
