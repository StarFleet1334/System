package com.solvd.app.patterns.creational.factory.test;

public class General implements Action{
    @Override
    public void move() {
        System.out.println("General started moving...");
    }
}
