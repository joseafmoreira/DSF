package dev.dsf.datastructure.priorityqueue.heap.max;

import dev.dsf.abstractdatatype.binarytree.MaxHeapADT;
import dev.dsf.abstractdatatype.priorityqueue.HighPriorityFirst;
import dev.dsf.datastructure.priorityqueue.heap.AbstractHeapPriorityQueue;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface using a max-heap based collection, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractHeapMaxPriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ArrayHeapMaxPriorityQueue
 * @see LinkedHeapMaxPriorityQueue
 */
public abstract class AbstractHeapMaxPriorityQueue<T, C extends MaxHeapADT<PriorityQueueNode<T>>>
        extends AbstractHeapPriorityQueue<T, C> implements HighPriorityFirst {
    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T first() {
        return collection.findMax().getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T dequeue() {
        return collection.removeMax().getElement();
    }
}
