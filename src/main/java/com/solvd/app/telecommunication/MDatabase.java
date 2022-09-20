package com.solvd.app.telecommunication;

import com.solvd.app.exceptions.PhoneDoesNotExistException;

import java.util.HashMap;

public class MDatabase {
    // All Registered Mobile phones
    private final HashMap<String,String> data;

    public MDatabase() {
        this.data = new HashMap<>();
    }

    public void add(String fullName,String phoneNumber) {
        data.put(fullName,phoneNumber);
    }

    public void update(String fullName,String newPhoneNumber) throws PhoneDoesNotExistException {
        // We gonna check if phone number exists
        // if it exists we update it.
        // if it does not than we throw exception
        // which we have to catch were we call this method
        // thats why we also have to add into exceptions package some exceptions
        if (data.containsKey(fullName)) {
            data.put(fullName,newPhoneNumber);
        } else {
            throw new PhoneDoesNotExistException("Person does not have phone registered in Database System");
        }
    }

    public boolean search(String fullName) {
        if (data.containsKey(fullName)) {
            return true;
        } else {
            return false;
        }
    }

    public HashMap<String,String> info() {
        return data;
    }
}
