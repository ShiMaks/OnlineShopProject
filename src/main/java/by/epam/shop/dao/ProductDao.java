package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product> {

    List<Product> readAll() throws DaoException;
    List<Product> getProductsByCategory(int id) throws DaoException;
}
