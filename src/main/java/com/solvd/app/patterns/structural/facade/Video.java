package com.solvd.app.patterns.structural.facade;

import com.solvd.app.patterns.structural.facade.audios.Audio;
import com.solvd.app.patterns.structural.facade.types.Types;

public class Video {
    private String name;
    private String type;
    private Audio audio;
    private Types types;

    public Video(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", audio=" + audio +
                ", types=" + types +
                '}';
    }
}
