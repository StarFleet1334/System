package com.solvd.app.patterns.creational.abstractFactory.main.factoryies;

public class FactoryGenerator {

    public static AbstractFactory chooseFromMenu(String name) {
        if (name == null) {
            return null;
        } else if (name.equalsIgnoreCase("Drink")) {
            return new DrinkFactory();
        } else if (name.equalsIgnoreCase("Food")) {
            return new FoodFactory();
        }
        return null;
    }
}
