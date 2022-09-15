package com.solvd.app.linkeList;

//843

import com.solvd.app.dao.mysql.*;
import com.solvd.app.tables.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.PooledConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Main{
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        UsersDao usersDao = new UsersDao();
        usersDao.create(new Users(1,"Tamar Mefe",25,new Phones( 3,"David abramia","551764456")));
    }
}

