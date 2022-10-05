package com.solvd.app.patterns.creational.factory.test;

public class GeneralAction extends Battle{
    @Override
    public Action create() {
        return new General();
    }
}
