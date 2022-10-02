package com.solvd.app.patterns.structural.facade.audios;

public class Mp4Audio implements Audio{
    private final String name = "mpeg-4 multimedia";

    public String getName() {
        return name;
    }
}
