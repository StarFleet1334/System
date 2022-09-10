package com.solvd.app.tasks;


@FunctionalInterface
interface Addition<T extends Number> {
    T add(T x, T y);
}

@FunctionalInterface
interface Subtraction<T extends Number> {
    T sub(T x, T y);
}

@FunctionalInterface
interface Mul<T extends Number> {
    T mul(T x, T y);
}

public class SecondTask {
    public static void main(String[] args) {

    }
}
