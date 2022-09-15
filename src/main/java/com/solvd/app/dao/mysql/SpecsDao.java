package com.solvd.app.dao.mysql;

import com.solvd.app.dao.ISpecsDao;
import com.solvd.app.tables.Specs;

import java.util.List;

public class SpecsDao extends AbstractMysqlDao implements ISpecsDao {
    @Override
    public List<Specs> getAll() {
        return null;
    }

    @Override
    public Specs get(int id) {
        return null;
    }

    @Override
    public void update(Specs specs) {

    }

    @Override
    public void delete(Specs specs) {

    }

    @Override
    public void create(Specs specs) {

    }
}
