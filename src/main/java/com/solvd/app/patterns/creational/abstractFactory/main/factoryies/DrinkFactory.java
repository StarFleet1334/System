package com.solvd.app.patterns.creational.abstractFactory.main.factoryies;

import com.solvd.app.patterns.creational.abstractFactory.main.drinks.Coca;
import com.solvd.app.patterns.creational.abstractFactory.main.drinks.Drink;
import com.solvd.app.patterns.creational.abstractFactory.main.drinks.Fanta;
import com.solvd.app.patterns.creational.abstractFactory.main.drinks.Sprite;
import com.solvd.app.patterns.creational.abstractFactory.main.foods.Food;

public class DrinkFactory extends AbstractFactory{
    @Override
    public Food getFood(String name) {
        return null;
    }

    @Override
    public Drink getDrink(String name) {
        if (name == null) {
            return null;
        } else if (name.equalsIgnoreCase("Coca")) {
            return new Coca();
        } else if (name.equalsIgnoreCase("Fanta")) {
            return new Fanta();
        } else if (name.equalsIgnoreCase("Sprite")) {
            return new Sprite();
        }
        return null;
    }
}
