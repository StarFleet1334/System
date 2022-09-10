package com.solvd.app.pc;

import com.solvd.app.exceptions.BatteryEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Battery {
    private int BATTERY = 100;
    private static final Logger logger = LogManager.getLogger(Battery.class);
    private Thread thread;

    public int getBattery() {
        return BATTERY;
    }

    public void chargeBattery() {
        this.BATTERY = 100;
    }

    public void BatteryStatus(String owner) throws BatteryEmptyException {
        if (BATTERY == 0) {
            logger.info("Battery needs to be charged!!!");
            throw new BatteryEmptyException("Charge Battery");
        } else {
            System.out.println("Here");
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            BATTERY--;
                            if (BATTERY == 0) {
                                logger.info(owner + ": " + "Battery needs to be charged!!");
                                break;
                            };

                            if (BATTERY < 15) {
                                logger.info("Emergency!! to "+ owner +": " + " Battery is less than 15%");
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("Do you want to recharge your battery " + owner + "?");
                                String answer = scanner.nextLine();
                                if (answer.equalsIgnoreCase("yes")) {
                                    chargeBattery();
                                } else {
                                    break;
                                }
                            }

                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.out);
                    }
                }
            });
            thread.start();
        }
    }
}
