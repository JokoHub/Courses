package com.joko.IBA.GUIAdvanced;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Joko on 04.12.2016.
 */
public class DataSource {

    private File dataFile;

    public DataSource(String dataFilePath){
        this.dataFile = new File(dataFilePath);
    }

    public void loadData() throws FileNotFoundException {
        Scanner input = new Scanner(dataFile);
        Customer customer;
        int numOfCustomers = input.nextInt();
        for (int idx = 0; idx < numOfCustomers; idx++){
            String firstName = input.next();
            String lastName = input.next();
            Bank.addCustomer(firstName, lastName);
            customer = Bank.getCustomer(idx);
            int numOfAccounts = input.nextInt();

            while (numOfAccounts-- > 0){
                char accountType = input.next().charAt(0);
                switch (accountType){
                    case 'S':{
                        float initBalance = Float.parseFloat(input.next());
                        float interestRate = Float.parseFloat(input.next());
                        customer.addAccount(new SavingsAccount(initBalance, interestRate));
                        break;
                    }
                    case 'C':{
                        float initBalance = Float.parseFloat(input.next());
                        float overdraftProtection = Float.parseFloat(input.next());
                        customer.addAccount(new CheckingAccount(initBalance, overdraftProtection));
                        break;
                    }
                }
            }
        }
    }
}
