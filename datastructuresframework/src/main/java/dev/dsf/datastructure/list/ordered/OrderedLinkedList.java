package dev.dsf.datastructure.list.ordered;

import dev.dsf.abstractdatatype.OrderedListADT;
import dev.dsf.datastructure.list.LinkedList;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.LinearNode;

/**
 * Singly-linked list implementation of the {@code OrderedListADT} interface
 * using the {@code LinkedList} abstract class as a base code.
 * 
 * <h3>OrderedLinkedList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class OrderedLinkedList<T> extends LinkedList<T> implements OrderedListADT<T> {
    /**
     * Constructs an empty ordered linked list.
     */
    public OrderedLinkedList() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws ClassCastException {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (element == null) {
            tail.setNext(newNode);
            tail = newNode;
        } else if (head.getElement() == null || ((Comparable<T>) element).compareTo(head.getElement()) <= 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            LinearNode<T> currentNode = head;
            while (currentNode.getNext() != null && (currentNode.getNext().getElement() == null
                    || ((Comparable<T>) element).compareTo(currentNode.getNext().getElement()) > 0)) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            if (newNode.getNext() == null) {
                tail = newNode;
            }
        }
        size++;
        modCount++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException  {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
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
        T oldElement = currentNode.getElement();
        currentNode.setElement(element);
        if (element == null) {
            if (currentNode != tail) {
                if (previousNode != null)
                    previousNode.setNext(currentNode.getNext());
                else
                    head = currentNode.getNext();
                if (currentNode.getNext() == null)
                    tail = previousNode;
                tail.setNext(currentNode);
                currentNode.setNext(null);
                tail = currentNode;
            }
        } else {
            LinearNode<T> insertPreviousNode = null;
            LinearNode<T> insertCurrentNode = head;
            while (insertCurrentNode != null && (insertCurrentNode.getElement() == null
                    || ((Comparable<T>) element).compareTo(insertCurrentNode.getElement()) > 0)) {
                insertPreviousNode = insertCurrentNode;
                insertCurrentNode = insertCurrentNode.getNext();
            }
            if (currentNode.getNext() != insertCurrentNode) {
                if (previousNode != null)
                    previousNode.setNext(currentNode.getNext());
                else
                    head = currentNode.getNext();
                if (currentNode.getNext() == null)
                    tail = previousNode;
                currentNode.setNext(insertCurrentNode);
                if (insertPreviousNode != null)
                    insertPreviousNode.setNext(currentNode);
                else
                    head = currentNode;
                if (currentNode.getNext() == null)
                    tail = currentNode;
            }
        }
        modCount++;
        return oldElement;
    }
}
