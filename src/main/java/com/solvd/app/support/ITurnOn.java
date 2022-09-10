package com.solvd.app.support;

import com.solvd.app.exceptions.BatteryEmptyException;


public interface ITurnOn {
    void startComputer() throws BatteryEmptyException;
}
