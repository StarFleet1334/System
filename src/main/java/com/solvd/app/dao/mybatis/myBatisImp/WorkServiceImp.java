package com.solvd.app.dao.mybatis.myBatisImp;

import com.solvd.app.dao.mybatis.batisFactory.MybatisFactory;
import com.solvd.app.dao.jdbc.IWorksDao;
import com.solvd.app.dao.mybatis.IWorkService;
import com.solvd.app.models.Works;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class WorkServiceImp implements IWorkService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(WorkServiceImp.class);

    @Override
    public List<Works> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IWorksDao iWorksDao = session.getMapper(IWorksDao.class);
            return iWorksDao.getAll();
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting list of works");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public Works get(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Works works) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IWorksDao iWorksDao = session.getMapper(IWorksDao.class);
            iWorksDao.update(works);
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
    public void delete(Works works) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IWorksDao iWorksDao = session.getMapper(IWorksDao.class);
            iWorksDao.delete(works);
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
    public void create(Works works) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IWorksDao iWorksDao = session.getMapper(IWorksDao.class);
            iWorksDao.create(works);
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
    public Works getById(int user_id, int job_id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IWorksDao iWorksDao = session.getMapper(IWorksDao.class);
            return iWorksDao.getById(user_id,job_id);
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting works by ids");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }
}
