package com.solvd.app.patterns.creational.factory.main;

public class Exam {

    public Calculator doExercise(String operation) {
        if (operation == null) {
            return null;
        } else if (operation.equalsIgnoreCase("Divide")) {
            return new Divide();
        } else if (operation.equalsIgnoreCase("Sum")) {
            return new Sum();
        } else if (operation.equalsIgnoreCase("Subtract")) {
            return new Subtract();
        }
        return null;
    }
}
