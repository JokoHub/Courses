package com.joko.IBA.ReflectionCopy;

/**
 * Created by Joko on 26.11.2016.
 */
public class Reflection {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        MyObject object1 = new MyObject(5, 10, "hello!");
        MyObject object2 = new CopyClass<MyObject>().copyObject(object1);

        System.out.println(object2.toString());
    }
}
