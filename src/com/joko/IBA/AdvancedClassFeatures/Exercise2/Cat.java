package com.joko.IBA.AdvancedClassFeatures.Exercise2;

/**
 * Created by Joko on 01.12.2016.
 */
public class Cat extends Animal implements Pet {

    private String tName;

    public Cat(String oName){
        super(4);
        tName = oName;
    }

    public Cat(){
        this("");
    }

    @Override
    public void eat() {
        System.out.println("Cats like to eat spiders and mice.");
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
        System.out.println(tName + " likes to play with string");
    }
}
