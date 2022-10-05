package com.solvd.app.patterns.behavioral.strategy.chess;

public class Player {
    public static void main(String[] args) {
        Context f = new Context(new Castle());
        f.executeStrategy();

        Context s = new Context(new OpenPawn());
        s.executeStrategy();

        Context t = new Context(new KnightBishopOut());
        t.executeStrategy();
    }
}
