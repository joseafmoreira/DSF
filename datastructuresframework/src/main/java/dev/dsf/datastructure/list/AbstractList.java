package dev.dsf.datastructure.list;

import java.util.Iterator;

import dev.dsf.abstractdatatype.ListADT;
import dev.dsf.datastructure.collection.AbstractIterableCollection;

/**
 * This class provides a skeletal implementation of the
 * {@code ListADT} interface, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class AbstractList<T> extends AbstractIterableCollection<T> implements ListADT<T> {
    /**
     * The number of modifications made to this list
     */
    protected int modCount;

    /**
     * Constructor for use by subclasses.
     */
    protected AbstractList() {
        modCount = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T target) {
        return indexOf(target) != -1;
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        super.clear();
        modCount++;
    }

    /**
     * {@code Iterator} skeletal-implementation for the {@code ListADT} based classes
     */
    protected abstract class ListIterator implements Iterator<T> {
        /**
         * The expected number of modifications made to this list
         */
        protected int expectedModCount;
        /**
         * The flag indicating if it's ok to call the remove method
         */
        protected boolean okToRemove;

        /**
         * Constructs an empty list iterator.
         */
        protected ListIterator() {
            expectedModCount = modCount;
            okToRemove = false;
        }
    }
}
