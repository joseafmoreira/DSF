package dev.dsf;

import dev.dsf.abstractdatatype.OrderedListADT;
import dev.dsf.datastructure.list.ordered.OrderedArrayList;
import dev.dsf.datastructure.list.ordered.OrderedDoubleLinkedList;
import dev.dsf.datastructure.list.ordered.OrderedLinkedList;

public abstract class OrderedListTesting extends ListTesting {
    public static void main(String[] args) {
        OrderedListADT<Integer> list = getInstance(Type.DLINKED);
        Class(list);

        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(6);
        list.add(8);
        Collection(list);

        System.out.println("Removed element: " + list.removeFirst());
        System.out.println("Removed element: " + list.removeLast());
        System.out.println("Removed element: " + list.remove(3));
        Collection(list);

        System.out.println("First element: " + list.first());
        System.out.println("Last element: " + list.last());
        System.out.println("Element at index 4: " + list.get(4));
        System.out.println("Contains element 4? " + list.contains(4));

        list.clear();
        Collection(list);
    }

    private static <T> OrderedListADT<T> getInstance(Type type) {
        return switch (type) {
            case ARRAY -> new OrderedArrayList<>(ARRAY_INITIAL_CAPACITY);
            case LINKED -> new OrderedLinkedList<>();
            case DLINKED -> new OrderedDoubleLinkedList<>();
            default -> null;
        };
    }
}
