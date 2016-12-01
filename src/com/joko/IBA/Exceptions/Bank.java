package com.joko.IBA.Exceptions;

/**
 * Created by Joko on 27.11.2016.
 */
public class Bank {
    private static Customer[] customers;
    private static int numberOfCustomers;

    static {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }
    private Bank(){
    }

    public static void addCustomer(String f, String l){
        int i = numberOfCustomers++;
        customers[i] = new Customer(f, l);
    }

    public static int getNumOfCustomers(){
        return numberOfCustomers;
    }

    public static Customer getCustomer(int customer_index){
        return customers[customer_index];
    }
}
