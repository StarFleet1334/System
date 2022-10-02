package com.solvd.app.patterns.creational.builder.builders;

import com.solvd.app.patterns.creational.builder.Movie.Lor;
import com.solvd.app.patterns.creational.builder.characters.Dwarf;
import com.solvd.app.patterns.creational.builder.characters.Elf;
import com.solvd.app.patterns.creational.builder.characters.Human;
import com.solvd.app.patterns.creational.builder.characters.Orc;

public class LorBuilder implements MovieBuilder {
    private Elf elf;
    private Orc orc;
    private Human human;
    private Dwarf dwarf;


    public void setElf(Elf elf) {
        this.elf = elf;
    }

    public void setOrc(Orc orc) {
        this.orc = orc;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public void setDwarf(Dwarf dwarf) {
        this.dwarf = dwarf;
    }

    public Lor getMovie() {
        return new Lor(elf,orc,human,dwarf);
    }
}
