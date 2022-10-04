package com.solvd.app.patterns.behavioral.strategy.main;

public class Application {
    private boolean isClosed = false;

    public void generateRoute(Navigate navigate,String to) {
        navigate.buildRoute(to);
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
