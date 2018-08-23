package by.epam.shop.service;

import by.epam.shop.domain.Product;
import by.epam.shop.service.exception.ServiceException;

import java.util.List;

/**
 * Interface provides methods
 * for working with Product entity.
 *
 * @author Maksim Shilvian
 */
public interface ProductService {

    /**
     * Adds category to shop
     *
     * @param product entity
     * @throws ServiceException
     */
    void addProductToShop(Product product) throws ServiceException;

    /**
     *
     * @param product entity
     * @throws ServiceException
     */
    void updateProductInfo(Product product) throws  ServiceException;

    /**
     * Deletes product from shop
     *
     * @param id of product
     * @throws ServiceException
     */
    void deleteProduct(int id) throws ServiceException;

    /**
     * Gets product
     *
     * @param id of product
     * @return Product entity
     * @throws ServiceException
     */
    Product getProduct(int id) throws ServiceException;

    /**
     * Gets full list of products
     *
     * @return List of products
     * @throws ServiceException
     */
    List<Product> getProducts() throws ServiceException;

    /**
     * Gets full list of products for category
     *
     * @param idCategory
     * @return List of product
     * @throws ServiceException
     */
    List<Product> getProductsByCategory(int idCategory) throws ServiceException;
}
