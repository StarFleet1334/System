package com.solvd.app.models;

import java.util.Objects;

public class Technologies {
    private int id;
    private String name;
    private int pc;
    private int leptop;
    private Specs specs;

    public Technologies() {}

    public Technologies(int id,String name,int pc,int leptop,Specs specs) {
        this.id = id;
        this.name = name;
        this.pc = pc;
        this.leptop = leptop;
        this.specs = specs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getLeptop() {
        return leptop;
    }

    public void setLeptop(int leptop) {
        this.leptop = leptop;
    }

    public Specs getSpecs() {
        return specs;
    }

    public void setSpecs(Specs specs) {
        this.specs = specs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technologies that = (Technologies) o;
        return id == that.id && pc == that.pc && leptop == that.leptop && name.equals(that.name) && specs.equals(that.specs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pc, leptop, specs);
    }
}
