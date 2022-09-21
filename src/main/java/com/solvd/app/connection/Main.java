package com.solvd.app.connection;

import com.solvd.app.dao.jdbc.*;
import com.solvd.app.linkeList.LinkedList;
import com.solvd.app.tables.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Connection first = null;
    private static Connection second = null;
    private static Connection third = null;
    private static Connection fourth = null;
    private static Connection fifth = null;
    private static Connection sixth = null;

    public static void main(String[] args) throws IOException, InterruptedException {

        ConnectionPool connectionPool = ConnectionPool.newInstance();
        connectionPool.createConnectionPool();

        // 1



        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                first = connectionPool.getConnection();
                CallsDao callsDao = null;
                try {
                    callsDao = new CallsDao();
                    callsDao.setConnection(first);
                    List<Calls> list = callsDao.getAll();

                    for (Calls x : list) {
                        Users user = x.getUsers_id();
                        CallsStorage callsStorage = x.getCallsStorage_id();

                        System.out.println("User: ");
                        System.out.println(user.getId() + " " + user.getFull_name() + " " + user.getPhone());
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("CallStorage: ");
                        System.out.println(callsStorage.getId() + "  " + callsStorage.getFrom_user().getAge() + " " + callsStorage.getTo_user().getId());;
                    }
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(2000);

        // 2
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                second = connectionPool.getConnection();
                UsersDao usersDao = null;
                System.out.println("============================================");
                System.out.println("============================================");
                try {
                    usersDao = new UsersDao();
                    usersDao.setConnection(second);
                    List<Users> users = usersDao.getAll();
                    for (Users x : users) {
                        System.out.println(x.getId() + " " + x.getFull_name() + " " + x.getAge() + " " + x.getPhone());
                        if (x.getPhone() != null) {
                            System.out.println("Phone: " + x.getPhone().getPhone_number());
                        }
                    }
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        Thread.sleep(2000);

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                third = connectionPool.getConnection();
                UsersDao usersDao = null;
                System.out.println("================================");
                System.out.println("================================");
                try {
                    usersDao = new UsersDao();
                    usersDao.setConnection(third);
                    Users users = usersDao.get(11);
                    System.out.println(users.getId() + " " + users.getFull_name() + "  " + users.getAge() + " " + users.getPhone());
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread(runnable2);
        thread2.start();

        Thread.sleep(2000);

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                fourth = connectionPool.getConnection();
                TechnologiesDao technologiesDao = null;
                System.out.println("===============================");
                System.out.println("================================");

                try {
                    technologiesDao = new TechnologiesDao();
                    technologiesDao.setConnection(fourth);
                    List<Technologies> tech = technologiesDao.getAll();
                    for (Technologies x : tech) {
                        System.out.println(x.getId() + " " + x.getName() + x.getSpecs());
                        System.out.println("Specs: ");
                        System.out.println(x.getSpecs().getId() + " " + x.getSpecs().getSystem_manufacturer() + " " +
                                x.getSpecs().getMemory() + " " + x.getSpecs().getModel());
                    }
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread3 = new Thread(runnable3);
        thread3.start();

        Thread.sleep(2000);

        Runnable runnable4 = new Runnable() {
            @Override
            public void run() {
                fifth = connectionPool.getConnection();
                JobsDao jobsDao = null;
                System.out.println("=============================");
                System.out.println("=============================");
                try {
                    jobsDao = new JobsDao();
                    jobsDao.setConnection(fifth);
                    List<Jobs> list = jobsDao.getAll();

                    for (Jobs x : list) {
                        System.out.println(x.getId() + " " + x.getName() + " " +  x.getDescription() + x.getCode().getSalary());
                    }
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread4 = new Thread(runnable4);
        thread4.start();

        Thread.sleep(2000);

        Runnable runnable5 = new Runnable() {
            @Override
            public void run() {
                sixth = connectionPool.getConnection();
                connectionPool.returnConnection(first);
                WorksDao worksDao = null;

                try {
                    worksDao = new WorksDao();
                    List<Works> works = worksDao.getAll();

                    for (Works x : works) {
                        Users user = x.getUsers_id();
                        Jobs job = x.getJobs_id();
                        System.out.println("User: ");
                        System.out.println(user.getId() + " " + user.getFull_name() + " " + user.getAge());
                        System.out.println("Works: ");
                        System.out.println(job.getName() + " " + job.getDescription() + " " + x.getStart_date());
                    }
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread5 = new Thread(runnable5);
        thread5.start();
    }
}
