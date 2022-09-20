package com.solvd.app.dao.jdbc;

import com.solvd.app.dao.IPhonesDao;
import com.solvd.app.tables.Phones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PhonesDao extends AbstractMysqlDao implements IPhonesDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);
    private InputStream input;
    private Properties prop;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public PhonesDao() throws IOException {
        input = UsersDao.class.getResourceAsStream("/db.properties");
        prop = new Properties();
        prop.load(input);
    }

    @Override
    public List<Phones> getAll() throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from phones ;");
            resultSet = preparedStatement.executeQuery();
            List<Phones> list = new ArrayList<>();
            while (resultSet.next()) {
                Phones phones = new Phones();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("full_name");
                String phone_number = resultSet.getString("phone_number");
                phones.setId(id);
                phones.setPhone_number(phone_number);
                phones.setFull_name(name);
                list.add(phones);
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
    public Phones get(int id) throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from phones where id= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Phones phone = new Phones();
                String full_name = resultSet.getString("full_name");
                String phone_number = resultSet.getString("phone_number");
                phone.setId(id);
                phone.setFull_name(full_name);
                phone.setPhone_number(phone_number);
                System.out.println(full_name + " " + phone_number);
                return phone;
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
    public void update(Phones phones) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("update phones set full_name = ?, phone_number = ? where id = ?;");
            preparedStatement.setString(1,phones.getFull_name());
            if (phones.getPhone_number() == null) {
                preparedStatement.setNull(2,4);
            } else {
                preparedStatement.setString(2,phones.getPhone_number());
            }
            preparedStatement.setInt(3,phones.getId());
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
    public void delete(Phones phones) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("delete from phones where id= ? ;");
            preparedStatement.setInt(1,phones.getId());
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
    public void create(Phones phones) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("insert into phones values (default,?,?) ;");
            preparedStatement.setString(1,phones.getFull_name());
            if (phones.getPhone_number() == null) {
                preparedStatement.setNull(2,4);
            } else {
                preparedStatement.setString(2,phones.getPhone_number());
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            connection.close();
            preparedStatement.close();
        }
    }
}
