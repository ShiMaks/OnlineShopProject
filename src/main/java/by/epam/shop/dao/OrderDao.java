package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Order;

import java.util.List;

public interface OrderDao extends BaseDao<Order> {

    List<Order> readAll() throws DaoException;

}
