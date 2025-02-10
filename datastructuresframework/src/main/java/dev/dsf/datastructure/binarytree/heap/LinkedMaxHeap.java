package dev.dsf.datastructure.binarytree.heap;

import dev.dsf.abstractdatatype.MaxHeapADT;

/**
 * Linked implementation of the {@code MaxHeapADT} interface.
 * 
 * <h3>LinkedMaxHeap</h3>
 * 
 * @param <T> the type of element stored in this binary tree
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedMaxHeap<T> extends LinkedHeap<T> implements MaxHeapADT<T> {
    /**
     * Constructs an empty heap.
     */
    public LinkedMaxHeap() {
        super();
    }
}
