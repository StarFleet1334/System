package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.ITechnologiesDao;
import com.solvd.app.dao.IWorksDao;
import com.solvd.app.service.IWorkService;
import com.solvd.app.tables.Works;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class WorkServiceImp implements IWorkService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();


    @Override
    public List<Works> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IWorksDao iWorksDao = session.getMapper(IWorksDao.class);
            return iWorksDao.getAll();
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
            e.printStackTrace();
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }
}
