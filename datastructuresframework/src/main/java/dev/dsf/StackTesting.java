package dev.dsf;

import dev.dsf.abstractdatatype.StackADT;
import dev.dsf.datastructure.stack.ArrayStack;
import dev.dsf.datastructure.stack.LinkedStack;

public abstract class StackTesting {
    private static final boolean isArray = false;

    public static void main(String[] args) {
        StackADT<Integer> stack = (isArray ? new ArrayStack<>() : new LinkedStack<>());
        System.out.println("Stack class: " + stack.getClass());

        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        System.out.println("(" + stack.size() + ")" + stack);

        System.out.println("Removed element: " + stack.pop());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Top element: " + stack.peek());
        System.out.println("(" + stack.size() + ")" + stack);
    }
}
