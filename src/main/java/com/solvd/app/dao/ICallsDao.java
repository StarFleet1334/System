package com.solvd.app.dao;

import com.solvd.app.tables.Calls;

import java.sql.SQLException;

public interface ICallsDao extends IBaseDao<Calls> {
    // Some Additional if needed

    public Calls getById(int user_id,int call_storage_id) throws SQLException;
}
