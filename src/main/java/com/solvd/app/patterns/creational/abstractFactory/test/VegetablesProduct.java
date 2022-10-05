package com.solvd.app.patterns.creational.abstractFactory.test;

import java.util.Arrays;
import java.util.List;

public class VegetablesProduct implements Vegetables{
    @Override
    public String getDescription() {
        return "Vegetables";
    }

    @Override
    public List<String> kindOfVegetables() {
        return Arrays.asList("Potato", "Cucumber", "Tomato", "Broccoli", "Carrots", "Garlic", "Cabbage");
    }
}
