package dev.dsf.node;

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
 * <li>{@link #HeapNode(Object, int)}: Constructs a node with an
 * element and an empty array of pointers with a specified size</li>
 * <li>{@link #HeapNode(Object, Node...)}: Constructs a node with an
 * element and an array of pointers</li>
 * </ul>
 * 
 * The operations for this {@code HeapNode} include:
 * <p>
 * <ul>
 * <li>{@link #getLeft()}: Returns the reference stored in this heap node left
 * pointer</li>
 * <li>{@link #setLeft(HeapNode)}: Sets the reference stored in this heap
 * node left pointer</li>
 * <li>{@link #getRight()}: Returns the reference stored in this heap right
 * pointer</li>
 * <li>{@link #setRight(HeapNode)}: Sets the reference stored in this heap
 * node right pointer</li>
 * <li>{@link #getParent()}: Returns the reference stored in this heap node
 * parent pointer</li>
 * <li>{@link #setParent(HeapNode)}: Sets the reference stored in this heap
 * node parent pointer</li>
 * </ul>
 * 
 * <h3>HeapNode</h3>
 * 
 * @param <T> the type of element stored in this heap node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class HeapNode<T> extends BinaryTreeNode<T> {
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
        super(element, 3);
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
    @SuppressWarnings("unchecked")
    public HeapNode(T element, HeapNode<T> left, HeapNode<T> right, HeapNode<T> parent) {
        super(element, left, right, parent);
    }

    /**
     * Constructs a node with an element and an empty array of pointers with
     * a specified size.
     * 
     * @param element   the element to be stored in this node
     * @param nPointers the number of elements to be stored in this node's
     *                  pointers array
     */
    protected HeapNode(T element, int nPointers) {
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
    protected HeapNode(T element, Node<T>... pointers) {
        super(element, pointers);
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

    /**
     * Returns the reference stored in this heap node parent pointer.
     * 
     * @return the reference stored in this heap node parent pointer
     */
    public HeapNode<T> getParent() {
        return (HeapNode<T>) pointers[2];
    }

    /**
     * Sets the reference stored in this heap node parent pointer.
     * 
     * @param parent the reference to be stored in this heap node parent pointer
     */
    public void setParent(HeapNode<T> parent) {
        pointers[2] = parent;
    }
}
