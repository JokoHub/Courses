package com.joko.IBA.CollectionCasting;

import com.joko.IBA.Exceptions.OverdraftException;

public class Account {
    
    public double balance;
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(double initBalance) {
        balance = initBalance;
    }

    public Account(String name){
        this.name = name;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amt) {
        balance = balance + amt;
    }
    
    public void withdraw(double amt) throws OverdraftException {
        if ( amt <= balance ) {
            balance = balance - amt;
        } else{
            throw new OverdraftException("Insufficient funds", amt - balance);
        }

    }
}
