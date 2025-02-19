package dev.dsf.datastructure.binarytree;

import java.util.Iterator;
import java.util.StringJoiner;

import dev.dsf.abstractdatatype.BinaryTreeADT;
import dev.dsf.abstractdatatype.QueueADT;
import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.datastructure.binarytree.heap.ArrayHeap;
import dev.dsf.datastructure.binarytree.search.ArrayBinarySearchTree;
import dev.dsf.datastructure.collection.AbstractListBasedCollection;
import dev.dsf.datastructure.list.unordered.UnorderedArrayList;
import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;
import dev.dsf.datastructure.queue.LinkedQueue;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Resizable-array list implementation of the {@code BinaryTreeADT} interface.
 * 
 * <h3>ArrayBinaryTree</h3>
 * 
 * @param <T> the type of element stored in this binary tree
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ArrayBinarySearchTree
 * @see ArrayHeap
 */
public abstract class ArrayBinaryTree<T> extends AbstractListBasedCollection<T> implements BinaryTreeADT<T> {
    /**
     * Constructs an empty binary tree.
     */
    protected ArrayBinaryTree() {
        super(false);
        list = new UnorderedArrayList<>();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T getRoot() {
        if (isEmpty())
            throw new EmptyCollectionException("Binary tree is empty");
        return list.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        if (!isEmpty())
            preOrder(0, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        if (!isEmpty())
            inOrder(0, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        if (!isEmpty())
            postOrder(0, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        QueueADT<Integer> queue = new LinkedQueue<>();
        if (!isEmpty())
            queue.enqueue(0);
        while (!queue.isEmpty()) {
            int currentIndex = queue.dequeue();
            T element = this.list.get(currentIndex);
            if (element != null) {
                list.addLast(this.list.get(currentIndex));
                if (currentIndex * 2 + 1 < this.list.size())
                    queue.enqueue(currentIndex * 2 + 1);
                if (currentIndex * 2 + 2 < this.list.size())
                    queue.enqueue(currentIndex * 2 + 2);
            }
        }
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringJoiner message = new StringJoiner(", ", "[", "]");
        for (T element : this)
            message.add(element.toString());
        return message.toString();
    }

    /**
     * Performs a pre-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentIndex the current index being visited
     * @param list         the list to add the elements to
     */
    private void preOrder(int currentIndex, UnorderedListADT<T> list) {
        if (currentIndex >= this.list.size() || this.list.get(currentIndex) == null)
            return;
        list.addLast(this.list.get(currentIndex));
        preOrder(currentIndex * 2 + 1, list);
        preOrder(currentIndex * 2 + 2, list);
    }

    /**
     * Performs an in-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentIndex the current index being visited
     * @param list         the list to add the elements to
     */
    private void inOrder(int currentIndex, UnorderedListADT<T> list) {
        if (currentIndex >= this.list.size() || this.list.get(currentIndex) == null)
            return;
        inOrder(currentIndex * 2 + 1, list);
        list.addLast(this.list.get(currentIndex));
        inOrder(currentIndex * 2 + 2, list);
    }

    /**
     * Performs a post-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentIndex  the current index being visited
     * @param unorderedList the list to add the elements to
     */
    private void postOrder(int currentIndex, UnorderedListADT<T> list) {
        if (currentIndex >= this.list.size() || this.list.get(currentIndex) == null)
            return;
        postOrder(currentIndex * 2 + 1, list);
        postOrder(currentIndex * 2 + 2, list);
        list.addLast(this.list.get(currentIndex));
    }
}
