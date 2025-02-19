package dev.dsf.datastructure.binarytree.heap.max;

import dev.dsf.abstractdatatype.MaxHeapADT;
import dev.dsf.datastructure.binarytree.heap.LinkedHeap;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.HeapNode;

/**
 * Linked implementation of the {@code MaxHeapADT} interface.
 * 
 * <h3>LinkedMaxHeap</h3>
 * 
 * @param <T> the type of element stored in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedMaxHeap<T> extends LinkedHeap<T> implements MaxHeapADT<T> {
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
    public T removeMax() {
        T result = findMax();
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
     * Performs heapify operation after adding a new element to the max-heap.
     * This method ensures that the max-heap property is maintained by comparing the new
     * element with its parent.
     * If the new element is bigger than its parent, it is swapped with its parent
     * and the process is repeated until the heap property is satisfied.
     */
    @SuppressWarnings("unchecked")
    private void heapifyAdd() {
        HeapNode<T> nextNode = lastNode;
        T temp = nextNode.getElement();
        while (nextNode != root && ((Comparable<T>) temp).compareTo(nextNode.getParent().getElement()) > 0) {
            nextNode.setElement(nextNode.getParent().getElement());
            nextNode = nextNode.getParent();
        }
        nextNode.setElement(temp);
    }

    /**
     * Performs the heapify operation after removing an element from this max-heap.
     * This operation ensures that the max-heap property is maintained by moving
     * elements down this max-heap.
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
        else if (((Comparable<T>) leftNode.getElement()).compareTo(rightNode.getElement()) > 0)
            nextNode = leftNode;
        else
            nextNode = rightNode;
        temp = currentNode.getElement();
        while (nextNode != null && ((Comparable<T>) nextNode.getElement()).compareTo(temp) > 0) {
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
            else if (((Comparable<T>) leftNode.getElement()).compareTo(rightNode.getElement()) > 0)
                nextNode = leftNode;
            else
                nextNode = rightNode;
        }
        currentNode.setElement(temp);
    }
}
