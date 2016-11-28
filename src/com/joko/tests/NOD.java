package com.joko.tests;

/**
 * Created by User on 22.08.2016.
 */
public class NOD {
    static int a = 105;
    static int b = 70;

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args){
        System.out.print(gcd(a,b));
    }
}
