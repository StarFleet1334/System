package com.solvd.app.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Grandpa implements Purchaser{

    private String name;
    private List<String> newspapers;

    public Grandpa(String name) {
        this.name = name;
        newspapers = new ArrayList<>();
    }

    @Override
    public void addToWishList(String name) {
        System.out.println("Adding to wishlist newspaper called : " + name);
        newspapers.add(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public List<String> getNewsPapers() {
        return newspapers;
    }

    @Override
    public String toString() {
        return "Grandpa{" +
                "name='" + name + '\'' +
                ", newspapers=" + newspapers +
                '}';
    }
}
