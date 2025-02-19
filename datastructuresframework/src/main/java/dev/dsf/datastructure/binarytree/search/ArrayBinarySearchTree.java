package dev.dsf.datastructure.binarytree.search;

import dev.dsf.abstractdatatype.BinarySearchTreeADT;
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
        if (comparableTarget.equals(list.get(0))) {
            remove(0, replacement(0));
            return true;
        } else {
            int parentIndex = 0;
            int currentIndex = parentIndex * 2 +
                    (comparableTarget.compareTo(list.get(parentIndex)) <= 0 ? 1 : 2);
            while (currentIndex < list.size() && list.get(currentIndex) != null) {
                if (comparableTarget.equals(list.get(currentIndex))) {
                    remove(currentIndex, replacement(currentIndex));
                    return true;
                } else {
                    parentIndex = currentIndex;
                    currentIndex = parentIndex * 2 +
                            (comparableTarget.compareTo(list.get(parentIndex)) <= 0 ? 1 : 2);
                }
            }
        }
        return false;
    }

    /**
     * Removes the element at the specified index in this binary search tree.
     * <p>
     * If the replacement index is -1, the element at the current index is set to
     * null.
     * Otherwise, the element at the current index is replaced with the element at
     * the replacement index.
     * If the replacement index is the right child of the current index, the
     * replacement index is shifted.
     * <p>
     * The size of this binary tree is decremented by one.
     *
     * @param currentIndex     the index of the element to be removed
     * @param replacementIndex the index of the replacement element, or -1 if there
     *                         is no replacement
     */
    private void remove(int currentIndex, int replacementIndex) {
        if (replacementIndex == -1)
            list.set(currentIndex, null);
        else {
            list.set(currentIndex, list.get(replacementIndex));
            if (replacementIndex == currentIndex * 2 + 2)
                shift(replacementIndex);
        }
        size--;
    }

    /**
     * Returns the the index of the node to replace the node in the specified index
     * in this binary search tree.
     * The replacement node is determined based on the following rules:
     * - If the given node has no left child and no right child, the replacement
     * node is null.
     * - If the given node has a left child but no right child, the replacement node
     * is the left child.
     * - If the given node has no left child but a right child, the replacement node
     * is the right child.
     * - If the given node has both left and right children, the replacement node is
     * the leftmost node in the right subtree.
     * If the leftmost node in the right subtree is the right child of the given
     * node, the replacement node is set to have the left child of the given node.
     * Otherwise, the replacement node is set to have the right child of its parent,
     * the right child of the given node, and the left child of the given node.
     *
     * @param index the index of the node
     * @return the index of the node to replace the node in the specified index, or
     *         -1 if there's no replacement available
     */
    private int replacement(int index) {
        if (list.get(index * 2 + 1) == null && list.get(index * 2 + 2) == null)
            return -1;
        if (list.get(index * 2 + 1) != null && list.get(index * 2 + 2) == null)
            return index * 2 + 1;
        if (list.get(index * 2 + 1) == null && list.get(index * 2 + 2) != null)
            return index * 2 + 2;
        int parentIndex = index;
        int currentIndex = index * 2 + 2;
        while (list.get(currentIndex * 2 + 1) != null) {
            parentIndex = currentIndex;
            currentIndex = currentIndex * 2 + 1;
        }
        if (currentIndex != index * 2 + 2) {
            list.set(parentIndex * 2 + 1, list.get(currentIndex * 2 + 2));
            list.set(currentIndex * 2 + 1, list.get(index * 2 + 1));
            list.set(currentIndex * 2 + 2, list.get(index * 2 + 2));
        }
        return currentIndex;
    }

    /**
     * Shifts elements to maintain the binary search tree properties after a
     * replacement.
     * 
     * @param index the index of the node to be shifted
     */
    private void shift(int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if (leftIndex < list.size() && list.get(leftIndex) != null) {
            list.set(index, list.get(leftIndex));
            shift(leftIndex);
        } else if (rightIndex < list.size() && list.get(rightIndex) != null) {
            list.set(index, list.get(rightIndex));
            shift(rightIndex);
        } else
            list.set(index, null);
    }
}
