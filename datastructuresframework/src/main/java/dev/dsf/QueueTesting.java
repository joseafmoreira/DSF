package dev.dsf;

import dev.dsf.abstractdatatype.QueueADT;
import dev.dsf.datastructure.queue.ArrayQueue;
import dev.dsf.datastructure.queue.LinkedQueue;

public abstract class QueueTesting extends CollectionTesting {
    private static final boolean isArray = false;

    public static void main(String[] args) {
        QueueADT<Integer> queue = (isArray ? new ArrayQueue<>() : new LinkedQueue<>());
        Class(queue);

        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(2);
        Collection(queue);

        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Top element: " + queue.first());
        Collection(queue);
    }
}
