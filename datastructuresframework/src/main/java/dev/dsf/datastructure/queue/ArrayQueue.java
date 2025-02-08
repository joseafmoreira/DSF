package dev.dsf.datastructure.queue;

import dev.dsf.abstractdatatype.QueueADT;
import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.datastructure.list.unordered.UnorderedArrayList;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Resizable-array list implementation of the {@code QueueADT} interface.
 * 
 * <h3>ArrayQueue</h3>
 * 
 * @param <T> the type of element stored in this queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class ArrayQueue<T> implements QueueADT<T> {
    /**
     * The resizable-array list
     */
    protected UnorderedListADT<T> list;

    /**
     * Constructs an empty queue.
     */
    public ArrayQueue() {
        list = new UnorderedArrayList<>();
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
