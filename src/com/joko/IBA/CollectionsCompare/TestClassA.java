package com.joko.IBA.CollectionsCompare;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Random;

/**
 * Created by Joko on 01.12.2016.
 */
public class TestClassA {

    public int a;
    public double b;
    public String c;

    public TestClassA(int a, double b, String c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TestClassA(){
        a = 5;
        b = 5.0;
        c = "Hi";
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(1, 3, this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }
}
