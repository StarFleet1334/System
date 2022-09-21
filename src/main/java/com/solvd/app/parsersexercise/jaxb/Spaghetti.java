package com.solvd.app.parsersexercise.jaxb;

import java.util.List;


public class Spaghetti {
    private String name;
    private List<String> ingredients;
    private Double price;

    public Spaghetti() {}

    public Spaghetti(String name,List<String> ingredients,Double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Spaghetti{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", price=" + price +
                '}';
    }
}
