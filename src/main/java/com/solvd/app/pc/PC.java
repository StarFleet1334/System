package com.solvd.app.pc;


import com.solvd.app.exceptions.BatteryEmptyException;
import com.solvd.app.exceptions.FireWallException;
import com.solvd.app.exceptions.PowerOffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PC extends Computer{
    private static final Logger LOGGER = LogManager.getLogger(PC.class);

    @Override
    public void install(String pathname) throws FireWallException {
        if (pathname.contains(".torrent")) {
            LOGGER.info("File Is Safely Downloaded");
        } else {
            throw new FireWallException("This File May contain Threats,That can harm your computer");
        }
    }

    public PC(String fullName, String computerName, String operatingSystem, String systemManufacturer, String model, String processor, String memory, int directX) {
        super(fullName,computerName, operatingSystem, systemManufacturer, model, processor, memory, directX);
    }

    @Override
    public void startComputer() {
        setComputer(true);
    }

    @Override
    public void stopComputer() {
        setComputer(false);
        setOnline(false);
    }

    @Override
    public void sendMessage(Storage storage, Person from, Person to, String message) throws InterruptedException, PowerOffException, BatteryEmptyException {
        if (isComputer()) {
            storage.addMessage(from,to,message);
        } else {
            LOGGER.error("Please,To send A message U must turn on your machine!");
            throw new PowerOffException("Please, To send A message U must turn on your machine!");
        }
    }
}
