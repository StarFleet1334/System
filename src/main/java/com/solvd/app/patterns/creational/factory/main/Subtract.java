package com.solvd.app.patterns.creational.factory.main;

public class Subtract implements Calculator{
    @Override
    public int doCalculation(int x, int y) {
        return x - y;
    }
}
