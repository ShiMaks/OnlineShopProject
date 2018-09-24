package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.UserDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.pool.ConnectionPool;
import by.epam.shop.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for working with the user table from database
 *
 * @author Shilvian Maksim
 */
public class UserDaoDBImpl extends AbstractDao implements UserDao {

    private static final Logger LOGGER = LogManager.getLogger(UserDaoDBImpl.class);

    /**
     * Fields to identify SQL error type
     */
    private static final int ER_DUP_ENTRY_CODE = 1062;
    private static final String ENDS_WITH_LOGIN = "key 'login'";
    private static final String ENDS_WITH_EMAIL = "key 'email'";

    /**
     * SQL-statements
     */
    private static final String CREATE_USER = "INSERT INTO user (name, surname, email, phone, login, password, isAdmin) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_USER_BY_ID = "SELECT id, name, surname, email, phone, login FROM user" +
            " WHERE id = ?";
    private static final String UPDATE_USER = "UPDATE user SET name = ?, surname = ?, phone = ?, email = ?" +
            " WHERE id = ?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id  = ?";
    private static final String READ_ALL_USERS = "SELECT id, name, surname, email, phone, login FROM user" +
            " WHERE isAdmin = 0";
    private static final String READ_USER_BY_LOGIN_PASS = "SELECT id, login, password, isAdmin FROM user " +
            "WHERE login = ? AND password = ?";

    /**
     * Error causes fields
     */
    private static final String ERROR_IN_CREATE_USER = "Error while adding user to database";
    private static final String ERROR_IN_READ_USER = "Error while getting user from database";
    private static final String ERROR_IN_UPDATE_USER = "Error while trying to update user in database";
    private static final String ERROR_IN_DELETE_USER = "Error while deleting user from database";
    private static final String ERROR_IN_LOGIN_METHOD = "Error while authorization";
    private static final String ERROR_IN_UPDATE_PASS = "Error while updating user password";
    private static final String ERROR_IN_UPDATE_BALANCE = "Error while updating user balance";
    private static final String ERROR_IN_READ_ALL_USERS = "Error while getting user list from database";
    private static final String ERROR_IN_READ_PASS = "Error while getting user's password from database";

    public UserDaoDBImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public int createUser(User user) throws DaoException {
        int code = 0;
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setBoolean(7, false);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == ER_DUP_ENTRY_CODE) {
                code = identifyDuplicateField(e.getMessage());
            } else {
                throw new DaoException(ERROR_IN_CREATE_USER, e);
            }
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return code;
    }

    @Override
    public void create(User entity) throws DaoException {

    }

    @Override
    public User read(int id) throws DaoException {
        User user = null;
        ResultSet result = null;
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_USER_BY_ID)){
            statement.setInt(1, id);
            result = statement.executeQuery();
            if(result.next()) {
                user = new User();
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setSurname(result.getString("surname"));
                user.setLogin(result.getString("login"));
                user.setEmail(result.getString("email"));
                user.setPhone(result.getString("phone"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return user;
    }

    @Override
    public void update(User user) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USER)){
            // filling satetement
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }



    @Override
    public User getUserByLoginPassword(String login, String password) throws DaoException {
        User user = null;
        ResultSet result = null;
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_USER_BY_LOGIN_PASS)){
            statement.setString(1, login);
            statement.setString(2, password);
            result = statement.executeQuery();
            if(result.next()) {
                user = new User();
                user.setId(result.getInt("id"));
                user.setAdmin(result.getBoolean("isAdmin"));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return user;
    }

    @Override
    public List<User> readAll() throws DaoException {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = dataBaseConnection.getConnection();
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(READ_ALL_USERS);
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setLogin(resultSet.getString("login"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return users;
    }

    private int identifyDuplicateField(String excMessage) {
        if (excMessage.endsWith(ENDS_WITH_LOGIN)) {
            return 1;
        } else if (excMessage.endsWith(ENDS_WITH_EMAIL)) {
            return 2;
        } else {
            return 0;
        }
    }
}
