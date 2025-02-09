package dev.dsf.datastructure.queue;

import dev.dsf.abstractdatatype.QueueADT;
import dev.dsf.datastructure.collection.AbstractListBasedCollection;
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
public abstract class AbstractQueue<T> extends AbstractListBasedCollection<T> implements QueueADT<T> {
    /**
     * Constructs an empty queue.
     */
    protected AbstractQueue() {
        super();
    }

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
}
