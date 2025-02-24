package dev.dsf.abstractdatatype.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.dsf.abstractdatatype.collection.IterableCollectionADT;

/**
 * A graph is a non-linear abstract data type that consists of vertexes and
 * edges or connections between those vertexes.
 * <p>
 * There will be two base types of graphs implemented:
 * <p>
 * <ul>
 * <li>Undirected</li>
 * <li>Directed</li>
 * </ul>
 * The difference between undirected and directed graphs is that if an edge is
 * added between two vertexes it will be bidirectional and unidirectional,
 * respectively.
 * <p>
 * For this graph implementation, the edges don't have weights associated to
 * them.
 * <p>
 * 
 * The common operations for a graph include:
 * <p>
 * <ul>
 * <li>{@link #addVertex(Object)}: Adds a vertex to this graph</li>
 * <li>{@link #removeVertex(Object)}: Removes a vertex from this graph</li>
 * <li>{@link #addEdge(Object, Object)}: Adds an edge between two vertexes</li>
 * <li>{@link #removeEdge(Object, Object)}: Removes an edge between two
 * vertexes</li>
 * <li>{@link #isConnected()}: Checks if this graph is connected</li>
 * <li>{@link #iteratorBFS(Object)}: Returns an iterator over the elements in
 * this graph by performing a breadth-first-search traversal</li>
 * <li>{@link #iteratorDFS(Object)}: Returns an iterator over the elements in
 * this graph by performing a depth-first-search traversal</li>
 * <li>{@link #iteratorShortestPath(Object, Object)}: Returns an iterator over
 * the elements that constitute the shortest path between two vertexes including
 * those two vertexes</li>
 * <li>{@link #iteratorLongestPath(Object, Object)}: Returns an iterator over
 * the elements that constitute the longest path between two vertexes including
 * those two vertexes</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>GraphADT</h3>
 * 
 * @param <T> the type of elements in this graph
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see WeightedGraphADT
 */
public interface GraphADT<T> extends IterableCollectionADT<T> {
    /**
     * Adds a vertex to this graph.
     * 
     * @param vertex the vertex to be added
     * @throws NullPointerException if the specified vertex is null
     */
    void addVertex(T vertex);

    /**
     * Removes a vertex from this graph.
     * 
     * @param target the target to remove
     * @throws NullPointerException   if the specified target is null
     * @throws NoSuchElementException if the specified target isn't in this graph
     */
    void removeVertex(T target);

    /**
     * Adds an edge between two vertexes.
     * 
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @throws NullPointerException   if the specified vertices are null
     * @throws NoSuchElementException if one or both of the specified vertices isn't
     *                                in this graph
     */
    void addEdge(T vertex1, T vertex2);

    /**
     * Removes an edge between two vertexes.
     * 
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @throws NullPointerException   if the specified vertices are null
     * @throws NoSuchElementException if one or both of the specified vertices isn't
     *                                in this graph
     */
    void removeEdge(T vertex1, T vertex2);

    /**
     * Checks if this graph is connected.
     * 
     * @return true if this graph is connected, false otherwise
     */
    boolean isConnected();

    /**
     * Returns an iterator over the elements in this graph by performing a
     * breadth-first-search traversal.
     * 
     * @param startVertex the start vertex
     * @return an iterator over the elements in this graph
     * @throws NullPointerException if the specified vertex is null
     */
    Iterator<T> iteratorBFS(T startVertex);

    /**
     * Returns an iterator over the elements in this graph by performing a
     * depth-first-search traversal.
     * 
     * @param startVertex the start vertex
     * @return an iterator over the elements in this graph
     * @throws NullPointerException if the specified vertex is null
     */
    Iterator<T> iteratorDFS(T startVertex);

    /**
     * Returns an iterator over the elements that constitute the shortest path
     * between two vertexes including those two vertexes
     * 
     * @param startVertex  the start vertex
     * @param targetVertex the target vertex
     * @return an iterator over the elements that constitute the shortest path
     *         between two vertexes including those two vertexes
     * @throws NullPointerException if the specified vertices are null
     */
    Iterator<T> iteratorShortestPath(T startVertex, T targetVertex);

    /**
     * Returns an iterator over the elements that constitute the longest path
     * between two vertexes including those two vertexes
     * 
     * @param startVertex  the start vertex
     * @param targetVertex the target vertex
     * @return an iterator over the elements that constitute the longest path
     *         between two vertexes including those two vertexes
     * @throws NullPointerException if the specified vertices are null
     */
    Iterator<T> iteratorLongestPath(T startVertex, T targetVertex);

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the specified is null
     * @see IterableCollectionADT#contains(Object)
     */
    @Override
    default boolean contains(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");
        for (T element : this)
            if (element.equals(target))
                return true;
        return false;
    }
}
