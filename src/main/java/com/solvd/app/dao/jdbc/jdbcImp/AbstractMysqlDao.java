package com.solvd.app.dao.jdbc.jdbcImp;

public abstract class AbstractMysqlDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
