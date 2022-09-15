package com.solvd.app.linkeList;

//843

import com.solvd.app.dao.mysql.UsersDao;
import com.solvd.app.tables.Phones;
import com.solvd.app.tables.Users;
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
        usersDao.update(new Users(7,"Salome",20,null));
    }
}

