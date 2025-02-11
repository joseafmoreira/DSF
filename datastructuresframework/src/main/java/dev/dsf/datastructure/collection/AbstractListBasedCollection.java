package dev.dsf.datastructure.collection;

import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.datastructure.stack.AbstractStack;
import dev.dsf.datastructure.binarytree.ArrayBinaryTree;
import dev.dsf.datastructure.queue.AbstractQueue;

/**
 * This class provides a skeletal implementation of a list based collection,
 * containing all the methods common to all list based collections.
 * <p>
 * 
 * <h3>AbstractListBasedCollection</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractStack
 * @see AbstractQueue
 * @see ArrayBinaryTree
 */
public abstract class AbstractListBasedCollection<T> extends AbstractCollection {
    /**
     * The list containing the elements of this collection
     */
    protected UnorderedListADT<T> list;
    /**
     * A flag indicating whether this collection's size is the list size
     */
    private final boolean isListSize;

    /**
     * Constructs an empty collection.
     */
    protected AbstractListBasedCollection() {
        this(true);
    }

    protected AbstractListBasedCollection(boolean isListSize) {
        super();
        this.isListSize = isListSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        super.clear();
        list.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return isListSize ? list.size() : super.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        return list.equals(obj);
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
