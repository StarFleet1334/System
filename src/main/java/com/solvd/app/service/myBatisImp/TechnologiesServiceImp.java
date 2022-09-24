package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.ISpecsDao;
import com.solvd.app.dao.ITechnologiesDao;
import com.solvd.app.service.ITechnologiesService;
import com.solvd.app.tables.Technologies;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class TechnologiesServiceImp implements ITechnologiesService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();


    @Override
    public List<Technologies> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ITechnologiesDao iTechnologiesDao = session.getMapper(ITechnologiesDao.class);
            return iTechnologiesDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public Technologies get(int id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ITechnologiesDao iTechnologiesDao = session.getMapper(ITechnologiesDao.class);
            return iTechnologiesDao.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public void update(Technologies technologies) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ITechnologiesDao iTechnologiesDao = session.getMapper(ITechnologiesDao.class);
            iTechnologiesDao.update(technologies);
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
    public void delete(Technologies technologies) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ITechnologiesDao iTechnologiesDao = session.getMapper(ITechnologiesDao.class);
            iTechnologiesDao.delete(technologies);
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
    public void create(Technologies technologies) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ITechnologiesDao iTechnologiesDao = session.getMapper(ITechnologiesDao.class);
            iTechnologiesDao.create(technologies);
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
