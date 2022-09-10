package com.solvd.app.exceptions;

public class BatteryEmptyException extends Exception{
    public BatteryEmptyException(String message) {
        super(message);
    }
}