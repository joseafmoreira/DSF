package dev.dsf.datastructure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import dev.dsf.abstractdatatype.ListADT;
import dev.dsf.algorithm.search.LinearSearch;
import dev.dsf.algorithm.sort.MergeSort;
import dev.dsf.datastructure.list.ordered.OrderedDoubleLinkedList;
import dev.dsf.datastructure.list.unordered.UnorderedDoubleLinkedList;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.DoubleLinearNode;

/**
 * Doubly-linked list implementation of the {@code ListADT} interface.
 * 
 * <h3>DoubleLinkedList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see OrderedDoubleLinkedList
 * @see UnorderedDoubleLinkedList
 */
public abstract class DoubleLinkedList<T> extends AbstractList<T> {
    /**
     * The head node of this list.
     */
    protected DoubleLinearNode<T> head;
    /**
     * The tail node of this list.
     */
    protected DoubleLinearNode<T> tail;

    /**
     * Constructs an empty double linked list.
     */
    public DoubleLinkedList() {
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
     * @throws ClassCastException {@inheritDoc}
     */
    public void sort() {
        T[] array = MergeSort.sort(this);
        int i = 0;
        DoubleLinearNode<T> currentNode = head;
        while (currentNode != null) {
            currentNode.setElement(array[i++]);
            currentNode = currentNode.getNext();
        }
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
    public T remove(int index) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        DoubleLinearNode<T> currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.getNext();
        T result = currentNode.getElement();
        if (currentNode.getPrev() == null) {
            head = currentNode.getNext();
            if (head != null)
                head.setPrev(null);
        } else
            currentNode.getPrev().setNext(currentNode.getNext());
        if (currentNode.getNext() == null) {
            tail = currentNode.getPrev();
            if (tail != null)
                tail.setNext(null);
        } else
            currentNode.getNext().setPrev(currentNode.getPrev());
        size--;
        modCount++;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        super.clear();
        head = null;
        tail = null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    /**
     * {@code Iterator} implementation for the {@code DoubleLinkedList} class
     */
    private class DoubleLinkedListIterator extends ListIterator {
        /**
         * The current node of this double linked list
         */
        private DoubleLinearNode<T> currentNode;

        /**
         * Constructs an empty DoubleLinkedListIterator object.
         */
        public DoubleLinkedListIterator() {
            currentNode = head;
            expectedModCount = modCount;
            okToRemove = false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
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
            okToRemove = true;
            currentNode = currentNode.getNext();
            return result;
        }

        /**
         * {@inheritDoc}
         * 
         * @throws ConcurrentModificationException if this list has been altered
         */
        @Override
        public void remove() throws ConcurrentModificationException, IllegalStateException {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException("List has been altered");
            if (!okToRemove)
                throw new IllegalStateException("Invalid remove call");
            DoubleLinkedList.this
                    .remove((currentNode == null) ? tail.getElement() : currentNode.getPrev().getElement());
            expectedModCount++;
            okToRemove = false;
        }
    }
}
