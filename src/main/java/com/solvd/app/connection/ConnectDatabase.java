package com.solvd.app.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDatabase {
    private InputStream input;
    private Properties prop;
    private static final Logger logger = LogManager.getLogger(ConnectDatabase.class);

    public ConnectDatabase() throws IOException {
        input = ConnectDatabase.class.getResourceAsStream("/db.properties");
        prop = new Properties();
        prop.load(input);
    }

    private void connect() {
        // Here We connect to database and we close automatically with try-catch resource
        try ( Connection con = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"))){
            if (con != null) {
                logger.info("Connected to the database");
            }
        } catch (SQLException e) {
            logger.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace(System.out);
        }
    }
}
