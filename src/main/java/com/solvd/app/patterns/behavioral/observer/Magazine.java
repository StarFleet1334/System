package com.solvd.app.patterns.behavioral.observer;

public class Magazine {
    private Manager manager;
    private String name;

    public Magazine(String name) {
        this.name = name;
        this.manager = new Manager();
    }

    public Manager getManager() {
        return manager;
    }
}
