package com.solvd.app.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@FunctionalInterface
interface MyInterface {
    double getValue();
}

@FunctionalInterface
interface Reverse {
    int add(int x, int y);
}

@FunctionalInterface
interface Multiplication {
    double mul(double x, double y);
}

@FunctionalInterface
interface Home {
    void paint();
}

@FunctionalInterface
interface EvenChecker {
    boolean checker(int x);
}

public class FirstTask {
    private static final Logger LOGGER = LogManager.getLogger(FirstTask.class);
    public static void main(String[] args) {
        // 1
//        MyInterface ref = () -> 20;
//        LOGGER.info(ref.getValue());

        // 2
//        Reverse reverse = (x,y) -> x + y;
//        LOGGER.info(reverse.add(10,20));

        // 3
//        Multiplication multiplication = (x,y) -> x * y;
//        LOGGER.info(multiplication.mul(10.0,20.2));

        // 4
//        Home home = () -> logger.info("Drawing....");
//        home.paint();

        // 5
//        EvenChecker evenChecker = (x) -> x % 2 == 0;
//        LOGGER.info(evenChecker.checker(11));
    }
}
