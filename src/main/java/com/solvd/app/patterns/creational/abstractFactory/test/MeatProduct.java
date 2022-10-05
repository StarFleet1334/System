package com.solvd.app.patterns.creational.abstractFactory.test;

import java.util.Arrays;
import java.util.List;

public class MeatProduct implements Meat{
    @Override
    public String getDescription() {
        return "Meat";
    }

    @Override
    public List<String> kindOfMeats() {
        return Arrays.asList("Pork","Beef","Lamb and Mutton","Chicken","Turkey","Vension");
    }

    @Override
    public double startingPriceForMeat() {
        return 50.5;
    }
}
