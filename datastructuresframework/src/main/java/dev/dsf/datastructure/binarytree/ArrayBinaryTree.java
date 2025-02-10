package dev.dsf.datastructure.binarytree;

import java.util.Iterator;

import dev.dsf.abstractdatatype.BinaryTreeADT;
import dev.dsf.abstractdatatype.QueueADT;
import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.datastructure.binarytree.heap.ArrayHeap;
import dev.dsf.datastructure.binarytree.search.ArrayBinarySearchTree;
import dev.dsf.datastructure.collection.AbstractIterableCollection;
import dev.dsf.datastructure.list.unordered.UnorderedArrayList;
import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;
import dev.dsf.datastructure.queue.LinkedQueue;
import dev.dsf.exception.EmptyCollectionException;

/**
 * Resizable-array list implementation of the {@code BinaryTreeADT} interface.
 * 
 * <h3>LinkedBinaryTree</h3>
 * 
 * @param <T> the type of element stored in this binary tree
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ArrayBinarySearchTree
 * @see ArrayHeap
 */
public abstract class ArrayBinaryTree<T> extends AbstractIterableCollection<T> implements BinaryTreeADT<T> {
    /**
     * The array list containing the elements of this binary tree
     */
    protected UnorderedArrayList<T> list;

    /**
     * Constructs an empty binary tree.
     */
    protected ArrayBinaryTree() {
        super();
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
    public void clear() {
        super.clear();
        list = new UnorderedArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        preOrder(0, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
        inOrder(0, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        UnorderedListADT<T> list = new UnorderedLinkedList<>();
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
            int index = queue.dequeue();
            T element = this.list.get(index);
            if (element != null) {
                list.addLast(this.list.get(index));
                if (index * 2 + 1 < this.list.size())
                    queue.enqueue(index * 2 + 1);
                if (index * 2 + 2 < this.list.size())
                    queue.enqueue(index * 2 + 2);
            }
        }
        return list.iterator();
    }

    /**
     * Performs a pre-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentNode the current node being visited
     * @param list        the list to add the elements to
     */
    private void preOrder(int index, UnorderedListADT<T> list) {
        if (index >= this.list.size() || this.list.get(index) == null)
            return;
        list.addLast(this.list.get(index));
        preOrder(index * 2 + 1, list);
        preOrder(index * 2 + 2, list);
    }

    /**
     * Performs an in-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentNode the current node being visited
     * @param list        the list to add the elements to
     */
    private void inOrder(int index, UnorderedListADT<T> list) {
        if (index >= this.list.size() || this.list.get(index) == null)
            return;
        inOrder(index * 2 + 1, list);
        list.addLast(this.list.get(index));
        inOrder(index * 2 + 2, list);
    }

    /**
     * Performs a post-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentNode   the current node being visited
     * @param unorderedList the list to add the elements to
     */
    private void postOrder(int index, UnorderedListADT<T> list) {
        if (index >= this.list.size() || this.list.get(index) == null)
            return;
        postOrder(index * 2 + 1, list);
        postOrder(index * 2 + 2, list);
        list.addLast(this.list.get(index));
    }
}
