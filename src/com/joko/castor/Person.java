package com.joko.castor;

import java.util.Date;

/**
 * Created by Joko on 04.12.2016.
 */
public class Person {

    private String name;
    private Date dateOfBirth;

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
