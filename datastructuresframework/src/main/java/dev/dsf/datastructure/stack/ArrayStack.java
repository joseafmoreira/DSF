package dev.dsf.datastructure.stack;

import dev.dsf.datastructure.list.unordered.UnorderedArrayList;

/**
 * Resizable-array list implementation of the {@code StackADT} interface.
 * 
 * <h3>ArrayStack</h3>
 * 
 * @param <T> the type of element stored in this stack
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class ArrayStack<T> extends AbstractStack<T> {
    /**
     * Constructs an empty stack.
     */
    public ArrayStack() {
        list = new UnorderedArrayList<>();
    }
}
