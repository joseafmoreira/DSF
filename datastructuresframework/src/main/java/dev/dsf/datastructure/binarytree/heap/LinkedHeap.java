package dev.dsf.datastructure.binarytree.heap;

import dev.dsf.abstractdatatype.binarytree.HeapADT;
import dev.dsf.datastructure.binarytree.LinkedBinaryTree;
import dev.dsf.datastructure.binarytree.heap.max.LinkedMaxHeap;
import dev.dsf.datastructure.binarytree.heap.min.LinkedMinHeap;
import dev.dsf.node.HeapNode;

/**
 * This class provides a skeletal implemetation for a linked-based
 * heap having all the common method implementations.
 * <p>
 * 
 * <h3>LinkedHeap</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see LinkedMinHeap
 * @see LinkedMaxHeap
 */
public abstract class LinkedHeap<T> extends LinkedBinaryTree<T> implements HeapADT<T> {
    /**
     * The reference to the last node added in this heap.
     */
    protected HeapNode<T> lastNode;

    /**
     * Constructs an empty heap.
     */
    protected LinkedHeap() {
        super();
        lastNode = null;
    }

    /**
     * Returns the next parent node where a new element can be added in this linked
     * min-heap.
     *
     * @return The next parent node where a new element can be added.
     */
    protected HeapNode<T> getNextParent() {
        HeapNode<T> result = lastNode;
        while (result != root && result.getParent().getLeft() != result)
            result = result.getParent();
        if (result != root) {
            if (result.getParent().getRight() == null)
                result = result.getParent();
            else {
                result = result.getParent().getRight();
                while (result.getLeft() != null)
                    result = result.getLeft();
            }
        } else
            while (result.getLeft() != null)
                result = result.getLeft();
        return result;
    }

    /**
     * Returns the new last node in this linked heap.
     *
     * @return the new last node in this linked heap
     */
    protected HeapNode<T> getNewLastNode() {
        HeapNode<T> result = lastNode;
        while (result != root && result.getParent().getLeft() == result)
            result = result.getParent();
        if (result != root)
            result = result.getParent().getLeft();
        while (result.getRight() != null)
            result = result.getRight();
        return result;
    }
}
