package com.solvd.app.patterns.creational.builder.builders;

import com.solvd.app.patterns.creational.builder.characters.Dwarf;
import com.solvd.app.patterns.creational.builder.characters.Elf;
import com.solvd.app.patterns.creational.builder.characters.Human;
import com.solvd.app.patterns.creational.builder.characters.Orc;

public interface MovieBuilder {
    void setElf(Elf elf);
    void setOrc(Orc orc);
    void setDwarf(Dwarf dwarf);
    void setHuman(Human human);
}
