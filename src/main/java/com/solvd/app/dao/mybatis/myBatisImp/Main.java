package com.solvd.app.dao.mybatis.myBatisImp;

import com.solvd.app.models.Users;

import java.sql.SQLException;
import java.util.List;

import static java.time.LocalDateTime.now;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImp serviceImp = new UserServiceImp();

        List<Users> list = serviceImp.getAll();

        for (Users x : list) {
            System.out.println("Person : ");
            System.out.println(x.getId() + " " + x.getFull_name() + " " + x.getAge());
            System.out.println("Phone : ");
            if (x.getPhone() != null) {
                System.out.println(x.getPhone().getId() + " " + x.getPhone().getFull_name() + " " + x.getPhone().getPhone_number());
            } else {
                System.out.println("Null");
            }
        }
    }
}