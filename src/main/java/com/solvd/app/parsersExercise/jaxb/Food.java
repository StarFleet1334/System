package com.solvd.app.parsersExercise.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Food {

    private PizzaCategory pizza_category;

    private SpaghettiCategory spaghetti_category;

    public Food() {
        this.pizza_category = new PizzaCategory();
        this.spaghetti_category = new SpaghettiCategory();
    }

    public PizzaCategory getPizza_category() {
        return pizza_category;
    }

    @Override
    public String toString() {
        return "Food{" +
                "pizza_category=" + pizza_category +
                ", spaghetti_category=" + spaghetti_category +
                '}';
    }

    public void setPizza_category(PizzaCategory pizza_category) {
        this.pizza_category = pizza_category;
    }

    public SpaghettiCategory getSpaghetti_category() {
        return spaghetti_category;
    }

    public void setSpaghetti_category(SpaghettiCategory spaghetti_category) {
        this.spaghetti_category = spaghetti_category;
    }
}
