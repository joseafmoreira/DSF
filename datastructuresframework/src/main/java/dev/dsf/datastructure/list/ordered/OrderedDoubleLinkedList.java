package dev.dsf.datastructure.list.ordered;

import dev.dsf.abstractdatatype.OrderedListADT;
import dev.dsf.datastructure.list.DoubleLinkedList;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.DoubleLinearNode;

/**
 * Doubly-linked list implementation of the {@code OrderedListADT} interface
 * using the {@code DoubleLinkedList} abstract class as a base code.
 * 
 * <h3>OrderedDoubleLinkedList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
    /**
     * Constructs an empty ordered double linked list.
     */
    public OrderedDoubleLinkedList() {
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
        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (element == null) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else if (head.getElement() == null || ((Comparable<T>) element).compareTo(head.getElement()) <= 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else {
            DoubleLinearNode<T> currentNode = head;
            while (currentNode.getNext() != null && (currentNode.getNext().getElement() == null
                    || ((Comparable<T>) element).compareTo(currentNode.getNext().getElement()) > 0))
                currentNode = currentNode.getNext();
            newNode.setNext(currentNode.getNext());
            newNode.setPrev(currentNode);
            if (currentNode.getNext() != null)
                currentNode.getNext().setPrev(newNode);
            currentNode.setNext(newNode);
            if (newNode.getNext() == null)
                tail = newNode;
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
        DoubleLinearNode<T> currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.getNext();
        T oldElement = currentNode.getElement();
        currentNode.setElement(element);
        if (element == null) {
            if (currentNode != tail) {
                if (currentNode.getPrev() != null)
                    currentNode.getPrev().setNext(currentNode.getNext());
                else
                    head = currentNode.getNext();
                if (currentNode.getNext() != null)
                    currentNode.getNext().setPrev(currentNode.getPrev());
                tail.setNext(currentNode);
                currentNode.setPrev(tail);
                currentNode.setNext(null);
                tail = currentNode;
            }
        } else {
            DoubleLinearNode<T> prevNode = currentNode.getPrev();
            DoubleLinearNode<T> nextNode = currentNode.getNext();
            while (nextNode != null && (nextNode.getElement() == null || ((Comparable<T>) element).compareTo(nextNode.getElement()) > 0)) {
                prevNode = nextNode;
                nextNode = nextNode.getNext();
            }
            while (prevNode != null && prevNode.getElement() != null && ((Comparable<T>) element).compareTo(prevNode.getElement()) < 0) {
                nextNode = prevNode;
                prevNode = prevNode.getPrev();
            }
            if (currentNode.getNext() != nextNode) {
                if (currentNode.getPrev() != null)
                    currentNode.getPrev().setNext(currentNode.getNext());
                else
                    head = currentNode.getNext();
                if (currentNode.getNext() != null)
                    currentNode.getNext().setPrev(currentNode.getPrev());
                currentNode.setNext(nextNode);
                currentNode.setPrev(prevNode);
                if (prevNode != null)
                    prevNode.setNext(currentNode);
                else
                    head = currentNode;
                if (nextNode != null)
                    nextNode.setPrev(currentNode);
                else
                    tail = currentNode;
            }
        }
        modCount++;
        return oldElement;
    }
}
