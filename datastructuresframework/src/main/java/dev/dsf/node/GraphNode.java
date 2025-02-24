package dev.dsf.node;

/**
 * A graph node is an auxiliary object used to implement a graph's adjacency
 * list.
 * <p>
 * It contains an element and a weight.
 * <p>
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #GraphNode()}: Constructs an empty graph node</li>
 * <li>{@link #GraphNode(Object)}: Constructs a graph node with an element</li>
 * <li>{@link #GraphNode(Object, double)}: Constructs a graph node with an
 * element and a weight</li>
 * </ul>
 * 
 * The operations for this {@code GraphNode} include:
 * <p>
 * <ul>
 * <li>{@link #getWeight()}: Returns the weight stored in this graph node</li>
 * <li>{@link #setWeight(Object)}: Sets the weight stored in this
 * graph node</li>
 * </ul>
 * 
 * <h3>GraphNode</h3>
 * 
 * @param <T> the type of element stored in this graph node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class GraphNode<T> extends Node<T> {
    /**
     * The weight of the edge associated with the graph's vertex
     */
    protected double weight;

    /**
     * Constructs an empty graph node.
     */
    public GraphNode() {
        this(null);
    }

    /**
     * Constructs a graph node with an element.
     * 
     * @param element the specified element
     */
    public GraphNode(T element) {
        this(element, Double.POSITIVE_INFINITY);
    }

    /**
     * Constructs a graph node with an element and a weight.
     * 
     * @param element the specified element
     * @param weight  the specified weight
     */
    public GraphNode(T element, double weight) {
        super(element);
        setWeight(weight);
    }

    /**
     * Returns the weight stored in this graph node.
     * 
     * @return the weight stored in this graph node
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight stored in this graph node.
     * 
     * @param weight the weight to be stored in this graph node
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
