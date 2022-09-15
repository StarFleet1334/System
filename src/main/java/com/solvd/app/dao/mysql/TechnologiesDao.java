package com.solvd.app.dao.mysql;

import com.solvd.app.dao.ITechnologiesDao;
import com.solvd.app.tables.Phones;
import com.solvd.app.tables.Technologies;
import com.solvd.app.tables.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TechnologiesDao extends AbstractMysqlDao implements ITechnologiesDao {
    private static final Logger logger = LogManager.getLogger(UsersDao.class);
    private InputStream input;
    private Properties prop;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private SpecsDao specsDao;

    public TechnologiesDao() throws IOException {
        input = UsersDao.class.getResourceAsStream("/db.properties");
        prop = new Properties();
        prop.load(input);
        specsDao = new SpecsDao();
    }

    @Override
    public List<Technologies> getAll() throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from technologies ;");
            resultSet = preparedStatement.executeQuery();
            List<Technologies> list = new ArrayList<>();
            while (resultSet.next()) {
                Technologies technologies = new Technologies();
                String name = resultSet.getString("name");
                int pc = resultSet.getInt("pc");
                int leptop = resultSet.getInt("leptop");
                int specs_id = resultSet.getInt("specs");
                int id = resultSet.getInt("id_technologies");
                technologies.setId(id);
                technologies.setName(name);
                technologies.setPc(pc);
                technologies.setLeptop(leptop);
                list.add(technologies);
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
    public Technologies get(int id) throws SQLException {
        try {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("Select * from technologies where id_technologies= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Technologies technologies = new Technologies();
                String name = resultSet.getString("name");
                int pc = resultSet.getInt("pc");
                int leptop = resultSet.getInt("leptop");
                int specs_id = resultSet.getInt("specs");
                technologies.setId(id);
                technologies.setName(name);
                technologies.setPc(pc);
                technologies.setLeptop(leptop);
                technologies.setSpecs(specsDao.get(specs_id));
                return technologies;
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
    public void update(Technologies technologies) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("update technologies set name = ?, pc = ?, leptop = ?,specs = ? where id_technologies = ?;");
            preparedStatement.setString(1,technologies.getName());
            preparedStatement.setInt(2,technologies.getPc());
            preparedStatement.setInt(3,technologies.getLeptop());
            preparedStatement.setInt(4,technologies.getSpecs().getId());
            preparedStatement.setInt(5,technologies.getId());
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
    public void delete(Technologies technologies) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("delete from technologies where id_technologies= ? ;");
            preparedStatement.setInt(1,technologies.getId());
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
    public void create(Technologies technologies) throws SQLException {
        try  {
            connection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
            preparedStatement = connection.prepareStatement("insert into technologies values (default,?,?,?,?) ;");
            preparedStatement.setString(1,technologies.getName());
            preparedStatement.setInt(2,technologies.getPc());
            preparedStatement.setInt(3,technologies.getLeptop());
            preparedStatement.setInt(4,technologies.getSpecs().getId());
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
