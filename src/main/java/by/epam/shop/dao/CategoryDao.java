package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Category;

import java.util.List;

public interface CategoryDao extends BaseDao<Category> {

    List<Category> readAll() throws DaoException;
}
