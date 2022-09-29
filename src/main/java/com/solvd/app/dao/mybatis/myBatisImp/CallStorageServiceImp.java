package com.solvd.app.dao.mybatis.myBatisImp;

import com.solvd.app.dao.mybatis.batisFactory.MybatisFactory;
import com.solvd.app.dao.jdbc.ICallsStorageDao;
import com.solvd.app.dao.mybatis.ICallStorageService;
import com.solvd.app.models.CallsStorage;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class CallStorageServiceImp implements ICallStorageService {
    private static final Logger LOGGER = LogManager.getLogger(CallStorageServiceImp.class);
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();

    @Override
    public List<CallsStorage> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsStorageDao iCallsStorageDao = session.getMapper(ICallsStorageDao.class);
            return iCallsStorageDao.getAll();
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting list of CallsStorage");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public CallsStorage get(int id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsStorageDao iCallsStorageDao = session.getMapper(ICallsStorageDao.class);
            return iCallsStorageDao.get(id);
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting CallsStorage by id");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public void update(CallsStorage callsStorage) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsStorageDao iCallsStorageDao = session.getMapper(ICallsStorageDao.class);
            iCallsStorageDao.update(callsStorage);
            session.commit();
        } catch (SQLException e) {
            session.rollback();
        }
        finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public void delete(CallsStorage callsStorage) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsStorageDao iCallsStorageDao = session.getMapper(ICallsStorageDao.class);
            iCallsStorageDao.delete(callsStorage);
            session.commit();
        } catch (SQLException e) {
            session.rollback();
        }
        finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public void create(CallsStorage callsStorage) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsStorageDao iCallsStorageDao = session.getMapper(ICallsStorageDao.class);
            iCallsStorageDao.create(callsStorage);
            session.commit();
        } catch (SQLException e) {
            session.rollback();
        }
        finally {
            assert session != null;
            session.close();
        }
    }
}
