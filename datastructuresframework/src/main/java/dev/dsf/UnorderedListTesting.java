package dev.dsf;

import dev.dsf.abstractdatatype.list.UnorderedListADT;
import dev.dsf.datastructure.list.unordered.UnorderedArrayList;
import dev.dsf.datastructure.list.unordered.UnorderedDoubleLinkedList;
import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;

public abstract class UnorderedListTesting extends ListTesting {
    public static void main(String[] args) {
        UnorderedListADT<Integer> list = getInstance(Type.DLINKED);
        Class(list);

        list.addLast(1);
        list.addLast(3);
        list.addLast(2);
        list.addLast(5);
        list.addFirst(4);
        list.addAfter(7, 4);
        list.addAfter(9, 5);
        list.addAfter(6, 1);
        list.addBefore(8, 6);
        Collection(list);

        System.out.println("Removed element: " + list.removeFirst());
        System.out.println("Removed element: " + list.removeLast());
        System.out.println("Removed element: " + list.remove(3));
        Collection(list);

        list.sort();
        Collection(list);
        System.out.println("First element: " + list.first());
        System.out.println("Last element: " + list.last());
        System.out.println("Element at index 4: " + list.get(4));
        System.out.println("Contains element 4? " + list.contains(4));

        System.out.println("Element at index 2 before change: " + list.set(2, 4));
        Collection(list);
        System.out.println("Contains element 4? " + list.contains(4));
        
        list.clear();
        Collection(list);
    }

    private static <T> UnorderedListADT<T> getInstance(Type type) {
        return switch (type) {
            case ARRAY -> new UnorderedArrayList<>(ARRAY_INITIAL_CAPACITY);
            case LINKED -> new UnorderedLinkedList<>();
            case DLINKED -> new UnorderedDoubleLinkedList<>();
            default -> null;
        };
    }
}
