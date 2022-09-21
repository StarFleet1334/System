package com.solvd.app.parsersexercise.jaxb;

import java.util.ArrayList;
import java.util.List;

public class SpaghettiCategory {
    private List<Spaghetti> spaghettiList;

    @Override
    public String toString() {
        return "SpaghettiCategory{" +
                "spaghettiList=" + spaghettiList +
                '}';
    }

    public SpaghettiCategory() {
        this.spaghettiList = new ArrayList<>();
    }

    public List<Spaghetti> getSpaghettiList() {
        return spaghettiList;
    }

    public void setSpaghettiList(List<Spaghetti> spaghettiList) {
        this.spaghettiList = spaghettiList;
    }
}
