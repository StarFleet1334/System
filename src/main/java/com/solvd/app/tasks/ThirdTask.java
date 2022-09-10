package com.solvd.app.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.stream.Stream;

public class ThirdTask {
    private static final Logger logger = LogManager.getLogger(ThirdTask.class);

    public static void main(String[] args) {

        // 1 - filter even Numbers
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter((number) -> number % 2 == 0)
                .forEach(logger::info);

        System.out.println("--------------------------");
        // 2
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter((number) -> number % 2 != 0)
                .map((number) -> number * 2)
                .limit(2)
                .forEach(logger::info);

        logger.info("--------------------------");
        // 3
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .map((number) -> number * new Random().nextInt(20))
                .filter((number) -> number > 15)
                .sorted()
                .forEach(logger::info);
        logger.info("-----------------------------");

        // 4
        double val = Stream.of(1,1,2,2,4,4,6,2,0,10)
                .distinct()
                .count();
        logger.info("Number of distinct values: " + (int) val);

        logger.info("--------------------------------------");

        // 5
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .map((number) -> number * 2)
                .filter((number) -> number > 18)
                .findAny()
                .ifPresent(logger::info);

        logger.info("---------------------------------------");

        // 6
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .reduce(Integer::sum)
                .ifPresent((number) -> logger.info("Total Sum: " + number));

        logger.info("----------------------------------------");

        // 7
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .map((number) -> number * 3)
                .sorted()
                .reduce(Integer::sum)
                .filter((number) -> number > 40)
                .stream().findAny()
                .ifPresent((number) -> logger.info("Number Greater than 40: " + number));
    }
}
