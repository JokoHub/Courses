package com.joko.IBA.ReflectionProxyCopy;

/**
 * Created by Joko on 26.11.2016.
 */
public class Launcher {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        MyObject object1 = new MyObject(5, 10, "woohoo!");
        MyObject object2 = new MyObjectProxy().copyObject(object1);

        System.out.println(object2.toString());
    }
}
