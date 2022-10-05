package com.solvd.app.patterns.behavioral.strategy.chess;

public class KnightBishopOut implements Strategy{
    @Override
    public void movement() {
        System.out.println("Before you move your queen,rooks or king, move your knights and bishops" +
                " toward the center of the board.");
    }
}
