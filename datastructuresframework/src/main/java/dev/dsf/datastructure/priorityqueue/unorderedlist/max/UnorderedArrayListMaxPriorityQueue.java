package dev.dsf.datastructure.priorityqueue.unorderedlist.max;

import dev.dsf.datastructure.list.unordered.UnorderedArrayList;
import dev.dsf.node.PriorityQueueNode;

/**
 * Unordered array list implementation of the {@code PriorityQueueADT}
 * interface.
 * 
 * <h3>UnorderedArrayListMaxPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class UnorderedArrayListMaxPriorityQueue<T>
          extends AbstractUnorderedListMaxPriorityQueue<T, UnorderedArrayList<PriorityQueueNode<T>>> {
     /**
      * Construct an empty priority queue.
      */
     public UnorderedArrayListMaxPriorityQueue() {
          collection = new UnorderedArrayList<>();
     }
}
