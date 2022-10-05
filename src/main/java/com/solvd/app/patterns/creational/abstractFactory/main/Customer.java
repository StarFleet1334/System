package com.solvd.app.patterns.creational.abstractFactory.main;

import com.solvd.app.patterns.creational.abstractFactory.main.factoryies.AbstractFactory;
import com.solvd.app.patterns.creational.abstractFactory.main.factoryies.FactoryGenerator;
import com.solvd.app.patterns.creational.abstractFactory.main.foods.Burger;
import com.solvd.app.patterns.creational.abstractFactory.main.foods.Food;

public class Customer {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = FactoryGenerator.chooseFromMenu("Food");

        Food burger = abstractFactory.getFood("burger");
       burger.name();

        Food pizza = abstractFactory.getFood("pizza");
       pizza.name();

    }
}
