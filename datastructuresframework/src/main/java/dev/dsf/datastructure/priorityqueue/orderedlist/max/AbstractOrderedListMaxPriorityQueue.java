package dev.dsf.datastructure.priorityqueue.orderedlist.max;

import dev.dsf.abstractdatatype.OrderedListADT;
import dev.dsf.datastructure.priorityqueue.orderedlist.AbstractOrderedListPriorityQueue;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface using an ordered list based collection, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractOrderedMaxPriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see OrderedArrayListMaxPriorityQueue
 * @see OrderedLinkedListMaxPriorityQueue
 * @see OrderedDoubleLinkedListMaxPriorityQueue
 */
public abstract class AbstractOrderedListMaxPriorityQueue<T, C extends OrderedListADT<PriorityQueueNode<T>>>
        extends AbstractOrderedListPriorityQueue<T, C> {
    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T first() {
        return collection.last().getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T dequeue() {
        return collection.removeLast().getElement();
    }
}
