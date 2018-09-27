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

import static by.epam.shop.dao.util.TablesColumnNamesDeclaration.*;

/**
 * Class for working with the user table from database
 *
 * @author Shilvian Maksim
 */
public class UserDaoDBImpl extends AbstractDao<User> implements UserDao {

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
    private static final String UPDATE_USER = "UPDATE user SET name = ?, surname = ?, phone = ?" +
            " WHERE id = ?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id  = ?";
    private static final String READ_ALL_USERS = "SELECT id, name, surname, email, phone, login FROM user" +
            " WHERE isAdmin = 0";
    private static final String READ_USER_BY_LOGIN_PASS = "SELECT id, login, password, isAdmin FROM user " +
            "WHERE login = ? AND password = ?";
    private static final String READ_USER_PASS = "SELECT password FROM user WHERE id = ?";
    private static final String UPDATE_USER_PASS = "UPDATE user SET password = ? WHERE id = ?";

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
    protected User mapRow(ResultSet resultSet) throws DaoException {
        User user = new User();
        try{
            user.setId(resultSet.getInt(USER_COLUMN_ID));
            user.setName(resultSet.getString(USER_COLUMN_NAME));
            user.setSurname(resultSet.getString(USER_COLUMN_SURNAME));
            user.setLogin(resultSet.getString(USER_COLUMN_LOGIN));
            user.setEmail(resultSet.getString(USER_COLUMN_EMAIL));
            user.setPhone(resultSet.getString(USER_COLUMN_PHONE));
        } catch(SQLException e){
            throw new DaoException(e);
        }
        return user;
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
    public String readUserPassword(int idUser) throws DaoException {
        String pass = null;
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_PASS)) {
            preparedStatement.setInt(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pass = resultSet.getString(USER_COLUMN_PASSWORD);
            }
        } catch (SQLException e) {
            throw new DaoException(ERROR_IN_READ_PASS, e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return pass;
    }

    @Override
    public void updateUserPassword(User user) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_PASS)) {
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(ERROR_IN_UPDATE_PASS, e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public void create(User entity) throws DaoException {

    }

    @Override
    public User read(int id) throws DaoException {
        return read(id, READ_USER_BY_ID);
    }

    @Override
    public void update(User user) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USER)){
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPhone());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        delete(id, DELETE_USER_BY_ID);
    }

    @Override
    public User getUserByLoginPassword(String login, String password) throws DaoException {
        User user = null;
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_USER_BY_LOGIN_PASS)){
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                user = new User();
                user.setId(result.getInt(USER_COLUMN_ID));
                user.setAdmin(result.getBoolean(USER_COLUMN_IS_ADMIN));
                user.setLogin(result.getString(USER_COLUMN_LOGIN));
                user.setPassword(result.getString(USER_COLUMN_PASSWORD));
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
        return readAll(READ_ALL_USERS);
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
