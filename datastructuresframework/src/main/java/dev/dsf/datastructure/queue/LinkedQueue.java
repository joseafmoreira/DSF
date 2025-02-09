package dev.dsf.datastructure.queue;

import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;

/**
 * Singly-linked list implementation of the {@code QueueADT} interface.
 * 
 * <h3>LinkedQueue</h3>
 * 
 * @param <T> the type of element stored in this queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedQueue<T> extends AbstractQueue<T> {
    /**
     * Constructs an empty queue.
     */
    public LinkedQueue() {
        list = new UnorderedLinkedList<>();
    }
}
