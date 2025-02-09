package dev.dsf.datastructure.stack;

import dev.dsf.abstractdatatype.StackADT;
import dev.dsf.datastructure.collection.AbstractListBasedCollection;
import dev.dsf.exception.EmptyCollectionException;

/**
 * This class provides a skeletal implementation of the {@code StackADT}
 * interface, to minimize the effort required to implement this interface.
 * <p>
 * It uses the {@code AbstractListBasedCollection} abstract class as a base
 * code.
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
public abstract class AbstractStack<T> extends AbstractListBasedCollection<T> implements StackADT<T> {
    /**
     * Constructor for use by subclasses.
     */
    protected AbstractStack() {
    }

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
}
