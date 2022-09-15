package com.solvd.app.dao.mysql;

import com.solvd.app.dao.IJobsDao;
import com.solvd.app.tables.Jobs;

import java.util.List;

public class JobsDao extends AbstractMysqlDao implements IJobsDao {
    @Override
    public List<Jobs> getAll() {
        return null;
    }

    @Override
    public Jobs get(int id) {
        return null;
    }

    @Override
    public void update(Jobs jobs) {

    }

    @Override
    public void delete(Jobs jobs) {

    }

    @Override
    public void create(Jobs jobs) {

    }
}
