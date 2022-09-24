package com.solvd.app.service.myBatisImp;

import com.solvd.app.tables.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        WorkServiceImp workServiceImp = new WorkServiceImp();


        workServiceImp.update(
                new Works(
                        new Users(10,"Grigol Orbeliani",43,
                                new Phones(6,"Grigol","593138131")),
                        new Jobs(7,"Artist","Artistic Events",
                                new CodeSalaries(1,213131.2)),
                        new Date()
                )
        );


    }
}