package by.epam.shop.service;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Category;
import by.epam.shop.service.exception.ServiceException;

import java.util.List;

public interface CategoryService {

    void addCategoryToShop(Category category) throws ServiceException;

    void updateCategoryInfo(Category category) throws  ServiceException;

    void deleteCategory(int id) throws ServiceException;

    Category getCategory(int id) throws ServiceException;

    List<Category> getCategories() throws ServiceException, DaoException;
}
