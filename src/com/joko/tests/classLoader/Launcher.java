package com.joko.tests.classLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joko on 27.11.2016.
 */
public class Launcher {
    public static void main(String[] args) throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("com.joko.tests.classLoader.MyClass", "D:/JavaStuff/ClassesToLoad/MyClass.class");

        MyClassLoader loader = new MyClassLoader(map);
        try {
            Class myClass = loader.loadClass("com.joko.tests.classLoader.MyClass");
            Object o = myClass.newInstance();
            System.out.println(o.toString());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }


        //System.out.println("size of loaded class is:" + ObjectSizeFetcher.getObjectSize(o));
//
//        Method method = myClass.getMethod("sayHello");
//        method.invoke(o);
    }
}
