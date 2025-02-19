package dev.dsf.datastructure.priorityqueue.heap.max;

import dev.dsf.datastructure.binarytree.heap.max.LinkedMaxHeap;
import dev.dsf.node.PriorityQueueNode;

/**
 * Max-heap implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>LinkedHeapMaxPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedHeapMaxPriorityQueue<T> extends AbstractHeapMaxPriorityQueue<T, LinkedMaxHeap<PriorityQueueNode<T>>> {
    /**
     * Construct an empty heap.
     */
    public LinkedHeapMaxPriorityQueue() {
        collection = new LinkedMaxHeap<>();
    }
}
