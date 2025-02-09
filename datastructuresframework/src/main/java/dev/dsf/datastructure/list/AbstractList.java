package dev.dsf.datastructure.list;

import java.util.ConcurrentModificationException;
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
 * @see ArrayList
 * @see LinkedList
 * @see DoubleLinkedList
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
    public void clear() {
        super.clear();
        modCount++;
    }

    /**
     * {@code Iterator} skeletal-implementation for the {@code ListADT} based
     * classes
     */
    protected abstract class ListIterator implements Iterator<T> {
        /**
         * The current index of this list
         */
        protected int currentIndex;
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
            currentIndex = 0;
            expectedModCount = modCount;
            okToRemove = false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        /**
         * {@inheritDoc}
         * 
         * @throws ConcurrentModificationException if this list has been altered
         */
        @Override
        public void remove() throws ConcurrentModificationException, IllegalStateException {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException("List has been altered");
            if (!okToRemove)
                throw new IllegalStateException("Invalid remove call");
            AbstractList.this.remove(--currentIndex);
            expectedModCount++;
            okToRemove = false;
        }
    }
}
