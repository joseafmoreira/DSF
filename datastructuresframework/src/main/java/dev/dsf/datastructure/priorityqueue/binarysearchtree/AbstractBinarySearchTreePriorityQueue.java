package dev.dsf.datastructure.priorityqueue.binarysearchtree;

import dev.dsf.abstractdatatype.binarytree.BinarySearchTreeADT;
import dev.dsf.datastructure.priorityqueue.AbstractPriorityQueue;
import dev.dsf.datastructure.priorityqueue.binarysearchtree.max.AbstractBinarySearchTreeMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.binarysearchtree.min.AbstractBinarySearchTreeMinPriorityQueue;
import dev.dsf.node.PriorityQueueNode;

/**
 * This class provides a skeletal implementation of the {@code PriorityQueueADT}
 * interface using a binary search tree based collection, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractBinarySearchTreePriorityQueue</h3>
 * 
 * @param <T> the type of elements in this priority queue
 * @param <C> the type of the collection cointaining the elements of this
 *            priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractBinarySearchTreeMinPriorityQueue
 * @see AbstractBinarySearchTreeMaxPriorityQueue
 */
public abstract class AbstractBinarySearchTreePriorityQueue<T, C extends BinarySearchTreeADT<PriorityQueueNode<T>>>
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
