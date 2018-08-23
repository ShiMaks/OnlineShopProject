package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Product;

import java.util.List;

/**
 * Interface that provides additional methods
 * to access product data from database.
 *
 * @author Shilvian Maksim
 */
public interface ProductDao extends BaseDao<Product> {

    /**
     * Gets all existing products from database
     *
     * @return List of products
     * @throws DaoException
     */
    List<Product> readAll() throws DaoException;

    /**
     * Gets all products from database for category
     *
     * @param id of category
     * @return List of products
     * @throws DaoException
     */
    List<Product> getProductsByCategory(int id) throws DaoException;
}
