package com.solvd.app.tables;

import java.util.Objects;

public class Specs {
    private int id;
    private String operating_system;
    private String model;
    private int memory;
    private String system_manufacturer;

    public Specs() {}

    public Specs(int id,String operating_system,String model,int memory,String system_manufacturer) {
        this.id = id;
        this.operating_system = operating_system;
        this.model = model;
        this.memory = memory;
        this.system_manufacturer = system_manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getSystem_manufacturer() {
        return system_manufacturer;
    }

    public void setSystem_manufacturer(String system_manufacturer) {
        this.system_manufacturer = system_manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specs specs = (Specs) o;
        return id == specs.id && memory == specs.memory && operating_system.equals(specs.operating_system) && model.equals(specs.model) && system_manufacturer.equals(specs.system_manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operating_system, model, memory, system_manufacturer);
    }
}
