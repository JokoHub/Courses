package com.joko.IBA.ArraysTask;

/**
 * Created by Joko on 27.11.2016.
 */
public class TestArrays {
    public static void main(String[] args) {

        int[] array1 = {2, 3, 5, 7, 11, 13, 17, 19};
        int[] array2;

        System.out.println("Array1 is ");
        printArray(array1);

        array2 = array1;
        array2[0] = 0;
        array2[2] = 2;
        array2[4] = 4;
        array2[6] = 6;

        System.out.println("Array1 is ");
        printArray(array1);
    }

    public static void printArray(int[] array) {
        System.out.print('<');
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if ((i + 1) < array.length) {
                System.out.print(", ");
            }
        }
        System.out.println('>');
    }

}

