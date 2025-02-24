package dev.dsf.datastructure.graph;

import dev.dsf.abstractdatatype.list.UnorderedListADT;
import dev.dsf.datastructure.list.unordered.UnorderedArrayList;

/**
 * This class provides a skeletal implementation of the {@code GraphADT}
 * interface using a adjacency matrix, to minimize the effort required to
 * implement this interface.
 * <p>
 * 
 * <h3>AbstractMatrixGraph</h3>
 * 
 * @param <T> the type of element stored in this graph
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class AbstractMatrixGraph<T> extends AbstractGraph<T> {
    /**
     * The matrix containing the edges between the vertices of this graph
     */
    protected UnorderedListADT<UnorderedListADT<Double>> adjacencyMatrix;

    /**
     * Constructs an empty graph
     */
    protected AbstractMatrixGraph() {
        super();
        adjacencyMatrix = new UnorderedArrayList<>();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public void addVertex(T vertex) {
        super.addVertex(vertex);
        while (adjacencyMatrix.size() < list.size())
            adjacencyMatrix.addLast(new UnorderedArrayList<>());
        for (int i = 0; i < size(); i++)
            adjacencyMatrix.get(size() - 1).set(i, Double.POSITIVE_INFINITY);
    }
}
