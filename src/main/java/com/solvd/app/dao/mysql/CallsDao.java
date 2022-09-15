package com.solvd.app.dao.mysql;

import com.solvd.app.dao.ICallsDao;
import com.solvd.app.tables.Calls;

import java.util.List;

public class CallsDao extends AbstractMysqlDao implements ICallsDao {
    @Override
    public List<Calls> getAll() {
        return null;
    }

    @Override
    public Calls get(int id) {
        return null;
    }

    @Override
    public void update(Calls calls) {

    }

    @Override
    public void delete(Calls calls) {

    }

    @Override
    public void create(Calls calls) {

    }
}
