package com.solvd.app.patterns.structural.facade.factory;

import com.solvd.app.patterns.structural.facade.Video;
import com.solvd.app.patterns.structural.facade.types.AviType;
import com.solvd.app.patterns.structural.facade.types.MovType;
import com.solvd.app.patterns.structural.facade.types.Mp4Type;
import com.solvd.app.patterns.structural.facade.types.Types;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TypeFactory {
    private static final Logger LOGGER = LogManager.getLogger(TypeFactory.class);

    public void type_convertor_Video(Video video) {
        if (video.getType().equalsIgnoreCase("AVI")) {
            LOGGER.info("Converting AVI format Video.");
            video.setTypes(new AviType());
        } else if (video.getType().equalsIgnoreCase("MP4")) {
            LOGGER.info("Converting MP4 format Video.");
            video.setTypes(new Mp4Type());
        } else if (video.getType().equalsIgnoreCase("MOV")) {
            LOGGER.info("Converting MOV format Video.");
            video.setTypes(new MovType());
        }
    }
}
