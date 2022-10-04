package com.solvd.app.patterns.behavioral.strategy.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Application application = new Application();
    private static Navigate navigate;
    private static final Map<Integer,String> routes = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Map<Integer,Navigate> navigation = new HashMap<>();

    static  {
        routes.put(1,"London");
        routes.put(2,"Paris");
        routes.put(3,"Berlin");

        navigation.put(1,new WalkNavigate());
        navigation.put(2,new CarNavigate());
    }

    public static void main(String[] args) throws IOException {
        while (!application.isClosed()) {
            System.out.println("Hello User: ");
            System.out.println("You Have Option to Choose Route: ");
            System.out.println("1 - London");
            System.out.println("2 - Paris");
            System.out.println("3 - Berlin");

            int choice = Integer.parseInt(reader.readLine());
            String destination = routes.get(choice);

            System.out.println("We have 2 options: ");
            System.out.println("1 - Walk Navigation (if you would like to take a walk)");
            System.out.println("2 - Car Navigation (if you would like to take a car)");

            int secondChoice = Integer.parseInt(reader.readLine());
            navigate = navigation.get(secondChoice);
            navigate.buildRoute(destination);

            System.out.println("Do you still want to continue? ");
            String answer = reader.readLine();
            if (answer.equalsIgnoreCase("No")) {
                application.setClosed();
            }
        }
    }
}
