package com.joko.tests.classLoader;

import java.io.*;

/**
 * Created by Joko on 27.11.2016.
 */
public class MyClassLoader extends ClassLoader {

//    @Override
//    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
//        try {
//            FileInputStream fis = new FileInputStream(name);
//            byte[] bbuf = new byte[(int) (new File(name).length())];
//            System.out.println(bbuf.length);
//            fis.read(bbuf);
//            fis.close();
//            return defineClass(name, bbuf, 0, bbuf.length);
//        } catch (Exception e) {
//            System.out.println(e);
//            throw new ClassNotFoundException();
//        }
//    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
//public MyClassLoader(ClassLoader parent) {
//    super(parent);
//}
//
//    private Class getClass(String name) throws ClassNotFoundException {
//        String file = name.replace('.', File.separatorChar) + ".class";
//        byte[] b = null;
//        try {
//            b = loadClassFileData(file);
//            Class c = defineClass(name, b, 0, b.length);
//            resolveClass(c);
//            return c;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public Class loadClass(String name) throws ClassNotFoundException {
//        System.out.println("Loading Class '" + name + "'");
//        if (name.startsWith("D")) {
//            System.out.println("Loading Class using CCLoader");
//            return getClass(name);
//        }
//        return super.loadClass(name);
//    }
//
//    private byte[] loadClassFileData(String name) throws IOException {
//        InputStream stream = getClass().getClassLoader().getResourceAsStream(
//                name);
//        int size = stream.available();
//        byte buff[] = new byte[size];
//        DataInputStream in = new DataInputStream(stream);
//        in.readFully(buff);
//        in.close();
//        return buff;
//    }
//}
