package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.User;

public interface UserDao extends BaseDao<User> {

    User getUserByLoginPassword(String login, String password) throws DaoException;

}
