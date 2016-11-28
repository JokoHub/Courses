package com.joko.tests.classLoader;

/**
 * Created by Joko on 27.11.2016.
 */
public class Launcher {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fileName = "D:\\TestProjects\\src\\TestClass\\.class";
        MyClassLoader loader = new MyClassLoader();
        Class myClass = loader.loadClass(fileName);
        Object o = myClass.newInstance();
        o.toString();
    }
}
