package dev.dsf.datastructure.binarytree;

import java.util.Iterator;

import dev.dsf.abstractdatatype.BinaryTreeADT;
import dev.dsf.abstractdatatype.QueueADT;
import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.datastructure.binarytree.search.LinkedBinarySearchTree;
import dev.dsf.datastructure.collection.AbstractIterableCollection;
import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;
import dev.dsf.datastructure.queue.LinkedQueue;
import dev.dsf.exception.EmptyCollectionException;
import dev.dsf.node.Node;

/**
 * Linked implementation of the {@code BinaryTreeADT} interface.
 * 
 * <h3>LinkedBinaryTree</h3>
 * 
 * @param <T> the type of element stored in this binary tree
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see LinkedBinarySearchTree
 * @see LinkedHeap
 */
public abstract class LinkedBinaryTree<T> extends AbstractIterableCollection<T> implements BinaryTreeADT<T> {
    /**
     * The root node of this binary tree
     */
    protected BinaryTreeNode<T> root;

    /**
     * Constructs an empty binary tree
     */
    protected LinkedBinaryTree() {
        super();
        root = null;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T getRoot() {
        if (isEmpty())
            throw new EmptyCollectionException("Binary tree is empty");
        return root.getElement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        super.clear();
        root = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        preOrder(root, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        inOrder(root, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        postOrder(root, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        QueueADT<BinaryTreeNode<T>> queue = new LinkedQueue<>();
        if (!isEmpty())
            queue.enqueue(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> currentNode = queue.dequeue();
            list.addLast(currentNode.getElement());
            if (currentNode.getLeft() != null)
                queue.enqueue(currentNode.getLeft());
            if (currentNode.getRight() != null)
                queue.enqueue(currentNode.getRight());
        }
        return list.iterator();
    }

    /**
     * Performs a pre-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentNode the current node being visited
     * @param list        the list to add the elements to
     */
    private void preOrder(BinaryTreeNode<T> currentNode, UnorderedListADT<T> list) {
        if (currentNode == null)
            return;
        list.addLast(currentNode.getElement());
        preOrder(currentNode.getLeft(), list);
        preOrder(currentNode.getRight(), list);
    }

    /**
     * Performs an in-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentNode the current node being visited
     * @param list        the list to add the elements to
     */
    private void inOrder(BinaryTreeNode<T> currentNode, UnorderedListADT<T> list) {
        if (currentNode == null)
            return;
        inOrder(currentNode.getLeft(), list);
        list.addLast(currentNode.getElement());
        inOrder(currentNode.getRight(), list);
    }

    /**
     * Performs a post-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentNode   the current node being visited
     * @param unorderedList the list to add the elements to
     */
    private void postOrder(BinaryTreeNode<T> currentNode, UnorderedListADT<T> list) {
        if (currentNode == null)
            return;
        postOrder(currentNode.getLeft(), list);
        postOrder(currentNode.getRight(), list);
        list.addLast(currentNode.getElement());
    }

    /**
     * A binary tree node is an auxiliary object used to implement a linked binary
     * tree data structure.
     * <p>
     * It contains an element, a pointer to the left binary tree node and a pointer
     * to the right binary tree node.
     * <p>
     * 
     * The available constructors are the following:
     * <p>
     * <ul>
     * <li>{@link #BinaryTreeNode()}: Constructs an empty binary tree node</li>
     * <li>{@link #BinaryTreeNode(Object)}: Constructs a binary tree node with an
     * element</li>
     * <li>{@link #BinaryTreeNode(Object, BinaryTreeNode, BinaryTreeNode)}:
     * Constructs a binary tree node with an element, a reference to the left binary
     * tree node and a reference to the right binary tree</li>
     * </ul>
     * 
     * The operations for this {@code BinaryTreeNode} include:
     * <p>
     * <ul>
     * <li>{@link #getLeft()}: Returns the reference stored in this binary tree node
     * left pointer</li>
     * <li>{@link #setLeft(BinaryTreeNode)}: Sets the reference stored in this
     * binary tree node left pointer</li>
     * <li>{@link #getRight()}: Returns the reference stored in this binary tree
     * node right pointer</li>
     * <li>{@link #setRight(BinaryTreeNode)}: Sets the reference stored in this
     * binary tree node right pointer</li>
     * </ul>
     * 
     * <h3>BinaryTreeNode</h3>
     * 
     * @param <T> the type of element stored in this binary tree node
     * @since 1.0
     * @version 1.0
     * @author joseafmoreira
     */
    protected static class BinaryTreeNode<T> extends Node<T> {
        /**
         * The reference to the left node
         */
        protected BinaryTreeNode<T> left;
        /**
         * The reference to the right node
         */
        protected BinaryTreeNode<T> right;

        /**
         * Constructs an empty binary tree node.
         */
        public BinaryTreeNode() {
            this(null);
        }

        /**
         * Constructs a binary tree node with an element.
         * 
         * @param element the element to be stored in this binary tree node
         */
        public BinaryTreeNode(T element) {
            this(element, null, null);
        }

        /**
         * Constructs a binary tree node with an element, a reference to the left
         * binary tree node and a reference to the right binary tree node.
         * 
         * @param element the element to be stored in this binary tree node
         * @param left    the reference of the left binary tree node
         * @param right   the reference of the right binary tree node
         */
        public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
            super(element);
            setLeft(left);
            setRight(right);
        }

        /**
         * Returns the reference stored in this binary tree node left pointer.
         * 
         * @return the reference stored in this binary tree node left pointer
         */
        public BinaryTreeNode<T> getLeft() {
            return left;
        }

        /**
         * Sets the reference stored in this binary tree node left pointer.
         * 
         * @param left the reference to be stored in this binary tree node left
         *             pointer
         */
        public void setLeft(BinaryTreeNode<T> left) {
            this.left = left;
        }

        /**
         * Returns the reference stored in this binary tree node right pointer.
         * 
         * @return the reference stored in this binary tree node right pointer
         */
        public BinaryTreeNode<T> getRight() {
            return right;
        }

        /**
         * Sets the reference stored in this binary tree node right pointer.
         * 
         * @param right the reference to be stored in this binary tree node right
         *              pointer
         */
        public void setRight(BinaryTreeNode<T> right) {
            this.right = right;
        }
    }
}
