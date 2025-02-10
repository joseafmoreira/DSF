package dev.dsf.datastructure.binarytree.heap;

import dev.dsf.abstractdatatype.MinHeapADT;

/**
 * Linked implementation of the {@code MinHeapADT} interface.
 * 
 * <h3>LinkedMinHeap</h3>
 * 
 * @param <T> the type of element stored in this binary tree
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class LinkedMinHeap<T> extends LinkedHeap<T> implements MinHeapADT<T> {
    /**
     * Constructs an empty heap.
     */
    public LinkedMinHeap() {
        super();
    }
}
