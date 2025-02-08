package dev.dsf.datastructure.collection;

import java.util.Iterator;
import java.util.StringJoiner;

import dev.dsf.abstractdatatype.IterableCollectionADT;

/**
 * This class provides a skeletal implementation of the
 * {@code IterableCollectionADT} interface, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractIterableCollection</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class AbstractIterableCollection<T> extends AbstractCollection implements IterableCollectionADT<T> {
    /**
     * Constructor for use by subclasses.
     */
    protected AbstractIterableCollection() {
        super();
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        Iterator<T> it1 = iterator();
        Iterator<T> it2 = ((AbstractIterableCollection<T>) obj).iterator();
        while (it1.hasNext() && it2.hasNext()) {
            T element1 = it1.next();
            T element2 = it2.next();
            if (element1 == null ? element2 != null : !element1.equals(element2))
                return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hashCode = super.hashCode();
        for (T element : this)
            hashCode = PRIME_NUMBER * hashCode + (element == null ? 0 : element.hashCode());
        return hashCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringJoiner message = new StringJoiner(", ", "[", "]");
        for (T element : this)
            message.add(element == null ? "null" : element.toString());
        return message.toString();
    }
}
