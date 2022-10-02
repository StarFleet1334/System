package com.solvd.app.patterns.creational.factory;

public abstract class Battle {

    public void forward() {
        Action action = create();
        action.move();
    }

    public abstract Action create();
}
