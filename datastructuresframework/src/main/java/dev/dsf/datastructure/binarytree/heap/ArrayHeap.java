package dev.dsf.datastructure.binarytree.heap;

import dev.dsf.abstractdatatype.HeapADT;
import dev.dsf.datastructure.binarytree.ArrayBinaryTree;

/**
 * This class provides a skeletal implemetation for a resizable-array list-based
 * heap having all the common method implementations.
 * <p>
 * 
 * <h3>ArrayHeap</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ArrayMinHeap
 * @see ArrayMaxHeap
 */
public abstract class ArrayHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {
    /**
     * The index of the last node added in this heap.
     */
    protected int lastIndex;

    /**
     * Constructs an empty heap.
     */
    protected ArrayHeap() {
        super();
        lastIndex = -1;
    }
}
