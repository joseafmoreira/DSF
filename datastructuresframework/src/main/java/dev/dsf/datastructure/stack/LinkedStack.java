package dev.dsf.datastructure.stack;

import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;

/**
 * Singly-linked list implementation of the {@code StackADT} interface.
 * 
 * <h3>LinkedStack</h3>
 * 
 * @param <T> the type of element stored in this stack
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class LinkedStack<T> extends AbstractStack<T> {
    /**
     * Constructs an empty stack.
     */
    public LinkedStack() {
        list = new UnorderedLinkedList<>();
    }
}
