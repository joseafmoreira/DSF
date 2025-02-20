package dev.dsf.abstractdatatype;

import java.util.Iterator;
import java.util.function.IntFunction;

/**
 * An iterable collection is a collection that can be looped through using an
 * {@code Iterator} object.
 * <p>
 * 
 * The common operations for an iterable collection include:
 * <p>
 * <ul>
 * <li>{@link #contains(Object)}: Returns true if this collection contains the
 * specified target</li>
 * <li>{@link #containsAll(IterableCollectionADT)}: Returns {@code true} if this
 * collection contains all the elements from a specified collection</li>
 * <li>{@link #toArray()}: Returns an array containing all of the elements in
 * this collection</li>
 * <li>{@link #iterator()}: Returns an iterator over the elements in this
 * collection</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>IterableCollectionADT</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public interface IterableCollectionADT<T> extends CollectionADT, Iterable<T> {
    /**
     * Returns {@code true} if this collection contains the specified target.
     * 
     * @param target the specified target
     * @return {@code true} if this collection contains the specified target
     */
    boolean contains(T target);

    /**
     * Returns {@code true} if this collection contains all the elements from a
     * specified collection.
     * 
     * @param collection the specified collection
     * @return {@code true} if this collection contains all the elements from a
     *         specified collection
     * @throws NullPointerException if the specified collection is null
     */
    default boolean containsAll(IterableCollectionADT<T> collection) {
        if (collection == null)
            throw new NullPointerException("Collection is null");
        for (T element : collection)
            if (!contains(element))
                return false;
        return true;
    }

    /**
     * Returns an array containing all of the elements in this collection.
     * 
     * @return an array containing all of the elements in this collection
     */
    @SuppressWarnings("unchecked")
    default T[] toArray() {
        T[] array = (T[]) new Object[size()];
        int i = 0;
        for (T element : this)
            array[i++] = element;
        return array;
    }

    /**
     * Returns an array containing all of the elements in this collection.
     * 
     * @param generator
     * @return an array containing all of the elements in this collection
     */
    default T[] toArray(IntFunction<T[]> generator) {
        T[] array = generator.apply(size());
        int i = 0;
        for (T element : this)
            array[i++] = element;
        return array;
    }

    /**
     * Returns an iterator over the elements in this collection.
     * 
     * @return an iterator over the elements in this collection
     * 
     * @see Iterable#iterator()
     */
    @Override
    Iterator<T> iterator();
}
