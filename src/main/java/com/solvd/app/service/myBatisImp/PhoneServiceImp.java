package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.IPhonesDao;
import com.solvd.app.dao.IUserDao;
import com.solvd.app.service.IPhoneService;
import com.solvd.app.tables.Phones;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class PhoneServiceImp implements IPhoneService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();

    @Override
    public List<Phones> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IPhonesDao iPhonDao = session.getMapper(IPhonesDao.class);
            return iPhonDao.getAll();
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
    public Phones get(int id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IPhonesDao iPhonDao = session.getMapper(IPhonesDao.class);
            return iPhonDao.get(id);
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
    public void update(Phones phones) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IPhonesDao iPhonDao = session.getMapper(IPhonesDao.class);
            iPhonDao.update(phones);
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
    public void delete(Phones phones) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IPhonesDao iPhonDao = session.getMapper(IPhonesDao.class);
            iPhonDao.delete(phones);
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
    public void create(Phones phones) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IPhonesDao iPhonDao = session.getMapper(IPhonesDao.class);
            iPhonDao.create(phones);
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
