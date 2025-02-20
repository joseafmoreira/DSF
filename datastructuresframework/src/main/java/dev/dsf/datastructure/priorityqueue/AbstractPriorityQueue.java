package dev.dsf.datastructure.priorityqueue;

import java.util.Iterator;
import java.util.StringJoiner;

import dev.dsf.abstractdatatype.PriorityQueueADT;
import dev.dsf.abstractdatatype.collection.IterableCollectionADT;
import dev.dsf.datastructure.list.ordered.OrderedArrayList;
import dev.dsf.datastructure.priorityqueue.binarysearchtree.AbstractBinarySearchTreePriorityQueue;
import dev.dsf.datastructure.priorityqueue.heap.AbstractHeapPriorityQueue;
import dev.dsf.datastructure.priorityqueue.orderedlist.AbstractOrderedListPriorityQueue;
import dev.dsf.datastructure.priorityqueue.unorderedlist.AbstractUnorderedListPriorityQueue;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface, to minimize the effort required to implement this interface.
 * <p>
 * 
 * <h3>AbstractPriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractUnorderedListPriorityQueue
 * @see AbstractOrderedListPriorityQueue
 * @see AbstractHeapPriorityQueue
 * @see AbstractBinarySearchTreePriorityQueue
 */
public abstract class AbstractPriorityQueue<T, C extends IterableCollectionADT<PriorityQueueNode<T>>>
        implements PriorityQueueADT<T> {
    /**
     * The collection cointaining the elements of this priority queue
     */
    protected C collection;

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        collection.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return collection.size();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof IterableCollectionADT))
            return false;
        Iterator<PriorityQueueNode<T>> it1 = collection.iterator();
        Iterator<PriorityQueueNode<T>> it2 = ((IterableCollectionADT<PriorityQueueNode<T>>) obj).iterator();
        while (it1.hasNext() && it2.hasNext()) {
            PriorityQueueNode<T> node1 = it1.next();
            PriorityQueueNode<T> node2 = it2.next();
            if (node1 == null ? node2 != null : !node1.equals(node2))
                return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return collection.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        OrderedArrayList<PriorityQueueNode<T>> list = new OrderedArrayList<>(size());
        for (PriorityQueueNode<T> node : collection)
            list.add(node);
        StringJoiner message = new StringJoiner(", ", "[", "]");
        toStringGenerator(list, message);
        return message.toString();
    }

    /**
     * Generate a string representation of this priority queue based on it's
     * properties.
     * 
     * @param list    the specified list where all priority queue nodes are stored
     * @param message the specified message to store the string representation of
     *                this priority queue
     */
    protected abstract void toStringGenerator(OrderedArrayList<PriorityQueueNode<T>> list, StringJoiner message);
}
