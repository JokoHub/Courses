/*
 * Customer.java
 *
 * Created on November 11, 2005, 1:25 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.joko.IBA.IOExample;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class Customer {

    private List<Account> accounts;
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
        accounts = new ArrayList<>(10);
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
        accounts.add(acct);
    }

    public int getNumOfAccounts(){
        return accounts.size();
    }

    public Account getAccount(int account_index){
        return accounts.get(account_index);
    }
    
}
