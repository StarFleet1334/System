package com.solvd.app.pc;

public abstract class Specs {
    private String operatingSystem;
    private String systemManufacturer;
    private String model;
    private String processor;
    private String memory;
    private int directX;

    public Specs(String operatingSystem, String systemManufacturer, String model, String processor, String memory, int directX) {
        this.operatingSystem = operatingSystem;
        this.systemManufacturer = systemManufacturer;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.directX = directX;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getSystemManufacturer() {
        return systemManufacturer;
    }

    public void setSystemManufacturer(String systemManufacturer) {
        this.systemManufacturer = systemManufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getDirectX() {
        return directX;
    }

    public void setDirectX(int directX) {
        this.directX = directX;
    }
}
