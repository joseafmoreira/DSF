package dev.dsf;

import dev.dsf.abstractdatatype.priorityqueue.PriorityQueueADT;
import dev.dsf.datastructure.priorityqueue.binarysearchtree.max.ArrayBinarySearchTreeMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.binarysearchtree.max.LinkedBinarySearchTreeMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.heap.max.ArrayHeapMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.heap.max.LinkedHeapMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.orderedlist.max.OrderedArrayListMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.orderedlist.max.OrderedDoubleLinkedListMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.orderedlist.max.OrderedLinkedListMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.unorderedlist.max.UnorderedArrayListMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.unorderedlist.max.UnorderedDoubleLinkedListMaxPriorityQueue;
import dev.dsf.datastructure.priorityqueue.unorderedlist.max.UnorderedLinkedListMaxPriorityQueue;

public abstract class MaxPriorityQueueTesting extends PriorityQueueTesting {
    public static void main(String[] args) {
        PriorityQueueADT<Integer> priorityQueue = getInstance(Type.UNORDEREDDLINKEDLIST);
        Class(priorityQueue);

        priorityQueue.enqueue(2, 1);
        priorityQueue.enqueue(1, 0);
        priorityQueue.enqueue(3, 1);
        Collection(priorityQueue);

        System.out.println("Root element: " + priorityQueue.first());
        System.out.println("Removed element: " + priorityQueue.dequeue());
        Collection(priorityQueue);

        priorityQueue.clear();
        Collection(priorityQueue);
    }

    private static <T> PriorityQueueADT<T> getInstance(Type type) {
        return switch (type) {
            case ARRAYBINARYSEARCHTREE -> new ArrayBinarySearchTreeMaxPriorityQueue<>();
            case ARRAYHEAP -> new ArrayHeapMaxPriorityQueue<>();
            case ORDEREDARRAYLIST -> new OrderedArrayListMaxPriorityQueue<>();
            case UNORDEREDARRAYLIST -> new UnorderedArrayListMaxPriorityQueue<>();
            case LINKEDHEAP -> new LinkedHeapMaxPriorityQueue<>();
            case LINKEDBINARYSEARCHTREE -> new LinkedBinarySearchTreeMaxPriorityQueue<>();
            case ORDEREDLINKEDLIST -> new OrderedLinkedListMaxPriorityQueue<>();
            case UNORDEREDLINKEDLIST -> new UnorderedLinkedListMaxPriorityQueue<>();
            case ORDEREDDLINKEDLIST -> new OrderedDoubleLinkedListMaxPriorityQueue<>();
            case UNORDEREDDLINKEDLIST -> new UnorderedDoubleLinkedListMaxPriorityQueue<>();
            default -> null;
        };
    }
}
