package com.solvd.app.linkelist;

//843

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static String name = "Ilia";

    static {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}

