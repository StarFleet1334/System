package com.solvd.app.tables;

import java.util.Objects;

public class Users {
    private int id;
    private String full_name;
    private int age;
    private Phones phone;

    public Users() {}

    public Users(int id,String full_name,int age,Phones phone) {
        this.id = id;
        this.full_name = full_name;
        this.age = age;
        this.phone = phone;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Phones getPhone() {
        return phone;
    }

    public void setPhone(Phones phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && age == users.age && full_name.equals(users.full_name) && phone.equals(users.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, full_name, age, phone);
    }
}
