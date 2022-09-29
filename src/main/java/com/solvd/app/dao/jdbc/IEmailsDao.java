package com.solvd.app.dao.jdbc;

import com.solvd.app.models.Emails;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface IEmailsDao extends IBaseDao<Emails> {
    // Some Additional if needed
    Emails getById(@Param("user_id") int user_id,@Param("emails_storage_id") int emails_storage_id) throws SQLException;
}
