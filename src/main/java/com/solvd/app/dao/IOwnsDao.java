package com.solvd.app.dao;

import com.solvd.app.tables.Owns;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface IOwnsDao extends IBaseDao<Owns> {
    // Some Additional if needed
    public Owns getById(@Param("users_id") int users_id,@Param("tech_id") int tech_id) throws SQLException;
}
