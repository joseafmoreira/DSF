package dev.dsf.abstractdatatype.graph;

/**
 * A weighted graph is a graph that has weights associated with it's edges.
 * <p>
 * There will be two base types of weighted graph implemented:
 * <p>
 * <ul>
 * <li>Undirected</li>
 * <li>Directed</li>
 * </ul>
 * 
 * The common operations for a weighted graph include:
 * <p>
 * <ul>
 * <li>{@link #addEdge(Object, Object, double)}: Adds an edge between two
 * vertexes with a specified weight</li>
 * <li>{@link #shortestPathWeight(Object, Object)}: Returns the weight of the
 * shortest path between two vertexes</li>
 * <li>{@link #longestPathWeight(Object, Object)}: Returns the weight of the
 * longest path between two vertexes</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>NetworkADT</h3>
 * 
 * @param <T> the type of elements in this graph
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public interface WeightedGraphADT<T> extends GraphADT<T> {
    /**
     * Adds an edge between two vertexes with a specified weight.
     * 
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight  the weight of the edge
     */
    void addEdge(T vertex1, T vertex2, double weight);

    /**
     * {@inheritDoc}
     * 
     * @see GraphADT#addEdge(Object, Object)
     */
    @Override
    default void addEdge(T vertex1, T vertex2) {
        addEdge(vertex1, vertex2, 0);
    }

    /**
     * Returns the weight of the shortest path between two vertexes.
     * 
     * @param startVertex  the start vertex
     * @param targetVertex the target vertex
     * @return the weight of the shortest path between two vertexes
     */
    double shortestPathWeight(T startVertex, T targetVertex);

    /**
     * Returns the weight of the longest path between two vertexes.
     * 
     * @param startVertex  the start vertex
     * @param targetVertex the target vertex
     * @return the weight of the longest path between two vertexes
     */
    double longestPathWeight(T startVertex, T targetVertex);
}
