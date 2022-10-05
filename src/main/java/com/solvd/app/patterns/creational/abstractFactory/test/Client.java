package com.solvd.app.patterns.creational.abstractFactory.test;

public class Client {
    private Meat meat;
    private Vegetables vegetables;

    public Client(StoreFactory storeFactory) {
        this.meat = storeFactory.createMeat();
        this.vegetables = storeFactory.createVegetables();
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public Vegetables getVegetables() {
        return vegetables;
    }

    public void setVegetables(Vegetables vegetables) {
        this.vegetables = vegetables;
    }
}
