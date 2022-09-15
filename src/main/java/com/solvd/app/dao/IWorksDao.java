package com.solvd.app.dao;

import com.solvd.app.tables.Works;

import java.sql.SQLException;

public interface IWorksDao extends IBaseDao<Works> {
    // Some Additional if needed

    public Works getById(int user_id,int job_id) throws SQLException;
}
