package com.solvd.app.patterns.structural.decorator.tech.Applications;

import com.solvd.app.patterns.structural.decorator.tech.Notifier;
import com.solvd.app.patterns.structural.decorator.tech.NotifierDecorator;

import java.util.HashMap;

public class Facebook extends NotifierDecorator {
    public Facebook(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void call(String from_person, String to_person) {
        System.out.println("Calling From Facebook");
        super.call(from_person, to_person);
    }

    @Override
    public HashMap<String, String> getCall_sessions() {
        return super.getCall_sessions();
    }
}
