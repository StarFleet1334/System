package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.IJobsDao;
import com.solvd.app.dao.IUserDao;
import com.solvd.app.service.IJobService;
import com.solvd.app.tables.Jobs;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class JobServiceImp implements IJobService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();

    @Override
    public List<Jobs> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IJobsDao iJobsDao = session.getMapper(IJobsDao.class);
            return iJobsDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            assert session != null;
            session.close();
        }
        // This is unreachable but still
        return null;
    }

    @Override
    public Jobs get(int id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IJobsDao iJobsDao = session.getMapper(IJobsDao.class);
            return iJobsDao.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            assert session != null;
            session.close();
        }
        // This is unreachable but still
        return null;
    }

    @Override
    public void update(Jobs jobs) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IJobsDao iJobsDao = session.getMapper(IJobsDao.class);
            iJobsDao.update(jobs);
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
    public void delete(Jobs jobs) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IJobsDao iJobsDao = session.getMapper(IJobsDao.class);
            iJobsDao.delete(jobs);
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
    public void create(Jobs jobs) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IJobsDao iJobsDao = session.getMapper(IJobsDao.class);
            iJobsDao.create(jobs);
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
