package com.solvd.app.dao.mysql;

import com.solvd.app.dao.ICallsStorageDao;
import com.solvd.app.tables.CallsStorage;

import java.util.List;

public class CallsStorageDao extends AbstractMysqlDao implements ICallsStorageDao {
    @Override
    public List<CallsStorage> getAll() {
        return null;
    }

    @Override
    public CallsStorage get(int id) {
        return null;
    }

    @Override
    public void update(CallsStorage callsStorage) {

    }

    @Override
    public void delete(CallsStorage callsStorage) {

    }

    @Override
    public void create(CallsStorage callsStorage) {

    }
}
