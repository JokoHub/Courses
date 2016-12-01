package com.joko.IBA.Exceptions;

/**
 * Created by Joko on 01.12.2016.
 */
public class OverdraftException extends Exception {

    private final double tDeficit;

    public OverdraftException(String msg, double oDeficit){
        super(msg);
        tDeficit = oDeficit;
    }

    public double getDeficit() {
        return tDeficit;
    }
}
