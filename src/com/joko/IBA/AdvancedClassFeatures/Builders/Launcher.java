package com.joko.IBA.AdvancedClassFeatures.Builders;

/**
 * Created by Joko on 01.12.2016.
 */
public class Launcher {

    public static void main(String[] args) {
        Shape shape1 = new Shape(5, 5, 5, "red");
        Shape shape2 = new Shape(5, 5, 5, "red");
        System.out.println("Shape1 HashCode = Shape2 HashCode? ");
        System.out.println(shape1.hashCode() == shape2.hashCode());

        System.out.println("Shape1 equals Shape2? ");
        System.out.println(shape1.equals(shape2));


        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(5);
        Circle circle3 = new Circle(10);

        System.out.println("Circle1 HashCode = Circle1 HashCode? ");
        System.out.println(circle1.hashCode() == circle2.hashCode());
        System.out.println("Circle1 equals Circle2?");
        System.out.println(circle1.equals(circle2));

        System.out.println("Circle1 HashCode = Circle3 HashCode? ");
        System.out.println(circle1.hashCode() == circle3.hashCode());
        System.out.println("Circle1 equals Circle3?");
        System.out.println(circle1.equals(circle3));

    }
}
