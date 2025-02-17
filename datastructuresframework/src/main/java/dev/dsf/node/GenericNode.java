package dev.dsf.node;

/**
 * A generic node is an auxiliary object used to implement a linked data
 * structure.
 * <p>
 * It contains an element and an array of pointers to other nodes.
 * <p>
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #GenericNode()}: Constructs an empty generic node</li>
 * <li>{@link #GenericNode(Object)}: Constructs a generic node with an
 * element</li>
 * <li>{@link #GenericNode(Object, int)}: Constructs a generic node with an
 * element and an empty array of pointers with a specified size</li>
 * <li>{@link #GenericNode(Object, GenericNode...)}: Constructs a generic node
 * with an element and an array of pointers</li>
 * </ul>
 * 
 * The operations for this {@code Node} include:
 * <p>
 * <ul>
 * <li>{@link #getPointer(int)}: Returns the pointer stored in a specified index
 * of this generic node's pointers array</li>
 * <li>{@link #setPointer(int, GenericNode)}: Sets the pointer in a specified
 * index of
 * this generic node's pointers array</li>
 * </ul>
 * 
 * <h3>GenericNode</h3>
 * 
 * @param <T> the type of element stored in this node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class GenericNode<T> extends Node<T> {
    /**
     * Constructs an empty generic node.
     */
    public GenericNode() {
        this(null);
    }

    /**
     * Constructs a generic node with an element.
     * 
     * @param element the element to be stored in this node
     */
    public GenericNode(T element) {
        this(element, 0);
    }

    /**
     * Constructs a generic node with an element and an empty array of pointers with
     * a specified size.
     * 
     * @param element   the element to be stored in this generic node
     * @param nPointers the number of elements to be stored in this generic node's
     *                  pointers array
     */
    public GenericNode(T element, int nPointers) {
        super(element, nPointers);
    }

    /**
     * Constructs a generic node with an element and an array of pointers.
     * 
     * @param element  the element to be stored in this generic node
     * @param pointers the pointers to be stored in this generic node's pointers
     *                 array
     */
    @SuppressWarnings("unchecked")
    public GenericNode(T element, GenericNode<T>... pointers) {
        super(element, pointers);
    }

    /**
     * Returns the pointer stored in a specified index of this generic node's
     * pointers array.
     * 
     * @param index the specified index
     * @return the pointer stored in a specified index of this generic node's
     *         pointers array
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= pointers.length})
     */
    public GenericNode<T> getPointer(int index) {
        if (index < 0 || index >= pointers.length)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        return (GenericNode<T>) pointers[index];
    }

    /**
     * Sets the pointer in a specified index of this generic node's pointers array.
     * 
     * @param index   the specified index
     * @param pointer the pointer to set at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= pointers.length})
     */
    public void setPointer(int index, GenericNode<T> pointer) {
        if (index < 0 || index >= pointers.length)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        pointers[index] = pointer;
    }
}
