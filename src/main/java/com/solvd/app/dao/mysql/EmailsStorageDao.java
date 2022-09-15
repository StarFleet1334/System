package com.solvd.app.dao.mysql;

import com.solvd.app.dao.IEmailsStorageDao;
import com.solvd.app.tables.EmailsStorage;

import java.util.List;

public class EmailsStorageDao extends AbstractMysqlDao implements IEmailsStorageDao {
    @Override
    public List<EmailsStorage> getAll() {
        return null;
    }

    @Override
    public EmailsStorage get(int id) {
        return null;
    }

    @Override
    public void update(EmailsStorage emailsStorage) {

    }

    @Override
    public void delete(EmailsStorage emailsStorage) {

    }

    @Override
    public void create(EmailsStorage emailsStorage) {

    }
}
