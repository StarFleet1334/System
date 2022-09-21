package com.solvd.app.dao.jdbc;

import com.solvd.app.dao.IEmailsStorageDao;
import com.solvd.app.tables.EmailsStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmailsStorageDao extends AbstractMysqlDao implements IEmailsStorageDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private UsersDao usersDao;


    public EmailsStorageDao() throws IOException {
        usersDao = new UsersDao();
    }

    @Override
    public List<EmailsStorage> getAll() throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from emailsstorage ;");
            resultSet = preparedStatement.executeQuery();
            List<EmailsStorage> list = new ArrayList<>();
            usersDao.setConnection(connection);

            while (resultSet.next()) {
                EmailsStorage emailsStorage = new EmailsStorage();
                int from = resultSet.getInt("email_from_user");
                int to = resultSet.getInt("email_to_user");
                String text = resultSet.getString("text");
                Date time = resultSet.getDate("time");
                int id = resultSet.getInt("id");
                emailsStorage.setId(id);
                emailsStorage.setEmail_from_user(usersDao.get(from));
                emailsStorage.setEmail_to_user(usersDao.get(to));
                emailsStorage.setText(text);
                emailsStorage.setSend_time(time);
                list.add(emailsStorage);
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
    public EmailsStorage get(int id) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from emailsstorage where id= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            usersDao.setConnection(connection);

            while (resultSet.next()) {
                EmailsStorage emailsStorage = new EmailsStorage();
                int from = resultSet.getInt("email_from_user");
                int to = resultSet.getInt("email_to_user");
                String text = resultSet.getString("text");
                Date time = resultSet.getDate("time");
                emailsStorage.setId(id);
                emailsStorage.setEmail_from_user(usersDao.get(from));
                emailsStorage.setEmail_to_user(usersDao.get(to));
                emailsStorage.setText(text);
                emailsStorage.setSend_time(time);
                return emailsStorage;
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
    public void update(EmailsStorage emailsStorage) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("update users set email_from_user = ?, email_to_user = ?, text = ?, time= ? where id = ?;");
            preparedStatement.setInt(1,emailsStorage.getEmail_from_user().getId());
            preparedStatement.setInt(2,emailsStorage.getEmail_to_user().getId());
            if (emailsStorage.getText() == null) {
                preparedStatement.setNull(3,4);
            } else {
                preparedStatement.setString(3,emailsStorage.getText());
            }
            preparedStatement.setDate(4, (java.sql.Date) emailsStorage.getSend_time());
            preparedStatement.setInt(5,emailsStorage.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void delete(EmailsStorage emailsStorage) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("delete from emailsstorage where id= ? ;");
            preparedStatement.setInt(1,emailsStorage.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void create(EmailsStorage emailsStorage) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("insert into users values (default,?,?,?,?) ;");
            preparedStatement.setInt(1,emailsStorage.getEmail_from_user().getId());
            preparedStatement.setInt(2,emailsStorage.getEmail_to_user().getId());
            if (emailsStorage.getText() == null) {
                preparedStatement.setNull(3,4);
            } else {
                preparedStatement.setString(3,emailsStorage.getText());
            }
            preparedStatement.setDate(4, (java.sql.Date) emailsStorage.getSend_time());
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
