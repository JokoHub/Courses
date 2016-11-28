/*
 * Customer.java
 *
 * Created on November 11, 2005, 1:25 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.joko.IBA.ClassTest1.Exercise2;

/**
 *
 * @author student
 */
public class Customer {

    private Account[] accounts;
    private int numberOfAccounts;
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
        accounts = new Account[10];
        numberOfAccounts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account acct) {
        account = acct;
    }

    public void addAccount(Account acct){
        int i = numberOfAccounts++;
        accounts[i] = acct;
    }

    public int getNumOfAccounts(){
        return numberOfAccounts;
    }

    public Account getAccount(int account_index){
        return accounts[account_index];
    }
    
}
