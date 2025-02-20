package dev.dsf.datastructure.priorityqueue.orderedlist.max;

import dev.dsf.datastructure.list.ordered.OrderedArrayList;
import dev.dsf.node.PriorityQueueNode;

/**
 * Ordered array list implementation of the {@code PriorityQueueADT} interface.
 * 
 * <h3>OrderedArrayListMaxPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class OrderedArrayListMaxPriorityQueue<T>
                extends AbstractOrderedListMaxPriorityQueue<T, OrderedArrayList<PriorityQueueNode<T>>> {
        /**
         * Construct an empty priority queue.
         */
        public OrderedArrayListMaxPriorityQueue() {
                collection = new OrderedArrayList<>();
        }
}
