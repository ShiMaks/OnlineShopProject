package by.epam.shop.service.impl;

import by.epam.shop.dao.UserDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.factory.DaoFactory;
import by.epam.shop.domain.Product;
import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

import static by.epam.shop.service.util.ServiceInputParamNullValidator.validateInputParamNotNull;

public class UserServiceImpl implements UserService {

    private static final String DUPLICATE_LOGIN_MESSAGE = "This username is taken. Try another";
    private static final String DUPLICATE_EMAIL_MESSAGE = "This email is already in use. Try another";

    private static final String SUCCESS = "success";

    private UserDao userDao = DaoFactory.getUserDAO();

    @Override
    public void createUser(User user) throws ServiceException{
        validateInputParamNotNull(user);
        userDao.create(user);
    }

    @Override
    public void updateUserInfo(User user) throws ServiceException {
        validateInputParamNotNull(user);
        userDao.update(user);
    }

    @Override
    public void deleteUser(int id) throws ServiceException {
        userDao.delete(id);
    }

    @Override
    public User getUser(int id) throws ServiceException {
        return userDao.read(id);
    }

    @Override
    public User getUserByLoginPassword(String login, String password) throws ServiceException {
        return userDao.getUserByLoginPassword(login, password);
    }

    @Override
    public List<User> getUsers() throws ServiceException {
        return userDao.readAll();
    }
}
