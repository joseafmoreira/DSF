package dev.dsf.datastructure.stack;

import dev.dsf.abstractdatatype.StackADT;
import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.datastructure.list.unordered.UnorderedArrayList;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Resizable-array list implementation of the {@code StackADT} interface.
 * 
 * <h3>ArrayStack</h3>
 * 
 * @param <T> the type of element stored in this stack
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class ArrayStack<T> implements StackADT<T> {
    /**
     * The resizable-array list
     */
    protected UnorderedListADT<T> list;

    /**
     * Constructs an empty stack.
     */
    public ArrayStack() {
        list = new UnorderedArrayList<>();
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
