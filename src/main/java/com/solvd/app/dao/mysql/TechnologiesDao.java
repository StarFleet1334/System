package com.solvd.app.dao.mysql;

import com.solvd.app.dao.ITechnologiesDao;
import com.solvd.app.tables.Technologies;

import java.util.List;

public class TechnologiesDao extends AbstractMysqlDao implements ITechnologiesDao {
    @Override
    public List<Technologies> getAll() {
        return null;
    }

    @Override
    public Technologies get(int id) {
        return null;
    }

    @Override
    public void update(Technologies technologies) {

    }

    @Override
    public void delete(Technologies technologies) {

    }

    @Override
    public void create(Technologies technologies) {

    }
}
