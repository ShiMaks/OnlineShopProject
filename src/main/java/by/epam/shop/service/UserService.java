package by.epam.shop.service;

import by.epam.shop.domain.User;
import by.epam.shop.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface provides methods
 * for working with User entity.
 *
 * @author Maksim Shilvian
 */
public interface UserService {

    /**
     * Adds user in base
     *
     * @param user
     * @throws ServiceException
     */
    void createUser(User user) throws ServiceException;

    /**
     * Update info about certain user
     *
     * @param user
     * @throws ServiceException
     */
    void updateUserInfo(User user) throws  ServiceException;

    /**
     * Deletes user
     *
     * @param id
     * @throws ServiceException
     */
    void deleteUser(int id) throws ServiceException;

    /**
     * Gets user
     *
     * @param id of user
     * @return User entity
     * @throws ServiceException
     */
    User getUser(int id) throws ServiceException;

    /**
     * Gets user by login and password
     *
     * @param login of user
     * @param password of user
     * @return User entity
     */
    User getUserByLoginPassword(String login, String password) throws ServiceException;

    /**
     * Gets full list of users
     *
     * @return List of users
     * @throws ServiceException
     */
    List<User> getUsers() throws ServiceException;
}
