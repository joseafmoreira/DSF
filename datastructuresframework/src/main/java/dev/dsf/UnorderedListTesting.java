package dev.dsf;

import dev.dsf.abstractdatatype.UnorderedListADT;
import dev.dsf.datastructure.list.unordered.UnorderedArrayList;
import dev.dsf.datastructure.list.unordered.UnorderedDoubleLinkedList;
import dev.dsf.datastructure.list.unordered.UnorderedLinkedList;

public abstract class UnorderedListTesting extends ListTesting {
    public static void main(String[] args) {
        UnorderedListADT<Integer> list = getInstance(Type.LINKED);
        System.out.println("List class: " + list.getClass());

        list.addLast(1);
        list.addLast(3);
        list.addLast(2);
        list.addLast(5);
        list.addFirst(4);
        System.out.println("(" + list.size() + ")" + list);
        list.addAfter(7, 4);
        list.addAfter(9, 5);
        list.addAfter(6, 1);
        list.addBefore(8, 6);
        System.out.println("(" + list.size() + ")" + list);

        System.out.println("Removed element: " + list.removeFirst());
        System.out.println("Removed element: " + list.removeLast());
        System.out.println("Removed element: " + list.remove(3));
        System.out.println("(" + list.size() + ")" + list);

        list.sort();
        System.out.println("(" + list.size() + ")" + list);
        System.out.println("First element: " + list.first());
        System.out.println("Last element: " + list.last());
        System.out.println("Element at index 4: " + list.get(4));
        System.out.println("Contains element 4? " + list.contains(4));

        System.out.println("Element at index 2 before change: " + list.set(2, 4));
        System.out.println("(" + list.size() + ")" + list);
        System.out.println("Contains element 4? " + list.contains(4));
        
        list.clear();
        System.out.println("(" + list.size() + ")" + list);
    }

    private static <T> UnorderedListADT<T> getInstance(Type type) {
        switch (type) {
            case ARRAY:
                return new UnorderedArrayList<>(ARRAY_INITIAL_CAPACITY);
            case LINKED:
                return new UnorderedLinkedList<>();
            case DLINKED:
                return new UnorderedDoubleLinkedList<>();
            default:
                return null;
        }
    }
}
