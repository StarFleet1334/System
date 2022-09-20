package com.solvd.app.pc;

import com.solvd.app.exceptions.BatteryEmptyException;
import com.solvd.app.exceptions.MissPellingException;
import com.solvd.app.exceptions.PhoneDoesNotExistException;
import com.solvd.app.exceptions.PowerOffException;
import com.solvd.app.telecommunication.MDatabase;
import com.solvd.app.telecommunication.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Person {
    private String fullName;
    private Laptop laptop;
    private PC pc;
    private int age;
    private static final Logger logger = LogManager.getLogger(Person.class);
    private Phone phone;
    private String type;

    public Person(String firstName,String lastName,String computerName,String operatingSystem,
                  String systemManufacturer, String model, String processor, String memory, int directX, int age,String type) {
        this.fullName = firstName + " " + lastName;
        this.age = age;
        this.type = type;
        this.phone = new Phone();
        if (type.toLowerCase().equals("pc")) {
            pc = new PC(fullName,computerName, operatingSystem,systemManufacturer,model,processor,memory,directX);
        } else if (type.toLowerCase().equals("laptop")) {
            laptop = new Laptop(fullName,computerName, operatingSystem,systemManufacturer,model,processor,memory,directX);
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName,String lastName) {
        this.fullName = firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(fullName, person.fullName) && Objects.equals(laptop, person.laptop) && Objects.equals(pc, person.pc) && Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, laptop, pc, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", laptop=" + laptop +
                ", pc=" + pc +
                ", age=" + age +
                '}';
    }

    public void start() {
        if (type.toLowerCase().equals("pc")) {
            pc.startComputer();
        } else if (type.toLowerCase().equals("laptop")) {
            laptop.startComputer();
        }
    }

    public void send(Storage storage,Person to,String message) throws PowerOffException, InterruptedException, BatteryEmptyException {
        if (type.toLowerCase().equals("pc")) {
            pc.sendMessage(storage,this,to,message);
        } else if (type.toLowerCase().equals("laptop")) {
            laptop.sendMessage(storage,this,to,message);
        }
    }

    public Phone getPhone() {
        return phone;
    }

    public void checkInbox(Storage storage) {
        for (Map.Entry<HashMap<String, String>, List<String>> set : storage.getHistory().entrySet()) {
            for (Map.Entry<String,String> inner : set.getKey().entrySet()) {
                if (Objects.equals(inner.getKey().split(":")[1], fullName)) {
                    logger.info("From: " + inner.getKey().split(":")[0] + " @Status - " + inner.getValue());
                    System.out.println("From: " + inner.getKey().split(":")[0] + " @Status - " + inner.getValue());
                    for (String item : set.getValue()) {
                        System.out.println("- " + item);
                    }
                }
            }
        }
    }

    public void search(String fullName, MDatabase database) {
        database.search(fullName);
    }

    public void addPhoneNumber(MDatabase database,String phoneNumber) {
        phone.setNumber(phoneNumber);
        logger.info("Person: " + fullName + ",as: " + phoneNumber);
        database.add(fullName,phone.getNumber());
    }

    public void addToContacts(MDatabase mDatabase,String fullName) {
        try {
            phone.addToContact(mDatabase,fullName);
        } catch (PhoneDoesNotExistException e) {
            e.printStackTrace(System.out);
        }
    }

    public void updatePhoneNumber(MDatabase database,String newPhoneNumber) {
        try {
            database.update(fullName,newPhoneNumber);
            logger.info("Person: " + fullName + ",Updated PhoneNumber: " + newPhoneNumber);
        } catch (PhoneDoesNotExistException e) {
            e.printStackTrace(System.out);
        } finally {
            phone.setNumber(newPhoneNumber);
        }
    }

    public void useCalculator() {
        try {
            phone.calculate();
        } catch (MissPellingException e) {
            e.printStackTrace();
        }
    }

    public void useCalendar() {
        try {
            phone.calendar();
        } catch (MissPellingException e) {
            e.printStackTrace();
        }
    }
}
