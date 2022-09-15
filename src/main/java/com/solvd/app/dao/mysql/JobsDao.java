package com.solvd.app.dao.mysql;

import com.solvd.app.dao.IJobsDao;
import com.solvd.app.tables.CodeSalaries;
import com.solvd.app.tables.Jobs;
import com.solvd.app.tables.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JobsDao extends AbstractMysqlDao implements IJobsDao {
    private static final Logger logger = LogManager.getLogger(UsersDao.class);
    private InputStream input;
    private Properties prop;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private CodeSalariesDao codeSalariesDao;

    public JobsDao() throws IOException {
        input = UsersDao.class.getResourceAsStream("/db.properties");
        prop = new Properties();
        prop.load(input);
        codeSalariesDao = new CodeSalariesDao();
    }
    @Override
    public List<Jobs> getAll() throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from Jobs ;");
            resultSet = preparedStatement.executeQuery();
            List<Jobs> list = new ArrayList<>();
            while (resultSet.next()) {
                Jobs jobs = new Jobs();
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int code = resultSet.getInt("code");
                int id = resultSet.getInt("id_jobs");
                jobs.setId(id);
                jobs.setName(name);
                jobs.setDescription(description);
                jobs.setCode(codeSalariesDao.get(code));
                list.add(jobs);
            }
            return list;
        } catch (Exception e) {
            logger.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
            resultSet.close();
        }
        return null;
    }

    @Override
    public Jobs get(int id) throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from jobs where id_jobs= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Jobs jobs = new Jobs();
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int code = resultSet.getInt("code");
                jobs.setId(id);
                jobs.setName(name);
                jobs.setDescription(description);
                jobs.setCode(codeSalariesDao.get(code));
                System.out.println(name + " " + description + " " + code);
                return jobs;
            }

        } catch (Exception e) {
            logger.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
            resultSet.close();
        }
        return null;
    }

    @Override
    public void update(Jobs jobs) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("update jobs set name = ?, description = ?, code = ? where id_jobs = ?;");
            preparedStatement.setString(1,jobs.getName());
            preparedStatement.setString(2,jobs.getDescription());
            preparedStatement.setInt(3,jobs.getCode().getId());
            preparedStatement.setInt(4,jobs.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
        }
    }

    @Override
    public void delete(Jobs jobs) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("delete from jobs where id_jobs= ? ;");
            preparedStatement.setInt(1,jobs.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
        }
    }

    @Override
    public void create(Jobs jobs) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("insert into jobs values (default,?,?,?) ;");
            codeSalariesDao.create(new CodeSalaries(jobs.getCode().getId(),jobs.getCode().getSalary()));
            preparedStatement.setString(1,jobs.getName());
            preparedStatement.setString(2,jobs.getDescription());
            preparedStatement.setInt(3,jobs.getCode().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
        }
    }
}
