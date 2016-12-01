package com.joko.IBA.AdvancedClassFeatures.Exercise2;

/**
 * Created by Joko on 01.12.2016.
 */
public class Spider extends Animal {

    public Spider(){
        super(8);
    }

    @Override
    public void eat() {
        System.out.println("The spider eats a fly.");
    }
}
