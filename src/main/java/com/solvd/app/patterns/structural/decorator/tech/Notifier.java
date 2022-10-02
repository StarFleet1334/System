package com.solvd.app.patterns.structural.decorator.tech;

import java.util.HashMap;

public interface Notifier {
    void call(String from_person,String to_person);
    HashMap<String, String> getCall_sessions();
}
