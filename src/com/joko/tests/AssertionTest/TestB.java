package com.joko.tests.AssertionTest;

/**
 * Created by Joko on 01.12.2016.
 */
public abstract class TestB {

    public static int countValue(int a, int b){
        assert (a > 0 && b > 0);
        return (a + b) * 2;
    }
}
