package com.joko.IBA.ClassTest1.Exercise3;

/**
 * Created by Joko on 27.11.2016.
 */
public class AccumulativeSavingsBatch {
    Bank bank;

    public void setBank(Bank bank){
        this.bank = bank;
    }

    public void doBatch(){
        for (int i = 0; i < bank.getNumOfCustomers(); i++){
            for (int j = 0; j < bank.getCustomer(i).getNumOfAccounts(); j++){
                if (bank.getCustomer(i).getAccount(j) instanceof SavingsAccount){
                    ((SavingsAccount) bank.getCustomer(i).getAccount(j)).accumulateInterest();
                }
            }
        }
    }
}
