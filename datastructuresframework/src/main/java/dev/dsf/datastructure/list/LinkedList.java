package dev.dsf.datastructure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import dev.dsf.abstractdatatype.list.ListADT;
import dev.dsf.algorithm.search.LinearSearch;
import dev.dsf.datastructure.list.ordered.OrderedLinkedList;
import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.LinearNode;

/**
 * Singly-linked list implementation of the {@code ListADT} interface.
 * 
 * <h3>LinkedList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see OrderedLinkedList
 * @see UnorderedLinkedList
 */
public abstract class LinkedList<T> extends AbstractList<T> {
    /**
     * The head node of this list.
     */
    protected LinearNode<T> head;
    /**
     * The tail node of this list.
     */
    protected LinearNode<T> tail;

    /**
     * Constructs an empty linked list.
     */
    protected LinkedList() {
        super();
        head = null;
        tail = null;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException  {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T get(int index) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        Iterator<T> it = iterator();
        T element = null;
        for (int i = 0; i <= index; i++)
            element = it.next();
        return element;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public int indexOf(T target) {
        return LinearSearch.search((ListADT<T>) this, target);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException  {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T remove(int index) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        LinearNode<T> previousNode = null;
        LinearNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        T element = currentNode.getElement();
        if (previousNode == null)
            head = currentNode.getNext();
        else
            previousNode.setNext(currentNode.getNext());
        if (currentNode == tail)
            tail = previousNode;
        size--;
        modCount++;
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        super.clear();
        head = null;
        tail = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * {@code Iterator} implementation for the {@code LinkedList} class
     */
    private class LinkedListIterator extends ListIterator {
        /**
         * The current node of this linked list
         */
        private LinearNode<T> currentNode;

        /**
         * Constructs an empty LinkedListIterator object.
         */
        public LinkedListIterator() {
            super();
            currentNode = head;
        }

        /**
         * {@inheritDoc}
         * 
         * @throws ConcurrentModificationException if this list has been altered
         */
        @Override
        public T next() throws ConcurrentModificationException {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException("List has been altered");
            T result = currentNode.getElement();
            currentNode = currentNode.getNext();
            okToRemove = true;
            currentIndex++;
            return result;
        }
    }
}
