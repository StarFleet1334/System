package com.solvd.app.patterns.structural.decorator.tech;

import java.util.HashMap;

public class NotifierDecorator implements Notifier{
    private Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void call(String from_person, String to_person) {
        notifier.call(from_person,to_person);
    }

    @Override
    public HashMap<String, String> getCall_sessions() {
        return notifier.getCall_sessions();
    }
}
