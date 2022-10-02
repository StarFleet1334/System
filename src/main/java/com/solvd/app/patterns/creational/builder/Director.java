package com.solvd.app.patterns.creational.builder;

import com.solvd.app.patterns.creational.builder.builders.Builder;
import com.solvd.app.patterns.creational.builder.builders.MovieBuilder;
import com.solvd.app.patterns.creational.builder.characters.Dwarf;
import com.solvd.app.patterns.creational.builder.characters.Elf;
import com.solvd.app.patterns.creational.builder.characters.Human;
import com.solvd.app.patterns.creational.builder.characters.Orc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Director {
    private static final Logger LOGGER = LogManager.getLogger(Director.class);

    public void createElf(Builder builder) {
            builder.setName("Galadriel");
            builder.setLevel(100);
            builder.setDifficulty(Difficulty.HARD);
            builder.setSuperPower("Fast,Strong and has magical power");
    }


    public void createOrc(Builder builder) {
            builder.setName("Nar Toe Spear");
            builder.setLevel(30);
            builder.setDifficulty(Difficulty.EASY);
            builder.setSuperPower("SuperHuman strength,stamina,smell and hearing");
    }

    public void createDwarf(Builder builder) {
            builder.setName("Dravin");
            builder.setLevel(60);
            builder.setDifficulty(Difficulty.MEDIUM);
            builder.setSuperPower("SuperHuman strength,either by nature or through magical means");
    }

    public void createHuman(Builder builder) {
            builder.setName("Isildur");
            builder.setLevel(50);
            builder.setDifficulty(Difficulty.MEDIUM);
            builder.setSuperPower("Has Possessed One Ring");
    }

    public void createLOR(MovieBuilder builder, Elf elf, Human human, Dwarf dwarf, Orc orc) {
        builder.setHuman(human);
        builder.setOrc(orc);
        builder.setDwarf(dwarf);
        builder.setElf(elf);
    }
}
