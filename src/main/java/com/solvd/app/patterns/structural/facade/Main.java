package com.solvd.app.patterns.structural.facade;

import com.solvd.app.patterns.structural.facade.factory.AudioFactory;
import com.solvd.app.patterns.structural.facade.factory.TypeFactory;

public class Main {
    public static void main(String[] args) {
        Video video = new Video("Jujutsu kaisen 0","Mp4");
        AudioFactory audioFactory = new AudioFactory();
        TypeFactory typeFactory = new TypeFactory();
        audioFactory.convert_audio(video);
        typeFactory.type_convertor_Video(video);
        System.out.println(video);
    }
}
