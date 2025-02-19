package dev.dsf.datastructure.binarytree.heap;

import dev.dsf.abstractdatatype.HeapADT;
import dev.dsf.datastructure.binarytree.LinkedBinaryTree;

/**
 * This class provides a skeletal implemetation for a linked-based
 * heap having all the common method implementations.
 * <p>
 * 
 * <h3>LinkedHeap</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see LinkedMinHeap
 * @see LinkedMaxHeap
 */
public abstract class LinkedHeap<T> extends LinkedBinaryTree<T> implements HeapADT<T> {
    /**
     * The reference to the last node added in this heap.
     */
    protected HeapNode<T> lastNode;

    /**
     * Constructs an empty heap.
     */
    protected LinkedHeap() {
        super();
        lastNode = null;
    }

    /**
     * Returns the next parent node where a new element can be added in this linked
     * min-heap.
     *
     * @return The next parent node where a new element can be added.
     */
    protected HeapNode<T> getNextParent() {
        HeapNode<T> result = lastNode;
        while (result != root && result.getParent().getLeft() != result)
            result = result.getParent();
        if (result != root) {
            if (result.getParent().getRight() == null)
                result = result.getParent();
            else {
                result = result.getParent().getRight();
                while (result.getLeft() != null)
                    result = result.getLeft();
            }
        } else
            while (result.getLeft() != null)
                result = result.getLeft();
        return result;
    }

    /**
     * Returns the new last node in this linked heap.
     *
     * @return the new last node in this linked heap
     */
    protected HeapNode<T> getNewLastNode() {
        HeapNode<T> result = lastNode;
        while (result != root && result.getParent().getLeft() == result)
            result = result.getParent();
        if (result != root)
            result = result.getParent().getLeft();
        while (result.getRight() != null)
            result = result.getRight();
        return result;
    }

    /**
     * A heap node is an auxiliary object used to implement a linked heap data
     * structure.
     * <p>
     * It contains an element, a pointer to the parent heap node, a pointer to the
     * left heap node and a pointer to the right heap node.
     * <p>
     * 
     * The available constructors are the following:
     * <p>
     * <ul>
     * <li>{@link #HeapNode()}: Constructs an empty heap node</li>
     * <li>{@link #HeapNode(Object)}: Constructs a heap node with an
     * element</li>
     * <li>{@link #HeapNode(Object, HeapNode, HeapNode, HeapNode)}:
     * Constructs a heap node with an element, a reference to the parent heap node,
     * a reference to the left heap node and a reference to the right heap node</li>
     * </ul>
     * 
     * The operations for this {@code HeapNode} include:
     * <p>
     * <ul>
     * <li>{@link #getParent()}: Returns the reference stored in this heap node
     * parent pointer</li>
     * <li>{@link #setParent(HeapNode)}: Sets the reference stored in this heap
     * node parent pointer</li>
     * <li>{@link #getLeft()}: Returns the reference stored in this heap node left
     * pointer</li>
     * <li>{@link #setLeft(HeapNode)}: Sets the reference stored in this heap
     * node left pointer</li>
     * <li>{@link #getRight()}: Returns the reference stored in this heap right
     * pointer</li>
     * <li>{@link #setRight(HeapNode)}: Sets the reference stored in this heap
     * node right pointer</li>
     * </ul>
     * 
     * <h3>HeapNode</h3>
     * 
     * @param <T> the type of element stored in this heap node
     * @since 1.0
     * @version 1.0
     * @author joseafmoreira
     */
    protected static class HeapNode<T> extends BinaryTreeNode<T> {
        /**
         * The reference to the parent node
         */
        protected HeapNode<T> parent;

        /**
         * Constructs an empty heap node.
         */
        public HeapNode() {
            this(null);
        }

        /**
         * Constructs a heap node with an element.
         * 
         * @param element the element to be stored in this heap node
         */
        public HeapNode(T element) {
            this(element, null, null, null);
        }

        /**
         * Constructs a heap node with an element, a reference to the parent heap node,
         * a reference to the left heap node and a reference to the right heap node.
         * 
         * @param element the element to be stored in this heap node
         * @param parent  the reference of the parent heap node
         * @param left    the reference of the left heap node
         * @param right   the reference of the right heap node
         */
        public HeapNode(T element, HeapNode<T> parent, HeapNode<T> left, HeapNode<T> right) {
            super(element);
            setParent(parent);
            setLeft(left);
            setRight(right);
        }

        /**
         * Returns the reference stored in this heap node parent pointer.
         * 
         * @return the reference stored in this heap node parent pointer
         */
        public HeapNode<T> getParent() {
            return parent;
        }

        /**
         * Sets the reference stored in this heap node parent pointer.
         * 
         * @param parent the reference to be stored in this heap node parent pointer
         */
        public void setParent(HeapNode<T> parent) {
            this.parent = parent;
        }

        /**
         * Returns the reference stored in this heap node left pointer.
         * 
         * @return the reference stored in this heap node left pointer
         */
        public HeapNode<T> getLeft() {
            return (HeapNode<T>) super.getLeft();
        }

        /**
         * Sets the reference stored in this heap node left pointer.
         * 
         * @param left the reference to be stored in this heap node left pointer
         */
        public void setLeft(HeapNode<T> left) {
            super.setLeft(left);
        }

        /**
         * Returns the reference stored in this heap node right pointer.
         * 
         * @return the reference stored in this heap node right pointer
         */
        public HeapNode<T> getRight() {
            return (HeapNode<T>) super.getRight();
        }

        /**
         * Sets the reference stored in this heap node right pointer.
         * 
         * @param right the reference to be stored in this heap node right pointer
         */
        public void setRight(HeapNode<T> right) {
            super.setRight(right);
        }
    }
}
