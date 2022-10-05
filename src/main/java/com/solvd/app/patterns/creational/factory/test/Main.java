package com.solvd.app.patterns.creational.factory.test;

public class Main {
    public static void main(String[] args) {
        Battle battle = new GeneralAction();
        battle.forward();
    }
}
