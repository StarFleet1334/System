package com.solvd.app.pc;

import com.solvd.app.exceptions.BatteryEmptyException;
import com.solvd.app.exceptions.FireWallException;
import com.solvd.app.exceptions.PowerOffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Laptop extends Computer{

    private Battery battery;
    private static final Logger logger = LogManager.getLogger(Laptop.class);
    private String owner;

    public Laptop(String fullName,String computerName, String operatingSystem, String systemManufacturer, String model, String processor, String memory, int directX) {
        super(fullName,computerName, operatingSystem, systemManufacturer, model, processor, memory, directX);
        battery = new Battery();
        owner = fullName;
    }
    public String getOwner() {
        return owner;
    }

    @Override
    public void install(String pathname) throws FireWallException {
        if (pathname.contains(".torrent")) {
            System.out.println("was here");
            logger.info("File Is Safely Downloaded");
        } else {
            throw new FireWallException("This File May contain Threats,That can harm your computer");
        }
    }

    @Override
    public void startComputer() {
        try {
            battery.BatteryStatus(owner);
            setComputer(true);
        } catch (BatteryEmptyException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void stopComputer() {
        setOnline(false);
        setComputer(false);
    }

    @Override
    public void sendMessage(Storage storage, Person from, Person to, String message) throws InterruptedException, PowerOffException, BatteryEmptyException {
        if (battery.getBattery() != 0) {
            storage.addMessage(from,to,message);
        } else {
            logger.error("Please, Charge Your Laptop!!");
            throw new BatteryEmptyException("Please,Charge Your Laptop!!!!");
        }
    }

}
