package com.joko.tests.classLoader;

//import com.joko.tests.testClasses.Bar;

import java.net.URL;

/**
 * Created by Joko on 27.11.2016.
 */
public class Launcher {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader = new MyClassLoader();

        URL url = Launcher.class.getResource("TestClass.class");
        Object object;
        System.out.println(url.getPath().replaceFirst("/", "").replaceAll("/", "/"));
//        Object o = url.getFile();
//        System.out.println(o.getClass());
//        loader.loadClass(url.getFile());

//        Class myClass = loader.loadClass(progClass);
//        Object o = myClass.newInstance();
//        o.toString();


//        MyClassLoader ccl = new MyClassLoader(Launcher.class.getClassLoader());
//        Class clas = ccl.loadClass(progClass);
//        Bar o = (Bar)clas.newInstance();
//        o.printCL();
    }
}
