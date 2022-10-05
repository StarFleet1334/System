package com.solvd.app.patterns.creational.abstractFactory;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(new ProductFactory());
        System.out.println(client.getMeat().getDescription());
        System.out.println(client.getVegetables().getDescription());
    }
}
