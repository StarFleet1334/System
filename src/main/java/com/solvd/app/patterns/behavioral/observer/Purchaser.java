package com.solvd.app.patterns.behavioral.observer;

import java.util.List;
import java.util.Map;

public interface Purchaser {
    void addToWishList(String name);

    List<String> getNewsPapers();

    default void getNotification(String newPaper) {
        System.out.println("NewsPaper called: " + newPaper + " has just been realised.");
    }
}
