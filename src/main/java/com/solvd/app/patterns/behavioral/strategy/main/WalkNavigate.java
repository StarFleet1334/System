package com.solvd.app.patterns.behavioral.strategy.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class WalkNavigate implements Navigate{
    public static final Map<String,Integer> routes = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(WalkNavigate.class);

    static {
        routes.put("Berlin",2340);
        routes.put("Paris",2650);
        routes.put("London",2800);
    }

    @Override
    public void buildRoute(String to) {
        if (routes.get(to) != null) {
            System.out.println("You just need to go " + routes.get(to) + "km to go to " + to);
        } else {
            LOGGER.error("Null Argument in WalkNavigate");
        }
    }
}
