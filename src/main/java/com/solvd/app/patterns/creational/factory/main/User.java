package com.solvd.app.patterns.creational.factory.main;

public class User {
    public static void main(String[] args) {
        Exam exam = new Exam();
        Calculator sum = exam.doExercise("Sum");
        System.out.println(sum.doCalculation(10,20));

        Calculator divide = exam.doExercise("Divide");
        System.out.println(divide.doCalculation(20,4));

        Calculator subtract = exam.doExercise("Subtract");
        System.out.println(subtract.doCalculation(222,22));
    }
}
