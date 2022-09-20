package com.solvd.app.dao.jdbc;

import com.solvd.app.dao.IEmailsDao;
import com.solvd.app.tables.Emails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmailsDao extends AbstractMysqlDao implements IEmailsDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);
    private InputStream input;
    private Properties prop;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private UsersDao usersDao;
    private EmailsStorageDao emailsStorageDao;

    public EmailsDao() throws IOException {
        input = UsersDao.class.getResourceAsStream("/db.properties");
        prop = new Properties();
        prop.load(input);
        usersDao = new UsersDao();
        emailsStorageDao = new EmailsStorageDao();
    }

    @Override
    public List<Emails> getAll() throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from emails ;");
            resultSet = preparedStatement.executeQuery();
            List<Emails> list = new ArrayList<>();
            while (resultSet.next()) {
                Emails emails = new Emails();
                int user_id = resultSet.getInt("users_id");
                int emails_id = resultSet.getInt("emails_storage_id");
                emails.setUsers_id(usersDao.get(user_id));
                emails.setEmailsStorage_id(emailsStorageDao.get(emails_id));
                list.add(emails);
            }
            return list;
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
            resultSet.close();
        }
        return null;
    }

    @Override
    public Emails getById(int user_id, int emails_storage_id) throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from emails where users_id= ?,emails_storage_id= ? ;");
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,emails_storage_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Emails emails = new Emails();
                int users_id = resultSet.getInt("users_id");
                int emails_id = resultSet.getInt("emails_storage_id");
                emails.setUsers_id(usersDao.get(users_id));
                emails.setEmailsStorage_id(emailsStorageDao.get(emails_id));
                return emails;
            }

        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
            resultSet.close();
        }
        return null;
    }

    @Override
    public Emails get(int id) {
        return null;
    }

    @Override
    public void update(Emails emails) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("update emails set emails_storage_id= ? where users_id = ?;");
            preparedStatement.setInt(1,emails.getEmailsStorage_id().getId());
            preparedStatement.setInt(2,emails.getUsers_id().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
        }
    }

    @Override
    public void delete(Emails emails) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("delete from emails where users_id= ?,emails_storage_id= ? ;");
            preparedStatement.setInt(1,emails.getUsers_id().getId());
            preparedStatement.setInt(2,emails.getEmailsStorage_id().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
        }
    }

    @Override
    public void create(Emails emails) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("insert into emails values (?,?) ;");
            preparedStatement.setInt(1,emails.getUsers_id().getId());
            preparedStatement.setInt(2,emails.getEmailsStorage_id().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
            resultSet.close();
        }
    }
}
