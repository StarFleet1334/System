package com.solvd.app.dao;

import com.solvd.app.tables.Calls;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface ICallsDao extends IBaseDao<Calls> {
    // Some Additional if needed

    public Calls getById(@Param("user_id") int user_id,@Param("call_storage_id") int call_storage_id) throws SQLException;
}
