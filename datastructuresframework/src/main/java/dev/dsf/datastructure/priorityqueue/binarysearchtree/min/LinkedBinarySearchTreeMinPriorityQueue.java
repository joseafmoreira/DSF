package dev.dsf.datastructure.priorityqueue.binarysearchtree.min;

import dev.dsf.datastructure.binarytree.search.LinkedBinarySearchTree;
import dev.dsf.node.PriorityQueueNode;

/**
 * Linked binary search tree implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>LinkedBinarySearchTreeMinPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedBinarySearchTreeMinPriorityQueue<T>
        extends AbstractBinarySearchTreeMinPriorityQueue<T, LinkedBinarySearchTree<PriorityQueueNode<T>>> {
    /**
     * Construct an empty priority queue.
     */
    public LinkedBinarySearchTreeMinPriorityQueue() {
        collection = new LinkedBinarySearchTree<>();
    }
}
