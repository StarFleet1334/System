package com.solvd.app.patterns.behavioral.strategy.chess;

public class Castle implements Strategy{
    @Override
    public void movement() {
        System.out.println("Castling is a move that allows you to move your king to safety and bring your rook into play");
    }
}
