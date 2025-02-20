package dev.dsf.datastructure.priorityqueue.heap.max;

import dev.dsf.datastructure.binarytree.heap.max.ArrayMaxHeap;
import dev.dsf.node.PriorityQueueNode;

/**
 * Array max-heap implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>ArrayHeapMaxPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class ArrayHeapMaxPriorityQueue<T> extends AbstractHeapMaxPriorityQueue<T, ArrayMaxHeap<PriorityQueueNode<T>>> {
    /**
     * Construct an empty priority queue.
     */
    public ArrayHeapMaxPriorityQueue() {
        collection = new ArrayMaxHeap<>();
    }
}
