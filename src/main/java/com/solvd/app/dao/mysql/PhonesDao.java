package com.solvd.app.dao.mysql;

import com.solvd.app.dao.IPhonesDao;
import com.solvd.app.tables.Phones;

import java.util.List;

public class PhonesDao extends AbstractMysqlDao implements IPhonesDao {
    @Override
    public List<Phones> getAll() {
        return null;
    }

    @Override
    public Phones get(int id) {
        return null;
    }

    @Override
    public void update(Phones phones) {

    }

    @Override
    public void delete(Phones phones) {

    }

    @Override
    public void create(Phones phones) {

    }
}
