package com.solvd.app.service.myBatisImp;

import com.solvd.app.tables.CodeSalaries;
import com.solvd.app.tables.Jobs;
import com.solvd.app.tables.Phones;
import com.solvd.app.tables.Users;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
       JobServiceImp serviceImp = new JobServiceImp();


       serviceImp.update(
               new Jobs(5,"Astronaut","Travel to space",
                       new CodeSalaries(1,213131.2))
       );
    }
}