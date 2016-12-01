package com.joko.IBA.AdvancedClassFeatures.Exercise2;

/**
 * Created by Joko on 01.12.2016.
 */
public abstract class Animal {

    protected int tLegs;

    protected Animal(int oLegs){
        tLegs = oLegs;
    }

    public abstract void eat();

    public void walk(){
        System.out.println("This animal walks on " + tLegs + " legs.");
    }
}
