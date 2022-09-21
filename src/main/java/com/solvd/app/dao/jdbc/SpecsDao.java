package com.solvd.app.dao.jdbc;

import com.solvd.app.dao.ISpecsDao;
import com.solvd.app.tables.Specs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SpecsDao extends AbstractMysqlDao implements ISpecsDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public SpecsDao() throws IOException {}

    @Override
    public List<Specs> getAll() throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from specs ;");
            resultSet = preparedStatement.executeQuery();
            List<Specs> list = new ArrayList<>();
            while (resultSet.next()) {
                Specs specs = new Specs();
                String op_system = resultSet.getString("operating_system");
                String model = resultSet.getString("model");
                int memory = resultSet.getInt("memory");
                int id = resultSet.getInt("id");
                String sys_manufacturer = resultSet.getString("system_manufacturer");
                specs.setId(id);
                specs.setOperating_system(op_system);
                specs.setModel(model);
                specs.setMemory(memory);
                specs.setSystem_manufacturer(sys_manufacturer);
                list.add(specs);
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
    public Specs get(int id) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from specs where id= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Specs specs = new Specs();
                String op_system = resultSet.getString("operating_system");
                String model = resultSet.getString("model");
                int memory = resultSet.getInt("memory");
                String sys_manufacturer = resultSet.getString("system_manufacturer");
                specs.setId(id);
                specs.setOperating_system(op_system);
                specs.setModel(model);
                specs.setMemory(memory);
                specs.setSystem_manufacturer(sys_manufacturer);
                return specs;
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
    public void update(Specs specs) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("update specs set operating_system = ?, model = ?, memory = ?, system_manufacturer = ? where id = ?;");
            preparedStatement.setString(1,specs.getOperating_system());
            preparedStatement.setString(2,specs.getModel());
            preparedStatement.setInt(3,specs.getMemory());
            preparedStatement.setString(4,specs.getSystem_manufacturer());
            preparedStatement.setInt(5,specs.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void delete(Specs specs) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("delete from specs where id= ? ;");
            preparedStatement.setInt(1,specs.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void create(Specs specs) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("insert into specs values (default,?,?,?,?) ;");
            preparedStatement.setString(1,specs.getOperating_system());
            preparedStatement.setString(2,specs.getModel());
            preparedStatement.setInt(3,specs.getMemory());
            preparedStatement.setString(4,specs.getSystem_manufacturer());
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
