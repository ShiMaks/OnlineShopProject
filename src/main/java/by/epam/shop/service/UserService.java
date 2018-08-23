package by.epam.shop.service;

import by.epam.shop.domain.Product;
import by.epam.shop.domain.User;
import by.epam.shop.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    void createUser(User user) throws ServiceException;

    void updateUserInfo(User user) throws  ServiceException;

    void deleteUser(int id) throws ServiceException;

    User getUser(int id) throws ServiceException;

    User getUserByLoginPassword(String login, String password);

    List<User> getUsers() throws ServiceException;
}
