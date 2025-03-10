package dev.dsf;

import dev.dsf.abstractdatatype.binarytree.MinHeapADT;
import dev.dsf.datastructure.binarytree.heap.min.ArrayMinHeap;
import dev.dsf.datastructure.binarytree.heap.min.LinkedMinHeap;

public abstract class MinHeapTesting extends CollectionTesting {
    private static final boolean isArray = true;

    public static void main(String[] args) {
        MinHeapADT<Integer> heap = (isArray ? new ArrayMinHeap<>() : new LinkedMinHeap<>());
        Class(heap);

        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(1);
        Collection(heap);

        System.out.println("Root element: " + heap.findMin());
        System.out.println("Removed min: " + heap.removeMin());
        Collection(heap);

        heap.clear();
        Collection(heap);
    }
}
