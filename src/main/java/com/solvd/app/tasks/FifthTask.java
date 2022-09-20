package com.solvd.app.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class EvenNumbersRunnable implements Runnable {
    private int range;
    private static final Logger LOGGER = LogManager.getLogger(EvenNumbersRunnable.class);

    public EvenNumbersRunnable(int range) {
        this.range = range;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= range; i++) {
                if (i % 2 == 0) {
                    LOGGER.info("Even Number: " + i);
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
    }
}

class EvenNumberThread extends Thread {
    private int range;
    private static final Logger LOGGER = LogManager.getLogger(EvenNumberThread.class);

    public EvenNumberThread(int range) {
        this.range = range;
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= range; i++) {
                if (i % 2 == 0) {
                    LOGGER.info("Even Number: " + i);
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
    }
}

public class FifthTask {
    public static void main(String[] args) {
        new EvenNumberThread(10);
    }
}
