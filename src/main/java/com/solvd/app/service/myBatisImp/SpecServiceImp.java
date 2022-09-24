package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.IPhonesDao;
import com.solvd.app.dao.ISpecsDao;
import com.solvd.app.service.ISpecsService;
import com.solvd.app.tables.Specs;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class SpecServiceImp implements ISpecsService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();

    @Override
    public List<Specs> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ISpecsDao iSpecsDao = session.getMapper(ISpecsDao.class);
            return iSpecsDao.getAll();
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
    public Specs get(int id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ISpecsDao iSpecsDao = session.getMapper(ISpecsDao.class);
            return iSpecsDao.get(id);
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
