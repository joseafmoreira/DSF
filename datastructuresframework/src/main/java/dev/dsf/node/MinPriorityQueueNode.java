package dev.dsf.node;

/**
 * A min-priority queue node is an auxiliary object used to implement a
 * min-priority queue data structure.
 * <p>
 * It contains an element, a priority and an order.
 * <p>
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #MinPriorityQueueNode()}: Constructs an empty priority queue
 * node</li>
 * <li>{@link #MinPriorityQueueNode(Object)}: Constructs a priority queue node
 * with an element</li>
 * <li>{@link #MinPriorityQueueNode(Object, int)}: Constructs a priority queue
 * node with an element and a priority</li>
 * </ul>
 * 
 * <h3>MinPriorityQueueNode</h3>
 * 
 * @param <T> the type of element stored in this priority queue node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class MinPriorityQueueNode<T> extends PriorityQueueNode<T> {
    /**
     * Constructs an empty priority queue node.
     */
    protected MinPriorityQueueNode() {
        this(null);
    }

    /**
     * Constructs a priority queue node with an element.
     * 
     * @param element the element to be stored in this priority queue node
     */
    protected MinPriorityQueueNode(T element) {
        this(element, 0);
    }

    /**
     * Constructs a priority queue node with an element and a priority.
     * 
     * @param element  the element to be stored in this priority queue node
     * @param priority the priority associated with this priority queue node
     */
    protected MinPriorityQueueNode(T element, int priority) {
        super(element, priority);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(PriorityQueueNode<T> o) {
        int result = 0;
        if (priority > o.priority)
            result = 1;
        else if (priority < o.priority)
            result = -1;
        else if (order > o.order)
            result = 1;
        else if (order < o.order)
            result = -1;
        return result;
    }
}
