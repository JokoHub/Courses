package com.joko.IBA.AdvancedClassFeatures.Exercise2;

/**
 * Created by Joko on 01.12.2016.
 */
public class TestAnimal {

    public static void main(String[] args) {
        Fish f = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat();

        System.out.println("Let's play with Fish and Cat");
        f.play();
        c.play();

        System.out.println("Let's see how spider eats!");
        e.eat();
        e.walk();

        System.out.println("Let's take a fish for a walk!");
        a.walk();
    }
}
