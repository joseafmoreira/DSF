package dev.dsf.abstractdatatype;

import dev.dsf.exception.EmptyCollectionException;

/**
 * A priority queue is an abstract data type similar to a queue that, unlike a
 * queue, arranges it's elements based on their priority values.
 * <p>
 * 
 * The operations for a priority queue include:
 * <p>
 * <ul>
 * <li>{@link #enqueue(Object, int)}: Adds an element to this priority queue at the proper location</li>
 * <li>{@link #first()}: Returns the element from the front of this priority queue</li>
 * <li>{@link #dequeue()}: Removes the element from the front of this priority queue</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>PriorityQueueADT</h3>
 * 
 * @param <T> the type of elements in this priorirty queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public interface PriorityQueueADT<T> extends CollectionADT {
    /**
     * Adds an element to this priority queue at the proper location.
     * 
     * @param element  the specified element
     * @param priority the specified priority
     * @throws NullPointerException if the specified element is null and
     *                              this priority queue does not allow null elements
     */
    void enqueue(T element, int priority);

    /**
     * Returns the element from the front of this priority queue.
     * 
     * @return the element from the front of this priority queue
     * @throws EmptyCollectionException if this priority queue is empty
     */
    T first();

    /**
     * Removes the element from the front of this priority queue.
     * 
     * @return the element from the front of this priority queue
     * @throws EmptyCollectionException if this priority queue is empty
     */
    T dequeue();
}
