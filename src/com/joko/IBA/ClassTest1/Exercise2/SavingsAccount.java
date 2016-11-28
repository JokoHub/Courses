package com.joko.IBA.ClassTest1.Exercise2;

/**
 * Created by Joko on 27.11.2016.
 */
public class SavingsAccount extends Account {
    private double tInterestRate;

    public SavingsAccount(double initBalance, double oInterestRate){
        super(initBalance);
        tInterestRate = oInterestRate;
    }


}
