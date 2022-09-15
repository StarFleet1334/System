package com.solvd.app.dao.mysql;

import com.solvd.app.dao.IOwnsDao;
import com.solvd.app.tables.Owns;

import java.util.List;

public class OwnsDao extends AbstractMysqlDao implements IOwnsDao {
    @Override
    public List<Owns> getAll() {
        return null;
    }

    @Override
    public Owns get(int id) {
        return null;
    }

    @Override
    public void update(Owns owns) {

    }

    @Override
    public void delete(Owns owns) {

    }

    @Override
    public void create(Owns owns) {

    }
}
