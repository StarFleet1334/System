package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.IOwnsDao;
import com.solvd.app.dao.IWorksDao;
import com.solvd.app.service.IOwnService;
import com.solvd.app.tables.Owns;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class OwnServiceImp implements IOwnService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();


    @Override
    public List<Owns> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IOwnsDao iOwnsDao = session.getMapper(IOwnsDao.class);
            return iOwnsDao.getAll();
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
    public Owns get(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Owns owns) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IOwnsDao iOwnsDao = session.getMapper(IOwnsDao.class);
            iOwnsDao.update(owns);
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
    public void delete(Owns owns) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IOwnsDao iOwnsDao = session.getMapper(IOwnsDao.class);
            iOwnsDao.delete(owns);
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
    public void create(Owns owns) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IOwnsDao iOwnsDao = session.getMapper(IOwnsDao.class);
            iOwnsDao.create(owns);
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
    public Owns getById(int users_id, int tech_id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IOwnsDao iOwnsDao = session.getMapper(IOwnsDao.class);
            return iOwnsDao.getById(users_id,tech_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }
}
