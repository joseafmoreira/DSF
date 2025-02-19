package dev.dsf.datastructure.priorityqueue.unorderedlist;

import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.datastructure.priorityqueue.AbstractPriorityQueue;
import dev.dsf.datastructure.priorityqueue.unorderedlist.max.AbstractUnorderedListMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.unorderedlist.min.AbstractUnorderedListMinPriorityQueue;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface using an unordered list based collection, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractUnorderedListPriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractUnorderedListMinPriorityQueue
 * @see AbstractUnorderedListMaxPriorityQueue
 */
public abstract class AbstractUnorderedListPriorityQueue<T, C extends UnorderedListADT<PriorityQueueNode<T>>>
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
        collection.addLast(new PriorityQueueNode<>(element, priority));
    }
}
