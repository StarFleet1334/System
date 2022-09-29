package com.solvd.app.dao.jdbc;

import com.solvd.app.models.Works;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface IWorksDao extends IBaseDao<Works> {
    // Some Additional if needed


    public Works getById(@Param("user_id") int user_id,@Param("job_id")int job_id) throws SQLException;
}
