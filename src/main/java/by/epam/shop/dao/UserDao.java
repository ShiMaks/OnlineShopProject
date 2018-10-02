package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    /**
     * Gets user by login and password from database
     *
     * @param login
     * @param password
     * @return User
     * @throws DaoException
     */
    User getUserByLoginPassword(String login, String password) throws DaoException;

    /**
     * Gets all existing user from database
     *
     * @return List of users
     * @throws DaoException
     */
    List<User> readAll() throws DaoException;

    /**
     * Adds user to database
     *
     * @param user
     * @return int code
     * @throws DaoException
     */
    int createUser(User user) throws DaoException;

    /**
     * Gets user's password from database
     *
     * @param idUser
     * @return String password
     * @throws DaoException
     */
    String readUserPassword(int idUser) throws DaoException;

    /**
     * Updates user's password
     *
     * @param user
     * @throws DaoException
     */
    void updateUserPassword(User user) throws DaoException;

}
