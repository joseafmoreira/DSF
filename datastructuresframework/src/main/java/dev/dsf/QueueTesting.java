package dev.dsf;

import dev.dsf.abstractdatatype.QueueADT;
import dev.dsf.datastructure.queue.ArrayQueue;
import dev.dsf.datastructure.queue.LinkedQueue;

public abstract class QueueTesting {
    private static final String CLASS = "ARRAY";

    public static void main(String[] args) {
        QueueADT<Integer> queue = (CLASS.equals("ARRAY") ? new ArrayQueue<>() : new LinkedQueue<>());
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(2);
        System.out.println("(" + queue.size() + ")" + queue);

        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Top element: " + queue.first());
        System.out.println("(" + queue.size() + ")" + queue);
    }
}
