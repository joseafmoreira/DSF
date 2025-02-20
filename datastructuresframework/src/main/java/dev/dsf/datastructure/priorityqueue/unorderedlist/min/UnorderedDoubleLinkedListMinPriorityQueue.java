package dev.dsf.datastructure.priorityqueue.unorderedlist.min;

import dev.dsf.datastructure.list.unordered.UnorderedDoubleLinkedList;
import dev.dsf.node.PriorityQueueNode;

/**
 * Unordered doubly-linked list implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>UnorderedDoubleLinkedListMinPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class UnorderedDoubleLinkedListMinPriorityQueue<T>
          extends AbstractUnorderedListMinPriorityQueue<T, UnorderedDoubleLinkedList<PriorityQueueNode<T>>> {
     /**
      * Construct an empty priority queue.
      */
     public UnorderedDoubleLinkedListMinPriorityQueue() {
          collection = new UnorderedDoubleLinkedList<>();
     }
}
