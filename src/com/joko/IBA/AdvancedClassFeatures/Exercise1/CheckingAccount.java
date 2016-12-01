package com.joko.IBA.AdvancedClassFeatures.Exercise1;

/**
 * Created by Joko on 27.11.2016.
 */
public class CheckingAccount extends Account {
    private double tOverdraftAmount;

    public CheckingAccount(double initBalance, double oOverdraftAmount){
        super(initBalance);
        tOverdraftAmount = oOverdraftAmount;
    }

    public CheckingAccount(double initBalance){
        this(initBalance, 0.0);
    }

    @Override
    public boolean withdraw(double amt) {
        boolean result = true;
        if (balance < amt){
            double overdraftNeeded = amt - balance;
            if (tOverdraftAmount < overdraftNeeded){
                result = false;
            } else {
                balance = 0.0;
                tOverdraftAmount -= overdraftNeeded;
            }
        } else{
            balance -= amt;
        }
        return result;
    }
}
