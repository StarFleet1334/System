package com.solvd.app.dao.mysql;

import com.solvd.app.dao.IWorksDao;
import com.solvd.app.tables.Phones;
import com.solvd.app.tables.Users;
import com.solvd.app.tables.Works;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class WorksDao extends AbstractMysqlDao implements IWorksDao {
    private static final Logger logger = LogManager.getLogger(UsersDao.class);
    private InputStream input;
    private Properties prop;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private UsersDao usersDao;
    private JobsDao jobsDao;

    public WorksDao() throws IOException {
        input = UsersDao.class.getResourceAsStream("/db.properties");
        prop = new Properties();
        prop.load(input);
        usersDao = new UsersDao();
        jobsDao = new JobsDao();
    }

    @Override
    public List<Works> getAll() throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from works ;");
            resultSet = preparedStatement.executeQuery();
            List<Works> list = new ArrayList<>();
            while (resultSet.next()) {
                Works works = new Works();
                int users_id = resultSet.getInt("users_id");
                int jobs_id = resultSet.getInt("jobs_id");
                Date start_date = resultSet.getDate("start_date");
                works.setUsers_id(usersDao.get(users_id));
                works.setJobs_id(jobsDao.get(jobs_id));
                works.setStart_date(start_date);
                list.add(works);
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
    public Works getById(int user_id, int job_id) throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from works where users_id= ?,jobs_id= ? ;");
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,job_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Works works = new Works();
                Date start_date = resultSet.getDate("start_date");
                works.setUsers_id(usersDao.get(user_id));
                works.setJobs_id(jobsDao.get(job_id));
                works.setStart_date(start_date);
                return works;
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
    public Works get(int id)  {
        return null;
    }

    @Override
    public void update(Works works) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("update works set jobs_id = ?,start_date = ? where users_id = ?;");
            preparedStatement.setInt(1,works.getJobs_id().getId());
            preparedStatement.setDate(2, (java.sql.Date) works.getStart_date());
            preparedStatement.setInt(3,works.getUsers_id().getId());
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
    public void delete(Works works) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("delete from works where users_id= ? ;");
            preparedStatement.setInt(1,works.getUsers_id().getId());
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
    public void create(Works works) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("insert into works values (?,?,?) ;");
            preparedStatement.setInt(1,works.getUsers_id().getId());
            preparedStatement.setInt(2,works.getJobs_id().getId());
            preparedStatement.setDate(3, (java.sql.Date) works.getStart_date());
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
