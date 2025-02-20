package dev.dsf.datastructure.priorityqueue.binarysearchtree.min;

import dev.dsf.datastructure.binarytree.search.ArrayBinarySearchTree;
import dev.dsf.node.PriorityQueueNode;

/**
 * Array binary search tree implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>ArrayBinarySearchTreeMinPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class ArrayBinarySearchTreeMinPriorityQueue<T>
        extends AbstractBinarySearchTreeMinPriorityQueue<T, ArrayBinarySearchTree<PriorityQueueNode<T>>> {
    /**
     * Construct an empty priority queue.
     */
    public ArrayBinarySearchTreeMinPriorityQueue() {
        collection = new ArrayBinarySearchTree<>();
    }
}
