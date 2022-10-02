package com.solvd.app.patterns.creational.builder.builders;

import com.solvd.app.patterns.creational.builder.Difficulty;

public interface Builder {
    void setName(String name);
    void setLevel(int level);
    void setSuperPower(String power);
    void setDifficulty(Difficulty difficulty);
}
