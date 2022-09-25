package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.ICallsDao;
import com.solvd.app.dao.ICodeSalariesDao;
import com.solvd.app.service.ICallService;
import com.solvd.app.tables.Calls;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class CallServiceImp implements ICallService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();


    @Override
    public List<Calls> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsDao iCallsDao = session.getMapper(ICallsDao.class);
            return iCallsDao.getAll();
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
    public Calls get(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Calls calls) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsDao iCallsDao = session.getMapper(ICallsDao.class);
            iCallsDao.update(calls);
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
    public void delete(Calls calls) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsDao iCallsDao = session.getMapper(ICallsDao.class);
            iCallsDao.delete(calls);
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
    public void create(Calls calls) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsDao iCallsDao = session.getMapper(ICallsDao.class);
            iCallsDao.create(calls);
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
    public Calls getById(int user_id, int call_storage_id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICallsDao iCallsDao = session.getMapper(ICallsDao.class);
            return iCallsDao.getById(user_id,call_storage_id);
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
