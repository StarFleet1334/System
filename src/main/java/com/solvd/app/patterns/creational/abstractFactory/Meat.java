package com.solvd.app.patterns.creational.abstractFactory;

import java.util.List;

public interface Meat {
    String getDescription();
    List<String> kindOfMeats();
    double startingPriceForMeat();
}
