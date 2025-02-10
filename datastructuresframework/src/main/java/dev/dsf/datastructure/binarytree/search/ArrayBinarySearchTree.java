package dev.dsf.datastructure.binarytree.search;

import java.util.Iterator;

import dev.dsf.abstractdatatype.BinarySearchTreeADT;
import dev.dsf.datastructure.binarytree.ArrayBinaryTree;
import dev.dsf.exception.EmptyCollectionException;

public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {
    /**
     * Constructs an empty binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
    }

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
            list.addLast(element);
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
        boolean hasRemoved = false;
        if (comparableTarget.equals(list.get(0))) {
            replacement(0, replacement(0));
            size--;
            hasRemoved = true;
        } else {
            int parentIndex = 0;
            int currentIndex = parentIndex * 2 + (comparableTarget.compareTo(list.get(parentIndex)) <= 0 ? 1 : 2);
            while (list.get(currentIndex) != null) {
                if (comparableTarget.equals(list.get(currentIndex))) {
                    replacement(parentIndex * 2 + (currentIndex == parentIndex * 2 + 1 ? 1 : 2),
                            replacement(currentIndex));
                    size--;
                    hasRemoved = true;
                    break;
                } else {
                    parentIndex = currentIndex;
                    currentIndex = parentIndex * 2 + (comparableTarget.compareTo(list.get(parentIndex)) <= 0 ? 1 : 2);
                }
            }
        }
        return hasRemoved;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return iteratorInOrder();
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
        int result;
        if (list.get(index * 2 + 1) != null && list.get(index * 2 + 2) == null)
            result = index * 2 + 1;
        else if (list.get(index * 2 + 1) == null && list.get(index * 2 + 2) != null)
            result = index * 2 + 2;
        else {
            int currentIndex = index * 2 + 2;
            int parentIndex = index;
            while (list.get(currentIndex * 2 + 1) != null) {
                parentIndex = currentIndex;
                currentIndex = currentIndex * 2 + 1;
            }
            if (index * 2 + 2 == currentIndex)
                replacement(currentIndex * 2 + 1, index * 2 + 1);
            else {
                replacement(parentIndex * 2 + 1, currentIndex * 2 + 2);
                replacement(currentIndex * 2 + 2, index * 2 + 2);
                replacement(currentIndex * 2 + 1, index * 2 + 1);
            }
            result = currentIndex;
        }
        return result;
    }

    /**
     * Replaces the element in the first index with the element in the second index
     * and sets the element in the second index to null.
     * 
     * @param index1 the first index
     * @param index2 the second index
     */
    private void replacement(int index1, int index2) {
        list.set(index1, (index2 == -1 ? null : list.get(index2)));
        if (index2 != -1)
            list.set(index2, null);
    }
}
