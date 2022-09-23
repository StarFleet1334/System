package com.solvd.app.service.myBatisImp;

import com.solvd.app.tables.CodeSalaries;
import com.solvd.app.tables.Phones;
import com.solvd.app.tables.Users;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
       CodeSalariesServiceImp serviceImp = new CodeSalariesServiceImp();



       serviceImp.delete(
               new CodeSalaries(4,456.21)
       );


    }
}