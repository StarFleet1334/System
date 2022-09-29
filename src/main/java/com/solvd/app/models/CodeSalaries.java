package com.solvd.app.models;

import java.util.Objects;

public class CodeSalaries {
    private int id;
    private double salary;

    public CodeSalaries() {}

    public CodeSalaries(int id,double salary) {
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeSalaries that = (CodeSalaries) o;
        return id == that.id && Double.compare(that.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary);
    }
}
