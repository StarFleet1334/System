package com.solvd.app.patterns.creational.factory.test;

public class Soldier implements Action{
    @Override
    public void move() {
        System.out.println("Soldier started moving...");
    }
}
