package com.joko.tests;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Joko
 */
public class FirstTry {
    public static void main (String[] args){
        int a = 130;
        byte b = (byte) a;
//        System.out.println(b);
//        System.out.print(5^9);
        TreeSet<Integer> mySet = new TreeSet<>();
        mySet.add(5);
        mySet.add(3);
        mySet.add(2);
        System.out.println(mySet);
        System.out.print(mySet.tailSet(5));

        List<String> myList = new LinkedList<>();

    }


}

//