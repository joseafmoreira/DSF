package dev.dsf;

import dev.dsf.abstractdatatype.BinarySearchTreeADT;
import dev.dsf.datastructure.binarytree.search.ArrayBinarySearchTree;
import dev.dsf.datastructure.binarytree.search.LinkedBinarySearchTree;

public abstract class BinarySearchTreeTesting extends CollectionTesting {
    private static final boolean isArray = true;

    public static void main(String[] args) {
        BinarySearchTreeADT<Integer> binaryTree = (isArray ? new ArrayBinarySearchTree<>() : new LinkedBinarySearchTree<>());
        Class(binaryTree);

        binaryTree.add(7);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(1);
        Collection(binaryTree);

        System.out.println("Removed element: " + binaryTree.removeMin());
        System.out.println("Removed element: " + binaryTree.removeMax());
        System.out.println("Removed element: " + binaryTree.remove(3));
        Collection(binaryTree);

        System.out.println("Minimum element: " + binaryTree.findMin());
        System.out.println("Maximum element: " + binaryTree.findMax());
        System.out.println("Contains element 4? " + binaryTree.contains(4));

        binaryTree.clear();
        Collection(binaryTree);
    }
}
