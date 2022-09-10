package com.solvd.app.pc;

import com.solvd.app.exceptions.BatteryEmptyException;
import com.solvd.app.exceptions.PowerOffException;
import com.solvd.app.teleCommunication.MDatabase;



public class Main {

    //305
    // Convert to Maven,Add logger into Task

    public static void main(String[] args) throws PowerOffException, BatteryEmptyException, InterruptedException {
        Storage storage = new Storage();
        Person first = new Person("ilia","lataria","asdasd","adadsaa","asdads",
                "asdasdas","adasadas","16Ram",12,19,"PC");
////
        Person second = new Person("Jack","Daniels","asdas","MAc","adsa",
                "asdasdasd","asdas","adadas",1,22,"laptop");
        second.start();
        first.start();
        first.send(storage,second,"Hello,");
        first.send(storage,second,"Hello Again");
        second.checkInbox(storage);
        second.send(storage,first,"Hello Ilia");
        second.send(storage,first,"How are you doing?");
        first.checkInbox(storage);
//
        MDatabase mDatabase = new MDatabase();
        first.addPhoneNumber(mDatabase,"593138131");
//
//        first.addPhoneNumber(mDatabase,"593138131");
//        first.updatePhoneNumber(mDatabase,"551141909");
//        second.addPhoneNumber(mDatabase,"220060");
//        first.addToContacts(mDatabase,"Jack Daniels");
//        first.useCalendar();



    }

}
