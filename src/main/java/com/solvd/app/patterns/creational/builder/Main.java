package com.solvd.app.patterns.creational.builder;

import com.solvd.app.patterns.creational.builder.movie.Lor;
import com.solvd.app.patterns.creational.builder.builders.*;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        ElfBuilder elfBuilder = new ElfBuilder();
        HumanBuilder humanBuilder = new HumanBuilder();
        OrcBuilder orcBuilder = new OrcBuilder();
        DwarfBuilder dwarfBuilder = new DwarfBuilder();
        LorBuilder lorBuilder = new LorBuilder();
        director.createElf(elfBuilder);
        director.createHuman(humanBuilder);
        director.createOrc(orcBuilder);
        director.createDwarf(dwarfBuilder);
        director.createLOR(lorBuilder,elfBuilder.getCharacter(),humanBuilder.createCharacter(),dwarfBuilder.getCharacter(),orcBuilder.createCharacter());

        Lor lor = lorBuilder.getMovie();
        System.out.println(lor);
    }
}
