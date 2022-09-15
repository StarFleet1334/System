package com.solvd.app.dao.mysql;


import com.solvd.app.dao.IUserDao;
import com.solvd.app.tables.Phones;
import com.solvd.app.tables.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UsersDao extends AbstractMysqlDao implements IUserDao {
    private static final Logger logger = LogManager.getLogger(UsersDao.class);
    private InputStream input;
    private Properties prop;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private PhonesDao phonesDao;

    public UsersDao() throws IOException {
        input = UsersDao.class.getResourceAsStream("/db.properties");
        prop = new Properties();
        prop.load(input);
        phonesDao = new PhonesDao();
    }


    @Override
    public List<Users> getAll() throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from users ;");
            resultSet = preparedStatement.executeQuery();
            List<Users> list = new ArrayList<>();
            while (resultSet.next()) {
                Users user = new Users();
                int user_id = resultSet.getInt("id");
                String full_name = resultSet.getString("full_name");
                int age = resultSet.getInt("age");
                int phones_id = resultSet.getInt("phones_id");
                user.setId(user_id);
                user.setFull_name(full_name);
                user.setAge(age);
                user.setPhone(phonesDao.get(phones_id));
                list.add(user);
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
    public Users get(int id) throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from users where id= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users user = new Users();
                int user_id = resultSet.getInt("id");
                String full_name = resultSet.getString("full_name");
                int age = resultSet.getInt("age");
                int phones_id = resultSet.getInt("phones_id");
                user.setId(user_id);
                user.setFull_name(full_name);
                user.setAge(age);
                user.setPhone(phonesDao.get(phones_id));
                return user;
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
    public void update(Users users) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("update users set full_name = ?, age = ?, phones_id = ? where id = ?;");
            preparedStatement.setString(1,users.getFull_name());
            preparedStatement.setInt(2,users.getAge());
            if (users.getPhone() == null) {
                preparedStatement.setNull(3,4);
            } else {
                preparedStatement.setInt(3,users.getPhone().getId());
            }
            preparedStatement.setInt(4,users.getId());
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
    public void delete(Users users) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("delete from users where id= ? ;");
            preparedStatement.setInt(1,users.getId());
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
    public void create(Users users) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("insert into users values (default,?,?,?) ;");
            preparedStatement.setString(1,users.getFull_name());
            preparedStatement.setInt(2,users.getAge());
            if (users.getPhone() == null) {
                preparedStatement.setNull(3,4);
            } else {
                phonesDao.create(new Phones(users.getPhone().getId(),users.getPhone().getFull_name(),users.getPhone().getPhone_number()));
                preparedStatement.setInt(3,users.getPhone().getId());
            }
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
