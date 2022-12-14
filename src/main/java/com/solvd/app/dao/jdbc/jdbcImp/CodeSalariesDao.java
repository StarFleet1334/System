package com.solvd.app.dao.jdbc.jdbcImp;

import com.solvd.app.dao.jdbc.ICodeSalariesDao;
import com.solvd.app.models.CodeSalaries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CodeSalariesDao extends AbstractMysqlDao implements ICodeSalariesDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public CodeSalariesDao() throws IOException {}

    @Override
    public List<CodeSalaries> getAll() throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from codesalaries ;");
            resultSet = preparedStatement.executeQuery();
            List<CodeSalaries> list = new ArrayList<>();
            while (resultSet.next()) {
                CodeSalaries codeSalaries = new CodeSalaries();
                int code = resultSet.getInt("id_code");
                double salary = resultSet.getDouble("salary");
                codeSalaries.setId(code);
                codeSalaries.setSalary(salary);
                list.add(codeSalaries);
            }
            return list;
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        return null;
    }

    @Override
    public CodeSalaries get(int id) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from codesalaries where id_code= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CodeSalaries codeSalaries = new CodeSalaries();
                double salary = resultSet.getDouble("salary");
                codeSalaries.setId(id);
                codeSalaries.setSalary(salary);
                return codeSalaries;
            }
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        return null;
    }

    @Override
    public void update(CodeSalaries codeSalaries) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("update codesalaries set salary= ? where id_code = ?;");
            preparedStatement.setDouble(1,codeSalaries.getSalary());
            preparedStatement.setInt(2,codeSalaries.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void delete(CodeSalaries codeSalaries) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("delete from codesalaries where id_code= ? ;");
            preparedStatement.setInt(1,codeSalaries.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void create(CodeSalaries codeSalaries) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("insert into codesalaries values (default,?) ;");
            preparedStatement.setDouble(1,codeSalaries.getSalary());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
