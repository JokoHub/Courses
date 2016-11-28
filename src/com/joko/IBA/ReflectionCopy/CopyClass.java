package com.joko.IBA.ReflectionCopy;

import java.lang.reflect.Field;

/**
 * Created by Joko on 26.11.2016.
 */
public class CopyClass<T>{

    public T copyObject (T myObject) throws IllegalAccessException, InstantiationException {
        Class<T> tempClass = (Class<T>) myObject.getClass();
        T instance = tempClass.newInstance();
        Field[] fields = tempClass.getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);
            field.set(instance, field.get(myObject));
        }
        return instance;
    }


}
