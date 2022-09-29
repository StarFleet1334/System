package com.solvd.app.dao.mybatis.myBatisImp;

import com.solvd.app.dao.mybatis.batisFactory.MybatisFactory;
import com.solvd.app.dao.jdbc.IJobsDao;
import com.solvd.app.dao.mybatis.IJobService;
import com.solvd.app.models.Jobs;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class JobServiceImp implements IJobService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(JobServiceImp.class);


    @Override
    public List<Jobs> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IJobsDao iJobsDao = session.getMapper(IJobsDao.class);
            return iJobsDao.getAll();
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting list of jobs");
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
            LOGGER.error("Error,occurred while getting jobs by id");
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
