package com.joko.IBA.CollectionCasting;


/**
 * Created by Joko on 27.11.2016.
 */
public class SavingsAccount extends Account {
    private double tInterestRate;

    @Override
    public String getName() {
        return ("this is " + super.getName());
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public SavingsAccount(double initBalance, double oInterestRate){
        super(initBalance);
        tInterestRate = oInterestRate;
    }

    public SavingsAccount(String name){
        super(name);
    }


}
