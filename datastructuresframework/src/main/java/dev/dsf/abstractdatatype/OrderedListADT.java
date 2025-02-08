package dev.dsf.abstractdatatype;

/**
 * An ordered list is a linear abstract data type that allows the addition in
 * which the order of it's elements is determined by some intrinsic
 * characteristic of the elements.
 * <p>
 * In order to add an element to this ordered list, the class of the element
 * needs to implement the {@code Comparable} interface.
 * <p>
 * 
 * The common operations for an ordered list include:
 * <p>
 * <ul>
 * <li>{@link #add(Comparable)}: Adds an element to this ordered list at the
 * proper location</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>OrderedListADT</h3>
 * 
 * @param <T> the type of elements in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public interface OrderedListADT<T> extends ListADT<T> {
    /**
     * Adds an element to this oridered list at the proper location.
     * 
     * @param element the element to be added
     * @throws NullPointerException if the specified element is null and
     *                              this list does not allow null elements
     * @throws ClassCastException   if the element isn't comparable
     */
    void add(T element);

    /**
     * Adds all the elements in a specified collection to this ordered list at the
     * proper location.
     * 
     * @param collection the element to be added to the rear of this unordered list
     * @throws NullPointerException if the specified collection is null or the
     *                              specified element is null and this list does not
     *                              allow null elements
     * @throws ClassCastException   if the elements in the specified collection
     *                              aren't comparable
     */
    default void addAll(IterableCollectionADT<T> collection) {
        if (collection == null)
            throw new NullPointerException("Collection is null");
        for (T element : this)
            add(element);
    }
}
