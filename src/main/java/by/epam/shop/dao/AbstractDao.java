package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.pool.ConnectionPool;
import by.epam.shop.domain.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<E extends Entity> {

    protected ConnectionPool dataBaseConnection;
    protected abstract E mapRow(ResultSet resultSet) throws DaoException;

    public AbstractDao(ConnectionPool connectionPool){
        this.dataBaseConnection = connectionPool;
    }

    protected E read(int id, String sql) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
            closeResultSet(resultSet);
        }
        return null;
    }

    protected void delete(int id, String sql) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    protected List<E> readAll(String sql) throws DaoException {
        List<E> results = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = dataBaseConnection.getConnection();
        try (Statement statement = connection.createStatement();) {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                results.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
            closeResultSet(resultSet);
        }
        return results;
    }

    protected List<E> readAllByCondition(int condition, String sql) throws DaoException {
        List<E> results = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, condition);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                results.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
            closeResultSet(resultSet);
        }
        return results;
    }

    protected void closeResultSet(ResultSet resultSet){
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    public MySqlConnection connect;
//
//    {
//        connect = new MySqlConnection();
//    }


}
