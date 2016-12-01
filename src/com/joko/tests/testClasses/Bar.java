package com.joko.tests.testClasses;

/**
 * Created by Joko on 29.11.2016.
 */
public class Bar {
    public Bar(String a, String b) {
        System.out.println("Bar Constructor >>> " + a + " " + b);
    }

    public void printCL() {
        System.out.println("Bar ClassLoader: "+Bar.class.getClassLoader());
    }
}
