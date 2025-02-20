package dev.dsf.datastructure.priorityqueue.orderedlist.min;

import dev.dsf.datastructure.list.ordered.OrderedLinkedList;
import dev.dsf.node.PriorityQueueNode;

/**
 * Ordered doubly-linked list implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>OrderedDoubleLinkedListMaxPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class OrderedLinkedListMinPriorityQueue<T>
          extends AbstractOrderedListMinPriorityQueue<T, OrderedLinkedList<PriorityQueueNode<T>>> {
     /**
      * Construct an empty priority queue.
      */
     public OrderedLinkedListMinPriorityQueue() {
          collection = new OrderedLinkedList<>();
     }
}
