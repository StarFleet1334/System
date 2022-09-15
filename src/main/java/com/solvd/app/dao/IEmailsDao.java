package com.solvd.app.dao;

import com.solvd.app.tables.Emails;

import java.sql.SQLException;

public interface IEmailsDao extends IBaseDao<Emails> {
    // Some Additional if needed
    Emails getById(int user_id,int emails_storage_id) throws SQLException;
}
