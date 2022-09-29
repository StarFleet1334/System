package com.solvd.app.models;

import java.util.Objects;

public class Phones {
    private int id;
    private String full_name;
    private String phone_number;

    public Phones() {}


    public Phones(int id,String full_name,String phone_number) {
        this.id = id;
        this.full_name = full_name;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phones phones = (Phones) o;
        return id == phones.id && full_name.equals(phones.full_name) && phone_number.equals(phones.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, full_name, phone_number);
    }
}
