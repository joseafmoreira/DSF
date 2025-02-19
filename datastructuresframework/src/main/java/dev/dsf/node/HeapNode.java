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
 * <li>{@link #getRight()}: Returns the reference stored in this heap right
 * pointer</li>
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
        super(element, left, right);
        setParent(parent);
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
    @Override
    public HeapNode<T> getLeft() {
        return (HeapNode<T>) super.getLeft();
    }

    /**
     * Returns the reference stored in this heap node right pointer.
     * 
     * @return the reference stored in this heap node right pointer
     */
    @Override
    public HeapNode<T> getRight() {
        return (HeapNode<T>) super.getRight();
    }
}
