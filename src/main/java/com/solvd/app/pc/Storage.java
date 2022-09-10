package com.solvd.app.pc;

import java.util.*;

public final class Storage {
    private final HashMap<HashMap<String,String>, List<String>> history;

    public Storage() {
        this.history = new HashMap<>();
    }

    public HashMap<HashMap<String, String>, List<String>> getHistory() {
        return history;
    }
    public void addMessage(Person person,Person to, String message)  {
        List<String> lst = new ArrayList<>();
        lst.add(message);
        HashMap<String,String> arr = new HashMap<>();
        arr.put(person.getFullName() + ":" + to.getFullName(),"Online");
        for (Map.Entry<HashMap<String, String>, List<String>> set : history.entrySet()) {
            for (Map.Entry<String,String> inner : set.getKey().entrySet()) {
                if (Objects.equals(inner.getKey(), person.getFullName() + ":" + to.getFullName())) {
                    set.getValue().add(message);
                    return;
                }
            }
        }
        history.put(arr,lst);


    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return Objects.equals(history, storage.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(history);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "history=" + history +
                '}';
    }
}
