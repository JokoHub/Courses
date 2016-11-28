package com.joko.IBA.ReflectionProxyCopy;

import java.lang.reflect.Field;

/**
 * Created by Joko on 26.11.2016.
 */
public class MyObjectProxy implements ObjectInterface {
    private MyObject myObject;

    public MyObject copyObject (MyObject object) throws IllegalAccessException, InstantiationException {
        Class<MyObject> tempClass = (Class<MyObject>) object.getClass();
        myObject = tempClass.newInstance();
        Field[] fields = tempClass.getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);
            field.set(myObject, field.get(object));
        }

        return myObject;
    }


}
