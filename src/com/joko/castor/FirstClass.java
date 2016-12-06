package com.joko.castor;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Joko on 04.12.2016.
 */
public class FirstClass {
    public static void main(String[] args) throws IOException, MarshalException, ValidationException {
        Person person = new Person("Joko");
        person.setDateOfBirth(new Date(93, 01, 18));

        FileWriter writer = new FileWriter("test.xml");
        Marshaller.marshal(person, writer);
        writer.close();

        FileReader reader = new FileReader("test.xml");
        Person person1 = (Person) Unmarshaller.unmarshal(Person.class, reader);
        System.out.println(person1.getName() + " " + person1.getDateOfBirth());
        reader.close();
    }
}
