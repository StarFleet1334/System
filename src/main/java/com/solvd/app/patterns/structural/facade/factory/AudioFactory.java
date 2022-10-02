package com.solvd.app.patterns.structural.facade.factory;

import com.solvd.app.patterns.structural.facade.Video;
import com.solvd.app.patterns.structural.facade.audios.AviAudio;
import com.solvd.app.patterns.structural.facade.audios.MovAudio;
import com.solvd.app.patterns.structural.facade.audios.Mp4Audio;
import com.solvd.app.patterns.structural.facade.types.AviType;
import com.solvd.app.patterns.structural.facade.types.MovType;
import com.solvd.app.patterns.structural.facade.types.Mp4Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AudioFactory {
    private final static Logger LOGGER = LogManager.getLogger(AudioFactory.class);

    public void convert_audio(Video video) {
        if (video.getType().equalsIgnoreCase("AVI")) {
            LOGGER.info("Converting AVI format Video with AVI audio.");
            video.setAudio(new AviAudio());
        } else if (video.getType().equalsIgnoreCase("MP4")) {
            LOGGER.info("Converting MP4 format Video with Mp4 audio.");
            video.setAudio(new Mp4Audio());
        } else if (video.getType().equalsIgnoreCase("MOV")) {
            LOGGER.info("Converting MOV format Video with Mov audio.");
            video.setAudio(new MovAudio());
        }
    }
}
