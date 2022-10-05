package com.solvd.app.patterns.creational.abstractFactory.main.factoryies;

import com.solvd.app.patterns.creational.abstractFactory.main.drinks.Drink;
import com.solvd.app.patterns.creational.abstractFactory.main.foods.Food;

public abstract class AbstractFactory {
    public abstract Food getFood(String name);
    public abstract Drink getDrink(String name);
}
