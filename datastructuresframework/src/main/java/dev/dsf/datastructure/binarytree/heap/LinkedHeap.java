package dev.dsf.datastructure.binarytree.heap;

import dev.dsf.abstractdatatype.HeapADT;
import dev.dsf.datastructure.binarytree.LinkedBinaryTree;
import dev.dsf.node.HeapNode;

/**
 * This class provides a skeletal implemetation for a linked-based heap
 * having all the common method implementations.
 * <p>
 * 
 * <h3>LinkedHeap</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see LinkedMinHeap
 * @see LinkedMaxHeap
 */
public abstract class LinkedHeap<T> extends LinkedBinaryTree<T> implements HeapADT<T> {
    /**
     * The reference to the last node added in this heap.
     */
    protected HeapNode<T> lastNode;

    /**
     * Constructs an empty heap.
     */
    protected LinkedHeap() {
        super();
        lastNode = null;
    }
}
