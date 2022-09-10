package com.solvd.app.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Draw implements Runnable {
    private static final Logger logger = LogManager.getLogger(Draw.class);
    // Immutable Implementations
    private final List<String> painting = Arrays.asList("Mona Lisa","The Starry Night",
            "Girl with a Pearl Earring","The Kiss","The Night Watch");
    private static int taskCount = 0;
    private final int id = taskCount++;


    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + ": Drawing... for The Customer by ID: " + id);
        painting.forEach(logger::info);
        logger.info("-------------------------------------------------");
    }
}



public class CombineTask {
    public static void main(String[] args) throws InterruptedException {
        // Thread Pool With Size of 5
        ExecutorService example = Executors.newFixedThreadPool(5);


        // Thread Pool With Size 7
        ExecutorService exec = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            if (i == 5 || i == 6) {
                Thread.sleep(2000);
            }
            exec.execute(new Draw());
        }
        exec.shutdown();

    }
}
