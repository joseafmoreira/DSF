package dev.dsf.datastructure.graph;

import java.util.Iterator;

import dev.dsf.abstractdatatype.graph.GraphADT;
import dev.dsf.abstractdatatype.list.UnorderedListADT;

/**
 * This class provides a skeletal implementation of the
 * {@code GraphADT} interface, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractGraph</h3>
 * 
 * @param <T> the type of element stored in this graph
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class AbstractGraph<T> implements GraphADT<T> {
    /**
     * The list containing the vertices of this graph
     */
    protected UnorderedListADT<T> list;

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public void addVertex(T vertex) {
        if (vertex == null)
            throw new NullPointerException("Vertex is null");
        list.addLast(vertex);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public void removeVertex(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");
        list.remove(target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return list.size();
    }
}
