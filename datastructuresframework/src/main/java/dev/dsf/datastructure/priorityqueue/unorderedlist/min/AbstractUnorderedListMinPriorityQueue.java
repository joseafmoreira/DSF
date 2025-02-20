package dev.dsf.datastructure.priorityqueue.unorderedlist.min;

import dev.dsf.abstractdatatype.list.UnorderedListADT;
import dev.dsf.datastructure.priorityqueue.unorderedlist.AbstractUnorderedListPriorityQueue;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface using an unordered list based collection, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractUnorderedListMinPriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see UnorderedArrayListMinPriorityQueue
 * @see UnorderedLinkedListMinPriorityQueue
 * @see UnorderedDoubleLinkedListMinPriorityQueue
 */
public abstract class AbstractUnorderedListMinPriorityQueue<T, C extends UnorderedListADT<PriorityQueueNode<T>>>
        extends AbstractUnorderedListPriorityQueue<T, C> {
    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T first() {
        return collection.get(getMin()).getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T dequeue() {
        return collection.remove(getMin()).getElement();
    }

    /**
     * Returns the index of the lowest element in this unordered list.
     * 
     * @return the index of the lowest element in this unordered list
     */
    protected int getMin() {
        int minIndex = 0;
        for (int i = 1; i < collection.size(); i++)
            if (collection.get(i).compareTo(collection.get(minIndex)) < 0)
                minIndex = i;
        return minIndex;
    }
}
