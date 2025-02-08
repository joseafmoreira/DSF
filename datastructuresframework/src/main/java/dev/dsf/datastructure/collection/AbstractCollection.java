package dev.dsf.datastructure.collection;

import dev.dsf.abstractdatatype.CollectionADT;

/**
 * This class provides a skeletal implementation of the {@code CollectionADT}
 * interface, to minimize the effort required to implement this interface.
 * <p>
 * 
 * <h3>AbstractCollection</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class AbstractCollection implements CollectionADT {
    /**
     * The prime number used to generate the hash for this collection
     */
    protected static final int PRIME_NUMBER = 31;
    /**
     * The number of elements in this collection
     */
    protected int size;

    /**
     * Constructor for use by subclasses.
     */
    protected AbstractCollection() {
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof AbstractCollection))
            return false;
        return size() == ((AbstractCollection) obj).size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return PRIME_NUMBER * 1 + size();
    }
}
