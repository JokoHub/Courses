package com.joko.IBA.ClassTest1.Exercise3;


/**
 * Created by Joko on 27.11.2016.
 */
public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank(){
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    public void addCustomer(String f, String l){
        int i = numberOfCustomers++;
        customers[i] = new Customer(f, l);
    }

    public int getNumOfCustomers(){
        return numberOfCustomers;
    }

    public Customer getCustomer(int customer_index){
        return customers[customer_index];
    }
}
