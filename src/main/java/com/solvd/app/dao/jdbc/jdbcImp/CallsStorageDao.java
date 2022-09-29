package com.solvd.app.dao.jdbc.jdbcImp;

import com.solvd.app.dao.jdbc.ICallsStorageDao;
import com.solvd.app.models.CallsStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CallsStorageDao extends AbstractMysqlDao implements ICallsStorageDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private UsersDao usersDao;

    public CallsStorageDao() throws IOException {
        usersDao = new UsersDao();
    }

    @Override
    public List<CallsStorage> getAll() throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from callsstorage ;");
            resultSet = preparedStatement.executeQuery();
            List<CallsStorage> list = new ArrayList<>();
            while (resultSet.next()) {
                CallsStorage callsStorage = new CallsStorage();
                int id = resultSet.getInt("id");
                int from_user = resultSet.getInt("from_user");
                int to_user = resultSet.getInt("to_user");
                callsStorage.setId(id);
                callsStorage.setFrom_user(usersDao.get(from_user));
                callsStorage.setTo_user(usersDao.get(to_user));
                list.add(callsStorage);
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
    public CallsStorage get(int id) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from callsstorage where id= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            usersDao.setConnection(connection);
            while (resultSet.next()) {
                CallsStorage callsStorage = new CallsStorage();
                int from_user = resultSet.getInt("from_user");
                int to_user = resultSet.getInt("to_user");
                callsStorage.setId(id);
                callsStorage.setFrom_user(usersDao.get(from_user));
                callsStorage.setTo_user(usersDao.get(to_user));
                return callsStorage;
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
    public void update(CallsStorage callsStorage) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("update callsstorage set from_user = ?, to_user = ? where id = ?;");
            preparedStatement.setInt(1,callsStorage.getFrom_user().getId());
            preparedStatement.setInt(2,callsStorage.getTo_user().getId());
            preparedStatement.setInt(3,callsStorage.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void delete(CallsStorage callsStorage) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("delete from callsstorage where id= ? ;");
            preparedStatement.setInt(1,callsStorage.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void create(CallsStorage callsStorage) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("insert into callstorage values (default,?,?) ;");
            preparedStatement.setInt(1,callsStorage.getFrom_user().getId());
            preparedStatement.setInt(2,callsStorage.getTo_user().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
