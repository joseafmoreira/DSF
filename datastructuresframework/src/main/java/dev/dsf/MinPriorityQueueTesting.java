package dev.dsf;

import dev.dsf.abstractdatatype.PriorityQueueADT;
import dev.dsf.datastructure.priorityqueue.binarysearchtree.min.ArrayBinarySearchTreeMinPriorityQueue;
import dev.dsf.datastructure.priorityqueue.binarysearchtree.min.LinkedBinarySearchTreeMinPriorityQueue;
import dev.dsf.datastructure.priorityqueue.heap.min.ArrayHeapMinPriorityQueue;
import dev.dsf.datastructure.priorityqueue.heap.min.LinkedHeapMinPriorityQueue;
import dev.dsf.datastructure.priorityqueue.orderedlist.min.OrderedArrayListMinPriorityQueue;
import dev.dsf.datastructure.priorityqueue.orderedlist.min.OrderedDoubleLinkedListMinPriorityQueue;
import dev.dsf.datastructure.priorityqueue.orderedlist.min.OrderedLinkedListMinPriorityQueue;
import dev.dsf.datastructure.priorityqueue.unorderedlist.min.UnorderedArrayListMinPriorityQueue;
import dev.dsf.datastructure.priorityqueue.unorderedlist.min.UnorderedDoubleLinkedListMinPriorityQueue;
import dev.dsf.datastructure.priorityqueue.unorderedlist.min.UnorderedLinkedListMinPriorityQueue;

public abstract class MinPriorityQueueTesting extends PriorityQueueTesting {
    public static void main(String[] args) {
        PriorityQueueADT<Integer> priorityQueue = getInstance(Type.UNORDEREDDLINKEDLIST);
        Class(priorityQueue);

        priorityQueue.enqueue(2, 1);
        priorityQueue.enqueue(1, 0);
        Collection(priorityQueue);

        System.out.println("Root element: " + priorityQueue.first());
        System.out.println("Removed element: " + priorityQueue.dequeue());
        Collection(priorityQueue);

        priorityQueue.clear();
        Collection(priorityQueue);
    }

    private static <T> PriorityQueueADT<T> getInstance(Type type) {
        return switch (type) {
            case ARRAYBINARYSEARCHTREE -> new ArrayBinarySearchTreeMinPriorityQueue<>();
            case ARRAYHEAP -> new ArrayHeapMinPriorityQueue<>();
            case ORDEREDARRAYLIST -> new OrderedArrayListMinPriorityQueue<>();
            case UNORDEREDARRAYLIST -> new UnorderedArrayListMinPriorityQueue<>();
            case LINKEDHEAP -> new LinkedHeapMinPriorityQueue<>();
            case LINKEDBINARYSEARCHTREE -> new LinkedBinarySearchTreeMinPriorityQueue<>();
            case ORDEREDLINKEDLIST -> new OrderedLinkedListMinPriorityQueue<>();
            case UNORDEREDLINKEDLIST -> new UnorderedLinkedListMinPriorityQueue<>();
            case ORDEREDDLINKEDLIST -> new OrderedDoubleLinkedListMinPriorityQueue<>();
            case UNORDEREDDLINKEDLIST -> new UnorderedDoubleLinkedListMinPriorityQueue<>();
            default -> null;
        };
    }
}
