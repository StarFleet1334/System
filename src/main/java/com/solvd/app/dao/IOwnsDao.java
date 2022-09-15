package com.solvd.app.dao;

import com.solvd.app.tables.Owns;

import java.sql.SQLException;

public interface IOwnsDao extends IBaseDao<Owns> {
    // Some Additional if needed
    public Owns getById(int users_id,int tech_id) throws SQLException;
}
