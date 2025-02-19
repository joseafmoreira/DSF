package dev.dsf.datastructure.binarytree.heap;

import dev.dsf.abstractdatatype.HeapADT;
import dev.dsf.datastructure.binarytree.ArrayBinaryTree;
import dev.dsf.datastructure.binarytree.heap.max.ArrayMaxHeap;
import dev.dsf.datastructure.binarytree.heap.min.ArrayMinHeap;

/**
 * This class provides a skeletal implemetation for a resizable-array list-based
 * heap having all the common method implementations.
 * <p>
 * 
 * <h3>ArrayHeap</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ArrayMinHeap
 * @see ArrayMaxHeap
 */
public abstract class ArrayHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {
    /**
     * The index of the last node added in this heap.
     */
    protected int lastIndex;

    /**
     * Constructs an empty heap.
     */
    protected ArrayHeap() {
        super();
        lastIndex = -1;
    }

    /**
     * Returns the next parent node index where a new element can be added in this
     * array heap.
     *
     * @return The next parent node index where a new element can be added.
     */
    protected int getNextParent() {
        int result = lastIndex;
        while (result != 0 && ((result - 1) / 2) * 2 + 1 != result)
            result = (result - 1) / 2;
        if (result != 0) {
            if (list.get(((result - 1) / 2) * 2 + 2) == null)
                result = (result - 1) / 2;
            else {
                result = ((result - 1) / 2) * 2 + 2;
                while (list.get(result * 2 + 1) != null)
                    result = result * 2 + 1;
            }
        } else
            while (list.get(result * 2 + 1) != null)
                result = result * 2 + 1;
        return result;
    }

    /**
     * Returns the height of this heap.
     * 
     * @return the height of this heap
     */
    protected int getHeight() {
        if (isEmpty())
            return -1;
        return (int) (Math.floor(Math.log(size()) / Math.log(2)));
    }

    /**
     * Returns the new last node index in this array heap.
     *
     * @return the new last node index in this array heap
     */
    protected int getNewLastNode() {
        int result = lastIndex;
        while (result != 0 && ((result - 1) / 2) * 2 + 1 == result)
            result = (result - 1) / 2;
        if (result != 0)
            result = ((result - 1) / 2) * 2 + 1;
        while (result * 2 + 2 < list.size() && list.get(result * 2 + 2) != null)
            result = result * 2 + 2;
        return result;
    }
}
