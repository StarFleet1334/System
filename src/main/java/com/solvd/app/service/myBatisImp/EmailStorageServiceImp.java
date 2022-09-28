package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.IEmailsStorageDao;
import com.solvd.app.service.IEmailStorageService;
import com.solvd.app.tables.EmailsStorage;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class EmailStorageServiceImp implements IEmailStorageService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(EmailStorageServiceImp.class);

    @Override
    public List<EmailsStorage> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsStorageDao iEmailsStorageDao = session.getMapper(IEmailsStorageDao.class);
            return iEmailsStorageDao.getAll();
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting list of EmailsStorage");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public EmailsStorage get(int id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsStorageDao iEmailsStorageDao = session.getMapper(IEmailsStorageDao.class);
            return iEmailsStorageDao.get(id);
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting EmailsStorage by id");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public void update(EmailsStorage emailsStorage) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsStorageDao iEmailsStorageDao = session.getMapper(IEmailsStorageDao.class);
            iEmailsStorageDao.update(emailsStorage);
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
    public void delete(EmailsStorage emailsStorage) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsStorageDao iEmailsStorageDao = session.getMapper(IEmailsStorageDao.class);
            iEmailsStorageDao.delete(emailsStorage);
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
    public void create(EmailsStorage emailsStorage) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IEmailsStorageDao iEmailsStorageDao = session.getMapper(IEmailsStorageDao.class);
            iEmailsStorageDao.create(emailsStorage);
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
