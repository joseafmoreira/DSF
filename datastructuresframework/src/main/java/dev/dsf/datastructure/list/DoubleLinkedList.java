package dev.dsf.datastructure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import dev.dsf.abstractdatatype.ListADT;
import dev.dsf.algorithm.search.LinearSearch;
import dev.dsf.datastructure.list.ordered.OrderedDoubleLinkedList;
import dev.dsf.datastructure.list.unordered.UnorderedDoubleLinkedList;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.Node;

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
    protected DoubleLinkedList() {
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
        DoubleLinearNode<T> currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.getNext();
        T element = currentNode.getElement();
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

    /**
     * A double linear node is an auxiliary object used to implement a doubly linked
     * data structure.
     * <p>
     * It contains an {@code #element}, a pointer to the {@code #next} double linear
     * node and a pointer to the {@code #prev} double linear node.
     * <p>
     * 
     * The available constructors are the following:
     * <p>
     * <ul>
     * <li>{@link #DoubleLinearNode()}: Constructs an empty double linear node</li>
     * <li>{@link #DoubleLinearNode(Object)}: Constructs a double linear node with
     * an element</li>
     * <li>{@link #DoubleLinearNode(Object, DoubleLinearNode, DoubleLinearNode)}:
     * Constructs a double linear node with an
     * element, a reference to the next double linear node and a reference to the
     * prev double linear node</li>
     * </ul>
     * 
     * The operations for this {@code DoubleLinearNode} include:
     * <p>
     * <ul>
     * <li>{@link #getPrev()}: Returns the reference stored in this linear node prev
     * pointer</li>
     * <li>{@link #setPrev(DoubleLinearNode)}: Sets the reference stored in this
     * linear node prev pointer</li>
     * <li>{@link #getNext()}: Returns the reference stored in this linear node next
     * pointer</li>
     * <li>{@link #setNext(DoubleLinearNode)}: Sets the reference stored in this
     * linear node next pointer</li>
     * </ul>
     * 
     * <h3>DoubleLinearNode</h3>
     * 
     * @param <T> the type of element stored in this double linear node
     * @since 1.0
     * @version 1.0
     * @author joseafmoreira
     */
    protected static class DoubleLinearNode<T> extends Node<T> {
        /**
         * The reference to the previous node
         */
        protected DoubleLinearNode<T> prev;
        /**
         * The reference to the next node
         */
        protected DoubleLinearNode<T> next;

        /**
         * Constructs an empty double linear node.
         */
        public DoubleLinearNode() {
            this(null);
        }

        /**
         * Constructs a double linear node with an element.
         * 
         * @param element the element to be stored in this double linear node
         */
        public DoubleLinearNode(T element) {
            this(element, null, null);
        }

        /**
         * Constructs a double linear node with an element, a reference to the next
         * double linear node and a reference to the prev double linear node.
         * 
         * @param element the element to be stored in this double linear node
         * @param prev    the reference of the prev double linear node
         * @param next    the reference of the next double linear node
         */
        public DoubleLinearNode(T element, DoubleLinearNode<T> prev, DoubleLinearNode<T> next) {
            super(element);
            setPrev(prev);
            setNext(next);
        }

        /**
         * Returns the reference stored in this linear node prev pointer.
         * 
         * @return the reference stored in this linear node prev pointer
         */
        public DoubleLinearNode<T> getPrev() {
            return prev;
        }

        /**
         * Sets the reference stored in this linear node prev pointer.
         * 
         * @param next the reference to be stored in this linear node prev pointer
         */
        public void setPrev(DoubleLinearNode<T> prev) {
            this.prev = prev;
        }

        /**
         * Returns the reference stored in this linear node next pointer.
         * 
         * @return the reference stored in this linear node next pointer
         */
        public DoubleLinearNode<T> getNext() {
            return next;
        }

        /**
         * Sets the reference stored in this linear node next pointer.
         * 
         * @param next the reference to be stored in this linear node next pointer
         */
        public void setNext(DoubleLinearNode<T> next) {
            this.next = next;
        }
    }
}
