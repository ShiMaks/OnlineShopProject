package by.epam.shop.service.impl;

import by.epam.shop.dao.ProductDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.factory.DaoFactory;
import by.epam.shop.domain.Product;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.exception.ServiceException;

import java.util.List;

import static by.epam.shop.service.util.ServiceInputParamNullValidator.validateInputParamNotNull;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = DaoFactory.getProductDAO();

    @Override
    public void addProductToShop(Product product) throws ServiceException {
        validateInputParamNotNull(product);
        try {
            productDao.create(product);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateProductInfo(Product product) throws ServiceException {
        validateInputParamNotNull(product);
        try {
            productDao.update(product);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteProduct(int id) throws ServiceException {
        try {
            productDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Product getProduct(int id) throws ServiceException {
        try {
            return productDao.read(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> getProducts() throws ServiceException {
        try {
            return productDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> getProductsByCategory(int idCategory) throws ServiceException {
        try {
            return productDao.getProductsByCategory(idCategory);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


}
