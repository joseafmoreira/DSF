package dev.dsf.node;

/**
 * A double linear node is an auxiliary object used to implement a doubly linked
 * data structure.
 * <p>
 * It contains an {@code #element}, a pointer to the {@code #next} double linear
 * node and a pointer to the {@code #prev} double linear node.
 * <p>
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #DoubleLinearNode()}: Constructs an empty double linear node</li>
 * <li>{@link #DoubleLinearNode(Object)}: Constructs a double linear node with
 * an element</li>
 * <li>{@link #DoubleLinearNode(Object, DoubleLinearNode, DoubleLinearNode)}:
 * Constructs a double linear node with an
 * element, a reference to the next double linear node and a reference to the
 * prev double linear node</li>
 * <li>{@link #DoubleLinearNode(Object, int)}: Constructs a node with an
 * element and an empty array of pointers with a specified size</li>
 * <li>{@link #DoubleLinearNode(Object, Node...)}: Constructs a node with an
 * element and an array of pointers</li>
 * </ul>
 * 
 * The operations for this {@code DoubleLinearNode} include:
 * <p>
 * <ul>
 * <li>{@link #getNext()}: Returns the reference stored in this linear node next
 * pointer</li>
 * <li>{@link #setNext(DoubleLinearNode)}: Sets the reference stored in this
 * linear
 * node next pointer</li>
 * <li>{@link #getPrev()}: Returns the reference stored in this linear node prev
 * pointer</li>
 * <li>{@link #setPrev(DoubleLinearNode)}: Sets the reference stored in this
 * linear
 * node prev pointer</li>
 * </ul>
 * 
 * <h3>DoubleLinearNode</h3>
 * 
 * @param <T> the type of element stored in this double linear node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class DoubleLinearNode<T> extends LinearNode<T> {
    /**
     * Constructs an empty double linear node.
     */
    public DoubleLinearNode() {
        this(null);
    }

    /**
     * Constructs a double linear node with an element.
     * 
     * @param element the element to be stored in this double linear node
     */
    public DoubleLinearNode(T element) {
        super(element, 2);
    }

    /**
     * Constructs a double linear node with an element, a reference to the next
     * double linear node and a reference to the prev double linear node.
     * 
     * @param element the element to be stored in this double linear node
     * @param next    the reference of the next double linear node
     * @param prev    the reference of the prev double linear node
     */
    @SuppressWarnings("unchecked")
    public DoubleLinearNode(T element, DoubleLinearNode<T> next, DoubleLinearNode<T> prev) {
        super(element, next, prev);
    }

    /**
     * Constructs a node with an element and an empty array of pointers with
     * a specified size.
     * 
     * @param element   the element to be stored in this node
     * @param nPointers the number of elements to be stored in this node's
     *                  pointers array
     */
    protected DoubleLinearNode(T element, int nPointers) {
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
    protected DoubleLinearNode(T element, Node<T>... pointers) {
        super(element, pointers);
    }

    /**
     * Returns the reference stored in this double linear node next pointer.
     * 
     * @return the reference stored in this double linear node next pointer
     */
    public DoubleLinearNode<T> getNext() {
        return (DoubleLinearNode<T>) super.getNext();
    }

    /**
     * Sets the reference stored in this double linear node next pointer.
     * 
     * @param next the reference to be stored in this double linear node next
     *             pointer
     */
    public void setNext(DoubleLinearNode<T> next) {
        super.setNext(next);
    }

    /**
     * Returns the reference stored in this double linear node prev pointer.
     * 
     * @return the reference stored in this double linear node prev pointer
     */
    public DoubleLinearNode<T> getPrev() {
        return (DoubleLinearNode<T>) pointers[1];
    }

    /**
     * Sets the reference stored in this double linear node prev pointer.
     * 
     * @param prev the reference to be stored in this double linear node prev
     *             pointer
     */
    public void setPrev(DoubleLinearNode<T> prev) {
        pointers[1] = prev;
    }
}
