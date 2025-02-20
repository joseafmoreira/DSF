package dev.dsf.datastructure.list.ordered;

import dev.dsf.abstractdatatype.list.OrderedListADT;
import dev.dsf.datastructure.list.LinkedList;
import dev.dsf.node.LinearNode;

/**
 * Singly-linked list implementation of the {@code OrderedListADT} interface.
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
     * Constructs an empty list.
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
}
