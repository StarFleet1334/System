package com.solvd.app.patterns.behavioral.strategy.chess;

public class Context {
    private Strategy strategy;

    Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        this.strategy.movement();
    }
}
