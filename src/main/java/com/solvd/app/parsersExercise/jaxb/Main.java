package com.solvd.app.parsersExercise.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // change capital letter Logger
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        // Pizzas

        List<String> lst_pizza = Arrays.asList("Pizza Sauce","Pepperoni","Mozzarella Cheese","black pepper",
                "oregano","pizza dough,store-bought or homemade");
        Pizza first = new Pizza("Pepperoni", lst_pizza,9.99);


        List<String> cheese_pizza = Arrays.asList("homemade pizza crust","pizza sauce","mozarella cheese,sliced",
                "mozzarella cheese,shredded","parmesan cheese,grated","ground basil or italian seasoning");
        Pizza second = new Pizza("Cheese Pizza",cheese_pizza,15.0);


        // Spaghettis
        List<String> lst_spaghetti = Arrays.asList("ground beef","onion,chopped","garlic,minced","green bell pepper,diced",
                "diced tomatoes","tomato sauce","tomato paste","dried oregano","dried basil","teaspoon salt","teaspoon ground black pepper");
        Spaghetti spaghetti = new Spaghetti("spaghetti-sauce-wth-ground-beef",lst_spaghetti,3.48);


        // Address of Restaurant
        Address address = new Address("Chichinadze Zakarias street","Tbilisi","Georgia", 114);



        // Food
        Food food = new Food();
        food.getPizza_category().getPizzaList().add(first);
        food.getPizza_category().getPizzaList().add(second);
        food.getSpaghetti_category().getSpaghettiList().add(spaghetti);

        // Restaurant

        Restaurant restaurant = new Restaurant();
        restaurant.setId(1);
        restaurant.setAddress(address);
        restaurant.setFood(food);


        // Marshalling
        JAXBHandler jaxbHandler = new JAXBHandler();
        jaxbHandler.marshal(restaurant);


        Restaurant opened = jaxbHandler.unmarshal();
        System.out.println(opened);

    }

}
