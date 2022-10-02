package com.solvd.app.patterns.creational.builder.Movie;

import com.solvd.app.patterns.creational.builder.characters.Dwarf;
import com.solvd.app.patterns.creational.builder.characters.Elf;
import com.solvd.app.patterns.creational.builder.characters.Human;
import com.solvd.app.patterns.creational.builder.characters.Orc;

public class Lor {
    private final Elf elf;
    private final Orc orc;
    private final Human human;
    private final Dwarf dwarf;

    public Lor(Elf elf, Orc orc, Human human, Dwarf dwarf) {
        this.elf = elf;
        this.orc = orc;
        this.human = human;
        this.dwarf = dwarf;
    }

    public Elf getElf() {
        return elf;
    }

    public Orc getOrc() {
        return orc;
    }

    public Human getHuman() {
        return human;
    }

    public Dwarf getDwarf() {
        return dwarf;
    }

    @Override
    public String toString() {
        return "Lor consists of 4 different race{" +
                "elf=" + elf +
                ", orc=" + orc +
                ", human=" + human +
                ", dwarf=" + dwarf +
                '}';
    }
}
