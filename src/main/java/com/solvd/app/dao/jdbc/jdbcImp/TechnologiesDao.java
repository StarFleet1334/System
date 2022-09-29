package com.solvd.app.dao.jdbc.jdbcImp;

import com.solvd.app.dao.jdbc.ITechnologiesDao;
import com.solvd.app.models.Technologies;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TechnologiesDao extends AbstractMysqlDao implements ITechnologiesDao {
    private static final Logger LOGGER = LogManager.getLogger(UsersDao.class);
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private SpecsDao specsDao;

    public TechnologiesDao() throws IOException {
        specsDao = new SpecsDao();
    }

    @Override
    public List<Technologies> getAll() throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from technologies ;");
            resultSet = preparedStatement.executeQuery();
            List<Technologies> list = new ArrayList<>();
            specsDao.setConnection(connection);
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
                technologies.setSpecs(specsDao.get(specs_id));
                list.add(technologies);
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
    public Technologies get(int id) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("Select * from technologies where id_technologies= ? ;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            specsDao.setConnection(connection);
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
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        return null;
    }

    @Override
    public void update(Technologies technologies) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("update technologies set name = ?, pc = ?, leptop = ?,specs = ? where id_technologies = ?;");
            preparedStatement.setString(1,technologies.getName());
            preparedStatement.setInt(2,technologies.getPc());
            preparedStatement.setInt(3,technologies.getLeptop());
            preparedStatement.setInt(4,technologies.getSpecs().getId());
            preparedStatement.setInt(5,technologies.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void delete(Technologies technologies) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("delete from technologies where id_technologies= ? ;");
            preparedStatement.setInt(1,technologies.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public void create(Technologies technologies) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement("insert into technologies values (default,?,?,?,?) ;");
            preparedStatement.setString(1,technologies.getName());
            preparedStatement.setInt(2,technologies.getPc());
            preparedStatement.setInt(3,technologies.getLeptop());
            preparedStatement.setInt(4,technologies.getSpecs().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.info("Error occurred,check maybe user/password is incorrect.");
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }
}
