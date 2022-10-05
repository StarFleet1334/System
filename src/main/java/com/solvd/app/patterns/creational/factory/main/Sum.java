package com.solvd.app.patterns.creational.factory.main;

public class Sum implements Calculator{

    @Override
    public int doCalculation(int x,int y) {
        return x + y;
    }
}
