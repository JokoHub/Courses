package com.joko.IBA.IOExample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joko on 27.11.2016.
 */
public class Bank {
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
    }
    private Bank(){
    }

    public static void addCustomer(String f, String l){
        customers.add(new Customer(f, l));
    }

    public static int getNumOfCustomers(){
        return customers.size();
    }

    public static Customer getCustomer(int customer_index){
        return customers.get(customer_index);
    }
}
