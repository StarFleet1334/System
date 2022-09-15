package com.solvd.app.tables;

import java.util.Objects;

public class CallsStorage {
    private int id;
    private Users from_user;
    private Users to_user;

    public CallsStorage() {}

    public CallsStorage(int id,Users from,Users to) {
        this.id = id;
        this.from_user = from;
        this.to_user = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getFrom_user() {
        return from_user;
    }

    public void setFrom_user(Users from_user) {
        this.from_user = from_user;
    }

    public Users getTo_user() {
        return to_user;
    }

    public void setTo_user(Users to_user) {
        this.to_user = to_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallsStorage that = (CallsStorage) o;
        return id == that.id && from_user.equals(that.from_user) && to_user.equals(that.to_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from_user, to_user);
    }
}
