package dev.dsf.abstractdatatype.list;

import dev.dsf.abstractdatatype.collection.IterableCollectionADT;
import dev.dsf.exception.EmptyCollectionException;

/**
 * A list is a linear abstract data type that is more flexible than the stack
 * and the queue meaning that you can add, remove and search elements on the
 * list without restrictions.
 * <p>
 * There will be two base types of lists implemented:
 * <p>
 * <ul>
 * <li>Ordered</li>
 * <li>Unordered</li>
 * </ul>
 * For this interface, it's only specified the common operations between both
 * lists leaving the unique methods for the ordered and the unordered lists in
 * the {@code OrderedListADT} and {@code UnorderedListADT} respectively
 * 
 * The common operations for a list include:
 * <p>
 * <ul>
 * <li>{@link #get(int)}: Returns the element at the specified index in this
 * list</li>
 * <li>{@link #first()}: Returns the element from the front of this list</li>
 * <li>{@link #last()}: Retrusn the element from the rear of this list</li>
 * <li>{@link #set(int, Object)}: Replaces the element at the specified index in
 * this list with the specified element</li>
 * <li>{@link #sort()}: Sorts the elements in the list according to their
 * natural ordering</li>
 * <li>{@link #indexOf(Object)}: Returns the index of the first occurrence of
 * the specified target in this list, or -1 if this list does not contain the
 * target</li>
 * <li>{@link #remove(int)}: Removes an element from this list at a specified
 * index</li>
 * <li>{@link #removeFirst()}: Removes an element from the front of this
 * list</li>
 * <li>{@link #removeLast()}: Removes an element from the rear of this list</li>
 * <li>{@link #remove(Object)}: Removes a specified target from this list</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>ListADT</h3>
 * 
 * @param <T> the type of elements in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see OrderedListADT
 * @see UnorderedListADT
 */
public interface ListADT<T> extends IterableCollectionADT<T> {
    /**
     * Returns the element at the specified index in this list.
     * 
     * @param index the specified index
     * @return the element at the specified index in this list
     * @throws EmptyCollectionException  if this list is empty
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    T get(int index);

    /**
     * Returns the element from the front of this list.
     * 
     * @return the element from the front of this list
     * @throws EmptyCollectionException if this list is empty
     */
    default T first() {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        return get(0);
    }

    /**
     * Returns the element from the rear of this list.
     * 
     * @return the element from the rear of this list
     * @throws EmptyCollectionException if this list is empty
     */
    default T last() {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        return get(size() - 1);
    }

    /**
     * Returns the index of the first occurrence of the specified target
     * in this list, or -1 if this list does not contain the target.
     * 
     * @param target the specified target
     * @return the index of the first occurrence of the specified target
     *         in this list, or -1 if this list does not contain the target
     * @throws EmptyCollectionException if this list is empty
     * @throws NullPointerException     if the specified element is null and
     *                                  this list does not allow null elements
     */
    int indexOf(T target);

    /**
     * {@inheritDoc}
     */
    @Override
    default boolean contains(T target) {
        return indexOf(target) != -1;
    }

    /**
     * Removes an element from this list at a specified index.
     * 
     * @param index the specified index
     * @return the removed element
     * @throws EmptyCollectionException  if this list is empty
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    T remove(int index);

    /**
     * Removes an element from the front of this list.
     * 
     * @return the element from the front of this list
     * @throws EmptyCollectionException if this list is empty
     */
    default T removeFirst() {
        return remove(0);
    }

    /**
     * Removes an element from the rear of this list.
     * 
     * @return the element from the rear of this list
     * @throws EmptyCollectionException if this list is empty
     */
    default T removeLast() {
        return remove(size() - 1);
    }

    /**
     * Removes a specified target from this list.
     * 
     * @param target the target to remove
     * @return {@code true} if this list contained the specified target
     * @throws EmptyCollectionException if this list is empty
     * @throws NullPointerException     if the specified target is null and
     *                                  this list does not allow null elements
     */
    default boolean remove(T target) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        int index = indexOf(target);
        if (index == -1)
            return false;
        remove(index);
        return true;
    }

    /**
     * Removes all the elements present in a specified collection from this list.
     * 
     * @param collection the specified collection
     * @return {@code true} if all the elements from the specified collection are
     *         removed from this list
     * @throws EmptyCollectionException if this list is empty
     * @throws NullPointerException     if the specified target is null and
     *                                  this list does not allow null elements
     */
    default boolean removeAll(IterableCollectionADT<T> collection) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (collection == null)
            throw new NullPointerException("Collection is null");
        boolean removedAll = true;
        for (T element : this)
            if (!remove(element))
                removedAll = false;
        return removedAll;
    }
}
