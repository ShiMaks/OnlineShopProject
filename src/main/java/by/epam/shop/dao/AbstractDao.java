package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.pool.ConnectionPool;
import by.epam.shop.domain.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<E extends Entity> {

    private static final Logger LOGGER = LogManager.getLogger(AbstractDao.class);

    protected ConnectionPool dataBaseConnection;
    protected abstract E mapRow(ResultSet resultSet) throws DaoException;

    public AbstractDao(ConnectionPool connectionPool){
        this.dataBaseConnection = connectionPool;
    }

    protected E read(int id, String sql) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapRow(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("read: {}, id={}", sql, id);
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return null;
    }

    protected void delete(int id, String sql) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("delete: {}, id={}", sql, id);
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    protected List<E> readAll(String sql) throws DaoException {
        List<E> results = new ArrayList<>();
        Connection connection = dataBaseConnection.getConnection();
        try (Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                results.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("read list: {}", sql);
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return results;
    }

    protected List<E> readAllByCondition(int condition, String sql) throws DaoException {
        List<E> results = new ArrayList<>();
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, condition);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                results.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("read list by condition: {}, condition={}", sql, condition);
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return results;
    }
}
