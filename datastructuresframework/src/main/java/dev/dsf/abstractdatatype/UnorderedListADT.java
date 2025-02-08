package dev.dsf.abstractdatatype;

import java.util.NoSuchElementException;

/**
 * An unordered list is a linear abstract data type that allows the addition in
 * which the order of it's elements is determined by the end user.
 * <p>
 * 
 * The common operations for an unordered list include:
 * <p>
 * <ul>
 * <li>{@link #add(int, Object)}: Inserts the specified element at the specified
 * index in this list</li>
 * <li>{@link #addFirst(Object)}: Adds an element to the front of this
 * unordered list</li>
 * <li>{@link #addLast(Object)}: Adds an element to the rear of this unordered
 * list</li>
 * <li>{@link #addBefore(Object, Object)}: Adds an element before a specified
 * target in this unordered list</li>
 * <li>{@link #addAfter(Object, Object)}: Adds an element after a specified
 * target in this unordered list</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>UnorderedListADT</h3>
 * 
 * @param <T> the type of elements in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public interface UnorderedListADT<T> extends ListADT<T> {
    /**
     * Inserts the specified element at the specified index in this list.
     * 
     * @param index   the specified index
     * @param element the specified element
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     * @throws NullPointerException      if the specified element is null and
     *                                   this list does not allow null elements
     */
    void add(int index, T element);

    /**
     * Adds an element to the front of this unordered list.
     * 
     * @param element the element to be added to the front of this unordered list
     * @throws NullPointerException if the specified element is null and
     *                              this list does not allow null elements
     */
    default void addFirst(T element) {
        add(0, element);
    }

    /**
     * Adds an element to the rear of this unordered list.
     * 
     * @param element the element to be added to the rear of this unordered list
     * @throws NullPointerException if the specified element is null and
     *                                this list does not allow null elements
     */
    default void addLast(T element) {
        add(size(), element);
    }

    /**
     * Adds an element before a specified target in this unordered list.
     * 
     * @param element the element to be added after the target
     * @param target  the target to search
     * @throws NullPointerException   if the specified element or target is
     *                                null and this list does not allow null
     *                                elements
     * @throws NoSuchElementException if the specified target is not
     *                                found in this list
     */
    default void addBefore(T element, T target) {
        int index = indexOf(target);
        if (index == -1)
            throw new IllegalArgumentException("Target not found in the list");
        add(index, element);
    }

    /**
     * Adds an element after a specified target in this unordered list.
     * 
     * @param element the element to be added after the target
     * @param target  the target to search
     * @throws NullPointerException   if the specified element or target is
     *                                null and this list does not allow null
     *                                elements
     * @throws NoSuchElementException if the specified target is not
     *                                found in this list
     */
    default void addAfter(T element, T target) {
        int index = indexOf(target);
        if (index == -1)
            throw new IllegalArgumentException("Target not found in the list");
        add(index + 1, element);
    }

    /**
     * Adds all the elements in a specified collection to the rear of this unordered list.
     * 
     * @param collection the specified collection
     * @throws NullPointerException if the specified collection is null
     */
    default void addAll(IterableCollectionADT<T> collection) {
        if (collection == null)
            throw new NullPointerException("Collection is null");
        for (T element : this)
            addLast(element);
    }
}
