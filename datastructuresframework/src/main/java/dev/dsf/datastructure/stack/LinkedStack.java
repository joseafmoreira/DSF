package dev.dsf.datastructure.stack;

import dev.dsf.abstractdatatype.StackADT;
import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Singly-linked list implementation of the {@code StackADT} interface.
 * 
 * <h3>LinkedStack</h3>
 * 
 * @param <T> the type of element stored in this stack
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedStack<T> implements StackADT<T> {
    /**
     * The singly-linked list
     */
    protected UnorderedListADT<T> list;

    /**
     * Constructs an empty stack.
     */
    public LinkedStack() {
        list = new UnorderedLinkedList<>();
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
