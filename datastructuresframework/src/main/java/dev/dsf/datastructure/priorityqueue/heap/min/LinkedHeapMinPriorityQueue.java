package dev.dsf.datastructure.priorityqueue.heap.min;

import dev.dsf.datastructure.binarytree.heap.min.LinkedMinHeap;
import dev.dsf.node.PriorityQueueNode;

/**
 * Min-heap implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>LinkedHeapMinPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedHeapMinPriorityQueue<T> extends AbstractHeapMinPriorityQueue<T, LinkedMinHeap<PriorityQueueNode<T>>> {
    /**
     * Construct an empty heap.
     */
    public LinkedHeapMinPriorityQueue() {
        collection = new LinkedMinHeap<>();
    }
}
