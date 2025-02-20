package dev.dsf;

import dev.dsf.abstractdatatype.collection.CollectionADT;

public abstract class CollectionTesting {
    protected static void Class(CollectionADT collection) {
        System.out.println("Class: " + collection.getClass());
    }

    protected static void Collection(CollectionADT collection) {
        System.out.println("(" + collection.size() + ")" + collection);
    }
}
