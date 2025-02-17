package dev.dsf.node;

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
 * <li>{@link #BinaryTreeNode(Object, int)}: Constructs a node with an
 * element and an empty array of pointers with a specified size</li>
 * <li>{@link #BinaryTreeNode(Object, Node...)}: Constructs a node with an
 * element and an array of pointers</li>
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
 * @see HeapNode
 */
public class BinaryTreeNode<T> extends Node<T> {
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
        super(element, 2);
    }

    /**
     * Constructs a binary tree node with an element, a reference to the left
     * binary tree node and a reference to the right binary tree node.
     * 
     * @param element the element to be stored in this binary tree node
     * @param left    the reference of the left binary tree node
     * @param right   the reference of the right binary tree node
     */
    @SuppressWarnings("unchecked")
    public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        super(element, left, right);
    }

    /**
     * Constructs a node with an element and an empty array of pointers with
     * a specified size.
     * 
     * @param element   the element to be stored in this node
     * @param nPointers the number of elements to be stored in this node's
     *                  pointers array
     */
    protected BinaryTreeNode(T element, int nPointers) {
        super(element, nPointers);
    }

    /**
     * Constructs a node with an element and an array of pointers.
     * 
     * @param element  the element to be stored in this node
     * @param pointers the pointers to be stored in this node's pointers
     *                 array
     */
    @SuppressWarnings("unchecked")
    protected BinaryTreeNode(T element, Node<T>... pointers) {
        super(element, pointers);
    }

    /**
     * Returns the reference stored in this binary tree node left pointer.
     * 
     * @return the reference stored in this binary tree node left pointer
     */
    public BinaryTreeNode<T> getLeft() {
        return (BinaryTreeNode<T>) pointers[0];
    }

    /**
     * Sets the reference stored in this binary tree node left pointer.
     * 
     * @param left the reference to be stored in this binary tree node left
     *             pointer
     */
    public void setLeft(BinaryTreeNode<T> left) {
        pointers[0] = left;
    }

    /**
     * Returns the reference stored in this binary tree node right pointer.
     * 
     * @return the reference stored in this binary tree node right pointer
     */
    public BinaryTreeNode<T> getRight() {
        return (BinaryTreeNode<T>) pointers[1];
    }

    /**
     * Sets the reference stored in this binary tree node right pointer.
     * 
     * @param right the reference to be stored in this binary tree node right
     *              pointer
     */
    public void setRight(BinaryTreeNode<T> right) {
        pointers[1] = right;
    }
}
