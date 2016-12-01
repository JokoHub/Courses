package com.joko.IBA.Exceptions;

public class Account {
    
    public double balance;
    
    public Account(double initBalance) {
        balance = initBalance;
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
