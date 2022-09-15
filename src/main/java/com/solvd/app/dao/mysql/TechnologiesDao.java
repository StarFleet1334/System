package com.solvd.app.dao.mysql;

import com.solvd.app.dao.ITechnologiesDao;
import com.solvd.app.tables.Technologies;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

public class TechnologiesDao extends AbstractMysqlDao implements ITechnologiesDao {
    private static final Logger logger = LogManager.getLogger(UsersDao.class);
    private InputStream input;
    private Properties prop;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private SpecsDao specsDao;

    public TechnologiesDao() throws IOException {
        input = UsersDao.class.getResourceAsStream("/db.properties");
        prop = new Properties();
        prop.load(input);
        specsDao = new SpecsDao();
    }

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
