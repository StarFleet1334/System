package com.solvd.app.dao.mysql;

import com.solvd.app.dao.IOwnsDao;
import com.solvd.app.tables.Owns;
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

public class OwnsDao extends AbstractMysqlDao implements IOwnsDao {
    private static final Logger logger = LogManager.getLogger(UsersDao.class);
    private InputStream input;
    private Properties prop;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private UsersDao usersDao;
    private TechnologiesDao technologiesDao;

    public OwnsDao() throws IOException {
        input = UsersDao.class.getResourceAsStream("/db.properties");
        prop = new Properties();
        prop.load(input);
        usersDao = new UsersDao();
        technologiesDao = new TechnologiesDao();
    }

    @Override
    public List<Owns> getAll() throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from owns ;");
            resultSet = preparedStatement.executeQuery();
            List<Owns> list = new ArrayList<>();
            while (resultSet.next()) {
                Owns owns = new Owns();
                int user_id = resultSet.getInt("user_id");
                int tech_id = resultSet.getInt("technology_id");
                String name = resultSet.getString("name");
                owns.setUsers_id(usersDao.get(user_id));
                owns.setTechnologies_id(technologiesDao.get(tech_id));
                owns.setName(name);
                list.add(owns);
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
    public Owns get(int id) {
        return null;
    }

    @Override
    public void update(Owns owns) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("update owns set technology_id = ?, name = ? where user_id = ?;");
            preparedStatement.setInt(1,owns.getTechnologies_id().getId());
            preparedStatement.setString(2,owns.getName());
            preparedStatement.setInt(3,owns.getUsers_id().getId());
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
    public void delete(Owns owns) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("delete from works where user_id= ?,technology_id= ? ;");
            preparedStatement.setInt(1,owns.getUsers_id().getId());
            preparedStatement.setInt(2,owns.getTechnologies_id().getId());
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
    public void create(Owns owns) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("insert into owns values (?,?,?) ;");
            preparedStatement.setInt(1,owns.getUsers_id().getId());
            preparedStatement.setInt(2,owns.getTechnologies_id().getId());
            preparedStatement.setString(3,owns.getName());
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
    public Owns getById(int users_id, int tech_id) throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from users where users_id= ?,technology_id= ? ;");
            preparedStatement.setInt(1,users_id);
            preparedStatement.setInt(2,tech_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Owns owns = new Owns();
                String name = resultSet.getString("name");
                owns.setUsers_id(usersDao.get(users_id));
                owns.setTechnologies_id(technologiesDao.get(tech_id));
                owns.setName(name);
                return owns;
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
}
