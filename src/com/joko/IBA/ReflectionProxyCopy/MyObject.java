package com.joko.IBA.ReflectionProxyCopy;

/**
 * Created by Joko on 26.11.2016.
 */
public class MyObject implements ObjectInterface {

    public int intValue;
    public long longValue;
    private String stringValue;

    public MyObject(int a, long b, String c){
        intValue = a;
        longValue = b;
        stringValue = c;
    }

    public MyObject(){}

    @Override
    public String toString() {
        return "MyObject{" +
                "intValue=" + intValue +
                ", longValue=" + longValue +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }
}
