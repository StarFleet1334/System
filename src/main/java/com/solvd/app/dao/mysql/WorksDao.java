package com.solvd.app.dao.mysql;

import com.solvd.app.dao.IWorksDao;
import com.solvd.app.tables.Works;

import java.util.List;

public class WorksDao extends AbstractMysqlDao implements IWorksDao {
    @Override
    public List<Works> getAll() {
        return null;
    }

    @Override
    public Works get(int id) {
        return null;
    }

    @Override
    public void update(Works works) {

    }

    @Override
    public void delete(Works works) {

    }

    @Override
    public void create(Works works) {

    }
}
