package dev.dsf.datastructure.priorityqueue.unorderedlist.max;

import dev.dsf.abstractdatatype.list.UnorderedListADT;
import dev.dsf.abstractdatatype.priorityqueue.HighPriorityFirst;
import dev.dsf.datastructure.priorityqueue.unorderedlist.AbstractUnorderedListPriorityQueue;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface using an unordered list based collection, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractUnorderedListMaxPriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see UnorderedArrayListMaxPriorityQueue
 * @see UnorderedLinkedListMaxPriorityQueue
 * @see UnorderedDoubleLinkedListMaxPriorityQueue
 */
public abstract class AbstractUnorderedListMaxPriorityQueue<T, C extends UnorderedListADT<PriorityQueueNode<T>>>
        extends AbstractUnorderedListPriorityQueue<T, C> implements HighPriorityFirst {
    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T first() {
        return collection.get(getMax()).getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T dequeue() {
        return collection.remove(getMax()).getElement();
    }

    /**
     * Returns the index of the highest element in this unordered list.
     * 
     * @return the index of the highest element in this unordered list
     */
    protected int getMax() {
        int maxIndex = 0;
        for (int i = 1; i < collection.size(); i++)
            if (collection.get(i).compareTo(collection.get(maxIndex)) > 0)
                maxIndex = i;
        return maxIndex;
    }
}
