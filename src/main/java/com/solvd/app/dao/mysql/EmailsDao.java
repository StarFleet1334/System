package com.solvd.app.dao.mysql;

import com.solvd.app.dao.IEmailsDao;
import com.solvd.app.tables.Emails;

import java.util.List;

public class EmailsDao extends AbstractMysqlDao implements IEmailsDao {
    @Override
    public List<Emails> getAll() {
        return null;
    }

    @Override
    public Emails get(int id) {
        return null;
    }

    @Override
    public void update(Emails emails) {

    }

    @Override
    public void delete(Emails emails) {

    }

    @Override
    public void create(Emails emails) {

    }
}
