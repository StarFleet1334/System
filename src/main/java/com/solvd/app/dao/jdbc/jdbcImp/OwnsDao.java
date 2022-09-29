package com.solvd.app.dao.jdbc.jdbcImp;

import com.solvd.app.dao.jdbc.IOwnsDao;
import com.solvd.app.models.Owns;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnsDao extends AbstractMysqlDao implements IOwnsDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private UsersDao usersDao;
    private TechnologiesDao technologiesDao;

    public OwnsDao() throws IOException {
        usersDao = new UsersDao();
        technologiesDao = new TechnologiesDao();
    }

    @Override
    public List<Owns> getAll() throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from owns ;");
            resultSet = preparedStatement.executeQuery();
            List<Owns> list = new ArrayList<>();
            usersDao.setConnection(connection);
            technologiesDao.setConnection(connection);

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
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
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
            preparedStatement = connection.prepareStatement("update owns set technology_id = ?, name = ? where user_id = ?;");
            preparedStatement.setInt(1,owns.getTechnologies_id().getId());
            preparedStatement.setString(2,owns.getName());
            preparedStatement.setInt(3,owns.getUsers_id().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void delete(Owns owns) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("delete from works where user_id= ?,technology_id= ? ;");
            preparedStatement.setInt(1,owns.getUsers_id().getId());
            preparedStatement.setInt(2,owns.getTechnologies_id().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void create(Owns owns) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("insert into owns values (?,?,?) ;");
            preparedStatement.setInt(1,owns.getUsers_id().getId());
            preparedStatement.setInt(2,owns.getTechnologies_id().getId());
            preparedStatement.setString(3,owns.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public Owns getById(int users_id, int tech_id) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from users where users_id= ?,technology_id= ? ;");
            preparedStatement.setInt(1,users_id);
            preparedStatement.setInt(2,tech_id);
            resultSet = preparedStatement.executeQuery();
            usersDao.setConnection(connection);
            technologiesDao.setConnection(connection);

            while (resultSet.next()) {
                Owns owns = new Owns();
                String name = resultSet.getString("name");
                owns.setUsers_id(usersDao.get(users_id));
                owns.setTechnologies_id(technologiesDao.get(tech_id));
                owns.setName(name);
                return owns;
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

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
