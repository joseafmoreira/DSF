package dev.dsf;

import dev.dsf.abstractdatatype.OrderedListADT;
import dev.dsf.datastructure.list.ordered.OrderedArrayList;
import dev.dsf.datastructure.list.ordered.OrderedDoubleLinkedList;
import dev.dsf.datastructure.list.ordered.OrderedLinkedList;

public abstract class OrderedListTesting {
    private static final String CLASS = "ARRAY";
    private static final int CAPACITY = 0;

    public static void main(String[] args) {
        OrderedListADT<Integer> list = (CLASS.equals("ARRAY") ? new OrderedArrayList<>(CAPACITY)
                : (CLASS.equals("LINKED") ? new OrderedLinkedList<>() : new OrderedDoubleLinkedList<>()));
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(6);
        list.add(8);
        System.out.println("(" + list.size() + ")" + list);

        System.out.println("Removed element: " + list.removeFirst());
        System.out.println("Removed element: " + list.removeLast());
        System.out.println("Removed element: " + list.remove(3));
        System.out.println("(" + list.size() + ")" + list);

        System.out.println("First element: " + list.first());
        System.out.println("Last element: " + list.last());
        System.out.println("Element at index 4: " + list.get(4));
        System.out.println("Contains element 4? " + list.contains(4));

        list.clear();
        System.out.println("(" + list.size() + ")" + list);
    }
}
