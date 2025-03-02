package dev.dsf.datastructure.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.dsf.abstractdatatype.QueueADT;
import dev.dsf.abstractdatatype.StackADT;
import dev.dsf.abstractdatatype.list.UnorderedListADT;
import dev.dsf.datastructure.list.unordered.UnorderedArrayList;
import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;
import dev.dsf.datastructure.queue.LinkedQueue;
import dev.dsf.datastructure.stack.LinkedStack;

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
        while (adjacencyMatrix.size() < size()) {
            UnorderedListADT<Double> unorderedList = new UnorderedArrayList<>();
            while (unorderedList.size() < size())
                unorderedList.addLast(Double.POSITIVE_INFINITY);
            adjacencyMatrix.addLast(unorderedList);
        }
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

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorBFS(T startVertex) {
        if (startVertex == null)
            throw new NullPointerException("Starting vertex is null");
        UnorderedListADT<T> it = new UnorderedLinkedList<>();
        if (!isEmpty()) {
            int startIndex = isVertexValid(startVertex);
            if (startIndex != -1) {
                QueueADT<Integer> queue = new LinkedQueue<>();
                UnorderedListADT<Boolean> visitedVertices = new UnorderedLinkedList<>();
                for (int i = 0; i < size(); i++)
                    visitedVertices.addLast((i == startIndex));
                queue.enqueue(startIndex);
                while (!queue.isEmpty()) {
                    int currentIndex = queue.dequeue();
                    it.addLast(list.get(currentIndex));
                    for (int i = 0; i < size(); i++)
                        if (adjacencyMatrix.get(currentIndex).get(i) != Double.POSITIVE_INFINITY && !visitedVertices.get(i)) {
                            queue.enqueue(i);
                            visitedVertices.set(i, true);
                        }
                }
            }
        }
        return it.iterator();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorDFS(T startVertex) {
        if (startVertex == null)
            throw new NullPointerException("Starting vertex is null");
        UnorderedListADT<T> it = new UnorderedLinkedList<>();
        if (!isEmpty()) {
            int startIndex = isVertexValid(startVertex);
            if (startIndex != -1) {
                StackADT<Integer> stack = new LinkedStack<>();
                UnorderedListADT<Boolean> visitedVertices = new UnorderedLinkedList<>();
                for (int i = 0; i < size(); i++)
                    visitedVertices.addLast((i == startIndex));
                stack.push(startIndex);
                it.addLast(list.get(startIndex));
                while (!stack.isEmpty()) {
                    int currentIndex = stack.peek();
                    boolean found = false;
                    for (int i = 0; i < size(); i++)
                        if (adjacencyMatrix.get(currentIndex).get(i) != Double.POSITIVE_INFINITY && !visitedVertices.get(i)) {
                            stack.push(i);
                            it.addLast(list.get(i));
                            visitedVertices.set(i, true);
                            found = true;
                        }
                    if (!found && !stack.isEmpty())
                        stack.pop();
                }
            }
        }
        return it.iterator();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        if (startVertex == null)
            throw new NullPointerException("Starting vertex is null");
        if (targetVertex == null)
            throw new NullPointerException("Target vertex is null");
        UnorderedListADT<T> it = new UnorderedLinkedList<>();
        if (!isEmpty()) {
            int startIndex = isVertexValid(startVertex);
            int targetIndex = isVertexValid(targetVertex);
        }
        return it.iterator();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorLongestPath(T startVertex, T targetVertex) {
        if (startVertex == null)
            throw new NullPointerException("Starting vertex is null");
        if (targetVertex == null)
            throw new NullPointerException("Target vertex is null");
        UnorderedListADT<T> it = new UnorderedLinkedList<>();
        if (!isEmpty()) {
            int startIndex = isVertexValid(startVertex);
            int targetIndex = isVertexValid(targetVertex);
        }
        return it.iterator();
    }

    /**
     * Checks if a vertex is valid in this graph.
     *
     * @param vertex the vertex to check
     * @return the index of the vertex if it is valid, -1 otherwise
     */
    protected int isVertexValid(T vertex) {
        for (int i = 0; i < size(); i++)
            if (list.get(i).equals(vertex))
                return i;
        return -1;
    }
}
