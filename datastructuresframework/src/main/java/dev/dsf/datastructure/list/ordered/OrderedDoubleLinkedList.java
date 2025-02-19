package dev.dsf.datastructure.list.ordered;

import dev.dsf.abstractdatatype.OrderedListADT;
import dev.dsf.datastructure.list.DoubleLinkedList;

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
}
