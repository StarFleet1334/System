package com.solvd.app.patterns.creational.builder.characters;

import com.solvd.app.patterns.creational.builder.Difficulty;

public class Orc {
    private final String name;
    private final int level;
    private final String power;
    private final Difficulty difficulty;


    public Orc(String name, int level, String power, Difficulty difficulty) {
        this.name = name;
        this.level = level;
        this.power = power;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getPower() {
        return power;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return "Orc{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", power='" + power + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
