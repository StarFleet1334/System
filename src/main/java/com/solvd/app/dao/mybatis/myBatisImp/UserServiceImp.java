package com.solvd.app.dao.mybatis.myBatisImp;

import com.solvd.app.dao.mybatis.batisFactory.MybatisFactory;
import com.solvd.app.dao.jdbc.IUserDao;
import com.solvd.app.dao.mybatis.IUserService;
import com.solvd.app.models.Users;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImp implements IUserService {

    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImp.class);

    @Override
    public List<Users> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserDao iUserDao = session.getMapper(IUserDao.class);
            return iUserDao.getAll();
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting list of users");
        }
        finally {
            assert session != null;
            session.close();
        }
        // This is unreachable but still
        return null;
    }

    @Override
    public Users get(int id) {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserDao iUserDao = session.getMapper(IUserDao.class);
            return iUserDao.get(id);
        } catch (SQLException e) {
            LOGGER.error("Error,occurred while getting users by id");
        }
        finally {
            assert session != null;
            session.close();
        }
        // This is unreachable but still
        return null;
    }

    @Override
    public void update(Users users) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserDao iUserDao = session.getMapper(IUserDao.class);
            iUserDao.update(users);
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
    public void delete(Users users) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserDao iUserDao = session.getMapper(IUserDao.class);
            iUserDao.delete(users);
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
    public void create(Users users) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserDao iUserDao = session.getMapper(IUserDao.class);
            iUserDao.create(users);
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
