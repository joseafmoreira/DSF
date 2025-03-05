package dev.dsf.datastructure.graph;

import java.util.Iterator;

import dev.dsf.abstractdatatype.collection.IterableCollectionADT;
import dev.dsf.abstractdatatype.graph.GraphADT;
import dev.dsf.abstractdatatype.list.UnorderedListADT;
import dev.dsf.datastructure.list.unordered.UnorderedDoubleLinkedList;

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
     * Constructs an empty graph
     */
    protected AbstractGraph() {
        list = new UnorderedDoubleLinkedList<>();
    }

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
     */
    @Override
    public boolean isConnected() {
        for (T vertex : list) {
            Iterator<T> it = iteratorBFS(vertex);
            int itSize = 0;
            while (it.hasNext()) {
                it.next();
                itSize++;
            }
            if (itSize != size())
                return false;
        }
        return true;
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

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof IterableCollectionADT))
            return false;
        Iterator<T> it1 = list.iterator();
        Iterator<T> it2 = ((IterableCollectionADT<T>) obj).iterator();
        while (it1.hasNext() && it2.hasNext()) {
            T element1 = it1.next();
            T element2 = it2.next();
            if (element1 == null ? element2 != null : !element1.equals(element2))
                return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return list.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return list.toString();
    }
}
