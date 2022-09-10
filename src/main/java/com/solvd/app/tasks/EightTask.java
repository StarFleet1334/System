package com.solvd.app.tasks;

// 831

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;



class Paint implements Runnable {
    // Immutable Implementations
    private static final Logger logger = LogManager.getLogger(Paint.class);
    private final List<String> painting = Arrays.asList("Mona Lisa","The Starry Night",
            "Girl with a Pearl Earring","The Kiss","The Night Watch");
    private static int taskCount = 0;
    private final int id = taskCount++;
    private int number;

    public Paint(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        try {
            if (number == 5 || number == 6) {
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Thread.currentThread().getName() + ": Painting... for The Customer by ID: " + id);
        painting.forEach(logger::info);
        logger.info("-------------------------------------------------");
    }
}

public class EightTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 7; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(new Paint(i));
            future.get();
        }
    }
}
