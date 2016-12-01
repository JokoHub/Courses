package com.joko.IBA.CollectionCasting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joko on 01.12.2016.
 */
public class TestCovariance {

    public static void printNames(List<? extends Account> lea){
        for (int i = 0; i < lea.size(); i++){
            System.out.println(lea.get(i).getName() + " ");
        }
    }

    public static void main(String[] args) {
        List<CheckingAccount> lc = new ArrayList<>();
        lc.add(new CheckingAccount("Checking one"));
        lc.add(new CheckingAccount("Checking two"));
        lc.add(new CheckingAccount("Checking three"));

        List<SavingsAccount> ls = new ArrayList<>();
        ls.add(new SavingsAccount("Savings one"));
        ls.add(new SavingsAccount("Savings two"));
        ls.add(new SavingsAccount("Savings three"));

        printNames(lc);
        printNames(ls);


        // Быстрое приведение коллекции к другому типу
        List<? extends Account> list = new ArrayList<>();
        List<Account> accountList = new ArrayList<>(list);
    }
}
