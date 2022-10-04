package com.solvd.app.patterns.behavioral.strategy.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CarNavigate implements Navigate{
    public static final Map<String,Integer> routes = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(CarNavigate.class);

    static {
        routes.put("Berlin",340);
        routes.put("Paris",650);
        routes.put("London",800);
    }

    @Override
    public void buildRoute(String to) {
        if (routes.get(to) != null) {
            System.out.println("You just need to go " + routes.get(to) + "km to go to " + to);
        } else {
            LOGGER.error("Null Argument in CarNavigate");
        }
    }
}
