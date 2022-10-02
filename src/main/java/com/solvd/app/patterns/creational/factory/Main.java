package com.solvd.app.patterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        Battle battle = new GeneralAction();
        battle.forward();
    }
}
