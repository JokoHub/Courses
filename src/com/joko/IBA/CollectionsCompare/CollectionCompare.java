package com.joko.IBA.CollectionsCompare;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by Joko on 01.12.2016.
 */
public class CollectionCompare {

    public static void main(String[] args) {
        TestClassA a = new TestClassA(5, 10.0, "wow");
        TestClassA b = new TestClassA(10, 15.0, "woohoo");
        TestClassA c = new TestClassA();
        TestClassA d = new TestClassA();

        Set<TestClassA> mySet = new HashSet<>();
        mySet.add(c);
        mySet.add(a);
        mySet.add(b);
        mySet.add(d);

    }
}
