package dev.dsf.datastructure.stack;

import dev.dsf.abstractdatatype.StackADT;
import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.exception.EmptyCollectionException;

/**
 * This class provides a skeletal implementation of the {@code StackADT}
 * interface, to minimize the effort required to implement this interface.
 * <p>
 * 
 * <h3>AbstractStack</h3>
 * 
 * @param <T> the type of elements in this stack
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ArrayStack
 * @see LinkedStack
 */
public abstract class AbstractStack<T> implements StackADT<T> {
    /**
     * The list containing the elements of this collection
     */
    protected UnorderedListADT<T> list;

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T element) {
        list.addLast(element);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T peek() {
        return list.last();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T pop() {
        return list.removeLast();
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
