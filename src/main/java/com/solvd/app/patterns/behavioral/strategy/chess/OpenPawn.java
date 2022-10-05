package com.solvd.app.patterns.behavioral.strategy.chess;

public class OpenPawn implements Strategy{
    @Override
    public void movement() {
        System.out.println("Move the pawn in front of either the king or queen two squares forward.");
    }
}
