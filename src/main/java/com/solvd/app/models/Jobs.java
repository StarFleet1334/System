package com.solvd.app.models;

import java.util.Objects;

public class Jobs {
    private int id;
    private String name;
    private String description;
    private CodeSalaries code;

    public Jobs() {}

    public Jobs(int id) {
        this.id = id;
    }

    public Jobs(int id,String name,String description,CodeSalaries code) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CodeSalaries getCode() {
        return code;
    }

    public void setCode(CodeSalaries code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobs jobs = (Jobs) o;
        return id == jobs.id && name.equals(jobs.name) && description.equals(jobs.description) && code.equals(jobs.code);
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", salary=" + code.getSalary() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, code);
    }
}
