package dev.dsf.abstractdatatype;

/**
 * A collection is an abstract data type that is a grouping of items that can be
 * used in a polymorphic way.
 * <p>
 * 
 * The common operations for a collection include:
 * <p>
 * <ul>
 * <li>{@link #clear()}: Removes all of the elements from this collection</li>
 * <li>{@link #isEmpty()}: Returns {@code true} if this collection contains no
 * elements, {@code false} otherwise</li>
 * <li>{@link #size()}: Returns the number of elements in this collection</li>
 * <li>{@link #equals(Object)}: Indicates whether some other object is "equal
 * to" this collection</li>
 * <li>{@link #hashCode()}: Returns a hash code value for this collection</li>
 * <li>{@link #toString()}: Returns a string representation of this
 * collection</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>CollectionADT</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see IterableCollectionADT
 */
public interface CollectionADT {
    /**
     * Removes all of the elements from this collection.
     */
    void clear();

    /**
     * Returns {@code true} if this collection contains no elements, {@code false}
     * otherwise.
     * 
     * @return {@code true} if this collection contains no elements, {@code false}
     *         otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of elements in this collection.
     * 
     * @return the number of elements in this collection
     */
    int size();

    /**
     * Indicates whether some other object is "equal to" this collection.
     * 
     * @param obj the specified object to be compared with this collection
     * @return {@code true} if the specified object is "equal to" this collection,
     *         {@code false} otherwise
     * 
     * @see Object#equals(Object)
     */
    @Override
    boolean equals(Object obj);

    /**
     * Returns a hash code value for this collection.
     * 
     * @return a hash code value for this collection
     * 
     * @see Object#hashCode()
     */
    @Override
    int hashCode();

    /**
     * Returns a string representation of this collection.
     * 
     * @return a string representation of this collection
     * 
     * @see Object#toString()
     */
    @Override
    String toString();
}
