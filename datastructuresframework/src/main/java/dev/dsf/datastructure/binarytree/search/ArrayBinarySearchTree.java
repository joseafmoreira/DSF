package dev.dsf.datastructure.binarytree.search;

import dev.dsf.abstractdatatype.binarytree.BinarySearchTreeADT;
import dev.dsf.datastructure.binarytree.ArrayBinaryTree;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Resizable-array implementation of the {@code BinarySearchTreeADT} interface.
 * 
 * <h3>ArrayBinarySearchTree</h3>
 * 
 * @param <T> the type of element stored in this binary tree
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {
    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException   {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T element) {
        if (element == null)
            throw new NullPointerException("Element is null");
        Comparable<T> comparableElement = (Comparable<T>) element;
        int index = 0;
        if (isEmpty())
            list.addFirst(element);
        else {
            while (true) {
                index = index * 2 + (comparableElement.compareTo(list.get(index)) <= 0 ? 1 : 2);
                if (list.get(index) == null) {
                    list.set(index, element);
                    break;
                }
            }
        }
        while (list.size() < index * 2 + 3)
            list.addLast(null);
        size++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T findMin() {
        if (isEmpty())
            throw new EmptyCollectionException("Binary tree is empty");
        int index = 0;
        while (list.get(index * 2 + 1) != null)
            index = index * 2 + 1;
        return list.get(index);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T findMax() {
        if (isEmpty())
            throw new EmptyCollectionException("Binary tree is empty");
        int index = 0;
        while (list.get(index * 2 + 2) != null)
            index = index * 2 + 2;
        return list.get(index);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the specified target is null
     * @throws ClassCastException   if the specified element isn't comparable
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");
        if (isEmpty())
            return false;
        int index = 0;
        Comparable<T> comparableTarget = (Comparable<T>) target;
        while (list.get(index) != null) {
            T element = list.get(index);
            int compareTo = comparableTarget.compareTo(element);
            if (compareTo == 0)
                return true;
            else
                index = index * 2 + (compareTo < 0 ? 1 : 2);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException     {@inheritDoc}
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");
        if (isEmpty())
            throw new EmptyCollectionException("Binary tree is empty");
        Comparable<T> comparableTarget = (Comparable<T>) target;
        int currentIndex = 0;
        while (currentIndex < list.size() && list.get(currentIndex) != null) {
            int comparison = comparableTarget.compareTo(list.get(currentIndex));
            if (comparison == 0) {
                int replacementIndex = replacement(currentIndex);
                remove(currentIndex, replacementIndex);
                return true;
            } else
                currentIndex = currentIndex * 2 + (comparison < 0 ? 1 : 2);
        }
        return false;
    }

    /**
     * Removes the element at the specified index, adjusting the binary search tree
     * structure.
     *
     * @param currentIndex     index of the element to remove
     * @param replacementIndex index of the replacement node, or -1 if none
     */
    private void remove(int currentIndex, int replacementIndex) {
        if (replacementIndex == -1)
            list.set(currentIndex, null);
        else {
            list.set(currentIndex, list.get(replacementIndex));
            shiftSubtree(replacementIndex);
        }
        size--;
    }

    /**
     * Determines the index of the replacement node following binary search tree
     * rules.
     *
     * @param index node index to replace
     * @return replacement node index or -1 if none
     */
    private int replacement(int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if (getElement(leftIndex) == null && getElement(rightIndex) == null)
            return -1;
        if (getElement(leftIndex) != null && getElement(rightIndex) == null)
            return leftIndex;
        if (getElement(leftIndex) == null && getElement(rightIndex) != null)
            return rightIndex;
        int parentIndex = rightIndex;
        int successorIndex = rightIndex;
        while (getElement(successorIndex * 2 + 1) != null) {
            parentIndex = successorIndex;
            successorIndex = successorIndex * 2 + 1;
        }
        if (successorIndex != rightIndex)
            list.set(parentIndex * 2 + 1, list.get(successorIndex * 2 + 2));
        return successorIndex;
    }

    /**
     * Shifts the subtree upwards from the specified index, preserving BST order.
     *
     * @param index index of the node to shift
     */
    private void shiftSubtree(int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        if (getElement(leftIndex) != null) {
            list.set(index, list.get(leftIndex));
            shiftSubtree(leftIndex);
        } else if (getElement(rightIndex) != null) {
            list.set(index, list.get(rightIndex));
            shiftSubtree(rightIndex);
        } else
            list.set(index, null);
    }

    /**
     * Utility method to get an element safely.
     *
     * @param index the specified index of the element
     * @return the element at the specified index or null if index is out of range
     */
    private T getElement(int index) {
        return (index >= 0 && index < list.size()) ? list.get(index) : null;
    }
}
