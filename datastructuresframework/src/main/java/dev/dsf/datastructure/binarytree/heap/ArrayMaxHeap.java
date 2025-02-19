package dev.dsf.datastructure.binarytree.heap;

import dev.dsf.abstractdatatype.MaxHeapADT;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Resizable-array implementation of the {@code MaxHeapADT} interface.
 * 
 * <h3>ArrayMaxHeap</h3>
 * 
 * @param <T> the type of element stored in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class ArrayMaxHeap<T> extends ArrayHeap<T> implements MaxHeapADT<T> {
    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException   {@inheritDoc}
     */
    @Override
    public void add(T element) {
        if (element == null)
            throw new NullPointerException("Element is null");
        if (!(element instanceof Comparable<?>))
            throw new ClassCastException("Element not comparable");
        int addedIndex = 0;
        if (isEmpty())
            list.addFirst(element);
        else {
            int nextParent = getNextParent();
            addedIndex = nextParent * 2 + (list.get(nextParent * 2 + 1) == null ? 1 : 2);
            list.set(addedIndex, element);
        }
        size++;
        while (list.size() < Math.pow(2, getHeight() + 2) - 1)
            list.addLast(null);
        lastIndex = addedIndex;
        if (size() > 1)
            heapifyAdd();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T removeMax() {
        T result = findMax();
        if (size() == 1) {
            list.set(0, null);
            lastIndex = -1;
        } else {
            list.set(0, list.get(lastIndex));
            list.set(lastIndex, null);
            lastIndex--;
            heapifyRemove();
        }
        size--;
        return result;
    }

    /**
     * Performs heapify operation after adding a new element to the max-heap.
     * This method ensures that the heap property is maintained by comparing the new
     * element with its parent.
     * If the new element is bigger than its parent, it is swapped with its parent
     * and the process is repeated until the heap property is satisfied.
     * 
     * @throws ClassCastException if the element isn't comparable
     */
    @SuppressWarnings("unchecked")
    private void heapifyAdd() {
        int nextNodeIndex = lastIndex;
        T temp = list.get(nextNodeIndex);
        while (nextNodeIndex != 0 && list.get((nextNodeIndex - 1) / 2) != null
                && ((Comparable<T>) temp).compareTo(list.get((nextNodeIndex - 1) / 2)) > 0) {
            list.set(nextNodeIndex, list.get((nextNodeIndex - 1) / 2));
            nextNodeIndex = (nextNodeIndex - 1) / 2;
        }
        list.set(nextNodeIndex, temp);
    }

    /**
     * Performs the heapify operation after removing an element from this max-heap.
     * This operation ensures that the max-heap property is maintained by moving
     * elements down this max-heap.
     */
    @SuppressWarnings("unchecked")
    private void heapifyRemove() {
        int currentIndex = 0;
        while (true) {
            int leftIndex = currentIndex * 2 + 1;
            int rightIndex = currentIndex * 2 + 2;
            int smallestIndex = currentIndex;
            if (leftIndex <= lastIndex && list.get(leftIndex) != null &&
                    ((Comparable<T>) list.get(leftIndex)).compareTo(list.get(smallestIndex)) > 0)
                smallestIndex = leftIndex;
            if (rightIndex <= lastIndex && list.get(rightIndex) != null &&
                    ((Comparable<T>) list.get(rightIndex)).compareTo(list.get(smallestIndex)) > 0)
                smallestIndex = rightIndex;
            if (smallestIndex != currentIndex) {
                T swap = list.get(currentIndex);
                list.set(currentIndex, list.get(smallestIndex));
                list.set(smallestIndex, swap);
                currentIndex = smallestIndex;
            } else
                break;
        }
    }
}
