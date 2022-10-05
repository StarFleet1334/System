package com.solvd.app.patterns.creational.factory.test;

public class SoldierAction extends Battle{

    @Override
    public Action create() {
        return new Soldier();
    }
}
