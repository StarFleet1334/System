package com.solvd.app.connection;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// Implementing Thread-Safe Singleton
public class ConnectionPool {
    // Singleton Pattern
    private static ConnectionPool instance;

    // Availability of Connection Pool
    private boolean isActive = true;

    private List<Connection> freeConnections = new ArrayList<>();

    // Active Connection Pool. In our case size is 5 (so this <= 5)
    private List<Connection> activeConnections = new ArrayList<>();

    // This is Connection Obtained by current Thread
    private ThreadLocal<Connection> currentConnection = new ThreadLocal<>();

    private static InputStream input;
    private static Properties prop;

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);


    private ConnectionPool(){}


    // static method newInstance()
    public static ConnectionPool newInstance() throws IOException {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                    input = ConnectionPool.class.getResourceAsStream("/db.properties");
                    prop = new Properties();
                    prop.load(input);
                }
            }
        }
        return instance;
    }

    public boolean isActive() {
        return isActive;
    }

    public ConnectionPool createConnectionPool() throws IOException {
       ConnectionPool connectionPool = newInstance();
       for (int i = 0; i < 5; i++) {
           Connection connection = connectionPool.newConnection();
           connectionPool.freeConnections.add(connection);
       }
       connectionPool.isActive = true;
       return connectionPool;
    }

    private Connection newConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
        } catch (SQLException e) {
            LOGGER.error("Exception during making newConnection");
        }
        return connection;
    }

    private boolean isValidConnection(Connection connection) {
        try {
            if (connection == null || connection.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Connection getConnection() {
        Connection connection = null;
        if (activeConnections.size() < 5) {
            if (freeConnections.size() > 0) {
                connection = freeConnections.get(0);
                freeConnections.remove(0);
                if (isValidConnection(connection)) {
                    activeConnections.add(connection);
                    currentConnection.set(connection);
                } else {
                    connection = getConnection(); // The synchronised method reenter lock
                }
            } else {
                // No available in the free connection pool
                LOGGER.info("No available Connection in free-Connection Pool");
                connection = newConnection();
                activeConnections.add(connection);
            }

        } else {
            // if maximum amount of connections has been reached
            LOGGER.info("Maximum number of connections has been reached.");
            // Entering the waiting state and will be awakened by notify or automatically
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            connection = getConnection();
        }
        return connection;
    }


    // returnConnection() -> not static, should be synchronised
    public synchronized void returnConnection(Connection connection) {
        LOGGER.info(Thread.currentThread().getName() + " close connection");
        activeConnections.remove(connection);
        currentConnection.remove();

        if (isValidConnection(connection)) {
            freeConnections.add(connection);
        } else {
            freeConnections.add(newConnection());
        }
        this.notifyAll();
    }


}
