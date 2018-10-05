package by.epam.shop.service.impl;

import by.epam.shop.dao.UserDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.factory.DaoFactory;
import by.epam.shop.domain.Product;
import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.util.PasswordEncryptor;

import java.sql.SQLException;
import java.util.List;

import static by.epam.shop.service.util.ServiceInputParamNullValidator.validateInputParamNotNull;

public class UserServiceImpl implements UserService {

    private static final int DUPLICATE_LOGIN_CODE = 1;
    private static final int DUPLICATE_EMAIL_CODE = 2;

    private static final String DUPLICATE_LOGIN_MESSAGE = "This username is taken. Try another";
    private static final String DUPLICATE_EMAIL_MESSAGE = "This email is already in use. Try another";

    private static final String SUCCESS = "success";

    private UserDao userDao = DaoFactory.getUserDAO();

    @Override
    public String createUser(User user) throws ServiceException{
        validateInputParamNotNull(user);
        user.setPassword(PasswordEncryptor.md5Apache(user.getPassword()));
        int code = userDao.createUser(user);
        String message = SUCCESS;
        if (code == DUPLICATE_LOGIN_CODE) {
            message = DUPLICATE_LOGIN_MESSAGE;
        } else if (code == DUPLICATE_EMAIL_CODE) {
            message = DUPLICATE_EMAIL_MESSAGE;
        }
        return message;
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
        validateInputParamNotNull(login, password);
        return userDao.getUserByLoginPassword(login, PasswordEncryptor.md5Apache(password));
    }

    @Override
    public List<User> getUsers() throws ServiceException {
        return userDao.readAll();
    }

    @Override
    public String getUserPassword(int idUser) throws ServiceException {
        return userDao.readUserPassword(idUser);
    }

    @Override
    public void changeUserPassword(User user) throws ServiceException {
        validateInputParamNotNull(user);
        user.setPassword(PasswordEncryptor.md5Apache(user.getPassword()));
        userDao.updateUserPassword(user);
    }

}
