package com.solvd.app.patterns.creational.factory.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Divide implements Calculator{
    private static final Logger LOGGER = LogManager.getLogger(Divide.class);

    @Override
    public int doCalculation(int x,int y) {
        int answer = 0;
        try {
            answer = x / y;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return answer;
    }
}
