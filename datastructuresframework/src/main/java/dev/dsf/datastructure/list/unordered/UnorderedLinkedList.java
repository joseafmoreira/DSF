package dev.dsf.datastructure.list.unordered;

import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.algorithm.sort.MergeSort;
import dev.dsf.datastructure.list.LinkedList;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Singly-linked list implementation of the {@code UnorderedListADT} interface
 * using the {@code LinkedList} abstract class as a base code.
 * 
 * <h3>UnorderedLinkedList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class UnorderedLinkedList<T> extends LinkedList<T> implements UnorderedListADT<T> {
    /**
     * Constructs an empty unordered linked list.
     */
    public UnorderedLinkedList() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        LinearNode<T> newNode = new LinearNode<>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            if (tail == null)
                tail = newNode;
        } else {
            LinearNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++)
                currentNode = currentNode.getNext();
            newNode.setNext(currentNode.getNext());
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
    @Override
    public T set(int index, T element) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        LinearNode<T> currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.getNext();
        T result = currentNode.getElement();
        currentNode.setElement(element);
        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws ClassCastException {@inheritDoc}
     */
    @Override
    public void sort() {
        T[] array = MergeSort.sort(this);
        int i = 0;
        LinearNode<T> currentNode = head;
        while (currentNode != null) {
            currentNode.setElement(array[i++]);
            currentNode = currentNode.getNext();
        }
    }
}
