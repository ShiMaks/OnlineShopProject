package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    User getUserByLoginPassword(String login, String password) throws DaoException;

    List<User> readAll() throws DaoException;

}
