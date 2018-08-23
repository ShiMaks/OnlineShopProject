package by.epam.shop.service;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Category;
import by.epam.shop.service.exception.ServiceException;

import java.util.List;

/**
 * Interface provides methods
 * for working with Category entity.
 *
 * @author Maksim Shilvian
 */
public interface CategoryService {

    /**
     * Adds category to shop
     *
     * @param category entity
     * @throws ServiceException
     */
    void addCategoryToShop(Category category) throws ServiceException;

    /**
     * Update info about certain category
     *
     * @param category entity
     * @throws ServiceException
     */
    void updateCategoryInfo(Category category) throws  ServiceException;

    /**
     * Deletes category from shop
     *
     * @param id of category
     * @throws ServiceException
     */
    void deleteCategory(int id) throws ServiceException;

    /**
     * Gets category
     *
     * @param id of category
     * @return Category entity
     * @throws ServiceException
     */
    Category getCategory(int id) throws ServiceException;

    /**
     * Gets full list of category
     *
     * @return List of categories
     * @throws ServiceException
     */
    List<Category> getCategories() throws ServiceException;
}
