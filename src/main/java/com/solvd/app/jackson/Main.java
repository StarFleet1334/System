package com.solvd.app.jackson;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args)  {
        JsonHandler jsonHandler = new JsonHandler();
        Company company = null;
        
        try {
            company = jsonHandler.jsonToObject();
        } catch (IOException | URISyntaxException e) {
            LOGGER.error("Error while converting Json to Object");
        }

        try {
            jsonHandler.objectToJson(company);
        } catch (IOException | URISyntaxException e) {
            LOGGER.error("Error while converting Object to Json");
        }
    }
}
