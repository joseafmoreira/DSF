package dev.dsf.datastructure.priorityqueue.unorderedlist.min;

import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;
import dev.dsf.node.PriorityQueueNode;

/**
 * Unordered singly-linked list implementation of the {@code PriorityQueueADT}
 * interface.
 * 
 * <h3>UnorderedLinkedListMinPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class UnorderedLinkedListMinPriorityQueue<T>
          extends AbstractUnorderedListMinPriorityQueue<T, UnorderedLinkedList<PriorityQueueNode<T>>> {
     /**
      * Construct an empty priority queue.
      */
     public UnorderedLinkedListMinPriorityQueue() {
          collection = new UnorderedLinkedList<>();
     }
}
