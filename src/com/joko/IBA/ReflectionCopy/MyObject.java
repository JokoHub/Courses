package com.joko.IBA.ReflectionCopy;

/**
 * Created by Joko on 26.11.2016.
 */
public class MyObject {

    public int intValue;
    public long longValue;
    public String stringValue;

    public MyObject(){}

    public MyObject (int a, long b, String c){
        intValue = a;
        longValue = b;
        stringValue = c;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "intValue=" + intValue +
                ", longValue=" + longValue +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }
}
