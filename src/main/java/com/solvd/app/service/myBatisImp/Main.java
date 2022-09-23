package com.solvd.app.service.myBatisImp;

import com.solvd.app.tables.Phones;
import com.solvd.app.tables.Users;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        PhoneServiceImp phoneServiceImp = new PhoneServiceImp();

       phoneServiceImp.create(
               new Phones(8,"Margaritha","551435465")
       );


       phoneServiceImp.update(
               new Phones(1,"Ilia",null)
       );
    }
}