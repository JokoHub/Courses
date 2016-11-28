package com.joko.tests.classLoader;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Joko on 27.11.2016.
 */
public class MyClassLoader extends ClassLoader {

    public Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(name);
            byte[] bbuf = new byte[(int) (new File(name).length())];
            fis.read(bbuf);
            fis.close();
            return defineClass(name, bbuf, 0, bbuf.length);

        } catch (Exception e) {
            System.out.println(e);
            throw new ClassNotFoundException();
        }
    }
}
