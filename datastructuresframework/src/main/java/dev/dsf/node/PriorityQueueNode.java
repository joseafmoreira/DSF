package dev.dsf.node;

/**
 * A priority queue node is an auxiliary object used to implement a priority
 * queue data structure.
 * <p>
 * It contains an element, a priority and an order.
 * <p>
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #PriorityQueueNode()}: Constructs an empty priority queue
 * node</li>
 * <li>{@link #PriorityQueueNode(Object)}: Constructs a priority queue node with
 * an element</li>
 * <li>{@link #PriorityQueueNode(Object, int)}: Constructs a priority queue node
 * with an element and a priority</li>
 * </ul>
 * 
 * The operations for this {@code MinPriorityQueueNode} include:
 * <p>
 * <ul>
 * <li>{@link #compareTo(PriorityQueueNode)}: Compares this priority queue node
 * with the
 * specified priority queue node for order</li>
 * </ul>
 * 
 * <h3>PriorityQueueNode</h3>
 * 
 * @param <T> the type of element stored in this priority queue node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see MinPriorityQueueNode
 * @see MaxPriorityQueueNode
 */
public abstract class PriorityQueueNode<T> extends Node<T> implements Comparable<PriorityQueueNode<T>> {
    /**
     * The order of the next instantiated priority queue node
     */
    private static int NEXT_ORDER = 1;
    /**
     * The priority of this priority queue node
     */
    protected final int priority;
    /**
     * The order of this priority queue node
     */
    protected final int order;

    /**
     * Constructs an empty priority queue node.
     */
    protected PriorityQueueNode() {
        this(null);
    }

    /**
     * Constructs a priority queue node with an element.
     * 
     * @param element the element to be stored in this priority queue node
     */
    protected PriorityQueueNode(T element) {
        this(element, 0);
    }

    /**
     * Constructs a priority queue node with an element and a priority.
     * 
     * @param element  the element to be stored in this priority queue node
     * @param priority the priority associated with this priority queue node
     */
    protected PriorityQueueNode(T element, int priority) {
        super(element);
        this.priority = priority;
        this.order = NEXT_ORDER++;
    }

    /**
     * Compares this priority queue node with the specified priority queue node for
     * order.
     * 
     * @param o the specified priority queue node to be compared
     * @return a negative integer, zero, or a positive integer as this priority
     *         queue node is less than, equal to, or greater than the specified
     *         priority queue node.
     */
    @Override
    public abstract int compareTo(PriorityQueueNode<T> o);
}
