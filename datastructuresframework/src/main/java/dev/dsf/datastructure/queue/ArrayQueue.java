package dev.dsf.datastructure.queue;

import dev.dsf.datastructure.list.unordered.UnorderedArrayList;

/**
 * Resizable-array list implementation of the {@code QueueADT} interface.
 * 
 * <h3>ArrayQueue</h3>
 * 
 * @param <T> the type of element stored in this queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class ArrayQueue<T> extends AbstractQueue<T> {
    /**
     * Constructs an empty queue.
     */
    public ArrayQueue() {
        list = new UnorderedArrayList<>();
    }
}
