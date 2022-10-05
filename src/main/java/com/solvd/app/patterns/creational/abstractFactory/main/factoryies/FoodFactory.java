package com.solvd.app.patterns.creational.abstractFactory.main.factoryies;

import com.solvd.app.patterns.creational.abstractFactory.main.drinks.Drink;
import com.solvd.app.patterns.creational.abstractFactory.main.foods.Burger;
import com.solvd.app.patterns.creational.abstractFactory.main.foods.Food;
import com.solvd.app.patterns.creational.abstractFactory.main.foods.Pizza;

public class FoodFactory extends AbstractFactory{
    @Override
    public Food getFood(String name) {
        if (name == null) {
            return null;
        } else if (name.equalsIgnoreCase("Burger")) {
            return new Burger();
        } else if (name.equalsIgnoreCase("Pizza")) {
            return new Pizza();
        }
        return null;
    }

    @Override
    public Drink getDrink(String name) {
        return null;
    }
}
