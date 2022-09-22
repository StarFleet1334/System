package com.solvd.app.linkelist;

//843

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {

        ProcessingThread processingThread = new ProcessingThread();
        Thread t1 = new Thread(processingThread,"t1");
        t1.start();
        Thread t2 = new Thread(processingThread,"t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count= " + processingThread.getCount());
    }
}

class ProcessingThread implements Runnable {
    private int count;

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    private void processSomething(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

