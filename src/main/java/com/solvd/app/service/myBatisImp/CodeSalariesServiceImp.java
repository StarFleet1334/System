package com.solvd.app.service.myBatisImp;

import com.solvd.app.MybatisFactory;
import com.solvd.app.dao.ICodeSalariesDao;
import com.solvd.app.dao.IPhonesDao;
import com.solvd.app.service.ICodeSalariesService;
import com.solvd.app.tables.CodeSalaries;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class CodeSalariesServiceImp implements ICodeSalariesService {
    private final static SqlSessionFactory sqlSessionFactory = MybatisFactory.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(CodeSalariesServiceImp.class);

    @Override
    public List<CodeSalaries> getAll() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICodeSalariesDao iCodeSalariesDao = session.getMapper(ICodeSalariesDao.class);
            return iCodeSalariesDao.getAll();
        } catch (SQLException e) {
            LOGGER.error("Error, Occurred in CodeSalariesServiceImp while getting List of Salaries");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public CodeSalaries get(int id) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICodeSalariesDao iCodeSalariesDao = session.getMapper(ICodeSalariesDao.class);
            return iCodeSalariesDao.get(id);
        } catch (SQLException e) {
            LOGGER.error("Error, Occurred in CodeSalariesServiceImp while getting Salary by id");
        }
        finally {
            assert session != null;
            session.close();
        }
        return null;
    }

    @Override
    public void update(CodeSalaries codeSalaries) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICodeSalariesDao iCodeSalariesDao = session.getMapper(ICodeSalariesDao.class);
            iCodeSalariesDao.update(codeSalaries);
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
    public void delete(CodeSalaries codeSalaries) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICodeSalariesDao iCodeSalariesDao = session.getMapper(ICodeSalariesDao.class);
            iCodeSalariesDao.delete(codeSalaries);
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
    public void create(CodeSalaries codeSalaries) throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            ICodeSalariesDao iCodeSalariesDao = session.getMapper(ICodeSalariesDao.class);
            iCodeSalariesDao.create(codeSalaries);
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
