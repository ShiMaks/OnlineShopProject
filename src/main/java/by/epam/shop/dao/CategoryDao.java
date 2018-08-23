package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Category;

import java.util.List;

/**
 * Interface that provides additional methods
 * to access category data from database.
 *
 * @author Shilvian Maksim
 */
public interface CategoryDao extends BaseDao<Category> {

    /**
     * Gets all existing categories from database
     *
     * @return List of categories
     * @throws DaoException
     */
    List<Category> readAll() throws DaoException;
}
