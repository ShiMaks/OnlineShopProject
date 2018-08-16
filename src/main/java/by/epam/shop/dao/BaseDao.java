package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Entity;

public interface BaseDao<T extends Entity> {

    void create(T entity) throws DaoException;
    T read(int id) throws DaoException;
    void update(T entity) throws DaoException;
    void delete(int id) throws DaoException;

}
