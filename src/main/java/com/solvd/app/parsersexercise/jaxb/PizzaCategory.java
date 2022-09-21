package com.solvd.app.parsersexercise.jaxb;

import java.util.ArrayList;
import java.util.List;

public class PizzaCategory {
    private List<Pizza> pizzaList;

    @Override
    public String toString() {
        return "PizzaCategory{" +
                "pizzaList=" + pizzaList +
                '}';
    }

    public PizzaCategory() {
        this.pizzaList = new ArrayList<>();
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
}
