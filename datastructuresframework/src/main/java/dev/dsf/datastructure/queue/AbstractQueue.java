package dev.dsf.datastructure.queue;

import dev.dsf.abstractdatatype.QueueADT;
import dev.dsf.abstractdatatype.list.UnorderedListADT;
import dev.dsf.exception.EmptyCollectionException;

/**
 * This class provides a skeletal implementation of the {@code QueueADT}
 * interface, to minimize the effort required to implement this interface.
 * <p>
 * 
 * <h3>AbstractQueue</h3>
 * 
 * @param <T> the type of elements in this queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ArrayQueue
 * @see LinkedQueue
 */
public abstract class AbstractQueue<T> implements QueueADT<T> {
    /**
     * The list containing the elements of this collection
     */
    protected UnorderedListADT<T> list;

    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueue(T element) {
        list.addLast(element);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T first() {
        return list.first();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T dequeue() {
        return list.removeFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        return list.equals(obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return list.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return list.toString();
    }
}
