package com.solvd.app.parsersExercise.stax;

import com.solvd.app.tables.Users;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    private static final String name = "staxXml/person.xml";
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, URISyntaxException {
        ParseXml parseXml = new ParseXml();
        List<Users> lst = parseXml.parse(name);
        for (Users x : lst) {
            System.out.println(x.getId() + " " + x.getFull_name() + " " +
                    x.getAge());
            System.out.println("Phone: ");
            System.out.println(x.getPhone().getId() + " " + x.getPhone().getFull_name() + " " + x.getPhone().getPhone_number());
        }
    }
}
