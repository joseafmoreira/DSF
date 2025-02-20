package dev.dsf.datastructure.priorityqueue.heap.min;

import dev.dsf.datastructure.binarytree.heap.min.ArrayMinHeap;
import dev.dsf.node.PriorityQueueNode;

/**
 * Array min-heap implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>ArrayHeapMinPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class ArrayHeapMinPriorityQueue<T> extends AbstractHeapMinPriorityQueue<T, ArrayMinHeap<PriorityQueueNode<T>>> {
    /**
     * Construct an empty priority queue.
     */
    public ArrayHeapMinPriorityQueue() {
        collection = new ArrayMinHeap<>();
    }
}
