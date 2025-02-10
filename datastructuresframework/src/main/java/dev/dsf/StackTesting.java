package dev.dsf;

import dev.dsf.abstractdatatype.StackADT;
import dev.dsf.datastructure.stack.ArrayStack;
import dev.dsf.datastructure.stack.LinkedStack;

public abstract class StackTesting extends CollectionTesting {
    private static final boolean isArray = true;

    public static void main(String[] args) {
        StackADT<Integer> stack = (isArray ? new ArrayStack<>() : new LinkedStack<>());
        Class(stack);

        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        Collection(stack);

        System.out.println("Removed element: " + stack.pop());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Top element: " + stack.peek());
        Collection(stack);
    }
}
