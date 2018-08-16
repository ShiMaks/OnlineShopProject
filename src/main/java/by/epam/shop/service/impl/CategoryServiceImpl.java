package by.epam.shop.service.impl;

import by.epam.shop.dao.CategoryDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.factory.DaoFactory;
import by.epam.shop.domain.Category;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.exception.ServiceException;

import java.util.List;

import static by.epam.shop.service.util.ServiceInputParamNullValidator.validateInputParamNotNull;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = DaoFactory.getCategoryDAO();

    @Override
    public void addCategoryToShop(Category category) throws ServiceException {
        validateInputParamNotNull(category);
        try {
            categoryDao.create(category);
        } catch (DaoException e) {
            throw  new ServiceException(e);
        }

    }

    @Override
    public void updateCategoryInfo(Category category) throws ServiceException {
        validateInputParamNotNull(category);
        try {
            categoryDao.update(category);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCategory(int id) throws ServiceException {
        try {
            categoryDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Category getCategory(int id) throws ServiceException {
        try {
            return categoryDao.read(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Category> getCategories() throws ServiceException {
        try {
            return categoryDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
