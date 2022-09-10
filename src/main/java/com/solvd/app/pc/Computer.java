package com.solvd.app.pc;


import com.solvd.app.support.IInstall;
import com.solvd.app.support.ISent;
import com.solvd.app.support.ITurnOff;
import com.solvd.app.support.ITurnOn;

public abstract class Computer extends Specs implements ISent, ITurnOn, ITurnOff, IInstall {
    private String computerName;
    private boolean isOnline = false;
    private boolean isComputer = false;

    public Computer(String fullName,String computerName, String operatingSystem, String systemManufacturer, String model, String processor, String memory, int directX) {
        super(operatingSystem, systemManufacturer, model, processor, memory, directX);
        this.computerName = computerName;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean value) {
        isComputer = value;
    }

    public abstract void startComputer();

    public abstract void stopComputer();
}
