package dev.dsf.datastructure.binarytree.heap.min;

import dev.dsf.abstractdatatype.binarytree.MinHeapADT;
import dev.dsf.datastructure.binarytree.heap.LinkedHeap;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.HeapNode;

/**
 * Linked implementation of the {@code MinHeapADT} interface.
 * 
 * <h3>LinkedMinHeap</h3>
 * 
 * @param <T> the type of element stored in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedMinHeap<T> extends LinkedHeap<T> implements MinHeapADT<T> {
    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException   {@inheritDoc}
     */
    @Override
    public void add(T element) {
        if (element == null)
            throw new NullPointerException("Element is null");
        HeapNode<T> newNode = new HeapNode<T>(element);
        if (root == null)
            root = newNode;
        else {
            HeapNode<T> nextParent = getNextParent();
            if (nextParent.getLeft() == null)
                nextParent.setLeft(newNode);
            else
                nextParent.setRight(newNode);
            newNode.setParent(nextParent);
        }
        lastNode = newNode;
        size++;
        if (size() > 1)
            heapifyAdd();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T removeMin() {
        T result = findMin();
        if (size() == 1) {
            root = null;
            lastNode = null;
        } else {
            HeapNode<T> newLastNode = getNewLastNode();
            if (lastNode.getParent().getLeft() == lastNode)
                lastNode.getParent().setLeft(null);
            else
                lastNode.getParent().setRight(null);
            root.setElement(lastNode.getElement());
            lastNode = newLastNode;
            heapifyRemove();
        }
        size--;
        return result;
    }

    /**
     * Performs heapify operation after adding a new element to the min-heap.
     * This method ensures that the heap property is maintained by comparing the new
     * element with its parent.
     * If the new element is smaller than its parent, it is swapped with its parent
     * and the process is repeated until the heap property is satisfied.
     * 
     * @throws ClassCastException if the element isn't comparable
     */
    @SuppressWarnings("unchecked")
    private void heapifyAdd() {
        HeapNode<T> nextNode = lastNode;
        T temp = nextNode.getElement();
        while (nextNode != root && ((Comparable<T>) temp).compareTo(nextNode.getParent().getElement()) < 0) {
            nextNode.setElement(nextNode.getParent().getElement());
            nextNode = nextNode.getParent();
        }
        nextNode.setElement(temp);
    }

    /**
     * Performs the heapify operation after removing an element from this min-heap.
     * This operation ensures that the min-heap property is maintained by moving
     * elements down this min-heap.
     */
    @SuppressWarnings("unchecked")
    private void heapifyRemove() {
        T temp;
        HeapNode<T> currentNode = (HeapNode<T>) root;
        HeapNode<T> leftNode = currentNode.getLeft();
        HeapNode<T> rightNode = currentNode.getRight();
        HeapNode<T> nextNode;
        if (leftNode == null && rightNode == null)
            nextNode = null;
        else if (leftNode == null)
            nextNode = rightNode;
        else if (rightNode == null)
            nextNode = leftNode;
        else if (((Comparable<T>) leftNode.getElement()).compareTo(rightNode.getElement()) < 0)
            nextNode = leftNode;
        else
            nextNode = rightNode;
        temp = currentNode.getElement();
        while (nextNode != null && ((Comparable<T>) nextNode.getElement()).compareTo(temp) < 0) {
            currentNode.setElement(nextNode.getElement());
            currentNode = nextNode;
            leftNode = currentNode.getLeft();
            rightNode = currentNode.getRight();
            if (leftNode == null && rightNode == null)
                nextNode = null;
            else if (leftNode == null)
                nextNode = rightNode;
            else if (rightNode == null)
                nextNode = leftNode;
            else if (((Comparable<T>) leftNode.getElement()).compareTo(rightNode.getElement()) < 0)
                nextNode = leftNode;
            else
                nextNode = rightNode;
        }
        currentNode.setElement(temp);
    }
}
