package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.IPhonesDao;
import com.solvd.app.dao.ISpecsDao;
import com.solvd.app.service.ISpecsService;
import com.solvd.app.tables.Specs;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class SpecServiceImp implements ISpecsService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(SpecServiceImp.class);

    @Override
    public List<Specs> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ISpecsDao iSpecsDao = session.getMapper(ISpecsDao.class);
            return iSpecsDao.getAll();
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting list of specs");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public Specs get(int id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ISpecsDao iSpecsDao = session.getMapper(ISpecsDao.class);
            return iSpecsDao.get(id);
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting specs by id");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public void update(Specs specs) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ISpecsDao iSpecsDao = session.getMapper(ISpecsDao.class);
            iSpecsDao.update(specs);
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
    public void delete(Specs specs) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ISpecsDao iSpecsDao = session.getMapper(ISpecsDao.class);
            iSpecsDao.delete(specs);
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
    public void create(Specs specs) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ISpecsDao iSpecsDao = session.getMapper(ISpecsDao.class);
            iSpecsDao.create(specs);
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
