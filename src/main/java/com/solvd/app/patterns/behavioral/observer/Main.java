package com.solvd.app.patterns.behavioral.observer;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Magazine magazine = new Magazine("Radio Ardaidardo");
        Grandpa grandpa = new Grandpa("Jemali");
        Grandma grandma = new Grandma("Marina");

        magazine.getManager().publish("Mario");
        magazine.getManager().publish("Jungle");

        grandma.addToWishList("Mario");
        grandpa.addToWishList("Jungle");
        grandpa.addToWishList("Mario");

        magazine.getManager().subscribe(grandma);
        magazine.getManager().subscribe(grandpa);


        magazine.getManager().unsubscribe(grandma,"Mario");

        Map<String, List<Purchaser>> lst = magazine.getManager().getMap();
        for (Map.Entry<String,List<Purchaser>> set : lst.entrySet()) {
            System.out.println(set.getKey() + ": ");
            for (int i = 0; i < set.getValue().size(); i++) {
                System.out.println(set.getValue().get(i));
            }
            System.out.println("=================================");
        }


    }
}
