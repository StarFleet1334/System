package com.solvd.app.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prop {
    @JsonProperty
    private int age;
    @JsonProperty
    private String salary;
    @JsonProperty
    private String experience;

    public Prop() {}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }


}
