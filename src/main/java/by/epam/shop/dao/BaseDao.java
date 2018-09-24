package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Entity;

import java.sql.SQLException;

/**
 *Interface that provides CRUD methods to access data
 * from database.
 *
 * @author Maksim Shilvian
 * @param <T> extends Entity
 */
public interface BaseDao<T extends Entity> {

    /**
     * Adds entity to database
     *
     * @param entity
     * @throws DaoException
     */
    void create(T entity) throws DaoException;

    /**
     * Gets object from database
     *
     * @param id
     * @return T extends Entity object
     * @throws DaoException
     */
    T read(int id) throws DaoException, InterruptedException;

    /**
     * Updates information about entity in database
     *
     * @param entity
     * @throws DaoException
     */
    void update(T entity) throws DaoException;

    /**
     * Deletes entity from database
     *
     * @param id
     * @throws DaoException
     */
    void delete(int id) throws DaoException;

}
