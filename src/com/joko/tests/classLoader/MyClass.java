package com.joko.tests.classLoader;

/**
 * Created by Joko on 04.12.2016.
 */
public class MyClass {

    public int a;
    public double b;
    public String s;

    public MyClass(){
        a = 5;
        b = 10.0;
        s = "well, it's a hello from MyClass";
    }
    public void sayHello(){
        System.out.println("Hello from the loaded class");
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a=" + a +
                ", b=" + b +
                ", s='" + s + '\'' +
                '}';
    }
}
