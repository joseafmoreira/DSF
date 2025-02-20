package dev.dsf.datastructure.priorityqueue.orderedlist.min;

import dev.dsf.datastructure.list.ordered.OrderedDoubleLinkedList;
import dev.dsf.node.PriorityQueueNode;

/**
 * Ordered doubly-linked list implementation of the {@code PriorityQueueADT}
 * interface.
 * 
 * <h3>OrderedDoubleLinkedListMaxPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class OrderedDoubleLinkedListMinPriorityQueue<T>
          extends AbstractOrderedListMinPriorityQueue<T, OrderedDoubleLinkedList<PriorityQueueNode<T>>> {
     /**
      * Construct an empty priority queue.
      */
     public OrderedDoubleLinkedListMinPriorityQueue() {
          collection = new OrderedDoubleLinkedList<>();
     }
}
