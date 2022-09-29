package com.solvd.app.models;

import java.util.Objects;

public class Owns {
    private Users users_id;
    private Technologies technologies_id;
    private String name;

    public Owns() {}

    public Owns(Users users_id,Technologies technologies_id,String name) {
        this.users_id = users_id;
        this.technologies_id = technologies_id;
        this.name = name;
    }


    public Users getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Users users_id) {
        this.users_id = users_id;
    }

    public Technologies getTechnologies_id() {
        return technologies_id;
    }

    public void setTechnologies_id(Technologies technologies_id) {
        this.technologies_id = technologies_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owns owns = (Owns) o;
        return users_id.equals(owns.users_id) && technologies_id.equals(owns.technologies_id) && name.equals(owns.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users_id, technologies_id, name);
    }
}
