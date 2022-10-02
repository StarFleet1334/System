package com.solvd.app.patterns.structural.facade.audios;

public class AviAudio implements Audio{
    private final String name = "avi suffix - Audio Video Interleave file";

    public String getName() {
        return name;
    }
}
