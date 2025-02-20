package dev.dsf.datastructure.priorityqueue.orderedlist.max;

import dev.dsf.datastructure.list.ordered.OrderedLinkedList;
import dev.dsf.node.PriorityQueueNode;

/**
 * Ordered singly-linked list implementation of the {@code PriorityQueueADT}
 * interface.
 * 
 * <h3>OrderedLinkedListMaxPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class OrderedLinkedListMaxPriorityQueue<T>
          extends AbstractOrderedListMaxPriorityQueue<T, OrderedLinkedList<PriorityQueueNode<T>>> {
     /**
      * Construct an empty priority queue.
      */
     public OrderedLinkedListMaxPriorityQueue() {
          collection = new OrderedLinkedList<>();
     }
}
