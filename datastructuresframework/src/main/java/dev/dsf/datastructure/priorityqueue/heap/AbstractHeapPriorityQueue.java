package dev.dsf.datastructure.priorityqueue.heap;

import dev.dsf.abstractdatatype.binarytree.HeapADT;
import dev.dsf.datastructure.priorityqueue.AbstractPriorityQueue;
import dev.dsf.datastructure.priorityqueue.heap.max.AbstractHeapMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.heap.min.AbstractHeapMinPriorityQueue;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface using a heap based collection, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractHeapPriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractHeapMinPriorityQueue
 * @see AbstractHeapMaxPriorityQueue
 */
public abstract class AbstractHeapPriorityQueue<T, C extends HeapADT<PriorityQueueNode<T>>>
        extends AbstractPriorityQueue<T, C> {
    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public void enqueue(T element, int priority) {
        collection.add(new PriorityQueueNode<>(element, priority));
    }
}
