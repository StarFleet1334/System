package com.solvd.app.patterns.structural.decorator.tech;


import java.util.HashMap;

public class Storage implements Notifier{
    private HashMap<String,String> call_sessions = new HashMap<>();

    @Override
    public void call(String from_person, String to_person) {
        call_sessions.put(from_person,to_person);
    }

    public HashMap<String, String> getCall_sessions() {
        return call_sessions;
    }
}
