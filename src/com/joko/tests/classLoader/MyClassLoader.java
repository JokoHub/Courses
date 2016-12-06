package com.joko.tests.classLoader;

import java.io.*;
import java.util.Map;

/**
 * Created by Joko on 27.11.2016.
 */
public class MyClassLoader extends ClassLoader {

    Map<String, String> nameMap;

    public MyClassLoader(Map<String, String> map) {
        nameMap = map;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            System.out.println("loading class + " + name);

            if (!nameMap.containsKey(name)) {
                System.out.println("loading class using standard classLoader!");
                return super.findSystemClass(name);
            }

            String fileName = nameMap.get(name);
            FileInputStream fis = new FileInputStream(fileName);
            byte[] bbuf = new byte[(int) (new File(fileName).length())];
            fis.read(bbuf);
            fis.close();
            System.out.println("loading class using private classLoader!");
            Class loadedClass = defineClass(name, bbuf, 0, bbuf.length);

            long objectSize = ObjectSizeFetcher.getObjectSize(loadedClass);
            System.out.println("The size of loaded class is " + objectSize);
            if (objectSize < 1000) {
                return loadedClass;
            } else {
                throw new RuntimeException("Loading class is too big to load.");
            }

//            return loadedClass;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
            throw new ClassNotFoundException();
        }
    }
}
