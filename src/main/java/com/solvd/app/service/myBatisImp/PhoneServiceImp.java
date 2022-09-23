package com.solvd.app.service.myBatisImp;

import com.solvd.app.service.IPhoneService;
import com.solvd.app.tables.Phones;

import java.sql.SQLException;
import java.util.List;

public class PhoneServiceImp implements IPhoneService {
    @Override
    public List<Phones> getAll() throws SQLException {
        return null;
    }

    @Override
    public Phones get(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Phones phones) throws SQLException {

    }

    @Override
    public void delete(Phones phones) throws SQLException {

    }

    @Override
    public void create(Phones phones) throws SQLException {

    }
}
