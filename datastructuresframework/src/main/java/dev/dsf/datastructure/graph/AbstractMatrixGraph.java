package dev.dsf.datastructure.graph;

import java.util.NoSuchElementException;

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
            while (adjacencyMatrix.get(i).size() < size())
                adjacencyMatrix.get(i).addLast(Double.POSITIVE_INFINITY);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException   {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    public void removeVertex(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");
        for (int i = 0; i < size(); i++)
            if (list.get(i).equals(target)) {
                list.remove(target);
                for (int j = 0; j < adjacencyMatrix.size(); j++) {
                    if (j == i) {
                        adjacencyMatrix.remove(j);
                        j--;
                        continue;
                    }
                    adjacencyMatrix.get(j).remove(i);
                }
                return;
            }
        throw new NoSuchElementException("Target isn't in this graph");
    }
}
