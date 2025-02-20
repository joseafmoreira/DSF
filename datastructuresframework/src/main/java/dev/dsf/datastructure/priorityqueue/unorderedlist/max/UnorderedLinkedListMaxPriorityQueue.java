package dev.dsf.datastructure.priorityqueue.unorderedlist.max;

import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;
import dev.dsf.node.PriorityQueueNode;

/**
 * Unordered singly-linked list implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>UnorderedDoubleLinkedListMaxPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class UnorderedLinkedListMaxPriorityQueue<T>
          extends AbstractUnorderedListMaxPriorityQueue<T, UnorderedLinkedList<PriorityQueueNode<T>>> {
     /**
      * Construct an empty priority queue.
      */
     public UnorderedLinkedListMaxPriorityQueue() {
          collection = new UnorderedLinkedList<>();
     }
}
