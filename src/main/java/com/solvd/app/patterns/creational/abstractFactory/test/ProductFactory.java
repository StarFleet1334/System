package com.solvd.app.patterns.creational.abstractFactory.test;

public class ProductFactory implements StoreFactory{

    @Override
    public Meat createMeat() {
        return new MeatProduct();
    }

    @Override
    public Vegetables createVegetables() {
        return new VegetablesProduct();
    }
}
