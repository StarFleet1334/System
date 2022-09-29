package com.solvd.app.dao.jdbc.jdbcImp;


import com.solvd.app.dao.jdbc.IUserDao;
import com.solvd.app.models.Phones;
import com.solvd.app.models.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao extends AbstractMysqlDao implements IUserDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private PhonesDao phonesDao;

    public UsersDao() throws IOException {
        phonesDao = new PhonesDao();
    }


    @Override
    public List<Users> getAll() throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from users ;");
            resultSet = preparedStatement.executeQuery();
            List<Users> list = new ArrayList<>();
            phonesDao.setConnection(connection);
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
            //logger.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        return null;
    }

    @Override
    public Users get(int id) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from users where id= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            phonesDao.setConnection(connection);
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
         //   Logger.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        return null;
    }

    @Override
    public void update(Users users) throws SQLException {
        try  {
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
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void delete(Users users) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("delete from users where id= ? ;");
            preparedStatement.setInt(1,users.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }


    @Override
    public void create(Users users) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("insert into users values (default,?,?,?) ;");
            preparedStatement.setString(1,users.getFull_name());
            preparedStatement.setInt(2,users.getAge());
            phonesDao.setConnection(connection);
            if (users.getPhone() == null) {
                preparedStatement.setNull(3,4);
            } else {

                List<Phones> phones = phonesDao.getAll();
                boolean check = false;
                for (Phones phone : phones) {
                    if (phone.getId() == users.getPhone().getId()) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    phonesDao.create(new Phones(users.getPhone().getId(),users.getPhone().getFull_name(),users.getPhone().getPhone_number()));
                }
                preparedStatement.setInt(3,users.getPhone().getId());
            }
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
