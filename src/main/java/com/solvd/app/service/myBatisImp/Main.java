package com.solvd.app.service.myBatisImp;

import com.solvd.app.tables.CallsStorage;
import com.solvd.app.tables.EmailsStorage;
import com.solvd.app.tables.Phones;
import com.solvd.app.tables.Users;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static java.time.LocalDateTime.now;

public class Main {
    public static void main(String[] args) throws SQLException {

      CallStorageServiceImp serviceImp = new CallStorageServiceImp();

      CallsStorage x = serviceImp.get(3);

        System.out.println(x.getId());
        Users from = x.getFrom_user();
        Users to = x.getTo_user();

        System.out.println("From User : ");
        System.out.println(from.getId() + " " + from.getFull_name() + " " + from.getAge());
        System.out.println("Phone : ");
        if (from.getPhone() != null) {
            System.out.println(from.getPhone().getId());
        } else {
            System.out.println("Null");
        }

        System.out.println("To User : ");
        System.out.println(to.getId() + " " + to.getFull_name() + " " + to.getAge());
        System.out.println("Phone : ");
        if (to.getPhone() != null) {
            System.out.println(to.getPhone().getId());
        } else {
            System.out.println("Null");
        }
    }
}