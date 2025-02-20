package dev.dsf.datastructure.priorityqueue.binarysearchtree.max;

import java.util.StringJoiner;

import dev.dsf.abstractdatatype.binarytree.BinarySearchTreeADT;
import dev.dsf.datastructure.list.ordered.OrderedArrayList;
import dev.dsf.datastructure.priorityqueue.binarysearchtree.AbstractBinarySearchTreePriorityQueue;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface using a binary search tree based collection, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractBinarySearchTreeMinPriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ArrayBinarySearchTreeMaxPriorityQueue
 * @see LinkedBinarySearchTreeMaxPriorityQueue
 */
public abstract class AbstractBinarySearchTreeMaxPriorityQueue<T, C extends BinarySearchTreeADT<PriorityQueueNode<T>>>
        extends AbstractBinarySearchTreePriorityQueue<T, C> {
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected void toStringGenerator(OrderedArrayList<PriorityQueueNode<T>> list, StringJoiner message) {
        for (int i = size() - 1; i >= 0; i--)
            message.add(list.get(i).getElement() == null ? "null" : list.get(i).toString());
    }
}
