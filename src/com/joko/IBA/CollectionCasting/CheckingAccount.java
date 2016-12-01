package com.joko.IBA.CollectionCasting;

import com.joko.IBA.Exceptions.OverdraftException;

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

    public CheckingAccount(String name){
        super(name);
    }
    @Override
    public String getName() {
        return ("this is " + super.getName());
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void withdraw(double amt) throws OverdraftException {
        if (balance < amt){
            double overdraftNeeded = amt - balance;
            if (tOverdraftAmount < overdraftNeeded){
                throw new OverdraftException("Insufficient funds for overdraft protection ", overdraftNeeded);
            } else {
                balance = 0.0;
                tOverdraftAmount -= overdraftNeeded;
            }
        } else{
            balance -= amt;
        }
    }
}
