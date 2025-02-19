package dev.dsf;

import dev.dsf.abstractdatatype.MaxHeapADT;
import dev.dsf.datastructure.binarytree.heap.ArrayMaxHeap;

public class MaxHeapTesting extends CollectionTesting {
    private static final boolean isArray = true;

    public static void main(String[] args) {
        MaxHeapADT<Integer> heap = new ArrayMaxHeap<>();
        Class(heap);

        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(1);
        Collection(heap);

        System.out.println("Root element: " + heap.findMax());
        System.out.println("Removed max: " + heap.removeMax());
        Collection(heap);

        heap.clear();
        Collection(heap);
    }
}
