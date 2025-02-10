package dev.dsf.datastructure.binarytree.search;

import java.util.Iterator;

import dev.dsf.abstractdatatype.BinarySearchTreeADT;
import dev.dsf.datastructure.binarytree.LinkedBinaryTree;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.BinaryTreeNode;

/**
 * Linked implementation of the {@code BinarySearchTreeADT} interface
 * using the {@code LinkedBinaryTree} class as a base code.
 * 
 * <h3>LinkedBinarySearchTree</h3>
 * 
 * @param <T> the type of element stored in this binary tree
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {
    /**
     * Constructs an empty binary search tree.
     */
    public LinkedBinarySearchTree() {
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
        BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(element);
        if (isEmpty())
            root = newNode;
        else {
            BinaryTreeNode<T> currentNode = root;
            while (true) {
                if (comparableElement.compareTo(currentNode.getElement()) <= 0) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        break;
                    } else
                        currentNode = currentNode.getLeft();
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        break;
                    } else
                        currentNode = currentNode.getRight();
                }
            }
        }
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
        BinaryTreeNode<T> currentNode = root;
        while (currentNode.getLeft() != null)
            currentNode = currentNode.getLeft();
        return currentNode.getElement();
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
        BinaryTreeNode<T> currentNode = root;
        while (currentNode.getRight() != null)
            currentNode = currentNode.getRight();
        return currentNode.getElement();
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
        BinaryTreeNode<T> currentNode = root;
        Comparable<T> comparableTarget = (Comparable<T>) target;
        while (currentNode != null) {
            int compareTo = comparableTarget.compareTo(currentNode.getElement());
            if (compareTo == 0)
                return true;
            else if (compareTo < 0)
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
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
        if (comparableTarget.equals(root.getElement())) {
            root = replacement(root);
            size--;
            hasRemoved = true;
        } else {
            BinaryTreeNode<T> parentNode = root;
            BinaryTreeNode<T> currentNode = (comparableTarget.compareTo(parentNode.getElement()) <= 0)
                    ? parentNode.getLeft()
                    : parentNode.getRight();
            while (currentNode != null) {
                if (comparableTarget.equals(currentNode.getElement())) {
                    if (currentNode == parentNode.getLeft())
                        parentNode.setLeft(replacement(currentNode));
                    else
                        parentNode.setRight(replacement(currentNode));
                    size--;
                    hasRemoved = true;
                    break;
                } else {
                    parentNode = currentNode;
                    currentNode = (comparableTarget.compareTo(parentNode.getElement()) <= 0) ? parentNode.getLeft()
                            : parentNode.getRight();
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
     * Returns the replacement node for the given node in this binary search tree.
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
     * @param node the node for which to find the replacement node
     * @return the replacement node for the given node
     */
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        if (node.getLeft() == null && node.getRight() == null)
            return null;
        BinaryTreeNode<T> result;
        if (node.getLeft() != null && node.getRight() == null)
            result = node.getLeft();
        else if (node.getLeft() == null && node.getRight() != null)
            result = node.getRight();
        else {
            BinaryTreeNode<T> currentNode = node.getRight();
            BinaryTreeNode<T> parentNode = node;
            while (currentNode.getLeft() != null) {
                parentNode = currentNode;
                currentNode = currentNode.getLeft();
            }
            if (node.getRight() == currentNode)
                currentNode.setLeft(node.getLeft());
            else {
                parentNode.setLeft(currentNode.getRight());
                currentNode.setRight(node.getRight());
                currentNode.setLeft(node.getLeft());
            }
            result = currentNode;
        }
        return result;
    }
}
