package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.IEmailsDao;
import com.solvd.app.dao.IJobsDao;
import com.solvd.app.service.IEmailService;
import com.solvd.app.tables.Emails;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class EmailServiceImp implements IEmailService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(EmailServiceImp.class);

    @Override
    public List<Emails> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsDao iEmailsDao = session.getMapper(IEmailsDao.class);
            return iEmailsDao.getAll();
        } catch (SQLException e) {
            LOGGER.error("Error, occurred in EmailServiceImp while getting List of Emails");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public Emails get(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Emails emails) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsDao iEmailsDao = session.getMapper(IEmailsDao.class);
            iEmailsDao.update(emails);
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
    public void delete(Emails emails) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsDao iEmailsDao = session.getMapper(IEmailsDao.class);
            iEmailsDao.delete(emails);
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
    public void create(Emails emails) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsDao iEmailsDao = session.getMapper(IEmailsDao.class);
            iEmailsDao.create(emails);
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
    public Emails getById(int user_id, int emails_storage_id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsDao iEmailsDao = session.getMapper(IEmailsDao.class);
            return iEmailsDao.getById(user_id,emails_storage_id);
        } catch (SQLException e) {
            LOGGER.error("Error, occurred in EmailServiceImp while getting Email by ids");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }
}
