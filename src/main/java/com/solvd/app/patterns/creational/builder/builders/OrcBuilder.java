package com.solvd.app.patterns.creational.builder.builders;

import com.solvd.app.patterns.creational.builder.Difficulty;
import com.solvd.app.patterns.creational.builder.characters.Orc;

public class OrcBuilder implements Builder{
    private String name;
    private int level;
    private String power;
    private Difficulty difficulty;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setSuperPower(String power) {
        this.power = power;
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Orc createCharacter() {
        return new Orc(name,level,power,difficulty);
    }
}
