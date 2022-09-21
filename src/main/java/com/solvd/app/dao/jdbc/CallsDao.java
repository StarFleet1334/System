package com.solvd.app.dao.jdbc;

import com.solvd.app.connection.ConnectionPool;
import com.solvd.app.dao.ICallsDao;
import com.solvd.app.tables.Calls;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CallsDao extends AbstractMysqlDao implements ICallsDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private UsersDao usersDao;
    private CallsStorageDao callsStorageDao;

    public CallsDao() throws IOException {
        usersDao = new UsersDao();
        callsStorageDao = new CallsStorageDao();
    }


    @Override
    public List<Calls> getAll() throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from calls ;");
            resultSet = preparedStatement.executeQuery();
            List<Calls> list = new ArrayList<>();
            usersDao.setConnection(connection);
            callsStorageDao.setConnection(connection);
            while (resultSet.next()) {
                Calls calls = new Calls();
                int from_user = resultSet.getInt("user_id");
                int calls_storage_id = resultSet.getInt("calls_storage_id");
                calls.setUsers_id(usersDao.get(from_user));
                calls.setCallsStorage_id(callsStorageDao.get(calls_storage_id));
                list.add(calls);
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
    public Calls getById(int user_id, int call_storage_id) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from users where use_id= ?,calls_storage_id= ? ;");
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,call_storage_id);
            resultSet = preparedStatement.executeQuery();
            Calls calls = new Calls();
            calls.setUsers_id(usersDao.get(user_id));
            calls.setCallsStorage_id(callsStorageDao.get(call_storage_id));
            return calls;
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
    public Calls get(int id) {
        return null;
    }

    @Override
    public void update(Calls calls) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("update calls set calls_storage_id = ? where user_id = ?;");
            preparedStatement.setInt(1,calls.getUsers_id().getId());
            preparedStatement.setInt(2,calls.getCallsStorage_id().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void delete(Calls calls) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("delete from calls where user_id= ?,calls_storage_id= ? ;");
            preparedStatement.setInt(1,calls.getUsers_id().getId());
            preparedStatement.setInt(2,calls.getCallsStorage_id().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void create(Calls calls) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("insert into users values (?,?) ;");
            preparedStatement.setInt(1,calls.getUsers_id().getId());
            preparedStatement.setInt(2,calls.getCallsStorage_id().getId());
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
