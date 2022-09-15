package com.solvd.app.dao;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDao<T> {
    List<T> getAll() throws SQLException;
    T get(int id) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;
    void create(T t) throws SQLException;
}
