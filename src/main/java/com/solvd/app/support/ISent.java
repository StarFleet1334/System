package com.solvd.app.support;

import com.solvd.app.exceptions.BatteryEmptyException;
import com.solvd.app.exceptions.PowerOffException;
import com.solvd.app.pc.Person;
import com.solvd.app.pc.Storage;


public interface ISent {
    void sendMessage(Storage storage, Person from, Person to, String message) throws InterruptedException, PowerOffException, BatteryEmptyException;
}
