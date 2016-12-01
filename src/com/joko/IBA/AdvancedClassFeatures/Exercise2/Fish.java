package com.joko.IBA.AdvancedClassFeatures.Exercise2;

/**
 * Created by Joko on 01.12.2016.
 */
public class Fish extends Animal implements Pet {

    private String tName;

    public Fish(){
        super(0);
    }

    @Override
    public void eat() {
        System.out.println("Fish eat pond scum.");
    }

    @Override
    public String getName() {
        return tName;
    }

    @Override
    public void setName(String oName) {
        tName = oName;
    }

    @Override
    public void play() {
        System.out.println("Fish swim in their tanks all day.");
    }

    @Override
    public void walk() {
        super.walk();
        System.out.println("Fish, of course, can't walk; they swim.");
    }
}
