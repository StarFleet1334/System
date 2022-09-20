package com.solvd.app.telecommunication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TAppCategory {
    MESSAGE(App.MESSAGE.class),
    CALENDAR(App.CALENDAR.class),
    CALCULATOR(App.CALCULATOR.class),
    WEATHER(App.WEATHER.class),
    NOTES(App.NOTES.class),
    CLEAR(App.CLEAR.class);

    private final App[] kinds;

    TAppCategory(Class<? extends App> kind) {
        this.kinds = kind.getEnumConstants();
    }

    interface App {
        enum MESSAGE implements App {
            START_CHAT,ADD_TO_CONTACTS
        }
        enum CALENDAR implements App {
            DAY,MONTH,YEAR,NUMBER
        }
        enum CALCULATOR implements App {
            ADD,SUB,DIV,MUL,PERCENTAGE
        }
        enum WEATHER implements App {
            WEATHER
        }
        enum NOTES implements App {
            CREATE_NEW,SEARCH_NOTES
        }
        enum CLEAR implements App {
            CLEAN
        }
    }

    public List<App> showSubOptions() {
        return new ArrayList<>(Arrays.asList(kinds));
    }

    public App defaultApp() {
        return App.CLEAR.CLEAN;
    }

}
