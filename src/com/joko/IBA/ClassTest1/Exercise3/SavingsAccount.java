package com.joko.IBA.ClassTest1.Exercise3;

/**
 * Created by Joko on 27.11.2016.
 */
public class SavingsAccount extends Account {
    private double tInterestRate;

    public SavingsAccount(double initBalance, double oInterestRate){
        super(initBalance);
        tInterestRate = oInterestRate;
    }

    public void accumulateInterest(){
        balance = balance + (balance * (tInterestRate / 12));
    }


}
