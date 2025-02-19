package dev.dsf.datastructure.priorityqueue.orderedlist;

import dev.dsf.abstractdatatype.OrderedListADT;
import dev.dsf.datastructure.priorityqueue.AbstractPriorityQueue;
import dev.dsf.datastructure.priorityqueue.orderedlist.max.AbstractOrderedMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.orderedlist.min.AbstractOrderedMinPriorityQueue;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface using an ordered list based collection, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractOrderedListPriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractOrderedMinPriorityQueue
 * @see AbstractOrderedMaxPriorityQueue
 */
public abstract class AbstractOrderedListPriorityQueue<T, C extends OrderedListADT<PriorityQueueNode<T>>>
        extends AbstractPriorityQueue<T, C> {
    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public void enqueue(T element, int priority) {
        if (element == null)
            throw new NullPointerException("Element is null");
        collection.add(new PriorityQueueNode<>(element, priority));
    }
}
