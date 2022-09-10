package com.solvd.app.support;

import com.solvd.app.exceptions.BatteryEmptyException;

public interface IBattery {
    String BatteryStatus() throws BatteryEmptyException;
}
